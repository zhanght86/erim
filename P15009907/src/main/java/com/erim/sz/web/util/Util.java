package com.erim.sz.web.util;

/**
 * 
 * @类名: Util
 * @描述: 08项目公共方法
 * @作者: 宁晓强
 * @创建时间: 2015年10月17日 下午1:49:24
 *
 */
public class Util {

	/**
	 * 
	 * @方法名: isAllowAdd
	 * @描述: 判断当前日期是否符合按周选择-量价管理中使用
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午1:50:02 
	 * @param hnpWeek
	 * @param week
	 * @return
	 *
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
}
