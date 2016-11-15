package com.erim.sz.zy.bean;

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
public class ZySystemUserBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//登录名
	private String  zyUserLoginname;
	//密码
	private String  zyUserPassword;
	//真实姓名
	private String  zyUserRealname;
	//联系方式
	private String  zyUserTel;
	//角色id
	private Integer zyRoleId;
	//上次登录时间
	private Date    zyLastLoginTime;
	//上次登录ip
	private String  zyLastLoginIp;
	//是否审核
	private String  zyIsThrough;
	//上次登陆城市
	private String  zyLastLoginAddress;
	//是否合作用户
	private String  zyIsCooperation;
	//用户是否停用
	private String  zyIsDelStatus;
	
	//////////////////////////////////////// 自定义  start //////////////////////////////////////////
	//角色名称
	private String   zyRoleName;
	//公司ID
	private Integer  cpyId;
	//公司名称
	private String   cpyName;
	//公司Logo
	private String 	 cpyImg;
	// 公司品牌
	private String 	cpyBrand;
	
	//////////////////////////////////////// 自定义  end //////////////////////////////////////////	
	
	
	
	public Integer getId() {
		return id;
	}
	public String getCpyBrand() {
		return cpyBrand;
	}
	public void setCpyBrand(String cpyBrand) {
		this.cpyBrand = cpyBrand;
	}
	public String getCpyImg() {
		return cpyImg;
	}
	public void setCpyImg(String cpyImg) {
		this.cpyImg = cpyImg;
	}
	public String getZyIsDelStatus() {
		return zyIsDelStatus;
	}
	public void setZyIsDelStatus(String zyIsDelStatus) {
		this.zyIsDelStatus = zyIsDelStatus;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZyUserLoginname() {
		return zyUserLoginname;
	}
	public void setZyUserLoginname(String zyUserLoginname) {
		this.zyUserLoginname = zyUserLoginname;
	}
	public String getZyUserPassword() {
		return zyUserPassword;
	}
	public void setZyUserPassword(String zyUserPassword) {
		this.zyUserPassword = zyUserPassword;
	}
	public String getZyUserRealname() {
		return zyUserRealname;
	}
	public void setZyUserRealname(String zyUserRealname) {
		this.zyUserRealname = zyUserRealname;
	}
	public String getZyUserTel() {
		return zyUserTel;
	}
	public void setZyUserTel(String zyUserTel) {
		this.zyUserTel = zyUserTel;
	}
	public Integer getZyRoleId() {
		return zyRoleId;
	}
	public void setZyRoleId(Integer zyRoleId) {
		this.zyRoleId = zyRoleId;
	}
	public Date getZyLastLoginTime() {
		return zyLastLoginTime;
	}
	public void setZyLastLoginTime(Date zyLastLoginTime) {
		this.zyLastLoginTime = zyLastLoginTime;
	}
	public String getZyLastLoginIp() {
		return zyLastLoginIp;
	}
	public void setZyLastLoginIp(String zyLastLoginIp) {
		this.zyLastLoginIp = zyLastLoginIp;
	}
	public String getZyIsThrough() {
		return zyIsThrough;
	}
	public void setZyIsThrough(String zyIsThrough) {
		this.zyIsThrough = zyIsThrough;
	}
	public String getZyRoleName() {
		return zyRoleName;
	}
	public void setZyRoleName(String zyRoleName) {
		this.zyRoleName = zyRoleName;
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
	public String getZyLastLoginAddress() {
		return zyLastLoginAddress;
	}
	public void setZyLastLoginAddress(String zyLastLoginAddress) {
		this.zyLastLoginAddress = zyLastLoginAddress;
	}
	public String getZyIsCooperation() {
		return zyIsCooperation;
	}
	public void setZyIsCooperation(String zyIsCooperation) {
		this.zyIsCooperation = zyIsCooperation;
	}
	
}
