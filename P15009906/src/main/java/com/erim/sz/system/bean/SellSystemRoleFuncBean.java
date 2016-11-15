package com.erim.sz.system.bean;

import java.io.Serializable;


public class SellSystemRoleFuncBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	//权限编码
	private String  sellFuncCode;
	//角色id
	private Integer sellRoleId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSellFuncCode() {
		return sellFuncCode;
	}
	public void setSellFuncCode(String sellFuncCode) {
		this.sellFuncCode = sellFuncCode;
	}
	public Integer getSellRoleId() {
		return sellRoleId;
	}
	public void setSellRoleId(Integer sellRoleId) {
		this.sellRoleId = sellRoleId;
	}
}
