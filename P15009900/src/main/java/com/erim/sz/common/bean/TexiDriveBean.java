package com.erim.sz.common.bean;

import com.erim.core.bean.BaseBean;

/**
 * @描述: 自驾管理
 * 
 * @作者: 陈鹏
 * @创建时间: 2015年7月10日 下午9:46:06
 */
public class TexiDriveBean extends BaseBean {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	// 产品ID
	private Integer tdlId;
	// 自驾类型 01:全天 02：半天
	private String  zjlType;
	// 用车城市
	private String  zjlProvince;
	// 用车城市
	private String  zjlCity;
	// 可否异地还车
	private String  zjlPlaceCar;
	
	/**
	 * 半天
	 */
	//半天限时
	private String  zjlHfLimit;
	//半天限公里
	private String  zjlHfLimitKm;
	//半天的取车地点
	private String  zjlHfTakePlace;
	//半天取车地址
	private String  zjlHfTakeAddress;
	//半天的还车地点
	private String  zjlHfBackPlace;
	//半天还车地址
	private String  zjlHfBackAddress;
	//半天的费用说明
	private String  zjlHfCostShow;
	//半天取车还车须知
	private String  zjlHfBackNotice;
	//半天违章须知
	private String  zjlHfBreachNotice;
	//半天保险说明   
	private String  zjlHfInsuranceNotice; 
	//半天更改/取消订单说明
	private String  zjlHfUpdateNotice;
	//特别备注
	private String  zjlHfSpecialNote;
	
	/**
	 * 全天
	 */
	//全天限时长
	private String  zjlDay;
	//全天限公里
	private String  zjlLimit;
	//全天取车地点
	private String  ZjlTakePlace;
	//全天取车地址  
	private String  zjlTakeAddress; 
	//全天还车地点
	private String  zjlBackPlace;
	//全天还车地址    
	private String  zjlBackAddress; 
	//全天费用说明
	private String  zjlCostShow;
	//全天取还须知
	private String  zjlBackShow;
	//全天违章须知
	private String  zjlBreachNotice;
	//全天保险说明
	private String  zjlInsuranceNotice;
	//全天更改取消订单说明
	private String  zjlUpdateNotice;
	//全天特别备注
	private String  zjlSpecialNotice;
	
	/**
	 * 暂未使用字段
	 */
	//自驾半天
	private String  zjlHalfDay;
	//自驾全天
	private String  zjlAllDay;
	
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
	public String getZjlType() {
		return zjlType;
	}
	public void setZjlType(String zjlType) {
		this.zjlType = zjlType;
	}
	public String getZjlProvince() {
		return zjlProvince;
	}
	public void setZjlProvince(String zjlProvince) {
		this.zjlProvince = zjlProvince;
	}
	public String getZjlCity() {
		return zjlCity;
	}
	public void setZjlCity(String zjlCity) {
		this.zjlCity = zjlCity;
	}
	public String getZjlPlaceCar() {
		return zjlPlaceCar;
	}
	public void setZjlPlaceCar(String zjlPlaceCar) {
		this.zjlPlaceCar = zjlPlaceCar;
	}
	public String getZjlHfLimit() {
		return zjlHfLimit;
	}
	public void setZjlHfLimit(String zjlHfLimit) {
		this.zjlHfLimit = zjlHfLimit;
	}
	public String getZjlHfLimitKm() {
		return zjlHfLimitKm;
	}
	public void setZjlHfLimitKm(String zjlHfLimitKm) {
		this.zjlHfLimitKm = zjlHfLimitKm;
	}
	public String getZjlHfTakePlace() {
		return zjlHfTakePlace;
	}
	public void setZjlHfTakePlace(String zjlHfTakePlace) {
		this.zjlHfTakePlace = zjlHfTakePlace;
	}
	public String getZjlHfTakeAddress() {
		return zjlHfTakeAddress;
	}
	public void setZjlHfTakeAddress(String zjlHfTakeAddress) {
		this.zjlHfTakeAddress = zjlHfTakeAddress;
	}
	public String getZjlHfBackPlace() {
		return zjlHfBackPlace;
	}
	public void setZjlHfBackPlace(String zjlHfBackPlace) {
		this.zjlHfBackPlace = zjlHfBackPlace;
	}
	public String getZjlHfBackAddress() {
		return zjlHfBackAddress;
	}
	public void setZjlHfBackAddress(String zjlHfBackAddress) {
		this.zjlHfBackAddress = zjlHfBackAddress;
	}
	public String getZjlHfCostShow() {
		return zjlHfCostShow;
	}
	public void setZjlHfCostShow(String zjlHfCostShow) {
		this.zjlHfCostShow = zjlHfCostShow;
	}
	public String getZjlHfBackNotice() {
		return zjlHfBackNotice;
	}
	public void setZjlHfBackNotice(String zjlHfBackNotice) {
		this.zjlHfBackNotice = zjlHfBackNotice;
	}
	public String getZjlHfBreachNotice() {
		return zjlHfBreachNotice;
	}
	public void setZjlHfBreachNotice(String zjlHfBreachNotice) {
		this.zjlHfBreachNotice = zjlHfBreachNotice;
	}
	public String getZjlHfInsuranceNotice() {
		return zjlHfInsuranceNotice;
	}
	public void setZjlHfInsuranceNotice(String zjlHfInsuranceNotice) {
		this.zjlHfInsuranceNotice = zjlHfInsuranceNotice;
	}
	public String getZjlHfUpdateNotice() {
		return zjlHfUpdateNotice;
	}
	public void setZjlHfUpdateNotice(String zjlHfUpdateNotice) {
		this.zjlHfUpdateNotice = zjlHfUpdateNotice;
	}
	public String getZjlHfSpecialNote() {
		return zjlHfSpecialNote;
	}
	public void setZjlHfSpecialNote(String zjlHfSpecialNote) {
		this.zjlHfSpecialNote = zjlHfSpecialNote;
	}
	public String getZjlLimit() {
		return zjlLimit;
	}
	public void setZjlLimit(String zjlLimit) {
		this.zjlLimit = zjlLimit;
	}
	public String getZjlTakePlace() {
		return ZjlTakePlace;
	}
	public void setZjlTakePlace(String zjlTakePlace) {
		ZjlTakePlace = zjlTakePlace;
	}
	public String getZjlTakeAddress() {
		return zjlTakeAddress;
	}
	public void setZjlTakeAddress(String zjlTakeAddress) {
		this.zjlTakeAddress = zjlTakeAddress;
	}
	public String getZjlBackPlace() {
		return zjlBackPlace;
	}
	public void setZjlBackPlace(String zjlBackPlace) {
		this.zjlBackPlace = zjlBackPlace;
	}
	public String getZjlBackAddress() {
		return zjlBackAddress;
	}
	public void setZjlBackAddress(String zjlBackAddress) {
		this.zjlBackAddress = zjlBackAddress;
	}
	public String getZjlCostShow() {
		return zjlCostShow;
	}
	public void setZjlCostShow(String zjlCostShow) {
		this.zjlCostShow = zjlCostShow;
	}
	public String getZjlBackShow() {
		return zjlBackShow;
	}
	public void setZjlBackShow(String zjlBackShow) {
		this.zjlBackShow = zjlBackShow;
	}
	public String getZjlBreachNotice() {
		return zjlBreachNotice;
	}
	public void setZjlBreachNotice(String zjlBreachNotice) {
		this.zjlBreachNotice = zjlBreachNotice;
	}
	public String getZjlInsuranceNotice() {
		return zjlInsuranceNotice;
	}
	public void setZjlInsuranceNotice(String zjlInsuranceNotice) {
		this.zjlInsuranceNotice = zjlInsuranceNotice;
	}
	public String getZjlUpdateNotice() {
		return zjlUpdateNotice;
	}
	public void setZjlUpdateNotice(String zjlUpdateNotice) {
		this.zjlUpdateNotice = zjlUpdateNotice;
	}
	public String getZjlSpecialNotice() {
		return zjlSpecialNotice;
	}
	public void setZjlSpecialNotice(String zjlSpecialNotice) {
		this.zjlSpecialNotice = zjlSpecialNotice;
	}
	public String getZjlHalfDay() {
		return zjlHalfDay;
	}
	public void setZjlHalfDay(String zjlHalfDay) {
		this.zjlHalfDay = zjlHalfDay;
	}
	public String getZjlAllDay() {
		return zjlAllDay;
	}
	public void setZjlAllDay(String zjlAllDay) {
		this.zjlAllDay = zjlAllDay;
	}
	public String getZjlDay() {
		return zjlDay;
	}
	public void setZjlDay(String zjlDay) {
		this.zjlDay = zjlDay;
	}
	
}
