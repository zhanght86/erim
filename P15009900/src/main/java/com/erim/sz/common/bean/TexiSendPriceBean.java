package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @类名: TexiSendPriceBean
 * @描述: 租车管理固定接送量价管理信息实体
 * @作者: 宁晓强
 * @创建时间: 2015年10月13日 下午3:27:51
 *
 */
public class TexiSendPriceBean extends BaseBean implements Serializable {

	/**
	 * @Fileds serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	// 接送线路ID
	private Integer sendId;
	// 接送线路类型
	private String	sendType;
	// 日期 yyyy-MM-dd
	private String	tspDate;
	// 是否出售 02是 01否
	private String 	tspIsOpen;
	// 星期
	private String	tspWeek;
	// 可同时接单数量
	private Integer	tspSign;
	// 同业价
	private Integer tspTradePrice;
	// 批发价
	private Integer	tspCombinationPrice;
	// 零售价
	private Integer tspRetailPrice;
	// 加收费用时间 - 时
	private String 	tspSellH;
	// 加收费用时间- 分
	private String 	tspSellM;
	// 加收费用金额
	private Integer tspSellPrice;
	// 费用说明
	private String	tspPriceShow;
	// 取消订单限制
	private String	tspCancelIndent;
	// 创建时间
	private Date	tspCreateTime;
	// 创建用户
	private String	tspCreateUser;
	// 公司ID
	private Integer cpyId;
	
	/**
	 * 转码
	 */
	// 入口号
	private String	dicPortal;
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
	public Integer getSendId() {
		return sendId;
	}
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getTspDate() {
		return tspDate;
	}
	public void setTspDate(String tspDate) {
		this.tspDate = tspDate;
	}
	public String getTspIsOpen() {
		return tspIsOpen;
	}
	public void setTspIsOpen(String tspIsOpen) {
		this.tspIsOpen = tspIsOpen;
	}
	public String getTspWeek() {
		return tspWeek;
	}
	public void setTspWeek(String tspWeek) {
		this.tspWeek = tspWeek;
	}
	public Integer getTspSign() {
		return tspSign;
	}
	public void setTspSign(Integer tspSign) {
		this.tspSign = tspSign;
	}
	public Integer getTspTradePrice() {
		return tspTradePrice;
	}
	public void setTspTradePrice(Integer tspTradePrice) {
		this.tspTradePrice = tspTradePrice;
	}
	public Integer getTspCombinationPrice() {
		return tspCombinationPrice;
	}
	public void setTspCombinationPrice(Integer tspCombinationPrice) {
		this.tspCombinationPrice = tspCombinationPrice;
	}
	public Integer getTspRetailPrice() {
		return tspRetailPrice;
	}
	public void setTspRetailPrice(Integer tspRetailPrice) {
		this.tspRetailPrice = tspRetailPrice;
	}
	public String getTspSellH() {
		return tspSellH;
	}
	public void setTspSellH(String tspSellH) {
		this.tspSellH = tspSellH;
	}
	public String getTspSellM() {
		return tspSellM;
	}
	public void setTspSellM(String tspSellM) {
		this.tspSellM = tspSellM;
	}
	public Integer getTspSellPrice() {
		return tspSellPrice;
	}
	public void setTspSellPrice(Integer tspSellPrice) {
		this.tspSellPrice = tspSellPrice;
	}
	public String getTspPriceShow() {
		return tspPriceShow;
	}
	public void setTspPriceShow(String tspPriceShow) {
		this.tspPriceShow = tspPriceShow;
	}
	public String getTspCancelIndent() {
		return tspCancelIndent;
	}
	public void setTspCancelIndent(String tspCancelIndent) {
		this.tspCancelIndent = tspCancelIndent;
	}
	public Date getTspCreateTime() {
		return tspCreateTime;
	}
	public void setTspCreateTime(Date tspCreateTime) {
		this.tspCreateTime = tspCreateTime;
	}
	public String getTspCreateUser() {
		return tspCreateUser;
	}
	public void setTspCreateUser(String tspCreateUser) {
		this.tspCreateUser = tspCreateUser;
	}
	public String getDicPortal() {
		return dicPortal;
	}
	public void setDicPortal(String dicPortal) {
		this.dicPortal = dicPortal;
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
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
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
	
}
