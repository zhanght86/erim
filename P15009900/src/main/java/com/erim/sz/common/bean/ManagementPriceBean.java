package com.erim.sz.common.bean;

import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @描述: 签证价格管理信息实体
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月7日 上午11:27:08
 */
public class ManagementPriceBean extends BaseBean {
	
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
	// 签证ID
	private Integer mdlId;
	// 签证名称
	private String	mdlName;
	// 是否开放
	private String	mdlIsOpen;
	// 日期
	private String	mdlDate;
	// 星期
	private String	mdlWeek;
	// 同业价
	private String 	mdlPriceSame;
	// 批发价
	private String 	mdlPriceTeam;
	// 零售价
	private String 	mdlPriceSeal;
	// 创建用户
	private Date	mdlCreateTime;
	// 创建时间
	private String	mdlCreateUser;
	// 费用说明
	private String mdlCostShow;
	
	/**
	 * 转码参数
	 */
	// 入口
	private String 	portal;
	// 开始日期
	private String 	start;
	// 结束日期
	private String 	end;
	// 按周选择
	private String	week;
	// 日历号
	private String	day;
	// 从前数据是否允许修改 - 早于今天的数据不允许修改
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMdlId() {
		return mdlId;
	}
	public void setMdlId(Integer mdlId) {
		this.mdlId = mdlId;
	}
	public String getMdlName() {
		return mdlName;
	}
	public void setMdlName(String mdlName) {
		this.mdlName = mdlName;
	}
	public String getMdlIsOpen() {
		return mdlIsOpen;
	}
	public void setMdlIsOpen(String mdlIsOpen) {
		this.mdlIsOpen = mdlIsOpen;
	}
	public String getMdlDate() {
		return mdlDate;
	}
	public void setMdlDate(String mdlDate) {
		this.mdlDate = mdlDate;
	}
	public String getMdlWeek() {
		return mdlWeek;
	}
	public void setMdlWeek(String mdlWeek) {
		this.mdlWeek = mdlWeek;
	}
	public String getMdlPriceSame() {
		return mdlPriceSame;
	}
	public void setMdlPriceSame(String mdlPriceSame) {
		this.mdlPriceSame = mdlPriceSame;
	}
	public String getMdlPriceTeam() {
		return mdlPriceTeam;
	}
	public void setMdlPriceTeam(String mdlPriceTeam) {
		this.mdlPriceTeam = mdlPriceTeam;
	}
	public String getMdlPriceSeal() {
		return mdlPriceSeal;
	}
	public void setMdlPriceSeal(String mdlPriceSeal) {
		this.mdlPriceSeal = mdlPriceSeal;
	}
	public Date getMdlCreateTime() {
		return mdlCreateTime;
	}
	public void setMdlCreateTime(Date mdlCreateTime) {
		this.mdlCreateTime = mdlCreateTime;
	}
	public String getMdlCreateUser() {
		return mdlCreateUser;
	}
	public void setMdlCreateUser(String mdlCreateUser) {
		this.mdlCreateUser = mdlCreateUser;
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
	public String getMdlCostShow() {
		return mdlCostShow;
	}
	public void setMdlCostShow(String mdlCostShow) {
		this.mdlCostShow = mdlCostShow;
	}
	
	
	
}
