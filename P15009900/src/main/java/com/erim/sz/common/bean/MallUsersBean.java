package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: MallUsersBean 
 * @Description: 商城用户
 * @author maoxian
 * @date 2015年9月16日 下午6:55:07 
 *
 */
public class MallUsersBean extends BaseBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	//登录名(手机号)
	private String  mluLoginname;
	//密码
	private String  mluPassword;
	//email
	private String  mluEmail;
	//QQ
	private String  mluQq;
	//注册IP
	private String  mluCreateIp;
	//注册时间
	private Date    mluCreateTime;
	//是否使用
	private String  mluIsLive;
	//会员等级
	private Integer mluLevel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMluLoginname() {
		return mluLoginname;
	}
	public void setMluLoginname(String mluLoginname) {
		this.mluLoginname = mluLoginname;
	}
	public String getMluPassword() {
		return mluPassword;
	}
	public void setMluPassword(String mluPassword) {
		this.mluPassword = mluPassword;
	}
	public String getMluEmail() {
		return mluEmail;
	}
	public void setMluEmail(String mluEmail) {
		this.mluEmail = mluEmail;
	}
	public String getMluQq() {
		return mluQq;
	}
	public void setMluQq(String mluQq) {
		this.mluQq = mluQq;
	}
	public String getMluCreateIp() {
		return mluCreateIp;
	}
	public void setMluCreateIp(String mluCreateIp) {
		this.mluCreateIp = mluCreateIp;
	}
	public Date getMluCreateTime() {
		return mluCreateTime;
	}
	public void setMluCreateTime(Date mluCreateTime) {
		this.mluCreateTime = mluCreateTime;
	}
	public String getMluIsLive() {
		return mluIsLive;
	}
	public void setMluIsLive(String mluIsLive) {
		this.mluIsLive = mluIsLive;
	}
	public Integer getMluLevel() {
		return mluLevel;
	}
	public void setMluLevel(Integer mluLevel) {
		this.mluLevel = mluLevel;
	}
}
