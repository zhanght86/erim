package com.erim.sz.common.bean;

import java.io.Serializable;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: LineTripBean
 * @Description: 专线行程介绍管理
 * @author 龙龙
 * @date 2015年7月20日 下午9:05:06
 *
 */
public class LineCooperationBean extends BaseBean implements Serializable{
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//城市
	private String ldlCity;
	//公司名称
	private String ldlName;
	//公司性质
	private String ldlCompanyNature;
	//公司地址
	private String ldlCompanyAddress;
	//负责人
	private String ldlPerson;
	//计调
	private String ldlLowerTotal;
	//客服
	private String ldlService;
	//状态
	private String ldlStatus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLdlCity() {
		return ldlCity;
	}
	public void setLdlCity(String ldlCity) {
		this.ldlCity = ldlCity;
	}
	public String getLdlName() {
		return ldlName;
	}
	public void setLdlName(String ldlName) {
		this.ldlName = ldlName;
	}
	public String getLdlCompanyNature() {
		return ldlCompanyNature;
	}
	public void setLdlCompanyNature(String ldlCompanyNature) {
		this.ldlCompanyNature = ldlCompanyNature;
	}
	public String getLdlCompanyAddress() {
		return ldlCompanyAddress;
	}
	public void setLdlCompanyAddress(String ldlCompanyAddress) {
		this.ldlCompanyAddress = ldlCompanyAddress;
	}
	public String getLdlPerson() {
		return ldlPerson;
	}
	public void setLdlPerson(String ldlPerson) {
		this.ldlPerson = ldlPerson;
	}
	public String getLdlLowerTotal() {
		return ldlLowerTotal;
	}
	public void setLdlLowerTotal(String ldlLowerTotal) {
		this.ldlLowerTotal = ldlLowerTotal;
	}
	public String getLdlService() {
		return ldlService;
	}
	public void setLdlService(String ldlService) {
		this.ldlService = ldlService;
	}
	public String getLdlStatus() {
		return ldlStatus;
	}
	public void setLdlStatus(String ldlStatus) {
		this.ldlStatus = ldlStatus;
	}

	
}
