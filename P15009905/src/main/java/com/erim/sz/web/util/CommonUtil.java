package com.erim.sz.web.util;

import org.apache.log4j.Logger;

/**
 * @ClassName: CommonUtil 
 * @Description: 工具类 
 * @author maoxian
 * @date 2015年8月20日 下午3:16:33 
 *
 */
public class CommonUtil {

	//声明日志
	private static Logger logger = Logger.getLogger(CommonUtil.class);
	//操作成功返回1
	public static Integer SUCCESS = 1;
	//操作失败返回0
	public static Integer ERROR   = 0;
	
	/**
	 * 
	 * @Title: error 
	 * @Description: 失败
	 * @param @param cls    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public static Integer error(Class<?> cls,Exception e){
		logger = Logger.getLogger(cls);
		logger.error(e);
		return CommonUtil.ERROR;
	}
}
