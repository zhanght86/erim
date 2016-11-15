package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: CommissionDetailBean
 * @Description: 佣金规则管理
 * @author 陈鹏
 * @date 2015年7月20日 下午8:59:58
 *
 */
public class CommissionDetailBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	// 省
	private String cinProvince;
	// 市
	private String cinCity;
	// 公司角色
	private String cinRole;
	// 佣金分类
	private String cinNtype;
	// 量级分类
	private String cinLevel;
	// 价格
	private String cinPrice;
	// 单位
	private String cinUnit;
	// 创建时间
	private Date cinCreatedate;
	// 创建用户
	private String cinCreateuser;
	// 是否审核通过 1 是 0 否
	private String cinIsThrough;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCinProvince() {
		return cinProvince;
	}

	public void setCinProvince(String cinProvince) {
		this.cinProvince = cinProvince;
	}

	public String getCinCity() {
		return cinCity;
	}

	public void setCinCity(String cinCity) {
		this.cinCity = cinCity;
	}

	public String getCinRole() {
		return cinRole;
	}

	public void setCinRole(String cinRole) {
		this.cinRole = cinRole;
	}

	public String getCinNtype() {
		return cinNtype;
	}

	public void setCinNtype(String cinNtype) {
		this.cinNtype = cinNtype;
	}

	public String getCinLevel() {
		return cinLevel;
	}

	public void setCinLevel(String cinLevel) {
		this.cinLevel = cinLevel;
	}

	public String getCinPrice() {
		return cinPrice;
	}

	public void setCinPrice(String cinPrice) {
		this.cinPrice = cinPrice;
	}

	public String getCinUnit() {
		return cinUnit;
	}

	public void setCinUnit(String cinUnit) {
		this.cinUnit = cinUnit;
	}

	public Date getCinCreatedate() {
		return cinCreatedate;
	}

	public void setCinCreatedate(Date cinCreatedate) {
		this.cinCreatedate = cinCreatedate;
	}

	public String getCinCreateuser() {
		return cinCreateuser;
	}

	public void setCinCreateuser(String cinCreateuser) {
		this.cinCreateuser = cinCreateuser;
	}

	public String getCinIsThrough() {
		return cinIsThrough;
	}

	public void setCinIsThrough(String cinIsThrough) {
		this.cinIsThrough = cinIsThrough;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
