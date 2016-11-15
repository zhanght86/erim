package com.erim.sz.tm.bean;

import java.io.Serializable;

/**
 * @ClassName: TmSystemCountryBean 
 * @Description: 国际 国家
 * @author maoxian
 * @date 2015年10月23日 下午1:01:39
 */
public class TmSystemCountryBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	//序号
	private Integer countryId;
	//父级编号
	private Integer countryPid;
	//等级
	private Integer countryLevel;
	//名称
	private String  countryName;
	//备注
	private String  countryRemark;
	
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public Integer getCountryPid() {
		return countryPid;
	}
	public void setCountryPid(Integer countryPid) {
		this.countryPid = countryPid;
	}
	public Integer getCountryLevel() {
		return countryLevel;
	}
	public void setCountryLevel(Integer countryLevel) {
		this.countryLevel = countryLevel;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryRemark() {
		return countryRemark;
	}
	public void setCountryRemark(String countryRemark) {
		this.countryRemark = countryRemark;
	}
	
}
