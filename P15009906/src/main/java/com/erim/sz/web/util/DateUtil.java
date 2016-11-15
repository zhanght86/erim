package com.erim.sz.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 
 * @ClassName: DateUtil 
 * @Description: 日期工具类 
 * @author maoxian
 * @date 2015年8月16日 下午11:36:33 
 *
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
	
}
