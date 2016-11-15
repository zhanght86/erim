package com.erim.sz.common.bean;

import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @类名: CaferteriaPriceBean
 * @描述: 特色餐套餐量价管理信息实体
 * @作者: 宁晓强
 * @创建时间: 2015年10月18日 上午10:18:53
 */
public class CafeteriaPriceBean extends BaseBean {

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
	// 特色餐ID
	private Integer cdlId;
	// 套餐ID
	private Integer	cpeId;
	// 套餐名称
	private String	cpeName;
	// 日期
	private String	cpcDate;
	// 是否出售
	private String	cpcIsOpen;
	// 星期
	private String	cpcWeek;
	// 可售份数
	private Integer	cpcSign;
	// 可售份数是否限量
	private String	cpcIsSign;
	// 同业价
	private Integer cpcTradePrice;
	// 批发价
	private Integer	cpcCombinationPrice;
	// 零售价
	private Integer cpcRetailPrice;
	// 费用说明
	private String	cpcExplain;
	// 创建时间
	private Date	cpcCreateTime;
	// 创建用户
	private String	cpcCreateUser;
	// 公司id
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
	public Integer getCpeId() {
		return cpeId;
	}
	public void setCpeId(Integer cpeId) {
		this.cpeId = cpeId;
	}
	public String getCpeName() {
		return cpeName;
	}
	public void setCpeName(String cpeName) {
		this.cpeName = cpeName;
	}
	public String getCpcDate() {
		return cpcDate;
	}
	public void setCpcDate(String cpcDate) {
		this.cpcDate = cpcDate;
	}
	public String getCpcIsOpen() {
		return cpcIsOpen;
	}
	public void setCpcIsOpen(String cpcIsOpen) {
		this.cpcIsOpen = cpcIsOpen;
	}
	public String getCpcWeek() {
		return cpcWeek;
	}
	public void setCpcWeek(String cpcWeek) {
		this.cpcWeek = cpcWeek;
	}
	public Integer getCpcSign() {
		return cpcSign;
	}
	public void setCpcSign(Integer cpcSign) {
		this.cpcSign = cpcSign;
	}
	public String getCpcIsSign() {
		return cpcIsSign;
	}
	public void setCpcIsSign(String cpcIsSign) {
		this.cpcIsSign = cpcIsSign;
	}
	public Integer getCpcCombinationPrice() {
		return cpcCombinationPrice;
	}
	public void setCpcCombinationPrice(Integer cpcCombinationPrice) {
		this.cpcCombinationPrice = cpcCombinationPrice;
	}
	public Integer getCpcRetailPrice() {
		return cpcRetailPrice;
	}
	public void setCpcRetailPrice(Integer cpcRetailPrice) {
		this.cpcRetailPrice = cpcRetailPrice;
	}
	public String getCpcExplain() {
		return cpcExplain;
	}
	public void setCpcExplain(String cpcExplain) {
		this.cpcExplain = cpcExplain;
	}
	public Date getCpcCreateTime() {
		return cpcCreateTime;
	}
	public void setCpcCreateTime(Date cpcCreateTime) {
		this.cpcCreateTime = cpcCreateTime;
	}
	public String getCpcCreateUser() {
		return cpcCreateUser;
	}
	public void setCpcCreateUser(String cpcCreateUser) {
		this.cpcCreateUser = cpcCreateUser;
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
	public Integer getCdlId() {
		return cdlId;
	}
	public void setCdlId(Integer cdlId) {
		this.cdlId = cdlId;
	}
	public Integer getCpcTradePrice() {
		return cpcTradePrice;
	}
	public void setCpcTradePrice(Integer cpcTradePrice) {
		this.cpcTradePrice = cpcTradePrice;
	}
	
	
}
