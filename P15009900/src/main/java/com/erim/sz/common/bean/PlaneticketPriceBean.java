package com.erim.sz.common.bean;

import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @描述: 飞机票量价信息实体
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月8日 下午3:01:33
 */
public class PlaneticketPriceBean extends BaseBean {

	/**
	 * serialVersionUID:序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer	id;
	// 产品ID
	private Integer	gdlId;
	// 产品舱位类型
	private String 	ptdClass;
	// 日期
	private String	preDate;
	// 是否出售
	private String	preIsOpen;
	// 星期
	private String	preWeek;
	// 机票数量
	private Integer	preSign;
	// 同业价格
	private Integer preTradePrice;
	// 零售价格
	private Integer preRetailPrice;
	// 税费
	private Integer preTallage;
	// 是否含税
	private String	preIsTallage;
	// 必选服务
	private Integer	preRequired;
	// 必选服务说明
	private String	preRequiredShow;
	// 可选服务
	private Integer	preOptional;
	// 可选服务说明
	private String	preOptianalShow;
	// 出票时间-开始
	private String	preIssueStart;
	// 出票时间-结束
	private String	preIssueEnd;
	// 创建时间
	private Date	preCreateTime;
	// 创建用户
	private String	preCreateUser;
	// 税费+同业
	private Integer	preTrade;
	// 税费+零售
	private Integer	preRetail;
	/*
	 * 转码字段
	 */
	// 入口号 
	private String 	portal;
	// 开始时间
	private String	start;
	// 结束时间
	private String	end;
	// 星期
	private String 	week;
	// 日历号
	private String 	day;
	// 当前数据是否允许被修改- 早于今日的数据不允许被修改
	private String 	isUpdate;
	
	
	public String getPtdClass() {
		return ptdClass;
	}
	public void setPtdClass(String ptdClass) {
		this.ptdClass = ptdClass;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGdlId() {
		return gdlId;
	}
	public void setGdlId(Integer gdlId) {
		this.gdlId = gdlId;
	}
	public String getPreDate() {
		return preDate;
	}
	public void setPreDate(String preDate) {
		this.preDate = preDate;
	}
	public String getPreIsOpen() {
		return preIsOpen;
	}
	public void setPreIsOpen(String preIsOpen) {
		this.preIsOpen = preIsOpen;
	}
	public String getPreWeek() {
		return preWeek;
	}
	public void setPreWeek(String preWeek) {
		this.preWeek = preWeek;
	}
	public Integer getPreSign() {
		return preSign;
	}
	public void setPreSign(Integer preSign) {
		this.preSign = preSign;
	}
	public Integer getPreTradePrice() {
		return preTradePrice;
	}
	public void setPreTradePrice(Integer preTradePrice) {
		this.preTradePrice = preTradePrice;
	}
	public Integer getPreRetailPrice() {
		return preRetailPrice;
	}
	public void setPreRetailPrice(Integer preRetailPrice) {
		this.preRetailPrice = preRetailPrice;
	}
	public Integer getPreTallage() {
		return preTallage;
	}
	public void setPreTallage(Integer preTallage) {
		this.preTallage = preTallage;
	}
	public String getPreIsTallage() {
		return preIsTallage;
	}
	public void setPreIsTallage(String preIsTallage) {
		this.preIsTallage = preIsTallage;
	}
	public Integer getPreRequired() {
		return preRequired;
	}
	public void setPreRequired(Integer preRequired) {
		this.preRequired = preRequired;
	}
	public String getPreRequiredShow() {
		return preRequiredShow;
	}
	public void setPreRequiredShow(String preRequiredShow) {
		this.preRequiredShow = preRequiredShow;
	}
	public Integer getPreOptional() {
		return preOptional;
	}
	public void setPreOptional(Integer preOptional) {
		this.preOptional = preOptional;
	}
	public String getPreOptianalShow() {
		return preOptianalShow;
	}
	public void setPreOptianalShow(String preOptianalShow) {
		this.preOptianalShow = preOptianalShow;
	}
	public String getPreIssueStart() {
		return preIssueStart;
	}
	public void setPreIssueStart(String preIssueStart) {
		this.preIssueStart = preIssueStart;
	}
	public String getPreIssueEnd() {
		return preIssueEnd;
	}
	public void setPreIssueEnd(String preIssueEnd) {
		this.preIssueEnd = preIssueEnd;
	}
	public Date getPreCreateTime() {
		return preCreateTime;
	}
	public void setPreCreateTime(Date preCreateTime) {
		this.preCreateTime = preCreateTime;
	}
	public String getPreCreateUser() {
		return preCreateUser;
	}
	public void setPreCreateUser(String preCreateUser) {
		this.preCreateUser = preCreateUser;
	}
	public String getPortal() {
		return portal;
	}
	public void setPortal(String portal) {
		this.portal = portal;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}
	public Integer getPreTrade() {
		return preTrade;
	}
	public void setPreTrade(Integer preTrade) {
		this.preTrade = preTrade;
	}
	public Integer getPreRetail() {
		return preRetail;
	}
	public void setPreRetail(Integer preRetail) {
		this.preRetail = preRetail;
	}
}
