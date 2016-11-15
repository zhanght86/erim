package com.erim.sz.zy.bean;

import java.io.Serializable;


public class ZySystemRoleFuncBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	//权限编码
	private String  zyFuncCode;
	//角色id
	private Integer zyRoleId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZyFuncCode() {
		return zyFuncCode;
	}
	public void setZyFuncCode(String zyFuncCode) {
		this.zyFuncCode = zyFuncCode;
	}
	public int getZyRoleId() {
		return zyRoleId;
	}
	public void setZyRoleId(int zyRoleId) {
		this.zyRoleId = zyRoleId;
	}
	
}
