package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: HotelDetailBean
 * @Description: 酒店管理
 * @author 陈鹏
 * @date 2015年7月14日 下午8:58:29
 */
public class HotelDetailBean extends BaseBean implements Serializable {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	
	///////////////////////////////////// 自定义字段 start /////////////////////////////////////////////
	
	private List<HotelRoomBean> listHotelRoom;
	
	private String allRoomId;
	
	///////////////////////////////////// 自定义字段 end /////////////////////////////////////////////
	
	/**
	 * 酒店基础信息
	 */
	private Integer id;
	// 产品编码
	private String 	hdlCode;
	// 酒店名称
	private String  hdlName;
	// 英文名称
	private String  hdlEnglish;
	// 关键字
	private String  hdlKeyword;
	// 省
	private String  hdlProvince;
	// 市
	private String  hdlCity;
	//市 页面传值取值用 汉字
	private String  hdlCityVo;
	// 县
	private String  hdlCounty;
	// 详细地址
	private String  hdlAddress;
	// 经度
	private String  longitude; 
	// 纬度
	private String  latitude; 
	// 酒店电话
	private String  hdlTelephone;
	// 酒店传真
	private String  hdlChuanzhen;
	// 星级/酒店档次
	private String  hdlLevel;
	// 房间数量
	private Integer hdlRoomNum;
	// 酒店开业时间
	private String  hdlStart;
	// 装修时间
	private String  hdlRenovationDate;
	// 特色
	private String  hdlCharacteristic;
	// 酒店设施
	private String  hdlFacilities;
	// 网络设施
	private String  hdlNetWork;
	// 服务项目
	private String  hdlService;
	// 信用卡
	private String  hdlCreditcard;
	//公交/地铁
	private String  hdlPosition;
	//交通位置
	private String  hdlLocation;
	// 所属商圈
	private String  hdlDistrict;
	// 附近机场/站点
	private String  hdlNearSite;
	// 标志学校医院行政
	private String  hdlMark;
	// 景点
	private String  hdlFeature;
	// 酒店介绍
	private String  hdlDescribe;
	// 酒店图片1
	private String  hdlImg1;
	// 酒店图片2
	private String  hdlImg2;
	// 酒店图片3
	private String  hdlImg3;
	// 酒店图片4
	private String  hdlImg4;
	// 酒店图片5
	private String  hdlImg5;
	// 创建时间
	private Date    hdlCreatetime;
	// 创建用户
	private String  hdlCreateuser;
	// 是否上架 01否 02是
	private String  hdlIsDelStatus;
	// 企业id
	private Integer cpyId;
	// 是否有效 01否 02是
	private String  hdlIsValid;
	// 是否国内
	private String  hdlIsInternal;
	// 国际所在地
	private String  hdlExternal;
	// 外国
	private String  hdlForeign;
	// 外国城市
	private String  hdlForeignCity;
	private String  hdlForeignCityVo;
	// 是否审核通过 02 是 01 否
	private String  hdlIsThrough;
	// 审核时间
	private Date    hdlThroughTime;
	// 审核人
	private String  hdlThroughUser;
	//预定方式
	private String 	hdlScheduled;
	
	/**
	 * 餐厅信息
	 */
	// 餐厅名称
	private String  hdlCtmc;
	// 餐厅类型
	private String  hdlCtlx;
	// 餐厅面积
	private int 	hdlCtmj;
	// 餐厅用餐人数
	private int 	hdlCtnumSta;
	// 餐厅用餐人数
	private int 	hdlCtnum;
	// 餐厅图片
	private String  hdlImg6;
	
	/**
	 * 停车场信息
	 */
	//停车场名称
	private String hdlTextpName;
	//停车场类型
	private String hdlTextLx;
	//停车场面积
	private int hdlTextmj;
	//停车位数量
	private int hdlTextNum;
	//停车场费用
	private String  hdlTextmony;
	// 停车场图片
	private String  hdlImg7;
	
	/**
	 * 其他暂未使用字段
	 */
	// 主营项目
	private String hdlZyxm;
	// 行政区
	private String  hdlRegion;
	// 餐厅类型
	private String  hdlCantype;
	// 主营项目
	private String  hdlZhuying;
	// 其他设施 
	private String  hdlFacilitiesOther;
	// 娱乐场所
	private String  hdlGame;
	// 其他娱乐
	private String  hdlGameOther;
	// 餐饮设施 餐饮设施
	private String  hdlFood;
	
	
	/**
	 * 转码参数
	 */
	// 城市
	private String  dicCity;
	// 档次
	private String  dicLevel;
	//  国际所在地，香港澳门台湾转码
	private String 	dicExternal;
	
	
	//////////////////////////////////////企业相关信息/////////////////////////////////////////
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
	///////////////////////////////////////////////////////////////////////////////////////
	
	//最低价房型ID
	private Integer hheId;
	//同业价
	private Integer hnpTradePrice;
	//零售价
	private Integer hnpRetailPrice;
	//可销售房间数
	private Integer hnpSign;
	//住店时间
	private String  hnpDate;
	//价格
	private Integer hdlPrice1;
	private Integer hdlPrice2;
	
	///////////////////////////////////////////////////////////////////////////////////////
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHdlCode() {
		return hdlCode;
	}
	public void setHdlCode(String hdlCode) {
		this.hdlCode = hdlCode;
	}
	public String getHdlName() {
		return hdlName;
	}
	public void setHdlName(String hdlName) {
		this.hdlName = hdlName;
	}
	public String getHdlEnglish() {
		return hdlEnglish;
	}
	public void setHdlEnglish(String hdlEnglish) {
		this.hdlEnglish = hdlEnglish;
	}
	public String getHdlKeyword() {
		return hdlKeyword;
	}
	public void setHdlKeyword(String hdlKeyword) {
		this.hdlKeyword = hdlKeyword;
	}
	public String getHdlProvince() {
		return hdlProvince;
	}
	public void setHdlProvince(String hdlProvince) {
		this.hdlProvince = hdlProvince;
	}
	public String getHdlCity() {
		return hdlCity;
	}
	public void setHdlCity(String hdlCity) {
		this.hdlCity = hdlCity;
	}
	public String getHdlCityVo() {
		return hdlCityVo;
	}
	public void setHdlCityVo(String hdlCityVo) {
		this.hdlCityVo = hdlCityVo;
	}
	public String getHdlCounty() {
		return hdlCounty;
	}
	public void setHdlCounty(String hdlCounty) {
		this.hdlCounty = hdlCounty;
	}
	public String getHdlAddress() {
		return hdlAddress;
	}
	public void setHdlAddress(String hdlAddress) {
		this.hdlAddress = hdlAddress;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getHdlTelephone() {
		return hdlTelephone;
	}
	public void setHdlTelephone(String hdlTelephone) {
		this.hdlTelephone = hdlTelephone;
	}
	public String getHdlChuanzhen() {
		return hdlChuanzhen;
	}
	public void setHdlChuanzhen(String hdlChuanzhen) {
		this.hdlChuanzhen = hdlChuanzhen;
	}
	public String getHdlLevel() {
		return hdlLevel;
	}
	public void setHdlLevel(String hdlLevel) {
		this.hdlLevel = hdlLevel;
	}
	public Integer getHdlRoomNum() {
		return hdlRoomNum;
	}
	public void setHdlRoomNum(Integer hdlRoomNum) {
		this.hdlRoomNum = hdlRoomNum;
	}
	public String getHdlStart() {
		return hdlStart;
	}
	public void setHdlStart(String hdlStart) {
		this.hdlStart = hdlStart;
	}
	public String getHdlRenovationDate() {
		return hdlRenovationDate;
	}
	public void setHdlRenovationDate(String hdlRenovationDate) {
		this.hdlRenovationDate = hdlRenovationDate;
	}
	public String getHdlCharacteristic() {
		return hdlCharacteristic;
	}
	public void setHdlCharacteristic(String hdlCharacteristic) {
		this.hdlCharacteristic = hdlCharacteristic;
	}
	public String getHdlFacilities() {
		return hdlFacilities;
	}
	public void setHdlFacilities(String hdlFacilities) {
		this.hdlFacilities = hdlFacilities;
	}
	public String getHdlNetWork() {
		return hdlNetWork;
	}
	public void setHdlNetWork(String hdlNetWork) {
		this.hdlNetWork = hdlNetWork;
	}
	public String getHdlService() {
		return hdlService;
	}
	public void setHdlService(String hdlService) {
		this.hdlService = hdlService;
	}
	public String getHdlCreditcard() {
		return hdlCreditcard;
	}
	public void setHdlCreditcard(String hdlCreditcard) {
		this.hdlCreditcard = hdlCreditcard;
	}
	public String getHdlPosition() {
		return hdlPosition;
	}
	public void setHdlPosition(String hdlPosition) {
		this.hdlPosition = hdlPosition;
	}
	public String getHdlLocation() {
		return hdlLocation;
	}
	public void setHdlLocation(String hdlLocation) {
		this.hdlLocation = hdlLocation;
	}
	public String getHdlDistrict() {
		return hdlDistrict;
	}
	public void setHdlDistrict(String hdlDistrict) {
		this.hdlDistrict = hdlDistrict;
	}
	public String getHdlNearSite() {
		return hdlNearSite;
	}
	public void setHdlNearSite(String hdlNearSite) {
		this.hdlNearSite = hdlNearSite;
	}
	public String getHdlMark() {
		return hdlMark;
	}
	public void setHdlMark(String hdlMark) {
		this.hdlMark = hdlMark;
	}
	public String getHdlFeature() {
		return hdlFeature;
	}
	public void setHdlFeature(String hdlFeature) {
		this.hdlFeature = hdlFeature;
	}
	public String getHdlDescribe() {
		return hdlDescribe;
	}
	public void setHdlDescribe(String hdlDescribe) {
		this.hdlDescribe = hdlDescribe;
	}
	public String getHdlImg1() {
		return hdlImg1;
	}
	public void setHdlImg1(String hdlImg1) {
		this.hdlImg1 = hdlImg1;
	}
	public String getHdlImg2() {
		return hdlImg2;
	}
	public void setHdlImg2(String hdlImg2) {
		this.hdlImg2 = hdlImg2;
	}
	public String getHdlImg3() {
		return hdlImg3;
	}
	public void setHdlImg3(String hdlImg3) {
		this.hdlImg3 = hdlImg3;
	}
	public String getHdlImg4() {
		return hdlImg4;
	}
	public void setHdlImg4(String hdlImg4) {
		this.hdlImg4 = hdlImg4;
	}
	public String getHdlImg5() {
		return hdlImg5;
	}
	public void setHdlImg5(String hdlImg5) {
		this.hdlImg5 = hdlImg5;
	}
	public Date getHdlCreatetime() {
		return hdlCreatetime;
	}
	public void setHdlCreatetime(Date hdlCreatetime) {
		this.hdlCreatetime = hdlCreatetime;
	}
	public String getHdlCreateuser() {
		return hdlCreateuser;
	}
	public void setHdlCreateuser(String hdlCreateuser) {
		this.hdlCreateuser = hdlCreateuser;
	}
	public String getHdlIsDelStatus() {
		return hdlIsDelStatus;
	}
	public void setHdlIsDelStatus(String hdlIsDelStatus) {
		this.hdlIsDelStatus = hdlIsDelStatus;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getHdlIsValid() {
		return hdlIsValid;
	}
	public void setHdlIsValid(String hdlIsValid) {
		this.hdlIsValid = hdlIsValid;
	}
	public String getHdlIsInternal() {
		return hdlIsInternal;
	}
	public void setHdlIsInternal(String hdlIsInternal) {
		this.hdlIsInternal = hdlIsInternal;
	}
	public String getHdlExternal() {
		return hdlExternal;
	}
	public void setHdlExternal(String hdlExternal) {
		this.hdlExternal = hdlExternal;
	}
	public String getHdlForeign() {
		return hdlForeign;
	}
	public void setHdlForeign(String hdlForeign) {
		this.hdlForeign = hdlForeign;
	}
	public String getHdlForeignCity() {
		return hdlForeignCity;
	}
	public void setHdlForeignCity(String hdlForeignCity) {
		this.hdlForeignCity = hdlForeignCity;
	}
	public String getHdlIsThrough() {
		return hdlIsThrough;
	}
	public void setHdlIsThrough(String hdlIsThrough) {
		this.hdlIsThrough = hdlIsThrough;
	}
	public Date getHdlThroughTime() {
		return hdlThroughTime;
	}
	public void setHdlThroughTime(Date hdlThroughTime) {
		this.hdlThroughTime = hdlThroughTime;
	}
	public String getHdlThroughUser() {
		return hdlThroughUser;
	}
	public void setHdlThroughUser(String hdlThroughUser) {
		this.hdlThroughUser = hdlThroughUser;
	}
	public String getHdlScheduled() {
		return hdlScheduled;
	}
	public void setHdlScheduled(String hdlScheduled) {
		this.hdlScheduled = hdlScheduled;
	}
	public String getHdlCtmc() {
		return hdlCtmc;
	}
	public void setHdlCtmc(String hdlCtmc) {
		this.hdlCtmc = hdlCtmc;
	}
	public String getHdlCtlx() {
		return hdlCtlx;
	}
	public void setHdlCtlx(String hdlCtlx) {
		this.hdlCtlx = hdlCtlx;
	}
	public int getHdlCtmj() {
		return hdlCtmj;
	}
	public void setHdlCtmj(int hdlCtmj) {
		this.hdlCtmj = hdlCtmj;
	}
	public int getHdlCtnumSta() {
		return hdlCtnumSta;
	}
	public void setHdlCtnumSta(int hdlCtnumSta) {
		this.hdlCtnumSta = hdlCtnumSta;
	}
	public int getHdlCtnum() {
		return hdlCtnum;
	}
	public void setHdlCtnum(int hdlCtnum) {
		this.hdlCtnum = hdlCtnum;
	}
	public String getHdlImg6() {
		return hdlImg6;
	}
	public void setHdlImg6(String hdlImg6) {
		this.hdlImg6 = hdlImg6;
	}
	public String getHdlTextpName() {
		return hdlTextpName;
	}
	public void setHdlTextpName(String hdlTextpName) {
		this.hdlTextpName = hdlTextpName;
	}
	public String getHdlTextLx() {
		return hdlTextLx;
	}
	public void setHdlTextLx(String hdlTextLx) {
		this.hdlTextLx = hdlTextLx;
	}
	public int getHdlTextmj() {
		return hdlTextmj;
	}
	public void setHdlTextmj(int hdlTextmj) {
		this.hdlTextmj = hdlTextmj;
	}
	public int getHdlTextNum() {
		return hdlTextNum;
	}
	public void setHdlTextNum(int hdlTextNum) {
		this.hdlTextNum = hdlTextNum;
	}
	public String getHdlTextmony() {
		return hdlTextmony;
	}
	public void setHdlTextmony(String hdlTextmony) {
		this.hdlTextmony = hdlTextmony;
	}
	public String getHdlImg7() {
		return hdlImg7;
	}
	public void setHdlImg7(String hdlImg7) {
		this.hdlImg7 = hdlImg7;
	}
	public String getHdlZyxm() {
		return hdlZyxm;
	}
	public void setHdlZyxm(String hdlZyxm) {
		this.hdlZyxm = hdlZyxm;
	}
	public String getHdlRegion() {
		return hdlRegion;
	}
	public void setHdlRegion(String hdlRegion) {
		this.hdlRegion = hdlRegion;
	}
	public String getHdlCantype() {
		return hdlCantype;
	}
	public void setHdlCantype(String hdlCantype) {
		this.hdlCantype = hdlCantype;
	}
	public String getHdlZhuying() {
		return hdlZhuying;
	}
	public void setHdlZhuying(String hdlZhuying) {
		this.hdlZhuying = hdlZhuying;
	}
	public String getHdlFacilitiesOther() {
		return hdlFacilitiesOther;
	}
	public void setHdlFacilitiesOther(String hdlFacilitiesOther) {
		this.hdlFacilitiesOther = hdlFacilitiesOther;
	}
	public String getHdlGame() {
		return hdlGame;
	}
	public void setHdlGame(String hdlGame) {
		this.hdlGame = hdlGame;
	}
	public String getHdlGameOther() {
		return hdlGameOther;
	}
	public void setHdlGameOther(String hdlGameOther) {
		this.hdlGameOther = hdlGameOther;
	}
	public String getHdlFood() {
		return hdlFood;
	}
	public void setHdlFood(String hdlFood) {
		this.hdlFood = hdlFood;
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
	public String getDicExternal() {
		return dicExternal;
	}
	public void setDicExternal(String dicExternal) {
		this.dicExternal = dicExternal;
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
	public String getCpyBrand() {
		return cpyBrand;
	}
	public void setCpyBrand(String cpyBrand) {
		this.cpyBrand = cpyBrand;
	}
	public Integer getHheId() {
		return hheId;
	}
	public void setHheId(Integer hheId) {
		this.hheId = hheId;
	}
	public Integer getHnpTradePrice() {
		return hnpTradePrice;
	}
	public void setHnpTradePrice(Integer hnpTradePrice) {
		this.hnpTradePrice = hnpTradePrice;
	}
	public Integer getHnpRetailPrice() {
		return hnpRetailPrice;
	}
	public void setHnpRetailPrice(Integer hnpRetailPrice) {
		this.hnpRetailPrice = hnpRetailPrice;
	}
	public Integer getHnpSign() {
		return hnpSign;
	}
	public void setHnpSign(Integer hnpSign) {
		this.hnpSign = hnpSign;
	}
	public String getHnpDate() {
		return hnpDate;
	}
	public void setHnpDate(String hnpDate) {
		this.hnpDate = hnpDate;
	}
	public Integer getHdlPrice1() {
		return hdlPrice1;
	}
	public void setHdlPrice1(Integer hdlPrice1) {
		this.hdlPrice1 = hdlPrice1;
	}
	public Integer getHdlPrice2() {
		return hdlPrice2;
	}
	public void setHdlPrice2(Integer hdlPrice2) {
		this.hdlPrice2 = hdlPrice2;
	}
	public List<HotelRoomBean> getListHotelRoom() {
		return listHotelRoom;
	}
	public void setListHotelRoom(List<HotelRoomBean> listHotelRoom) {
		this.listHotelRoom = listHotelRoom;
	}
	public String getAllRoomId() {
		return allRoomId;
	}
	public void setAllRoomId(String allRoomId) {
		this.allRoomId = allRoomId;
	}
	public String getHdlForeignCityVo() {
		return hdlForeignCityVo;
	}
	public void setHdlForeignCityVo(String hdlForeignCityVo) {
		this.hdlForeignCityVo = hdlForeignCityVo;
	}
	
}
