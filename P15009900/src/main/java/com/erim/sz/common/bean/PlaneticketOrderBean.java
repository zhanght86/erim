package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * 
 * 项目名称：P15009902 
 * 类名称：PlaneticketOrderBean 
 * 类描述：飞 机票订单管理
 * 创建人：龙龙 
 * 创建时间：2015年7月23日
 * 修改备注：
 * 
 * @version
 *
 */

public class PlaneticketOrderBean extends BaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	// 航班号
	private String ptoNum;
	//产品编号
	private String ptoCode;
	// 航空公司
	private String ptoCommpany;
	// 出发时间
	private Date ptoStartTime;
	// 出发地点
	private String ptoStartAddress;
	// 到达时间
	private Date ptoEndTime;
	// 到达地点
	private String ptoEndAddress;
	// 舱位
	private String ptoBerth;
	// 机票价格
	private int ptoPrice;
	// 订购数量
	private Integer ptoTotal;
	// 公司ID
	private Integer cpyId;
	// 购买用户
	private String cpyCreateuser;
	// 购买时间
	private Date   ptoCreatetime;
	// 线上付款
	private int ptoPriceOnline;
	// 线下付款
	private int ptoPriceOffline;
	//接单拒单
	private String potNtype;
	
	public String getPotNtype() {
		return potNtype;
	}

	public void setPotNtype(String potNtype) {
		this.potNtype = potNtype;
	}

	private String ptoIsThrough;

	public String getPtoIsThrough() {
		return ptoIsThrough;
	}

	public void setPtoIsThrough(String ptoIsThrough) {
		this.ptoIsThrough = ptoIsThrough;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPtoNum() {
		return ptoNum;
	}

	public void setPtoNum(String ptoNum) {
		this.ptoNum = ptoNum;
	}

	public String getPtoCommpany() {
		return ptoCommpany;
	}

	public void setPtoCommpany(String ptoCommpany) {
		this.ptoCommpany = ptoCommpany;
	}

	public Date getPtoStartTime() {
		return ptoStartTime;
	}

	public void setPtoStartTime(Date ptoStartTime) {
		this.ptoStartTime = ptoStartTime;
	}

	public String getPtoStartAddress() {
		return ptoStartAddress;
	}

	public void setPtoStartAddress(String ptoStartAddress) {
		this.ptoStartAddress = ptoStartAddress;
	}

	public Date getPtoEndTime() {
		return ptoEndTime;
	}

	public void setPtoEndTime(Date ptoEndTime) {
		this.ptoEndTime = ptoEndTime;
	}

	public String getPtoEndAddress() {
		return ptoEndAddress;
	}

	public void setPtoEndAddress(String ptoEndAddress) {
		this.ptoEndAddress = ptoEndAddress;
	}

	public String getPtoBerth() {
		return ptoBerth;
	}

	public void setPtoBerth(String ptoBerth) {
		this.ptoBerth = ptoBerth;
	}

	

	public int getPtoPrice() {
		return ptoPrice;
	}

	public void setPtoPrice(int ptoPrice) {
		this.ptoPrice = ptoPrice;
	}

	public Integer getPtoTotal() {
		return ptoTotal;
	}

	public void setPtoTotal(Integer ptoTotal) {
		this.ptoTotal = ptoTotal;
	}

	public Integer getCpyId() {
		return cpyId;
	}

	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}

	public String getCpyCreateuser() {
		return cpyCreateuser;
	}

	public void setCpyCreateuser(String cpyCreateuser) {
		this.cpyCreateuser = cpyCreateuser;
	}

	public Date getPtoCreatetime() {
		return ptoCreatetime;
	}

	public void setPtoCreatetime(Date ptoCreatetime) {
		this.ptoCreatetime = ptoCreatetime;
	}

	public int getPtoPriceOnline() {
		return ptoPriceOnline;
	}

	public void setPtoPriceOnline(int ptoPriceOnline) {
		this.ptoPriceOnline = ptoPriceOnline;
	}

	public int getPtoPriceOffline() {
		return ptoPriceOffline;
	}

	public void setPtoPriceOffline(int ptoPriceOffline) {
		this.ptoPriceOffline = ptoPriceOffline;
	}

	public String getPtoCode() {
		return ptoCode;
	}

	public void setPtoCode(String ptoCode) {
		this.ptoCode = ptoCode;
	}

	

}
