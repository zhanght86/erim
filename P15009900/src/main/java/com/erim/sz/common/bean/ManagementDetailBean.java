package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: ManagementDetailBean
 * @Description: 签证管理
 * @author maoxian
 * @date 2015年7月11日 下午2:04:14
 */
public class ManagementDetailBean extends BaseBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	// 产品编号
	private String 	mdlCode;
	// 签证名称
	private String 	mdlName;
	// 签证国家
	private String 	mdlAddress;
	// 送签地
	private String 	mdlSend;
	// 类型
	private String 	mdlNtype;
	// 入境次数
	private String 	mdlNum;
	// 办理时长
	private String 	mdlLong;
	// 可停留天数
	private String 	mdlStay;
	// 签证有效期
	private String 	mdlValidity;
	// 面签
	private String 	mdlInterview;
	// 领使受理范围
	private String 	mdlProvince;
	// 签证类型说明
	private String 	mdlResponsibility;
	// 预知须知
	private String 	mdlOrderKnow;
	// 办理流程
	private String 	mdlMoneyContain;
	// 补充说明
	private String 	mdladdInstruction;
	// 创建时间
	private String	mdlCreatetime;
	// 创建用户
	private String 	mdlCreateuser;
	// 是否审核通过 1 是 0 否
	private String 	mdlIsThrough;
	// 审核时间
	private Date 	mdlThroughTime;
	// 审核人
	private String 	mdlThroughUser;
	// 公司id
	private Integer cpyId;
	
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
	
    //计调人名
	private String  cbsOperator;
	
	// 计调人电话
	private String  cbsOperatorPhone;
	
	// 计调qq
	private String  cbsOperatorQq;
	

	/////////////////////////////企业信息end///////////////////////////////////
	// 时间
	private String 	mdlDate;
	// 同业价
	private Integer	mdlPriceSame;
	
	/////////////////////////////未使用字段///////////////////////////////////////////////////////////
	// 批发价
	private int mdlPriceTeam;
	// 零售价
	private int mdlPriceSeal;
	// 材料
	private String 	mdlImg2;
	// 材料
	private String 	mdlImg3;
	// 办理流程
	private String 	mdlProcedures;
	// 可受理人群
	private String 	mdlAttestor;
	// 收集材料后需几个工作日
	private String 	mdlNeedDay;
	// 所属领取
	private String 	mdlTown;
	// 入境次数
	private String 	mdlNumbers;
	// 注意事项
	private String 	mdlMessage;
	// 可受理群众
	private String 	mdlCaseload;
	// 可受理范围市
	private String 	mdlCity;
	// 材料说明
	private String 	mdlTextKnow;
	// 上传图片
	private String 	mdlImg1;
	// 上传文本
	private String 	mdlTextImg;
	// 材料名称
	private String 	mdlMaterial;
	// 是否删除
	private String 	mdlIsDelStatus;
	// 预定方式
	private String 	mdlScheduled;
	// 国家国旗
	private String  mdlFlag;
	
	public String getMdlDate() {
		return mdlDate;
	}
	public void setMdlDate(String mdlDate) {
		this.mdlDate = mdlDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getMdlCode() {
		return mdlCode;
	}
	public void setMdlCode(String mdlCode) {
		this.mdlCode = mdlCode;
	}
	public String getMdlName() {
		return mdlName;
	}
	public void setMdlName(String mdlName) {
		this.mdlName = mdlName;
	}
	public String getMdlAddress() {
		return mdlAddress;
	}
	public void setMdlAddress(String mdlAddress) {
		this.mdlAddress = mdlAddress;
	}
	public String getMdlSend() {
		return mdlSend;
	}
	public void setMdlSend(String mdlSend) {
		this.mdlSend = mdlSend;
	}
	public String getMdlNtype() {
		return mdlNtype;
	}
	public void setMdlNtype(String mdlNtype) {
		this.mdlNtype = mdlNtype;
	}
	public String getMdlNum() {
		return mdlNum;
	}
	public void setMdlNum(String mdlNum) {
		this.mdlNum = mdlNum;
	}
	public String getMdlLong() {
		return mdlLong;
	}
	public void setMdlLong(String mdlLong) {
		this.mdlLong = mdlLong;
	}
	public String getMdlStay() {
		return mdlStay;
	}
	public void setMdlStay(String mdlStay) {
		this.mdlStay = mdlStay;
	}
	public String getMdlValidity() {
		return mdlValidity;
	}
	public void setMdlValidity(String mdlValidity) {
		this.mdlValidity = mdlValidity;
	}
	public String getMdlInterview() {
		return mdlInterview;
	}
	public void setMdlInterview(String mdlInterview) {
		this.mdlInterview = mdlInterview;
	}
	public String getMdlProvince() {
		return mdlProvince;
	}
	public void setMdlProvince(String mdlProvince) {
		this.mdlProvince = mdlProvince;
	}
	public String getMdlResponsibility() {
		return mdlResponsibility;
	}
	public void setMdlResponsibility(String mdlResponsibility) {
		this.mdlResponsibility = mdlResponsibility;
	}
	public String getMdlOrderKnow() {
		return mdlOrderKnow;
	}
	public void setMdlOrderKnow(String mdlOrderKnow) {
		this.mdlOrderKnow = mdlOrderKnow;
	}
	public String getMdlMoneyContain() {
		return mdlMoneyContain;
	}
	public void setMdlMoneyContain(String mdlMoneyContain) {
		this.mdlMoneyContain = mdlMoneyContain;
	}
	public String getMdladdInstruction() {
		return mdladdInstruction;
	}
	public void setMdladdInstruction(String mdladdInstruction) {
		this.mdladdInstruction = mdladdInstruction;
	}
	public String getMdlCreatetime() {
		return mdlCreatetime;
	}
	public void setMdlCreatetime(String mdlCreatetime) {
		this.mdlCreatetime = mdlCreatetime;
	}
	public String getMdlCreateuser() {
		return mdlCreateuser;
	}
	public void setMdlCreateuser(String mdlCreateuser) {
		this.mdlCreateuser = mdlCreateuser;
	}
	public String getMdlIsThrough() {
		return mdlIsThrough;
	}
	public void setMdlIsThrough(String mdlIsThrough) {
		this.mdlIsThrough = mdlIsThrough;
	}
	public Date getMdlThroughTime() {
		return mdlThroughTime;
	}
	public void setMdlThroughTime(Date mdlThroughTime) {
		this.mdlThroughTime = mdlThroughTime;
	}
	public String getMdlThroughUser() {
		return mdlThroughUser;
	}
	public void setMdlThroughUser(String mdlThroughUser) {
		this.mdlThroughUser = mdlThroughUser;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
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
	public Integer getMdlPriceSame() {
		return mdlPriceSame;
	}
	public void setMdlPriceSame(Integer mdlPriceSame) {
		this.mdlPriceSame = mdlPriceSame;
	}
	public int getMdlPriceTeam() {
		return mdlPriceTeam;
	}
	public void setMdlPriceTeam(int mdlPriceTeam) {
		this.mdlPriceTeam = mdlPriceTeam;
	}
	public int getMdlPriceSeal() {
		return mdlPriceSeal;
	}
	public void setMdlPriceSeal(int mdlPriceSeal) {
		this.mdlPriceSeal = mdlPriceSeal;
	}
	public String getMdlImg2() {
		return mdlImg2;
	}
	public void setMdlImg2(String mdlImg2) {
		this.mdlImg2 = mdlImg2;
	}
	public String getMdlImg3() {
		return mdlImg3;
	}
	public void setMdlImg3(String mdlImg3) {
		this.mdlImg3 = mdlImg3;
	}
	public String getMdlProcedures() {
		return mdlProcedures;
	}
	public void setMdlProcedures(String mdlProcedures) {
		this.mdlProcedures = mdlProcedures;
	}
	public String getMdlAttestor() {
		return mdlAttestor;
	}
	public void setMdlAttestor(String mdlAttestor) {
		this.mdlAttestor = mdlAttestor;
	}
	public String getMdlNeedDay() {
		return mdlNeedDay;
	}
	public void setMdlNeedDay(String mdlNeedDay) {
		this.mdlNeedDay = mdlNeedDay;
	}
	public String getMdlTown() {
		return mdlTown;
	}
	public void setMdlTown(String mdlTown) {
		this.mdlTown = mdlTown;
	}
	public String getMdlNumbers() {
		return mdlNumbers;
	}
	public void setMdlNumbers(String mdlNumbers) {
		this.mdlNumbers = mdlNumbers;
	}
	public String getMdlMessage() {
		return mdlMessage;
	}
	public void setMdlMessage(String mdlMessage) {
		this.mdlMessage = mdlMessage;
	}
	public String getMdlCaseload() {
		return mdlCaseload;
	}
	public void setMdlCaseload(String mdlCaseload) {
		this.mdlCaseload = mdlCaseload;
	}
	public String getMdlCity() {
		return mdlCity;
	}
	public void setMdlCity(String mdlCity) {
		this.mdlCity = mdlCity;
	}
	public String getMdlTextKnow() {
		return mdlTextKnow;
	}
	public void setMdlTextKnow(String mdlTextKnow) {
		this.mdlTextKnow = mdlTextKnow;
	}
	public String getMdlImg1() {
		return mdlImg1;
	}
	public void setMdlImg1(String mdlImg1) {
		this.mdlImg1 = mdlImg1;
	}
	public String getMdlTextImg() {
		return mdlTextImg;
	}
	public void setMdlTextImg(String mdlTextImg) {
		this.mdlTextImg = mdlTextImg;
	}
	public String getMdlMaterial() {
		return mdlMaterial;
	}
	public void setMdlMaterial(String mdlMaterial) {
		this.mdlMaterial = mdlMaterial;
	}
	public String getMdlIsDelStatus() {
		return mdlIsDelStatus;
	}
	public void setMdlIsDelStatus(String mdlIsDelStatus) {
		this.mdlIsDelStatus = mdlIsDelStatus;
	}
	public String getMdlScheduled() {
		return mdlScheduled;
	}
	public void setMdlScheduled(String mdlScheduled) {
		this.mdlScheduled = mdlScheduled;
	}
	public String getMdlFlag() {
		return mdlFlag;
	}
	public void setMdlFlag(String mdlFlag) {
		this.mdlFlag = mdlFlag;
	}
	public String getCbsOperatorQq() {
		return cbsOperatorQq;
	}
	public void setCbsOperatorQq(String cbsOperatorQq) {
		this.cbsOperatorQq = cbsOperatorQq;
	}
	
}
