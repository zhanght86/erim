package com.erim.sz.common.bean;

import java.util.List;

import com.erim.core.bean.BaseBean;

/**
 * @描述: 特色餐套餐管理
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年12月3日 下午3:24:26
 */
public class CafeteriaPackageBean extends BaseBean {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	///////////////////////////////////////////// 自定义数组 start /////////////////////////////////////
	
	// 套餐菜品
	private List<CafeteriaPackageDishesBean> dishesList;
	
	///////////////////////////////////////////// 自定义数组 end /////////////////////////////////////
	 
	private Integer	id;
	// 特色餐ID
	private Integer	cdlID; 
	// 套餐编号
	private String	cpeCode;
	// 套餐名称
	private String	cpeName;
	// 适用人数-几人
	private Integer	cpePersonMin;
	// 适用人数-至几人
	private Integer	cpePersonMax;
	// 有效期开始时间
	private String	cpeStartTime;
	// 截止日期结束时间 
	private String	cpeEndTime;
	// 套餐总价
	private Integer	cpeContentPrice;
	// 套餐说明
	private String	cpeIntroduction;
	// 购买须知
	private String	cpeBuyKnow;
	// 上下架
	private String	cpeIsDelStatus;
	// 创建时间
	private String	cpeCreatetime;
	//套餐推广图
	private String  cpeImg5;
	
	/////////////////////////////////////pakage_price///////////////////////////////////////////
	//套餐当日量价
	private String cpcRetailPrice;
	/**
	 * 没有用到的字段
	 */
	//套餐内容数量可选几道
	private Integer	cpeContentNum;
	//套餐单价 元/道
	private Integer	cpeEachPrice;
	//菜品类型
	private String	cpeCafeteriaType;
	//菜品名称
	private String	cpeCafeteriaName;
	//规格
	private Integer	cpeCafeteriaNorms;
	//菜品图片
	private String	cpeCafeteriaImg;
	//套餐照片
	private String	cpeImg;
	//预约提醒
	private String	cpeMessage;
	//温馨提示
	private String	cpeFriendlyTips;
	//商家其他服务
	private String	cpeService;
	//名称
	private String 	cpeOtherName;
	//数量/规格
	private String 	cpeOtherNorms;
	//价格
	private String 	cpeOtherPrice;
	//套餐图片
	private String 	cpeImage;
	//团购价
	private Integer	cpePriceGroup;
	//套餐单点总计
	private Integer	cpeTotal;
	//其他小计
	private Integer	cpeOtherTotal;
	//套餐份量
	private Integer	cpeNumber;
	//套餐内容名称
	private String	cpeContentName;
	//内容图片
	private String	cpeContentImg;
	//套餐详解图
	private String	cpeDetailedImg;
	//发票提供
	private String	cpeInvoice;
	//特殊日期使用规则
	private String	cpeUseRule;
	//特别提示
	private String	cpeSpecialTips;
	//营业时间
	private String	cpeOpenTime;
    //关门时间
	private String	cpeCloseTime;
	// 同城价 
	private Integer	cpePriceSametown;
	//零售价
	private Integer	cpeRetailPrice;
	// 批发价
	private Integer	cpePriceAllsale;
	//门店价
	private Integer	cpePriceStores;
	//活动说明
	private String	cpeActiveNotes;
	//限购限用提醒
	private String	cpePurchasing;
	//包间
	private String	cpeRooms;
	//食堂外带
	private String	cpeOutgo;
	//特别备注
	private String	cpeRemark;

	/*
	 * 业务字段 其他菜品
	 */
	private List<CafeteriaPackageDishesFoodBean> foodOtherList;
	
	
	public List<CafeteriaPackageDishesFoodBean> getFoodOtherList() {
		return foodOtherList;
	}
	public void setFoodOtherList(List<CafeteriaPackageDishesFoodBean> foodOtherList) {
		this.foodOtherList = foodOtherList;
	}
	public String getCpcRetailPrice() {
		return cpcRetailPrice;
	}
	public void setCpcRetailPrice(String cpcRetailPrice) {
		this.cpcRetailPrice = cpcRetailPrice;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCdlID() {
		return cdlID;
	}
	public void setCdlID(Integer cdlID) {
		this.cdlID = cdlID;
	}
	public String getCpeName() {
		return cpeName;
	}
	public void setCpeName(String cpeName) {
		this.cpeName = cpeName;
	}
	public Integer getCpePersonMin() {
		return cpePersonMin;
	}
	public void setCpePersonMin(Integer cpePersonMin) {
		this.cpePersonMin = cpePersonMin;
	}
	public Integer getCpePersonMax() {
		return cpePersonMax;
	}
	public void setCpePersonMax(Integer cpePersonMax) {
		this.cpePersonMax = cpePersonMax;
	}
	public Integer getCpeNumber() {
		return cpeNumber;
	}
	public void setCpeNumber(Integer cpeNumber) {
		this.cpeNumber = cpeNumber;
	}
	public String getCpeImg() {
		return cpeImg;
	}
	public void setCpeImg(String cpeImg) {
		this.cpeImg = cpeImg;
	}
	public Integer getCpeContentNum() {
		return cpeContentNum;
	}
	public void setCpeContentNum(Integer cpeContentNum) {
		this.cpeContentNum = cpeContentNum;
	}
	public String getCpeContentName() {
		return cpeContentName;
	}
	public void setCpeContentName(String cpeContentName) {
		this.cpeContentName = cpeContentName;
	}
	public Integer getCpeEachPrice() {
		return cpeEachPrice;
	}
	public void setCpeEachPrice(Integer cpeEachPrice) {
		this.cpeEachPrice = cpeEachPrice;
	}
	public String getCpeCafeteriaType() {
		return cpeCafeteriaType;
	}
	public void setCpeCafeteriaType(String cpeCafeteriaType) {
		this.cpeCafeteriaType = cpeCafeteriaType;
	}
	public Integer getCpeCafeteriaNorms() {
		return cpeCafeteriaNorms;
	}
	public void setCpeCafeteriaNorms(Integer cpeCafeteriaNorms) {
		this.cpeCafeteriaNorms = cpeCafeteriaNorms;
	}
	public String getCpeCafeteriaName() {
		return cpeCafeteriaName;
	}
	public void setCpeCafeteriaName(String cpeCafeteriaName) {
		this.cpeCafeteriaName = cpeCafeteriaName;
	}
	public String getCpeCafeteriaImg() {
		return cpeCafeteriaImg;
	}
	public void setCpeCafeteriaImg(String cpeCafeteriaImg) {
		this.cpeCafeteriaImg = cpeCafeteriaImg;
	}
	public Integer getCpeContentPrice() {
		return cpeContentPrice;
	}
	public void setCpeContentPrice(Integer cpeContentPrice) {
		this.cpeContentPrice = cpeContentPrice;
	}
	public String getCpeContentImg() {
		return cpeContentImg;
	}
	public void setCpeContentImg(String cpeContentImg) {
		this.cpeContentImg = cpeContentImg;
	}
	public String getCpeIntroduction() {
		return cpeIntroduction;
	}
	public void setCpeIntroduction(String cpeIntroduction) {
		this.cpeIntroduction = cpeIntroduction;
	}
	public String getCpeDetailedImg() {
		return cpeDetailedImg;
	}
	public void setCpeDetailedImg(String cpeDetailedImg) {
		this.cpeDetailedImg = cpeDetailedImg;
	}
	public String getCpeInvoice() {
		return cpeInvoice;
	}
	public void setCpeInvoice(String cpeInvoice) {
		this.cpeInvoice = cpeInvoice;
	}
	public String getCpeUseRule() {
		return cpeUseRule;
	}
	public void setCpeUseRule(String cpeUseRule) {
		this.cpeUseRule = cpeUseRule;
	}
	public String getCpeSpecialTips() {
		return cpeSpecialTips;
	}
	public void setCpeSpecialTips(String cpeSpecialTips) {
		this.cpeSpecialTips = cpeSpecialTips;
	}
	public String getCpeFriendlyTips() {
		return cpeFriendlyTips;
	}
	public void setCpeFriendlyTips(String cpeFriendlyTips) {
		this.cpeFriendlyTips = cpeFriendlyTips;
	}
	public String getCpeOpenTime() {
		return cpeOpenTime;
	}
	public void setCpeOpenTime(String cpeOpenTime) {
		this.cpeOpenTime = cpeOpenTime;
	}
	public String getCpeCloseTime() {
		return cpeCloseTime;
	}
	public void setCpeCloseTime(String cpeCloseTime) {
		this.cpeCloseTime = cpeCloseTime;
	}
	public String getCpeStartTime() {
		return cpeStartTime;
	}
	public void setCpeStartTime(String cpeStartTime) {
		this.cpeStartTime = cpeStartTime;
	}
	public String getCpeEndTime() {
		return cpeEndTime;
	}
	public void setCpeEndTime(String cpeEndTime) {
		this.cpeEndTime = cpeEndTime;
	}
	public Integer getCpePriceSametown() {
		return cpePriceSametown;
	}
	public void setCpePriceSametown(Integer cpePriceSametown) {
		this.cpePriceSametown = cpePriceSametown;
	}
	public Integer getCpeRetailPrice() {
		return cpeRetailPrice;
	}
	public void setCpeRetailPrice(Integer cpeRetailPrice) {
		this.cpeRetailPrice = cpeRetailPrice;
	}
	public Integer getCpePriceAllsale() {
		return cpePriceAllsale;
	}
	public void setCpePriceAllsale(Integer cpePriceAllsale) {
		this.cpePriceAllsale = cpePriceAllsale;
	}
	public Integer getCpePriceGroup() {
		return cpePriceGroup;
	}
	public void setCpePriceGroup(Integer cpePriceGroup) {
		this.cpePriceGroup = cpePriceGroup;
	}
	public Integer getCpePriceStores() {
		return cpePriceStores;
	}
	public void setCpePriceStores(Integer cpePriceStores) {
		this.cpePriceStores = cpePriceStores;
	}
	public String getCpeMessage() {
		return cpeMessage;
	}
	public void setCpeMessage(String cpeMessage) {
		this.cpeMessage = cpeMessage;
	}
	public String getCpeBuyKnow() {
		return cpeBuyKnow;
	}
	public void setCpeBuyKnow(String cpeBuyKnow) {
		this.cpeBuyKnow = cpeBuyKnow;
	}
	public String getCpeActiveNotes() {
		return cpeActiveNotes;
	}
	public void setCpeActiveNotes(String cpeActiveNotes) {
		this.cpeActiveNotes = cpeActiveNotes;
	}
	
	public String getCpeCreatetime() {
		return cpeCreatetime;
	}
	public void setCpeCreatetime(String cpeCreatetime) {
		this.cpeCreatetime = cpeCreatetime;
	}
	public String getCpeIsDelStatus() {
		return cpeIsDelStatus;
	}
	public void setCpeIsDelStatus(String cpeIsDelStatus) {
		this.cpeIsDelStatus = cpeIsDelStatus;
	}
	public String getCpePurchasing() {
		return cpePurchasing;
	}
	public void setCpePurchasing(String cpePurchasing) {
		this.cpePurchasing = cpePurchasing;
	}
	public String getCpeRooms() {
		return cpeRooms;
	}
	public void setCpeRooms(String cpeRooms) {
		this.cpeRooms = cpeRooms;
	}
	public String getCpeOutgo() {
		return cpeOutgo;
	}
	public void setCpeOutgo(String cpeOutgo) {
		this.cpeOutgo = cpeOutgo;
	}
	public String getCpeService() {
		return cpeService;
	}
	public void setCpeService(String cpeService) {
		this.cpeService = cpeService;
	}
	public String getCpeRemark() {
		return cpeRemark;
	}
	public void setCpeRemark(String cpeRemark) {
		this.cpeRemark = cpeRemark;
	}
	public Integer getCpeOtherTotal() {
		return cpeOtherTotal;
	}
	public void setCpeOtherTotal(Integer cpeOtherTotal) {
		this.cpeOtherTotal = cpeOtherTotal;
	}
	public Integer getCpeTotal() {
		return cpeTotal;
	}
	public void setCpeTotal(Integer cpeTotal) {
		this.cpeTotal = cpeTotal;
	}
	public String getCpeCode() {
		return cpeCode;
	}
	public void setCpeCode(String cpeCode) {
		this.cpeCode = cpeCode;
	}
	public String getCpeOtherName() {
		return cpeOtherName;
	}
	public void setCpeOtherName(String cpeOtherName) {
		this.cpeOtherName = cpeOtherName;
	}
	public String getCpeOtherNorms() {
		return cpeOtherNorms;
	}
	public void setCpeOtherNorms(String cpeOtherNorms) {
		this.cpeOtherNorms = cpeOtherNorms;
	}
	
	
	public String getCpeOtherPrice() {
		return cpeOtherPrice;
	}
	public void setCpeOtherPrice(String cpeOtherPrice) {
		this.cpeOtherPrice = cpeOtherPrice;
	}
	public String getCpeImage() {
		return cpeImage;
	}
	public void setCpeImage(String cpeImage) {
		this.cpeImage = cpeImage;
	}
	public List<CafeteriaPackageDishesBean> getDishesList() {
		return dishesList;
	}
	public void setDishesList(List<CafeteriaPackageDishesBean> dishesList) {
		this.dishesList = dishesList;
	}
	public String getCpeImg5() {
		return cpeImg5;
	}
	public void setCpeImg5(String cpeImg5) {
		this.cpeImg5 = cpeImg5;
	}

}