package com.erim.sz.guide.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.common.bean.GuidePriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.guide.dao.GuideDetailDao;
import com.erim.sz.guide.dao.GuidePriceDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.sz.web.util.PriceUtil;
import com.erim.web.service.CodeService;

/**
 * @类名: GuidePriceService
 * @描述: 导游信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年10月20日 下午3:06:09
 */
@Service("guidePriceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuidePriceService {

	@Autowired
	private GuidePriceDao guidePriceDao;
	@Autowired
	private GuideDetailDao guideDao;
	@Autowired
	private CodeService codeService;
	
	/**
	 * @描述: 同业资源入口
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月22日 下午5:49:40
	 * @param map
	 * @param bean
	 */
	public void showSametownPortal(ModelMap map, GuidePriceBean bean) {
		
		// 导游ID
		Integer oneId = bean.getGdlId();
		if (oneId != null && !"".equals(oneId)) {
			// 存储Session,以便其他操作使用
			SecurityUtils.getSubject().getSession().setAttribute("oneId", oneId);
		}
		GuideDetailBean detailBean = guideDao.selectById(oneId);
		// 导游名称
		String gdlName = detailBean.getGdlName();
		if (gdlName != null && !"".equals(gdlName)) {
			map.addAttribute("gdlName", gdlName);
			SecurityUtils.getSubject().getSession().setAttribute("gdlName", gdlName);
		}
		// 导游性别
		String sex = detailBean.getGdlSex();
		// 性别转码
		if (sex != null && !"".equals(sex)) {
			String str = codeService.getValueByCodeNoAndKey(DictionaryUtil.SEX, sex);
			map.addAttribute("sex", str);
			SecurityUtils.getSubject().getSession().setAttribute("sex", str);
		}
		// 导游证号
		String certificate = bean.getCertificate();
		if (certificate != null && !"".equals(certificate)) {
			map.addAttribute("certificate", certificate);
			SecurityUtils.getSubject().getSession().setAttribute("certificate", certificate);
		}
		// 服务类型
		String isInternal = bean.getIsInternal();
		List<GuidePriceBean> list = new ArrayList<GuidePriceBean>();
		if (isInternal != null && !"".equals(isInternal)) {
			String[] strArr = isInternal.split(",");
			for (int i = 0; i < strArr.length; i++) {
				String inStr = strArr[i];
				if (ErimConstants.GUIDE_SERVICE_LOCAL.equals(inStr)) {
					GuidePriceBean priceBean = new GuidePriceBean();
					priceBean.setGdlServiceCode(ErimConstants.GUIDE_SERVICE_LOCAL);
					priceBean.setGdlServiceName("国内地陪");
					list.add(i, priceBean);
				} else if (ErimConstants.GUIDE_SERVICE_GAID.equals(inStr)) {
					GuidePriceBean priceBean = new GuidePriceBean();
					priceBean.setGdlServiceCode(ErimConstants.GUIDE_SERVICE_GAID);
					priceBean.setGdlServiceName("国际/港澳台地陪");
					list.add(i, priceBean);
				}
			}
		}
		// 该导游的所有服务类型
		map.addAttribute("isInternal", list);
		SecurityUtils.getSubject().getSession().setAttribute("isInternal", list);
		
		// 默认当前服务类型为 国内地陪
		map.addAttribute("currIsInternal", ErimConstants.GUIDE_SERVICE_LOCAL);
		SecurityUtils.getSubject().getSession().setAttribute("currIsInternal", ErimConstants.GUIDE_SERVICE_LOCAL);
		
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		// 存入Session,以便其他操作使用
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		// 页面参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}

	/**
	 * @方法名: showGuidePricePortal
	 * @描述: 导游管理 - 初始化量价
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午4:17:31 
	 * @param map
	 * @param bean
	 */
	public void showGuidePricePortal(ModelMap map, GuidePriceBean bean) {
		
		// 导游ID
		Integer oneId = bean.getGdlId();
		if (oneId != null && !"".equals(oneId)) {
			// 存储Session,以便其他操作使用
			SecurityUtils.getSubject().getSession().setAttribute("oneId", oneId);
		}
		GuideDetailBean detailBean = guideDao.selectById(oneId);
		// 导游名称
		String gdlName = detailBean.getGdlName();
		if (gdlName != null && !"".equals(gdlName)) {
			map.addAttribute("gdlName", gdlName);
			SecurityUtils.getSubject().getSession().setAttribute("gdlName", gdlName);
		}
		// 导游性别
		String sex = detailBean.getGdlSex();
		// 性别转码
		if (sex != null && !"".equals(sex)) {
			String str = codeService.getValueByCodeNoAndKey(DictionaryUtil.SEX, sex);
			map.addAttribute("sex", str);
			SecurityUtils.getSubject().getSession().setAttribute("sex", str);
		}
		
		// 导游证号
		String certificate = bean.getCertificate();
		if (certificate != null && !"".equals(certificate)) {
			map.addAttribute("certificate", certificate);
			SecurityUtils.getSubject().getSession().setAttribute("certificate", certificate);
		}
		// 服务类型
		String isInternal = bean.getIsInternal();
		List<GuidePriceBean> list = new ArrayList<GuidePriceBean>();
		if (isInternal != null && !"".equals(isInternal)) {
			String[] strArr = isInternal.split(",");
			for (int i = 0; i < strArr.length; i++) {
				String inStr = strArr[i];
				if (ErimConstants.GUIDE_SERVICE_LOCAL.equals(inStr)) {
					GuidePriceBean priceBean = new GuidePriceBean();
					priceBean.setGdlServiceCode(ErimConstants.GUIDE_SERVICE_LOCAL);
					priceBean.setGdlServiceName("国内地陪");
					list.add(i, priceBean);
				} else if (ErimConstants.GUIDE_SERVICE_NATIONAL.equals(inStr)) {
					GuidePriceBean priceBean = new GuidePriceBean();
					priceBean.setGdlServiceCode(ErimConstants.GUIDE_SERVICE_NATIONAL);
					priceBean.setGdlServiceName("国内全陪");
					list.add(i, priceBean);
				} else if (ErimConstants.GUIDE_SERVICE_LEADER.equals(inStr)) {
					GuidePriceBean priceBean = new GuidePriceBean();
					priceBean.setGdlServiceCode(ErimConstants.GUIDE_SERVICE_LEADER);
					priceBean.setGdlServiceName("国际/港澳台领队");
					list.add(i, priceBean);
				} else if (ErimConstants.GUIDE_SERVICE_GAID.equals(inStr)) {
					GuidePriceBean priceBean = new GuidePriceBean();
					priceBean.setGdlServiceCode(ErimConstants.GUIDE_SERVICE_GAID);
					priceBean.setGdlServiceName("国际/港澳台地陪");
					list.add(i, priceBean);
				}
			}
		}
		// 该导游的所有服务类型
		SecurityUtils.getSubject().getSession().setAttribute("isInternal", list);
		
		// 默认当前服务类型为 国内地陪
		map.addAttribute("currIsInternal", ErimConstants.GUIDE_SERVICE_LOCAL);
		SecurityUtils.getSubject().getSession().setAttribute("currIsInternal", ErimConstants.GUIDE_SERVICE_LOCAL);
		
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		// 存入Session,以便其他操作使用
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		// 页面参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 获取该导游是否有可服务类型
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月8日 上午10:15:50
	 * @param map
	 * @param bean
	 */
	public Integer getGuideIsInternal(ModelMap map, GuidePriceBean bean) {
		// 服务类型
		String isInternal = bean.getIsInternal();
		if (isInternal == null || "".equals(isInternal)) {
			return CommonUtil.GUIDENOTPRICE;
		}
		return CommonUtil.SUCCESS;
	}
	
	/**
	 * @描述: 更改可服务类型
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月20日 下午3:35:22
	 * @param map
	 * @param bean
	 */
	public void skipService(ModelMap map, GuidePriceBean bean) {
		// 当前选中服务类型
		String currIsInternal = bean.getIsInternal();
		SecurityUtils.getSubject().getSession().setAttribute("currIsInternal", currIsInternal);
		map.addAttribute("currIsInternal", currIsInternal);
		
		// 年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @方法名: refresh
	 * @描述: 刷新
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午4:29:39 
	 * @param map
	 * @param bean
	 */
	public void refresh(ModelMap map, GuidePriceBean bean) {
		// 年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @方法名: showListForward
	 * @描述: 时间向前选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午4:18:30 
	 * @param map
	 * @param bean
	 */
	public void showListForward(ModelMap map, GuidePriceBean bean) {
		
		// Session
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		int yearInt = Integer.valueOf(year);
		int monthInt = Integer.valueOf(month);
		if (monthInt == 12) {
			yearInt++;
			monthInt = 1;
		} else {
			monthInt++;
		}
		year = Integer.toString(yearInt);
		month = Integer.toString(monthInt);
		// 存入Session,以便接下来操作使用
		if (year != null && !"".equals(year) && month != null && !"".equals(month)) {
			SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
			SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		}
		
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
		
	}
	
	/**
	 * @方法名: showListBackwards
	 * @描述: 时间向后选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午4:21:35 
	 * @param map
	 * @param bean
	 */
	public void showListBackwards(ModelMap map, GuidePriceBean bean) {
		
		// Session(也就是页面)中的年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		int yearInt = Integer.valueOf(year);
		int monthInt = Integer.valueOf(month);
		if (monthInt == 1) {
			yearInt--;
			monthInt = 12;
		} else {
			monthInt--;
		}
		year = Integer.toString(yearInt);
		month = Integer.toString(monthInt);
		// 存入Session,以便接下来操作使用
		if (year != null && !"".equals(year) && month != null && !"".equals(month)) {
			SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
			SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		}
		
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
		
	}
	
	/**
	 * @方法名: insertPrice
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午4:24:52 
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer insertPrice(ModelMap map, GuidePriceBean bean) {
		Integer result = CommonUtil.ERROR;
		
		// 导游ID
		Integer oneId=  (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		// 导游名称
		String gdlName = (String) SecurityUtils.getSubject().getSession().getAttribute("gdlName");
		String gdlServiceCode = bean.getGdlServiceCode();
		if (gdlServiceCode != null && !"".equals(gdlServiceCode)) {
			SecurityUtils.getSubject().getSession().setAttribute("gdlServiceCode", gdlServiceCode);
		} else {
			// 导游服务类型
			gdlServiceCode = (String) SecurityUtils.getSubject().getSession().getAttribute("currIsInternal");
		}
		
		// 开始时间和结束时间
		String start = bean.getStart();
		String end = bean.getEnd();
		
		// 获取之间所有日期
		String[] day = DateUtil.getCountByStartEnd(start, end);
		Integer state = 0;
		for (int i = 0; i < day.length; i++) {
			// 当前日期
			String date = day[i];
			// 获取当前日期为周几
			String week = DateUtil.getWeekByDate(date);
			// 判断是否符合按周选择
			boolean bl = PriceUtil.isAllowAdd(bean.getWeek(), week);
			if (bl) {
				// 第一条可录入日期
				if (state == 0) {
					// 获取初次录入日期的年月信息
					PriceUtil.getFirstDate(date, map);
				}
				state = 1;
				bean.setGdlId(oneId); // 导游ID
				bean.setGdlName(gdlName); // 导游名称
				bean.setGpeDate(date); // 日期
				bean.setGpeWeek(week); // 星期
				bean.setGdlServiceCode(gdlServiceCode); // 可服务类型
				bean.setCpyId(CommonUtil.getCpyId()); // 公司ID
				bean.setGpeCreateUser(CommonUtil.getLoginName()); // 创建用户
				bean.setGpeCreateTime(new Date()); // 创建时间
				// 执行新增
				result = guidePriceDao.insertPrice(bean);
			}
		}
		// 没有任何可添加的日期
		if (state == 0) {
			//　如果只是无可新增日期，返回没有可添加的日期
			result = CommonUtil.NOTHAVE;
		}
		return result;
	}
	
	/**
	 * @方法名: selectCafeteriaPriceList
	 * @描述: 查询数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午4:33:26 
	 * @param map
	 * @param bean
	 */
	public void selectGuidePriceList(ModelMap map, GuidePriceBean bean) {
		List<GuidePriceBean> list = new ArrayList<GuidePriceBean>(42);
		List<GuidePriceBean> modelList = new ArrayList<GuidePriceBean>();
		
		// 获取日期
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		// 该有所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 该有所有天数总计
		int monthNum = DateUtil.getMonthCount(year, month);
		
		/*
		 * 根据套餐ID、当前所选日期获取该日期内所有量价信息
		 */
		// 导游ID
		Integer gdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		bean.setGdlId(gdlId);
		// 导游服务类型
		String service = (String) SecurityUtils.getSubject().getSession().getAttribute("currIsInternal");
		bean.setGdlServiceCode(service);
		// 量价信息
		modelList = guidePriceDao.selectGuidePriceList(bean, monthCount);
		
		// 日历号
		int j = 0;
		/*
		 * 根据年月，判断该月日历数据前，共有多少空格
		 */
		int weekCount = DateUtil.getWeekByDate(year, month);
		for (int i = 0; i < weekCount; i++) {
			// 填入空格
			list.add(i, new GuidePriceBean());
		}
		
		/*
		 * 处理查询的量价信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询到的量价信息
			GuidePriceBean model = new GuidePriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 量价信息日期
				String tplDate = model.getGpeDate();
				// 下标
				int index = j + weekCount;
				// 当前信息日期是否符合日期
				if (monthCount[j].equals(tplDate)) {
					// 当前日期是否允许修改
					boolean bl = DateUtil.getCheckDateUpdate(tplDate);
					// 允许修改
					if (bl) {
						model.setIsUpdate(ErimConstants.YESORNO_YES);
					} else {
						model.setIsUpdate(ErimConstants.YESORNO_NO);
					}
					// 塞进List
					model.setDay(j + 1 + "");
					list.add(index, model);
				} else {
					// 不符合
					i--;
					model = new GuidePriceBean();
					model.setDay(j + 1 + "");
					list.add(index, model);
				}
				j++;
			}
		}
		
		/*
		 * 填充日历中剩余的空格，凑满42个
		 */
		// 日历中已有的格数
		int priceSize = list.size();
		// 剩余格数
		int blankCount = 42 - priceSize;
		// 填入空值
		for (int i = 0; i < blankCount; i++) {
			// 下标
			int index = priceSize + i;
			GuidePriceBean model = new GuidePriceBean();
			// 日历
			if (j < monthNum) {
				model.setDay(j + 1 + "");
				list.add(index, model);
				j++;
			} else {
				list.add(index, model);
			}
		}
		map.addAttribute("priceList", list);
	}
	
	/**
	 * @方法名: updateIsOpen
	 * @描述: 更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午4:33:48 
	 * @param bean
	 * @return
	 */
	public Integer updateIsOpen(GuidePriceBean bean) {
		/**
		 * 修改原因：根据ID更改是否出售状态改为根据当前日期和当前导游ID
		 */
		Integer result = CommonUtil.ERROR;
		result = guidePriceDao.updateIsOpen(bean);
		return result;
	}
	
	/**
	 * @方法名: updatePrice
	 * @描述: 修改量价
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午4:34:48 
	 * @param bean
	 * @return
	 */
	public Integer updatePrice(GuidePriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = guidePriceDao.updatePrice(bean);
		return result;
	}
	
	/**
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午4:36:15 
	 * @param bean
	 * @return
	 */
	public Integer updateBatchIsOpen(GuidePriceBean bean, ModelMap map) {
		Integer result = CommonUtil.ERROR;
		// 开始日期和结束日期
		String start = bean.getStart();
		String end = bean.getEnd();
		// 获取初次录入日期的年月信息
		PriceUtil.getFirstDate(start, map);
		// 获取之间所有日期
		String[] strList = DateUtil.getCountByStartEnd(start, end);
		// 导游ID
		Integer oneId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		bean.setGdlId(oneId);
		// 导游服务类型
		String serviceType = (String) SecurityUtils.getSubject().getSession().getAttribute("currIsInternal");
		bean.setIsInternal(serviceType);
		bean.setGpeIsOpen(ErimConstants.YESORNO_NO); // 停止出售
		// 执行修改
		result = guidePriceDao.updateBatchIsOpen(bean, strList);
		return result;
	}
}
