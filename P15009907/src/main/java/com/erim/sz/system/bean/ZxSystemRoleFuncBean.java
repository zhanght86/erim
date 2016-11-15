package com.erim.sz.system.bean;

import java.io.Serializable;


public class ZxSystemRoleFuncBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	//权限编码
	private String  zxFuncCode;
	//角色id
	private Integer zxRoleId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZxFuncCode() {
		return zxFuncCode;
	}
	public void setZxFuncCode(String zxFuncCode) {
		this.zxFuncCode = zxFuncCode;
	}
	public int getZxRoleId() {
		return zxRoleId;
	}
	public void setZxRoleId(int zxRoleId) {
		this.zxRoleId = zxRoleId;
	}
	
}
