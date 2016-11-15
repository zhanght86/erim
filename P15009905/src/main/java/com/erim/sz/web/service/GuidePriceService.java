package com.erim.sz.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.common.bean.GuidePriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.web.dao.GuideDetailDao;
import com.erim.sz.web.dao.GuidePriceDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.PriceUtil;

/**
 * @类名: GuidePriceService
 * @描述: 导游量价信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年12月22日 下午4:18:04
 */
@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuidePriceService {

	@Autowired
	private GuidePriceDao guidePriceDao;
	@Autowired
	private GuideDetailDao guideDetailDao;
	
	/**
	 * @描述: 初始化档期管理信息- IndexContrller 专用 业务方法
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月22日 下午2:25:47
	 * @param map
	 * @param bean
	 */
	public void refreshGuidePriceList(ModelMap map) {
		
		GuidePriceBean bean = new GuidePriceBean();
		
		// 导游ID
		Integer guideId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("id");
		
		// 获取该导游服务类型字典
		List<GuidePriceBean> list = setServiceCode(map, guideId);
		
		if (list.size() > 0) {
			// 当前选中的服务类型
			SecurityUtils.getSubject().getSession().setAttribute("currService", list.get(0).getGdlServiceCode());
		}
		
		// 当前年月
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		SecurityUtils.getSubject().getSession().setAttribute("year", year);
		SecurityUtils.getSubject().getSession().setAttribute("month", month);
		
		// 该月所有天数统计
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		
		bean.setGdlId(guideId);
		bean.setGdlServiceCode((String)SecurityUtils.getSubject().getSession().getAttribute("currService"));
		
		List<GuidePriceBean> modelList = guidePriceDao.selectGuidePriceList(bean, monthCount);
		// 生成日历
		createCalendar(map, modelList, year, month);
	}
	
	/**
	 * @描述: 查询档期信息列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 上午11:37:21
	 * @param map
	 */
	public void selectPriceList(ModelMap map) {
		GuidePriceBean bean = new GuidePriceBean();
		
		// 导游ID
		Integer guideId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("id");
		
		// 获取该导游服务类型字典
		setServiceCode(map, guideId);
		
		// 当前选中的服务类型
		String currService = (String) SecurityUtils.getSubject().getSession().getAttribute("currService");
		
		// 当前年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("year");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("month");
		
		// 该月所有天数统计
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		
		bean.setGdlId(guideId);
		bean.setGdlServiceCode(currService);
		
		List<GuidePriceBean> modelList = guidePriceDao.selectGuidePriceList(bean, monthCount);
		// 生成日历
		createCalendar(map, modelList, year, month);
	}
	
	/**
	 * @描述: 时间向前选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 下午12:00:11
	 * @param map
	 * @param bean
	 */
	public void forwardDate(ModelMap map, GuidePriceBean bean) {
		// 当前年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("year");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("month");
		
		// 执行时间向前选择
		Map<String, Object> dateMap = PriceUtil.dateForward(year, month);
		year = (String) dateMap.get("year");
		month = (String) dateMap.get("month");
		
		SecurityUtils.getSubject().getSession().setAttribute("year", year);
		SecurityUtils.getSubject().getSession().setAttribute("month", month);
		
		// 获取数据
		selectPriceList(map);
	}
	
	/**
	 * @描述: 时间向后选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 下午12:01:08
	 * @param map
	 * @param bean
	 */
	public void backwardsDate(ModelMap map, GuidePriceBean bean) {
		
		// 当前年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("year");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("month");
		
		// 执行时间向后选择
		Map<String, Object> dateMap = PriceUtil.dateBackwards(year, month);
		year = (String) dateMap.get("year");
		month = (String) dateMap.get("month");
		
		SecurityUtils.getSubject().getSession().setAttribute("year", year);
		SecurityUtils.getSubject().getSession().setAttribute("month", month);
		
		//　获取数据
		selectPriceList(map);
	}
	
	/**
	 * @描述: 更改导游当前选择服务类型
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 下午1:51:35
	 * @param map
	 * @param bean
	 */
	public void updateServiceType(ModelMap map, GuidePriceBean bean) {
		// 导游当前服务类型
		String service = bean.getIsInternal();
		
		SecurityUtils.getSubject().getSession().setAttribute("currService", service);
		
		//　获取数据
		selectPriceList(map);
	}
	
	/**
	 * @描述: 数据生成日历
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月22日 下午4:29:30
	 * @param modelList
	 * @param year
	 * @param month
	 * @return
	 */
	public void createCalendar(ModelMap map, List<GuidePriceBean> modelList, String year, String month) {
		
		List<GuidePriceBean> list = new ArrayList<GuidePriceBean>(42);
		
		// 该月所有天数统计
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 该月所有天数总计
		int monthNum = DateUtil.getMonthCount(year, month);
		
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
					String day = j + 1 + "";
					model.setDay(day);
					if (DateUtil.getCuurentMonth().equals(month) && DateUtil.getCurrentDay().equals(day)) {
						model.setIsNow(ErimConstants.YESORNO_YES);
						map.addAttribute("nowPrice", model.getGpeGuestPrice());
					} else {
						model.setIsNow(ErimConstants.YESORNO_NO);
					}
					// 塞进List
					list.add(index, model);
				} else {
					// 不符合
					i--;
					model = new GuidePriceBean();
					String day = j + 1 + "";
					model.setDay(day);
					// 判断是否为今天
					if (DateUtil.getCuurentMonth().equals(month) && DateUtil.getCurrentDay().equals(day)) {
						model.setIsNow(ErimConstants.YESORNO_YES);
						map.addAttribute("nowPrice", model.getGpeGuestPrice());
					} else {
						model.setIsNow(ErimConstants.YESORNO_NO);
					}
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
				String day = j + 1 + "";
				model.setDay(day);
				// 判断是否为今天
				if (DateUtil.getCuurentMonth().equals(month) && DateUtil.getCurrentDay().equals(day)) {
					model.setIsNow(ErimConstants.YESORNO_YES);
					map.addAttribute("nowPrice", model.getGpeGuestPrice());
				} else {
					model.setIsNow(ErimConstants.YESORNO_NO);
				}
				list.add(index, model);
				j++;
			} else {
				list.add(index, model);
			}
		}
		map.addAttribute("priceList", list);
	}
	
	/**
	 * @描述: 导游服务类型字典
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月22日 下午3:14:30
	 * @param map
	 * @param Id
	 */
	public List<GuidePriceBean> setServiceCode(ModelMap map, Integer Id) {
		// 根据导游ID获取一条导游信息
		GuideDetailBean detailBean = guideDetailDao.getGuideDetailById(Id);
		// 服务类型
		String service = detailBean.getGdlServer();
		List<GuidePriceBean> serviceList = new ArrayList<GuidePriceBean>();
		if (service != null && service.contains(ErimConstants.GUIDE_SERVICE_LOCAL)) {
			GuidePriceBean priceBean = new GuidePriceBean();
			priceBean.setGdlServiceCode(ErimConstants.GUIDE_SERVICE_LOCAL);
			priceBean.setGdlServiceName("国内地陪");
			serviceList.add(priceBean);
		} 
		if (service != null && service.contains(ErimConstants.GUIDE_SERVICE_NATIONAL)) {
			GuidePriceBean priceBean = new GuidePriceBean();
			priceBean.setGdlServiceCode(ErimConstants.GUIDE_SERVICE_NATIONAL);
			priceBean.setGdlServiceName("国内全陪");
			serviceList.add(priceBean);
		} 
		if (service != null && service.contains(ErimConstants.GUIDE_SERVICE_LEADER)) {
			GuidePriceBean priceBean = new GuidePriceBean();
			priceBean.setGdlServiceCode(ErimConstants.GUIDE_SERVICE_LEADER);
			priceBean.setGdlServiceName("国际/港澳台领队");
			serviceList.add(priceBean);
		} 
		if (service != null && service.contains(ErimConstants.GUIDE_SERVICE_GAID)) {
			GuidePriceBean priceBean = new GuidePriceBean();
			priceBean.setGdlServiceCode(ErimConstants.GUIDE_SERVICE_GAID);
			priceBean.setGdlServiceName("国际/港澳台地陪");
			serviceList.add(priceBean);
		}
		// 该导游的所有服务类型
		map.addAttribute("serviceList", serviceList);
		
		return serviceList;
	}
	
	/**
	 * @描述: 更改导游档期信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 上午10:28:20
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer updateIsOpen(ModelMap map, GuidePriceBean bean) {
		// 定义返回状态
		Integer result = CommonUtil.ERROR;
		
		// 日期
		String day = bean.getDay();
		day = Integer.valueOf(day)<10?"0"+day:day;
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("year");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("month");
		bean.setGpeDate(year+"-"+month+"-"+day);
		
		// 导游档期
		String isOpen = bean.getGpeIsOpen();
		// 满档
		if ("01".equals(isOpen)) {
			result = guidePriceDao.updateBatchIsOpen(bean);
		} else if ("02".equals(isOpen)) {
			// 执行修改
			result = guidePriceDao.updateIsOpen(bean);
		}
		return result;
	}
	
}
