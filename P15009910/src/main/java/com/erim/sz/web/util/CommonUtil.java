package com.erim.sz.web.util;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;

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
	
	/**
	 * @Title: cpyId 
	 * @Description: 获取当前用户企业id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public static Integer getCpyId(){
		return (Integer)SecurityUtils.getSubject().getSession().getAttribute("userCpyId");
	}
	
	/**
	 * @Title: getLoginName 
	 * @Description: 获取当前用户登录名
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getLoginName(){
		return (String)SecurityUtils.getSubject().getSession().getAttribute("userName");
	}
	
	/**
	 * @Title: getYjUserCode 
	 * @Description: 获取当前用户编码
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月17日 下午11:37:25 
	 * @throws
	 */
	public static String getYjUserCode(){
		return (String)SecurityUtils.getSubject().getSession().getAttribute("yjUserCode");
	}
}
