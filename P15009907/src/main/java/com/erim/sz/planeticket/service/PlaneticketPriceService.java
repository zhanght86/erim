package com.erim.sz.planeticket.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.PlaneticketPriceBean;
import com.erim.sz.common.bean.PlaneticketDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.planeticket.dao.PlaneticketDetailDao;
import com.erim.sz.planeticket.dao.PlaneticketPriceDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.PriceUtil;

/**
 * @描述: 飞机票量价信息实体操作业务层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月8日 下午3:48:24
 */
@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PlaneticketPriceService {

	@Autowired
	private PlaneticketPriceDao planeticketPriceDao;
	@Autowired
	private PlaneticketDetailDao planeticketDetailDao;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	
	/**
	 * @描述: 加载量价管理信息页面参数
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午4:42:23
	 * @param map
	 * @param bean
	 */
	public void showPlaneticketPricePortal(ModelMap map, PlaneticketPriceBean bean) {
		
		// 产品ID
		Integer gdlId = bean.getGdlId();
		// 根据产品ID获取一条产品信息
		PlaneticketDetailBean detailModel = planeticketDetailDao.selectPlaneticket(gdlId);
		// 产品信息
		String gdlInfo = "";
		// 类别
		String ptdNtype = detailModel.getPtdNtype();
		if (ErimConstants.TRANSNTYPE_DCZF.equals(ptdNtype)) {
			gdlInfo += "【单程-直飞航班】";
		} else if (ErimConstants.TRANSNTYPE_DCZZ.equals(ptdNtype)) {
			gdlInfo += "【单程-中转航班】";
		}
		// 出发城市
		String ptdStartCity = detailModel.getPtdStartCity();
		if (ptdStartCity != null && !"".equals(ptdStartCity)) {
			ptdStartCity = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ptdStartCity));
		}
		gdlInfo += ptdStartCity;
		// 出发时间
		String ptdStartTime = detailModel.getPtdStartTime();
		gdlInfo += "(" + ptdStartTime + ") → ";
		// 到达城市
		String ptdEndCity = detailModel.getPtdEndCity();
		// 到达城市
		if (ptdEndCity != null && !"".equals(ptdEndCity)) {
			ptdEndCity = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ptdEndCity));
		}
		gdlInfo += ptdEndCity;
		// 到达时间
		String ptdEndTime = detailModel.getPtdEndTime();
		gdlInfo += "(" + ptdEndTime + ")";
		
		// 产品ID
		SecurityUtils.getSubject().getSession().setAttribute("oneId", gdlId);
		// 产品信息
		SecurityUtils.getSubject().getSession().setAttribute("gdlName", gdlInfo);
		// 当前所选舱位 默认经济舱
		SecurityUtils.getSubject().getSession().setAttribute("ptdClass", ErimConstants.PLANE_CALSS_ECONOMY);
		
		// 年月
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		
		// 返回页面的信息
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 更改当前选择舱位
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午1:27:18
	 * @param map
	 * @param bean
	 */
	public void skipPtdClass(ModelMap map, PlaneticketPriceBean bean) {
		// 当前选择舱位
		String ptdClass = bean.getPtdClass();
		SecurityUtils.getSubject().getSession().setAttribute("ptdClass", ptdClass);
		// 带上当前时间
		refresh(map, bean);
	}
	
	/**
	 * @描述: 时间向前选择按钮
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午5:44:57
	 * @param map
	 * @param bean
	 */
	public void showListForward(ModelMap map, PlaneticketPriceBean bean) {
		
		//Session
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 执行时间向前选择
		Map<String, Object> dateMap = PriceUtil.dateForward(year, month);
		year = (String) dateMap.get("year");
		month = (String) dateMap.get("month");
				
		// 存入Session,以便接下来操作使用
		if (year != null && !"".equals(year) && month != null && !"".equals(month)) {
			SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
			SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		}
		
		// 返回页面的参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
		
	}
	
	/**
	 * @描述: 时间向后选择按钮
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午5:45:19
	 * @param map
	 * @param bean
	 */
	public void showListBackwards(ModelMap map, PlaneticketPriceBean bean) {
		//Session
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 执行时间向后选择
		Map<String, Object> dateMap = PriceUtil.dateBackwards(year, month);
		year = (String) dateMap.get("year");
		month = (String) dateMap.get("month");
				
		// 存入Session,以便接下来操作使用
		if (year != null && !"".equals(year) && month != null && !"".equals(month)) {
			SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
			SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		}
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午5:50:51
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer insertPrice(ModelMap map, PlaneticketPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		
		// 产品ID
		Integer tdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		// 舱位类型
		String ptdClass = (String) SecurityUtils.getSubject().getSession().getAttribute("ptdClass");
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
			// 判断是否符合安州选择
			boolean bl = PriceUtil.isAllowAdd(bean.getWeek(), week);
			if (bl) {
				// 第一条可录入日期
				if (state == 0) {
					// 获取初次录入日期的年月信息
					PriceUtil.getFirstDate(date, map);
				}
				state = 1;
				bean.setGdlId(tdlId); // 产品ID
				bean.setPreDate(date); // 日期
				bean.setPreWeek(week); // 星期
				bean.setPtdClass(ptdClass); // 舱位类型
				bean.setPreIsOpen(ErimConstants.YESORNO_YES); // 是否开放
				bean.setPreCreateTime(new Date()); // 创建时间
				bean.setPreCreateUser(CommonUtil.getLoginName()); // 创建用户
				// 执行查询
				result = planeticketPriceDao.insertPrice(bean);
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
	 * @描述: 刷新参数
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午5:52:08
	 * @param map
	 * @param bean
	 */
	public void refresh(ModelMap map, PlaneticketPriceBean bean) {
		// 产品名称
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 查询数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午5:52:41
	 * @param map
	 * @param bean
	 */
	public void selectPlaneticketPriceList(ModelMap map, PlaneticketPriceBean bean) {
		
		List<PlaneticketPriceBean> list = new ArrayList<PlaneticketPriceBean>(42);
		List<PlaneticketPriceBean> modelList = new ArrayList<PlaneticketPriceBean>();
		// 获取日期
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		// 该有所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 该有天数总计
		int monthNum = DateUtil.getMonthCount(year, month);
		/*
		 * 根据产品ID、当前所选日期获取该日期内所有量价信息
		 */
		// 产品ID
		Integer gdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		bean.setGdlId(gdlId);
		// 舱位类型
		String ptdClass = (String) SecurityUtils.getSubject().getSession().getAttribute("ptdClass");
		bean.setPtdClass(ptdClass);
		// 量价信息
		modelList = planeticketPriceDao.selectPlaneticketPriceList(bean, monthCount);
		// 日历号
		int j = 0;
		/*
		 * 根据年月，判断该月日历数据前，共有多少空格
		 */
		int weekCount = DateUtil.getWeekByDate(year, month);
		for (int i = 0; i < weekCount; i++) {
			// 填入空格
			list.add(i, new PlaneticketPriceBean());
		}
		/*
		 * 处理查询的量价信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询到的量价信息
			PlaneticketPriceBean model = new PlaneticketPriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 量价信息日期
				String gpeDate = model.getPreDate();
				//　下标
				int index = j + weekCount;
				// 当前信息日期是否符合日期
				if (monthCount[j].equals(gpeDate)) {
					// 当前日期是否允许修改
					boolean bl = DateUtil.getCheckDateUpdate(gpeDate);
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
					model = new PlaneticketPriceBean();
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
			PlaneticketPriceBean model = new PlaneticketPriceBean();
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
	 * @描述: 更改出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午5:55:11
	 * @param bean
	 * @return
	 */
	public Integer updateIsOpen(PlaneticketPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = planeticketPriceDao.updateIsOpen(bean);
		return result;
	}
	
	/**
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午5:56:11
	 * @param bean
	 * @return
	 */
	public Integer updatePrice(PlaneticketPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = planeticketPriceDao.updatePrice(bean);
		return result;
	}
	
	/**
	 * @描述: 批量修改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午5:58:48
	 * @param bean
	 * @return
	 */
	public Integer updateBatchIsOpen(PlaneticketPriceBean bean, ModelMap map) {
		Integer result = CommonUtil.ERROR;
		// 开始日期和结束日期
		String start = bean.getStart();
		String end = bean.getEnd();
		// 获取初次录入日期的年月信息
		PriceUtil.getFirstDate(start, map);
		// 获取之间所有日期
		String[] strList = DateUtil.getCountByStartEnd(start, end);
		// 产品ID
		Integer gdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		bean.setGdlId(gdlId);
		// 产品舱位类型
		String ptdClass = (String) SecurityUtils.getSubject().getSession().getAttribute("ptdClass");
		bean.setPtdClass(ptdClass);
		// 停售
		bean.setPreIsOpen(ErimConstants.YESORNO_NO);
		// 执行查询
		result = planeticketPriceDao.updateBatchIsOpen(bean, strList);
		return result;
	}
}
