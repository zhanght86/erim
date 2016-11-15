package com.erim.sz.web.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.ui.ModelMap;

/**
 * @描述: 量价专用工具包
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月16日 下午5:38:19
 */
public class PriceUtil {

	/**
	 * @描述: 获取首条数据的年月
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月16日 下午5:37:33
	 * @param date
	 * @param map
	 */
	public static void getFirstDate(String date, ModelMap map) {
		if (date != null && !"".equals(date)) {
			// 获取该日期的年月
			String year = date.substring(0, 4);
			String month = date.substring(5, 7);
			
			SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
			SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		}
	}
	
	/**
	 * @方法名: isAllowAdd
	 * @描述: 判断当前日期是否符合按周选择-量价管理中使用
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午1:50:02 
	 * @param hnpWeek
	 * @param week
	 * @return
	 */
	public static boolean isAllowAdd(String hnpWeek, String week) {
		// 星期等于null，直接返回允许
		if (hnpWeek == null || hnpWeek == "" ) {
			return true;
		}
		// 分解允许录入的星期
		String[] weekLi = hnpWeek.split(",");
		for (int i = 0; i < weekLi.length; i++) {
			// 允许录入的星期
			String weekStr = weekLi[i];
			// 当选择0, 每个星期都可以录入
			if ("0".equals(weekStr)) {
				return true;
			}
			// 当前日期符合当前选择的星期
			if (week.equals(weekStr)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @描述: 时间向前
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月18日 下午3:35:30
	 * @param year
	 * @param month
	 * @return
	 */
	public static Map<String, Object> dateForward(String year, String month) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
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
		
		map.put("year", year);
		map.put("month", month);
		return map;
	}
	
	/**
	 * @描述: 时间向后
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月18日 下午3:43:29
	 * @param year
	 * @param month
	 * @return
	 */
	public static Map<String, Object> dateBackwards(String year, String month) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
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
		map.put("year", year);
		map.put("month", month);
		
		return map;
	}
}
