package com.erim.sz.common.bean;

import java.util.Date;
import java.util.List;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: TexiDetailBean
 * @Description: 租车管理
 * @author 陈鹏
 * @date 2015年7月10日 下午9:46:06
 */
public class TexiDetailBean extends BaseBean {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	//////////////////////////////////////////////// 自定义字段 start ////////////////////////////////////////////////////////////////////////////////
	
	//车辆信息跟随信息
	private List<VTexiCarBean> listVTexiCarBean;
	//所有子租车类型
	private String allTexiIdType;
	
	//////////////////////////////////////////////// 自定义字段 end ////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 车辆信息
	 */
	private Integer id;
	// 产品编号
	private String  tdlCode;
	// 是国内还是国外,02国内 01国外
	private String  tdlInland;
	// 省
	private String  tdlProvince;
	// 市
	private String  tdlCity;
	private String  tdlCityVo;
	// 县
	private String  tdlCounty;
	// 国际所在地
	private String	tdlExternal;
	// 外国
	private String 	tdlForeign;
	// 外国城市
	private String	tdlForeignCity;
	private String	tdlForeignCityVo;
	// 汽车品牌
	private String  tdlBrand;
	// 汽车名称
	private String  tdlName;
	// 汽车档次
	private String  tdlTexttype;
	// 车型
	private String  tdlType;
	// 汽车手动挡自动挡
	private String  tdlTextgear;
	// 汽车排量
	private String  tdlTextpail;
	// 乘坐人数
	private String  tdlNum;
	// 乘坐人数比较 0：等于 1：大于
	private Integer tdlNumCompare;
	// 购买日期
	private String  tdlCreatecardate;
	// 外观图
	private String  tdlImgAppearance;
	// 内部图
	private String  tdlImgBosom;
	// 可同时接单数量开始
	private String  tdlJiedan;
	// 创建用户
	private String  tdlCreateuser;
	// 创建时间
	private Date    tdlCreatedate;
	// 公司ID
	private Integer cpyId;
	// 是否停租 02是01否
	private String  tdlIsDelStatus;
	// 是否审核通过 02 是 01 否
	private String  tdlIsThrough;
	// 审核时间
	private Date    tdlThroughTime;
	// 审核人
	private String  tdlThroughUser;
	//预定方式
	private String tdlScheduled;
	
		
	/**
	 * 其余字段
	 */
	//公司名称名称
	private String  tdlGsname;
	//车型标准
	private String  tdlNtype;
	//车龄
	private Integer tdlAge;
	//档次
	private String  tdlLevel;
	//电话
	private String  tdlPhone;
	//优待政策
	private String  tdlReferentialPolicies;
	//预定限制
	private String  tdlSetReservation;
	//汽车数量
	private int  	tdlTextnum;
	//安全指南
	private String  tdlSecurityGuide;
	//推荐理由
	private String  tdlTuijian;
	//费用和违章须知
	private String  tdlTextwz;
	//费用包含
	private String  tdlTextcost;
	//保险说明
	private String  tdlTextinsurance;
	//取还车说明
	private String  tdlTexttext;
	//同业价
	private String  tdlTyprice;
	//批发价
	private String  tdlPfprice;
	//销售价
	private String  tdXsprice;
	//可同时接单数量开始
	private int  	tdlEndjiedan;
	//特别备注
	private String  tdlTeremark;
	//可否异地还车
	private String  tdlHuanche;
	//更改或取消订单说明
	private String  tdlTextdd;
	//限行
	private String  tdlTextxx;
	//还车时间截止
	private String  tdlEndtimetwo;
	//取车时间
	private String  tdlStarttime;
	//取车时间截止
	private String  tdlStarttimetwo;
	//还车时间
	private String  tdlEndtime;
	//取车地址
	private String  tdlAddress;
	//还车地址
	private String  tdlAddressone;
	//国际
	private String  tdlInternational;
	
	/////////////////////////////send_price表///////////////////////////////////
	private String priceId;
	//类型
	private String sendType;
	// 日期 yyyy-MM-dd
	private String	tspDate;
	// 零售价
	private Integer tspRetailPrice;
	// 费用说明
	private String	tspPriceShow;
	// 取消订单限制
	private String	tspCancelIndent;
	
	///////////////////////////////car_price////////////////////////////////////////
	// 全天零售价
	private Integer tcpRetailPrice;
	
	
	
	////////////////////////////////drive_price/////////////////////////////////////////
	// 全天零售价
	private Integer tdpRetailPrice;
	
	/////////////////////////////企业信息///////////////////////////////////
	
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
	
	/////////////////////////////转码参数///////////////////////////////////
	// 档次
	private String  dicLevel;
	// 城市
	private String  dicCity;
	// 出发城市
	private String  tdlCitytwo;
	// 目的城市
	private String  tdlCityone;
	// 租车使用类型编码
	private Integer tdlTypeCode;
	// 租车使用类型名称
	private String	tdlTypeName;
	// 入口号
	private String 	portal;
	// 租车使用类型
	private String 	applyType;
	// 当前固定接送信息ID
	private Integer sendId;
	// 包车类型
	private String 	bcType;
	// 自驾类型
	private String 	zjType;
	////////////////////////texi_sendb表参数///////////////////////////////////////////////////
	/**
	 * 接机字段
	 */
	private String 	gdlStart;
	private String 	gdlEnd;
	//接机费用说明
	private String gdlMoney;
	//接机服务说明
	private String gdlShow;
	/**
	 * 送机字段
	 */
	private String  gdlMachine;
	private String  gdlMachineback;
	//送机费用说明
	private String gdlMachinemoney;
	//送机服务说明
	private String gdlMachineshow;
	/**
	 * 接站字段
	 */
	private String  gdlStation;
	private String  gdlStationup;
	//接站费用说明
	private String gdlStationmoney;
	//接站说明
	private String gdlStationshow;
	/**
	 * 送站字段
	 */
	private String  gdlStationback;
	private String  gdlStationnup;
	//送站费用说明
	private String gdlStationbackmoney;
	//送站服务说明
	private String gdlStationbackshow;
	
	/**
	 * 固定线路
	 */
	//固定线路出发城市
	private String  gdlStartcity;
	//固定线路到达地方
	private String  gdlEndcity;
	//固定线路费用说明
	private String gdlCitymoney;
	//固定线路说明
	private String gdlCityshow;
	
	//固定路线日期 yyyy-MM-dd
	private String	tspDate1;
	//固定路线日期 yyyy-MM-dd
	private String	tspDate2;
	private String	tspDate3;
	private String	tspDate4;
	private String	tspDate5;
	//
	/////////////////////////////text_drive表参数///////////////////////////////////////////////////////////
	private String  zjlCity;//用车城市
	//半天取车地址
	private String  zjlHfTakeAddress;
	//全天取车地址  
	private String  zjlTakeAddress; 
	//自驾用车方式
	private String  zjlType;
	// 自驾游日期 yyyy-MM-dd
	private String	tdpDate1;
	// 自驾游日期 yyyy-MM-dd
	private String	tdpDate2;
	// 可否异地还车
	private String  zjlPlaceCar;
	//前台接收数据用：取车地点
	private String  zjlTakePlaceVo;
	//半天的取车地点
	private String  zjlHfTakePlace;
	//全天取车地点
	private String  ZjlTakePlace;
	//前台接收数据用：还车地点
	private String  zjlBackPlaceVo;
	//半天的还车地点
	private String  zjlHfBackPlace;
	//全天还车地点
	private String  zjlBackPlace;
	//////////////////////////////texi_car///////////////////////////////////////////////////////////////////////
	// 包车类型
	private String	bclType;
	// 包车日期 yyyy-MM-dd
	private String	tcpDate1;
	// 包车日期 yyyy-MM-dd
	private String	tcpDate2;
	
	///////////////////////////////////////////////////////////////////////////////////
	
	public String getGdlStart() {
		return gdlStart;
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

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public String getGdlMoney() {
		return gdlMoney;
	}

	public void setGdlMoney(String gdlMoney) {
		this.gdlMoney = gdlMoney;
	}

	public String getGdlShow() {
		return gdlShow;
	}

	public void setGdlShow(String gdlShow) {
		this.gdlShow = gdlShow;
	}

	public String getGdlMachinemoney() {
		return gdlMachinemoney;
	}

	public void setGdlMachinemoney(String gdlMachinemoney) {
		this.gdlMachinemoney = gdlMachinemoney;
	}

	public String getGdlMachineshow() {
		return gdlMachineshow;
	}

	public void setGdlMachineshow(String gdlMachineshow) {
		this.gdlMachineshow = gdlMachineshow;
	}

	public String getGdlStationmoney() {
		return gdlStationmoney;
	}

	public void setGdlStationmoney(String gdlStationmoney) {
		this.gdlStationmoney = gdlStationmoney;
	}

	public String getGdlStationshow() {
		return gdlStationshow;
	}

	public void setGdlStationshow(String gdlStationshow) {
		this.gdlStationshow = gdlStationshow;
	}

	public String getGdlStationbackmoney() {
		return gdlStationbackmoney;
	}

	public void setGdlStationbackmoney(String gdlStationbackmoney) {
		this.gdlStationbackmoney = gdlStationbackmoney;
	}

	public String getGdlStationbackshow() {
		return gdlStationbackshow;
	}

	public void setGdlStationbackshow(String gdlStationbackshow) {
		this.gdlStationbackshow = gdlStationbackshow;
	}

	public String getGdlCitymoney() {
		return gdlCitymoney;
	}

	public void setGdlCitymoney(String gdlCitymoney) {
		this.gdlCitymoney = gdlCitymoney;
	}

	public String getGdlCityshow() {
		return gdlCityshow;
	}

	public void setGdlCityshow(String gdlCityshow) {
		this.gdlCityshow = gdlCityshow;
	}

	public Integer getTdpRetailPrice() {
		return tdpRetailPrice;
	}

	public void setTdpRetailPrice(Integer tdpRetailPrice) {
		this.tdpRetailPrice = tdpRetailPrice;
	}

	public Integer getTcpRetailPrice() {
		return tcpRetailPrice;
	}

	public void setTcpRetailPrice(Integer tcpRetailPrice) {
		this.tcpRetailPrice = tcpRetailPrice;
	}

	public String getTspDate() {
		return tspDate;
	}

	public void setTspDate(String tspDate) {
		this.tspDate = tspDate;
	}

	public Integer getTspRetailPrice() {
		return tspRetailPrice;
	}

	public void setTspRetailPrice(Integer tspRetailPrice) {
		this.tspRetailPrice = tspRetailPrice;
	}

	public String getTspPriceShow() {
		return tspPriceShow;
	}

	public void setTspPriceShow(String tspPriceShow) {
		this.tspPriceShow = tspPriceShow;
	}

	public String getTspCancelIndent() {
		return tspCancelIndent;
	}

	public void setTspCancelIndent(String tspCancelIndent) {
		this.tspCancelIndent = tspCancelIndent;
	}

	public String getBclType() {
		return bclType;
	}

	public void setBclType(String bclType) {
		this.bclType = bclType;
	}

	public String getTcpDate1() {
		return tcpDate1;
	}

	public void setTcpDate1(String tcpDate1) {
		this.tcpDate1 = tcpDate1;
	}

	public String getTcpDate2() {
		return tcpDate2;
	}

	public void setTcpDate2(String tcpDate2) {
		this.tcpDate2 = tcpDate2;
	}

	public String getTspDate1() {
		return tspDate1;
	}

	public void setTspDate1(String tspDate1) {
		this.tspDate1 = tspDate1;
	}

	public String getTspDate2() {
		return tspDate2;
	}

	public void setTspDate2(String tspDate2) {
		this.tspDate2 = tspDate2;
	}

	public String getTdpDate1() {
		return tdpDate1;
	}

	public void setTdpDate1(String tdpDate1) {
		this.tdpDate1 = tdpDate1;
	}

	public String getTdpDate2() {
		return tdpDate2;
	}

	public void setTdpDate2(String tdpDate2) {
		this.tdpDate2 = tdpDate2;
	}

	public String getZjlType() {
		return zjlType;
	}

	public void setZjlType(String zjlType) {
		this.zjlType = zjlType;
	}

	public String getZjlTakePlaceVo() {
		return zjlTakePlaceVo;
	}

	public void setZjlTakePlaceVo(String zjlTakePlaceVo) {
		this.zjlTakePlaceVo = zjlTakePlaceVo;
	}

	public String getZjlBackPlaceVo() {
		return zjlBackPlaceVo;
	}

	public void setZjlBackPlaceVo(String zjlBackPlaceVo) {
		this.zjlBackPlaceVo = zjlBackPlaceVo;
	}

	public String getZjlHfBackPlace() {
		return zjlHfBackPlace;
	}

	public void setZjlHfBackPlace(String zjlHfBackPlace) {
		this.zjlHfBackPlace = zjlHfBackPlace;
	}

	public String getZjlBackPlace() {
		return zjlBackPlace;
	}

	public void setZjlBackPlace(String zjlBackPlace) {
		this.zjlBackPlace = zjlBackPlace;
	}

	public String getZjlHfTakePlace() {
		return zjlHfTakePlace;
	}

	public void setZjlHfTakePlace(String zjlHfTakePlace) {
		this.zjlHfTakePlace = zjlHfTakePlace;
	}

	public String getZjlTakePlace() {
		return ZjlTakePlace;
	}

	public void setZjlTakePlace(String zjlTakePlace) {
		ZjlTakePlace = zjlTakePlace;
	}

	public String getZjlPlaceCar() {
		return zjlPlaceCar;
	}

	public void setZjlPlaceCar(String zjlPlaceCar) {
		this.zjlPlaceCar = zjlPlaceCar;
	}

	public String getZjlHfTakeAddress() {
		return zjlHfTakeAddress;
	}

	public void setZjlHfTakeAddress(String zjlHfTakeAddress) {
		this.zjlHfTakeAddress = zjlHfTakeAddress;
	}

	public String getZjlTakeAddress() {
		return zjlTakeAddress;
	}

	public void setZjlTakeAddress(String zjlTakeAddress) {
		this.zjlTakeAddress = zjlTakeAddress;
	}

	

	public String getZjlCity() {
		return zjlCity;
	}

	public void setZjlCity(String zjlCity) {
		this.zjlCity = zjlCity;
	}

	public String getGdlStartcity() {
		return gdlStartcity;
	}

	public void setGdlStartcity(String gdlStartcity) {
		this.gdlStartcity = gdlStartcity;
	}

	public String getGdlEndcity() {
		return gdlEndcity;
	}

	public void setGdlEndcity(String gdlEndcity) {
		this.gdlEndcity = gdlEndcity;
	}

	public Integer getTdlNumCompare() {
		return tdlNumCompare;
	}

	public void setTdlNumCompare(Integer tdlNumCompare) {
		this.tdlNumCompare = tdlNumCompare;
	}

	public String getGdlStationback() {
		return gdlStationback;
	}
	public void setGdlStationback(String gdlStationback) {
		this.gdlStationback = gdlStationback;
	}
	public String getGdlStationnup() {
		return gdlStationnup;
	}
	public void setGdlStationnup(String gdlStationnup) {
		this.gdlStationnup = gdlStationnup;
	}
	public String getGdlStation() {
		return gdlStation;
	}
	public void setGdlStation(String gdlStation) {
		this.gdlStation = gdlStation;
	}
	public String getGdlStationup() {
		return gdlStationup;
	}
	public void setGdlStationup(String gdlStationup) {
		this.gdlStationup = gdlStationup;
	}
	public String getGdlMachine() {
		return gdlMachine;
	}
	public void setGdlMachine(String gdlMachine) {
		this.gdlMachine = gdlMachine;
	}
	public String getGdlMachineback() {
		return gdlMachineback;
	}
	public void setGdlMachineback(String gdlMachineback) {
		this.gdlMachineback = gdlMachineback;
	}
	public void setGdlStart(String gdlStart) {
		this.gdlStart = gdlStart;
	}
	public String getGdlEnd() {
		return gdlEnd;
	}
	public void setGdlEnd(String gdlEnd) {
		this.gdlEnd = gdlEnd;
	}
	public Integer getId() {
		return id;
	}
	public String getBcType() {
		return bcType;
	}
	public void setBcType(String bcType) {
		this.bcType = bcType;
	}
	public String getZjType() {
		return zjType;
	}
	public void setZjType(String zjType) {
		this.zjType = zjType;
	}
	public Integer getSendId() {
		return sendId;
	}
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public String getPortal() {
		return portal;
	}
	public void setPortal(String portal) {
		this.portal = portal;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTdlCode() {
		return tdlCode;
	}
	public void setTdlCode(String tdlCode) {
		this.tdlCode = tdlCode;
	}
	public String getTdlInland() {
		return tdlInland;
	}
	public void setTdlInland(String tdlInland) {
		this.tdlInland = tdlInland;
	}
	public String getTdlProvince() {
		return tdlProvince;
	}
	public void setTdlProvince(String tdlProvince) {
		this.tdlProvince = tdlProvince;
	}
	public String getTdlCity() {
		return tdlCity;
	}
	public void setTdlCity(String tdlCity) {
		this.tdlCity = tdlCity;
	}
	public String getTdlCounty() {
		return tdlCounty;
	}
	public void setTdlCounty(String tdlCounty) {
		this.tdlCounty = tdlCounty;
	}
	public String getTdlExternal() {
		return tdlExternal;
	}
	public void setTdlExternal(String tdlExternal) {
		this.tdlExternal = tdlExternal;
	}
	public String getTdlForeign() {
		return tdlForeign;
	}
	public void setTdlForeign(String tdlForeign) {
		this.tdlForeign = tdlForeign;
	}
	public String getTdlForeignCity() {
		return tdlForeignCity;
	}
	public void setTdlForeignCity(String tdlForeignCity) {
		this.tdlForeignCity = tdlForeignCity;
	}
	public String getTdlBrand() {
		return tdlBrand;
	}
	public void setTdlBrand(String tdlBrand) {
		this.tdlBrand = tdlBrand;
	}
	public String getTdlName() {
		return tdlName;
	}
	public void setTdlName(String tdlName) {
		this.tdlName = tdlName;
	}
	public String getTdlTexttype() {
		return tdlTexttype;
	}
	public void setTdlTexttype(String tdlTexttype) {
		this.tdlTexttype = tdlTexttype;
	}
	public String getTdlType() {
		return tdlType;
	}
	public void setTdlType(String tdlType) {
		this.tdlType = tdlType;
	}
	public String getTdlTextgear() {
		return tdlTextgear;
	}
	public void setTdlTextgear(String tdlTextgear) {
		this.tdlTextgear = tdlTextgear;
	}
	public String getTdlTextpail() {
		return tdlTextpail;
	}
	public void setTdlTextpail(String tdlTextpail) {
		this.tdlTextpail = tdlTextpail;
	}
	public String getTdlNum() {
		return tdlNum;
	}
	public void setTdlNum(String tdlNum) {
		this.tdlNum = tdlNum;
	}
	public String getTdlCreatecardate() {
		return tdlCreatecardate;
	}
	public void setTdlCreatecardate(String tdlCreatecardate) {
		this.tdlCreatecardate = tdlCreatecardate;
	}
	public String getTdlImgAppearance() {
		return tdlImgAppearance;
	}
	public void setTdlImgAppearance(String tdlImgAppearance) {
		this.tdlImgAppearance = tdlImgAppearance;
	}
	public String getTdlImgBosom() {
		return tdlImgBosom;
	}
	public void setTdlImgBosom(String tdlImgBosom) {
		this.tdlImgBosom = tdlImgBosom;
	}
	
	public String getTdlJiedan() {
		return tdlJiedan;
	}
	public void setTdlJiedan(String tdlJiedan) {
		this.tdlJiedan = tdlJiedan;
	}
	public String getTdlCreateuser() {
		return tdlCreateuser;
	}
	public void setTdlCreateuser(String tdlCreateuser) {
		this.tdlCreateuser = tdlCreateuser;
	}
	public Date getTdlCreatedate() {
		return tdlCreatedate;
	}
	public void setTdlCreatedate(Date tdlCreatedate) {
		this.tdlCreatedate = tdlCreatedate;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getTdlIsDelStatus() {
		return tdlIsDelStatus;
	}
	public void setTdlIsDelStatus(String tdlIsDelStatus) {
		this.tdlIsDelStatus = tdlIsDelStatus;
	}
	public String getTdlIsThrough() {
		return tdlIsThrough;
	}
	public void setTdlIsThrough(String tdlIsThrough) {
		this.tdlIsThrough = tdlIsThrough;
	}
	public Date getTdlThroughTime() {
		return tdlThroughTime;
	}
	public void setTdlThroughTime(Date tdlThroughTime) {
		this.tdlThroughTime = tdlThroughTime;
	}
	public String getTdlThroughUser() {
		return tdlThroughUser;
	}
	public void setTdlThroughUser(String tdlThroughUser) {
		this.tdlThroughUser = tdlThroughUser;
	}
	public String getTdlGsname() {
		return tdlGsname;
	}
	public void setTdlGsname(String tdlGsname) {
		this.tdlGsname = tdlGsname;
	}
	public String getTdlNtype() {
		return tdlNtype;
	}
	public void setTdlNtype(String tdlNtype) {
		this.tdlNtype = tdlNtype;
	}
	public Integer getTdlAge() {
		return tdlAge;
	}
	public void setTdlAge(Integer tdlAge) {
		this.tdlAge = tdlAge;
	}
	public String getTdlLevel() {
		return tdlLevel;
	}
	public void setTdlLevel(String tdlLevel) {
		this.tdlLevel = tdlLevel;
	}
	public String getTdlPhone() {
		return tdlPhone;
	}
	public void setTdlPhone(String tdlPhone) {
		this.tdlPhone = tdlPhone;
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
	public int getTdlTextnum() {
		return tdlTextnum;
	}
	public void setTdlTextnum(int tdlTextnum) {
		this.tdlTextnum = tdlTextnum;
	}
	public String getTdlSecurityGuide() {
		return tdlSecurityGuide;
	}
	public void setTdlSecurityGuide(String tdlSecurityGuide) {
		this.tdlSecurityGuide = tdlSecurityGuide;
	}
	public String getTdlTuijian() {
		return tdlTuijian;
	}
	public void setTdlTuijian(String tdlTuijian) {
		this.tdlTuijian = tdlTuijian;
	}
	public String getTdlTextwz() {
		return tdlTextwz;
	}
	public void setTdlTextwz(String tdlTextwz) {
		this.tdlTextwz = tdlTextwz;
	}
	public String getTdlTextcost() {
		return tdlTextcost;
	}
	public void setTdlTextcost(String tdlTextcost) {
		this.tdlTextcost = tdlTextcost;
	}
	public String getTdlTextinsurance() {
		return tdlTextinsurance;
	}
	public void setTdlTextinsurance(String tdlTextinsurance) {
		this.tdlTextinsurance = tdlTextinsurance;
	}
	public String getTdlTexttext() {
		return tdlTexttext;
	}
	public void setTdlTexttext(String tdlTexttext) {
		this.tdlTexttext = tdlTexttext;
	}
	public String getTdlTyprice() {
		return tdlTyprice;
	}
	public void setTdlTyprice(String tdlTyprice) {
		this.tdlTyprice = tdlTyprice;
	}
	public String getTdlPfprice() {
		return tdlPfprice;
	}
	public void setTdlPfprice(String tdlPfprice) {
		this.tdlPfprice = tdlPfprice;
	}
	public String getTdXsprice() {
		return tdXsprice;
	}
	public void setTdXsprice(String tdXsprice) {
		this.tdXsprice = tdXsprice;
	}
	public int getTdlEndjiedan() {
		return tdlEndjiedan;
	}
	public void setTdlEndjiedan(int tdlEndjiedan) {
		this.tdlEndjiedan = tdlEndjiedan;
	}
	public String getTdlTeremark() {
		return tdlTeremark;
	}
	public void setTdlTeremark(String tdlTeremark) {
		this.tdlTeremark = tdlTeremark;
	}
	public String getTdlHuanche() {
		return tdlHuanche;
	}
	public void setTdlHuanche(String tdlHuanche) {
		this.tdlHuanche = tdlHuanche;
	}
	public String getTdlTextdd() {
		return tdlTextdd;
	}
	public void setTdlTextdd(String tdlTextdd) {
		this.tdlTextdd = tdlTextdd;
	}
	public String getTdlTextxx() {
		return tdlTextxx;
	}
	public void setTdlTextxx(String tdlTextxx) {
		this.tdlTextxx = tdlTextxx;
	}
	public String getTdlEndtimetwo() {
		return tdlEndtimetwo;
	}
	public void setTdlEndtimetwo(String tdlEndtimetwo) {
		this.tdlEndtimetwo = tdlEndtimetwo;
	}
	public String getTdlStarttime() {
		return tdlStarttime;
	}
	public void setTdlStarttime(String tdlStarttime) {
		this.tdlStarttime = tdlStarttime;
	}
	public String getTdlStarttimetwo() {
		return tdlStarttimetwo;
	}
	public void setTdlStarttimetwo(String tdlStarttimetwo) {
		this.tdlStarttimetwo = tdlStarttimetwo;
	}
	public String getTdlEndtime() {
		return tdlEndtime;
	}
	public void setTdlEndtime(String tdlEndtime) {
		this.tdlEndtime = tdlEndtime;
	}
	public String getTdlAddress() {
		return tdlAddress;
	}
	public void setTdlAddress(String tdlAddress) {
		this.tdlAddress = tdlAddress;
	}
	public String getTdlAddressone() {
		return tdlAddressone;
	}
	public void setTdlAddressone(String tdlAddressone) {
		this.tdlAddressone = tdlAddressone;
	}
	public String getTdlInternational() {
		return tdlInternational;
	}
	public void setTdlInternational(String tdlInternational) {
		this.tdlInternational = tdlInternational;
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
	public String getDicLevel() {
		return dicLevel;
	}
	public void setDicLevel(String dicLevel) {
		this.dicLevel = dicLevel;
	}
	public String getDicCity() {
		return dicCity;
	}
	public void setDicCity(String dicCity) {
		this.dicCity = dicCity;
	}
	public String getTdlCitytwo() {
		return tdlCitytwo;
	}
	public void setTdlCitytwo(String tdlCitytwo) {
		this.tdlCitytwo = tdlCitytwo;
	}
	public String getTdlCityone() {
		return tdlCityone;
	}
	public void setTdlCityone(String tdlCityone) {
		this.tdlCityone = tdlCityone;
	}
	public Integer getTdlTypeCode() {
		return tdlTypeCode;
	}
	public void setTdlTypeCode(Integer tdlTypeCode) {
		this.tdlTypeCode = tdlTypeCode;
	}
	public String getTdlTypeName() {
		return tdlTypeName;
	}
	public void setTdlTypeName(String tdlTypeName) {
		this.tdlTypeName = tdlTypeName;
	}
	public String getTdlScheduled() {
		return tdlScheduled;
	}
	public void setTdlScheduled(String tdlScheduled) {
		this.tdlScheduled = tdlScheduled;
	}

	public String getTdlCityVo() {
		return tdlCityVo;
	}

	public void setTdlCityVo(String tdlCityVo) {
		this.tdlCityVo = tdlCityVo;
	}

	public String getTdlForeignCityVo() {
		return tdlForeignCityVo;
	}

	public void setTdlForeignCityVo(String tdlForeignCityVo) {
		this.tdlForeignCityVo = tdlForeignCityVo;
	}

	public List<VTexiCarBean> getListVTexiCarBean() {
		return listVTexiCarBean;
	}

	public void setListVTexiCarBean(List<VTexiCarBean> listVTexiCarBean) {
		this.listVTexiCarBean = listVTexiCarBean;
	}

	public String getAllTexiIdType() {
		return allTexiIdType;
	}

	public void setAllTexiIdType(String allTexiIdType) {
		this.allTexiIdType = allTexiIdType;
	}

	public String getPriceId() {
		return priceId;
	}

	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}

	public String getTspDate3() {
		return tspDate3;
	}

	public void setTspDate3(String tspDate3) {
		this.tspDate3 = tspDate3;
	}

	public String getTspDate4() {
		return tspDate4;
	}

	public void setTspDate4(String tspDate4) {
		this.tspDate4 = tspDate4;
	}

	public String getTspDate5() {
		return tspDate5;
	}

	public void setTspDate5(String tspDate5) {
		this.tspDate5 = tspDate5;
	}
	
	
}
