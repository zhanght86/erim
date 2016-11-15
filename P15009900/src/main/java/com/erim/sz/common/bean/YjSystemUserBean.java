package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: CmsSystemUserBean 
 * @Description: 商户用户
 * @author maoxian
 * @date 2015年8月1日 上午11:20:33
 */
public class YjSystemUserBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//登录名
	private String  yjUserLoginname;
	//密码
	private String  yjUserPassword;
	//真实姓名
	private String  yjUserRealname;
	//联系方式
	private String  yjUserTel;
	//角色id
	private Integer yjRoleId;
	//上次登录时间
	private Date    yjLastLoginTime;
	//上次登录ip
	private String  yjLastLoginIp;
	//是否审核
	private String  yjIsThrough;
	//是否登陆
	private String  yjLastLoginAddress;
	
	//////////////////////////////////////// 自定义  start //////////////////////////////////////////
	//角色名称
	private String   yjRoleName;
	//公司ID
	private Integer  cpyId;
	//公司名称
	private String   cpyName;
	//用户的user_code
	private String yjUserCode;
	//用户的介绍人
	private String yjParentLoginname;
	//////////////////////////////////////// 自定义  end //////////////////////////////////////////	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYjUserLoginname() {
		return yjUserLoginname;
	}
	public void setYjUserLoginname(String yjUserLoginname) {
		this.yjUserLoginname = yjUserLoginname;
	}
	public String getYjUserPassword() {
		return yjUserPassword;
	}
	public void setYjUserPassword(String yjUserPassword) {
		this.yjUserPassword = yjUserPassword;
	}
	public String getYjUserRealname() {
		return yjUserRealname;
	}
	public void setYjUserRealname(String yjUserRealname) {
		this.yjUserRealname = yjUserRealname;
	}
	public String getYjUserTel() {
		return yjUserTel;
	}
	public void setYjUserTel(String yjUserTel) {
		this.yjUserTel = yjUserTel;
	}
	public Integer getYjRoleId() {
		return yjRoleId;
	}
	public void setYjRoleId(Integer yjRoleId) {
		this.yjRoleId = yjRoleId;
	}
	public Date getYjLastLoginTime() {
		return yjLastLoginTime;
	}
	public void setYjLastLoginTime(Date yjLastLoginTime) {
		this.yjLastLoginTime = yjLastLoginTime;
	}
	public String getYjLastLoginIp() {
		return yjLastLoginIp;
	}
	public void setYjLastLoginIp(String yjLastLoginIp) {
		this.yjLastLoginIp = yjLastLoginIp;
	}
	public String getYjIsThrough() {
		return yjIsThrough;
	}
	public void setYjIsThrough(String yjIsThrough) {
		this.yjIsThrough = yjIsThrough;
	}
	public String getYjRoleName() {
		return yjRoleName;
	}
	public void setYjRoleName(String yjRoleName) {
		this.yjRoleName = yjRoleName;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getCpyName() {
		return cpyName;
	}
	public void setCpyName(String cpyName) {
		this.cpyName = cpyName;
	}
	public String getYjLastLoginAddress() {
		return yjLastLoginAddress;
	}
	public void setYjLastLoginAddress(String yjLastLoginAddress) {
		this.yjLastLoginAddress = yjLastLoginAddress;
	}
	public String getYjUserCode() {
		return yjUserCode;
	}
	public void setYjUserCode(String yjUserCode) {
		this.yjUserCode = yjUserCode;
	}
	public String getYjParentLoginname() {
		return yjParentLoginname;
	}
	public void setYjParentLoginname(String yjParentLoginname) {
		this.yjParentLoginname = yjParentLoginname;
	}
	
}
