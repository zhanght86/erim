package com.erim.sz.common.bean;

import com.erim.core.bean.BaseBean;

/**
 * @描述: 固定接送
 * 
 * @作者: 陈鹏
 * @创建时间: 2015年7月10日 下午9:46:06
 */
public class TexiSendBean extends BaseBean {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	// id
	private Integer id;
	// 出租车ID
	private Integer tdlId;
	// 出租车名称
	private String  tdlName;
	// 是否上下架
	private String gdlDelStatus;
	// 产品ID
	private String gdlCode;
	// 线路类型
	private String gdlType;
	// 国内国际
	private String gdlSendnation;
	// 香港澳门台湾
	private String gdlSendintand;
	// 国家
	private String gdlSendforgen;
	// 城市
	private String gdlSendforgencity;
	// 省
	private String gdlSendprivnce;
	// 市
	private String gdlSendcity;
	// 区县
	private String gdlSendcounty;
	
	/**
	 * 接机字段
	 */
	//接机出发
	private String gdlStart;
	//接机到达
	private String gdlEnd;
	//接机费用说明
	private String gdlMoney;
	//接机服务说明
	private String gdlShow;
	
	/**
	 * 送机字段
	 */
	//送机出发
	private String gdlMachine;
	//送机到达
	private String gdlMachineback;
	//送机费用说明
	private String gdlMachinemoney;
	//送机服务说明
	private String gdlMachineshow;
	
	/**
	 * 接站字段
	 */
	//接站出发
	private String gdlStation;
	//接站到达
	private String gdlStationup;
	//接站费用说明
	private String gdlStationmoney;
	//接站说明
	private String gdlStationshow;
	
	/**
	 * 送站字段
	 */
	//送站出发
	private String gdlStationback;
	//送站到达
	private String gdlStationnup;
	//送站费用说明
	private String gdlStationbackmoney;
	//送站服务说明
	private String gdlStationbackshow;
	
	/**
	 * 固定线路
	 */
	//固定线路出发
	private String gdlStartcity;
	//固定线路到达
	private String gdlEndcity;
	//固定线路费用说明
	private String gdlCitymoney;
	//固定线路说明
	private String gdlCityshow;
	
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
	public String getGdlDelStatus() {
		return gdlDelStatus;
	}
	public void setGdlDelStatus(String gdlDelStatus) {
		this.gdlDelStatus = gdlDelStatus;
	}
	public String getGdlCode() {
		return gdlCode;
	}
	public void setGdlCode(String gdlCode) {
		this.gdlCode = gdlCode;
	}
	public String getGdlType() {
		return gdlType;
	}
	public void setGdlType(String gdlType) {
		this.gdlType = gdlType;
	}
	public String getGdlStart() {
		return gdlStart;
	}
	public void setGdlStart(String gdlStart) {
		this.gdlStart = gdlStart;
	}
	public String getGdlEnd() {
		return gdlEnd;
	}
	public void setGdlEnd(String gdlEnd) {
		this.gdlEnd = gdlEnd;
	}
	public String getGdlMoney() {
		return gdlMoney;
	}
	public void setGdlMoney(String gdlMoney) {
		this.gdlMoney = gdlMoney;
	}
	public String getGdlShow() {
		return gdlShow;
	}
	public void setGdlShow(String gdlShow) {
		this.gdlShow = gdlShow;
	}
	public String getGdlMachine() {
		return gdlMachine;
	}
	public void setGdlMachine(String gdlMachine) {
		this.gdlMachine = gdlMachine;
	}
	public String getGdlMachineback() {
		return gdlMachineback;
	}
	public void setGdlMachineback(String gdlMachineback) {
		this.gdlMachineback = gdlMachineback;
	}
	public String getGdlMachinemoney() {
		return gdlMachinemoney;
	}
	public void setGdlMachinemoney(String gdlMachinemoney) {
		this.gdlMachinemoney = gdlMachinemoney;
	}
	public String getGdlMachineshow() {
		return gdlMachineshow;
	}
	public void setGdlMachineshow(String gdlMachineshow) {
		this.gdlMachineshow = gdlMachineshow;
	}
	public String getGdlStation() {
		return gdlStation;
	}
	public void setGdlStation(String gdlStation) {
		this.gdlStation = gdlStation;
	}
	public String getGdlStationup() {
		return gdlStationup;
	}
	public void setGdlStationup(String gdlStationup) {
		this.gdlStationup = gdlStationup;
	}
	public String getGdlStationmoney() {
		return gdlStationmoney;
	}
	public void setGdlStationmoney(String gdlStationmoney) {
		this.gdlStationmoney = gdlStationmoney;
	}
	public String getGdlStationshow() {
		return gdlStationshow;
	}
	public void setGdlStationshow(String gdlStationshow) {
		this.gdlStationshow = gdlStationshow;
	}
	public String getGdlStationback() {
		return gdlStationback;
	}
	public void setGdlStationback(String gdlStationback) {
		this.gdlStationback = gdlStationback;
	}
	public String getGdlStationnup() {
		return gdlStationnup;
	}
	public void setGdlStationnup(String gdlStationnup) {
		this.gdlStationnup = gdlStationnup;
	}
	public String getGdlStationbackmoney() {
		return gdlStationbackmoney;
	}
	public void setGdlStationbackmoney(String gdlStationbackmoney) {
		this.gdlStationbackmoney = gdlStationbackmoney;
	}
	public String getGdlStationbackshow() {
		return gdlStationbackshow;
	}
	public void setGdlStationbackshow(String gdlStationbackshow) {
		this.gdlStationbackshow = gdlStationbackshow;
	}
	public String getGdlStartcity() {
		return gdlStartcity;
	}
	public void setGdlStartcity(String gdlStartcity) {
		this.gdlStartcity = gdlStartcity;
	}
	public String getGdlEndcity() {
		return gdlEndcity;
	}
	public void setGdlEndcity(String gdlEndcity) {
		this.gdlEndcity = gdlEndcity;
	}
	public String getGdlCitymoney() {
		return gdlCitymoney;
	}
	public void setGdlCitymoney(String gdlCitymoney) {
		this.gdlCitymoney = gdlCitymoney;
	}
	public String getGdlCityshow() {
		return gdlCityshow;
	}
	public void setGdlCityshow(String gdlCityshow) {
		this.gdlCityshow = gdlCityshow;
	}
	public String getTdlName() {
		return tdlName;
	}
	public void setTdlName(String tdlName) {
		this.tdlName = tdlName;
	}
	public String getGdlSendprivnce() {
		return gdlSendprivnce;
	}
	public void setGdlSendprivnce(String gdlSendprivnce) {
		this.gdlSendprivnce = gdlSendprivnce;
	}
	public String getGdlSendcity() {
		return gdlSendcity;
	}
	public void setGdlSendcity(String gdlSendcity) {
		this.gdlSendcity = gdlSendcity;
	}
	public String getGdlSendnation() {
		return gdlSendnation;
	}
	public void setGdlSendnation(String gdlSendnation) {
		this.gdlSendnation = gdlSendnation;
	}
	public String getGdlSendcounty() {
		return gdlSendcounty;
	}
	public void setGdlSendcounty(String gdlSendcounty) {
		this.gdlSendcounty = gdlSendcounty;
	}
	public String getGdlSendintand() {
		return gdlSendintand;
	}
	public void setGdlSendintand(String gdlSendintand) {
		this.gdlSendintand = gdlSendintand;
	}
	public String getGdlSendforgen() {
		return gdlSendforgen;
	}
	public void setGdlSendforgen(String gdlSendforgen) {
		this.gdlSendforgen = gdlSendforgen;
	}
	public String getGdlSendforgencity() {
		return gdlSendforgencity;
	}
	public void setGdlSendforgencity(String gdlSendforgencity) {
		this.gdlSendforgencity = gdlSendforgencity;
	}
	
}
