package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: CafeteriaVoucherFoodBean 
 * @Description: 代金劵
 * @author maoxian
 * @date 2015年11月8日 下午12:22:38
 */
public class CafeteriaVoucherPriceBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//代金劵id
	private Integer djqId;
	//代金券面额
	private Integer cvpPriceTotal;
	//同业价
	private Integer cvpPriceTown;
	//批发
	private Integer cvpPriceSale;
	//零售价
	private Integer cvpPriceRetail;
	//创建时间
	private Date    cvpCreatetime;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDjqId() {
		return djqId;
	}
	public void setDjqId(Integer djqId) {
		this.djqId = djqId;
	}
	public Integer getCvpPriceTotal() {
		return cvpPriceTotal;
	}
	public void setCvpPriceTotal(Integer cvpPriceTotal) {
		this.cvpPriceTotal = cvpPriceTotal;
	}
	public Integer getCvpPriceTown() {
		return cvpPriceTown;
	}
	public void setCvpPriceTown(Integer cvpPriceTown) {
		this.cvpPriceTown = cvpPriceTown;
	}
	public Integer getCvpPriceSale() {
		return cvpPriceSale;
	}
	public void setCvpPriceSale(Integer cvpPriceSale) {
		this.cvpPriceSale = cvpPriceSale;
	}
	public Integer getCvpPriceRetail() {
		return cvpPriceRetail;
	}
	public void setCvpPriceRetail(Integer cvpPriceRetail) {
		this.cvpPriceRetail = cvpPriceRetail;
	}
	public Date getCvpCreatetime() {
		return cvpCreatetime;
	}
	public void setCvpCreatetime(Date cvpCreatetime) {
		this.cvpCreatetime = cvpCreatetime;
	}

}
