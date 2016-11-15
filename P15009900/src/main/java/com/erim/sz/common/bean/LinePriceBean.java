package com.erim.sz.common.bean;

import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @描述: 专线量价管理信息实体
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月5日 下午7:47:26
 */
public class LinePriceBean extends BaseBean {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	////////////////////////////////////自定义字段 ///////////////////////////////////////////////
	
	//开始时间
	private String startDate;
	//结束时间
	private String endDate;

	//////////////////////////////////// 自定义字段 ///////////////////////////////////////////////
	
	// id
	private Integer id;
	// 专线ID
	private Integer tdlId;
	// 专线名称
	private String 	tdlName;
	// 日期
	private String 	lpeDate;
	// 是否出售
	private String	lpeIsOpen;
	// 星期
	private String	lpeWeek;
	// 可报团人数
	private Integer	lpeSign;
	// 同业成人价
	private Integer	lpeTradeAdult;
	// 同业儿童价
	private Integer	lpeTradeChild;
	// 零售成人价
	private Integer	lpeRetailAdult;
	// 零售儿童价
	private Integer	lpeRetailChild;
	// 可选服务单房差价格
	private Integer	lpeSinglePrice;
	// 可选单房差说明
	private String	lpeSingleShow;
	// 可选服务保险价格
	private Integer lpeInsurePrice;
	// 可选服务保险说明
	private String	lpeInsureShow;
	// 是否可升级
	private String	lpeIsUpgrade;
	// 升级内容
	private String	lpeUpgradeCont;
	// 升级内容成人价
	private Integer	lpeUpgradeAdult;
	// 升级内容儿童价
	private Integer lpeUpgradeChild;
	// 接受报团截止多少天
	private Integer	lpeRestrict;
	// 创建时间
	private Date	lpeCreateDate;
	// 创建用户
	private String	lpeCreateUser;
	// 公司ID
	private Integer	cpyId;
	
	/*
	 * 转码
	 */
	// 入口号
	private String 	portal;
	// 开始时间
	private String	start;
	// 结束时间
	private String	end;
	// 星期
	private String	week;
	// 日历号
	private String	day;
	// 当前数据是否允许修改 - 早于今天的数据不允许修改。
  	private String	isUpdate;
  	//是否可以预定 选定的日期-当前日期 >=提前预定天数 1：可以预定 0：已过期
  	private String isPredetermine;
  	
  	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTdlId() {
		return tdlId;
	}
	public void setTdlId(Integer tdlId) {
		this.tdlId = tdlId;
	}
	public String getTdlName() {
		return tdlName;
	}
	public void setTdlName(String tdlName) {
		this.tdlName = tdlName;
	}
	public String getLpeDate() {
		return lpeDate;
	}
	public void setLpeDate(String lpeDate) {
		this.lpeDate = lpeDate;
	}
	public String getLpeIsOpen() {
		return lpeIsOpen;
	}
	public void setLpeIsOpen(String lpeIsOpen) {
		this.lpeIsOpen = lpeIsOpen;
	}
	public String getLpeWeek() {
		return lpeWeek;
	}
	public void setLpeWeek(String lpeWeek) {
		this.lpeWeek = lpeWeek;
	}
	public Integer getLpeSign() {
		return lpeSign;
	}
	public void setLpeSign(Integer lpeSign) {
		this.lpeSign = lpeSign;
	}
	public Integer getLpeTradeAdult() {
		return lpeTradeAdult;
	}
	public void setLpeTradeAdult(Integer lpeTradeAdult) {
		this.lpeTradeAdult = lpeTradeAdult;
	}
	public Integer getLpeTradeChild() {
		return lpeTradeChild;
	}
	public void setLpeTradeChild(Integer lpeTradeChild) {
		this.lpeTradeChild = lpeTradeChild;
	}
	public Integer getLpeRetailAdult() {
		return lpeRetailAdult;
	}
	public void setLpeRetailAdult(Integer lpeRetailAdult) {
		this.lpeRetailAdult = lpeRetailAdult;
	}
	public Integer getLpeRetailChild() {
		return lpeRetailChild;
	}
	public void setLpeRetailChild(Integer lpeRetailChild) {
		this.lpeRetailChild = lpeRetailChild;
	}
	public Integer getLpeSinglePrice() {
		return lpeSinglePrice;
	}
	public void setLpeSinglePrice(Integer lpeSinglePrice) {
		this.lpeSinglePrice = lpeSinglePrice;
	}
	public String getLpeSingleShow() {
		return lpeSingleShow;
	}
	public void setLpeSingleShow(String lpeSingleShow) {
		this.lpeSingleShow = lpeSingleShow;
	}
	public Integer getLpeInsurePrice() {
		return lpeInsurePrice;
	}
	public void setLpeInsurePrice(Integer lpeInsurePrice) {
		this.lpeInsurePrice = lpeInsurePrice;
	}
	public String getLpeInsureShow() {
		return lpeInsureShow;
	}
	public void setLpeInsureShow(String lpeInsureShow) {
		this.lpeInsureShow = lpeInsureShow;
	}
	public String getLpeIsUpgrade() {
		return lpeIsUpgrade;
	}
	public void setLpeIsUpgrade(String lpeIsUpgrade) {
		this.lpeIsUpgrade = lpeIsUpgrade;
	}
	public String getLpeUpgradeCont() {
		return lpeUpgradeCont;
	}
	public void setLpeUpgradeCont(String lpeUpgradeCont) {
		this.lpeUpgradeCont = lpeUpgradeCont;
	}
	public Integer getLpeUpgradeAdult() {
		return lpeUpgradeAdult;
	}
	public void setLpeUpgradeAdult(Integer lpeUpgradeAdult) {
		this.lpeUpgradeAdult = lpeUpgradeAdult;
	}
	public Integer getLpeUpgradeChild() {
		return lpeUpgradeChild;
	}
	public void setLpeUpgradeChild(Integer lpeUpgradeChild) {
		this.lpeUpgradeChild = lpeUpgradeChild;
	}
	public Integer getLpeRestrict() {
		return lpeRestrict;
	}
	public void setLpeRestrict(Integer lpeRestrict) {
		this.lpeRestrict = lpeRestrict;
	}
	public Date getLpeCreateDate() {
		return lpeCreateDate;
	}
	public void setLpeCreateDate(Date lpeCreateDate) {
		this.lpeCreateDate = lpeCreateDate;
	}
	public String getLpeCreateUser() {
		return lpeCreateUser;
	}
	public void setLpeCreateUser(String lpeCreateUser) {
		this.lpeCreateUser = lpeCreateUser;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
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
	public String getIsPredetermine() {
		return isPredetermine;
	}
	public void setIsPredetermine(String isPredetermine) {
		this.isPredetermine = isPredetermine;
	}
  	
  	
	
	
}
