package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @类名: TexiSendPriceBean
 * @描述: 租车管理自驾量价管理信息实体
 * @作者: 宁晓强
 * @创建时间: 2015年10月16日 下午3:27:51
 *
 */
public class TexiDrivePriceBean extends BaseBean implements Serializable {

	/**
	 * @Fileds serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	// 自驾ID
	private Integer zjlId;
	// 自驾类型
	private String	zjlType;
	// 日期 yyyy-MM-dd
	private String	tdpDate;
	// 是否出售 02是 01否
	private String 	tdpIsOpen;
	// 星期
	private String	tdpWeek;
	// 可同时接单数量
	private Integer	tdpSign;
	// 全天同业价
	private Integer tdpTradePrice;
	// 全天批发价
	private Integer	tdpCombinationPrice;
	// 全天零售价
	private Integer tdpRetailPrice;
	// 创建时间
	private Date	tdpCreateTime;
	// 创建用户
	private String	tdpCreateUser;
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
  	
   	/**
   	 * 废弃字段
   	 */
   	// 费用说明
 	private String	tdpPriceShow;
 	// 取消订单限制
 	private String	tdpCancelIndent;
   	
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
	public Integer getZjlId() {
		return zjlId;
	}
	public void setZjlId(Integer zjlId) {
		this.zjlId = zjlId;
	}
	public String getZjlType() {
		return zjlType;
	}
	public void setZjlType(String zjlType) {
		this.zjlType = zjlType;
	}
	public String getTdpDate() {
		return tdpDate;
	}
	public void setTdpDate(String tdpDate) {
		this.tdpDate = tdpDate;
	}
	public String getTdpIsOpen() {
		return tdpIsOpen;
	}
	public void setTdpIsOpen(String tdpIsOpen) {
		this.tdpIsOpen = tdpIsOpen;
	}
	public String getTdpWeek() {
		return tdpWeek;
	}
	public void setTdpWeek(String tdpWeek) {
		this.tdpWeek = tdpWeek;
	}
	public Integer getTdpSign() {
		return tdpSign;
	}
	public void setTdpSign(Integer tdpSign) {
		this.tdpSign = tdpSign;
	}
	public Integer getTdpTradePrice() {
		return tdpTradePrice;
	}
	public void setTdpTradePrice(Integer tdpTradePrice) {
		this.tdpTradePrice = tdpTradePrice;
	}
	public Integer getTdpCombinationPrice() {
		return tdpCombinationPrice;
	}
	public void setTdpCombinationPrice(Integer tdpCombinationPrice) {
		this.tdpCombinationPrice = tdpCombinationPrice;
	}
	public Integer getTdpRetailPrice() {
		return tdpRetailPrice;
	}
	public void setTdpRetailPrice(Integer tdpRetailPrice) {
		this.tdpRetailPrice = tdpRetailPrice;
	}
	public String getTdpPriceShow() {
		return tdpPriceShow;
	}
	public void setTdpPriceShow(String tdpPriceShow) {
		this.tdpPriceShow = tdpPriceShow;
	}
	public String getTdpCancelIndent() {
		return tdpCancelIndent;
	}
	public void setTdpCancelIndent(String tdpCancelIndent) {
		this.tdpCancelIndent = tdpCancelIndent;
	}
	public Date getTdpCreateTime() {
		return tdpCreateTime;
	}
	public void setTdpCreateTime(Date tdpCreateTime) {
		this.tdpCreateTime = tdpCreateTime;
	}
	public String getTdpCreateUser() {
		return tdpCreateUser;
	}
	public void setTdpCreateUser(String tdpCreateUser) {
		this.tdpCreateUser = tdpCreateUser;
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
