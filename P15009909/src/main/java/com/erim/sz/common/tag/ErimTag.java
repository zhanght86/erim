package com.erim.sz.common.tag;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.config.ValidScope;

/**
 * 
 * @ClassName: ErimTag 
 * @Description: erim常用标签
 * @author maoxian
 * @date 2015年8月28日 下午5:34:41 
 *
 */
@DefaultKey("erim")
@ValidScope(Scope.APPLICATION)
public class ErimTag {

	/**
	 * 
	 * @Title: contains 
	 * @Description: 是否包含  key中是否包含 value
	 * @param @param key
	 * @param @param value
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean contains(String key,String value){
		return StringUtils.isNotBlank(key)&&StringUtils.isNotBlank(value)?key.contains(value):false;
	}
	
	/**
	 * @Title: nowDate 
	 * @Description: 档期日期
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public String nowDate(){
		return new SimpleDateFormat("yyyy-MM-dd E").format(new Date());
	}
	
	public static void main(String[] args) {
		System.out.println( new SimpleDateFormat("yyyy-MM-dd EEEE").format(new Date()));
		System.out.println( new SimpleDateFormat("yyyy-MM-dd E").format(new Date()));
		System.out.println(new Date());
	}
	/**
	 * @Title: emptyDefault 
	 * @Description: 当key为空时取value值
	 * @param @param key
	 * @param @param value
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public Object emptyDefault(Object key,Object value){
		if(null == key || "" == key ) return value;
		return StringUtils.isNotBlank(key.toString())?key:value;
	}
	
	/**
	 * @Title: splitObject 
	 * @Description: 字符串分割成数组
	 * @param @param key  要分割的字符串
	 * @param @param ed   分隔符
	 * @param @return    设定文件 
	 * @return String[]    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 下午9:58:12 
	 * @throws
	 */
	public String[] split(String key,String ed){
		return key.split(ed);
	}
	
	/**
	 * @Title: splitReplaceSame 
	 * @Description: 分割字符串去重 返回set集合
	 * @param @param key
	 * @param @param ed
	 * @param @return    设定文件 
	 * @return Set<String>    返回类型 
	 * @author maoxian
	 * @date 2016年1月3日 下午5:45:32 
	 * @throws
	 */
	public Set<String> splitReplaceSame(String key,String ed){
		Set<String> set = new HashSet<String>();
		if("+".equals(ed)) ed = "[+]";
		String[] akey = key.split(ed);
		for(String ak : akey){
			if(StringUtils.isNotBlank(ak)){
				set.add(ak);
			}
		}
		return set;
	}
	
	/**
	 * @Title: isNotEmptyList 
	 * @Description: 判断数组是否为空
	 * @param @param list
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @author maoxian
	 * @date 2015年12月2日 上午11:07:00 
	 * @throws
	 */
	public boolean isNotEmptyList(List<?> list){
		return null != list && list.size()>0?true:false;
	}
	
	/**
	 * @Title: subString 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param remark  内容
	 * @param @param length  截取长度
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public String subString(String remark,Integer length){
		if(StringUtils.isNotBlank(remark)){
			if(remark.length()>length){
				return remark.substring(0, length)+"...";
			}else{
				return remark;
			}
		}
		return "";
	}
	
	/**
	 * @Title: isNotEmpty 
	 * @Description: 判断是否为空
	 * @param @param val
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @author maoxian
	 * @date 2015年12月1日 下午2:18:15 
	 * @throws
	 */
	public boolean isNotEmpty(Object obj){
		return null != obj ? !"".equals(obj) ? true : false : false;
	}
	
	/**
	 * @Title: isEmpty 
	 * @Description: 判断为空
	 * @param @param val
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @author maoxian
	 * @date 2015年12月1日 下午2:18:56 
	 * @throws
	 */
	public boolean isEmpty(Object obj){
		return !this.isNotEmpty(obj);
	}
}