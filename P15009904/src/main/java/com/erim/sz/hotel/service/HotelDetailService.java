package com.erim.sz.hotel.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.core.lang.ExtHashMap;
import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.common.bean.HotelMeetingBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.common.util.CodeUtil;
import com.erim.sz.hotel.dao.HotelDetailDao;
import com.erim.sz.hotel.dao.HotelMeetingDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.sz.zy.service.ZySystemCooperationService;
import com.erim.web.service.CodeService;

/**
 * @类名: HotelDetailService
 * @描述: 酒店实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年10月2日 下午3:42:03
 */
@Service("hotelDetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelDetailService {

	@Autowired
	private HotelDetailDao 		         hotelDetailDao;
	@Autowired
	private CodeService 		         codeService;
	@Autowired
	private TmSystemRegionService        tmSystemRegionService;
	@Autowired
	private HotelMeetingDao		         hotelMeetingDao;
	@Autowired
	private ZySystemCooperationService  zySystemCooperationService;
	
	/**
	 * @方法名：showHotelTown 
	 * @描述: 同城同业
	 * @作者： 贺渊博
	 * @创建时间：2015年11月11日 下午4:08:42
	 * @param model
	 * @param bean
	 */
	public void showHotelTown(ModelMap model, HotelDetailBean bean) {
		// 入住日期
		if(StringUtils.isEmpty(bean.getHnpDate())){
			bean.setHnpDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    	}
		//当前公司
		bean.setCpyId(CommonUtil.getCpyId());
		//获取国内国际的值
		String  hdlIsInternal = bean.getHdlIsInternal();
		//如果为国内时清空国际的值
		if("02".equals(hdlIsInternal)){
			bean.setHdlExternal(null);
			bean.setHdlForeign(null);
			bean.setHdlForeignCity(null);
		}
		//如果为国际的值清空国内的值
		if("01".equals(hdlIsInternal)){
			bean.setHdlProvince(null);
			bean.setHdlCity(null);
			bean.setHdlCounty(null);
		}
		// 分页查询
		List<HotelDetailBean> hotelList = hotelDetailDao.selectPageTown(bean, model);
		// 回传信息
		model.put("hotelList", hotelList);
	}
	
	/**
	 * @Title: showHotel
	 * @Description: 查询酒店信息
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void showHotel(ModelMap model, HotelDetailBean bean) {
		
		/////////////////////////////////// 字典设置start ///////////////////////////////
		// 星级
		model.addAttribute("startlevel",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STARTLEVEL));
		// 省
		model.addAttribute("provinces",        this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		/////////////////////////////////// 字典设置end  ///////////////////////////////
		
		bean.getPageLinkBean().setLimit(10);

		// 分页查询
		List<HotelDetailBean> hotelList = hotelDetailDao.selectPageHotelList(bean, model);
		for (int i = 0; i < hotelList.size(); i++) {
			HotelDetailBean model1 = hotelList.get(i);
			// 所在城市
			String hdlCity = model1.getHdlCity();
			if (hdlCity != null && !"".equals(hdlCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(hdlCity));
				model1.setHdlCity(str);
			}
			String hdlExternal = model1.getHdlExternal();
			if (hdlExternal != null && !"".equals(hdlExternal)) {
				if ("01".equals(hdlExternal)) {
					model1.setDicExternal("香港");
				}
				if ("02".equals(hdlExternal)) {
					model1.setDicExternal("澳门");
				}
				if ("03".equals(hdlExternal)) {
					model1.setDicExternal("台湾");
				}
			}
		}
		// 回传信息
		model.put("hotelList", hotelList);
	}
	
	/**
	 * @方法名: selectHotelList
	 * @描述: 分页获取酒店数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月2日 下午4:22:33 
	 * @param map
	 * @param bean
	 */
	public void selectPageHotelList(ModelMap map, HotelDetailBean bean) {
		// 酒店档次
		map.addAttribute("startLevel", codeService.getSystemCodeByCodeNo(DictionaryUtil.STARTLEVEL));
		// 省份
		map.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		// 同城类型
		map.addAttribute("sametownntype", ErimConstants.TOWN_HOTEL);
		
		//bean.getPageLinkBean().setLimit(10);
		bean.setCpyId(CommonUtil.getCpyId());
		
		//获取柜内国际值
		String HdlIsInternal = bean.getHdlIsInternal();
		//当选择国内时，清空国际所在地等字段
		if("02".equals(HdlIsInternal)){
			bean.setHdlForeign(null);
			bean.setHdlForeignCity(null);
			bean.setHdlExternal(null);
		}
		//当选择国外时，清空省市县三个字段
		else if("01".equals(HdlIsInternal)){
			bean.setHdlProvince(null);
			bean.setHdlCity(null);
			bean.setHdlCounty(null);
		}
		
		//如果是合作用户 查询合作用户的操作权限 写入查询条件
		if("1".equals(CommonUtil.getCooperation())){
			Integer cid = zySystemCooperationService.getCpyIdByNtype(ErimConstants.TOWN_HOTEL);
			//产品id
			if(0 != cid)  bean.setId(cid);
		}
		
		// 获取数据
		List<HotelDetailBean> list = hotelDetailDao.selectPageHotelList(bean, map);
		
		map.put("hotelList", list);
		//国家字符串类型 自动检索时用
        map.addAttribute("guojiaforquery",this.getGuojiaForQuery(this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY)));
	}
	
	/**
	 * @方法名: setCode
	 * @描述: 放置字典
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月2日 下午7:38:01 
	 * @param model
	 */
	public void setCode(ModelMap model) {
		// 星级/酒店档次
		model.addAttribute("startlevel",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STARTLEVEL));
		// 特色
		model.addAttribute("hotelfeatures",    this.codeService.getSystemCodeListByCodeNo(DictionaryUtil.HOTELFEATURES));
		// 设施
		model.addAttribute("hotelfacilities",  this.codeService.getSystemCodeListByCodeNo(DictionaryUtil.HOTELFACILITIES));
		// 预定方式
		model.addAttribute("scheduled",  this.codeService.getSystemCodeListByCodeNo(DictionaryUtil. SCHEDULED));
		// 休闲娱乐
		model.addAttribute("recreation",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.RECREATION));
		// 餐饮设施
		model.addAttribute("diningfacilities", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.DININGFACILITIES));
		// 信用卡
		model.addAttribute("credit",           this.codeService.getSystemCodeByCodeNo(DictionaryUtil.CREDIT));
		// 服务项目
		model.addAttribute("serviceitems",     this.codeService.getSystemCodeListByCodeNo(DictionaryUtil.SERVICEITEMS));
		//会议室设施 
		model.addAttribute("sheshi",     	   this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MEET));
		//是否属于周边
		model.addAttribute("zhoubian",     	   this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ZHOUBIAN));
		//会议室摆放方式
		model.addAttribute("shape",     	   this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SHAPE));
		//餐厅类型
		model.addAttribute("cttype",     	   this.codeService.getSystemCodeByCodeNo(DictionaryUtil.CTTYPE));
		//主营项目
		model.addAttribute("business",     	   this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ZYXM));
		//停车场类型
		model.addAttribute("texttype",     	   this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTPTYPE));
		//停车费用
	    model.addAttribute("zyxm",     	       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTPMONEY));
	    //网络设施
	    model.addAttribute("WiFi",     	       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.INTERNET));
		// 省
		model.addAttribute("provinces",        this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		//国家字符串类型 自动检索时用
        model.addAttribute("guojiaforquery",this.getGuojiaForQuery(this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY)));
	}
	
	/**
	 * @方法名: insertHotel
	 * @描述: 新增酒店基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 上午10:44:03 
	 * @param hotelDetailBean
	 * @return
	 */
	public Integer insertHotel(HotelDetailBean hotelDetailBean) {
		
		// 创建时间
		hotelDetailBean.setHdlCreatetime(new Date());
		// 创建用户
		hotelDetailBean.setHdlCreateuser(CommonUtil.getLoginName());
		// 公司ID
		Integer cpyId = CommonUtil.getCpyId(); 
		hotelDetailBean.setCpyId(cpyId);
		// 是否上架
		hotelDetailBean.setHdlIsDelStatus(ErimConstants.YESORNO_NO);
		// 默认无效
		hotelDetailBean.setHdlIsValid(ErimConstants.YESORNO_NO);
		// 是否国内
		String hdlIsInternal = hotelDetailBean.getHdlIsInternal();
		if (ErimConstants.YESORNO_YES.equals(hdlIsInternal)) {
			// 当国内时，清空 国际所在地、外国、国外城市 三个字段
			hotelDetailBean.setHdlExternal("");
			hotelDetailBean.setHdlForeign("");
			hotelDetailBean.setHdlForeignCity("");
		} else {
			// 当国外时、清空 省、市、县 三个字段
			hotelDetailBean.setHdlProvince("");
			hotelDetailBean.setHdlCity("");
			hotelDetailBean.setHdlCounty("");
		}
		Integer result = hotelDetailDao.insert(hotelDetailBean);
		
		// 当插入成功
		if (result == CommonUtil.SUCCESS) {
			Integer ID = hotelDetailBean.getId();
			// 酒店ID存入Session
			SecurityUtils.getSubject().getSession().setAttribute("hotelID", ID);
			String hdlCode = CodeUtil.getShopCode(CodeUtil.NTYPE_HOTEL, cpyId, ID);
			hotelDetailBean.setHdlCode(hdlCode);
			hotelDetailDao.updateCode(hotelDetailBean);
		}
		return result;
	}
	
	/**
	 * @描述: 根据酒店ID查询会议室信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月9日 下午8:39:58
	 * @param map
	 * @param id 酒店基础ID
	 */
	public void selectMeetingByHotelId(ModelMap map, Integer id) {
		
		// 根据酒店基础ID查询酒店名称，返回页面
		HotelDetailBean bean = hotelDetailDao.getHotelDetailById(id);
		map.addAttribute("hotelBean", bean);
		
		List<HotelMeetingBean> list = new ArrayList<HotelMeetingBean>();
		if (id != null) {
			// 执行查询
			list = hotelMeetingDao.selectMeetingByHotelId(id);
			// 转码
			for (int i = 0; i < list.size(); i++) {
				HotelMeetingBean meeting = list.get(i);
				// 会议室人数
				Integer numSta = meeting.getHmgPersonnum();
				Integer numEnd = meeting.getHmgPersonNumEnd();
				if (numSta != null && numEnd != null && !"".equals(numSta) && !"".equals(numEnd)) {
					meeting.setPersonNum(numSta + "~" + numEnd + "人");
				}
				// 摆放形式
				String hmgShape = meeting.getHmgShape();
				if (hmgShape != null && !"".equals(hmgShape)) {
					String str = codeService.getValueByCodeKeys(DictionaryUtil.SHAPE, hmgShape);
					meeting.setHmgShape(str);
				}
			}
		}
		map.addAttribute("meetingList", list);
		
	}
	
	/**
	 * @方法名: insertCafeteria
	 * @描述: 添加餐厅信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午4:06:17 
	 * @param bean
	 * @return
	 */
	public Integer insertCafeteria(HotelDetailBean bean) {
		
		Integer id = bean.getId();
		if (id != null) {
			
			bean.setId(id);
			Integer result = hotelDetailDao.insertCafeteria(bean);
			return result;
		}
		return CommonUtil.ERROR;
	}
	
	/**
	 * @方法名: insertPark
	 * @描述: 添加停车场信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午4:47:40 
	 * @param bean
	 * @return
	 */
	public Integer insertPark(HotelDetailBean bean) {
		Integer id = bean.getId();
		if (id != null) {
			Integer result = hotelDetailDao.insertPark(bean);
			return result;
		}
		return CommonUtil.ERROR;
	}
	
	/**
	 * @方法名: getHotelDetailById
	 * @描述: 根据ID获取一条酒店信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午8:56:17 
	 * @param map
	 * @param id
	 */
	public void getHotelDetailById(ModelMap map, Integer id) {
		HotelDetailBean bean = new HotelDetailBean();
		id = (Integer) SecurityUtils.getSubject().getSession().getAttribute("hotelID");
		if (id != null) {
			bean = hotelDetailDao.getHotelDetailById(id);
		}
		map.addAttribute("hotelBean", bean);
	}
	
	/**
	 * @描述: 打开修改页面获取数据
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午8:08:31
	 * @param map
	 * @param id
	 */
	public void showUpdateHotelPage(ModelMap map, Integer id) {
		HotelDetailBean bean = new HotelDetailBean();
		if (id == null || "".equals(id)) {
			id = (Integer) SecurityUtils.getSubject().getSession().getAttribute("hotelID");
		}
		if (id != null) {
			bean = hotelDetailDao.getHotelDetailById(id);
			// 关键字
			String hdlKeyWord = bean.getHdlKeyword();
			if (hdlKeyWord != null && !"".equals(hdlKeyWord)) {
				map.addAttribute("keyword", hdlKeyWord.split(","));
			} else  {
				map.addAttribute("keyword", new String[]{""});
			}
			// 景点
			String hdlFeature = bean.getHdlFeature();
			if (hdlFeature != null && !"".equals(hdlFeature)) {
				map.addAttribute("feature", hdlFeature.split(","));
			} else {
				map.addAttribute("feature", new String[]{""});
			}
		}
		map.addAttribute("hotelBean", bean);
	}
	
	/**
	 * @方法名: updateHotel
	 * @描述: 修改酒店基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午9:26:20 
	 * @param bean
	 * @return
	 */
	public Integer updateHotel(HotelDetailBean bean) {
		// 创建时间
		bean.setHdlCreatetime(new Date());
		
		// 是否国内
		String hdlIsInternal = bean.getHdlIsInternal();
		if (ErimConstants.YESORNO_YES.equals(hdlIsInternal)) {
			// 当国内时，清空 国际所在地、外国、国外城市 三个字段
			bean.setHdlExternal("");
			bean.setHdlForeign("");
			bean.setHdlForeignCity("");
		} else {
			// 当国外时、清空 省、市、县 三个字段
			bean.setHdlProvince("");
			bean.setHdlCity("");
			bean.setHdlCounty("");
		}
		
		Integer result = hotelDetailDao.updateHotel(bean);
		// 当修改成功
		if (result == CommonUtil.SUCCESS) {
			// 酒店ID存入Session
			SecurityUtils.getSubject().getSession().setAttribute("hotelID", bean.getId());
		}
		return result;
	}
	
	/**
	 * @方法名: updateIsDelStatus
	 * @描述: 更改是否上架
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 上午9:40:15 
	 * @param bean
	 * @return
	 */
	public Integer updateIsDelStatus(HotelDetailBean bean) {
		Integer result = hotelDetailDao.updateIsDelStatus(bean);
		
		// 修改成功后，置空ID和上下架状态
		bean.setId(null);
		bean.setHdlIsDelStatus(null);
		
		return result;
	}
	
	/**
	 * @方法名: updateHotel
	 * @描述: 修改酒店基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午9:26:20 
	 * @param bean
	 * @return
	 */
	public Integer updateHotel1(HotelDetailBean bean) {
		// 创建时间
		bean.setHdlCreatetime(new Date());
		
		Integer result = hotelDetailDao.updateHotel1(bean);
		// 当修改成功
		if (result == CommonUtil.SUCCESS) {
			// 酒店ID存入Session
			SecurityUtils.getSubject().getSession().setAttribute("hotelID", bean.getId());
		}
		return result;
	}
	
	public String getGuojiaForQuery(ExtHashMap map){
	    Iterator iter = map.entrySet().iterator();
	    String s = "";
	    while(iter.hasNext()){
	       Entry entry = (Entry) iter.next();
	       Object a = entry.getValue();
	       s += a.toString()+",";
	    }
	    return s;
	}
}
