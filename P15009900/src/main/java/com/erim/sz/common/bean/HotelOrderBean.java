package com.erim.sz.common.bean;

import java.io.Serializable;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: HotelOrderBean
 * @Description: 酒店订单
 * @author maoxian
 * @date 2015年8月8日 下午3:44:34
 */
public class HotelOrderBean extends BaseBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	// 酒店id
	private Integer hdlId;
	// 公司id
	private Integer cpyId;
	// 订单号
	private String  hloNum;
	// 总金额
	private int 	hloPriceTotal;
	// 创建用户
	private String  hldCreateuser;
	// 购买时间
	private String  hldCreatetime;
	// 是否审核通过 1 是 0 否
	private String  hldIsThrough;
	// 接单拒单
	private String  hldNtype;
	// 酒店名称
	private String  hdlName;
	

	public String getHdlName() {
		return hdlName;
	}

	public void setHdlName(String hdlName) {
		this.hdlName = hdlName;
	}

	public String getHldNtype() {
		return hldNtype;
	}

	public void setHldNtype(String hldNtype) {
		this.hldNtype = hldNtype;
	}

	public String getHldIsThrough() {
		return hldIsThrough;
	}

	public void setHldIsThrough(String hldIsThrough) {
		this.hldIsThrough = hldIsThrough;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHdlId() {
		return hdlId;
	}

	public void setHdlId(Integer hdlId) {
		this.hdlId = hdlId;
	}

	public Integer getCpyId() {
		return cpyId;
	}

	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}

	public String getHloNum() {
		return hloNum;
	}

	public void setHloNum(String hloNum) {
		this.hloNum = hloNum;
	}

	public int getHloPriceTotal() {
		return hloPriceTotal;
	}

	public void setHloPriceTotal(int hloPriceTotal) {
		this.hloPriceTotal = hloPriceTotal;
	}

	public String getHldCreateuser() {
		return hldCreateuser;
	}

	public void setHldCreateuser(String hldCreateuser) {
		this.hldCreateuser = hldCreateuser;
	}

	public String getHldCreatetime() {
		return hldCreatetime;
	}

	public void setHldCreatetime(String hldCreatetime) {
		this.hldCreatetime = hldCreatetime;
	}
}
