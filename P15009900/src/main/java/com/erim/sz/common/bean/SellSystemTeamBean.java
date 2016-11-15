package com.erim.sz.common.bean;

import java.io.Serializable;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: SellSystemTeamBean 
 * @Description: 所有组团社列表
 * @author maoxian
 * @date 2015年11月26日 下午4:32:02
 */
public class SellSystemTeamBean extends BaseBean implements Serializable{
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//省
	private String  sstProvince;
	//市
	private String  sstCity;
	//许可证号 
	private String  sstCode;
	//组团社名称
	private String  sstName;
	//组团社电话
	private String  sstTelephone;
	//地址
	private String  sstAddress;
	//创建时间
	private String  sstTimestamp;
	//锁定状态
	private String locked;
	//锁定人
	private String lockedLoginName;
	//当前用户usercode
	private String yjUserCode;
	public String getLockedLoginName() {
		return lockedLoginName;
	}
	public void setLockedLoginName(String lockedLoginName) {
		this.lockedLoginName = lockedLoginName;
	}
	public String getLockedDate() {
		return lockedDate;
	}
	public void setLockedDate(String lockedDate) {
		this.lockedDate = lockedDate;
	}
	//锁定时间
	private String lockedDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSstProvince() {
		return sstProvince;
	}
	public void setSstProvince(String sstProvince) {
		this.sstProvince = sstProvince;
	}
	public String getSstCity() {
		return sstCity;
	}
	public void setSstCity(String sstCity) {
		this.sstCity = sstCity;
	}
	public String getSstCode() {
		return sstCode;
	}
	public void setSstCode(String sstCode) {
		this.sstCode = sstCode;
	}
	public String getSstName() {
		return sstName;
	}
	public void setSstName(String sstName) {
		this.sstName = sstName;
	}
	public String getSstTelephone() {
		return sstTelephone;
	}
	public void setSstTelephone(String sstTelephone) {
		this.sstTelephone = sstTelephone;
	}
	public String getSstAddress() {
		return sstAddress;
	}
	public void setSstAddress(String sstAddress) {
		this.sstAddress = sstAddress;
	}
	public String getSstTimestamp() {
		return sstTimestamp;
	}
	public void setSstTimestamp(String sstTimestamp) {
		this.sstTimestamp = sstTimestamp;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	public String getYjUserCode() {
		return yjUserCode;
	}
	public void setYjUserCode(String yjUserCode) {
		this.yjUserCode = yjUserCode;
	}
	
}
