package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @类名: HotelNumPriceBean
 * @描述: 酒店量价信息管理实体
 * @作者: 宁晓强
 * @创建时间: 2015年10月5日 下午12:11:00
 */
public class HotelPriceBean extends BaseBean implements Serializable {
	
	/**
	 * @Fileds serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	//////////////////////////////////// 自定义字段 ///////////////////////////////////////////////
	
	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	
    //////////////////////////////////// 自定义字段 ///////////////////////////////////////////////
	
	//ID
	private Integer id;
	//房型ID
	private Integer hheId;
	//企业ID
    private Integer cpyId;
    //酒店ID
    private Integer hdlId;
  	//日期 yyyy-MM-dd
  	private String  hnpDate;
    //是否开房 02是01否
  	private String  hnpIsOpen;
  	//星期
  	private String 	hnpWeek;
  	//早餐
  	private String  hnpBreakfast;
  	//同业价
  	private Integer hnpTradePrice;
    //批发价
  	private Integer	hnpCombinationPrice;
  	//零售价
  	private Integer	hnpRetailPrice;
  	//可销售房间数
  	private Integer hnpSign;
  	//早餐开始时
  	private String	hnpStartH;
  	//早餐开始分
  	private String	hnpStartM;
  	//早餐结束时
  	private String	hnpEndH;
  	//早餐结束分
  	private String	hnpEndM;
  	//房费包含其他服务
  	private String	hnpService;
  	//更改/取消规则
  	private String	hnpUpdateRule;
	//当日房售卖时间 / 是否24小时销售 01否 02是
  	private String	hnpSellTime;
  	//当日房售卖时
  	private String	hnpSellH;
  	//当日房售卖分
  	private String	hnpSellM;
  	//创建时间
  	private Date    hnpCreatetime;
  	//创建用户
  	private String	hnpCreateUser;
  	
  	/**
  	 * 转码参数
  	 */
  	// 入口
  	private String  portal;
  	// 开始日期
  	private String	enteringStart;
  	// 结束日期
  	private String 	enteringEnd;
  	// 按周选择
  	private String  week;
  	// 日历号
  	private String 	day;
  	// 当前数据是否允许修改 - 早于今天的数据不允许修改。
  	private String	isUpdate;
  	//是否可以预定 选定的日期-当前日期 >=提前预定天数 1：可以预定 0：已过期
  	private String isPredetermine;
  	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHheId() {
		return hheId;
	}
	public void setHheId(Integer hheId) {
		this.hheId = hheId;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public Integer getHdlId() {
		return hdlId;
	}
	public void setHdlId(Integer hdlId) {
		this.hdlId = hdlId;
	}
	public String getHnpDate() {
		return hnpDate;
	}
	public void setHnpDate(String hnpDate) {
		this.hnpDate = hnpDate;
	}
	public String getHnpIsOpen() {
		return hnpIsOpen;
	}
	public void setHnpIsOpen(String hnpIsOpen) {
		this.hnpIsOpen = hnpIsOpen;
	}
	public String getHnpWeek() {
		return hnpWeek;
	}
	public void setHnpWeek(String hnpWeek) {
		this.hnpWeek = hnpWeek;
	}
	public String getHnpBreakfast() {
		return hnpBreakfast;
	}
	public void setHnpBreakfast(String hnpBreakfast) {
		this.hnpBreakfast = hnpBreakfast;
	}
	public Integer getHnpTradePrice() {
		return hnpTradePrice;
	}
	public void setHnpTradePrice(Integer hnpTradePrice) {
		this.hnpTradePrice = hnpTradePrice;
	}
	public Integer getHnpCombinationPrice() {
		return hnpCombinationPrice;
	}
	public void setHnpCombinationPrice(Integer hnpCombinationPrice) {
		this.hnpCombinationPrice = hnpCombinationPrice;
	}
	public Integer getHnpRetailPrice() {
		return hnpRetailPrice;
	}
	public void setHnpRetailPrice(Integer hnpRetailPrice) {
		this.hnpRetailPrice = hnpRetailPrice;
	}
	public Integer getHnpSign() {
		return hnpSign;
	}
	public void setHnpSign(Integer hnpSign) {
		this.hnpSign = hnpSign;
	}
	public String getHnpStartH() {
		return hnpStartH;
	}
	public void setHnpStartH(String hnpStartH) {
		this.hnpStartH = hnpStartH;
	}
	public String getHnpStartM() {
		return hnpStartM;
	}
	public void setHnpStartM(String hnpStartM) {
		this.hnpStartM = hnpStartM;
	}
	public String getHnpEndH() {
		return hnpEndH;
	}
	public void setHnpEndH(String hnpEndH) {
		this.hnpEndH = hnpEndH;
	}
	public String getHnpEndM() {
		return hnpEndM;
	}
	public void setHnpEndM(String hnpEndM) {
		this.hnpEndM = hnpEndM;
	}
	public String getHnpService() {
		return hnpService;
	}
	public void setHnpService(String hnpService) {
		this.hnpService = hnpService;
	}
	public String getHnpUpdateRule() {
		return hnpUpdateRule;
	}
	public void setHnpUpdateRule(String hnpUpdateRule) {
		this.hnpUpdateRule = hnpUpdateRule;
	}
	public String getHnpSellTime() {
		return hnpSellTime;
	}
	public void setHnpSellTime(String hnpSellTime) {
		this.hnpSellTime = hnpSellTime;
	}
	public String getHnpSellH() {
		return hnpSellH;
	}
	public void setHnpSellH(String hnpSellH) {
		this.hnpSellH = hnpSellH;
	}
	public String getHnpSellM() {
		return hnpSellM;
	}
	public void setHnpSellM(String hnpSellM) {
		this.hnpSellM = hnpSellM;
	}
	public Date getHnpCreatetime() {
		return hnpCreatetime;
	}
	public void setHnpCreatetime(Date hnpCreatetime) {
		this.hnpCreatetime = hnpCreatetime;
	}
	public String getHnpCreateUser() {
		return hnpCreateUser;
	}
	public void setHnpCreateUser(String hnpCreateUser) {
		this.hnpCreateUser = hnpCreateUser;
	}
	public String getPortal() {
		return portal;
	}
	public void setPortal(String portal) {
		this.portal = portal;
	}
	public String getEnteringStart() {
		return enteringStart;
	}
	public void setEnteringStart(String enteringStart) {
		this.enteringStart = enteringStart;
	}
	public String getEnteringEnd() {
		return enteringEnd;
	}
	public void setEnteringEnd(String enteringEnd) {
		this.enteringEnd = enteringEnd;
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
