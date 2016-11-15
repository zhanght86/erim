package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.List;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: GroundDetailBean
 * @Description: 当地游
 * @author 陈鹏
 * @date 2015年7月11日 下午1:19:24
 */
public class GroundDetailBean extends BaseBean implements Serializable {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//产品编号(手动输入)
	private String 	gddCodeone;
	//产品编码(自动生成)
	private String 	gddCode;
	//线路名称
	private String 	gddName;
	
	// 产品分类
	private String	gddProductType;
	//始发城市、国内/国际港澳台
	private String 	gddInternation;
	//始发城市、港澳台国际
	private String 	gddCountylocation;
	//国家
	private String 	gddMajorcountries;
	//国外城市
	private String 	gddDeparturecity;
	private String 	gddDeparturecityVo;
	//出发省
	private String 	gddProvice;
	//出发市
	private String 	gddCity;
	//出发县
	private String 	gddCounty;
	//主要景点
	private String 	gddCharacteristic;
	//线路玩法
	private String 	gddProductine;
	//线路类型
	private String 	gddLocalwide;
	//同城标识
	private String 	gddIsSurrounding;
	//产品形态
	private String 	gddProduct;
	//是否属于学生活动
	private String 	gddYesno;
	//学生活动
	private String 	gddGame;
	//学生活动+文本框
	private String 	gddAddgame;
	//产品主题
	private String 	gddStandards;
	//产品主题其他
	private String 	gddAddstandard;
	//产品主题+文本框
	private String 	gddAddstandards;
	//产品标准
	private String 	gddThemeone;
	//集合地点
	private String 	gddSet;
	//集合时间
	private String 	gddStarttime;
	//集合标志
	private String 	gddMark;
	//预定方式
	private String 	gddScheduled;
	
	/**
	 * 二次录入字段（行程管理按钮下面的）
	 */
	//费用包含
	private String 	gddCostContains;
	//费用不含
	private String 	gddNomoney;
	//推荐自费
	private String 	gddExpense;
	//退改规则
	private String 	gddRule;
	//预订限制
	private String 	gddIsbookinglimit;
	//出行须知
	private String 	gddTravelinformation;
	//旅行社违约
	private String 	gddDefault;
	//补充说明
	private String 	gddSupplement;
	//特别提醒
	private String 	gddRemind;
	/**
	 * 二次录入字段结束
	 */
	
	// 是否上架 1是 0否
	private String 	gddIsDelStatus;
	// 创建时间
	private String 	gddCreatetime;
	// 创建用户
	private String 	gddCreateuser;
	// 企业ID
	private Integer cpyId;
	// 是否审核通过 1 是 0 否
	private String 	gddIsThrough;
	// 审核时间
	private String 	gddThroughTime;
	// 审核人
	private String 	gddThroughUser;
	// 图片
	private String 	gddImg1;
	
	/**
	 * 行程管理
	 */
	// 产品特色
	private String 	gddFeature;
	// 产品推荐理由
	private String 	gddReasons;
	// 行程特色
	private String 	gddProject;
	
	/**
	 * 暂未使用字段
	 */
	//国外
	private String gddForeign;
	//国外城市
	private String gddForeigncity;
	//消费者违约
	private String gddConsumersdefault;
	//目的地
	private String gddDestination;
	//编码
	private String gddisnum;
	//是否删除成功
	private String gdddelete;
	//联系人
	private String gddispeople;
	//评分
	private int 	gddisscore;
	//最晚班期
	private String gddIslatertime;
	//费用包含
	private String gddIsmoney;
	//产品标准定位
	private String gddNorm;
	//产品型形态
	private String gddForm;
	//导游旗品牌
	private String gddGuideBrand;
	//自费说明
	private String gddCostExplain;
	//行程主题
	private String gddTheme;
	//上午详细行程
	private String gddAmTrip;
	//中餐
	private String gddNoonFood;
	//下午详细行程
	private String gddPmTrip;
	//晚餐
	private String gddDinner;
	//入住
	private String gddStay;
	//重要提示
	private String gddPrompt;
	//线路涉及景点
	private String gddSight;
	//涉及的交通工具
    private String gddTrafficTools;	
	//产品说明
	private String gddIsshow;
	//线路品牌
	private String gddIspinpai;
	
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
	//公司logo
	private String  cpyImg;
	//公司地址
	private String  cpyAddress;
	
	 //计调人名
	private String  cbsOperator;
	// 计调人电话
	private String  cbsOperatorPhone;
	// 计调qq
	private String  cbsOperatorQq;

	/////////////////////////////企业信息end///////////////////////////////////
	
	// 同业价
	private Integer gpeTradeAdult;
	// 日期
	private String 	gpeDate;
	// 零售价
	private Integer gpeRetailAdult;
	// 量
	private Integer gpeSign;
	//行程天数
	private Integer TripDays;
	
	
	//////////////////////////////拓展字段/////////////////////////////////////////
	
	//数组 获取所有省
	private String[] astrprovince;
	private Integer countDay;
	private Integer countDayCompare;
	
	
	//获取子行程
	private List<GroundTriplBean> listGroundTripBean;
	//////////////////////////////拓展字段/////////////////////////////////////////
	
	
	public Integer getGpeSign() {
		return gpeSign;
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
	public String getGddProductType() {
		return gddProductType;
	}
	public void setGddProductType(String gddProductType) {
		this.gddProductType = gddProductType;
	}
	public void setGpeSign(Integer gpeSign) {
		this.gpeSign = gpeSign;
	}
	public Integer getGpeRetailAdult() {
		return gpeRetailAdult;
	}
	public void setGpeRetailAdult(Integer gpeRetailAdult) {
		this.gpeRetailAdult = gpeRetailAdult;
	}
	public Integer getGpeTradeAdult() {
		return gpeTradeAdult;
	}
	public void setGpeTradeAdult(Integer gpeTradeAdult) {
		this.gpeTradeAdult = gpeTradeAdult;
	}
	public String getGpeDate() {
		return gpeDate;
	}
	public void setGpeDate(String gpeDate) {
		this.gpeDate = gpeDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGddCode() {
		return gddCode;
	}
	public void setGddCode(String gddCode) {
		this.gddCode = gddCode;
	}
	public String getGddName() {
		return gddName;
	}
	public void setGddName(String gddName) {
		this.gddName = gddName;
	}
	public String getGddInternation() {
		return gddInternation;
	}
	public void setGddInternation(String gddInternation) {
		this.gddInternation = gddInternation;
	}
	public String getGddCountylocation() {
		return gddCountylocation;
	}
	public void setGddCountylocation(String gddCountylocation) {
		this.gddCountylocation = gddCountylocation;
	}
	public String getGddForeign() {
		return gddForeign;
	}
	public void setGddForeign(String gddForeign) {
		this.gddForeign = gddForeign;
	}
	public String getGddForeigncity() {
		return gddForeigncity;
	}
	public void setGddForeigncity(String gddForeigncity) {
		this.gddForeigncity = gddForeigncity;
	}
	public String getGddProvice() {
		return gddProvice;
	}
	public void setGddProvice(String gddProvice) {
		this.gddProvice = gddProvice;
	}
	public String getGddCity() {
		return gddCity;
	}
	public void setGddCity(String gddCity) {
		this.gddCity = gddCity;
	}
	public String getGddCounty() {
		return gddCounty;
	}
	public void setGddCounty(String gddCounty) {
		this.gddCounty = gddCounty;
	}
	public String getGddLocalwide() {
		return gddLocalwide;
	}
	public void setGddLocalwide(String gddLocalwide) {
		this.gddLocalwide = gddLocalwide;
	}
	public String getGddCharacteristic() {
		return gddCharacteristic;
	}
	public void setGddCharacteristic(String gddCharacteristic) {
		this.gddCharacteristic = gddCharacteristic;
	}
	public String getGddProduct() {
		return gddProduct;
	}
	public void setGddProduct(String gddProduct) {
		this.gddProduct = gddProduct;
	}
	public String getGddStandards() {
		return gddStandards;
	}
	public void setGddStandards(String gddStandards) {
		this.gddStandards = gddStandards;
	}
	public String getGddThemeone() {
		return gddThemeone;
	}
	public void setGddThemeone(String gddThemeone) {
		this.gddThemeone = gddThemeone;
	}
	public String getGddSet() {
		return gddSet;
	}
	public void setGddSet(String gddSet) {
		this.gddSet = gddSet;
	}
	public String getGddStarttime() {
		return gddStarttime;
	}
	public void setGddStarttime(String gddStarttime) {
		this.gddStarttime = gddStarttime;
	}
	public String getGddMark() {
		return gddMark;
	}
	public void setGddMark(String gddMark) {
		this.gddMark = gddMark;
	}
	public String getGddCostContains() {
		return gddCostContains;
	}
	public void setGddCostContains(String gddCostContains) {
		this.gddCostContains = gddCostContains;
	}
	public String getGddNomoney() {
		return gddNomoney;
	}
	public void setGddNomoney(String gddNomoney) {
		this.gddNomoney = gddNomoney;
	}
	public String getGddExpense() {
		return gddExpense;
	}
	public void setGddExpense(String gddExpense) {
		this.gddExpense = gddExpense;
	}
	public String getGddIsbookinglimit() {
		return gddIsbookinglimit;
	}
	public void setGddIsbookinglimit(String gddIsbookinglimit) {
		this.gddIsbookinglimit = gddIsbookinglimit;
	}
	public String getGddTravelinformation() {
		return gddTravelinformation;
	}
	public void setGddTravelinformation(String gddTravelinformation) {
		this.gddTravelinformation = gddTravelinformation;
	}
	public String getGddDefault() {
		return gddDefault;
	}
	public void setGddDefault(String gddDefault) {
		this.gddDefault = gddDefault;
	}
	public String getGddConsumersdefault() {
		return gddConsumersdefault;
	}
	public void setGddConsumersdefault(String gddConsumersdefault) {
		this.gddConsumersdefault = gddConsumersdefault;
	}
	public String getGddSupplement() {
		return gddSupplement;
	}
	public void setGddSupplement(String gddSupplement) {
		this.gddSupplement = gddSupplement;
	}
	public String getGddRemind() {
		return gddRemind;
	}
	public void setGddRemind(String gddRemind) {
		this.gddRemind = gddRemind;
	}
	public String getGddIsDelStatus() {
		return gddIsDelStatus;
	}
	public void setGddIsDelStatus(String gddIsDelStatus) {
		this.gddIsDelStatus = gddIsDelStatus;
	}
	public String getGddCreatetime() {
		return gddCreatetime;
	}
	public void setGddCreatetime(String gddCreatetime) {
		this.gddCreatetime = gddCreatetime;
	}
	public String getGddCreateuser() {
		return gddCreateuser;
	}
	public void setGddCreateuser(String gddCreateuser) {
		this.gddCreateuser = gddCreateuser;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getGddIsSurrounding() {
		return gddIsSurrounding;
	}
	public void setGddIsSurrounding(String gddIsSurrounding) {
		this.gddIsSurrounding = gddIsSurrounding;
	}
	public String getGddDestination() {
		return gddDestination;
	}
	public void setGddDestination(String gddDestination) {
		this.gddDestination = gddDestination;
	}
	public String getGddImg1() {
		return gddImg1;
	}
	public void setGddImg1(String gddImg1) {
		this.gddImg1 = gddImg1;
	}
	public String getGddIsThrough() {
		return gddIsThrough;
	}
	public void setGddIsThrough(String gddIsThrough) {
		this.gddIsThrough = gddIsThrough;
	}
	public String getGddThroughTime() {
		return gddThroughTime;
	}
	public void setGddThroughTime(String gddThroughTime) {
		this.gddThroughTime = gddThroughTime;
	}
	public String getGddThroughUser() {
		return gddThroughUser;
	}
	public void setGddThroughUser(String gddThroughUser) {
		this.gddThroughUser = gddThroughUser;
	}
	public String getGddisnum() {
		return gddisnum;
	}
	public void setGddisnum(String gddisnum) {
		this.gddisnum = gddisnum;
	}
	public String getGdddelete() {
		return gdddelete;
	}
	public void setGdddelete(String gdddelete) {
		this.gdddelete = gdddelete;
	}
	public String getGddispeople() {
		return gddispeople;
	}
	public void setGddispeople(String gddispeople) {
		this.gddispeople = gddispeople;
	}
	public int getGddisscore() {
		return gddisscore;
	}
	public void setGddisscore(int gddisscore) {
		this.gddisscore = gddisscore;
	}
	public String getGddIslatertime() {
		return gddIslatertime;
	}
	public void setGddIslatertime(String gddIslatertime) {
		this.gddIslatertime = gddIslatertime;
	}
	public String getGddIsmoney() {
		return gddIsmoney;
	}
	public void setGddIsmoney(String gddIsmoney) {
		this.gddIsmoney = gddIsmoney;
	}
	public String getGddNorm() {
		return gddNorm;
	}
	public void setGddNorm(String gddNorm) {
		this.gddNorm = gddNorm;
	}
	public String getGddForm() {
		return gddForm;
	}
	public void setGddForm(String gddForm) {
		this.gddForm = gddForm;
	}
	public String getGddReasons() {
		return gddReasons;
	}
	public void setGddReasons(String gddReasons) {
		this.gddReasons = gddReasons;
	}
	public String getGddGuideBrand() {
		return gddGuideBrand;
	}
	public void setGddGuideBrand(String gddGuideBrand) {
		this.gddGuideBrand = gddGuideBrand;
	}
	public String getGddCostExplain() {
		return gddCostExplain;
	}
	public void setGddCostExplain(String gddCostExplain) {
		this.gddCostExplain = gddCostExplain;
	}
	public String getGddProject() {
		return gddProject;
	}
	public void setGddProject(String gddProject) {
		this.gddProject = gddProject;
	}
	public String getGddTheme() {
		return gddTheme;
	}
	public void setGddTheme(String gddTheme) {
		this.gddTheme = gddTheme;
	}
	public String getGddAmTrip() {
		return gddAmTrip;
	}
	public void setGddAmTrip(String gddAmTrip) {
		this.gddAmTrip = gddAmTrip;
	}
	public String getGddNoonFood() {
		return gddNoonFood;
	}
	public void setGddNoonFood(String gddNoonFood) {
		this.gddNoonFood = gddNoonFood;
	}
	public String getGddPmTrip() {
		return gddPmTrip;
	}
	public void setGddPmTrip(String gddPmTrip) {
		this.gddPmTrip = gddPmTrip;
	}
	public String getGddDinner() {
		return gddDinner;
	}
	public void setGddDinner(String gddDinner) {
		this.gddDinner = gddDinner;
	}
	public String getGddStay() {
		return gddStay;
	}
	public void setGddStay(String gddStay) {
		this.gddStay = gddStay;
	}
	public String getGddPrompt() {
		return gddPrompt;
	}
	public void setGddPrompt(String gddPrompt) {
		this.gddPrompt = gddPrompt;
	}
	public String getGddSight() {
		return gddSight;
	}
	public void setGddSight(String gddSight) {
		this.gddSight = gddSight;
	}
	public String getGddTrafficTools() {
		return gddTrafficTools;
	}
	public void setGddTrafficTools(String gddTrafficTools) {
		this.gddTrafficTools = gddTrafficTools;
	}
	public String getGddIsshow() {
		return gddIsshow;
	}
	public void setGddIsshow(String gddIsshow) {
		this.gddIsshow = gddIsshow;
	}
	public String getGddIspinpai() {
		return gddIspinpai;
	}
	public void setGddIspinpai(String gddIspinpai) {
		this.gddIspinpai = gddIspinpai;
	}
	public String getGddProductine() {
		return gddProductine;
	}
	public void setGddProductine(String gddProductine) {
		this.gddProductine = gddProductine;
	}
	public String getGddMajorcountries() {
		return gddMajorcountries;
	}
	public void setGddMajorcountries(String gddMajorcountries) {
		this.gddMajorcountries = gddMajorcountries;
	}
	public String getGddDeparturecity() {
		return gddDeparturecity;
	}
	public void setGddDeparturecity(String gddDeparturecity) {
		this.gddDeparturecity = gddDeparturecity;
	}
	public String getGddCodeone() {
		return gddCodeone;
	}
	public void setGddCodeone(String gddCodeone) {
		this.gddCodeone = gddCodeone;
	}
	public String getGddRule() {
		return gddRule;
	}
	public void setGddRule(String gddRule) {
		this.gddRule = gddRule;
	}
	public String getGddYesno() {
		return gddYesno;
	}
	public void setGddYesno(String gddYesno) {
		this.gddYesno = gddYesno;
	}
	public String getGddGame() {
		return gddGame;
	}
	public void setGddGame(String gddGame) {
		this.gddGame = gddGame;
	}
	public String getGddAddgame() {
		return gddAddgame;
	}
	public void setGddAddgame(String gddAddgame) {
		this.gddAddgame = gddAddgame;
	}
	public String getGddAddstandards() {
		return gddAddstandards;
	}
	public void setGddAddstandards(String gddAddstandards) {
		this.gddAddstandards = gddAddstandards;
	}
	public String getGddFeature() {
		return gddFeature;
	}
	public void setGddFeature(String gddFeature) {
		this.gddFeature = gddFeature;
	}
	public String getGddAddstandard() {
		return gddAddstandard;
	}
	public void setGddAddstandard(String gddAddstandard) {
		this.gddAddstandard = gddAddstandard;
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
	public String getGddScheduled() {
		return gddScheduled;
	}
	public void setGddScheduled(String gddScheduled) {
		this.gddScheduled = gddScheduled;
	}
	public String[] getAstrprovince() {
		return astrprovince;
	}
	public void setAstrprovince(String[] astrprovince) {
		this.astrprovince = astrprovince;
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
	public Integer getTripDays() {
		return TripDays;
	}
	public void setTripDays(Integer tripDays) {
		TripDays = tripDays;
	}
	public String getCbsOperatorQq() {
		return cbsOperatorQq;
	}
	public void setCbsOperatorQq(String cbsOperatorQq) {
		this.cbsOperatorQq = cbsOperatorQq;
	}
	public List<GroundTriplBean> getListGroundTripBean() {
		return listGroundTripBean;
	}
	public void setListGroundTripBean(List<GroundTriplBean> listGroundTripBean) {
		this.listGroundTripBean = listGroundTripBean;
	}
	public String getGddDeparturecityVo() {
		return gddDeparturecityVo;
	}
	public void setGddDeparturecityVo(String gddDeparturecityVo) {
		this.gddDeparturecityVo = gddDeparturecityVo;
	}
	
	
	
}
