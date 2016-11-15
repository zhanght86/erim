package com.erim.sz.system.bean;

import java.io.Serializable;


public class YjSystemRoleFuncBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	//权限编码
	private String  yjFuncCode;
	//角色id
	private Integer yjRoleId;
	
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
	public Integer getYjRoleId() {
		return yjRoleId;
	}
	public void setYjRoleId(Integer yjRoleId) {
		this.yjRoleId = yjRoleId;
	}
}
