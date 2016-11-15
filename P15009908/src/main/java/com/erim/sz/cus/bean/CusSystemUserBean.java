package com.erim.sz.cus.bean;

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
public class CusSystemUserBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//登录名
	private String  cusUserLoginname;
	//密码
	private String  cusUserPassword;
	//真实姓名
	private String  cusUserRealname;
	//联系方式
	private String  cusUserTel;
	//角色id
	private Integer cusRoleId;
	//上次登录时间
	private Date    cusLastLoginTime;
	//上次登录ip
	private String  cusLastLoginIp;
	//是否审核
	private String  cusIsThrough;
	//上次登陆城市
	private String  cusLastLoginAddress;
	//是否合作用户
	private String  cusIsCooperation;
	//用户是否停用
	private String  cusIsDelStatus;
	
	//////////////////////////////////////// 自定义  start //////////////////////////////////////////
	//角色名称
	private String   cusRoleName;
	//公司ID
	private Integer  cpyId;
	//公司名称
	private String   cpyName;
	//公司Logo
	private String 	 cpyImg;
	// 公司品牌
	private String 	 cpyBrand;
	//是否付费
	private String   pseIsSx;
	
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
	public String getCusIsDelStatus() {
		return cusIsDelStatus;
	}
	public void setCusIsDelStatus(String cusIsDelStatus) {
		this.cusIsDelStatus = cusIsDelStatus;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCusUserLoginname() {
		return cusUserLoginname;
	}
	public void setCusUserLoginname(String cusUserLoginname) {
		this.cusUserLoginname = cusUserLoginname;
	}
	public String getCusUserPassword() {
		return cusUserPassword;
	}
	public void setCusUserPassword(String cusUserPassword) {
		this.cusUserPassword = cusUserPassword;
	}
	public String getCusUserRealname() {
		return cusUserRealname;
	}
	public void setCusUserRealname(String cusUserRealname) {
		this.cusUserRealname = cusUserRealname;
	}
	public String getCusUserTel() {
		return cusUserTel;
	}
	public void setCusUserTel(String cusUserTel) {
		this.cusUserTel = cusUserTel;
	}
	public Integer getCusRoleId() {
		return cusRoleId;
	}
	public void setCusRoleId(Integer cusRoleId) {
		this.cusRoleId = cusRoleId;
	}
	public Date getCusLastLoginTime() {
		return cusLastLoginTime;
	}
	public void setCusLastLoginTime(Date cusLastLoginTime) {
		this.cusLastLoginTime = cusLastLoginTime;
	}
	public String getCusLastLoginIp() {
		return cusLastLoginIp;
	}
	public void setCusLastLoginIp(String cusLastLoginIp) {
		this.cusLastLoginIp = cusLastLoginIp;
	}
	public String getCusIsThrough() {
		return cusIsThrough;
	}
	public void setCusIsThrough(String cusIsThrough) {
		this.cusIsThrough = cusIsThrough;
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
	public String getCpyName() {
		return cpyName;
	}
	public void setCpyName(String cpyName) {
		this.cpyName = cpyName;
	}
	public String getCusLastLoginAddress() {
		return cusLastLoginAddress;
	}
	public void setCusLastLoginAddress(String cusLastLoginAddress) {
		this.cusLastLoginAddress = cusLastLoginAddress;
	}
	public String getCusIsCooperation() {
		return cusIsCooperation;
	}
	public void setCusIsCooperation(String cusIsCooperation) {
		this.cusIsCooperation = cusIsCooperation;
	}
	public String getPseIsSx() {
		return pseIsSx;
	}
	public void setPseIsSx(String pseIsSx) {
		this.pseIsSx = pseIsSx;
	}
	
}
