package com.erim.sz.common.bean;

import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @类名: GuidePriceBean
 * @描述: 导游（领队）管理信息实体
 * @作者: 宁晓强
 * @创建时间: 2015年10月20日 下午2:46:13
 *
 */
public class GuidePriceBean extends BaseBean {
	
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
	// 导游ID
	private Integer gdlId;
	// 导游姓名
	private String	gdlName;
	// 服务类型编码
	private String	gdlServiceCode;
	// 服务类型名称
	private String	gdlServiceName;
	// 日期
	private String 	gpeDate;
	// 档期管理
	private String 	gpeIsOpen;
	// 星期
	private String	gpeWeek;
	// 地接价
	private Integer gpeFloorPrice;
	// 组团价
	private Integer gpeClusterPrice;
	// 直客价
	private Integer	gpeGuestPrice;
	// 服务费包括
	private String	gpeService;
	// 服务说明
	private String	gpeServiceShow;
	// 预约类型
	private String	gpeAppointType;
	// 提前预约天数
	private Integer	gpeAppointNum;
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
	// 导游性别
	private String 	sex;
	// 导游证号
	private String	certificate;
	// 服务类型
	private String	isInternal;
	// 当前数据是否允许修改 - 早于今天的数据不允许修改。
  	private String	isUpdate;
	// 是否是今天
  	private String 	isNow;
  	//是否可以预定 选定的日期-当前日期 >=提前预定天数 1：可以预定 0：已过期
  	private String isPredetermine;
  	
	public String getIsNow() {
		return isNow;
	}
	public void setIsNow(String isNow) {
		this.isNow = isNow;
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
	public String getGdlServiceCode() {
		return gdlServiceCode;
	}
	public void setGdlServiceCode(String gdlServiceCode) {
		this.gdlServiceCode = gdlServiceCode;
	}
	public String getGdlServiceName() {
		return gdlServiceName;
	}
	public void setGdlServiceName(String gdlServiceName) {
		this.gdlServiceName = gdlServiceName;
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
	public Integer getGpeFloorPrice() {
		return gpeFloorPrice;
	}
	public void setGpeFloorPrice(Integer gpeFloorPrice) {
		this.gpeFloorPrice = gpeFloorPrice;
	}
	public Integer getGpeClusterPrice() {
		return gpeClusterPrice;
	}
	public void setGpeClusterPrice(Integer gpeClusterPrice) {
		this.gpeClusterPrice = gpeClusterPrice;
	}
	public Integer getGpeGuestPrice() {
		return gpeGuestPrice;
	}
	public void setGpeGuestPrice(Integer gpeGuestPrice) {
		this.gpeGuestPrice = gpeGuestPrice;
	}
	public String getGpeService() {
		return gpeService;
	}
	public void setGpeService(String gpeService) {
		this.gpeService = gpeService;
	}
	public String getGpeServiceShow() {
		return gpeServiceShow;
	}
	public void setGpeServiceShow(String gpeServiceShow) {
		this.gpeServiceShow = gpeServiceShow;
	}
	public String getGpeAppointType() {
		return gpeAppointType;
	}
	public void setGpeAppointType(String gpeAppointType) {
		this.gpeAppointType = gpeAppointType;
	}
	public Integer getGpeAppointNum() {
		return gpeAppointNum;
	}
	public void setGpeAppointNum(Integer gpeAppointNum) {
		this.gpeAppointNum = gpeAppointNum;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getIsInternal() {
		return isInternal;
	}
	public void setIsInternal(String isInternal) {
		this.isInternal = isInternal;
	}
	public String getIsPredetermine() {
		return isPredetermine;
	}
	public void setIsPredetermine(String isPredetermine) {
		this.isPredetermine = isPredetermine;
	}
	
	
	
}
