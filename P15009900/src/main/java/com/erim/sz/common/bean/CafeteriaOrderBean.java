package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: CafeteriaOrderBean
 * @Description: 特色餐订单管理
 * @author 陈鹏
 * @date 2015年7月11日 下午1:19:24
 *
 */
public class CafeteriaOrderBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	// 订单编号
	private String  corCode;
	// 总价格
	private int     corTotalprice;
	// 确认订单
	private String  corIssure;
	// 线上支付
	private int     corPayOnline;
	// 线下支付
	private int     corPayOffline;
	// 最终支付
	private int     corPayMoney;
	// 确认/拒接
	private String  corNtype;
	// 创建时间
	private Date    corCreatetime;
	// 创建用户
	private String  corCreateuser;
	// 是否审核通过 1 是 0 否
	private String  corIsThrough;
	//企业ID
	private Integer cpyId;
		
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}

	public String getCorIsThrough() {
		return corIsThrough;
	}

	public void setCorIsThrough(String corIsThrough) {
		this.corIsThrough = corIsThrough;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorCode() {
		return corCode;
	}

	public void setCorCode(String corCode) {
		this.corCode = corCode;
	}
	
	public int getCorPayMoney() {
		return corPayMoney;
	}
	public void setCorPayMoney(int corPayMoney) {
		this.corPayMoney = corPayMoney;
	}
	public int getCorTotalprice() {
		return corTotalprice;
	}
	public void setCorTotalprice(int corTotalprice) {
		this.corTotalprice = corTotalprice;
	}
	public int getCorPayOnline() {
		return corPayOnline;
	}
	public void setCorPayOnline(int corPayOnline) {
		this.corPayOnline = corPayOnline;
	}
	public int getCorPayOffline() {
		return corPayOffline;
	}
	public void setCorPayOffline(int corPayOffline) {
		this.corPayOffline = corPayOffline;
	}
	public String getCorIssure() {
		return corIssure;
	}

	public void setCorIssure(String corIssure) {
		this.corIssure = corIssure;
	}

	

	public String getCorNtype() {
		return corNtype;
	}

	public void setCorNtype(String corNtype) {
		this.corNtype = corNtype;
	}

	public Date getCorCreatetime() {
		return corCreatetime;
	}

	public void setCorCreatetime(Date corCreatetime) {
		this.corCreatetime = corCreatetime;
	}

	public String getCorCreateuser() {
		return corCreateuser;
	}

	public void setCorCreateuser(String corCreateuser) {
		this.corCreateuser = corCreateuser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
