package com.erim.sz.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.common.bean.GuidePriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.web.dao.GuideDetailDao;
import com.erim.sz.web.dao.GuidePriceDao;
import com.erim.sz.web.util.DateUtil;

/**
 * @描述: 导游导服费信息实体操作业务层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月12日 下午2:05:43
 */
@Service
public class GuidePriceServcie {

	@Autowired
	private GuidePriceDao guidePriceDao;
	@Autowired
	private GuideDetailDao guideDao;
	
	/**
	 * @描述: 生成服务类型字典
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午9:37:04
	 * @param isInternal
	 * @return
	 */
	public List<GuidePriceBean> createDic(String isInternal) {
		// 服务类型字典
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
		return list;
	}
	
	/**
	 * @描述: 量价日历
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午8:37:13
	 * @param map
	 * @param bean
	 */
	public void getGuidePriceList(ModelMap map, GuidePriceBean bean) {
		
		// 导游ID
		Integer gdlId = bean.getGdlId();
		map.addAttribute("gdlId", gdlId);
		// 根据导游ID查询一条导游基础信息
		GuideDetailBean detialbean = guideDao.selectGuide(gdlId);
		// 服务类型
//		String isInternal = detialbean.getGdlServer();
//		map.addAttribute("isInternal", isInternal); // 服务类型
		
		// 当前年月
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		
		// 当前所选服务类型
//		String currService  = "";
//		if (isInternal != null && !"".equals(isInternal)) {
//			currService = isInternal.substring(0, 2);
//		}
//		bean.setGdlServiceCode(currService);
		// 执行查询
		List<GuidePriceBean> modelList = guidePriceDao.selectGuidePriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year); // 年
		map.addAttribute("month", month); // 月
		map.addAttribute("gdlServiceCode", bean.getGdlServiceCode());
		//map.addAttribute("serviceDic", createDic(isInternal)); // 服务类型字典
		//map.addAttribute("currService", currService); // 当前所选服务类型
		
	}
	
	/**
	 * @描述: 时间向前选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午8:41:27
	 * @param map
	 * @param bean
	 */
	public void forward(ModelMap map, GuidePriceBean bean) {
		// 当前年月
		String year = bean.getStart();
		String month = bean.getEnd();
		
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
		
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<GuidePriceBean> modelList = guidePriceDao.selectGuidePriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("gdlId", bean.getGdlId());
		// 服务类型编码
//		String isInternal = bean.getIsInternal();
//		map.addAttribute("isInternal", isInternal);
		// 生成字典
//		map.addAttribute("serviceDic", createDic(isInternal));
		// 当前所选服务
//		String code = bean.getGdlServiceCode();
//		map.addAttribute("currService", code);
		map.addAttribute("gdlServiceCode", bean.getGdlServiceCode());
		
	}
	
	/**
	 * @描述: 时间向后选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午8:51:21
	 * @param map
	 * @param bean
	 */
	public void backwards(ModelMap map, GuidePriceBean bean) {
		String year = bean.getStart();
		String month = bean.getEnd();
		
		// 转换到上个月
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
		
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<GuidePriceBean> modelList = guidePriceDao.selectGuidePriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("gdlId", bean.getGdlId());
		
		// 服务类型编码
//		String isInternal = bean.getIsInternal();
//		map.addAttribute("isInternal", isInternal);
		// 生成字典
//		map.addAttribute("serviceDic", createDic(isInternal));
		// 当前所选服务
//		String code = bean.getGdlServiceCode();
//		map.addAttribute("currService", code);
		map.addAttribute("gdlServiceCode", bean.getGdlServiceCode());
	}
	
	/**
	 * @描述: 选择服务类型
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午10:22:39
	 * @param map
	 * @param bean
	 */
	public void skipService(ModelMap map, GuidePriceBean bean) {
		String year = bean.getStart();
		String month = bean.getEnd();
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<GuidePriceBean> modelList = guidePriceDao.selectGuidePriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("gdlId", bean.getGdlId());
		
		// 服务类型编码
		String isInternal = bean.getIsInternal();
		map.addAttribute("isInternal", isInternal);
		// 生成字典
		map.addAttribute("serviceDic", createDic(isInternal));
		// 当前所选服务
		String code = bean.getGdlServiceCode();
		map.addAttribute("currService", code);
	}
	
	/**
	 * @描述: 生成日历
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午8:47:43
	 * @param modelList
	 * @param monthCount
	 * @param year
	 * @param month
	 * @return
	 */
	public List<GuidePriceBean> createCalendar(List<GuidePriceBean> modelList, String[] monthCount, String year, String month) {
		
		List<GuidePriceBean> list = new ArrayList<GuidePriceBean>(42);
		
		// 该月天数总计
		int monthNum = DateUtil.getMonthCount(year, month);
		
		// 日历-日号
		int j = 0;
		
		/*
		 * 根据年月，判断该月日历前，共有多少空格
		 */
		int weekCount = DateUtil.getWeekByDate(year, month);
		for (int i = 0; i < weekCount; i++) {
			// 填入空值
			list.add(i, new GuidePriceBean());
		}
		
		/*
		 * 处理查询的房量信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询的房量信息
			GuidePriceBean model = new GuidePriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 房量信息日期
				String hnpDate = model.getGpeDate();
				// 下标
				int index = j+weekCount;
				// 当前信息日期符合日历日期
				if (monthCount[j].equals(hnpDate)) {
					// 日历号
					String day = j + 1 + "";
					String dayStr = "";
					if((j + 1) < 10){
						dayStr = "0" + (j + 1);
					}else{
						dayStr = (j + 1)+"";
					}
					model.setDay(day);
					// 是否为今天
					if (DateUtil.getCuurentMonth().equals(month) && DateUtil.getCurrentDay().equals(dayStr)) {
						model.setIsUpdate(ErimConstants.YESORNO_YES);
					} else {
						model.setIsUpdate(ErimConstants.YESORNO_NO);
					}
					//是否可以预定 在预定时间内：1 超过预定时间：0
					Date thisDate = DateUtil.parseDate( year + "-" + month + "-" + dayStr, "yyyy-MM-dd");
					//当前循环到的日期和今天相差多少天
					Double differenceDay = Math.ceil((double)(thisDate.getTime() - new Date().getTime())/(24*60*60*1000));
					//相差天数和提前预定天数做比较
					if("02".equals(model.getGpeAppointType())){
						if(differenceDay - model.getGpeAppointNum() >= 0){
							//可以预定
							model.setIsPredetermine("1");
						}else{
							model.setIsPredetermine("0");
						}
					}else{
						model.setIsPredetermine("1");
					}
					list.add(index, model);
				} else {
					// 不符合
					i--;
					model = new GuidePriceBean();
					// 日历号
					String day = j + 1 + "";
					model.setDay(day);
					// 是否为今天
					if (DateUtil.getCuurentMonth().equals(month) && DateUtil.getCurrentDay().equals(day)) {
						model.setIsUpdate(ErimConstants.YESORNO_YES);
					} else {
						model.setIsUpdate(ErimConstants.YESORNO_NO);
					}
					list.add(index, model);
				}
				j++;
			}
		}
		
		/*
		 * 填充日历中剩余的格子
		 */
		// 日历中已有的格数
		int priceSize = list.size();
		// 剩余格数
		int blankCount = 42-priceSize;
		// 填入空值
		for (int i = 0; i < blankCount; i++) {
			// 下标
			int index = priceSize+i;
			GuidePriceBean model = new GuidePriceBean();
			// 日历
			if (j < monthNum) {
				// 日历号
				String day = j + 1 + "";
				model.setDay(day);
				// 是否为今天
				if (DateUtil.getCuurentMonth().equals(month) && DateUtil.getCurrentDay().equals(day)) {
					model.setIsUpdate(ErimConstants.YESORNO_YES);
				} else {
					model.setIsUpdate(ErimConstants.YESORNO_NO);
				}
				list.add(index, model);
				j++;
			} else {
				list.add(index, model);
			}
		}
		return list;
	}
	
	
public void getGuidePriceListDJ(ModelMap map, GuidePriceBean bean) {
		
		// 导游ID
		Integer gdlId = bean.getGdlId();
		map.addAttribute("gdlId", gdlId);
		// 根据导游ID查询一条导游基础信息
		GuideDetailBean detialbean = guideDao.selectGuide(gdlId);
		// 服务类型
		String isInternal = detialbean.getGdlServer();
		map.addAttribute("isInternal", isInternal); // 服务类型
		
		// 当前年月
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		
		// 当前所选服务类型
		String currService  = "";
		if (isInternal != null && !"".equals(isInternal)) {
			currService = isInternal.substring(0, 2);
		}
		bean.setGdlServiceCode(currService);
		// 执行查询
		List<GuidePriceBean> modelList = guidePriceDao.selectGuidePriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year); // 年
		map.addAttribute("month", month); // 月
		map.addAttribute("serviceDic", createDic(isInternal)); // 服务类型字典
		map.addAttribute("currService", currService); // 当前所选服务类型
		
	}
	
	/**
	 * @描述: 时间向前选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午8:41:27
	 * @param map
	 * @param bean
	 */
	public void forwardDJ(ModelMap map, GuidePriceBean bean) {
		// 当前年月
		String year = bean.getStart();
		String month = bean.getEnd();
		
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
		
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<GuidePriceBean> modelList = guidePriceDao.selectGuidePriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("gdlId", bean.getGdlId());
		// 服务类型编码
		String isInternal = bean.getIsInternal();
		map.addAttribute("isInternal", isInternal);
		// 生成字典
		map.addAttribute("serviceDic", createDic(isInternal));
		// 当前所选服务
		String code = bean.getGdlServiceCode();
		map.addAttribute("currService", code);
		
	}
	
	/**
	 * @描述: 时间向后选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午8:51:21
	 * @param map
	 * @param bean
	 */
	public void backwardsDJ(ModelMap map, GuidePriceBean bean) {
		String year = bean.getStart();
		String month = bean.getEnd();
		
		// 转换到上个月
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
		
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<GuidePriceBean> modelList = guidePriceDao.selectGuidePriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("gdlId", bean.getGdlId());
		
		// 服务类型编码
		String isInternal = bean.getIsInternal();
		map.addAttribute("isInternal", isInternal);
		// 生成字典
		map.addAttribute("serviceDic", createDic(isInternal));
		// 当前所选服务
		String code = bean.getGdlServiceCode();
		map.addAttribute("currService", code);
	}
	
	/**
	 * @描述: 选择服务类型
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午10:22:39
	 * @param map
	 * @param bean
	 */
	public void skipServiceDJ(ModelMap map, GuidePriceBean bean) {
		String year = bean.getStart();
		String month = bean.getEnd();
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<GuidePriceBean> modelList = guidePriceDao.selectGuidePriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("gdlId", bean.getGdlId());
		
		// 服务类型编码
		String isInternal = bean.getIsInternal();
		map.addAttribute("isInternal", isInternal);
		// 生成字典
		map.addAttribute("serviceDic", createDic(isInternal));
		// 当前所选服务
		String code = bean.getGdlServiceCode();
		map.addAttribute("currService", code);
	}
}
