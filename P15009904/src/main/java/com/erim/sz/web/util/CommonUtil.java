package com.erim.sz.web.util;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;

import com.erim.sz.common.bean.CompanyBusinessBean;

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
	
	// 用户名存在，请重新输入
	public static Integer USERREPETITION = 10;
	// 量价管理-没有可添加的日期
	public static Integer NOTHAVE = 20;
	// 酒店管理 - 量价管理 - 请先添加房型信息
	public static Integer NOTROOM = 30;
	// 酒店管理 - 量价管理 - 该酒店没有房型信息
	public static Integer HOTELNOTROOM = 31;
	// 同业资源景点 - 量价管理 - 该景点没有量价信息
	public static Integer TICKETNOTCLASS = 32;
	// 同业资源特色餐 - 量价管理 - 该特色餐没有量价信息
	public static Integer CAFETERIANOTPACKAGE = 33;
	// 同业资源租车 - 量价信息 - 该出租车没有量价信息
	public static Integer TEXINOTPRICE = 34;
	// 导游管理 - 量价信息 - 该导游没有量价信息
	public static Integer GUIDENOTPRICE = 35;
	
	/**
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
	 * @Title: business 
	 * @Description: 公司可服务范围 
	 * @param @return    设定文件 
	 * @return CompanyBusinessBean    返回类型 
	 * @author maoxian
	 * @date 2015年12月2日 下午7:22:19 
	 * @throws
	 */
	public static CompanyBusinessBean getCpyBusiness(){
		return (CompanyBusinessBean)SecurityUtils.getSubject().getSession().getAttribute("userBussiness");
	}
	
	/**
	 * @Title: getCooperation 
	 * @Description: 是否共享
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getCooperation(){
		return (String)SecurityUtils.getSubject().getSession().getAttribute("userIsCooperation");
	}
	
	/**
	 * @Title: getRoleId 
	 * @Description: 获取当前角色id
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static Integer getRoleId(){
		return (Integer)SecurityUtils.getSubject().getSession().getAttribute("userRoleId");
	}
	
	
	/**
	 * @Title: nowDate 
	 * @Description: 获取当前时间 yyyy-MM-dd HH:mm:ss
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getNowDate(){
		return DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", new Date());
	}
	
	/**
	 * 
	 * @Title: changetoString 
	 * @Description: 数组转成字符串
	 * @param @param ary
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String changetoString(String[] ary){
		StringBuffer sb = new StringBuffer();
		if(null != ary && ary.length>0){
			for(int i = 0; i < ary.length; i++){
				sb. append(ary[i]).append(",");
			}
			if(sb.lastIndexOf(",") == sb.length()-1){
				sb = sb.deleteCharAt(sb.length()-1);
			}

		}
		return sb.toString();
	}
}
