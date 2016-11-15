package com.erim.sz.common.bean;

/**
 * @ClassName: VTexiCar 
 * @Description: 租车信息
 * @author maoxian
 * @date 2015年12月20日 下午6:33:34
 */
public class VTexiPriceBean {
	
////////////////////////////////////自定义字段 ///////////////////////////////////////////////
	
	//开始时间
	private String startDate;
	//结束时间
	private String endDate;
	//id|||type,id1|||type
	private String idType; 

////////////////////////////////////自定义字段 ///////////////////////////////////////////////

	// 序号
	private Integer tcpId;
	// 可接单数量
	private Integer tcpSign;
	// 日期
	private String  tcpDate;
	// 批发价
	private Integer tcpCombinationPrice;
	// 零售价
	private Integer tcpRetailPrice;
	// 类型
	private String  tcpNtype;
	
	
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
	public Integer getTcpId() {
		return tcpId;
	}
	public void setTcpId(Integer tcpId) {
		this.tcpId = tcpId;
	}
	public Integer getTcpSign() {
		return tcpSign;
	}
	public void setTcpSign(Integer tcpSign) {
		this.tcpSign = tcpSign;
	}
	public String getTcpDate() {
		return tcpDate;
	}
	public void setTcpDate(String tcpDate) {
		this.tcpDate = tcpDate;
	}
	public Integer getTcpCombinationPrice() {
		return tcpCombinationPrice;
	}
	public void setTcpCombinationPrice(Integer tcpCombinationPrice) {
		this.tcpCombinationPrice = tcpCombinationPrice;
	}
	public Integer getTcpRetailPrice() {
		return tcpRetailPrice;
	}
	public void setTcpRetailPrice(Integer tcpRetailPrice) {
		this.tcpRetailPrice = tcpRetailPrice;
	}
	public String getTcpNtype() {
		return tcpNtype;
	}
	public void setTcpNtype(String tcpNtype) {
		this.tcpNtype = tcpNtype;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
}
