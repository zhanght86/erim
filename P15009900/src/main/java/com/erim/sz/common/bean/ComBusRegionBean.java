package com.erim.sz.common.bean;

import com.erim.core.bean.BaseBean;

/**
 * @描述: 企业业务范围信息-省市县信息
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月10日 下午2:12:17
 */
public class ComBusRegionBean extends BaseBean {

	/**
	 * serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	// 公司ID
	private Integer	cpyId;
	// 字段类型 01地接涉及区域 01可服务地区
	private String	cbrBusType;
	// 省
	private String	cbrProvince;
	// 市
	private String	cbrCity;
	// 县
	private String	cbrCounty;
	
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
	public String getCbrBusType() {
		return cbrBusType;
	}
	public void setCbrBusType(String cbrBusType) {
		this.cbrBusType = cbrBusType;
	}
	public String getCbrProvince() {
		return cbrProvince;
	}
	public void setCbrProvince(String cbrProvince) {
		this.cbrProvince = cbrProvince;
	}
	public String getCbrCity() {
		return cbrCity;
	}
	public void setCbrCity(String cbrCity) {
		this.cbrCity = cbrCity;
	}
	public String getCbrCounty() {
		return cbrCounty;
	}
	public void setCbrCounty(String cbrCounty) {
		this.cbrCounty = cbrCounty;
	}
}
