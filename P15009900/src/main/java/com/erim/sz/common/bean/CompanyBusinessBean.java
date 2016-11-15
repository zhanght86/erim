package com.erim.sz.common.bean;

import com.erim.core.bean.BaseBean;

/**
 * @类名: CompanyBusinessBean
 * @描述: 公司业务范围信息实体
 * @作者: 宁晓强
 * @创建时间: 2015年10月27日 下午5:02:48
 */
public class CompanyBusinessBean extends BaseBean {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	// 公司ID
	private Integer cpyId;
	// 业务范围 01组团社 02国际专线商 03地接社 04产品直营
	private	String 	cbsService;
	
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
	
	/**
	 * 专线商（办事处、外联、批发商）
	 */
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
	// 国内省市县 设置成外键 业务字段 01
	private String 	cbsNurProvince;
	private String	cbsNurCity;
	private String	cbsNurCounty;
	// 港澳台
	private String	cbsNurInterna;
	// 国际区域
	private String	cbsNurState;
	// 国际其他区域
	private String	cbsNurRest;
	
	/*
	 * 可服务区域
	 */
	// 可服务地区 02国内01国际
	private String	cbsSrlInland;
	// 国内省市县 设置成外键 业务字段 02
	private String	cbsSrlProvince;
	private String	cbsSrlCity;
	private String	cbsSrlCounty;
	// 港澳台
	private String	cbsSrlInterna;
	// 国际区域
	private String	cbsSrlDir;
	// 国际其他区域
	private String	cbsSrlRest;
	// 现办公地址
	private String	cbsCurrAddress;
	
	/**
	 * 地接社
	 */
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
	
	/**
	 * 产品直营
	 */
	// 经营产品类别
	private String	cbsProductType;
	// 产品名称
	private String	cbsProductName;
	// 省
	private String	cbsProProvince;
	// 市
	private String	cbsProCity;
	// 县
	private String	cbsProCounty;
	
	/**
	 * 公共字段
	 */
	// 操作人（计调/OP）
	private String	cbsOperator;
	// 操作人电话
	private String	cbsOperatorPhone;
	// 操作人Q
	private String	cbsOperatorQQ;
	// 公司账户名称
	private String	cbsAccountName;
	// 账户
	private String	cbsAccount;
	// 开户行
	private String	cbsOpenAccount;
	// 营业执照扫描件
	private String	cbsLicense;
	// 经营许可证扫描件
	private String	cbsPermission;
	// 负责人证明
	private String	cbsProve;
	
	
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
	public String getCbsNurProvince() {
		return cbsNurProvince;
	}
	public void setCbsNurProvince(String cbsNurProvince) {
		this.cbsNurProvince = cbsNurProvince;
	}
	public String getCbsNurCity() {
		return cbsNurCity;
	}
	public void setCbsNurCity(String cbsNurCity) {
		this.cbsNurCity = cbsNurCity;
	}
	public String getCbsNurCounty() {
		return cbsNurCounty;
	}
	public void setCbsNurCounty(String cbsNurCounty) {
		this.cbsNurCounty = cbsNurCounty;
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
	public String getCbsSrlProvince() {
		return cbsSrlProvince;
	}
	public void setCbsSrlProvince(String cbsSrlProvince) {
		this.cbsSrlProvince = cbsSrlProvince;
	}
	public String getCbsSrlCity() {
		return cbsSrlCity;
	}
	public void setCbsSrlCity(String cbsSrlCity) {
		this.cbsSrlCity = cbsSrlCity;
	}
	public String getCbsSrlCounty() {
		return cbsSrlCounty;
	}
	public void setCbsSrlCounty(String cbsSrlCounty) {
		this.cbsSrlCounty = cbsSrlCounty;
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
	public String getCbsOperatorQQ() {
		return cbsOperatorQQ;
	}
	public void setCbsOperatorQQ(String cbsOperatorQQ) {
		this.cbsOperatorQQ = cbsOperatorQQ;
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
	
}
