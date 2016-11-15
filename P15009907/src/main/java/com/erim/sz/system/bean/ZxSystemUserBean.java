package com.erim.sz.system.bean;

import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: CmsSystemUserBean 
 * @Description: 商户用户
 * @author maoxian
 * @date 2015年8月1日 上午11:20:33
 */
public class ZxSystemUserBean extends BaseBean {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//登录名
	private String  zxUserLoginname;
	//密码
	private String  zxUserPassword;
	//真实姓名
	private String  zxUserRealname;
	//联系方式
	private String  zxUserTel;
	//角色id
	private Integer zxRoleId;
	//上次登录时间
	private Date    zxLastLoginTime;
	//上次登录ip
	private String  zxLastLoginIp;
	//是否审核
	private String  zxIsThrough;
	private String zxIs;
	//上次登陆城市
	private String  zxLastLoginAddress;
	
	//////////////////////////////////////// 自定义  start //////////////////////////////////////////
	//角色名称
	private String	zxRoleName;
	//公司ID
	private Integer	cpyId;
	//公司名称
	private String	cpyName;
	//公司Logo
	private String 	cpyImg;
	// 公司品牌
	private String 	cpyBrand;
	
	//////////////////////////////////////// 自定义  end //////////////////////////////////////////	
	
	
	public Integer getId() {
		return id;
	}
	public String getCpyImg() {
		return cpyImg;
	}
	public void setCpyImg(String cpyImg) {
		this.cpyImg = cpyImg;
	}
	public String getCpyBrand() {
		return cpyBrand;
	}
	public void setCpyBrand(String cpyBrand) {
		this.cpyBrand = cpyBrand;
	}
	public String getZxLastLoginAddress() {
		return zxLastLoginAddress;
	}
	public void setZxLastLoginAddress(String zxLastLoginAddress) {
		this.zxLastLoginAddress = zxLastLoginAddress;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZxUserLoginname() {
		return zxUserLoginname;
	}
	public void setZxUserLoginname(String zxUserLoginname) {
		this.zxUserLoginname = zxUserLoginname;
	}
	public String getZxUserPassword() {
		return zxUserPassword;
	}
	public void setZxUserPassword(String zxUserPassword) {
		this.zxUserPassword = zxUserPassword;
	}
	public String getZxUserRealname() {
		return zxUserRealname;
	}
	public void setZxUserRealname(String zxUserRealname) {
		this.zxUserRealname = zxUserRealname;
	}
	public String getZxUserTel() {
		return zxUserTel;
	}
	public void setZxUserTel(String zxUserTel) {
		this.zxUserTel = zxUserTel;
	}
	public Integer getZxRoleId() {
		return zxRoleId;
	}
	public void setZxRoleId(Integer zxRoleId) {
		this.zxRoleId = zxRoleId;
	}
	public Date getZxLastLoginTime() {
		return zxLastLoginTime;
	}
	public void setZxLastLoginTime(Date zxLastLoginTime) {
		this.zxLastLoginTime = zxLastLoginTime;
	}
	public String getZxLastLoginIp() {
		return zxLastLoginIp;
	}
	public void setZxLastLoginIp(String zxLastLoginIp) {
		this.zxLastLoginIp = zxLastLoginIp;
	}

	public String getZxRoleName() {
		return zxRoleName;
	}
	public void setZxRoleName(String zxRoleName) {
		this.zxRoleName = zxRoleName;
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
	public String getZxIsThrough() {
		return zxIsThrough;
	}
	public void setZxIsThrough(String zxIsThrough) {
		this.zxIsThrough = zxIsThrough;
	}
	public String getZxIs() {
		return zxIs;
	}
	public void setZxIs(String zxIs) {
		this.zxIs = zxIs;
	}
	
}
