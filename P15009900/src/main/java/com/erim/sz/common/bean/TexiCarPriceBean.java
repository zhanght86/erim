package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @类名: TexiSendPriceBean
 * @描述: 租车管理包车量价管理信息实体
 * @作者: 宁晓强
 * @创建时间: 2015年10月13日 下午3:27:51
 *
 */
public class TexiCarPriceBean extends BaseBean implements Serializable {

	/**
	 * @Fileds serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	// 包车ID
	private Integer bclId;
	// 包车类型
	private String	bclType;
	// 日期 yyyy-MM-dd
	private String	tcpDate;
	// 是否出售 02是 01否
	private String 	tcpIsOpen;
	// 星期
	private String	tcpWeek;
	// 可同时接单数量
	private Integer	tcpSign;
	// 全天同业价
	private Integer tcpTradePrice;
	// 全天批发价
	private Integer	tcpCombinationPrice;
	// 全天零售价
	private Integer tcpRetailPrice;
	// 费用说明
	private String	tcpPriceShow;
	// 取消订单限制
	private String	tcpCancelIndent;
	// 创建时间
	private Date	tcpCreateTime;
	// 创建用户
	private String	tcpCreateUser;
	// 公司ID
	private Integer cpyId;
	
	/**
	 * 转码
	 */
	// 入口号
	private String	dicPortal;
	// 开始时间
	private String 	start;
	// 结束时间
	private String 	end;
	// 星期
	private String 	week;
	// 日历号
  	private String 	day;
  	// 租车ID
  	private Integer tdlId;
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
	public Integer getBclId() {
		return bclId;
	}
	public void setBclId(Integer bclId) {
		this.bclId = bclId;
	}
	public String getBclType() {
		return bclType;
	}
	public void setBclType(String bclType) {
		this.bclType = bclType;
	}
	public String getTcpDate() {
		return tcpDate;
	}
	public void setTcpDate(String tcpDate) {
		this.tcpDate = tcpDate;
	}
	public String getTcpIsOpen() {
		return tcpIsOpen;
	}
	public void setTcpIsOpen(String tcpIsOpen) {
		this.tcpIsOpen = tcpIsOpen;
	}
	public String getTcpWeek() {
		return tcpWeek;
	}
	public void setTcpWeek(String tcpWeek) {
		this.tcpWeek = tcpWeek;
	}
	public Integer getTcpSign() {
		return tcpSign;
	}
	public void setTcpSign(Integer tcpSign) {
		this.tcpSign = tcpSign;
	}
	public Integer getTcpTradePrice() {
		return tcpTradePrice;
	}
	public void setTcpTradePrice(Integer tcpTradePrice) {
		this.tcpTradePrice = tcpTradePrice;
	}
	public Integer getTcpCombinationPrice() {
		return tcpCombinationPrice;
	}
	public void setTcpCombinationPrice(Integer tcpCombinationPrice) {
		this.tcpCombinationPrice = tcpCombinationPrice;
	}
	public Integer getTcpRetailPrice() {
		return tcpRetailPrice;
	}
	public void setTcpRetailPrice(Integer tcpRetailPrice) {
		this.tcpRetailPrice = tcpRetailPrice;
	}
	public String getTcpPriceShow() {
		return tcpPriceShow;
	}
	public void setTcpPriceShow(String tcpPriceShow) {
		this.tcpPriceShow = tcpPriceShow;
	}
	public String getTcpCancelIndent() {
		return tcpCancelIndent;
	}
	public void setTcpCancelIndent(String tcpCancelIndent) {
		this.tcpCancelIndent = tcpCancelIndent;
	}
	public Date getTcpCreateTime() {
		return tcpCreateTime;
	}
	public void setTcpCreateTime(Date tcpCreateTime) {
		this.tcpCreateTime = tcpCreateTime;
	}
	public String getTcpCreateUser() {
		return tcpCreateUser;
	}
	public void setTcpCreateUser(String tcpCreateUser) {
		this.tcpCreateUser = tcpCreateUser;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
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
  	
	
}
