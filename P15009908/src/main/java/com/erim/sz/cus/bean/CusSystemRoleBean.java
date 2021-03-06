package com.erim.sz.cus.bean;

import java.io.Serializable;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: CusSystemRoleBean 
 * @Description: 商户角色bean
 * @author maoxian
 * @date 2015年8月1日 下午12:52:54
 */
public class CusSystemRoleBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//角色中文
	private String  cusRoleName;
	//企业id
	private Integer cpyId;
	//是否合作用户
	private String  cusRoleIsCooperation;
	
	//是否审核通过 0否 1是
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCusRoleName() {
		return cusRoleName;
	}
	public void setCusRoleName(String cusRoleName) {
		this.cusRoleName = cusRoleName;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getCusRoleIsCooperation() {
		return cusRoleIsCooperation;
	}
	public void setCusRoleIsCooperation(String cusRoleIsCooperation) {
		this.cusRoleIsCooperation = cusRoleIsCooperation;
	}
}
