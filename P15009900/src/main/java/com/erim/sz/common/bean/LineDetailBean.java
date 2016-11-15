package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.List;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: LineDetailBean
 * @Description: 专线管理
 * @author 陈鹏
 * @date 2015年7月14日 下午8:59:15
 *
 */
public class LineDetailBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private Integer id;
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
    //公司logo
  	private String  cpyImg;
  	//公司地址
  	private String  cpyAddress;
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	//企业id
	private Integer cpyId;
	//产品编码
	private String ldlCode;
    //产品编号
	private String ldlCode1;
	//线路名称
	private String ldlName;
	//出发地_省
	private String ldlProvince;
	//出发地_市
	private String ldlCity;
	//出发地_县
	private String ldlCounty;
	//出发地_详细地址
	private String ldlStartplaceAddress;
	//行程特色
	private String ldlFeatures;
	//产品特色
	private String ldlFeature;
	//特别优惠
	private String ldlPreferential;
	//发团日期
	private String ldlStartdate;
	//发团截止日期
	private String ldlEnddate;
	//产品属性
	private String ldlAttribute1;
	//产品属性小类
	private String ldlAttribute2;
	//是否周边
	private String ldlPerimeterIs;
	//周边地址
	private String ldlPerimeterDetail;
	//出发时间
	private String ldlStarttime;
	//集合地点
	private String ldlStartaddress;
	//补充说明
	private String ldlNotes;
	//产品特色
	private String ldlCharacteristic;
	//费用包含
	private String ldlMoneyContain;
	//费用不包含
	private String ldlMoneyContainOff;
	//项目参考
	private String ldlProject;
	//预定限制
	private String ldlScheduleLimit;
	//预定违约条款
	private String ldlScheduleBreak;
	//出行须知
	private String ldlScheduleTravel;
	//经理推荐
	private String ldlRecommend;
	//创建时间
	private String ldlCreatedate;
	//创建用户
	private String ldlCreateuser;
	//是否审核通过 1 是 0 否
	private String ldIsThrough;
	private String ldThroughTime;
	private String ldThroughUser;
	//类型 1国内旅游 2国外旅游
	private String ldlNtype;
	//消费者违约
	private String ldlScheduleBreak1;
	//大交通去程
	private String ldlBigTraffic;
	//大交通返程
	private String  ldlBigTraffic1;
	//上下架
	private String ldlIsDelStatus;
	//专线推广图
    private String ldlPicture;
    //所属专线
    private String ldlSpecialLine;
    //主要景点
    private String ldlAttraction;
    //产品形态
    private String ldlProductForm;
    //客人构成
    private String ldlGuest;
    //产品标准
    private String ldlProductStandard;
    //特别提醒
    private String ldlRemind;
    //推荐自费
    private String ldlExpense;
    //其他推荐
    private String ldlRemark;
    //同城标识
    private String ldlSameSign;
    //主题1
  	private String ldlProType1;
    //主题2
  	private String ldlProType2;
  	//是否属于学生活动
  	private String ldlYesno; 
  	//学生活动
  	private String ldlGame;
  	//添加学生活动
  	private String ldlAddgame;
  	//国内国外
  	private String ldlInternation;
  	//国际港澳台
  	private String ldlCountylocation;
  	//国家
  	private String ldlMajorcountries;
  	//城市
  	private String ldlDeparturecity;
  	//线路类型
  	private String ldlProductine;
  	//预定方式
  	private String ldlScheduled;
  	//////////////////////////////////////////////////////////////////////////////////
  	
  	private Integer zdyDate;
  	private String lpeRetailAdult;
  	//合作组团
  	private String[] astrcpyId;
  	
  	//组团id
  	private Integer  sellId;
  	
  	 //分钟
  	private String ldlMinute;
  	
  	//是否合作
  	private String zscIsCoopertion;
  	
  	//行程
  	private List<LineTripBean> listTripBean;
    //专线国家名称数组，查询用
  	private List<String> listNation;
  	
  //热门推荐类型,查询用
  //类别 1周边 2国内 3 港澳台/日韩/东南亚 4朝鲜/俄罗斯/欧洲/美洲
  	private String  mhtNtype;
//////////////////////////////拓展字段/////////////////////////////////////////
  	private Integer countDay;
  	private Integer countDayCompare;
  	
///////////////////////////////////无用字段//////////////////////////////////////
  	
	//儿童价格
  	private Integer ldlMoneyChildren;
    //批发价
  	private Integer ldlPriceWholesale;
  	//销售价
  	private Integer ldlPriceSell;
	//同城同业
	private Integer ldlPriceSametown;
	//主题3
	private String ldlProType3;
	//产品关键词
	private String ldlKeyword;
	//地址关键字
	private String ldlKeyword1;
	 //集合地点 
  	private String ldlSet;
  	//集合时间
  	private String ldlStarttime1;
  	//集合标志
  	private String ldlMark;
	
	
////////////////////////////////////////get/set///////////////////////////////

	public String getCpyName() {
		return cpyName;
	}
	public String getCpyImg() {
		return cpyImg;
	}
	public void setCpyImg(String cpyImg) {
		this.cpyImg = cpyImg;
	}
	public String getCpyAddress() {
		return cpyAddress;
	}
	public void setCpyAddress(String cpyAddress) {
		this.cpyAddress = cpyAddress;
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
	
	 public String[] getAstrcpyId() {
		return astrcpyId;
	}
	public void setAstrcpyId(String[] astrcpyId) {
		this.astrcpyId = astrcpyId;
	}
	public Integer getSellId() {
		return sellId;
	}
	public void setSellId(Integer sellId) {
		this.sellId = sellId;
	}	
	public Integer getId() {
		return id;
	}
	public String getLpeRetailAdult() {
		return lpeRetailAdult;
	}
	public void setLpeRetailAdult(String lpeRetailAdult) {
		this.lpeRetailAdult = lpeRetailAdult;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLdlName() {
		return ldlName;
	}
	public void setLdlName(String ldlName) {
		this.ldlName = ldlName;
	}
	public String getLdlProvince() {
		return ldlProvince;
	}
	public void setLdlProvince(String ldlProvince) {
		this.ldlProvince = ldlProvince;
	}
	public String getLdlCity() {
		return ldlCity;
	}
	public void setLdlCity(String ldlCity) {
		this.ldlCity = ldlCity;
	}
	public String getLdlCounty() {
		return ldlCounty;
	}
	public void setLdlCounty(String ldlCounty) {
		this.ldlCounty = ldlCounty;
	}
	public String getLdlStartplaceAddress() {
		return ldlStartplaceAddress;
	}
	public void setLdlStartplaceAddress(String ldlStartplaceAddress) {
		this.ldlStartplaceAddress = ldlStartplaceAddress;
	}
	public String getLdlFeatures() {
		return ldlFeatures;
	}
	public void setLdlFeatures(String ldlFeatures) {
		this.ldlFeatures = ldlFeatures;
	}
	public String getLdlPreferential() {
		return ldlPreferential;
	}
	public void setLdlPreferential(String ldlPreferential) {
		this.ldlPreferential = ldlPreferential;
	}
	public String getLdlStartdate() {
		return ldlStartdate;
	}
	public void setLdlStartdate(String ldlStartdate) {
		this.ldlStartdate = ldlStartdate;
	}
	public String getLdlEnddate() {
		return ldlEnddate;
	}
	public void setLdlEnddate(String ldlEnddate) {
		this.ldlEnddate = ldlEnddate;
	}
	public String getLdlAttribute1() {
		return ldlAttribute1;
	}
	public void setLdlAttribute1(String ldlAttribute1) {
		this.ldlAttribute1 = ldlAttribute1;
	}
	public String getLdlAttribute2() {
		return ldlAttribute2;
	}
	public void setLdlAttribute2(String ldlAttribute2) {
		this.ldlAttribute2 = ldlAttribute2;
	}
	public String getLdlPerimeterIs() {
		return ldlPerimeterIs;
	}
	public void setLdlPerimeterIs(String ldlPerimeterIs) {
		this.ldlPerimeterIs = ldlPerimeterIs;
	}
	public String getLdlPerimeterDetail() {
		return ldlPerimeterDetail;
	}
	public void setLdlPerimeterDetail(String ldlPerimeterDetail) {
		this.ldlPerimeterDetail = ldlPerimeterDetail;
	}
	public String getLdlStarttime() {
		return ldlStarttime;
	}
	public void setLdlStarttime(String ldlStarttime) {
		this.ldlStarttime = ldlStarttime;
	}
	public String getLdlStartaddress() {
		return ldlStartaddress;
	}
	public void setLdlStartaddress(String ldlStartaddress) {
		this.ldlStartaddress = ldlStartaddress;
	}
	public String getLdlNotes() {
		return ldlNotes;
	}
	public void setLdlNotes(String ldlNotes) {
		this.ldlNotes = ldlNotes;
	}
	public String getLdlCharacteristic() {
		return ldlCharacteristic;
	}
	public void setLdlCharacteristic(String ldlCharacteristic) {
		this.ldlCharacteristic = ldlCharacteristic;
	}
	
	public String getLdlMoneyContain() {
		return ldlMoneyContain;
	}
	public void setLdlMoneyContain(String ldlMoneyContain) {
		this.ldlMoneyContain = ldlMoneyContain;
	}
	public String getLdlMoneyContainOff() {
		return ldlMoneyContainOff;
	}
	public void setLdlMoneyContainOff(String ldlMoneyContainOff) {
		this.ldlMoneyContainOff = ldlMoneyContainOff;
	}
	public String getLdlProject() {
		return ldlProject;
	}
	public void setLdlProject(String ldlProject) {
		this.ldlProject = ldlProject;
	}
	public String getLdlScheduleLimit() {
		return ldlScheduleLimit;
	}
	public void setLdlScheduleLimit(String ldlScheduleLimit) {
		this.ldlScheduleLimit = ldlScheduleLimit;
	}
	public String getLdlScheduleBreak() {
		return ldlScheduleBreak;
	}
	public void setLdlScheduleBreak(String ldlScheduleBreak) {
		this.ldlScheduleBreak = ldlScheduleBreak;
	}
	public String getLdlScheduleTravel() {
		return ldlScheduleTravel;
	}
	public void setLdlScheduleTravel(String ldlScheduleTravel) {
		this.ldlScheduleTravel = ldlScheduleTravel;
	}
	public String getLdlRecommend() {
		return ldlRecommend;
	}
	public void setLdlRecommend(String ldlRecommend) {
		this.ldlRecommend = ldlRecommend;
	}
	public Integer getLdlPriceWholesale() {
		return ldlPriceWholesale;
	}
	public void setLdlPriceWholesale(Integer ldlPriceWholesale) {
		this.ldlPriceWholesale = ldlPriceWholesale;
	}
	public Integer getLdlPriceSell() {
		return ldlPriceSell;
	}
	public void setLdlPriceSell(Integer ldlPriceSell) {
		this.ldlPriceSell = ldlPriceSell;
	}
	public String getLdlCreatedate() {
		return ldlCreatedate;
	}
	public void setLdlCreatedate(String ldlCreatedate) {
		this.ldlCreatedate = ldlCreatedate;
	}
	public String getLdlCreateuser() {
		return ldlCreateuser;
	}
	public void setLdlCreateuser(String ldlCreateuser) {
		this.ldlCreateuser = ldlCreateuser;
	}
	public Integer getLdlPriceSametown() {
		return ldlPriceSametown;
	}
	public void setLdlPriceSametown(Integer ldlPriceSametown) {
		this.ldlPriceSametown = ldlPriceSametown;
	}
	public String getLdIsThrough() {
		return ldIsThrough;
	}
	public void setLdIsThrough(String ldIsThrough) {
		this.ldIsThrough = ldIsThrough;
	}
	public String getLdThroughTime() {
		return ldThroughTime;
	}
	public void setLdThroughTime(String ldThroughTime) {
		this.ldThroughTime = ldThroughTime;
	}
	public String getLdThroughUser() {
		return ldThroughUser;
	}
	public void setLdThroughUser(String ldThroughUser) {
		this.ldThroughUser = ldThroughUser;
	}
	public Integer getLdlMoneyChildren() {
		return ldlMoneyChildren;
	}
	public void setLdlMoneyChildren(Integer ldlMoneyChildren) {
		this.ldlMoneyChildren = ldlMoneyChildren;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getLdlNtype() {
		return ldlNtype;
	}
	public void setLdlNtype(String ldlNtype) {
		this.ldlNtype = ldlNtype;
	}
	public String getLdlProType1() {
		return ldlProType1;
	}
	public void setLdlProType1(String ldlProType1) {
		this.ldlProType1 = ldlProType1;
	}
	public String getLdlProType2() {
		return ldlProType2;
	}
	public void setLdlProType2(String ldlProType2) {
		this.ldlProType2 = ldlProType2;
	}
	public String getLdlProType3() {
		return ldlProType3;
	}
	public void setLdlProType3(String ldlProType3) {
		this.ldlProType3 = ldlProType3;
	}
	public String getLdlKeyword() {
		return ldlKeyword;
	}
	public void setLdlKeyword(String ldlKeyword) {
		this.ldlKeyword = ldlKeyword;
	}
	public String getLdlKeyword1() {
		return ldlKeyword1;
	}
	public void setLdlKeyword1(String ldlKeyword1) {
		this.ldlKeyword1 = ldlKeyword1;
	}
	public String getLdlScheduleBreak1() {
		return ldlScheduleBreak1;
	}
	public void setLdlScheduleBreak1(String ldlScheduleBreak1) {
		this.ldlScheduleBreak1 = ldlScheduleBreak1;
	}
	public String getLdlCode() {
		return ldlCode;
	}
	public void setLdlCode(String ldlCode) {
		this.ldlCode = ldlCode;
	}
	public String getLdlBigTraffic() {
		return ldlBigTraffic;
	}
	public void setLdlBigTraffic(String ldlBigTraffic) {
		this.ldlBigTraffic = ldlBigTraffic;
	}
	public String getLdlIsDelStatus() {
		return ldlIsDelStatus;
	}
	public void setLdlIsDelStatus(String ldlIsDelStatus) {
		this.ldlIsDelStatus = ldlIsDelStatus;
	}
	public String getLdlMinute() {
		return ldlMinute;
	}
	public void setLdlMinute(String ldlMinute) {
		this.ldlMinute = ldlMinute;
	}
	public String getLdlPicture() {
		return ldlPicture;
	}
	public void setLdlPicture(String ldlPicture) {
		this.ldlPicture = ldlPicture;
	}
	public String getLdlSpecialLine() {
		return ldlSpecialLine;
	}
	public void setLdlSpecialLine(String ldlSpecialLine) {
		this.ldlSpecialLine = ldlSpecialLine;
	}
	public String getLdlProductForm() {
		return ldlProductForm;
	}
	public void setLdlProductForm(String ldlProductForm) {
		this.ldlProductForm = ldlProductForm;
	}
	public String getLdlProductStandard() {
		return ldlProductStandard;
	}
	public void setLdlProductStandard(String ldlProductStandard) {
		this.ldlProductStandard = ldlProductStandard;
	}
	public String getLdlRemind() {
		return ldlRemind;
	}
	public void setLdlRemind(String ldlRemind) {
		this.ldlRemind = ldlRemind;
	}
	public String getLdlExpense() {
		return ldlExpense;
	}
	public void setLdlExpense(String ldlExpense) {
		this.ldlExpense = ldlExpense;
	}
	public String getLdlRemark() {
		return ldlRemark;
	}
	public void setLdlRemark(String ldlRemark) {
		this.ldlRemark = ldlRemark;
	}
	public String getLdlAttraction() {
		return ldlAttraction;
	}
	public void setLdlAttraction(String ldlAttraction) {
		this.ldlAttraction = ldlAttraction;
	}
	public String getLdlSameSign() {
		return ldlSameSign;
	}
	public void setLdlSameSign(String ldlSameSign) {
		this.ldlSameSign = ldlSameSign;
	}
	public String getLdlCode1() {
		return ldlCode1;
	}
	public void setLdlCode1(String ldlCode1) {
		this.ldlCode1 = ldlCode1;
	}
	public String getLdlGuest() {
		return ldlGuest;
	}
	public void setLdlGuest(String ldlGuest) {
		this.ldlGuest = ldlGuest;
	}
	public String getLdlBigTraffic1() {
		return ldlBigTraffic1;
	}
	public void setLdlBigTraffic1(String ldlBigTraffic1) {
		this.ldlBigTraffic1 = ldlBigTraffic1;
	}
	public Integer getZdyDate() {
		return zdyDate;
	}
	public void setZdyDate(Integer zdyDate) {
		this.zdyDate = zdyDate;
	}
	public String getLdlSet() {
		return ldlSet;
	}
	public void setLdlSet(String ldlSet) {
		this.ldlSet = ldlSet;
	}
	public String getLdlStarttime1() {
		return ldlStarttime1;
	}
	public void setLdlStarttime1(String ldlStarttime1) {
		this.ldlStarttime1 = ldlStarttime1;
	}
	public String getLdlMark() {
		return ldlMark;
	}
	public void setLdlMark(String ldlMark) {
		this.ldlMark = ldlMark;
	}
	public String getLdlYesno() {
		return ldlYesno;
	}
	public void setLdlYesno(String ldlYesno) {
		this.ldlYesno = ldlYesno;
	}
	public String getLdlGame() {
		return ldlGame;
	}
	public void setLdlGame(String ldlGame) {
		this.ldlGame = ldlGame;
	}
	public String getLdlAddgame() {
		return ldlAddgame;
	}
	public void setLdlAddgame(String ldlAddgame) {
		this.ldlAddgame = ldlAddgame;
	}
	public String getLdlFeature() {
		return ldlFeature;
	}
	public void setLdlFeature(String ldlFeature) {
		this.ldlFeature = ldlFeature;
	}
	public String getLdlInternation() {
		return ldlInternation;
	}
	public void setLdlInternation(String ldlInternation) {
		this.ldlInternation = ldlInternation;
	}
	public String getLdlCountylocation() {
		return ldlCountylocation;
	}
	public void setLdlCountylocation(String ldlCountylocation) {
		this.ldlCountylocation = ldlCountylocation;
	}
	public String getLdlMajorcountries() {
		return ldlMajorcountries;
	}
	public void setLdlMajorcountries(String ldlMajorcountries) {
		this.ldlMajorcountries = ldlMajorcountries;
	}
	public String getLdlDeparturecity() {
		return ldlDeparturecity;
	}
	public void setLdlDeparturecity(String ldlDeparturecity) {
		this.ldlDeparturecity = ldlDeparturecity;
	}
	public String getLdlProductine() {
		return ldlProductine;
	}
	public void setLdlProductine(String ldlProductine) {
		this.ldlProductine = ldlProductine;
	}
	public String getLdlScheduled() {
		return ldlScheduled;
	}
	public void setLdlScheduled(String ldlScheduled) {
		this.ldlScheduled = ldlScheduled;
	}
	public String getZscIsCoopertion() {
		return zscIsCoopertion;
	}
	public void setZscIsCoopertion(String zscIsCoopertion) {
		this.zscIsCoopertion = zscIsCoopertion;
	}
	public List<LineTripBean> getListTripBean() {
		return listTripBean;
	}
	public void setListTripBean(List<LineTripBean> listTripBean) {
		this.listTripBean = listTripBean;
	}
	public List<String> getListNation() {
		return listNation;
	}
	public void setListNation(List<String> listNation) {
		this.listNation = listNation;
	}
	public String getMhtNtype() {
		return mhtNtype;
	}
	public void setMhtNtype(String mhtNtype) {
		this.mhtNtype = mhtNtype;
	}
	public Integer getCountDay() {
		return countDay;
	}
	public void setCountDay(Integer countDay) {
		this.countDay = countDay;
	}
	public Integer getCountDayCompare() {
		return countDayCompare;
	}
	public void setCountDayCompare(Integer countDayCompare) {
		this.countDayCompare = countDayCompare;
	}
	
	
	

}
