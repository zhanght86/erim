package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @类名: GroundPriceBean
 * @描述: 当地游量价管理信息实体
 * @作者: 宁晓强
 * @创建时间: 2015年10月25日 上午9:36:50
 */
public class GroundPriceBean extends BaseBean implements Serializable {
	
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
	// 产品ID
	private Integer gdlId;
	// 产品名称
	private String 	gdlName;
	// 日期
	private String 	gpeDate;
	// 是否出售
	private String 	gpeIsOpen;
	// 星期
	private String	gpeWeek;
	// 可报团人数
	private Integer	gpeSign;
	// 同业成人价
	private Integer	gpeTradeAdult;
	// 同业儿童价
	private Integer gpeTradeChild;
	// 零售成人价
	private	Integer	gpeRetailAdult;
	// 零售儿童价
	private Integer gpeRetailChild;
	// 批发儿童价
	private Integer gpeWholesaleChild;
	// 批发成人价
	private Integer gpeWholesaleAdult;
	// 可选服务单房差价格
	private Integer	gpeSinglePrice;
	// 可选服务单房差说明
	private String	gpeSingleShow;
	// 可选服务保险价格
	private Integer	gpeInsurePrice;
	// 可选服务保险说明
	private String	gpeInsureShow;
	//　是否可升级
	private String	gpeIsUpgrade;
	// 升级内容
	private String	gpeUpgradeCont;
	// 升级费用
	private Integer	gpeUpgradeAdult;
	// 升级内容儿童价
	private Integer	gpeUpgradeChild;
	// 接收报团截止出发前多少天
	private Integer	gpeRestrict;
	// 创建时间
	private Date	gpeCreateTime;
	// 创建用户
	private String	gpeCreateUser;
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
	public Integer getGdlId() {
		return gdlId;
	}
	public void setGdlId(Integer gdlId) {
		this.gdlId = gdlId;
	}
	public String getGdlName() {
		return gdlName;
	}
	public void setGdlName(String gdlName) {
		this.gdlName = gdlName;
	}
	public String getGpeDate() {
		return gpeDate;
	}
	public void setGpeDate(String gpeDate) {
		this.gpeDate = gpeDate;
	}
	public String getGpeIsOpen() {
		return gpeIsOpen;
	}
	public void setGpeIsOpen(String gpeIsOpen) {
		this.gpeIsOpen = gpeIsOpen;
	}
	public String getGpeWeek() {
		return gpeWeek;
	}
	public void setGpeWeek(String gpeWeek) {
		this.gpeWeek = gpeWeek;
	}
	public Integer getGpeSign() {
		return gpeSign;
	}
	public void setGpeSign(Integer gpeSign) {
		this.gpeSign = gpeSign;
	}
	public Integer getGpeTradeAdult() {
		return gpeTradeAdult;
	}
	public void setGpeTradeAdult(Integer gpeTradeAdult) {
		this.gpeTradeAdult = gpeTradeAdult;
	}
	public Integer getGpeTradeChild() {
		return gpeTradeChild;
	}
	public void setGpeTradeChild(Integer gpeTradeChild) {
		this.gpeTradeChild = gpeTradeChild;
	}
	public Integer getGpeRetailAdult() {
		return gpeRetailAdult;
	}
	public void setGpeRetailAdult(Integer gpeRetailAdult) {
		this.gpeRetailAdult = gpeRetailAdult;
	}
	public Integer getGpeRetailChild() {
		return gpeRetailChild;
	}
	public void setGpeRetailChild(Integer gpeRetailChild) {
		this.gpeRetailChild = gpeRetailChild;
	}
	public Integer getGpeSinglePrice() {
		return gpeSinglePrice;
	}
	public void setGpeSinglePrice(Integer gpeSinglePrice) {
		this.gpeSinglePrice = gpeSinglePrice;
	}
	public String getGpeSingleShow() {
		return gpeSingleShow;
	}
	public void setGpeSingleShow(String gpeSingleShow) {
		this.gpeSingleShow = gpeSingleShow;
	}
	public Integer getGpeInsurePrice() {
		return gpeInsurePrice;
	}
	public void setGpeInsurePrice(Integer gpeInsurePrice) {
		this.gpeInsurePrice = gpeInsurePrice;
	}
	public String getGpeInsureShow() {
		return gpeInsureShow;
	}
	public void setGpeInsureShow(String gpeInsureShow) {
		this.gpeInsureShow = gpeInsureShow;
	}
	public String getGpeIsUpgrade() {
		return gpeIsUpgrade;
	}
	public void setGpeIsUpgrade(String gpeIsUpgrade) {
		this.gpeIsUpgrade = gpeIsUpgrade;
	}
	public String getGpeUpgradeCont() {
		return gpeUpgradeCont;
	}
	public void setGpeUpgradeCont(String gpeUpgradeCont) {
		this.gpeUpgradeCont = gpeUpgradeCont;
	}
	public Integer getGpeUpgradeAdult() {
		return gpeUpgradeAdult;
	}
	public void setGpeUpgradeAdult(Integer gpeUpgradeAdult) {
		this.gpeUpgradeAdult = gpeUpgradeAdult;
	}
	public Integer getGpeUpgradeChild() {
		return gpeUpgradeChild;
	}
	public void setGpeUpgradeChild(Integer gpeUpgradeChild) {
		this.gpeUpgradeChild = gpeUpgradeChild;
	}
	public Integer getGpeRestrict() {
		return gpeRestrict;
	}
	public void setGpeRestrict(Integer gpeRestrict) {
		this.gpeRestrict = gpeRestrict;
	}
	public Date getGpeCreateTime() {
		return gpeCreateTime;
	}
	public void setGpeCreateTime(Date gpeCreateTime) {
		this.gpeCreateTime = gpeCreateTime;
	}
	public String getGpeCreateUser() {
		return gpeCreateUser;
	}
	public void setGpeCreateUser(String gpeCreateUser) {
		this.gpeCreateUser = gpeCreateUser;
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
	public Integer getGpeWholesaleChild() {
		return gpeWholesaleChild;
	}
	public void setGpeWholesaleChild(Integer gpeWholesaleChild) {
		this.gpeWholesaleChild = gpeWholesaleChild;
	}
	public Integer getGpeWholesaleAdult() {
		return gpeWholesaleAdult;
	}
	public void setGpeWholesaleAdult(Integer gpeWholesaleAdult) {
		this.gpeWholesaleAdult = gpeWholesaleAdult;
	}
	public String getIsPredetermine() {
		return isPredetermine;
	}
	public void setIsPredetermine(String isPredetermine) {
		this.isPredetermine = isPredetermine;
	}
	
	
	
	
}
