package com.erim.sz.system.bean;

import java.io.Serializable;

/**
 * 
 * @ClassName: YjSystemFuncRescource 
 * @Description: 角色权限
 * @author maoxian
 * @date 2015年8月2日 上午12:54:07
 */
public class YjSystemFuncRescourceBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//编码
	private String  yjFuncCode;
	private String  yjFuncRescourceCode;
	//操作名称
	private String  yjFuncRescourceName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYjFuncCode() {
		return yjFuncCode;
	}
	public void setYjFuncCode(String yjFuncCode) {
		this.yjFuncCode = yjFuncCode;
	}
	public String getYjFuncRescourceCode() {
		return yjFuncRescourceCode;
	}
	public void setYjFuncRescourceCode(String yjFuncRescourceCode) {
		this.yjFuncRescourceCode = yjFuncRescourceCode;
	}
	public String getYjFuncRescourceName() {
		return yjFuncRescourceName;
	}
	public void setYjFuncRescourceName(String yjFuncRescourceName) {
		this.yjFuncRescourceName = yjFuncRescourceName;
	}
	
}
