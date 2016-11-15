package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: TicketOrderBean
 * @Description: 门票订单管理
 * @author maoxian
 * @date 2015年7月8日 下午9:59:48
 *
 */
public class TicketOrderBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化版本ID
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	// 数量
	private Integer torNum;
	//订单号
	private String torCode;
	// 联系人
	private String torContactName;
	// 联系方式
	private String torContactPhone;
	// 总金额
	private int torTotalprice;
	// 状态
	private String torState;
	//确认/拒接 
	private String torNtype;
	// 创建时间
	private Date torCreatetime;
	// 创建用户
	private String torCreateuser;
	// 是否审核通过 1 是 0 否
	private String torIsThrough;
	//企业ID
	private Integer cpyId;
		
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTorNum() {
		return torNum;
	}

	public void setTorNum(Integer torNum) {
		this.torNum = torNum;
	}

	public String getTorContactName() {
		return torContactName;
	}

	public void setTorContactName(String torContactName) {
		this.torContactName = torContactName;
	}

	public String getTorContactPhone() {
		return torContactPhone;
	}

	public void setTorContactPhone(String torContactPhone) {
		this.torContactPhone = torContactPhone;
	}
	public int getTorTotalprice() {
		return torTotalprice;
	}
	public void setTorTotalprice(int torTotalprice) {
		this.torTotalprice = torTotalprice;
	}
	public String getTorState() {
		return torState;
	}

	public void setTorState(String torState) {
		this.torState = torState;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTorNtype() {
		return torNtype;
	}

	public void setTorNtype(String torNtype) {
		this.torNtype = torNtype;
	}
	public String getTorCode() {
		return torCode;
	}
	public void setTorCode(String torCode) {
		this.torCode = torCode;
	}

}