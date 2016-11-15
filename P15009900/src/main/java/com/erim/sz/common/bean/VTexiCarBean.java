package com.erim.sz.common.bean;

/**
 * @ClassName: VTexiCar 
 * @Description: 租车信息
 * @author maoxian
 * @date 2015年12月20日 下午6:33:34
 */
public class VTexiCarBean {

	// 序号
	private Integer id;
	// 车辆id
	private Integer tdlId;
	// 类型
	private String  cvalue;
	// 基本信息
	private String  remark;
	// 费用说明
	private String  money;
	// 服务说明
	private String  content;
	// 对应量价类型
	private String  ntype;
	
	
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
	public String getCvalue() {
		return cvalue;
	}
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNtype() {
		return ntype;
	}
	public void setNtype(String ntype) {
		this.ntype = ntype;
	}
}
