package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: TexiOrderBean
 * @Description: 租车订单管理
 * @author 陈鹏
 * @date 2015年7月10日 下午9:46:06
 *
 */
public class TexiOrderBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//订单编号
	private String torCode;
	//总价格
	private int torTotalprice;
	//确认订单
	private String torIssure;
	//线上支付
	private int torPayOnline;
	//线下支付
	private int torPayOffline;
	//最终支付
	private int torPayMoney;
	//确认/拒接 
	private String torNtype;
	//创建时间
	private Date torCreatetime;
	//创建用户
	private String torCreateuser;
	//公司id
	private Integer cpyId;
	//	是否审核
	private String torIsThrough;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTorCode() {
		return torCode;
	}
	public void setTorCode(String torCode) {
		this.torCode = torCode;
	}
	
	public String getTorIssure() {
		return torIssure;
	}
	public void setTorIssure(String torIssure) {
		this.torIssure = torIssure;
	}
	
	public int getTorTotalprice() {
		return torTotalprice;
	}
	public void setTorTotalprice(int torTotalprice) {
		this.torTotalprice = torTotalprice;
	}
	public int getTorPayOnline() {
		return torPayOnline;
	}
	public void setTorPayOnline(int torPayOnline) {
		this.torPayOnline = torPayOnline;
	}
	public int getTorPayOffline() {
		return torPayOffline;
	}
	public void setTorPayOffline(int torPayOffline) {
		this.torPayOffline = torPayOffline;
	}
	public int getTorPayMoney() {
		return torPayMoney;
	}
	public void setTorPayMoney(int torPayMoney) {
		this.torPayMoney = torPayMoney;
	}
	public String getTorNtype() {
		return torNtype;
	}
	public void setTorNtype(String torNtype) {
		this.torNtype = torNtype;
	}
	public Date getTorCreatetime() {
		return torCreatetime;
	}
	public void setTorCreatetime(Date torCreatetime) {
		this.torCreatetime = torCreatetime;
	}
	public String getTorCreateuser() {
		return torCreateuser;
	}
	public void setTorCreateuser(String torCreateuser) {
		this.torCreateuser = torCreateuser;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getTorIsThrough() {
		return torIsThrough;
	}
	public void setTorIsThrough(String torIsThrough) {
		this.torIsThrough = torIsThrough;
	}


}
