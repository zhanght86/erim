package com.erim.sz.cus.bean;

import java.io.Serializable;


public class CusSystemRoleFuncBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	//权限编码
	private String  cusFuncCode;
	//角色id
	private Integer cusRoleId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCusFuncCode() {
		return cusFuncCode;
	}
	public void setCusFuncCode(String cusFuncCode) {
		this.cusFuncCode = cusFuncCode;
	}
	public int getCusRoleId() {
		return cusRoleId;
	}
	public void setCusRoleId(int cusRoleId) {
		this.cusRoleId = cusRoleId;
	}
	
}
