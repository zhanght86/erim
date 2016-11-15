package com.erim.sz.system.bean;

import java.io.Serializable;

/**
 * 
 * @ClassName: ZxSystemFuncRescource 
 * @Description: 角色权限
 * @author maoxian
 * @date 2015年8月2日 上午12:54:07
 */
public class ZxSystemFuncRescourceBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//编码
	private String  ZxFuncCode;
	private String  ZxFuncRescourceCode;
	//操作名称
	private String  ZxFuncRescourceName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZxFuncCode() {
		return ZxFuncCode;
	}
	public void setZxFuncCode(String ZxFuncCode) {
		this.ZxFuncCode = ZxFuncCode;
	}
	public String getZxFuncRescourceCode() {
		return ZxFuncRescourceCode;
	}
	public void setZxFuncRescourceCode(String ZxFuncRescourceCode) {
		this.ZxFuncRescourceCode = ZxFuncRescourceCode;
	}
	public String getZxFuncRescourceName() {
		return ZxFuncRescourceName;
	}
	public void setZxFuncRescourceName(String ZxFuncRescourceName) {
		this.ZxFuncRescourceName = ZxFuncRescourceName;
	}
	
}
