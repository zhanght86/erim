package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;
/**
 * 
* @ClassName: LineOrderBean 
* @Description: 专线订单 
* @author 陈鹏
* @date 2015年7月27日 下午3:14:37 
*
 */
public class LineOrderBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	// 订单编号
	private String lorCode;
	// 购买时间
	private Date lorCreateetime;
	// 购买用户
	private String lorCreateuser;
	// 订单内容
	private String lorComment;
	// 订单电话
	private String lorTelephone;
	// 实际价格
	private String lorMoneyTotal;
	// 修改后价格
	private String lorMoneyUpdate;
	// 线上支付
	private String lorPayOnline;
	// 线下支付
	private String lorPayOffline;
	// 最终支付
	private String lorPayMoney;
	// 确认/拒接
	private String lorNtype;
	// ip
	private String lorIp;
	
	//总金额
	private String lorTotalPrice;
	// 是否审核通过 1 是 0 否
	
	private String lorIsThrough;
	
	private Integer cpyId;
	
	public Integer getCpyId() {
		return cpyId;
	}

	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}

	public String getLorIsThrough() {
		return lorIsThrough;
	}

	public void setLorIsThrough(String lorIsThrough) {
		this.lorIsThrough = lorIsThrough;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLorCode() {
		return lorCode;
	}

	public void setLorCode(String lorCode) {
		this.lorCode = lorCode;
	}

	public Date getLorCreateetime() {
		return lorCreateetime;
	}

	public void setLorCreateetime(Date lorCreateetime) {
		this.lorCreateetime = lorCreateetime;
	}

	public String getLorCreateuser() {
		return lorCreateuser;
	}

	public void setLorCreateuser(String lorCreateuser) {
		this.lorCreateuser = lorCreateuser;
	}

	public String getLorComment() {
		return lorComment;
	}

	public void setLorComment(String lorComment) {
		this.lorComment = lorComment;
	}

	public String getLorTelephone() {
		return lorTelephone;
	}

	public void setLorTelephone(String lorTelephone) {
		this.lorTelephone = lorTelephone;
	}

	public String getLorMoneyTotal() {
		return lorMoneyTotal;
	}

	public void setLorMoneyTotal(String lorMoneyTotal) {
		this.lorMoneyTotal = lorMoneyTotal;
	}

	public String getLorMoneyUpdate() {
		return lorMoneyUpdate;
	}

	public void setLorMoneyUpdate(String lorMoneyUpdate) {
		this.lorMoneyUpdate = lorMoneyUpdate;
	}

	public String getLorPayOnline() {
		return lorPayOnline;
	}

	public void setLorPayOnline(String lorPayOnline) {
		this.lorPayOnline = lorPayOnline;
	}

	public String getLorPayOffline() {
		return lorPayOffline;
	}

	public void setLorPayOffline(String lorPayOffline) {
		this.lorPayOffline = lorPayOffline;
	}

	public String getLorPayMoney() {
		return lorPayMoney;
	}

	public void setLorPayMoney(String lorPayMoney) {
		this.lorPayMoney = lorPayMoney;
	}

	public String getLorNtype() {
		return lorNtype;
	}

	public void setLorNtype(String lorNtype) {
		this.lorNtype = lorNtype;
	}

	public String getLorIp() {
		return lorIp;
	}

	public void setLorIp(String lorIp) {
		this.lorIp = lorIp;
	}

	public String getLorTotalPrice() {
		return lorTotalPrice;
	}

	public void setLorTotalPrice(String lorTotalPrice) {
		this.lorTotalPrice = lorTotalPrice;
	}

	

}
