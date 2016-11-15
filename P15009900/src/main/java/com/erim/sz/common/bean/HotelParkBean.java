package com.erim.sz.common.bean;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName:    HotelParkBean 
 * @Description:  TODO(酒店停车场) 
 * @author        贺渊博 
 * @date          2015年11月3日 下午8:55:24 
 */
public class HotelParkBean extends BaseBean {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	// 酒店id
	private Integer hdlId;
	//停车场名称
	private String  hpbName;
	//停车场面积
	private String  hpbArea;
	//停车场类型
	private String  hpbType;
	//停车场费用
	private String  hpbCost;
	//小型车位数量
	private String  hpbCarNum;
	//大型车位数量
	private String  hpbBusNum;
    //停车场图片
	private String  hpbImag;
	//上下架
	private String  hpbIsDelStatus;
	
	
	public String getHpbIsDelStatus() {
		return hpbIsDelStatus;
	}
	public void setHpbIsDelStatus(String hpbIsDelStatus) {
		this.hpbIsDelStatus = hpbIsDelStatus;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHpbName() {
		return hpbName;
	}
	public void setHpbName(String hpbName) {
		this.hpbName = hpbName;
	}
	public String getHpbType() {
		return hpbType;
	}
	public void setHpbType(String hpbType) {
		this.hpbType = hpbType;
	}
	public String getHpbImag() {
		return hpbImag;
	}
	public void setHpbImag(String hpbImag) {
		this.hpbImag = hpbImag;
	}
	public Integer getHdlId() {
		return hdlId;
	}
	public void setHdlId(Integer hdlId) {
		this.hdlId = hdlId;
	}
	public String getHpbCost() {
		return hpbCost;
	}
	public void setHpbCost(String hpbCost) {
		this.hpbCost = hpbCost;
	}
	public String getHpbArea() {
		return hpbArea;
	}
	public void setHpbArea(String hpbArea) {
		this.hpbArea = hpbArea;
	}
	public String getHpbCarNum() {
		return hpbCarNum;
	}
	public void setHpbCarNum(String hpbCarNum) {
		this.hpbCarNum = hpbCarNum;
	}
	public String getHpbBusNum() {
		return hpbBusNum;
	}
	public void setHpbBusNum(String hpbBusNum) {
		this.hpbBusNum = hpbBusNum;
	}
}
