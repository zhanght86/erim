package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * 
 * 项目名称：P15009902 
 * 类名称：GroundOrderBean 
 * 类描述： 地接旅行订单 
 * 创建人：龙龙 
 * 创建时间：2015年7月23日 
 * 修改备注：
 * 
 * @version
 *
 */

public class GroundOrderBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	// 产品编号
	private String gdoNo;
	// 地接服务
	private String gdoService;
	// 订单内容
	private String gdoContent;
	// 公司ID
	private Integer cpyId;
	// 电话
	private String gdoTel;
	// 成交价格
	private int gdoPrice;
	// 在线付款
	private int gdoPriceOnline;
	// 线下付款
	private int gdoPriceOffline;
	// 最终付款
	private int gdoPriceTotal;
	// 下单用户
	private String gdoCreateuser;
	// 创建时间
	private Date gdoCreatetime;
	//是否通过审核1 是 0 否
	private String gdoIsThrough;
	//接单拒单
	private String gdoNtp;

	

	public String getGdoNtp() {
		return gdoNtp;
	}

	public void setGdoNtp(String gdoNtp) {
		this.gdoNtp = gdoNtp;
	}

	public String getGdoIsThrough() {
		return gdoIsThrough;
	}

	public void setGdoIsThrough(String gdoIsThrough) {
		this.gdoIsThrough = gdoIsThrough;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGdoNo() {
		return gdoNo;
	}

	public void setGdoNo(String gdoNo) {
		this.gdoNo = gdoNo;
	}

	public String getGdoService() {
		return gdoService;
	}

	public void setGdoService(String gdoService) {
		this.gdoService = gdoService;
	}

	public String getGdoContent() {
		return gdoContent;
	}

	public void setGdoContent(String gdoContent) {
		this.gdoContent = gdoContent;
	}

	public Integer getCpyId() {
		return cpyId;
	}

	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}

	public String getGdoTel() {
		return gdoTel;
	}

	public void setGdoTel(String gdoTel) {
		this.gdoTel = gdoTel;
	}
	
	public int getGdoPrice() {
		return gdoPrice;
	}

	public void setGdoPrice(int gdoPrice) {
		this.gdoPrice = gdoPrice;
	}

	public int getGdoPriceOnline() {
		return gdoPriceOnline;
	}

	public void setGdoPriceOnline(int gdoPriceOnline) {
		this.gdoPriceOnline = gdoPriceOnline;
	}

	public int getGdoPriceOffline() {
		return gdoPriceOffline;
	}

	public void setGdoPriceOffline(int gdoPriceOffline) {
		this.gdoPriceOffline = gdoPriceOffline;
	}

	public int getGdoPriceTotal() {
		return gdoPriceTotal;
	}

	public void setGdoPriceTotal(int gdoPriceTotal) {
		this.gdoPriceTotal = gdoPriceTotal;
	}

	public String getGdoCreateuser() {
		return gdoCreateuser;
	}

	public void setGdoCreateuser(String gdoCreateuser) {
		this.gdoCreateuser = gdoCreateuser;
	}

	public Date getGdoCreatetime() {
		return gdoCreatetime;
	}

	public void setGdoCreatetime(Date gdoCreatetime) {
		this.gdoCreatetime = gdoCreatetime;
	}

}
