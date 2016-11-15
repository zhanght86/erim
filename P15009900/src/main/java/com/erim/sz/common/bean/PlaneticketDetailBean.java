package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: PlaneticketDetailBean 
 * @Description: 机票详细信息
 * @author maoxian
 * @date 2015年10月22日 下午8:50:10
 */
public class PlaneticketDetailBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//企业id
	private Integer cpyId;
	//产品编号
	private String  ptdNo;
	//所属航空公司
	private String  ptdCompany;
	//航班号
	private String  ptdNumber;
	//国内国际 1国内 2国际
	private String  ptdIsInternational;
	//机型
	private String  ptdModel; 
	//出发类别 国内／ 国际
	private String  ptdStartState;
	//出发国家/省
	private String  ptdStartCity;
	//出发时间
	private String  ptdStartTime;
	//起飞航站楼
	private String  ptdStartTerminal;
	//到达城市
	private String  ptdEndCity;
	//到达时间
	private String  ptdEndTime;
	//落地航站楼
	private String  ptdEndTerminal;
	//飞机餐 01有  02无
	private String  ptdCostFood;
	//机场建设费
	private Integer ptdCostMaching;
	//燃油费
	private Integer ptdCostFuel;
	
	private Date 	ptdCreatetime;
	
	private String  ptdCreateuser;
	//上下架 
	private String  ptdIsDelStatus;
	//经济舱座位
	private String ptdClassEconomy;
	//商务舱
	private Integer ptdClassBusiness;
	//头等舱
	private Integer ptdFirstClass;
	//出发国际港澳台
	private String  ptdStartTown;
	//到达国际港澳台
	private String  ptdEndTown;
	// 总时间
	private String  ptdEndStay;
	//落地时间分类
	private String  ptdEndNtype;
	//出发国家
	private String  ptdForeign;
	//到达国家
	private String  ptdEndforeign;
	//出发城市
	private String  ptdForeigncity;
	//到达国家城市
	private String  ptdEndforeigncity;
	//到达类别 国内/国际
	private String  ptdEndState;
	//类别 1 单程-直飞 2单程-中转
	private String  ptdNtype;
	//是否经停
	private String ptdYesno;
	//经停国家
	private String ptdGuojia;
	//经停省
	private String ptdProvince;
	//经停市
	private String  ptdCity;
	//经停国家国际港澳台
	private String  ptdTown;
	//经停国际国家
	private String ptdJingforeign;
	//经停国际城市
	private String ptdJingcity;
	//出发省
	private String ptdStartProvince;
	//到达省
	private String ptdEndProvince;
	//预定方式
	private String ptdScheduled;
	//////////////////////////////////////////////////////////////////////////
	private String timePeriod;//1:0-6点 2:6-12点 3:12-18点 4:18-24点
	
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
	
	/////////////////////////////企业信息end///////////////////////////////////
	
	// 同业价
	private Integer preTradePrice;
	// 时间
	private String	preDate;
	// 数量
	private Integer	preSign;
	//舱位类型
	private String ptdClass;
	
	
	//priceId
			private String preId1;
		    // 产品ID
			private Integer	gdlId1;
			// 产品舱位类型
			private String 	ptdClass1;
			// 日期
			private String	preDate1;
			// 是否出售
			private String	preIsOpen1;
			// 星期
			private String	preWeek1;
			// 机票数量
			private Integer	preSign1;
			// 同业价格
			private Integer preTradePrice1;
			// 零售价格
			private Integer preRetailPrice1;
			// 税费
			private Integer preTallage1;
			// 是否含税
			private String	preIsTallage1;
			// 必选服务
			private Integer	preRequired1;
			// 必选服务说明
			private String	preRequiredShow1;
			// 可选服务
			private Integer	preOptional1;
			// 可选服务说明
			private String	preOptianalShow1;
			// 出票时间-开始
			private String	preIssueStart1;
			// 出票时间-结束
			private String	preIssueEnd1;
			// 创建时间
			private Date	preCreateTime1;
			// 创建用户
			private String	preCreateUser1;
			// 税费+同业
			private Integer	preTrade1;
			// 税费+零售
			private Integer	preRetail1;
			
			
			private String preId2;
			// 产品ID
			private Integer	gdlId2;
			// 产品舱位类型
			private String 	ptdClass2;
			// 日期
			private String	preDate2;
			// 是否出售
			private String	preIsOpen2;
			// 星期
			private String	preWeek2;
			// 机票数量
			private Integer	preSign2;
			// 同业价格
			private Integer preTradePrice2;
			// 零售价格
			private Integer preRetailPrice2;
			// 税费
			private Integer preTallage2;
			// 是否含税
			private String	preIsTallage2;
			// 必选服务
			private Integer	preRequired2;
			// 必选服务说明
			private String	preRequiredShow2;
			// 可选服务
			private Integer	preOptional2;
			// 可选服务说明
			private String	preOptianalShow2;
			// 出票时间-开始
			private String	preIssueStart2;
			// 出票时间-结束
			private String	preIssueEnd2;
			// 创建时间
			private Date	preCreateTime2;
			// 创建用户
			private String	preCreateUser2;
			// 税费+同业
			private Integer	preTrade2;
			// 税费+零售
			private Integer	preRetail2;
			
			
			private String preId3;
			// 产品ID
			private Integer	gdlId3;
			// 产品舱位类型
			private String 	ptdClass3;
			// 日期
			private String	preDate3;
			// 是否出售
			private String	preIsOpen3;
			// 星期
			private String	preWeek3;
			// 机票数量
			private Integer	preSign3;
			// 同业价格
			private Integer preTradePrice3;
			// 零售价格
			private Integer preRetailPrice3;
			// 税费
			private Integer preTallage3;
			// 是否含税
			private String	preIsTallage3;
			// 必选服务
			private Integer	preRequired3;
			// 必选服务说明
			private String	preRequiredShow3;
			// 可选服务
			private Integer	preOptional3;
			// 可选服务说明
			private String	preOptianalShow3;
			// 出票时间-开始
			private String	preIssueStart3;
			// 出票时间-结束
			private String	preIssueEnd3;
			// 创建时间
			private Date	preCreateTime3;
			// 创建用户
			private String	preCreateUser3;
			// 税费+同业
			private Integer	preTrade3;
			// 税费+零售
			private Integer	preRetail3;
	/////////////////////////////////price//////////////////////////////////////////
	
	public Integer getPreSign() {
		return preSign;
	}
	public String getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}
	public String getPreId2() {
		return preId2;
	}
	public void setPreId2(String preId2) {
		this.preId2 = preId2;
	}
	public String getPreId3() {
		return preId3;
	}
	public void setPreId3(String preId3) {
		this.preId3 = preId3;
	}
	public String getPreId1() {
		return preId1;
	}
	public void setPreId1(String preId1) {
		this.preId1 = preId1;
	}
	public Integer getGdlId1() {
		return gdlId1;
	}
	public void setGdlId1(Integer gdlId1) {
		this.gdlId1 = gdlId1;
	}
	public String getPtdClass1() {
		return ptdClass1;
	}
	public void setPtdClass1(String ptdClass1) {
		this.ptdClass1 = ptdClass1;
	}
	public String getPreDate1() {
		return preDate1;
	}
	public void setPreDate1(String preDate1) {
		this.preDate1 = preDate1;
	}
	public String getPreIsOpen1() {
		return preIsOpen1;
	}
	public void setPreIsOpen1(String preIsOpen1) {
		this.preIsOpen1 = preIsOpen1;
	}
	public String getPreWeek1() {
		return preWeek1;
	}
	public void setPreWeek1(String preWeek1) {
		this.preWeek1 = preWeek1;
	}
	public Integer getPreSign1() {
		return preSign1;
	}
	public void setPreSign1(Integer preSign1) {
		this.preSign1 = preSign1;
	}
	public Integer getPreTradePrice1() {
		return preTradePrice1;
	}
	public void setPreTradePrice1(Integer preTradePrice1) {
		this.preTradePrice1 = preTradePrice1;
	}
	public Integer getPreRetailPrice1() {
		return preRetailPrice1;
	}
	public void setPreRetailPrice1(Integer preRetailPrice1) {
		this.preRetailPrice1 = preRetailPrice1;
	}
	public Integer getPreTallage1() {
		return preTallage1;
	}
	public void setPreTallage1(Integer preTallage1) {
		this.preTallage1 = preTallage1;
	}
	public String getPreIsTallage1() {
		return preIsTallage1;
	}
	public void setPreIsTallage1(String preIsTallage1) {
		this.preIsTallage1 = preIsTallage1;
	}
	public Integer getPreRequired1() {
		return preRequired1;
	}
	public void setPreRequired1(Integer preRequired1) {
		this.preRequired1 = preRequired1;
	}
	public String getPreRequiredShow1() {
		return preRequiredShow1;
	}
	public void setPreRequiredShow1(String preRequiredShow1) {
		this.preRequiredShow1 = preRequiredShow1;
	}
	public Integer getPreOptional1() {
		return preOptional1;
	}
	public void setPreOptional1(Integer preOptional1) {
		this.preOptional1 = preOptional1;
	}
	public String getPreOptianalShow1() {
		return preOptianalShow1;
	}
	public void setPreOptianalShow1(String preOptianalShow1) {
		this.preOptianalShow1 = preOptianalShow1;
	}
	public String getPreIssueStart1() {
		return preIssueStart1;
	}
	public void setPreIssueStart1(String preIssueStart1) {
		this.preIssueStart1 = preIssueStart1;
	}
	public String getPreIssueEnd1() {
		return preIssueEnd1;
	}
	public void setPreIssueEnd1(String preIssueEnd1) {
		this.preIssueEnd1 = preIssueEnd1;
	}
	public Date getPreCreateTime1() {
		return preCreateTime1;
	}
	public void setPreCreateTime1(Date preCreateTime1) {
		this.preCreateTime1 = preCreateTime1;
	}
	public String getPreCreateUser1() {
		return preCreateUser1;
	}
	public void setPreCreateUser1(String preCreateUser1) {
		this.preCreateUser1 = preCreateUser1;
	}
	public Integer getPreTrade1() {
		return preTrade1;
	}
	public void setPreTrade1(Integer preTrade1) {
		this.preTrade1 = preTrade1;
	}
	public Integer getPreRetail1() {
		return preRetail1;
	}
	public void setPreRetail1(Integer preRetail1) {
		this.preRetail1 = preRetail1;
	}
	public Integer getGdlId2() {
		return gdlId2;
	}
	public void setGdlId2(Integer gdlId2) {
		this.gdlId2 = gdlId2;
	}
	public String getPtdClass2() {
		return ptdClass2;
	}
	public void setPtdClass2(String ptdClass2) {
		this.ptdClass2 = ptdClass2;
	}
	public String getPreDate2() {
		return preDate2;
	}
	public void setPreDate2(String preDate2) {
		this.preDate2 = preDate2;
	}
	public String getPreIsOpen2() {
		return preIsOpen2;
	}
	public void setPreIsOpen2(String preIsOpen2) {
		this.preIsOpen2 = preIsOpen2;
	}
	public String getPreWeek2() {
		return preWeek2;
	}
	public void setPreWeek2(String preWeek2) {
		this.preWeek2 = preWeek2;
	}
	public Integer getPreSign2() {
		return preSign2;
	}
	public void setPreSign2(Integer preSign2) {
		this.preSign2 = preSign2;
	}
	public Integer getPreTradePrice2() {
		return preTradePrice2;
	}
	public void setPreTradePrice2(Integer preTradePrice2) {
		this.preTradePrice2 = preTradePrice2;
	}
	public Integer getPreRetailPrice2() {
		return preRetailPrice2;
	}
	public void setPreRetailPrice2(Integer preRetailPrice2) {
		this.preRetailPrice2 = preRetailPrice2;
	}
	public Integer getPreTallage2() {
		return preTallage2;
	}
	public void setPreTallage2(Integer preTallage2) {
		this.preTallage2 = preTallage2;
	}
	public String getPreIsTallage2() {
		return preIsTallage2;
	}
	public void setPreIsTallage2(String preIsTallage2) {
		this.preIsTallage2 = preIsTallage2;
	}
	public Integer getPreRequired2() {
		return preRequired2;
	}
	public void setPreRequired2(Integer preRequired2) {
		this.preRequired2 = preRequired2;
	}
	public String getPreRequiredShow2() {
		return preRequiredShow2;
	}
	public void setPreRequiredShow2(String preRequiredShow2) {
		this.preRequiredShow2 = preRequiredShow2;
	}
	public Integer getPreOptional2() {
		return preOptional2;
	}
	public void setPreOptional2(Integer preOptional2) {
		this.preOptional2 = preOptional2;
	}
	public String getPreOptianalShow2() {
		return preOptianalShow2;
	}
	public void setPreOptianalShow2(String preOptianalShow2) {
		this.preOptianalShow2 = preOptianalShow2;
	}
	public String getPreIssueStart2() {
		return preIssueStart2;
	}
	public void setPreIssueStart2(String preIssueStart2) {
		this.preIssueStart2 = preIssueStart2;
	}
	public String getPreIssueEnd2() {
		return preIssueEnd2;
	}
	public void setPreIssueEnd2(String preIssueEnd2) {
		this.preIssueEnd2 = preIssueEnd2;
	}
	public Date getPreCreateTime2() {
		return preCreateTime2;
	}
	public void setPreCreateTime2(Date preCreateTime2) {
		this.preCreateTime2 = preCreateTime2;
	}
	public String getPreCreateUser2() {
		return preCreateUser2;
	}
	public void setPreCreateUser2(String preCreateUser2) {
		this.preCreateUser2 = preCreateUser2;
	}
	public Integer getPreTrade2() {
		return preTrade2;
	}
	public void setPreTrade2(Integer preTrade2) {
		this.preTrade2 = preTrade2;
	}
	public Integer getPreRetail2() {
		return preRetail2;
	}
	public void setPreRetail2(Integer preRetail2) {
		this.preRetail2 = preRetail2;
	}
	public Integer getGdlId3() {
		return gdlId3;
	}
	public void setGdlId3(Integer gdlId3) {
		this.gdlId3 = gdlId3;
	}
	public String getPtdClass3() {
		return ptdClass3;
	}
	public void setPtdClass3(String ptdClass3) {
		this.ptdClass3 = ptdClass3;
	}
	public String getPreDate3() {
		return preDate3;
	}
	public void setPreDate3(String preDate3) {
		this.preDate3 = preDate3;
	}
	public String getPreIsOpen3() {
		return preIsOpen3;
	}
	public void setPreIsOpen3(String preIsOpen3) {
		this.preIsOpen3 = preIsOpen3;
	}
	public String getPreWeek3() {
		return preWeek3;
	}
	public void setPreWeek3(String preWeek3) {
		this.preWeek3 = preWeek3;
	}
	public Integer getPreSign3() {
		return preSign3;
	}
	public void setPreSign3(Integer preSign3) {
		this.preSign3 = preSign3;
	}
	public Integer getPreTradePrice3() {
		return preTradePrice3;
	}
	public void setPreTradePrice3(Integer preTradePrice3) {
		this.preTradePrice3 = preTradePrice3;
	}
	public Integer getPreRetailPrice3() {
		return preRetailPrice3;
	}
	public void setPreRetailPrice3(Integer preRetailPrice3) {
		this.preRetailPrice3 = preRetailPrice3;
	}
	public Integer getPreTallage3() {
		return preTallage3;
	}
	public void setPreTallage3(Integer preTallage3) {
		this.preTallage3 = preTallage3;
	}
	public String getPreIsTallage3() {
		return preIsTallage3;
	}
	public void setPreIsTallage3(String preIsTallage3) {
		this.preIsTallage3 = preIsTallage3;
	}
	public Integer getPreRequired3() {
		return preRequired3;
	}
	public void setPreRequired3(Integer preRequired3) {
		this.preRequired3 = preRequired3;
	}
	public String getPreRequiredShow3() {
		return preRequiredShow3;
	}
	public void setPreRequiredShow3(String preRequiredShow3) {
		this.preRequiredShow3 = preRequiredShow3;
	}
	public Integer getPreOptional3() {
		return preOptional3;
	}
	public void setPreOptional3(Integer preOptional3) {
		this.preOptional3 = preOptional3;
	}
	public String getPreOptianalShow3() {
		return preOptianalShow3;
	}
	public void setPreOptianalShow3(String preOptianalShow3) {
		this.preOptianalShow3 = preOptianalShow3;
	}
	public String getPreIssueStart3() {
		return preIssueStart3;
	}
	public void setPreIssueStart3(String preIssueStart3) {
		this.preIssueStart3 = preIssueStart3;
	}
	public String getPreIssueEnd3() {
		return preIssueEnd3;
	}
	public void setPreIssueEnd3(String preIssueEnd3) {
		this.preIssueEnd3 = preIssueEnd3;
	}
	public Date getPreCreateTime3() {
		return preCreateTime3;
	}
	public void setPreCreateTime3(Date preCreateTime3) {
		this.preCreateTime3 = preCreateTime3;
	}
	public String getPreCreateUser3() {
		return preCreateUser3;
	}
	public void setPreCreateUser3(String preCreateUser3) {
		this.preCreateUser3 = preCreateUser3;
	}
	public Integer getPreTrade3() {
		return preTrade3;
	}
	public void setPreTrade3(Integer preTrade3) {
		this.preTrade3 = preTrade3;
	}
	public Integer getPreRetail3() {
		return preRetail3;
	}
	public void setPreRetail3(Integer preRetail3) {
		this.preRetail3 = preRetail3;
	}
	public void setPreSign(Integer preSign) {
		this.preSign = preSign;
	}
	public Integer getPreTradePrice() {
		return preTradePrice;
	}
	public void setPreTradePrice(Integer preTradePrice) {
		this.preTradePrice = preTradePrice;
	}
	public String getPreDate() {
		return preDate;
	}
	public void setPreDate(String preDate) {
		this.preDate = preDate;
	}
	public String getPtdStartState() {
		return ptdStartState;
	}
	public void setPtdStartState(String ptdStartState) {
		this.ptdStartState = ptdStartState;
	}
	public String getPtdEndState() {
		return ptdEndState;
	}
	public void setPtdEndState(String ptdEndState) {
		this.ptdEndState = ptdEndState;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getPtdNo() {
		return ptdNo;
	}
	public void setPtdNo(String ptdNo) {
		this.ptdNo = ptdNo;
	}
	public String getPtdCompany() {
		return ptdCompany;
	}
	public void setPtdCompany(String ptdCompany) {
		this.ptdCompany = ptdCompany;
	}
	public String getPtdNumber() {
		return ptdNumber;
	}
	public void setPtdNumber(String ptdNumber) {
		this.ptdNumber = ptdNumber;
	}
	public String getPtdIsInternational() {
		return ptdIsInternational;
	}
	public void setPtdIsInternational(String ptdIsInternational) {
		this.ptdIsInternational = ptdIsInternational;
	}
	public String getPtdModel() {
		return ptdModel;
	}
	public void setPtdModel(String ptdModel) {
		this.ptdModel = ptdModel;
	}
	public String getPtdStartCity() {
		return ptdStartCity;
	}
	public void setPtdStartCity(String ptdStartCity) {
		this.ptdStartCity = ptdStartCity;
	}
	public String getPtdStartTime() {
		return ptdStartTime;
	}
	public void setPtdStartTime(String ptdStartTime) {
		this.ptdStartTime = ptdStartTime;
	}
	public String getPtdStartTerminal() {
		return ptdStartTerminal;
	}
	public void setPtdStartTerminal(String ptdStartTerminal) {
		this.ptdStartTerminal = ptdStartTerminal;
	}
	public String getPtdEndCity() {
		return ptdEndCity;
	}
	public void setPtdEndCity(String ptdEndCity) {
		this.ptdEndCity = ptdEndCity;
	}
	public String getPtdEndTime() {
		return ptdEndTime;
	}
	public void setPtdEndTime(String ptdEndTime) {
		this.ptdEndTime = ptdEndTime;
	}
	public String getPtdEndTerminal() {
		return ptdEndTerminal;
	}
	public void setPtdEndTerminal(String ptdEndTerminal) {
		this.ptdEndTerminal = ptdEndTerminal;
	}
	public String getPtdCostFood() {
		return ptdCostFood;
	}
	public void setPtdCostFood(String ptdCostFood) {
		this.ptdCostFood = ptdCostFood;
	}
	public Integer getPtdCostMaching() {
		return ptdCostMaching;
	}
	public void setPtdCostMaching(Integer ptdCostMaching) {
		this.ptdCostMaching = ptdCostMaching;
	}
	public Integer getPtdCostFuel() {
		return ptdCostFuel;
	}
	public void setPtdCostFuel(Integer ptdCostFuel) {
		this.ptdCostFuel = ptdCostFuel;
	}
	public Date getPtdCreatetime() {
		return ptdCreatetime;
	}
	public void setPtdCreatetime(Date ptdCreatetime) {
		this.ptdCreatetime = ptdCreatetime;
	}
	public String getPtdCreateuser() {
		return ptdCreateuser;
	}
	public void setPtdCreateuser(String ptdCreateuser) {
		this.ptdCreateuser = ptdCreateuser;
	}
	public String getPtdIsDelStatus() {
		return ptdIsDelStatus;
	}
	public void setPtdIsDelStatus(String ptdIsDelStatus) {
		this.ptdIsDelStatus = ptdIsDelStatus;
	}
	public Integer getPtdClassBusiness() {
		return ptdClassBusiness;
	}
	public void setPtdClassBusiness(Integer ptdClassBusiness) {
		this.ptdClassBusiness = ptdClassBusiness;
	}
	public String getPtdStartTown() {
		return ptdStartTown;
	}
	public void setPtdStartTown(String ptdStartTown) {
		this.ptdStartTown = ptdStartTown;
	}
	public String getPtdEndTown() {
		return ptdEndTown;
	}
	public void setPtdEndTown(String ptdEndTown) {
		this.ptdEndTown = ptdEndTown;
	}
	public String getPtdEndStay() {
		return ptdEndStay;
	}
	public void setPtdEndStay(String ptdEndStay) {
		this.ptdEndStay = ptdEndStay;
	}
	public String getPtdEndNtype() {
		return ptdEndNtype;
	}
	public void setPtdEndNtype(String ptdEndNtype) {
		this.ptdEndNtype = ptdEndNtype;
	}
	public String getPtdNtype() {
		return ptdNtype;
	}
	public void setPtdNtype(String ptdNtype) {
		this.ptdNtype = ptdNtype;
	}
	public String getPtdClassEconomy() {
		return ptdClassEconomy;
	}
	public void setPtdClassEconomy(String ptdClassEconomy) {
		this.ptdClassEconomy = ptdClassEconomy;
	}
	public String getPtdForeign() {
		return ptdForeign;
	}
	public void setPtdForeign(String ptdForeign) {
		this.ptdForeign = ptdForeign;
	}
	public String getPtdForeigncity() {
		return ptdForeigncity;
	}
	public void setPtdForeigncity(String ptdForeigncity) {
		this.ptdForeigncity = ptdForeigncity;
	}
	public String getPtdEndforeign() {
		return ptdEndforeign;
	}
	public void setPtdEndforeign(String ptdEndforeign) {
		this.ptdEndforeign = ptdEndforeign;
	}
	public String getPtdEndforeigncity() {
		return ptdEndforeigncity;
	}
	public void setPtdEndforeigncity(String ptdEndforeigncity) {
		this.ptdEndforeigncity = ptdEndforeigncity;
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
	public String getPtdYesno() {
		return ptdYesno;
	}
	public void setPtdYesno(String ptdYesno) {
		this.ptdYesno = ptdYesno;
	}
	public String getPtdStartProvince() {
		return ptdStartProvince;
	}
	public void setPtdStartProvince(String ptdStartProvince) {
		this.ptdStartProvince = ptdStartProvince;
	}
	public String getPtdEndProvince() {
		return ptdEndProvince;
	}
	public void setPtdEndProvince(String ptdEndProvince) {
		this.ptdEndProvince = ptdEndProvince;
	}
	public String getPtdProvince() {
		return ptdProvince;
	}
	public void setPtdProvince(String ptdProvince) {
		this.ptdProvince = ptdProvince;
	}
	public String getPtdCity() {
		return ptdCity;
	}
	public void setPtdCity(String ptdCity) {
		this.ptdCity = ptdCity;
	}
	public String getPtdTown() {
		return ptdTown;
	}
	public void setPtdTown(String ptdTown) {
		this.ptdTown = ptdTown;
	}
	public String getPtdGuojia() {
		return ptdGuojia;
	}
	public void setPtdGuojia(String ptdGuojia) {
		this.ptdGuojia = ptdGuojia;
	}
	public String getPtdJingforeign() {
		return ptdJingforeign;
	}
	public void setPtdJingforeign(String ptdJingforeign) {
		this.ptdJingforeign = ptdJingforeign;
	}
	public String getPtdJingcity() {
		return ptdJingcity;
	}
	public void setPtdJingcity(String ptdJingcity) {
		this.ptdJingcity = ptdJingcity;
	}
	public Integer getPtdFirstClass() {
		return ptdFirstClass;
	}
	public void setPtdFirstClass(Integer ptdFirstClass) {
		this.ptdFirstClass = ptdFirstClass;
	}
	public String getPtdScheduled() {
		return ptdScheduled;
	}
	public void setPtdScheduled(String ptdScheduled) {
		this.ptdScheduled = ptdScheduled;
	}
	public String getPtdClass() {
		return ptdClass;
	}
	public void setPtdClass(String ptdClass) {
		this.ptdClass = ptdClass;
	}
	
	
}