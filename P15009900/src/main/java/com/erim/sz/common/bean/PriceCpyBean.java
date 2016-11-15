package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: PriceCpyBean 
 * @Description: 担保金
 * @author maoxian
 * @date 2015年11月3日 上午11:10:16
 */
public class PriceCpyBean  extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//企业
	private Integer cpyId;
	//担保金
	private Integer priGuaranteeTotal;
	//剩余金额
	private Integer priGuaranteeSurplus;
	//充值类型
	private String  priNtype;
	//创建时间
	private Date    priCreatetime;
	
	
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
	public Integer getPriGuaranteeTotal() {
		return priGuaranteeTotal;
	}
	public void setPriGuaranteeTotal(Integer priGuaranteeTotal) {
		this.priGuaranteeTotal = priGuaranteeTotal;
	}
	public Integer getPriGuaranteeSurplus() {
		return priGuaranteeSurplus;
	}
	public void setPriGuaranteeSurplus(Integer priGuaranteeSurplus) {
		this.priGuaranteeSurplus = priGuaranteeSurplus;
	}
	public Date getPriCreatetime() {
		return priCreatetime;
	}
	public void setPriCreatetime(Date priCreatetime) {
		this.priCreatetime = priCreatetime;
	}
	public String getPriNtype() {
		return priNtype;
	}
	public void setPriNtype(String priNtype) {
		this.priNtype = priNtype;
	}
}
