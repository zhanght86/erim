package com.erim.sz.common.bean;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: CafeteriaVoucherBean
 * @Description: 代金券
 * @author 贺渊博
 * @date 2015年10月2日 下午4:54:49
 */
public class CafeteriaVoucherBean extends BaseBean {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//餐厅id
	private Integer cdlID;
	// 有效期
	private String  djqStartDate;
	// 失效期
	private String  djqEndDate;
	// 代金券包间使用
	private String  djqVoucher;
	// 购买须知
	private String  djqBuyShow;
	// 预约提醒
	private String  djqOrderRemind;
	// 使用说明
	private String  djqUseShow;
//////////////////////cafeteriavoucherpricebean/////////////////////////////////////////////
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDjqStartDate() {
		return djqStartDate;
	}

	public void setDjqStartDate(String djqStartDate) {
		this.djqStartDate = djqStartDate;
	}

	public String getDjqEndDate() {
		return djqEndDate;
	}

	public void setDjqEndDate(String djqEndDate) {
		this.djqEndDate = djqEndDate;
	}

	public String getDjqBuyShow() {
		return djqBuyShow;
	}

	public void setDjqBuyShow(String djqBuyShow) {
		this.djqBuyShow = djqBuyShow;
	}

	public String getDjqOrderRemind() {
		return djqOrderRemind;
	}

	public void setDjqOrderRemind(String djqOrderRemind) {
		this.djqOrderRemind = djqOrderRemind;
	}

	public Integer getCdlID() {
		return cdlID;
	}

	public void setCdlID(Integer cdlID) {
		this.cdlID = cdlID;
	}

	public String getDjqUseShow() {
		return djqUseShow;
	}

	public void setDjqUseShow(String djqUseShow) {
		this.djqUseShow = djqUseShow;
	}

	public String getDjqVoucher() {
		return djqVoucher;
	}

	public void setDjqVoucher(String djqVoucher) {
		this.djqVoucher = djqVoucher;
	}

}
