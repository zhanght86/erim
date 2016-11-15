package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;
/**
 * @ClassName: VCompanyDetailBean 
 * @Description: 企业相关
 * @author maoxian
 * @date 2015年12月6日 下午11:25:39
 */
public class VCompanyDetailBean extends BaseBean  implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	/////////////////////////////////// 自定义字段 /////////////////////////////////////////////////
	
	//是否合作  null未选择合作  0 为合作  1已合作
	private String  zscIsCoopertion;
	//合作商form cpyid
	private Integer zscFromCpyid;
	//组团社form cpyid
	private Integer zscSellCpyid;
	//上传产品数量
	private Integer intLineNum;
	//供应商合作
	private Integer isLineCompany;
	//lieid
	private Integer linecid;
	
	//直营县
	private String  zyCountry;
	//直营市
	private String  zyCity;
	//直营省
	private String  zyProvince;
	
	//数组
	private String[] astrprovince;
	//港澳台
	private String[] astrInterna;
	//国家
	private String[] astrState;
	
	/////////////////////////////////// 自定义字段 /////////////////////////////////////////////////
	
	
	private Integer id;
	//企业编码
	private String  cpyCode;
	//公司名称
	private String  cpyName;
	//佣金串
	private String  yjUserCode;
	//公司电话
	private String  cpyTelephone;
	//传真
	private String  cpyFax;
	//邮箱
	private String  cpyEmail;
	//省
	private String  cpyProvince;
	
	private String  cpyProvinceName;
	//市
	private String  cpyCity;
	 
	private String  cpyCityName;
	//县
	private String  cpyCounty;
	
	private String  cpyCountyName;
	//详细地址
	private String  cpyAddress;
	//性质
	private String  cpyNature;
	//经度
	private String  cpyX;
	//纬度
	private String  cpyY;
	//许可证
	private String  cpyImgPermit1;
	//许可证
	private String  cpyImgPermit2;
	//许可证
	private String  cpyImgPermit3;
	//专属客服ID
	private Integer cpyCustomId;
	//创建时间
	private Date    cpyCreatedate;
	//创建IP
	private String  cpyCreateip;
	//角色
	private String  cpyRoe;
	//审核状态
	private String  cpyNtype;
	//是否审核通过 01否 02 是
	private String  cpyIsThrough;
	//公司品牌
	private String  cpyBrand;
	//负责人
	private String  cpyIsPeople;
	//负责人电话
	private Integer cpyIsPhone;
	//操作人
	private String  cpyIsOperation;
	//操作人电话
	private Integer cpyIsOperationphone;
	//企业qq
	private Integer cpyIsQq;
	//是否国内
	private String  cpyIsInland;
	//港澳台
	private String  cpyExternal;
	//外国
	private String  cpyForeign;
	//外国城市
	private String  cpyForeignCity;
	//公司LOGO
	private String  cpyImg;
	
	private Integer cbsId;
	//业务范围01组团02专线03地接04直营
	private String  cbsService;
	/**
	 * 组团社相关字段
	 */
	// 公司性质
	private String	cbsCpyType;
	// 可服务区域-是否国际
	private String	cbsInland;
	// 可服务区域-省
	private String	cbsProvince;
	// 可服务区域-市
	private String	cbsCity;
	// 可服务区域-县
	private String	cbsCounty;
	// 可服务区域-港澳台国际
	private String	cbsIsInterna;
	// 可服务区域-国家
	private String	cbsState;
	
	/*
	 * 专线业务方向
	 */ 
	// 业务方向 02国内01国际
	private String	cbsSerInland;
	// 国内业务方向
	private String	cbsServiceInside;
	// 国内其他业务方向
	private String	cbsServiceAdd;
	// 港澳台
	private String	cbsSerInterna;
	// 国际业务方向
	private String	cbsServiceOuter;
	// 国际其他业务方向
	private String	cbsServiceRest;
	// 驻某省专线
	private String	cbsSerProvince;
	// 驻某市专线
	private String	cbsSerCity;
	// 驻某县专线
	private String	cbsSerCounty;
	
	/*
	 * 地接涉及区域
	 */
	// 地接涉及区域 02国内01国际
	private String	cbsNurInland;
	// 港澳台
	private String	cbsNurInterna;
	// 国际区域
	private String	cbsNurState;
	// 国际其他区域
	private String	cbsNurRest;
	
	
	//可服务地区02国内01国际
	private String cbsSrlInland;
	//港澳台
	private String cbsSrlInterna;
	// 国际区域
	private String	cbsSrlDir;
	// 国际其他区域
	private String	cbsSrlRest;
	// 现办公地址
	private String	cbsCurrAddress;
	// 地接范围
	// 省1
	private String 	cbsRanProvince1;
	// 省2
	private String 	cbsRanProvince2;
	// 省3
	private String 	cbsRanProvince3;
	// 省4
	private String 	cbsRanProvince4;
	// 省5
	private String 	cbsRanProvince5;
	// 市1
	private String	cbsRanCity1;
	// 市2
	private String	cbsRanCity2;
	// 市3
	private String	cbsRanCity3;
	// 市4
	private String	cbsRanCity4;
	// 市5
	private String	cbsRanCity5;
	// 县1
	private String	cbsRanCounty1;
	// 县2
	private String	cbsRanCounty2;
	// 县3
	private String	cbsRanCounty3;
	// 县4
	private String	cbsRanCounty4;
	// 县5
	private String	cbsRanCounty5;
	// 港澳台国际
	private String	cbsRanInterna;
	// 国家1
	private String	cbsRanState1;
	// 国家2
	private String	cbsRanState2;
	// 国家3
	private String	cbsRanState3;
	// 国家4
	private String	cbsRanState4;
	// 国家5
	private String	cbsRanState5;
	//经营产品类别
	private String cbsProductType;
	//产品名称
	private String cbsProductName;
	//操作人
	private String cbsOperator;
	//操作人Q
	private String cbsOperatorQq;
	//负责人证明
	private String cbsProve;
	//公司账户名称
	private String cbsAccountName;
	//账户
	private String cbsAccount;
	//开户行
	private String cbsOpenAccount;
	//操作人电话
	private String cbsOperatorPhone;
	//营业执照扫描件
	private String cbsLicense;
	//经营许可证扫描件
	private String cbsPermission;
	// 省
	private String	cbsProProvince;
	// 市
	private String	cbsProCity;
	// 县
	private String	cbsProCounty;
	
	private Integer ccpId;
	//联系人名称
	private String ccpName;
	//联系方式
	private String ccpTelephone;
	//邮箱
	private String ccpEmail;
	//QQ
	private String ccpQq;
	//身份证号
	private String ccpCard;
	//身份证正面
	private String ccpImgCard1;
	//身份证背面
	private String ccpImgCard2;
	//创建时间
	private Date ccpCreatetime;
	
	
	public String getZyCountry() {
		return zyCountry;
	}
	public void setZyCountry(String zyCountry) {
		this.zyCountry = zyCountry;
	}
	public String getZyCity() {
		return zyCity;
	}
	public void setZyCity(String zyCity) {
		this.zyCity = zyCity;
	}
	public String getZyProvince() {
		return zyProvince;
	}
	public void setZyProvince(String zyProvince) {
		this.zyProvince = zyProvince;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpyCode() {
		return cpyCode;
	}
	public void setCpyCode(String cpyCode) {
		this.cpyCode = cpyCode;
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
	public String getCpyFax() {
		return cpyFax;
	}
	public void setCpyFax(String cpyFax) {
		this.cpyFax = cpyFax;
	}
	public String getCpyEmail() {
		return cpyEmail;
	}
	public void setCpyEmail(String cpyEmail) {
		this.cpyEmail = cpyEmail;
	}
	public String getCpyProvince() {
		return cpyProvince;
	}
	public void setCpyProvince(String cpyProvince) {
		this.cpyProvince = cpyProvince;
	}
	public String getCpyProvinceName() {
		return cpyProvinceName;
	}
	public void setCpyProvinceName(String cpyProvinceName) {
		this.cpyProvinceName = cpyProvinceName;
	}
	public String getCpyCity() {
		return cpyCity;
	}
	public void setCpyCity(String cpyCity) {
		this.cpyCity = cpyCity;
	}
	public String getCpyCityName() {
		return cpyCityName;
	}
	public void setCpyCityName(String cpyCityName) {
		this.cpyCityName = cpyCityName;
	}
	public String getCpyCounty() {
		return cpyCounty;
	}
	public void setCpyCounty(String cpyCounty) {
		this.cpyCounty = cpyCounty;
	}
	public String getCpyCountyName() {
		return cpyCountyName;
	}
	public void setCpyCountyName(String cpyCountyName) {
		this.cpyCountyName = cpyCountyName;
	}
	public String getCpyAddress() {
		return cpyAddress;
	}
	public void setCpyAddress(String cpyAddress) {
		this.cpyAddress = cpyAddress;
	}
	public String getCpyNature() {
		return cpyNature;
	}
	public void setCpyNature(String cpyNature) {
		this.cpyNature = cpyNature;
	}
	public String getCpyX() {
		return cpyX;
	}
	public void setCpyX(String cpyX) {
		this.cpyX = cpyX;
	}
	public String getCpyY() {
		return cpyY;
	}
	public void setCpyY(String cpyY) {
		this.cpyY = cpyY;
	}
	public String getCpyImgPermit1() {
		return cpyImgPermit1;
	}
	public void setCpyImgPermit1(String cpyImgPermit1) {
		this.cpyImgPermit1 = cpyImgPermit1;
	}
	public String getCpyImgPermit2() {
		return cpyImgPermit2;
	}
	public void setCpyImgPermit2(String cpyImgPermit2) {
		this.cpyImgPermit2 = cpyImgPermit2;
	}
	public String getCpyImgPermit3() {
		return cpyImgPermit3;
	}
	public void setCpyImgPermit3(String cpyImgPermit3) {
		this.cpyImgPermit3 = cpyImgPermit3;
	}
	public Integer getCpyCustomId() {
		return cpyCustomId;
	}
	public void setCpyCustomId(Integer cpyCustomId) {
		this.cpyCustomId = cpyCustomId;
	}
	public Date getCpyCreatedate() {
		return cpyCreatedate;
	}
	public void setCpyCreatedate(Date cpyCreatedate) {
		this.cpyCreatedate = cpyCreatedate;
	}
	public String getCpyCreateip() {
		return cpyCreateip;
	}
	public void setCpyCreateip(String cpyCreateip) {
		this.cpyCreateip = cpyCreateip;
	}
	public String getCpyRoe() {
		return cpyRoe;
	}
	public void setCpyRoe(String cpyRoe) {
		this.cpyRoe = cpyRoe;
	}
	public String getCpyNtype() {
		return cpyNtype;
	}
	public void setCpyNtype(String cpyNtype) {
		this.cpyNtype = cpyNtype;
	}
	public String getCpyIsThrough() {
		return cpyIsThrough;
	}
	public void setCpyIsThrough(String cpyIsThrough) {
		this.cpyIsThrough = cpyIsThrough;
	}
	public String getCpyBrand() {
		return cpyBrand;
	}
	public void setCpyBrand(String cpyBrand) {
		this.cpyBrand = cpyBrand;
	}
	public String getCpyIsPeople() {
		return cpyIsPeople;
	}
	public void setCpyIsPeople(String cpyIsPeople) {
		this.cpyIsPeople = cpyIsPeople;
	}
	public Integer getCpyIsPhone() {
		return cpyIsPhone;
	}
	public void setCpyIsPhone(Integer cpyIsPhone) {
		this.cpyIsPhone = cpyIsPhone;
	}
	public String getCpyIsOperation() {
		return cpyIsOperation;
	}
	public void setCpyIsOperation(String cpyIsOperation) {
		this.cpyIsOperation = cpyIsOperation;
	}
	public Integer getCpyIsOperationphone() {
		return cpyIsOperationphone;
	}
	public void setCpyIsOperationphone(Integer cpyIsOperationphone) {
		this.cpyIsOperationphone = cpyIsOperationphone;
	}
	public Integer getCpyIsQq() {
		return cpyIsQq;
	}
	public void setCpyIsQq(Integer cpyIsQq) {
		this.cpyIsQq = cpyIsQq;
	}
	public String getCpyIsInland() {
		return cpyIsInland;
	}
	public void setCpyIsInland(String cpyIsInland) {
		this.cpyIsInland = cpyIsInland;
	}
	public String getCpyExternal() {
		return cpyExternal;
	}
	public void setCpyExternal(String cpyExternal) {
		this.cpyExternal = cpyExternal;
	}
	public String getCpyForeign() {
		return cpyForeign;
	}
	public void setCpyForeign(String cpyForeign) {
		this.cpyForeign = cpyForeign;
	}
	public String getCpyForeignCity() {
		return cpyForeignCity;
	}
	public void setCpyForeignCity(String cpyForeignCity) {
		this.cpyForeignCity = cpyForeignCity;
	}
	public String getCpyImg() {
		return cpyImg;
	}
	public void setCpyImg(String cpyImg) {
		this.cpyImg = cpyImg;
	}
	public Integer getCbsId() {
		return cbsId;
	}
	public void setCbsId(Integer cbsId) {
		this.cbsId = cbsId;
	}
	public String getCbsService() {
		return cbsService;
	}
	public void setCbsService(String cbsService) {
		this.cbsService = cbsService;
	}
	public String getCbsCpyType() {
		return cbsCpyType;
	}
	public void setCbsCpyType(String cbsCpyType) {
		this.cbsCpyType = cbsCpyType;
	}
	public String getCbsInland() {
		return cbsInland;
	}
	public void setCbsInland(String cbsInland) {
		this.cbsInland = cbsInland;
	}
	public String getCbsProvince() {
		return cbsProvince;
	}
	public void setCbsProvince(String cbsProvince) {
		this.cbsProvince = cbsProvince;
	}
	public String getCbsCity() {
		return cbsCity;
	}
	public void setCbsCity(String cbsCity) {
		this.cbsCity = cbsCity;
	}
	public String getCbsCounty() {
		return cbsCounty;
	}
	public void setCbsCounty(String cbsCounty) {
		this.cbsCounty = cbsCounty;
	}
	public String getCbsIsInterna() {
		return cbsIsInterna;
	}
	public void setCbsIsInterna(String cbsIsInterna) {
		this.cbsIsInterna = cbsIsInterna;
	}
	public String getCbsState() {
		return cbsState;
	}
	public void setCbsState(String cbsState) {
		this.cbsState = cbsState;
	}
	public String getCbsSerInland() {
		return cbsSerInland;
	}
	public void setCbsSerInland(String cbsSerInland) {
		this.cbsSerInland = cbsSerInland;
	}
	public String getCbsServiceInside() {
		return cbsServiceInside;
	}
	public void setCbsServiceInside(String cbsServiceInside) {
		this.cbsServiceInside = cbsServiceInside;
	}
	public String getCbsServiceAdd() {
		return cbsServiceAdd;
	}
	public void setCbsServiceAdd(String cbsServiceAdd) {
		this.cbsServiceAdd = cbsServiceAdd;
	}
	public String getCbsSerInterna() {
		return cbsSerInterna;
	}
	public void setCbsSerInterna(String cbsSerInterna) {
		this.cbsSerInterna = cbsSerInterna;
	}
	public String getCbsServiceOuter() {
		return cbsServiceOuter;
	}
	public void setCbsServiceOuter(String cbsServiceOuter) {
		this.cbsServiceOuter = cbsServiceOuter;
	}
	public String getCbsServiceRest() {
		return cbsServiceRest;
	}
	public void setCbsServiceRest(String cbsServiceRest) {
		this.cbsServiceRest = cbsServiceRest;
	}
	public String getCbsSerProvince() {
		return cbsSerProvince;
	}
	public void setCbsSerProvince(String cbsSerProvince) {
		this.cbsSerProvince = cbsSerProvince;
	}
	public String getCbsSerCity() {
		return cbsSerCity;
	}
	public void setCbsSerCity(String cbsSerCity) {
		this.cbsSerCity = cbsSerCity;
	}
	public String getCbsSerCounty() {
		return cbsSerCounty;
	}
	public void setCbsSerCounty(String cbsSerCounty) {
		this.cbsSerCounty = cbsSerCounty;
	}
	public String getCbsNurInland() {
		return cbsNurInland;
	}
	public void setCbsNurInland(String cbsNurInland) {
		this.cbsNurInland = cbsNurInland;
	}
	public String getCbsNurInterna() {
		return cbsNurInterna;
	}
	public void setCbsNurInterna(String cbsNurInterna) {
		this.cbsNurInterna = cbsNurInterna;
	}
	public String getCbsNurState() {
		return cbsNurState;
	}
	public void setCbsNurState(String cbsNurState) {
		this.cbsNurState = cbsNurState;
	}
	public String getCbsNurRest() {
		return cbsNurRest;
	}
	public void setCbsNurRest(String cbsNurRest) {
		this.cbsNurRest = cbsNurRest;
	}
	public String getCbsSrlInland() {
		return cbsSrlInland;
	}
	public void setCbsSrlInland(String cbsSrlInland) {
		this.cbsSrlInland = cbsSrlInland;
	}
	public String getCbsSrlInterna() {
		return cbsSrlInterna;
	}
	public void setCbsSrlInterna(String cbsSrlInterna) {
		this.cbsSrlInterna = cbsSrlInterna;
	}
	public String getCbsSrlDir() {
		return cbsSrlDir;
	}
	public void setCbsSrlDir(String cbsSrlDir) {
		this.cbsSrlDir = cbsSrlDir;
	}
	public String getCbsSrlRest() {
		return cbsSrlRest;
	}
	public void setCbsSrlRest(String cbsSrlRest) {
		this.cbsSrlRest = cbsSrlRest;
	}
	public String getCbsCurrAddress() {
		return cbsCurrAddress;
	}
	public void setCbsCurrAddress(String cbsCurrAddress) {
		this.cbsCurrAddress = cbsCurrAddress;
	}
	public String getCbsRanProvince1() {
		return cbsRanProvince1;
	}
	public void setCbsRanProvince1(String cbsRanProvince1) {
		this.cbsRanProvince1 = cbsRanProvince1;
	}
	public String getCbsRanProvince2() {
		return cbsRanProvince2;
	}
	public void setCbsRanProvince2(String cbsRanProvince2) {
		this.cbsRanProvince2 = cbsRanProvince2;
	}
	public String getCbsRanProvince3() {
		return cbsRanProvince3;
	}
	public void setCbsRanProvince3(String cbsRanProvince3) {
		this.cbsRanProvince3 = cbsRanProvince3;
	}
	public String getCbsRanProvince4() {
		return cbsRanProvince4;
	}
	public void setCbsRanProvince4(String cbsRanProvince4) {
		this.cbsRanProvince4 = cbsRanProvince4;
	}
	public String getCbsRanProvince5() {
		return cbsRanProvince5;
	}
	public void setCbsRanProvince5(String cbsRanProvince5) {
		this.cbsRanProvince5 = cbsRanProvince5;
	}
	public String getCbsRanCity1() {
		return cbsRanCity1;
	}
	public void setCbsRanCity1(String cbsRanCity1) {
		this.cbsRanCity1 = cbsRanCity1;
	}
	public String getCbsRanCity2() {
		return cbsRanCity2;
	}
	public void setCbsRanCity2(String cbsRanCity2) {
		this.cbsRanCity2 = cbsRanCity2;
	}
	public String getCbsRanCity3() {
		return cbsRanCity3;
	}
	public void setCbsRanCity3(String cbsRanCity3) {
		this.cbsRanCity3 = cbsRanCity3;
	}
	public String getCbsRanCity4() {
		return cbsRanCity4;
	}
	public void setCbsRanCity4(String cbsRanCity4) {
		this.cbsRanCity4 = cbsRanCity4;
	}
	public String getCbsRanCity5() {
		return cbsRanCity5;
	}
	public void setCbsRanCity5(String cbsRanCity5) {
		this.cbsRanCity5 = cbsRanCity5;
	}
	public String getCbsRanCounty1() {
		return cbsRanCounty1;
	}
	public void setCbsRanCounty1(String cbsRanCounty1) {
		this.cbsRanCounty1 = cbsRanCounty1;
	}
	public String getCbsRanCounty2() {
		return cbsRanCounty2;
	}
	public void setCbsRanCounty2(String cbsRanCounty2) {
		this.cbsRanCounty2 = cbsRanCounty2;
	}
	public String getCbsRanCounty3() {
		return cbsRanCounty3;
	}
	public void setCbsRanCounty3(String cbsRanCounty3) {
		this.cbsRanCounty3 = cbsRanCounty3;
	}
	public String getCbsRanCounty4() {
		return cbsRanCounty4;
	}
	public void setCbsRanCounty4(String cbsRanCounty4) {
		this.cbsRanCounty4 = cbsRanCounty4;
	}
	public String getCbsRanCounty5() {
		return cbsRanCounty5;
	}
	public void setCbsRanCounty5(String cbsRanCounty5) {
		this.cbsRanCounty5 = cbsRanCounty5;
	}
	public String getCbsRanInterna() {
		return cbsRanInterna;
	}
	public void setCbsRanInterna(String cbsRanInterna) {
		this.cbsRanInterna = cbsRanInterna;
	}
	public String getCbsRanState1() {
		return cbsRanState1;
	}
	public void setCbsRanState1(String cbsRanState1) {
		this.cbsRanState1 = cbsRanState1;
	}
	public String getCbsRanState2() {
		return cbsRanState2;
	}
	public void setCbsRanState2(String cbsRanState2) {
		this.cbsRanState2 = cbsRanState2;
	}
	public String getCbsRanState3() {
		return cbsRanState3;
	}
	public void setCbsRanState3(String cbsRanState3) {
		this.cbsRanState3 = cbsRanState3;
	}
	public String getCbsRanState4() {
		return cbsRanState4;
	}
	public void setCbsRanState4(String cbsRanState4) {
		this.cbsRanState4 = cbsRanState4;
	}
	public String getCbsRanState5() {
		return cbsRanState5;
	}
	public void setCbsRanState5(String cbsRanState5) {
		this.cbsRanState5 = cbsRanState5;
	}
	public String getCbsProductType() {
		return cbsProductType;
	}
	public void setCbsProductType(String cbsProductType) {
		this.cbsProductType = cbsProductType;
	}
	public String getCbsProductName() {
		return cbsProductName;
	}
	public void setCbsProductName(String cbsProductName) {
		this.cbsProductName = cbsProductName;
	}
	public String getCbsOperator() {
		return cbsOperator;
	}
	public void setCbsOperator(String cbsOperator) {
		this.cbsOperator = cbsOperator;
	}
	public String getCbsOperatorQq() {
		return cbsOperatorQq;
	}
	public void setCbsOperatorQq(String cbsOperatorQq) {
		this.cbsOperatorQq = cbsOperatorQq;
	}
	public String getCbsProve() {
		return cbsProve;
	}
	public void setCbsProve(String cbsProve) {
		this.cbsProve = cbsProve;
	}
	public String getCbsAccountName() {
		return cbsAccountName;
	}
	public void setCbsAccountName(String cbsAccountName) {
		this.cbsAccountName = cbsAccountName;
	}
	public String getCbsAccount() {
		return cbsAccount;
	}
	public void setCbsAccount(String cbsAccount) {
		this.cbsAccount = cbsAccount;
	}
	public String getCbsOpenAccount() {
		return cbsOpenAccount;
	}
	public void setCbsOpenAccount(String cbsOpenAccount) {
		this.cbsOpenAccount = cbsOpenAccount;
	}
	public String getCbsOperatorPhone() {
		return cbsOperatorPhone;
	}
	public void setCbsOperatorPhone(String cbsOperatorPhone) {
		this.cbsOperatorPhone = cbsOperatorPhone;
	}
	public String getCbsLicense() {
		return cbsLicense;
	}
	public void setCbsLicense(String cbsLicense) {
		this.cbsLicense = cbsLicense;
	}
	public String getCbsPermission() {
		return cbsPermission;
	}
	public void setCbsPermission(String cbsPermission) {
		this.cbsPermission = cbsPermission;
	}
	public String getCbsProProvince() {
		return cbsProProvince;
	}
	public void setCbsProProvince(String cbsProProvince) {
		this.cbsProProvince = cbsProProvince;
	}
	public String getCbsProCity() {
		return cbsProCity;
	}
	public void setCbsProCity(String cbsProCity) {
		this.cbsProCity = cbsProCity;
	}
	public String getCbsProCounty() {
		return cbsProCounty;
	}
	public void setCbsProCounty(String cbsProCounty) {
		this.cbsProCounty = cbsProCounty;
	}
	public Integer getCcpId() {
		return ccpId;
	}
	public void setCcpId(Integer ccpId) {
		this.ccpId = ccpId;
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
	public String getCcpCard() {
		return ccpCard;
	}
	public void setCcpCard(String ccpCard) {
		this.ccpCard = ccpCard;
	}
	public String getCcpImgCard1() {
		return ccpImgCard1;
	}
	public void setCcpImgCard1(String ccpImgCard1) {
		this.ccpImgCard1 = ccpImgCard1;
	}
	public String getCcpImgCard2() {
		return ccpImgCard2;
	}
	public void setCcpImgCard2(String ccpImgCard2) {
		this.ccpImgCard2 = ccpImgCard2;
	}
	public Date getCcpCreatetime() {
		return ccpCreatetime;
	}
	public void setCcpCreatetime(Date ccpCreatetime) {
		this.ccpCreatetime = ccpCreatetime;
	}
	public String[] getAstrprovince() {
		return astrprovince;
	}
	public void setAstrprovince(String[] astrprovince) {
		this.astrprovince = astrprovince;
	}
	public String getZscIsCoopertion() {
		return zscIsCoopertion;
	}
	public void setZscIsCoopertion(String zscIsCoopertion) {
		this.zscIsCoopertion = zscIsCoopertion;
	}
	public Integer getZscFromCpyid() {
		return zscFromCpyid;
	}
	public void setZscFromCpyid(Integer zscFromCpyid) {
		this.zscFromCpyid = zscFromCpyid;
	}
	public Integer getIntLineNum() {
		return intLineNum;
	}
	public void setIntLineNum(Integer intLineNum) {
		this.intLineNum = intLineNum;
	}
	public Integer getZscSellCpyid() {
		return zscSellCpyid;
	}
	public void setZscSellCpyid(Integer zscSellCpyid) {
		this.zscSellCpyid = zscSellCpyid;
	}
	public Integer getIsLineCompany() {
		return isLineCompany;
	}
	public void setIsLineCompany(Integer isLineCompany) {
		this.isLineCompany = isLineCompany;
	}
	public Integer getLinecid() {
		return linecid;
	}
	public void setLinecid(Integer linecid) {
		this.linecid = linecid;
	}
	public String[] getAstrInterna() {
		return astrInterna;
	}
	public void setAstrInterna(String[] astrInterna) {
		this.astrInterna = astrInterna;
	}
	public String[] getAstrState() {
		return astrState;
	}
	public void setAstrState(String[] astrState) {
		this.astrState = astrState;
	}
	public String getYjUserCode() {
		return yjUserCode;
	}
	public void setYjUserCode(String yjUserCode) {
		this.yjUserCode = yjUserCode;
	}
}
