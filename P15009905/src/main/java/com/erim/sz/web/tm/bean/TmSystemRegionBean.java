package com.erim.sz.web.tm.bean;

import java.io.Serializable;

/**
 * @ClassName: TmSystemRegionBean 
 * @Description: 年月日bean
 * @author maoxian
 * @date 2015年8月19日 下午4:53:12 
 *
 */
public class TmSystemRegionBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer regionId;
	private String  regionNo;
	private Integer regionPid;
	private Integer regionLevel;
	private String  regionName;
	private String  regionSpell;
	private String  regionRemark;
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	public String getRegionNo() {
		return regionNo;
	}
	public void setRegionNo(String regionNo) {
		this.regionNo = regionNo;
	}
	public Integer getRegionPid() {
		return regionPid;
	}
	public void setRegionPid(Integer regionPid) {
		this.regionPid = regionPid;
	}
	public Integer getRegionLevel() {
		return regionLevel;
	}
	public void setRegionLevel(Integer regionLevel) {
		this.regionLevel = regionLevel;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getRegionSpell() {
		return regionSpell;
	}
	public void setRegionSpell(String regionSpell) {
		this.regionSpell = regionSpell;
	}
	public String getRegionRemark() {
		return regionRemark;
	}
	public void setRegionRemark(String regionRemark) {
		this.regionRemark = regionRemark;
	}
}
