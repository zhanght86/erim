package com.erim.sz.common.bean;

import com.erim.core.bean.BaseBean;

/**
 * @描述: 包车管理
 * 
 * @作者: 陈鹏
 * @创建时间: 2015年7月10日 下午9:46:06
 */
public class TexiCarBean extends BaseBean {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//产品ID
	private Integer tdlId;
	//包车类型
	private String 	bclType;
	//半天包限时长
	private String 	bclHfLimit;
	//半天包限公里
	private String  bclHfKm;
	//半天包超时长费用
	private String  bclHfLength;
	//半天包超长公里费
	private String  bclHfLengthkm;
	//半天包费用包含
	private String  bclHfCost;
	//半天包服务说明
	private String  bclHfService;
	//全天限时长
	private String  bclLimit;
	//全天限公里
	private String  bclKm;
	//全天超时费
	private String  bclLength;
	//全天包超长公里费用
	private String  bclLengthkm;
	//全天费用包含
	private String  bclCost;
	//全天服务说明
	private String  bclService;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTdlId() {
		return tdlId;
	}
	public void setTdlId(Integer tdlId) {
		this.tdlId = tdlId;
	}
	public String getBclType() {
		return bclType;
	}
	public void setBclType(String bclType) {
		this.bclType = bclType;
	}
	public String getBclHfCost() {
		return bclHfCost;
	}
	public void setBclHfCost(String bclHfCost) {
		this.bclHfCost = bclHfCost;
	}
	public String getBclHfService() {
		return bclHfService;
	}
	public void setBclHfService(String bclHfService) {
		this.bclHfService = bclHfService;
	}
	public String getBclHfLimit() {
		return bclHfLimit;
	}
	public void setBclHfLimit(String bclHfLimit) {
		this.bclHfLimit = bclHfLimit;
	}
	public String getBclHfKm() {
		return bclHfKm;
	}
	public void setBclHfKm(String bclHfKm) {
		this.bclHfKm = bclHfKm;
	}
	public String getBclHfLength() {
		return bclHfLength;
	}
	public void setBclHfLength(String bclHfLength) {
		this.bclHfLength = bclHfLength;
	}
	public String getBclHfLengthkm() {
		return bclHfLengthkm;
	}
	public void setBclHfLengthkm(String bclHfLengthkm) {
		this.bclHfLengthkm = bclHfLengthkm;
	}
	public String getBclKm() {
		return bclKm;
	}
	public void setBclKm(String bclKm) {
		this.bclKm = bclKm;
	}
	public String getBclLength() {
		return bclLength;
	}
	public void setBclLength(String bclLength) {
		this.bclLength = bclLength;
	}
	public String getBclLengthkm() {
		return bclLengthkm;
	}
	public void setBclLengthkm(String bclLengthkm) {
		this.bclLengthkm = bclLengthkm;
	}
	public String getBclLimit() {
		return bclLimit;
	}
	public void setBclLimit(String bclLimit) {
		this.bclLimit = bclLimit;
	}
	public String getBclCost() {
		return bclCost;
	}
	public void setBclCost(String bclCost) {
		this.bclCost = bclCost;
	}
	public String getBclService() {
		return bclService;
	}
	public void setBclService(String bclService) {
		this.bclService = bclService;
	}
	
}
