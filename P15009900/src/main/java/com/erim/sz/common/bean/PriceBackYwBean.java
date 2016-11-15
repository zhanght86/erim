package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: PriceBackYwBean 
 * @Description: 运维返利表
 * @author maoxian
 * @date 2015年12月17日 下午11:22:17
 */
public class PriceBackYwBean extends BaseBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//缴费id
	private Integer cpyId;
	//公司佣金编码
	private String  cpyYjUserCode;
	//上一级编码
	private String  yjUserCode;
	//代理级别 1 2
	private Integer pybLevel;
	//运维费支付总金额
	private Integer cpyPrice;
	//返利金额
	private Integer pybBackPrice;
	//百分比 1级 20 2级10
	private Integer pybBackNum;
	//支付时间
	private Date    pybCreatetime;
	//支付用户
	private String  pybCreateuser;
	
	public Date getPybCreatetime() {
		return pybCreatetime;
	}
	public void setPybCreatetime(Date pybCreatetime) {
		this.pybCreatetime = pybCreatetime;
	}
	public String getPybCreateuser() {
		return pybCreateuser;
	}
	public void setPybCreateuser(String pybCreateuser) {
		this.pybCreateuser = pybCreateuser;
	}
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
	public String getCpyYjUserCode() {
		return cpyYjUserCode;
	}
	public void setCpyYjUserCode(String cpyYjUserCode) {
		this.cpyYjUserCode = cpyYjUserCode;
	}
	public String getYjUserCode() {
		return yjUserCode;
	}
	public void setYjUserCode(String yjUserCode) {
		this.yjUserCode = yjUserCode;
	}
	public Integer getPybLevel() {
		return pybLevel;
	}
	public void setPybLevel(Integer pybLevel) {
		this.pybLevel = pybLevel;
	}
	public Integer getCpyPrice() {
		return cpyPrice;
	}
	public void setCpyPrice(Integer cpyPrice) {
		this.cpyPrice = cpyPrice;
	}
	public Integer getPybBackPrice() {
		return pybBackPrice;
	}
	public void setPybBackPrice(Integer pybBackPrice) {
		this.pybBackPrice = pybBackPrice;
	}
	public Integer getPybBackNum() {
		return pybBackNum;
	}
	public void setPybBackNum(Integer pybBackNum) {
		this.pybBackNum = pybBackNum;
	}

}
