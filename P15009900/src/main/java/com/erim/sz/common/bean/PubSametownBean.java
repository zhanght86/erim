package com.erim.sz.common.bean;

import java.io.Serializable;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: PubSametown 
 * @Description: 同城同业区分
 * @author maoxian
 * @date 2015年9月18日 上午11:19:48 
 *
 */
public class PubSametownBean extends BaseBean implements Serializable{
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//产品ID
	private Integer cid;
	//发起企业ID
	private Integer cpyidFrom;
	//指向企业ID
	private Integer cpyidTo;
	//区分 酒店 门票
	private String  ntype;
	//公司品牌
	private String cpyBrand;
	//负责人
	private String cpyPeople;
	//负责人电话
	private int cpyPhone;
	//操作人
	private String cpyOperate;
	//操作人电话
	private int  cpyOperatephone;
	//企业qq
	private int cpyQQ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getCpyidFrom() {
		return cpyidFrom;
	}
	public void setCpyidFrom(Integer cpyidFrom) {
		this.cpyidFrom = cpyidFrom;
	}
	public Integer getCpyidTo() {
		return cpyidTo;
	}
	public void setCpyidTo(Integer cpyidTo) {
		this.cpyidTo = cpyidTo;
	}
	public String getNtype() {
		return ntype;
	}
	public void setNtype(String ntype) {
		this.ntype = ntype;
	}
	public String getCpyBrand() {
		return cpyBrand;
	}
	public void setCpyBrand(String cpyBrand) {
		this.cpyBrand = cpyBrand;
	}
	public String getCpyPeople() {
		return cpyPeople;
	}
	public void setCpyPeople(String cpyPeople) {
		this.cpyPeople = cpyPeople;
	}
	public int getCpyPhone() {
		return cpyPhone;
	}
	public void setCpyPhone(int cpyPhone) {
		this.cpyPhone = cpyPhone;
	}
	public String getCpyOperate() {
		return cpyOperate;
	}
	public void setCpyOperate(String cpyOperate) {
		this.cpyOperate = cpyOperate;
	}
	public int getCpyOperatephone() {
		return cpyOperatephone;
	}
	public void setCpyOperatephone(int cpyOperatephone) {
		this.cpyOperatephone = cpyOperatephone;
	}
	public int getCpyQQ() {
		return cpyQQ;
	}
	public void setCpyQQ(int cpyQQ) {
		this.cpyQQ = cpyQQ;
	}
	
}
