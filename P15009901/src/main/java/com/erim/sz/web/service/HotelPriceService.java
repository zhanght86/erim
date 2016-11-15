package com.erim.sz.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelPriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.web.dao.HotelPriceDao;
import com.erim.sz.web.util.DateUtil;

/**
 * @描述: 酒店量价信息实体操作业务层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月26日 下午5:00:28
 */
@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelPriceService {

	@Autowired
	private HotelPriceDao hotelPriceDao;
	
	/**
	 * @描述: 酒店量价列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月26日 下午5:00:14
	 * @param map
	 * @param bean
	 */
	public void getHotelPriceList(ModelMap map, HotelPriceBean bean) {
		
		// 当前年
		String year = DateUtil.getCuurentYear();
		// 当前月
		String month = DateUtil.getCuurentMonth();
		
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<HotelPriceBean> modelList = hotelPriceDao.getHotelPriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("hheId", bean.getHheId());
	}
	
	/**
	 * @描述: 时间向前选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月26日 下午10:32:46
	 * @param map
	 * @param bean
	 */
	public void forward(ModelMap map, HotelPriceBean bean) {
		
		String year = bean.getEnteringStart();
		String month = bean.getEnteringEnd();
		
		int yearInt = Integer.valueOf(year);
		int monthInt = Integer.valueOf(month);
		if (monthInt == 12) {
			yearInt++;
			monthInt = 1;
		} else {
			monthInt++;
		}
		year = Integer.toString(yearInt);
		
		if (monthInt < 10) {
			month = "0" + Integer.toString(monthInt);
		} else {
			month = Integer.toString(monthInt);
		}
				
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<HotelPriceBean> modelList = hotelPriceDao.getHotelPriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("hheId", bean.getHheId());
	}
	
	/**
	 * @描述: 时间向后选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月26日 下午10:50:03
	 * @param map
	 * @param bean
	 */
	public void backwards(ModelMap map, HotelPriceBean bean) {
		
		String year = bean.getEnteringStart();
		String month = bean.getEnteringEnd();
		
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
		if (monthInt < 10) {
			month = "0" + Integer.toString(monthInt);
		} else {
			month = Integer.toString(monthInt);
		}
		
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<HotelPriceBean> modelList = hotelPriceDao.getHotelPriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("hheId", bean.getHheId());
	}

	/**
	 * @描述: 生成酒店量价日历
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月26日 下午5:30:10
	 * @param modelList 量价数据列表
	 * @param monthCount 该月所有日期
	 * @param year 当前年
	 * @param month 当前月
	 * @return
	 */
	public List<HotelPriceBean> createCalendar(List<HotelPriceBean> modelList, String[] monthCount, String year, String month) {
		
		List<HotelPriceBean> list = new ArrayList<HotelPriceBean>(42);
		
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
			list.add(i, new HotelPriceBean());
		}
		
		/*
		 * 处理查询的房量信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询的房量信息
			HotelPriceBean model = new HotelPriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 房量信息日期
				String hnpDate = model.getHnpDate();
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
					//当前时间和提前预定时间比较
					if("01".equals(model.getHnpSellTime())){
						if(StringUtils.isNotEmpty(model.getHnpSellH())){
							Date thisDate = DateUtil.parseDate( year + "-" + month + "-" + dayStr + " " + model.getHnpSellH() , "yyyy-MM-dd HH:mm");
							if(thisDate.getTime() - new Date().getTime() >= 0){
								//可以预定
								model.setIsPredetermine("1");
							}else{
								model.setIsPredetermine("0");
							}
						}else{
							//可以预定
							model.setIsPredetermine("1");
						}
						
					}else{
						model.setIsPredetermine("1");
					}
					list.add(index, model);
				} else {
					// 不符合
					i--;
					model = new HotelPriceBean();
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
			HotelPriceBean model = new HotelPriceBean();
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
	
}
