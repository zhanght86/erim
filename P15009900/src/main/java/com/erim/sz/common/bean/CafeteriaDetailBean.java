package com.erim.sz.common.bean;

import java.util.Date;
import java.util.List;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: CafeteriaDetailBean
 * @Description: 特色餐管理
 * @author 陈鹏
 * @date 2015年7月11日 下午1:19:24
 */
public class CafeteriaDetailBean extends BaseBean {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	
	////////////////////////////////////////////////// 自定义字段 不在数据库储存 start///////////////////////////////////////////////////
	
	//代金券金额
	private String cvpPriceTown;
	//代金券面额
	private String cvpPriceTotal;
	
	private List<CafeteriaVoucherBean> listCafeteriaVoucher;
	
	private List<CafeteriaPackageBean> listCafeteriaPackage;
	// 所有套餐id
	private String allPackageId;
	
	////////////////////////////////////////////////// 自定义字段 不在数据库储存 end ///////////////////////////////////////////////////
	
	private Integer id;
	// 餐厅名称
	private String  cdlName;
	// 主打菜系
	private String  cdlSort;
	// 餐厅特色
	private String  cdlSpecial;
	// 国家 02国内,01国际、港澳台
	private String 	cdlInland;
	// 省
	private String  cdlProvince;
	// 市
	private String  cdlCity;
	// 市 用于页面传值和取值中文
	private String  cdlCityVo;
	// 县
	private String  cdlCounty;
	// 国际所在地
	private String	cdlExternal;
	// 外国
	private String	cdlForeign;
	// 外国城市
	private String	cdlForeignCity;
	private String	cdlForeignCityVo;
	// 详细地址
	private String  cdlAddress;
	// 餐厅电话
	private String  cdlTelephone;
	// 所属商圈
	private String	cdlDistrict;
	// 营业时间 
    private String  cdlOpenTime;
    // 关门时间
    private String  cdlCloseTime;
    // 停车场
    private String  cdlStopCar;
    // 用餐人数
    private String  cdlEatPeople;
    // 用餐人数不限
  	private String  cdlUnlimited;
  	// 网络设施
    private String  cdlInternet;
    // 推荐理由
    private String 	cdlReason;
    // 餐厅介绍
  	private String 	cdlIntroduce;
  	// 通知公告
  	private String 	cdlNotice;
  	// 餐厅图片
  	private String  cdlImg1;
  	// 图片2
  	private String  cdlImg2;
  	// 图片3
  	private String  cdlImg3;
  	// 图片4
  	private String  cdlImg4;
  	// 图片5
  	private String 	cdlImg5;
  	// 餐厅业务
  	private String  cdlBusiness;
  	// 最低起订早餐标准
  	private Integer cdlOrderNorme;
  	// 最低起订正餐标准
  	private Integer cdlOrderNormz;
  	// 可同时接单数量
  	private Integer cdlReceiveNum;
  	// 联系人
  	private String  cdlSpecialName;
  	// 联系人电话
  	private String 	cdlPhone;
  	// 联系人QQ
  	private String 	cdlPeopleQq;
  	// 创建时间
  	private Date    cdlCreatetime;
  	// 创建用户
 	private String  cdlCreateuse;
 	// 企业ID
 	private Integer cpyId;
 	// 是否上架1是0否
 	private String  cdlIsDelStatus;
 	// 产品编号
 	private String 	cdlCode;
 	// 是否审核通过 1 是 0 否
 	private String  cdlIsThrough;
 	// 审核时间
 	private Date    cdlThroughTime;
 	// 审核人
 	private String  cdlThroughUser;
 	// 特色餐价格
 	private Integer cdlPrice1;
 	// 特色餐价格
  	private Integer cdlPrice2;
  	
 	/**
 	 * 其他暂未使用字段
 	 */
 	// 是否上线
 	private String  cdlDelStatus;
	// 预定方式
	private String 	cdlScheduled;
	// 经度
	private String  cdlX;
	// 纬度 
	private String  cdlY;
	// 星级
	private String  cdlLevel;
	// 特色餐价格
	private Integer cdlPrice;
	// 优惠价格
	private Integer cdlSpecialPrice;
	
	
    //////////////////////////////////////////////////////////转码参数 ////////////////////////////////////////////////////////////////////////////////
	// 城市
    private String  dicCity;
    // 档次
    private String  dicLevel;
    ////////////////////////////////////////////////////////// 分割线 ////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
  //公司名称
  	private String  cpyName;
  	//公司电话
  	private String  cpyTelephone;
  	//联系人电话
  	private String  ccpTelephone;
  	//联系人QQ
  	private String  ccpQq;
  	//联系人姓名
  	private String  ccpName;
  	//企业品牌
  	private String  cpyBrand;
  	// 计调姓名
  	private String	cbsOperator;
  	// 计调联系人
  	private String	cbsOperatorPhone;
  	// 计调联系qq
  	private String	cbsOperatorQq;
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	//下面2项参数作转码用途
 // （1）特色餐价格选项与页面对应
 	private String PriceOption; 
 	//（2）特色餐人数选项与页面对应
 	private String PersonOption; 
 	
  	
  	
	public String getCpyBrand() {
		return cpyBrand;
	}
	public void setCpyBrand(String cpyBrand) {
		this.cpyBrand = cpyBrand;
	}
	public String getCbsOperator() {
		return cbsOperator;
	}
	public void setCbsOperator(String cbsOperator) {
		this.cbsOperator = cbsOperator;
	}
	public String getCbsOperatorPhone() {
		return cbsOperatorPhone;
	}
	public void setCbsOperatorPhone(String cbsOperatorPhone) {
		this.cbsOperatorPhone = cbsOperatorPhone;
	}
	public String getCbsOperatorQq() {
		return cbsOperatorQq;
	}
	public void setCbsOperatorQq(String cbsOperatorQq) {
		this.cbsOperatorQq = cbsOperatorQq;
	}
	// 零售价
	private Integer cpcRetailPrice;
	// 同业价
	private Integer cpcTradePrice;
	// 可售份数
	private Integer cpcSign;
	// 是否限量
	private String 	cpcIsSign;
	// 日期
	private	String 	cpcDate;
	// 套餐ID
	private Integer cpeId;
	public String getCvpPriceTown() {
		return cvpPriceTown;
	}
	public void setCvpPriceTown(String cvpPriceTown) {
		this.cvpPriceTown = cvpPriceTown;
	}
	public String getCvpPriceTotal() {
		return cvpPriceTotal;
	}
	public void setCvpPriceTotal(String cvpPriceTotal) {
		this.cvpPriceTotal = cvpPriceTotal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCdlName() {
		return cdlName;
	}
	public void setCdlName(String cdlName) {
		this.cdlName = cdlName;
	}
	public String getCdlSort() {
		return cdlSort;
	}
	public void setCdlSort(String cdlSort) {
		this.cdlSort = cdlSort;
	}
	public String getCdlSpecial() {
		return cdlSpecial;
	}
	public void setCdlSpecial(String cdlSpecial) {
		this.cdlSpecial = cdlSpecial;
	}
	public String getCdlInland() {
		return cdlInland;
	}
	public void setCdlInland(String cdlInland) {
		this.cdlInland = cdlInland;
	}
	public String getCdlProvince() {
		return cdlProvince;
	}
	public void setCdlProvince(String cdlProvince) {
		this.cdlProvince = cdlProvince;
	}
	public String getCdlCity() {
		return cdlCity;
	}
	public void setCdlCity(String cdlCity) {
		this.cdlCity = cdlCity;
	}
	public String getCdlCityVo() {
		return cdlCityVo;
	}
	public void setCdlCityVo(String cdlCityVo) {
		this.cdlCityVo = cdlCityVo;
	}
	public String getCdlCounty() {
		return cdlCounty;
	}
	public void setCdlCounty(String cdlCounty) {
		this.cdlCounty = cdlCounty;
	}
	public String getCdlExternal() {
		return cdlExternal;
	}
	public void setCdlExternal(String cdlExternal) {
		this.cdlExternal = cdlExternal;
	}
	public String getCdlForeign() {
		return cdlForeign;
	}
	public void setCdlForeign(String cdlForeign) {
		this.cdlForeign = cdlForeign;
	}
	public String getCdlForeignCity() {
		return cdlForeignCity;
	}
	public void setCdlForeignCity(String cdlForeignCity) {
		this.cdlForeignCity = cdlForeignCity;
	}
	public String getCdlAddress() {
		return cdlAddress;
	}
	public void setCdlAddress(String cdlAddress) {
		this.cdlAddress = cdlAddress;
	}
	public String getCdlTelephone() {
		return cdlTelephone;
	}
	public void setCdlTelephone(String cdlTelephone) {
		this.cdlTelephone = cdlTelephone;
	}
	public String getCdlDistrict() {
		return cdlDistrict;
	}
	public void setCdlDistrict(String cdlDistrict) {
		this.cdlDistrict = cdlDistrict;
	}
	public String getCdlOpenTime() {
		return cdlOpenTime;
	}
	public void setCdlOpenTime(String cdlOpenTime) {
		this.cdlOpenTime = cdlOpenTime;
	}
	public String getCdlCloseTime() {
		return cdlCloseTime;
	}
	public void setCdlCloseTime(String cdlCloseTime) {
		this.cdlCloseTime = cdlCloseTime;
	}
	public String getCdlStopCar() {
		return cdlStopCar;
	}
	public void setCdlStopCar(String cdlStopCar) {
		this.cdlStopCar = cdlStopCar;
	}
	public String getCdlEatPeople() {
		return cdlEatPeople;
	}
	public void setCdlEatPeople(String cdlEatPeople) {
		this.cdlEatPeople = cdlEatPeople;
	}
	public String getCdlUnlimited() {
		return cdlUnlimited;
	}
	public void setCdlUnlimited(String cdlUnlimited) {
		this.cdlUnlimited = cdlUnlimited;
	}
	public String getCdlInternet() {
		return cdlInternet;
	}
	public void setCdlInternet(String cdlInternet) {
		this.cdlInternet = cdlInternet;
	}
	public String getCdlReason() {
		return cdlReason;
	}
	public void setCdlReason(String cdlReason) {
		this.cdlReason = cdlReason;
	}
	public String getCdlIntroduce() {
		return cdlIntroduce;
	}
	public void setCdlIntroduce(String cdlIntroduce) {
		this.cdlIntroduce = cdlIntroduce;
	}
	public String getCdlNotice() {
		return cdlNotice;
	}
	public void setCdlNotice(String cdlNotice) {
		this.cdlNotice = cdlNotice;
	}
	public String getCdlImg1() {
		return cdlImg1;
	}
	public void setCdlImg1(String cdlImg1) {
		this.cdlImg1 = cdlImg1;
	}
	public String getCdlImg2() {
		return cdlImg2;
	}
	public void setCdlImg2(String cdlImg2) {
		this.cdlImg2 = cdlImg2;
	}
	public String getCdlImg3() {
		return cdlImg3;
	}
	public void setCdlImg3(String cdlImg3) {
		this.cdlImg3 = cdlImg3;
	}
	public String getCdlImg4() {
		return cdlImg4;
	}
	public void setCdlImg4(String cdlImg4) {
		this.cdlImg4 = cdlImg4;
	}
	public String getCdlImg5() {
		return cdlImg5;
	}
	public void setCdlImg5(String cdlImg5) {
		this.cdlImg5 = cdlImg5;
	}
	public String getCdlBusiness() {
		return cdlBusiness;
	}
	public void setCdlBusiness(String cdlBusiness) {
		this.cdlBusiness = cdlBusiness;
	}
	public Integer getCdlOrderNorme() {
		return cdlOrderNorme;
	}
	public void setCdlOrderNorme(Integer cdlOrderNorme) {
		this.cdlOrderNorme = cdlOrderNorme;
	}
	public Integer getCdlOrderNormz() {
		return cdlOrderNormz;
	}
	public void setCdlOrderNormz(Integer cdlOrderNormz) {
		this.cdlOrderNormz = cdlOrderNormz;
	}
	public Integer getCdlReceiveNum() {
		return cdlReceiveNum;
	}
	public void setCdlReceiveNum(Integer cdlReceiveNum) {
		this.cdlReceiveNum = cdlReceiveNum;
	}
	public String getCdlSpecialName() {
		return cdlSpecialName;
	}
	public void setCdlSpecialName(String cdlSpecialName) {
		this.cdlSpecialName = cdlSpecialName;
	}
	public String getCdlPhone() {
		return cdlPhone;
	}
	public void setCdlPhone(String cdlPhone) {
		this.cdlPhone = cdlPhone;
	}
	public String getCdlPeopleQq() {
		return cdlPeopleQq;
	}
	public void setCdlPeopleQq(String cdlPeopleQq) {
		this.cdlPeopleQq = cdlPeopleQq;
	}
	public Date getCdlCreatetime() {
		return cdlCreatetime;
	}
	public void setCdlCreatetime(Date cdlCreatetime) {
		this.cdlCreatetime = cdlCreatetime;
	}
	public String getCdlCreateuse() {
		return cdlCreateuse;
	}
	public void setCdlCreateuse(String cdlCreateuse) {
		this.cdlCreateuse = cdlCreateuse;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getCdlIsDelStatus() {
		return cdlIsDelStatus;
	}
	public void setCdlIsDelStatus(String cdlIsDelStatus) {
		this.cdlIsDelStatus = cdlIsDelStatus;
	}
	public String getCdlCode() {
		return cdlCode;
	}
	public void setCdlCode(String cdlCode) {
		this.cdlCode = cdlCode;
	}
	public String getCdlIsThrough() {
		return cdlIsThrough;
	}
	public void setCdlIsThrough(String cdlIsThrough) {
		this.cdlIsThrough = cdlIsThrough;
	}
	public Date getCdlThroughTime() {
		return cdlThroughTime;
	}
	public void setCdlThroughTime(Date cdlThroughTime) {
		this.cdlThroughTime = cdlThroughTime;
	}
	public String getCdlThroughUser() {
		return cdlThroughUser;
	}
	public void setCdlThroughUser(String cdlThroughUser) {
		this.cdlThroughUser = cdlThroughUser;
	}
	public Integer getCdlPrice1() {
		return cdlPrice1;
	}
	public void setCdlPrice1(Integer cdlPrice1) {
		this.cdlPrice1 = cdlPrice1;
	}
	public Integer getCdlPrice2() {
		return cdlPrice2;
	}
	public void setCdlPrice2(Integer cdlPrice2) {
		this.cdlPrice2 = cdlPrice2;
	}
	public String getCdlDelStatus() {
		return cdlDelStatus;
	}
	public void setCdlDelStatus(String cdlDelStatus) {
		this.cdlDelStatus = cdlDelStatus;
	}
	public String getCdlScheduled() {
		return cdlScheduled;
	}
	public void setCdlScheduled(String cdlScheduled) {
		this.cdlScheduled = cdlScheduled;
	}
	public String getCdlX() {
		return cdlX;
	}
	public void setCdlX(String cdlX) {
		this.cdlX = cdlX;
	}
	public String getCdlY() {
		return cdlY;
	}
	public void setCdlY(String cdlY) {
		this.cdlY = cdlY;
	}
	public String getCdlLevel() {
		return cdlLevel;
	}
	public void setCdlLevel(String cdlLevel) {
		this.cdlLevel = cdlLevel;
	}
	public Integer getCdlPrice() {
		return cdlPrice;
	}
	public void setCdlPrice(Integer cdlPrice) {
		this.cdlPrice = cdlPrice;
	}
	public Integer getCdlSpecialPrice() {
		return cdlSpecialPrice;
	}
	public void setCdlSpecialPrice(Integer cdlSpecialPrice) {
		this.cdlSpecialPrice = cdlSpecialPrice;
	}
	public String getDicCity() {
		return dicCity;
	}
	public void setDicCity(String dicCity) {
		this.dicCity = dicCity;
	}
	public String getDicLevel() {
		return dicLevel;
	}
	public void setDicLevel(String dicLevel) {
		this.dicLevel = dicLevel;
	}
	public String getCpyName() {
		return cpyName;
	}
	public void setCpyName(String cpyName) {
		this.cpyName = cpyName;
	}
	public String getCpyTelephone() {
		return cpyTelephone;
	}
	public void setCpyTelephone(String cpyTelephone) {
		this.cpyTelephone = cpyTelephone;
	}
	public String getCcpTelephone() {
		return ccpTelephone;
	}
	public void setCcpTelephone(String ccpTelephone) {
		this.ccpTelephone = ccpTelephone;
	}
	public String getCcpQq() {
		return ccpQq;
	}
	public void setCcpQq(String ccpQq) {
		this.ccpQq = ccpQq;
	}
	public String getCcpName() {
		return ccpName;
	}
	public void setCcpName(String ccpName) {
		this.ccpName = ccpName;
	}
	public Integer getCpcRetailPrice() {
		return cpcRetailPrice;
	}
	public void setCpcRetailPrice(Integer cpcRetailPrice) {
		this.cpcRetailPrice = cpcRetailPrice;
	}
	public Integer getCpcTradePrice() {
		return cpcTradePrice;
	}
	public void setCpcTradePrice(Integer cpcTradePrice) {
		this.cpcTradePrice = cpcTradePrice;
	}
	public Integer getCpcSign() {
		return cpcSign;
	}
	public void setCpcSign(Integer cpcSign) {
		this.cpcSign = cpcSign;
	}
	public String getCpcIsSign() {
		return cpcIsSign;
	}
	public void setCpcIsSign(String cpcIsSign) {
		this.cpcIsSign = cpcIsSign;
	}
	public String getCpcDate() {
		return cpcDate;
	}
	public void setCpcDate(String cpcDate) {
		this.cpcDate = cpcDate;
	}
	public Integer getCpeId() {
		return cpeId;
	}
	public void setCpeId(Integer cpeId) {
		this.cpeId = cpeId;
	}
	public List<CafeteriaPackageBean> getListCafeteriaPackage() {
		return listCafeteriaPackage;
	}
	public void setListCafeteriaPackage(List<CafeteriaPackageBean> listCafeteriaPackage) {
		this.listCafeteriaPackage = listCafeteriaPackage;
	}
	public String getAllPackageId() {
		return allPackageId;
	}
	public void setAllPackageId(String allPackageId) {
		this.allPackageId = allPackageId;
	}
	public String getCdlForeignCityVo() {
		return cdlForeignCityVo;
	}
	public void setCdlForeignCityVo(String cdlForeignCityVo) {
		this.cdlForeignCityVo = cdlForeignCityVo;
	}
	public List<CafeteriaVoucherBean> getListCafeteriaVoucher() {
		return listCafeteriaVoucher;
	}
	public void setListCafeteriaVoucher(
			List<CafeteriaVoucherBean> listCafeteriaVoucher) {
		this.listCafeteriaVoucher = listCafeteriaVoucher;
	}
	public String getPriceOption() {
		return PriceOption;
	}
	public void setPriceOption(String priceOption) {
		PriceOption = priceOption;
	}
	public String getPersonOption() {
		return PersonOption;
	}
	public void setPersonOption(String personOption) {
		PersonOption = personOption;
	}
	
}