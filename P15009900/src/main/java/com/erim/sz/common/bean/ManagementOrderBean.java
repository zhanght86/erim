package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: ManagementOrderBean
 * @Description: 签证管理
 * @author maoxian
 * @date 2015年7月11日 下午2:04:14
 *
 */
public class ManagementOrderBean extends BaseBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	// 订单编号
	private String morCode;
	// 总价格
	private int morTotalprice;
	// 确认订单
	private String morIssure;
	// 线上支付
	private int morPayOnline;
	// 线下支付
	private int morPayOffline;
	// 最终支付
	private int morPayMoney;
	// 确认/拒接
	private String morNtype;
	// 创建时间
	private Date morCreatetime;
	// 创建用户
	private String morCreateuser;
	// 是否审核通过 1 是 0 否
	private String morIsThrough;
	//接单拒单
	private String morNpt;
	//企业ID
    private Integer cpyId;
	
	public Integer getCpyId() {
		return cpyId;
	}

	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}

	public String getMorNpt() {
		return morNpt;
	}

	public void setMorNpt(String morNpt) {
		this.morNpt = morNpt;
	}

	public String getMorIsThrough() {
		return morIsThrough;
	}

	public void setMorIsThrough(String morIsThrough) {
		this.morIsThrough = morIsThrough;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMorCode() {
		return morCode;
	}

	public void setMorCode(String morCode) {
		this.morCode = morCode;
	}

	

	public String getMorIssure() {
		return morIssure;
	}

	public void setMorIssure(String morIssure) {
		this.morIssure = morIssure;
	}
	
	public int getMorTotalprice() {
		return morTotalprice;
	}

	public void setMorTotalprice(int morTotalprice) {
		this.morTotalprice = morTotalprice;
	}

	public int getMorPayOnline() {
		return morPayOnline;
	}

	public void setMorPayOnline(int morPayOnline) {
		this.morPayOnline = morPayOnline;
	}

	public int getMorPayOffline() {
		return morPayOffline;
	}

	public void setMorPayOffline(int morPayOffline) {
		this.morPayOffline = morPayOffline;
	}

	public int getMorPayMoney() {
		return morPayMoney;
	}

	public void setMorPayMoney(int morPayMoney) {
		this.morPayMoney = morPayMoney;
	}

	public String getMorNtype() {
		return morNtype;
	}

	public void setMorNtype(String morNtype) {
		this.morNtype = morNtype;
	}

	public Date getMorCreatetime() {
		return morCreatetime;
	}

	public void setMorCreatetime(Date morCreatetime) {
		this.morCreatetime = morCreatetime;
	}

	public String getMorCreateuser() {
		return morCreateuser;
	}

	public void setMorCreateuser(String morCreateuser) {
		this.morCreateuser = morCreateuser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
