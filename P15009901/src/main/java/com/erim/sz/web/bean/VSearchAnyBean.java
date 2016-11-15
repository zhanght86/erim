package com.erim.sz.web.bean;

import java.io.Serializable;

/**
 * @ClassName: VSearchAnyBean 
 * @Description: 门户检索视图
 * @author maoxian
 * @date 2016年1月3日 下午2:51:27
 */
public class VSearchAnyBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	//序列id
	private Integer vId;
	//名称
	private String  vName;
	//地址
	private String  vAddress;
	//关键词
	private String  vRemark;
	//类型
	private String  vNtype;
	//路径
	private String  vUrl;
	
	
	public Integer getvId() {
		return vId;
	}
	public void setvId(Integer vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvAddress() {
		return vAddress;
	}
	public void setvAddress(String vAddress) {
		this.vAddress = vAddress;
	}
	public String getvRemark() {
		return vRemark;
	}
	public void setvRemark(String vRemark) {
		this.vRemark = vRemark;
	}
	public String getvNtype() {
		return vNtype;
	}
	public void setvNtype(String vNtype) {
		this.vNtype = vNtype;
	}
	public String getvUrl() {
		return vUrl;
	}
	public void setvUrl(String vUrl) {
		this.vUrl = vUrl;
	}
}
