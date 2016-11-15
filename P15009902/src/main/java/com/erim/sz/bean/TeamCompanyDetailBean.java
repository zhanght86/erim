package com.erim.sz.bean;

import com.erim.sz.common.bean.CompanyDetailBean;

/**
 * @ClassName: TeamCompanyDetailBean 
 * @Description: 合作管理表
 * @author maoxian
 * @date 2015年12月18日 上午2:47:40
 */
public class TeamCompanyDetailBean extends CompanyDetailBean{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */
	private static final long serialVersionUID = 2673208120529100141L;

	// 是否支付 1是 0否
	private String isPay;
	// 佣金平台父级帐号
	private String yjLoginname;
	
	// 佣金平台帐号;
	private String cpyYjLoginname;
	// 子合作数量
	private Integer intChildCpy;
	
	public String getIsPay() {
		return isPay;
	}
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	public String getYjLoginname() {
		return yjLoginname;
	}
	public void setYjLoginname(String yjLoginname) {
		this.yjLoginname = yjLoginname;
	}
	public String getCpyYjLoginname() {
		return cpyYjLoginname;
	}
	public void setCpyYjLoginname(String cpyYjLoginname) {
		this.cpyYjLoginname = cpyYjLoginname;
	}
	public Integer getIntChildCpy() {
		return intChildCpy;
	}
	public void setIntChildCpy(Integer intChildCpy) {
		this.intChildCpy = intChildCpy;
	}
	
}
