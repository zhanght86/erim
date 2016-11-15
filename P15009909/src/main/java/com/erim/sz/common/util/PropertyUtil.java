package com.erim.sz.common.util;

import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;

/**
 * @ClassName: PropertyUtil 
 * @Description: 解析bean 
 * @author maoxian
 * @date 2016年1月5日 下午5:29:55
 */
public class PropertyUtil {

	/**
	 * @Title: getProperty 
	 * @Description: 通过域名取得bean值
	 * @param @param bean
	 * @param @param fieldName
	 * @param @return    设定文件 
	 * @return Object    返回类型 
	 * @author maoxian
	 * @date 2015年12月23日 下午11:13:58 
	 * @throws
	 */
	@SuppressWarnings("unused")
	private static String getProperty(Object bean, String fieldName) {  
	    Field[] fields = bean.getClass().getDeclaredFields();
	    Field.setAccessible(fields, true);     
	    Object obj = null;  
	    for (int i = 0; i < fields.length; i++) {  
	        Field field = fields[i];  
	        if (fieldName.equals(field.getName())) {  
	            try {  
	                obj = field.get(bean);  
	            } catch (Exception e) {  
	            	System.out.println(e);
	            }  
	        }  
	    }  
	    return null==obj?"":obj.toString();   
	}  
	
	/**
	 * @Title: getObject 
	 * @Description: 解析bean
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Object    返回类型 
	 * @author maoxian
	 * @date 2016年1月5日 下午5:31:04 
	 * @throws
	 */
	public static String getObject(Object bean){
		StringBuffer sb = new StringBuffer();
		
		Field[] fields = bean.getClass().getDeclaredFields();
	    Field.setAccessible(fields, true);     
	    for (int i = 0; i < fields.length; i++) {  
	    	try {
		        Field field = fields[i];  
		        String sName = field.getName();
		        Object o     = (Object)field.get(bean);
		        if(null != o && !"serialVersionUID".equals(sName)){
					sb.append("&"+sName+"="+field.get(bean));
		        }
	    	} catch (Exception e) {  
            	System.out.println(e);
            }  
	    }  
		return sb.toString();
	} 
}
