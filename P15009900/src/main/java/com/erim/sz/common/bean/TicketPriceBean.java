package com.erim.sz.common.bean;

import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @类名: TicketPriceBean
 * @描述: 门票量价管理信息实体
 * @作者: 宁晓强
 * @创建时间: 2015年10月17日 上午10:09:16
 */
public class TicketPriceBean extends BaseBean {
	
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
	
	private Integer id;
	// 门票ID
	private Integer tdlId;
	// 票类ID
	private Integer tclId;
	// 票类名称
	private String  tclType;
	// 日期 yyyy-MM-dd
	private String	tplDate;
	// 是否出售
	private String	tplIsOpen;
	// 星期
	private String	tplWeek;
	// 可售票数
	private String	tplSign;
	// 可售票数是否限量
	private String	tplIsSign;
	// 同业价
	private Integer	tplTradePrice;
	// 批发价
	private Integer tplCombinationPrice;
	// 零售价
	private Integer tplRetailPrice;
	// 可选服务/保险
	private Integer	tplInsurePrice;
	// 可选服务说明
	private String	tplExplain;
	// 预订时间类型
	private String	tplDateType;
	// 预订时间当日-时
	private String 	tplSameH;
	// 预订时间当日-分
	private String	tplSameM;
	// 预订时间游玩前-日
	private String	tplForwardD;
	// 预订时间游玩前-时
	private String	tplForwardH;
	// 预订时间游玩前-分
	private String	tplForwardM;
	// 创建时间
	private Date	tplCreateTime;
	// 创建用户
	private String	tplCreateUser;
	// 公司ID
	private Integer	cpyId;
	
	/*
	 * 转码
	 */
	// 入口号
	private String portal;
	// 开始时间
	private String start;
	// 结束时间
	private String end;
	// 星期
	private String week;
	// 日历号
	private String day;
	// 当前数据是否允许修改 - 早于今天的数据不允许修改。
  	private String	isUpdate;
  	//是否可以预定 选定的日期-当前日期 >=提前预定天数 1：可以预定 0：已过期
  	private String isPredetermine;
  	
	public String getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(String isUpdate) {
		this.isUpdate = isUpdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTclId() {
		return tclId;
	}
	public void setTclId(Integer tclId) {
		this.tclId = tclId;
	}
	public String getTclType() {
		return tclType;
	}
	public void setTclType(String tclType) {
		this.tclType = tclType;
	}
	public String getTplDate() {
		return tplDate;
	}
	public void setTplDate(String tplDate) {
		this.tplDate = tplDate;
	}
	public String getTplIsOpen() {
		return tplIsOpen;
	}
	public void setTplIsOpen(String tplIsOpen) {
		this.tplIsOpen = tplIsOpen;
	}
	public String getTplWeek() {
		return tplWeek;
	}
	public void setTplWeek(String tplWeek) {
		this.tplWeek = tplWeek;
	}
	public String getTplSign() {
		return tplSign;
	}
	public void setTplSign(String tplSign) {
		this.tplSign = tplSign;
	}
	public String getTplIsSign() {
		return tplIsSign;
	}
	public void setTplIsSign(String tplIsSign) {
		this.tplIsSign = tplIsSign;
	}
	public Integer getTplTradePrice() {
		return tplTradePrice;
	}
	public void setTplTradePrice(Integer tplTradePrice) {
		this.tplTradePrice = tplTradePrice;
	}
	public Integer getTplCombinationPrice() {
		return tplCombinationPrice;
	}
	public void setTplCombinationPrice(Integer tplCombinationPrice) {
		this.tplCombinationPrice = tplCombinationPrice;
	}
	public Integer getTplRetailPrice() {
		return tplRetailPrice;
	}
	public void setTplRetailPrice(Integer tplRetailPrice) {
		this.tplRetailPrice = tplRetailPrice;
	}
	public Integer getTplInsurePrice() {
		return tplInsurePrice;
	}
	public void setTplInsurePrice(Integer tplInsurePrice) {
		this.tplInsurePrice = tplInsurePrice;
	}
	public String getTplExplain() {
		return tplExplain;
	}
	public void setTplExplain(String tplExplain) {
		this.tplExplain = tplExplain;
	}
	public String getTplDateType() {
		return tplDateType;
	}
	public void setTplDateType(String tplDateType) {
		this.tplDateType = tplDateType;
	}
	public String getTplSameH() {
		return tplSameH;
	}
	public void setTplSameH(String tplSameH) {
		this.tplSameH = tplSameH;
	}
	public String getTplSameM() {
		return tplSameM;
	}
	public void setTplSameM(String tplSameM) {
		this.tplSameM = tplSameM;
	}
	public String getTplForwardD() {
		return tplForwardD;
	}
	public void setTplForwardD(String tplForwardD) {
		this.tplForwardD = tplForwardD;
	}
	public String getTplForwardH() {
		return tplForwardH;
	}
	public void setTplForwardH(String tplForwardH) {
		this.tplForwardH = tplForwardH;
	}
	public String getTplForwardM() {
		return tplForwardM;
	}
	public void setTplForwardM(String tplForwardM) {
		this.tplForwardM = tplForwardM;
	}
	public Date getTplCreateTime() {
		return tplCreateTime;
	}
	public void setTplCreateTime(Date tplCreateTime) {
		this.tplCreateTime = tplCreateTime;
	}
	public String getTplCreateUser() {
		return tplCreateUser;
	}
	public void setTplCreateUser(String tplCreateUser) {
		this.tplCreateUser = tplCreateUser;
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
	public Integer getTdlId() {
		return tdlId;
	}
	public void setTdlId(Integer tdlId) {
		this.tdlId = tdlId;
	}
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
	public String getIsPredetermine() {
		return isPredetermine;
	}
	public void setIsPredetermine(String isPredetermine) {
		this.isPredetermine = isPredetermine;
	}
	
	
}
