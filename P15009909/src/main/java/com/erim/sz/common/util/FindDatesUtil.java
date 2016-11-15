package com.erim.sz.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: FindDatesUtil
 * @Description: 时间段内所有日期
 * @author maoxian
 * @date 2015年10月5日 上午12:12:18
 */
public class FindDatesUtil {
	

	/**
	 * @Title: findDates 
	 * @Description: 获取时间段内所有日期 返回list
	 * @param @param dBegin
	 * @param @param dEnd
	 * @param @return    设定文件 
	 * @return List<Date>    返回类型 
	 * @throws
	 */
	public static List<Date> findDates(Date dBegin, Date dEnd) {
		List<Date> lDate = new ArrayList<Date>();
		lDate.add(dBegin);
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			lDate.add(calBegin.getTime());
		}
		return lDate;
	}
	
	/**
	 * @Title: main 
	 * @Description: 主方法  测试
	 * @param @param args
	 * @param @throws Exception    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public static void main(String[] args) throws Exception {
		String start = "2014-9-1";
		String end = "2014-10-8";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
		Date dBegin = sdf.parse(start);
		Date dEnd = sdf.parse(end);
		List<Date> lDate = findDates(dBegin, dEnd);
		for (Date date : lDate) {
			System.out.println(sdf.format(date));
		}
	}
}
