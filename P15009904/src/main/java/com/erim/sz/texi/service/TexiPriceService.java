package com.erim.sz.texi.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TexiCarBean;
import com.erim.sz.common.bean.TexiCarPriceBean;
import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.common.bean.TexiDriveBean;
import com.erim.sz.common.bean.TexiDrivePriceBean;
import com.erim.sz.common.bean.TexiSendBean;
import com.erim.sz.common.bean.TexiSendPriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.texi.dao.TexiCarDao;
import com.erim.sz.texi.dao.TexiDetailDao;
import com.erim.sz.texi.dao.TexiDriveDao;
import com.erim.sz.texi.dao.TexiSendDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;

/**
 * @描述: 租车量价信息实体操作业务层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月24日 上午11:29:51
 */
@Service("texiPriceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TexiPriceService {

	@Autowired
	private TexiDetailDao texiDetailDao;
	@Autowired
	private TexiSendDao texiSendDao;
	@Autowired
	private TexiCarDao texiCarDao;
	@Autowired
	private TexiDriveDao texidriveDao;
	@Autowired
	private TexiSendPriceService texiSendPriceService;
	@Autowired
	private TexiCarPriceService texiCarPriceService;
	@Autowired
	private TexiDrivePriceService texiDrivePriceService;
	
	/**
	 * @描述: 初始化同业资源租车量价列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月24日 下午1:46:24
	 * @param map
	 * @param bean
	 */
	public void showSametownPricePage(ModelMap map, TexiDetailBean bean) {
		
		// 固定接送
		@SuppressWarnings("unchecked")
		List<TexiDetailBean> sendList = (List<TexiDetailBean>) SecurityUtils.getSubject().getSession().getAttribute("sendList");
		map.addAttribute("sendList", sendList);
		// 包车
		Integer carID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("carID");
		map.addAttribute("carID", carID);
		// 自驾
		Integer driveID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("driveID");
		map.addAttribute("driveID", driveID);
		// 默认选中第一条固定接送类型
		Integer sendID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("sendID");
		map.addAttribute("sendID", sendID);
		// 包车默认半天
		String bcType = (String) SecurityUtils.getSubject().getSession().getAttribute("carType");
		map.addAttribute("bcType", bcType);
		// 自驾默认半天
		String zjType = (String) SecurityUtils.getSubject().getSession().getAttribute("driveType");
		map.addAttribute("zjType", zjType);
		if (sendID != null) {
			// 默认租车使用为固定接送
			SecurityUtils.getSubject().getSession().setAttribute("applyType", ErimConstants.TEXI_APPLY_SEND);
			map.addAttribute("applyType", ErimConstants.TEXI_APPLY_SEND);
		} else {
			if (carID != null) {
				// 默认租车使用为包车
				SecurityUtils.getSubject().getSession().setAttribute("applyType", ErimConstants.TEXI_APPLY_CAR);
				map.addAttribute("applyType", ErimConstants.TEXI_APPLY_CAR);
			} else {
				// 默认租车使用为自驾
				SecurityUtils.getSubject().getSession().setAttribute("applyType", ErimConstants.TEXI_APPLY_DRIVE);
				map.addAttribute("applyType", ErimConstants.TEXI_APPLY_DRIVE);
			}
		}
		
		// 当前年月
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 查询日历
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月24日 下午1:54:25
	 * @param map
	 * @param bean
	 */
	public void selectPriceList(ModelMap map, TexiDetailBean bean) {
		
		// 租车使用类型
		String applyType = (String) SecurityUtils.getSubject().getSession().getAttribute("applyType");
		
		if (ErimConstants.TEXI_APPLY_SEND.equals(applyType)) {
			// 查询固定线路数据列表
			texiSendPriceService.selectSendPriceList(map, new TexiSendPriceBean());
		} else if (ErimConstants.TEXI_APPLY_CAR.equals(applyType)) {
			// 查询包车数据列表
			texiCarPriceService.selectCarPirceList(map, new TexiCarPriceBean());
		} else if (ErimConstants.TEXI_APPLY_DRIVE.equals(applyType)) {
			// 查询自驾数据列表
			texiDrivePriceService.selectDrivePirceList(map, new TexiDrivePriceBean());
		}
	}
	
	/**
	 * @描述: 获取该出租车是否有固定接送、包车、自驾信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月22日 下午8:43:03
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer getTexiTypeNum(ModelMap map, TexiDetailBean bean) {
		
		// 查询该出租车是否有使用信息
		Integer isApply = CommonUtil.TEXINOTPRICE;
		/**
		 * 查询是否有固定接送信息
		 */
		// 产品ID
		Integer id = bean.getId();
		
		
		SecurityUtils.getSubject().getSession().setAttribute("tdlName", this.texiDetailDao.getTexiDetialById(id).getTdlName());
		
		TexiSendBean sendBean = new TexiSendBean();
		sendBean.setTdlId(id);
		// 根据产品ID查询固定接送信息列表
		List<TexiSendBean> sendList = texiSendDao.selectTexiSendList(sendBean, map);
		if (sendList.size() > 0) {
			// 如果有固定接送信息，则变量赋值 1
			isApply = 1;
			List<TexiDetailBean> detailList = new ArrayList<TexiDetailBean>();
			for (int i = 0; i < sendList.size(); i++) {
				TexiDetailBean detailBean = new TexiDetailBean();
				TexiSendBean dic = sendList.get(i);
				// 固定接送ID
				detailBean.setTdlTypeCode(dic.getId());
				// 固定接送类型
				String type = dic.getGdlType();
				if (ErimConstants.TEXI_SEND_GUDING.equals(type)) {
					detailBean.setTdlTypeName("固定线路：" + dic.getGdlStartcity() + " 至 " + dic.getGdlEndcity());
				} else if (ErimConstants.TEXI_SEND_JIEJI.equals(type)) {
					detailBean.setTdlTypeName("接机：" + dic.getGdlStart() + " 至 " + dic.getGdlEnd());
				} else if (ErimConstants.TEXI_SEND_JIEZHAN.equals(type)) {
					detailBean.setTdlTypeName("接站：" + dic.getGdlStation() + " 至 " + dic.getGdlStationup());
				} else if (ErimConstants.TEXI_SEND_SONGJI.equals(type)) {
					detailBean.setTdlTypeName("送机：" + dic.getGdlMachine() + " 至 " + dic.getGdlMachineback());
				} else if (ErimConstants.TEXI_SEND_SONGZHAN.equals(type)) {
					detailBean.setTdlTypeName("送站：" + dic.getGdlStationback() + " 至 " + dic.getGdlStationnup());
				}
				detailList.add(detailBean);
			}
			// 固定接送类型
			SecurityUtils.getSubject().getSession().setAttribute("sendList", detailList);
			// 默认选中第一条
			SecurityUtils.getSubject().getSession().setAttribute("sendID", sendList.get(0).getId());
		}
		/**
		 * 查询是否有包车信息
		 */
		// 根据产品ID查询是否有包车信息
		TexiCarBean carBean = texiCarDao.getTexiCarById(id);
		if (carBean != null) {
			isApply = 1;
			SecurityUtils.getSubject().getSession().setAttribute("carID", carBean.getId());
			SecurityUtils.getSubject().getSession().setAttribute("carType", "02");
		}
		/**
		 * 查询是否有自驾信息
		 */
		// 根据产品ID查询是否有自驾信息
		TexiDriveBean driveBean = texidriveDao.getTextDriveById(id);
		if (driveBean != null) {
			isApply = 1;
			SecurityUtils.getSubject().getSession().setAttribute("driveID", driveBean.getId());
			SecurityUtils.getSubject().getSession().setAttribute("driveType", "02");
		}
		return isApply;
	}
	
	/**
	 * @方法名: showListForward
	 * @描述: 时间向前选择刷新列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午6:44:07 
	 * @param map
	 * @param bean
	 */
	public void showListForward(ModelMap map, TexiDetailBean bean) {
		
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 转换到下个月
		int yearInt = Integer.valueOf(priceYear);
		int monthInt = Integer.valueOf(priceMonth);
		if (monthInt == 12) {
			yearInt++;
			monthInt = 1;
		} else {
			monthInt++;
		}
		priceYear = Integer.toString(yearInt);
		priceMonth = Integer.toString(monthInt);
		// 存入Session
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", priceYear);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", priceMonth);
		
		// 当前年月，放进map
		map.addAttribute("priceYeMon", priceYear + " 年 " + priceMonth + " 月");
		
		dateRefresh(map);
	}
	
	/**
	 * @方法名: showListBackwards
	 * @描述: 时间向后选择刷新页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午6:48:18 
	 * @param map
	 * @param bean
	 */
	public void showListBackwards(ModelMap map, TexiDetailBean bean) {
		// 当前年
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		// 当前月
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		int yearInt = Integer.valueOf(priceYear);
		int monthInt = Integer.valueOf(priceMonth);
		
		if (monthInt == 1) {
			yearInt--;
			monthInt = 12;
		} else {
			monthInt--;
		}
		
		priceYear = Integer.toString(yearInt);
		priceMonth = Integer.toString(monthInt);
		// 存入Session
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", priceYear);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", priceMonth);
		
		// 当前年月，放进map
		map.addAttribute("priceYeMon", priceYear + " 年 " + priceMonth + " 月");
		
		dateRefresh(map);
	}
	
	/**
	 * @描述: 更改时间后的一些参数刷新
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月24日 下午6:29:16
	 * @param map
	 */
	public void dateRefresh(ModelMap map) {
		// 固定接送
		@SuppressWarnings("unchecked")
		List<TexiDetailBean> sendList = (List<TexiDetailBean>) SecurityUtils.getSubject().getSession().getAttribute("sendList");
		map.addAttribute("sendList", sendList);
		// 包车
		Integer carID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("carID");
		map.addAttribute("carID", carID);
		// 自驾
		Integer driveID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("driveID");
		map.addAttribute("driveID", driveID);
		// 固定接送ID
		Integer sendID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("sendID");
		map.addAttribute("sendID", sendID);
		// 租车使用类型
		String applyType = (String) SecurityUtils.getSubject().getSession().getAttribute("applyType");
		map.addAttribute("applyType", applyType);
		// 包车类型
		String bcType = (String) SecurityUtils.getSubject().getSession().getAttribute("carType");
		map.addAttribute("bcType", bcType);
		// 自驾类型
		String zjType = (String) SecurityUtils.getSubject().getSession().getAttribute("driveType");
		map.addAttribute("zjType", zjType);
	}
	
	/**
	 * @描述: 更改租车使用类型
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月24日 下午7:49:56
	 * @param map
	 * @param applyType 租车使用类型
	 */
	public void texiApplyType(ModelMap map, TexiDetailBean bean) {
		
		// 更改使用类型
		String applyType = bean.getApplyType();
		SecurityUtils.getSubject().getSession().setAttribute("applyType", applyType);
		map.addAttribute("applyType", applyType);
		
		// 固定接送
		@SuppressWarnings("unchecked")
		List<TexiDetailBean> sendList = (List<TexiDetailBean>) SecurityUtils.getSubject().getSession().getAttribute("sendList");
		map.addAttribute("sendList", sendList);
		// 包车
		Integer carID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("carID");
		map.addAttribute("carID", carID);
		// 自驾
		Integer driveID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("driveID");
		map.addAttribute("driveID", driveID);
		// 固定接送ID
		Integer sendID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("sendID");
		map.addAttribute("sendID", sendID);

		// 包车类型
		String bcType = (String) SecurityUtils.getSubject().getSession().getAttribute("carType");
		map.addAttribute("bcType", bcType);
		// 自驾类型
		String zjType = (String) SecurityUtils.getSubject().getSession().getAttribute("driveType");
		map.addAttribute("zjType", zjType);
		
		// 当前年月
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		map.addAttribute("priceYeMon", priceYear + " 年 " + priceMonth + " 月");
	}
	
	/**
	 * @描述: 更改显示的固定接送ID
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月24日 下午8:01:33
	 * @param map
	 * @param bean
	 */
	public void texiSend(ModelMap map, TexiDetailBean bean) {
		// 使用类型
		String applyType = (String) SecurityUtils.getSubject().getSession().getAttribute("applyType");
		map.addAttribute("applyType", applyType);
		
		// 固定接送
		@SuppressWarnings("unchecked")
		List<TexiDetailBean> sendList = (List<TexiDetailBean>) SecurityUtils.getSubject().getSession().getAttribute("sendList");
		map.addAttribute("sendList", sendList);
		// 包车
		Integer carID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("carID");
		map.addAttribute("carID", carID);
		// 自驾
		Integer driveID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("driveID");
		map.addAttribute("driveID", driveID);
		
		// 固定接送ID
		Integer sendID = bean.getSendId();
		SecurityUtils.getSubject().getSession().setAttribute("sendID", sendID);
		map.addAttribute("sendID", sendID);

		// 包车类型
		String bcType = (String) SecurityUtils.getSubject().getSession().getAttribute("carType");
		map.addAttribute("bcType", bcType);
		
		// 自驾类型
		String zjType = (String) SecurityUtils.getSubject().getSession().getAttribute("driveType");
		map.addAttribute("zjType", zjType);
		
		// 当前年月
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		map.addAttribute("priceYeMon", priceYear + " 年 " + priceMonth + " 月");
	}
	
	/**
	 * @描述: 更改包车类型
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月24日 下午8:07:04
	 * @param map
	 * @param bean
	 */
	public void texiCar(ModelMap map, TexiDetailBean bean) {
		// 使用类型
		String applyType = (String) SecurityUtils.getSubject().getSession().getAttribute("applyType");
		map.addAttribute("applyType", applyType);
		
		// 固定接送
		@SuppressWarnings("unchecked")
		List<TexiDetailBean> sendList = (List<TexiDetailBean>) SecurityUtils.getSubject().getSession().getAttribute("sendList");
		map.addAttribute("sendList", sendList);
		// 包车
		Integer carID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("carID");
		map.addAttribute("carID", carID);
		// 自驾
		Integer driveID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("driveID");
		map.addAttribute("driveID", driveID);
		
		// 固定接送ID
		Integer sendID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("sendID");
		map.addAttribute("sendID", sendID);

		// 包车类型
		String bcType = bean.getBcType();
		SecurityUtils.getSubject().getSession().setAttribute("carType", bcType);
		map.addAttribute("bcType", bcType);
		// 自驾类型
		String zjType = (String) SecurityUtils.getSubject().getSession().getAttribute("driveType");
		map.addAttribute("zjType", zjType);
		
		// 当前年月
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		map.addAttribute("priceYeMon", priceYear + " 年 " + priceMonth + " 月");
	}
	
	/**
	 * @描述: 更改自驾类型
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月24日 下午8:07:18
	 * @param map
	 * @param bean
	 */
	public void texiDrive(ModelMap map, TexiDetailBean bean) {
		// 使用类型
		String applyType = (String) SecurityUtils.getSubject().getSession().getAttribute("applyType");
		map.addAttribute("applyType", applyType);
		
		// 固定接送
		@SuppressWarnings("unchecked")
		List<TexiDetailBean> sendList = (List<TexiDetailBean>) SecurityUtils.getSubject().getSession().getAttribute("sendList");
		map.addAttribute("sendList", sendList);
		// 包车
		Integer carID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("carID");
		map.addAttribute("carID", carID);
		// 自驾
		Integer driveID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("driveID");
		map.addAttribute("driveID", driveID);
		
		// 固定接送ID
		Integer sendID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("sendID");
		map.addAttribute("sendID", sendID);

		// 包车类型
		String bcType = (String) SecurityUtils.getSubject().getSession().getAttribute("carType");
		map.addAttribute("bcType", bcType);
		// 自驾类型
		String zjType = bean.getZjType();
		SecurityUtils.getSubject().getSession().setAttribute("driveType", zjType);
		map.addAttribute("zjType", zjType);
		
		// 当前年月
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		map.addAttribute("priceYeMon", priceYear + " 年 " + priceMonth + " 月");
	}
}
