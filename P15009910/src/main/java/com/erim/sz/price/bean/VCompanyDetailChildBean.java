package com.erim.sz.price.bean;

import com.erim.sz.common.bean.VCompanyDetailBean;

/**
 * @ClassName: VCompanyDetailChildBean 
 * @Description: 企业信息 私有bean
 * @author maoxian
 * @date 2015年12月18日 上午1:25:06
 */
public class VCompanyDetailChildBean extends VCompanyDetailBean{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	// 公司自己的code
	private String  cpyYjUserCode;
	// 一级代理返利
	private Integer backMoneyLevelf;
	// 二级代理返利
	private Integer backMoneyLevelS;
	
	public String getCpyYjUserCode() {
		return cpyYjUserCode;
	}
	public void setCpyYjUserCode(String cpyYjUserCode) {
		this.cpyYjUserCode = cpyYjUserCode;
	}
	public Integer getBackMoneyLevelf() {
		return backMoneyLevelf;
	}
	public void setBackMoneyLevelf(Integer backMoneyLevelf) {
		this.backMoneyLevelf = backMoneyLevelf;
	}
	public Integer getBackMoneyLevelS() {
		return backMoneyLevelS;
	}
	public void setBackMoneyLevelS(Integer backMoneyLevelS) {
		this.backMoneyLevelS = backMoneyLevelS;
	}
}
