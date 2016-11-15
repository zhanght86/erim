package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: PlaneticketMiddleBean 
 * @Description: 机票往返
 * @author maoxian
 * @date 2015年10月22日 下午10:06:15
 */
public class PlaneticketReturnBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	private Integer cpyId;
	 //产品编码
	private String ptdNo;
	
	private Date    ptrCreatetime;
	
	private String  ptrCreateuser;
	//去程？返程？
	private String  ptrReturn;
	//出发省/国家
	private String  ptrStartCity;
	//出发市
	private String  ptrStartTown;
	//中转id
	private Integer  ptrStartZzid;
	//出发直飞id
	private Integer ptrStartPtdid;
	//到达省
	private String  ptrEndCity;
	//到达市
	private String  ptrEndTown;
	//中转id
	private Integer  ptrEndZzid;
	//国内国际 1国内 2国际
	private String  ptrIsInternational;
	//到达直飞id
	private Integer ptrEndPtdid;
	
	
	////////////////////////////// 自定义start //////////////////////////
	
	private PlaneticketDetailBean priStartBean;
	
	private PlaneticketDetailBean priEndBean;
	
	////////////////////////////// 自定义end //////////////////////////
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public Date getPtrCreatetime() {
		return ptrCreatetime;
	}
	public void setPtrCreatetime(Date ptrCreatetime) {
		this.ptrCreatetime = ptrCreatetime;
	}
	public String getPtrCreateuser() {
		return ptrCreateuser;
	}
	public void setPtrCreateuser(String ptrCreateuser) {
		this.ptrCreateuser = ptrCreateuser;
	}
	public String getPtrReturn() {
		return ptrReturn;
	}
	public void setPtrReturn(String ptrReturn) {
		this.ptrReturn = ptrReturn;
	}
	public String getPtrStartCity() {
		return ptrStartCity;
	}
	public void setPtrStartCity(String ptrStartCity) {
		this.ptrStartCity = ptrStartCity;
	}
	public String getPtrStartTown() {
		return ptrStartTown;
	}
	public void setPtrStartTown(String ptrStartTown) {
		this.ptrStartTown = ptrStartTown;
	}
	
	public Integer getPtrStartZzid() {
		return ptrStartZzid;
	}
	public void setPtrStartZzid(Integer ptrStartZzid) {
		this.ptrStartZzid = ptrStartZzid;
	}
	public Integer getPtrStartPtdid() {
		return ptrStartPtdid;
	}
	public void setPtrStartPtdid(Integer ptrStartPtdid) {
		this.ptrStartPtdid = ptrStartPtdid;
	}
	public String getPtrEndCity() {
		return ptrEndCity;
	}
	public void setPtrEndCity(String ptrEndCity) {
		this.ptrEndCity = ptrEndCity;
	}
	public String getPtrEndTown() {
		return ptrEndTown;
	}
	public void setPtrEndTown(String ptrEndTown) {
		this.ptrEndTown = ptrEndTown;
	}
	
	public Integer getPtrEndZzid() {
		return ptrEndZzid;
	}
	public void setPtrEndZzid(Integer ptrEndZzid) {
		this.ptrEndZzid = ptrEndZzid;
	}
	public String getPtrIsInternational() {
		return ptrIsInternational;
	}
	public void setPtrIsInternational(String ptrIsInternational) {
		this.ptrIsInternational = ptrIsInternational;
	}
	public Integer getPtrEndPtdid() {
		return ptrEndPtdid;
	}
	public void setPtrEndPtdid(Integer ptrEndPtdid) {
		this.ptrEndPtdid = ptrEndPtdid;
	}
	public PlaneticketDetailBean getPriEndBean() {
		return priEndBean;
	}
	public void setPriEndBean(PlaneticketDetailBean priEndBean) {
		this.priEndBean = priEndBean;
	}
	public PlaneticketDetailBean getPriStartBean() {
		return priStartBean;
	}
	public void setPriStartBean(PlaneticketDetailBean priStartBean) {
		this.priStartBean = priStartBean;
	}
	public String getPtdNo() {
		return ptdNo;
	}
	public void setPtdNo(String ptdNo) {
		this.ptdNo = ptdNo;
	}
	
}