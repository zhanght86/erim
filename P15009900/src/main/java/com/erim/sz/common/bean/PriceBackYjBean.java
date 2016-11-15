package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: PriceBackYjBean 
 * @Description: 佣金返利系统
 * @author maoxian
 * @date 2015年12月17日 下午11:23:46
 */
public class PriceBackYjBean  extends BaseBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	
	///////////////////////////////////////////// 自定义字段 start ///////////////////////////////////////////////////////////
	
	//合作数量
	private Integer hzsl;
	
	///////////////////////////////////////////// 自定义字段 end   ///////////////////////////////////////////////////////////
	
	private Integer id;
	//支付公司id
	private Integer cpyId;
	//支付公司上级佣金串号
	private String  yjUserCode; 
	//创建时间
	private Date    pybCreatetime;
	//创建用户
	private String  pybCreateuser;
	//返利
	private Integer pybPrice;
	//返利类型
	private String  pybNtype;
	
	
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
	public String getYjUserCode() {
		return yjUserCode;
	}
	public void setYjUserCode(String yjUserCode) {
		this.yjUserCode = yjUserCode;
	}
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
	public Integer getHzsl() {
		return hzsl;
	}
	public void setHzsl(Integer hzsl) {
		this.hzsl = hzsl;
	}
	public Integer getPybPrice() {
		return pybPrice;
	}
	public void setPybPrice(Integer pybPrice) {
		this.pybPrice = pybPrice;
	}
	public String getPybNtype() {
		return pybNtype;
	}
	public void setPybNtype(String pybNtype) {
		this.pybNtype = pybNtype;
	}
}
