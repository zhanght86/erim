package com.erim.sz.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * @类名: DateUtil
 * @描述: 日期工具类
 * @作者: 宁晓强
 * @创建时间: 2015年12月22日 下午3:21:31
 */
public class DateUtil {

	/**
	 * 声明日志
	 */
	private static Logger logger = Logger.getLogger(DateUtil.class);

	//格式化星期
	private static SimpleDateFormat dateEEEE = new SimpleDateFormat("EEEE");
	
	/**
	 * 
	 * @Title: formdate 
	 * @Description: 转换日期格式
	 * @param @param formdate
	 * @param @param date
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String formatDate(String formatdate,Date date){
		return new SimpleDateFormat(formatdate).format(date);
	}
	
	/**
	 * 
	 * @Title: formatDate 
	 * @Description: 转换日期格式
	 * @param @param formatdate
	 * @param @param date
	 * @param @return    设定文件 
	 * @return Date    返回类型 
	 * @throws
	 */
	public static Date formatDate(String formatdate,String date){
		try {
			return new SimpleDateFormat(formatdate).parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.error("日期转换出错" + e);
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: nextDay 
	 * @Description: 从nowdate起  往后数num天
	 * @param @param nowDate       计算时间
	 * @param @param num		         相差天数
	 * @param @param returnFormat  返回天数类型 yyyy-MM-dd
	 * @param @param bolWeek       是否包含日期
	 * @param @return    设定文件 
	 * @return String[]    返回类型 
	 * @throws
	 */
	public static String[] nextDay(String nowDate,int num,String returnFormat,boolean bolWeek){
		//如果为空 默认为今天
		if(StringUtils.isBlank(nowDate)) nowDate = DateUtil.formatDate("yyyy-MM-dd", new Date());

		//返回日期
		String[] astrDate = new String[num];
		//日历类
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtil.formatDate("yyyy-MM-dd", nowDate));
		
		for(int i = 0; i< num; i++){
			//设置日期+i
			cal.add(Calendar.DAY_OF_YEAR,1);
			
			//是否显示日历 yyyy-mm-dd(星期一)
			if(bolWeek){
				astrDate[i] = DateUtil.formatDate(returnFormat, cal.getTime())+"("+dateEEEE.format(cal.getTime())+")";
			}else{
				astrDate[i] = DateUtil.formatDate(returnFormat, cal.getTime()); 
			}
		}
		
		return astrDate;
	}
	
	/**
	 * @Title: getListByNextDay 
	 * @Description: 从今天起 后9天
	 * @param @return    设定文件 
	 * @return List<String,String>    返回类型 
	 * @throws
	 */
	public static Map<String,String> getListByNextDay(){
		
		//声明数组
		Map<String,String> map = new HashMap<String,String>();
		//日历类
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		//9天
		for(int i = 0; i< 9; i++){
			//设置日期+i
			cal.add(Calendar.DAY_OF_YEAR,1);
			map.put(DateUtil.formatDate("yyyy-MM-dd", cal.getTime()), DateUtil.formatDate("MM-dd(EEEE)", cal.getTime()));
		}
		return map;
	}
	
	/**
	 * @描述: 获取当天日期
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月29日 下午5:53:27
	 * @return
	 */
	public static String getCuurentDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	/**
	 * @描述: 获取当前时间
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月1日 下午2:38:13
	 * @return
	 */
	public static String getCuurentTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * @方法名: getCuurentYear
	 * @描述: 获取当前年份
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月5日 下午4:33:34 
	 * @return
	 */
	public static String getCuurentYear() {
		return new SimpleDateFormat("yyyy").format(new Date());
	}
	
	/**
	 * @方法名: getCuurentMonth
	 * @描述: 获取当前月份
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月5日 下午4:34:21 
	 * @return
	 */
	public static String getCuurentMonth() {
		return new SimpleDateFormat("MM").format(new Date());
	}
	
	/**
	 * @描述: 获取当前日号
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午5:06:45
	 * @return
	 */
	public static String getCurrentDay() {
		return new SimpleDateFormat("dd").format(new Date());
	}
	
	/**
	 * @方法名: MonthForward
	 * @描述: 转换到下一月
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月5日 下午5:11:37 
	 * @param year 年份
	 * @param month 月份
	 * @return
	 */
	public static void monthForward(String year, String month) {
		
		if (year == null || "".equals(year)) {
			return;
		}
		if (month == null || "".equals(month)) {
			return;
		}
		
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
	}
	
	/**
	 * @方法名: monthBackwards
	 * @描述: 转换到上一月
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月6日 上午11:52:44 
	 * @param year
	 * @param month
	 */
	public static void monthBackwards(String year, String month) {
		
		if (year == null || "".equals(year)) {
			return;
		}
		if (month == null || "".equals(month)) {
			return;
		}
		
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
	}
	
	/**
	 * @方法名: getCountByStartEnd
	 * @描述: 根据开始日期和结束日期得到之间所有日期
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月6日 下午2:02:01 
	 * @param start 开始日期
	 * @param end 结束日期
	 * @return 之间所有日期
	 */
	public static String[] getCountByStartEnd(String start, String end) {
		
		String[] astrDate = null;
		try {
			
			Date startDate = formatDate("yyyy-MM-dd HH:mm:ss", start + " 00:00:00");
			Date endDate = formatDate("yyyy-MM-dd HH:mm:ss", end + " 00:00:00");
			Long a = (endDate.getTime() - startDate.getTime()) / (86400 * 1000);
			
			// 所得天数
			int day =  a.intValue();
			//返回日期
			astrDate = new String[++day];
			//日历类
			Calendar cal = Calendar.getInstance();
			cal.setTime(DateUtil.formatDate("yyyy-MM-dd", start));
			
			astrDate[0] = start;
			
			for(int i = 1; i < day; i++){
				//设置日期+i
				cal.add(Calendar.DAY_OF_YEAR,1);
				astrDate[i] = DateUtil.formatDate("yyyy-MM-dd", cal.getTime()); 
			}
		} catch (Exception e) {
			astrDate = new String[0];
		}
		return astrDate;
	}
	
	/**
	 * @方法名: getWeekByDate
	 * @描述: 根据日期返回是周几
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月6日 下午2:35:00 
	 * @param dateStr yyyy-MM-dd格式
	 * @return 周几
	 */
	public static String getWeekByDate(String dateStr) {
		
		String week = "";
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			int w = c.get(Calendar.DAY_OF_WEEK);
			if (w == 1) {
				w = 7;
			} else {
				w--;
			}
			week = w + "";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return week;
	}
	
	/**
	 * @方法名: getMonthCountByYearMonth
	 * @描述: 获取指定月份的所有日期及天数
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月8日 上午10:16:18 
	 * @param year 年
	 * @param month 月
	 * @return
	 */
	public static String[] getMonthCountByYearMonth(String year, String month) {
		
		int count = 0;
		
		if (year == null || "".equals(year)) {
			// 为null时默认为当前年
			year = getCuurentYear();
		}
		if (month == null || "".equals(month)) {
			// 为null时默认为当前月
			month = getCuurentMonth();
		}
		Integer intYear = Integer.valueOf(year);
		Integer intMonth = Integer.valueOf(month);
		
		Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, intYear);  
        a.set(Calendar.MONTH, intMonth - 1);  
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        count = a.get(Calendar.DATE);
        String nowDate = year + "-" + month + "-01";
		
        String[] strList = new String[count];
        //日历类
  		Calendar cal = Calendar.getInstance();
  		cal.setTime(DateUtil.formatDate("yyyy-MM-dd", nowDate));
  		strList[0] = nowDate;
  		for(int i = 1; i< count; i++){
  			//设置日期+i
  			cal.add(Calendar.DAY_OF_YEAR,1);
  			strList[i] = DateUtil.formatDate("yyyy-MM-dd", cal.getTime()); 
  		}
		return strList;
	}
	
	/**
	 * @方法名: getMonthCount
	 * @描述: 获取指定月份的天数
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月9日 上午11:47:45 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMonthCount(String year, String month) {
		
		int count = 0;
		if (year == null || "".equals(year)) {
			return 0;
		}
		if (month == null || "".equals(month)) {
			return 0;
		}
		Integer intYear = Integer.valueOf(year);
		Integer intMonth = Integer.valueOf(month);
		
		Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, intYear);  
        a.set(Calendar.MONTH, intMonth - 1);  
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        count = a.get(Calendar.DATE);
        
        return count;
	}

	/**
	 * @方法名: getWeekByDate
	 * @描述: 根据年月获取在日历中，前面有多少空格
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月8日 上午10:46:11 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getWeekByDate(String year, String month) {
		
		String dateStr = year + "-" + month + "-01";
		int week = 0;
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			int w = c.get(Calendar.DAY_OF_WEEK);
			if (w == 1) {
				w = 7;
			} else {
				w--;
			}
			week = --w;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return week;
	}
	
	/**
	 * @方法名: getCheckDateUpdate
	 * @描述: 判断当前日期是否已过去
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月2日 下午5:45:49 
	 * @param date 日期
	 * @return 已过去的日期返回false,当下和未来的日期返回true
	 */
	public static boolean getCheckDateUpdate(String dateStr) {
		String dateS = dateStr + " 23:59:00";
		boolean bl = true;
		try {
			// 数据日期
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateS);
			// 当前日期
			Date curDate = new Date();
			
			// 数据日期小于实际日期
			if (date.getTime() < curDate.getTime()) {
				return false;
			} else {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return bl;
	}
}
