package com.erim.sz.web.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GroundPriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.web.dao.GroundPriceDao;
import com.erim.sz.web.util.DateUtil;

/**
 * @描述: 当地游量价信息实体操作业务层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月28日 下午1:43:05
 */
@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GroundPriceService {

	@Autowired
	private GroundPriceDao groundPriceDao;
	
	/**
	 * @描述: 量价项
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月28日 下午1:51:28
	 * @param map
	 * @param bean
	 */
	public void getGroundPriceList(ModelMap map, GroundPriceBean bean) {
		
		// 当前年月
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		
		// 获取当月所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<GroundPriceBean> modelList = groundPriceDao.getGroundPriceList(bean, monthCount);
		
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("gdlId", bean.getGdlId());
	}
	
	/**
	 * @描述: 时间向前选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月28日 下午1:51:41
	 * @param map
	 * @param bean
	 */
	public void forward(ModelMap map, GroundPriceBean bean) {
		
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
		if (monthInt < 10) {
			month = "0" + Integer.toString(monthInt);
		} else {
			month = Integer.toString(monthInt);
		}
				
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<GroundPriceBean> modelList = groundPriceDao.getGroundPriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("gdlId", bean.getGdlId());
	}
	
	/**
	 * @描述: 时间向后选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月18日 下午4:29:51
	 * @param map
	 * @param bean
	 */
	public void backwards(ModelMap map, GroundPriceBean bean) {
		
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
		if (monthInt < 10) {
			month = "0" + Integer.toString(monthInt);
		} else {
			month = Integer.toString(monthInt);
		}
		
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<GroundPriceBean> modelList = groundPriceDao.getGroundPriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("gdlId", bean.getGdlId());
	}
	
	/**
	 * @描述: 生成日历
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月28日 下午1:53:47
	 * @param modelList
	 * @param monthCount
	 * @param year
	 * @param month
	 * @return
	 */
	public List<GroundPriceBean> createCalendar(List<GroundPriceBean> modelList, String[] monthCount, String year, String month) {
		
		List<GroundPriceBean> list = new ArrayList<GroundPriceBean>(42);
		
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
			list.add(i, new GroundPriceBean());
		}
		
		/*
		 * 处理查询的房量信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询的房量信息
			GroundPriceBean model = new GroundPriceBean();
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
					if(model.getGpeRestrict() != null){
						if(differenceDay - model.getGpeRestrict() >= 0){
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
					model = new GroundPriceBean();
					// 日历号
					String day = j + 1 + "";
					String dayStr = "";
					if((j + 1) < 10){
						dayStr = "0" + (j + 1);
					}
					model.setDay(day);
					// 是否为今天
					if (DateUtil.getCuurentMonth().equals(month) && DateUtil.getCurrentDay().equals(dayStr)) {
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
			GroundPriceBean model = new GroundPriceBean();
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
	public static void main(String args[]) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2016-01-03");
		double b = (double)(date.getTime() - new Date().getTime())/(24*60*60*1000);
		System.out.println(Math.ceil(b));
		
	}
	
	
}
