package com.erim.sz.common.bean;

import com.erim.core.bean.BaseBean;

/**
 * @类名: AboutUsBean
 * @描述: 关于我们信息实体
 * @作者: 贺渊博
 * @创建时间: 2015年11月29日 下午5:30:09
 */
public class AboutUsBean extends BaseBean {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	// 公司ID
	private Integer cpyId;
	// 关于我们
	private String 	sauRemark;
	// 创建时间
	private String 	sauCreatetime;
	// 创建用户
	private String 	sauCreateuser;
	
	/////////////////////////company_detail////////////////////////////
	private String cpyName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getSauRemark() {
		return sauRemark;
	}
	public void setSauRemark(String sauRemark) {
		this.sauRemark = sauRemark;
	}
	public String getSauCreatetime() {
		return sauCreatetime;
	}
	public void setSauCreatetime(String sauCreatetime) {
		this.sauCreatetime = sauCreatetime;
	}
	public String getSauCreateuser() {
		return sauCreateuser;
	}
	public void setSauCreateuser(String sauCreateuser) {
		this.sauCreateuser = sauCreateuser;
	}
	public String getCpyName() {
		return cpyName;
	}
	public void setCpyName(String cpyName) {
		this.cpyName = cpyName;
	}
	
	
	
}
