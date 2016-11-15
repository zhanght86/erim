package com.erim.sz.system.bean;

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
public class SellSystemUserBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//登录名
	private String  sellUserLoginname;
	//密码
	private String  sellUserPassword;
	//真实姓名
	private String  sellUserRealname;
	//联系方式
	private String  sellUserTel;
	//角色id
	private Integer sellRoleId;
	//上次登录时间
	private Date    sellLastLoginTime;
	//上次登录ip
	private String  sellLastLoginIp;
	//是否审核
	private String  sellIsThrough;
	//是否登陆
	private String  sellLastLoginAddress;
	//是否停用
	private String  sellIsDelStatus;
	
	//////////////////////////////////////// 自定义  start //////////////////////////////////////////
	//角色名称
	private String   sellRoleName;
	//公司ID
	private Integer  cpyId;
	//公司名称
	private String   cpyName;
	//////////////////////////////////////// 自定义  end //////////////////////////////////////////	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSellUserLoginname() {
		return sellUserLoginname;
	}
	public void setSellUserLoginname(String sellUserLoginname) {
		this.sellUserLoginname = sellUserLoginname;
	}
	public String getSellUserPassword() {
		return sellUserPassword;
	}
	public void setSellUserPassword(String sellUserPassword) {
		this.sellUserPassword = sellUserPassword;
	}
	public String getSellUserRealname() {
		return sellUserRealname;
	}
	public void setSellUserRealname(String sellUserRealname) {
		this.sellUserRealname = sellUserRealname;
	}
	public String getSellUserTel() {
		return sellUserTel;
	}
	public void setSellUserTel(String sellUserTel) {
		this.sellUserTel = sellUserTel;
	}
	public Integer getSellRoleId() {
		return sellRoleId;
	}
	public void setSellRoleId(Integer sellRoleId) {
		this.sellRoleId = sellRoleId;
	}
	public Date getSellLastLoginTime() {
		return sellLastLoginTime;
	}
	public void setSellLastLoginTime(Date sellLastLoginTime) {
		this.sellLastLoginTime = sellLastLoginTime;
	}
	public String getSellLastLoginIp() {
		return sellLastLoginIp;
	}
	public void setSellLastLoginIp(String sellLastLoginIp) {
		this.sellLastLoginIp = sellLastLoginIp;
	}
	public String getSellIsThrough() {
		return sellIsThrough;
	}
	public void setSellIsThrough(String sellIsThrough) {
		this.sellIsThrough = sellIsThrough;
	}
	public String getSellRoleName() {
		return sellRoleName;
	}
	public void setSellRoleName(String sellRoleName) {
		this.sellRoleName = sellRoleName;
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
	public String getSellLastLoginAddress() {
		return sellLastLoginAddress;
	}
	public void setSellLastLoginAddress(String sellLastLoginAddress) {
		this.sellLastLoginAddress = sellLastLoginAddress;
	}
	public String getSellIsDelStatus() {
		return sellIsDelStatus;
	}
	public void setSellIsDelStatus(String sellIsDelStatus) {
		this.sellIsDelStatus = sellIsDelStatus;
	}
	
}
