package com.erim.sz.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: PayNoUtil 
 * @Description: 各类支付订单号生成规则
 * @author maoxian
 * @date 2015年12月5日 上午1:19:51
 */
public class PayNoUtil {

	/**
	 * @Title: getPayService 
	 * @Description: 服务费
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月5日 上午1:20:31 
	 * @throws
	 */
	public static String getPayService(Integer cpyId){
		int intIndex = 19910418;
		intIndex = intIndex + cpyId;
		
		int randomi = new java.util.Random().nextInt(900)+100;
		
		
		return "L" + PayNoUtil.getTime() + intIndex + randomi;
	}
	
	public static void main(String[] args) {
		int randomi = new java.util.Random().nextInt(900)+100;
		int intIndex = 19910418;
		
		System.out.println("L" + PayNoUtil.getTime() + intIndex + randomi);
	}
	
	/**
	 * @Title: getNowDate 
	 * @Description: 获取当前时间
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月5日 上午1:27:38 
	 * @throws
	 */
	public static String getNowDate(){
		return new SimpleDateFormat("ddMMyyyy").format(new Date());
	}
	
	/**
	 * @Title: getTime 
	 * @Description: 获取时间戳
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月5日 上午1:29:19 
	 * @throws
	 */
	public static long getTime(){
		return new Date().getTime();
	}
}
