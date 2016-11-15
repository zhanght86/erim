package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.List;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: TicketDetailBean
 * @Description: 门票
 * @author maoxian
 * @date 2015年7月8日 下午9:59:48
 *
 */
public class TicketDetailBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化版本ID
	 */
	private static final long serialVersionUID = 1L;
	
	
	////////////////////////////////////////////////////自定义字段 start////////////////////////////////////////////////////
	
	//票类信息
	private List<TicketClassBean> listTicketClass;
	//票类id
	private String                allClassId;
	
	////////////////////////////////////////////////////自定义字段 end////////////////////////////////////////////////////
	
	// 景区ID
	private Integer id;
	// 产品ID
	private String productId;
	// 公司ID
	private Integer cpyId;
	// 景区名称
	private String tdlName;
	// 关键词
	private String tdlKey;
	// 景区地址
	private String tdlAddress;
	// 景区主题
	private String tdlTheme;
	// 景区电话
	private String tdlTel;
	// 附近景点
	private String tdlNearbySpots;
	// 附近酒店
	private String tdlNearbyHotel;
	// 标志建筑
	private String tdlNearbyArchitecture;
	// 交通位置
	private String tdlPosition;
	// 是否支持信用卡
	private String tdlIsCredit;
	// 景点开放 --> 开放时间
	private String tdlTimeOpen;
	// 景点关闭
	private String tdlTimeClose;
	// 景点开放时间----结束
	private String tdlMaintenanceTime;
	// 景点介绍
	private String tdlComment;
	// 参观须知 --> 时令公告
	private String tdlVisit;
	// 温馨提示
	private String tdlMessage;
	// 景区等级
	private String tdlScenicLevel;
	// 景点图片
	private String tdlImg1;
	// 景点图片
	private String tdlImg2;
	// 景点图片
	private String tdlImg3;
	//景点图片
	private String tdlImg4;
	// 创建时间
	private String tdlCreatetime;
	// 创建用户
	private String tdlCreateuser;
	// 是否审核通过 1 是 0 否
	private String tdlIsThrough;
	// 审核时间
	private String tdlThroughTime;
	// 审核人
	private String tdlThroughUser;
	// 所属地区  国内/国外
	private String tdlWithinOrOuter;
	// 国家
	private String tdlState;
	// 城市
	private String tdlCity;
	// 城市 用于页面搜索查询
	private String tdlCityVo;
	// 省
	private String tdlProvince;
	// 县
	private String tdlCounty;
	// 经度
	private String tdlLongitude;
	// 纬度
	private String tdlLatitude;
	// 服务票种、普通票
	private Integer tdlCashFare;
	// 服务票种、VIP票
	private Integer tdlVipTicket;
	// 时长
	private String tdlMin;
	// 包含服务
	private String tdlServer;
	// 兑换凭证
	private String tdlCashCvoucher;
	// 兑票方式
	private String tdlCashType;
	// 入园方式	
	private String tdlInThePark;
	// 入园地址
	private String tdlInTheAddress;
	// 封闭维护说明
	private String tdlUsingThisDictionary;
    // 景点简介说明
	private String tdlFeeDescription;
	// 联系人
	private String tdlContacPerson;
	// 联系方式
	private String tdlContact;
	// 有效期
	private String tdlValidity;
	// 友情提示
	private String tdlInSecurity;
	// 价格状态
	private String tdlStatePrice;
	// 退票说明/退改规则
	private String tdlRefundInstructions;
	// 是否上架 1是 0否
	private String  tdlIsDelStatus;
	// 优待政策 --> 门票政策
	private String tdlReferentialPolicies;
    // 预定限制
	private String tdlSetReservation;
	// 安全指南 --> 预订须知
	private String tdlSecurityGuide;
	// 手机号
	private String tdlIphone;
	// QQ号
	private String tdlQq;
	// 邮箱
	private String tdlEmail;
	//景点主题
	private String tdlAttractions;
	//国际香港、澳门。台湾、国家
	private String tdlNation;
	//编码
	private String tdlCode;
	//参观可容纳人数
	private int tdlNum;
	//点击国际后出现的国家
	private String tdlCountyone;
	//点击国际后出现的城市
	private String tdlCityone;
	private String tdlCityoneVo;
	//主要国家
	private String tdlMajorcountries;
	//点击国际出现的出发城市
	private String tdlMajorcity;
	//景点主题增加
	private String tdlAddtheme;
	//预定方式
	private String tdlScheduled;
	
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
	// 联系人邮箱
	private String  ccpEmail;
	// 联系人QQ
	private String  ccpQq;
	
	// 计调姓名
	private String	cbsOperator;
	// 计调联系人
	private String	cbsOperatorPhone;
	// 计调联系qq
	private String	cbsOperatorQq;
	/////////////////////////////企业信息end///////////////////////////////////
	
	/////////////////////////////量价信息start///////////////////////////////////
	
	// 最低价票类ID
	private Integer	tclId;
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
	private Integer tplRetailPrice;
	// 同业价
	private Integer tplTradePrice;
	// 住店时间
	private String  tplDate;
	// 数量
	private Integer tplSign;
	// 是否限量
	private String 	tplIsSign;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getTdlName() {
		return tdlName;
	}
	public void setTdlName(String tdlName) {
		this.tdlName = tdlName;
	}
	public String getTdlKey() {
		return tdlKey;
	}
	public void setTdlKey(String tdlKey) {
		this.tdlKey = tdlKey;
	}
	public String getTdlAddress() {
		return tdlAddress;
	}
	public void setTdlAddress(String tdlAddress) {
		this.tdlAddress = tdlAddress;
	}
	public String getTdlTheme() {
		return tdlTheme;
	}
	public void setTdlTheme(String tdlTheme) {
		this.tdlTheme = tdlTheme;
	}
	public String getTdlTel() {
		return tdlTel;
	}
	public void setTdlTel(String tdlTel) {
		this.tdlTel = tdlTel;
	}
	public String getTdlNearbySpots() {
		return tdlNearbySpots;
	}
	public void setTdlNearbySpots(String tdlNearbySpots) {
		this.tdlNearbySpots = tdlNearbySpots;
	}
	public String getTdlNearbyHotel() {
		return tdlNearbyHotel;
	}
	public void setTdlNearbyHotel(String tdlNearbyHotel) {
		this.tdlNearbyHotel = tdlNearbyHotel;
	}
	public String getTdlNearbyArchitecture() {
		return tdlNearbyArchitecture;
	}
	public void setTdlNearbyArchitecture(String tdlNearbyArchitecture) {
		this.tdlNearbyArchitecture = tdlNearbyArchitecture;
	}
	public String getTdlPosition() {
		return tdlPosition;
	}
	public void setTdlPosition(String tdlPosition) {
		this.tdlPosition = tdlPosition;
	}
	public String getTdlIsCredit() {
		return tdlIsCredit;
	}
	public void setTdlIsCredit(String tdlIsCredit) {
		this.tdlIsCredit = tdlIsCredit;
	}
	public String getTdlTimeOpen() {
		return tdlTimeOpen;
	}
	public void setTdlTimeOpen(String tdlTimeOpen) {
		this.tdlTimeOpen = tdlTimeOpen;
	}
	public String getTdlTimeClose() {
		return tdlTimeClose;
	}
	public void setTdlTimeClose(String tdlTimeClose) {
		this.tdlTimeClose = tdlTimeClose;
	}
	public String getTdlMaintenanceTime() {
		return tdlMaintenanceTime;
	}
	public void setTdlMaintenanceTime(String tdlMaintenanceTime) {
		this.tdlMaintenanceTime = tdlMaintenanceTime;
	}
	public String getTdlComment() {
		return tdlComment;
	}
	public void setTdlComment(String tdlComment) {
		this.tdlComment = tdlComment;
	}
	public String getTdlVisit() {
		return tdlVisit;
	}
	public void setTdlVisit(String tdlVisit) {
		this.tdlVisit = tdlVisit;
	}
	public String getTdlMessage() {
		return tdlMessage;
	}
	public void setTdlMessage(String tdlMessage) {
		this.tdlMessage = tdlMessage;
	}
	public String getTdlScenicLevel() {
		return tdlScenicLevel;
	}
	public void setTdlScenicLevel(String tdlScenicLevel) {
		this.tdlScenicLevel = tdlScenicLevel;
	}
	public String getTdlImg1() {
		return tdlImg1;
	}
	public void setTdlImg1(String tdlImg1) {
		this.tdlImg1 = tdlImg1;
	}
	public String getTdlImg2() {
		return tdlImg2;
	}
	public void setTdlImg2(String tdlImg2) {
		this.tdlImg2 = tdlImg2;
	}
	public String getTdlImg3() {
		return tdlImg3;
	}
	public void setTdlImg3(String tdlImg3) {
		this.tdlImg3 = tdlImg3;
	}
	public String getTdlImg4() {
		return tdlImg4;
	}
	public void setTdlImg4(String tdlImg4) {
		this.tdlImg4 = tdlImg4;
	}
	public String getTdlCreatetime() {
		return tdlCreatetime;
	}
	public void setTdlCreatetime(String tdlCreatetime) {
		this.tdlCreatetime = tdlCreatetime;
	}
	public String getTdlCreateuser() {
		return tdlCreateuser;
	}
	public void setTdlCreateuser(String tdlCreateuser) {
		this.tdlCreateuser = tdlCreateuser;
	}
	public String getTdlIsThrough() {
		return tdlIsThrough;
	}
	public void setTdlIsThrough(String tdlIsThrough) {
		this.tdlIsThrough = tdlIsThrough;
	}
	public String getTdlThroughTime() {
		return tdlThroughTime;
	}
	public void setTdlThroughTime(String tdlThroughTime) {
		this.tdlThroughTime = tdlThroughTime;
	}
	public String getTdlThroughUser() {
		return tdlThroughUser;
	}
	public void setTdlThroughUser(String tdlThroughUser) {
		this.tdlThroughUser = tdlThroughUser;
	}
	public String getTdlWithinOrOuter() {
		return tdlWithinOrOuter;
	}
	public void setTdlWithinOrOuter(String tdlWithinOrOuter) {
		this.tdlWithinOrOuter = tdlWithinOrOuter;
	}
	public String getTdlState() {
		return tdlState;
	}
	public void setTdlState(String tdlState) {
		this.tdlState = tdlState;
	}
	public String getTdlCity() {
		return tdlCity;
	}
	public void setTdlCity(String tdlCity) {
		this.tdlCity = tdlCity;
	}
	public String getTdlCityVo() {
		return tdlCityVo;
	}
	public void setTdlCityVo(String tdlCityVo) {
		this.tdlCityVo = tdlCityVo;
	}
	public String getTdlProvince() {
		return tdlProvince;
	}
	public void setTdlProvince(String tdlProvince) {
		this.tdlProvince = tdlProvince;
	}
	public String getTdlCounty() {
		return tdlCounty;
	}
	public void setTdlCounty(String tdlCounty) {
		this.tdlCounty = tdlCounty;
	}
	public String getTdlLongitude() {
		return tdlLongitude;
	}
	public void setTdlLongitude(String tdlLongitude) {
		this.tdlLongitude = tdlLongitude;
	}
	public String getTdlLatitude() {
		return tdlLatitude;
	}
	public void setTdlLatitude(String tdlLatitude) {
		this.tdlLatitude = tdlLatitude;
	}
	public Integer getTdlCashFare() {
		return tdlCashFare;
	}
	public void setTdlCashFare(Integer tdlCashFare) {
		this.tdlCashFare = tdlCashFare;
	}
	public Integer getTdlVipTicket() {
		return tdlVipTicket;
	}
	public void setTdlVipTicket(Integer tdlVipTicket) {
		this.tdlVipTicket = tdlVipTicket;
	}
	public String getTdlMin() {
		return tdlMin;
	}
	public void setTdlMin(String tdlMin) {
		this.tdlMin = tdlMin;
	}
	public String getTdlServer() {
		return tdlServer;
	}
	public void setTdlServer(String tdlServer) {
		this.tdlServer = tdlServer;
	}
	public String getTdlCashCvoucher() {
		return tdlCashCvoucher;
	}
	public void setTdlCashCvoucher(String tdlCashCvoucher) {
		this.tdlCashCvoucher = tdlCashCvoucher;
	}
	public String getTdlCashType() {
		return tdlCashType;
	}
	public void setTdlCashType(String tdlCashType) {
		this.tdlCashType = tdlCashType;
	}
	public String getTdlInThePark() {
		return tdlInThePark;
	}
	public void setTdlInThePark(String tdlInThePark) {
		this.tdlInThePark = tdlInThePark;
	}
	public String getTdlInTheAddress() {
		return tdlInTheAddress;
	}
	public void setTdlInTheAddress(String tdlInTheAddress) {
		this.tdlInTheAddress = tdlInTheAddress;
	}
	public String getTdlUsingThisDictionary() {
		return tdlUsingThisDictionary;
	}
	public void setTdlUsingThisDictionary(String tdlUsingThisDictionary) {
		this.tdlUsingThisDictionary = tdlUsingThisDictionary;
	}
	public String getTdlFeeDescription() {
		return tdlFeeDescription;
	}
	public void setTdlFeeDescription(String tdlFeeDescription) {
		this.tdlFeeDescription = tdlFeeDescription;
	}
	public String getTdlContacPerson() {
		return tdlContacPerson;
	}
	public void setTdlContacPerson(String tdlContacPerson) {
		this.tdlContacPerson = tdlContacPerson;
	}
	public String getTdlContact() {
		return tdlContact;
	}
	public void setTdlContact(String tdlContact) {
		this.tdlContact = tdlContact;
	}
	public String getTdlValidity() {
		return tdlValidity;
	}
	public void setTdlValidity(String tdlValidity) {
		this.tdlValidity = tdlValidity;
	}
	public String getTdlInSecurity() {
		return tdlInSecurity;
	}
	public void setTdlInSecurity(String tdlInSecurity) {
		this.tdlInSecurity = tdlInSecurity;
	}
	public String getTdlStatePrice() {
		return tdlStatePrice;
	}
	public void setTdlStatePrice(String tdlStatePrice) {
		this.tdlStatePrice = tdlStatePrice;
	}
	public String getTdlRefundInstructions() {
		return tdlRefundInstructions;
	}
	public void setTdlRefundInstructions(String tdlRefundInstructions) {
		this.tdlRefundInstructions = tdlRefundInstructions;
	}
	public String getTdlIsDelStatus() {
		return tdlIsDelStatus;
	}
	public void setTdlIsDelStatus(String tdlIsDelStatus) {
		this.tdlIsDelStatus = tdlIsDelStatus;
	}
	public String getTdlReferentialPolicies() {
		return tdlReferentialPolicies;
	}
	public void setTdlReferentialPolicies(String tdlReferentialPolicies) {
		this.tdlReferentialPolicies = tdlReferentialPolicies;
	}
	public String getTdlSetReservation() {
		return tdlSetReservation;
	}
	public void setTdlSetReservation(String tdlSetReservation) {
		this.tdlSetReservation = tdlSetReservation;
	}
	public String getTdlSecurityGuide() {
		return tdlSecurityGuide;
	}
	public void setTdlSecurityGuide(String tdlSecurityGuide) {
		this.tdlSecurityGuide = tdlSecurityGuide;
	}
	public String getTdlIphone() {
		return tdlIphone;
	}
	public void setTdlIphone(String tdlIphone) {
		this.tdlIphone = tdlIphone;
	}
	public String getTdlQq() {
		return tdlQq;
	}
	public void setTdlQq(String tdlQq) {
		this.tdlQq = tdlQq;
	}
	public String getTdlEmail() {
		return tdlEmail;
	}
	public void setTdlEmail(String tdlEmail) {
		this.tdlEmail = tdlEmail;
	}
	public String getTdlAttractions() {
		return tdlAttractions;
	}
	public void setTdlAttractions(String tdlAttractions) {
		this.tdlAttractions = tdlAttractions;
	}
	public String getTdlNation() {
		return tdlNation;
	}
	public void setTdlNation(String tdlNation) {
		this.tdlNation = tdlNation;
	}
	public String getTdlCode() {
		return tdlCode;
	}
	public void setTdlCode(String tdlCode) {
		this.tdlCode = tdlCode;
	}
	public int getTdlNum() {
		return tdlNum;
	}
	public void setTdlNum(int tdlNum) {
		this.tdlNum = tdlNum;
	}
	public String getTdlCountyone() {
		return tdlCountyone;
	}
	public void setTdlCountyone(String tdlCountyone) {
		this.tdlCountyone = tdlCountyone;
	}
	public String getTdlCityone() {
		return tdlCityone;
	}
	public void setTdlCityone(String tdlCityone) {
		this.tdlCityone = tdlCityone;
	}
	public String getTdlMajorcountries() {
		return tdlMajorcountries;
	}
	public void setTdlMajorcountries(String tdlMajorcountries) {
		this.tdlMajorcountries = tdlMajorcountries;
	}
	public String getTdlMajorcity() {
		return tdlMajorcity;
	}
	public void setTdlMajorcity(String tdlMajorcity) {
		this.tdlMajorcity = tdlMajorcity;
	}
	public String getTdlAddtheme() {
		return tdlAddtheme;
	}
	public void setTdlAddtheme(String tdlAddtheme) {
		this.tdlAddtheme = tdlAddtheme;
	}
	public String getTdlScheduled() {
		return tdlScheduled;
	}
	public void setTdlScheduled(String tdlScheduled) {
		this.tdlScheduled = tdlScheduled;
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
	public Integer getTclId() {
		return tclId;
	}
	public void setTclId(Integer tclId) {
		this.tclId = tclId;
	}
	public Integer getTplRetailPrice() {
		return tplRetailPrice;
	}
	public void setTplRetailPrice(Integer tplRetailPrice) {
		this.tplRetailPrice = tplRetailPrice;
	}
	public Integer getTplTradePrice() {
		return tplTradePrice;
	}
	public void setTplTradePrice(Integer tplTradePrice) {
		this.tplTradePrice = tplTradePrice;
	}
	public String getTplDate() {
		return tplDate;
	}
	public void setTplDate(String tplDate) {
		this.tplDate = tplDate;
	}
	public Integer getTplSign() {
		return tplSign;
	}
	public void setTplSign(Integer tplSign) {
		this.tplSign = tplSign;
	}
	public String getTplIsSign() {
		return tplIsSign;
	}
	public void setTplIsSign(String tplIsSign) {
		this.tplIsSign = tplIsSign;
	}
	public List<TicketClassBean> getListTicketClass() {
		return listTicketClass;
	}
	public void setListTicketClass(List<TicketClassBean> listTicketClass) {
		this.listTicketClass = listTicketClass;
	}
	public String getAllClassId() {
		return allClassId;
	}
	public void setAllClassId(String allClassId) {
		this.allClassId = allClassId;
	}
	public String getTdlCityoneVo() {
		return tdlCityoneVo;
	}
	public void setTdlCityoneVo(String tdlCityoneVo) {
		this.tdlCityoneVo = tdlCityoneVo;
	}
	
}