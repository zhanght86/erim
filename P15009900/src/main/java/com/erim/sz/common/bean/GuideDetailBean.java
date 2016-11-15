package com.erim.sz.common.bean;

import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: GuideDetailBean 
 * @Description: 导游细类
 * @author maoxian
 * @date 2015年9月10日 下午2:00:41
 */
public class GuideDetailBean extends BaseBean {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//导游编号
	private String 	gdlCode;
	//导游名称
	private String 	gdlName;
	//手机用户
	private String  gdlMobileUsers;
	//性别
	private String 	gdlSex;
	//工作年限
	private String 	gdlAge;
	//导游/领队证号
	private String 	gdlCertificate;
	//籍贯
	private String 	gdlNativePlace;
	//服务
	private String 	gdlServer;//
	
	
	/**
	 * 国内地陪
	 */
	//国内地陪-目的地-省
	private String 	gdlLocalProvince;
	//国内地陪-目的地-市
	private String 	gdlLocalCity;
	//国内地陪-目的地-区县
	private String 	gdlLocalCounty;
	/**
	 * 国内全陪
	 */
	//国内全陪-目的地-省
	private String 	gdlNationalProvince;
	//国内全陪-目的地-市
	private String 	gdlNationalCity;
	//国内全陪-目的地-区县
	private String 	gdlNationalCounty;
	/**
	 * 国际领队
	 */
	//国际领队-出发地-省
	private String 	gdlLeaderProvince;
	//国际领队-出发地-市
	private String 	gdlLeaderCity;
	//国际领队-出发地-区县
	private String 	gdlLeaderCounty;
	//国际领队-目的地-港澳台
	private String 	gdlDestination;
	//国际领队-目的地-国家
	private String 	gdlDestinationCountry;
	/**
	 * 国际地陪
	 */
	//国际地陪-目的地-港澳台
	private String 	gdlGaidLokal;
	//国际地陪-目的地-国家
	private String 	gdlGaidCountry;
	
	//导游语种
	private String 	gdlLanguage;
	//语种其他
	private String 	gdlRest;
	//公司评级
	private String 	gdlCompanyRating;
	//导游等级
	private String 	gdlGrade;
	//创建时间
	private Date 	gdlCreatetime;
	//创建用户
	private String 	gdlCreateuser;
	//是否审核通过 1 是 0 否
	private String 	gdlIsThrough;
	//审核时间
	private Date 	gdlThroughTime;
	//审核人
	private String 	gdlThroughUser;
	//是否上架 1是 0否
	private String 	gdlIsDelStatus;
	//导游密码
	private String 	gdlPwd;
	//企业id
	private Integer cpyId;
	
	/**
	 * 05 手机导游使用字段
	 */
	// 个人签名	
	private String	gdlSignature;
	// 自我介绍
	private String 	gdlIntroduction;
	
	/**
	 * 暂未发现用途字段
	 */
	//照片
	private String 	gdlImgPerson;
	//证件
	private String 	gdlImgCard;
	//组团社佣金
	private Integer gdlPrice;
	//导游星级
	private Integer gdlStars;
	//导游语种其他
	private String 	gdlLanguag;
	//导游性质
	private String 	gdlProperty;
	//服务城市
	private String 	gdlServiceRegion;
	//至//
	private String 	gdlAge1;
	//预定方式
	private String 	gdlScheduled;
	//用于页面搜索：目的城市 中文
	private String 	gdlLocalCityVo;
	//用于页面搜索：国外目的城市 中文
	private String 	gdlForienCityVo;
	
	private String 	gdlGaidLokal1;
	private String 	gdlGaidLokal2;
	private String 	gdlGaidLokal3;
	private String 	gdlGaidLokal4;
	
	///////////////////////////导游 价格相关 start//////////////////////////////////
	
	private String 	gpeDate1;//开始时间
	private String 	gpeDate2;//结束时间

	//服务类型
	private String 	gdlTypeService;
	
	//国内地陪
	private String 	gdlLocal;
	//国内全陪
	private String 	gdlNational;
	//国际/港澳台领队
	private String 	gdlLeader;
	//国际/港澳台地陪
	private String 	gdlDestination1;
	
	// 地接价
	private Integer gpeFloorPrice;
	// 时间
	private String	gpeDate;
	// 直客价
	private	Integer gpeGuestPrice;
	//列表展示图片 取最新一张图片
	private String gdlShowImg;
	
	///////////////////////////导游 价格相关 end////////////////////////////////////
	
	/////////////////////////////企业信息start///////////////////////////////////
	
	// 公司品牌
	private String  cpyBrand;
	// 公司名称
	private String  cpyName;
	// 公司电话
	private String  cpyTelephone;
	// 联系人
	private String  ccpName;
	// 联系电话
	private String  ccpTelephone;
	//联系人邮箱
	private String  ccpEmail;
	//联系人QQ
	private String  ccpQq;
  	// 计调姓名
  	private String	cbsOperator;
  	// 计调联系人
  	private String	cbsOperatorPhone;
  	// 计调联系qq
  	private String	cbsOperatorQq;
	
	/////////////////////////////企业信息end/////////////////////////////////////
	
  	
	public Integer getId() {
		return id;
	}
	public String getGdlSignature() {
		return gdlSignature;
	}
	public void setGdlSignature(String gdlSignature) {
		this.gdlSignature = gdlSignature;
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
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGdlCode() {
		return gdlCode;
	}
	public void setGdlCode(String gdlCode) {
		this.gdlCode = gdlCode;
	}
	public String getGdlName() {
		return gdlName;
	}
	public void setGdlName(String gdlName) {
		this.gdlName = gdlName;
	}
	public String getGdlSex() {
		return gdlSex;
	}
	public void setGdlSex(String gdlSex) {
		this.gdlSex = gdlSex;
	}
	public String getGdlAge() {
		return gdlAge;
	}
	public void setGdlAge(String gdlAge) {
		this.gdlAge = gdlAge;
	}
	public String getGdlCertificate() {
		return gdlCertificate;
	}
	public void setGdlCertificate(String gdlCertificate) {
		this.gdlCertificate = gdlCertificate;
	}
	public String getGdlNativePlace() {
		return gdlNativePlace;
	}
	public void setGdlNativePlace(String gdlNativePlace) {
		this.gdlNativePlace = gdlNativePlace;
	}
	public String getGdlServer() {
		return gdlServer;
	}
	public void setGdlServer(String gdlServer) {
		this.gdlServer = gdlServer;
	}
	public String getGdlLocalProvince() {
		return gdlLocalProvince;
	}
	public void setGdlLocalProvince(String gdlLocalProvince) {
		this.gdlLocalProvince = gdlLocalProvince;
	}
	public String getGdlLocalCity() {
		return gdlLocalCity;
	}
	public void setGdlLocalCity(String gdlLocalCity) {
		this.gdlLocalCity = gdlLocalCity;
	}
	public String getGdlLocalCounty() {
		return gdlLocalCounty;
	}
	public void setGdlLocalCounty(String gdlLocalCounty) {
		this.gdlLocalCounty = gdlLocalCounty;
	}
	public String getGdlNationalProvince() {
		return gdlNationalProvince;
	}
	public void setGdlNationalProvince(String gdlNationalProvince) {
		this.gdlNationalProvince = gdlNationalProvince;
	}
	public String getGdlNationalCity() {
		return gdlNationalCity;
	}
	public void setGdlNationalCity(String gdlNationalCity) {
		this.gdlNationalCity = gdlNationalCity;
	}
	public String getGdlNationalCounty() {
		return gdlNationalCounty;
	}
	public void setGdlNationalCounty(String gdlNationalCounty) {
		this.gdlNationalCounty = gdlNationalCounty;
	}
	public String getGdlLeaderProvince() {
		return gdlLeaderProvince;
	}
	public void setGdlLeaderProvince(String gdlLeaderProvince) {
		this.gdlLeaderProvince = gdlLeaderProvince;
	}
	public String getGdlLeaderCity() {
		return gdlLeaderCity;
	}
	public void setGdlLeaderCity(String gdlLeaderCity) {
		this.gdlLeaderCity = gdlLeaderCity;
	}
	public String getGdlLeaderCounty() {
		return gdlLeaderCounty;
	}
	public void setGdlLeaderCounty(String gdlLeaderCounty) {
		this.gdlLeaderCounty = gdlLeaderCounty;
	}
	public String getGdlDestination() {
		return gdlDestination;
	}
	public void setGdlDestination(String gdlDestination) {
		this.gdlDestination = gdlDestination;
	}
	public String getGdlDestinationCountry() {
		return gdlDestinationCountry;
	}
	public void setGdlDestinationCountry(String gdlDestinationCountry) {
		this.gdlDestinationCountry = gdlDestinationCountry;
	}
	public String getGdlGaidLokal() {
		return gdlGaidLokal;
	}
	public void setGdlGaidLokal(String gdlGaidLokal) {
		this.gdlGaidLokal = gdlGaidLokal;
	}
	public String getGdlGaidCountry() {
		return gdlGaidCountry;
	}
	public void setGdlGaidCountry(String gdlGaidCountry) {
		this.gdlGaidCountry = gdlGaidCountry;
	}
	public String getGdlLanguage() {
		return gdlLanguage;
	}
	public void setGdlLanguage(String gdlLanguage) {
		this.gdlLanguage = gdlLanguage;
	}
	public String getGdlRest() {
		return gdlRest;
	}
	public void setGdlRest(String gdlRest) {
		this.gdlRest = gdlRest;
	}
	public String getGdlCompanyRating() {
		return gdlCompanyRating;
	}
	public void setGdlCompanyRating(String gdlCompanyRating) {
		this.gdlCompanyRating = gdlCompanyRating;
	}
	public String getGdlGrade() {
		return gdlGrade;
	}
	public void setGdlGrade(String gdlGrade) {
		this.gdlGrade = gdlGrade;
	}
	public Date getGdlCreatetime() {
		return gdlCreatetime;
	}
	public void setGdlCreatetime(Date gdlCreatetime) {
		this.gdlCreatetime = gdlCreatetime;
	}
	public String getGdlCreateuser() {
		return gdlCreateuser;
	}
	public void setGdlCreateuser(String gdlCreateuser) {
		this.gdlCreateuser = gdlCreateuser;
	}
	public String getGdlIsThrough() {
		return gdlIsThrough;
	}
	public void setGdlIsThrough(String gdlIsThrough) {
		this.gdlIsThrough = gdlIsThrough;
	}
	public Date getGdlThroughTime() {
		return gdlThroughTime;
	}
	public void setGdlThroughTime(Date gdlThroughTime) {
		this.gdlThroughTime = gdlThroughTime;
	}
	public String getGdlThroughUser() {
		return gdlThroughUser;
	}
	public void setGdlThroughUser(String gdlThroughUser) {
		this.gdlThroughUser = gdlThroughUser;
	}
	public String getGdlIsDelStatus() {
		return gdlIsDelStatus;
	}
	public void setGdlIsDelStatus(String gdlIsDelStatus) {
		this.gdlIsDelStatus = gdlIsDelStatus;
	}
	public String getGdlPwd() {
		return gdlPwd;
	}
	public void setGdlPwd(String gdlPwd) {
		this.gdlPwd = gdlPwd;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getGdlIntroduction() {
		return gdlIntroduction;
	}
	public void setGdlIntroduction(String gdlIntroduction) {
		this.gdlIntroduction = gdlIntroduction;
	}
	public String getGdlImgCard() {
		return gdlImgCard;
	}
	public void setGdlImgCard(String gdlImgCard) {
		this.gdlImgCard = gdlImgCard;
	}
	public Integer getGdlPrice() {
		return gdlPrice;
	}
	public void setGdlPrice(Integer gdlPrice) {
		this.gdlPrice = gdlPrice;
	}
	public Integer getGdlStars() {
		return gdlStars;
	}
	public void setGdlStars(Integer gdlStars) {
		this.gdlStars = gdlStars;
	}
	public String getGdlLanguag() {
		return gdlLanguag;
	}
	public void setGdlLanguag(String gdlLanguag) {
		this.gdlLanguag = gdlLanguag;
	}
	public String getGdlProperty() {
		return gdlProperty;
	}
	public void setGdlProperty(String gdlProperty) {
		this.gdlProperty = gdlProperty;
	}
	public String getGdlServiceRegion() {
		return gdlServiceRegion;
	}
	public void setGdlServiceRegion(String gdlServiceRegion) {
		this.gdlServiceRegion = gdlServiceRegion;
	}
	public String getGdlAge1() {
		return gdlAge1;
	}
	public void setGdlAge1(String gdlAge1) {
		this.gdlAge1 = gdlAge1;
	}
	public String getGdlScheduled() {
		return gdlScheduled;
	}
	public void setGdlScheduled(String gdlScheduled) {
		this.gdlScheduled = gdlScheduled;
	}
	public String getGdlLocalCityVo() {
		return gdlLocalCityVo;
	}
	public void setGdlLocalCityVo(String gdlLocalCityVo) {
		this.gdlLocalCityVo = gdlLocalCityVo;
	}
	public String getGdlGaidLokal1() {
		return gdlGaidLokal1;
	}
	public void setGdlGaidLokal1(String gdlGaidLokal1) {
		this.gdlGaidLokal1 = gdlGaidLokal1;
	}
	public String getGdlGaidLokal2() {
		return gdlGaidLokal2;
	}
	public void setGdlGaidLokal2(String gdlGaidLokal2) {
		this.gdlGaidLokal2 = gdlGaidLokal2;
	}
	public String getGdlGaidLokal3() {
		return gdlGaidLokal3;
	}
	public void setGdlGaidLokal3(String gdlGaidLokal3) {
		this.gdlGaidLokal3 = gdlGaidLokal3;
	}
	public String getGdlGaidLokal4() {
		return gdlGaidLokal4;
	}
	public void setGdlGaidLokal4(String gdlGaidLokal4) {
		this.gdlGaidLokal4 = gdlGaidLokal4;
	}
	public String getGpeDate1() {
		return gpeDate1;
	}
	public void setGpeDate1(String gpeDate1) {
		this.gpeDate1 = gpeDate1;
	}
	public String getGpeDate2() {
		return gpeDate2;
	}
	public void setGpeDate2(String gpeDate2) {
		this.gpeDate2 = gpeDate2;
	}
	public String getGdlTypeService() {
		return gdlTypeService;
	}
	public void setGdlTypeService(String gdlTypeService) {
		this.gdlTypeService = gdlTypeService;
	}
	public String getGdlLocal() {
		return gdlLocal;
	}
	public void setGdlLocal(String gdlLocal) {
		this.gdlLocal = gdlLocal;
	}
	public String getGdlNational() {
		return gdlNational;
	}
	public void setGdlNational(String gdlNational) {
		this.gdlNational = gdlNational;
	}
	public String getGdlLeader() {
		return gdlLeader;
	}
	public void setGdlLeader(String gdlLeader) {
		this.gdlLeader = gdlLeader;
	}
	public String getGdlDestination1() {
		return gdlDestination1;
	}
	public void setGdlDestination1(String gdlDestination1) {
		this.gdlDestination1 = gdlDestination1;
	}
	public Integer getGpeFloorPrice() {
		return gpeFloorPrice;
	}
	public void setGpeFloorPrice(Integer gpeFloorPrice) {
		this.gpeFloorPrice = gpeFloorPrice;
	}
	public String getGpeDate() {
		return gpeDate;
	}
	public void setGpeDate(String gpeDate) {
		this.gpeDate = gpeDate;
	}
	public Integer getGpeGuestPrice() {
		return gpeGuestPrice;
	}
	public void setGpeGuestPrice(Integer gpeGuestPrice) {
		this.gpeGuestPrice = gpeGuestPrice;
	}
	public String getCpyBrand() {
		return cpyBrand;
	}
	public void setCpyBrand(String cpyBrand) {
		this.cpyBrand = cpyBrand;
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
	public String getCcpName() {
		return ccpName;
	}
	public void setCcpName(String ccpName) {
		this.ccpName = ccpName;
	}
	public String getCcpTelephone() {
		return ccpTelephone;
	}
	public void setCcpTelephone(String ccpTelephone) {
		this.ccpTelephone = ccpTelephone;
	}
	public String getCcpEmail() {
		return ccpEmail;
	}
	public void setCcpEmail(String ccpEmail) {
		this.ccpEmail = ccpEmail;
	}
	public String getCcpQq() {
		return ccpQq;
	}
	public void setCcpQq(String ccpQq) {
		this.ccpQq = ccpQq;
	}
	public String getGdlMobileUsers() {
		return gdlMobileUsers;
	}
	public void setGdlMobileUsers(String gdlMobileUsers) {
		this.gdlMobileUsers = gdlMobileUsers;
	}
	public String getGdlImgPerson() {
		return gdlImgPerson;
	}
	public void setGdlImgPerson(String gdlImgPerson) {
		this.gdlImgPerson = gdlImgPerson;
	}
	public String getGdlShowImg() {
		return gdlShowImg;
	}
	public void setGdlShowImg(String gdlShowImg) {
		this.gdlShowImg = gdlShowImg;
	}
	public String getGdlForienCityVo() {
		return gdlForienCityVo;
	}
	public void setGdlForienCityVo(String gdlForienCityVo) {
		this.gdlForienCityVo = gdlForienCityVo;
	}
	

	
}
