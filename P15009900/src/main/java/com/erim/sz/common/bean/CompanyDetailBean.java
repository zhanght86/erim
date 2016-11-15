package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/***
 * 
 * @ClassName: CompanyDetailBean
 * @Description: 公司管理
 * @author 龙龙
 * @date 2015年7月28日 下午8:45:30
 *
 */
public class CompanyDetailBean extends BaseBean  implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	// 企业编码
	private String  cpyCode;
	// 公司名称
	private String  cpyName;
	// 公司品牌
	private String  cpyBrand;
	// 公司电话
	private String  cpyTelephone;
	// 传真
	private String  cpyFax;
	// 邮箱
	private String  cpyEmail;
	// 是否国内 02国内01国际港港澳台
	private String	cpyIsInland; 
	// 省
	private String  cpyProvince;
	// 市
	private String  cpyCity;
	// 县
	private String  cpyCounty;
	// 港澳台
	private String	cpyExternal;
	// 国际国家
	private String	cpyForeign;
	// 国际城市
	private String	cpyForeignCity;
	// 详细地址
	private String  cpyAddress;
	// 经度
	private String  cpyX;
	// 纬度
	private String  cpyY;
	// 性质
	private String  cpyNature;
	// 许可证
	private String  cpyImgPermit1;
	// 许可证
	private String  cpyImgPermit2;
	// 许可证
	private String  cpyImgPermit3;
	// 专属客服ID
	private Integer cpyCustomId;
	// 创建时间
	private Date    cpyCreatedate;
	// 创建IP
	private String  cpyCreateip;
	// 角色 生产 销售
	private String  cpyRoe;
	// 公司类型
	private String  cpyNtype;
	// 是否审核通过 02 是 01 否
	private String  cpyIsThrough;
	// LOGO
	private String	cpyImg;
	
	// 审核时间
	private Date    cpyThroughTime;
	// 审核人
	private String  cpyThroughUser;
	// 审核IP
	private String  cpyThroughIp;
	// 是否被锁定  02是 01 否
	private String  cpyIsLock;
	
	/////////////////////////////扩展字段////////////////////////////////////////
	
	private String[] cid;
	
	private String   townProvince;
	
	private String   townCity;
	
	private String   townTown;
	
	private String   townNtype;
	
	private String[] aTownCity;
	
	private String[] aTownTown;
	
	private String[] aTownProvince;
	
	private String[] aTownRanInterna;
	
	private String   townRanInterna;
	
	private String   townRanState;
	
	//专线产品数量
	private Integer  intLineNum;
	//上级佣金系统编码
	private String   yjUserCode;
	//是否付费
	private String   pseIsSx;
	//上级login_name
	private String   parentLoginname;
	//企业佣金系统编码
	private String   cpyYjUserCode;
	
	/////////////////////////////扩展字段////////////////////////////////////////
	
	/**
	 * 字典用
	 */
	// 公司负责人
	private String	ccpName;
	// 负责人电话
	private String	ccpTelephone;
	// 计调姓名
	private String	cbsOperator;
	// 计调联系人
	private String	cbsOperatorPhone;
	// 负责人QQ
	private String	ccpQq;
	
	
	public String getCcpQq() {
		return ccpQq;
	}

	public void setCcpQq(String ccpQq) {
		this.ccpQq = ccpQq;
	}

	public Integer getIntLineNum() {
		return intLineNum;
	}

	public void setIntLineNum(Integer intLineNum) {
		this.intLineNum = intLineNum;
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

	public String getCcpTelephone() {
		return ccpTelephone;
	}

	public void setCcpTelephone(String ccpTelephone) {
		this.ccpTelephone = ccpTelephone;
	}

	public String getCcpName() {
		return ccpName;
	}

	public void setCcpName(String ccpName) {
		this.ccpName = ccpName;
	}

	public Integer getId() {
		return id;
	}
	
	public String getCpyImg() {
		return cpyImg;
	}

	public void setCpyImg(String cpyImg) {
		this.cpyImg = cpyImg;
	}

	public String[] getaTownCity() {
		return aTownCity;
	}

	public void setaTownCity(String[] aTownCity) {
		this.aTownCity = aTownCity;
	}

	public String[] getaTownTown() {
		return aTownTown;
	}

	public void setaTownTown(String[] aTownTown) {
		this.aTownTown = aTownTown;
	}

	public String[] getaTownProvince() {
		return aTownProvince;
	}

	public void setaTownProvince(String[] aTownProvince) {
		this.aTownProvince = aTownProvince;
	}

	public String getTownProvince() {
		return townProvince;
	}
	public void setTownProvince(String townProvince) {
		this.townProvince = townProvince;
	}
	public String getTownCity() {
		return townCity;
	}
	public void setTownCity(String townCity) {
		this.townCity = townCity;
	}
	public String getTownTown() {
		return townTown;
	}
	public void setTownTown(String townTown) {
		this.townTown = townTown;
	}
	public String[] getCid() {
		return cid;
	}
	public void setCid(String[] cid) {
		this.cid = cid;
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
	public String getCpyBrand() {
		return cpyBrand;
	}
	public void setCpyBrand(String cpyBrand) {
		this.cpyBrand = cpyBrand;
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
	public String getCpyIsInland() {
		return cpyIsInland;
	}
	public void setCpyIsInland(String cpyIsInland) {
		this.cpyIsInland = cpyIsInland;
	}
	public String getCpyProvince() {
		return cpyProvince;
	}
	public void setCpyProvince(String cpyProvince) {
		this.cpyProvince = cpyProvince;
	}
	public String getCpyCity() {
		return cpyCity;
	}
	public void setCpyCity(String cpyCity) {
		this.cpyCity = cpyCity;
	}
	public String getCpyCounty() {
		return cpyCounty;
	}
	public void setCpyCounty(String cpyCounty) {
		this.cpyCounty = cpyCounty;
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
	public String getCpyAddress() {
		return cpyAddress;
	}
	public void setCpyAddress(String cpyAddress) {
		this.cpyAddress = cpyAddress;
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
	public String getCpyNature() {
		return cpyNature;
	}
	public void setCpyNature(String cpyNature) {
		this.cpyNature = cpyNature;
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
	public String getTownNtype() {
		return townNtype;
	}
	public void setTownNtype(String townNtype) {
		this.townNtype = townNtype;
	}
	public String getTownRanInterna() {
		return townRanInterna;
	}
	public void setTownRanInterna(String townRanInterna) {
		this.townRanInterna = townRanInterna;
	}
	public String getTownRanState() {
		return townRanState;
	}
	public void setTownRanState(String townRanState) {
		this.townRanState = townRanState;
	}


	public String getYjUserCode() {
		return yjUserCode;
	}

	public Date getCpyThroughTime() {
		return cpyThroughTime;
	}

	public void setYjUserCode(String yjUserCode) {
		this.yjUserCode = yjUserCode;
	}

	public String getPseIsSx() {
		return pseIsSx;
	}

	public void setPseIsSx(String pseIsSx) {
		this.pseIsSx = pseIsSx;
	}

	public String getParentLoginname() {
		return parentLoginname;
	}

	public void setParentLoginname(String parentLoginname) {
		this.parentLoginname = parentLoginname;
	}
	

	public void setCpyThroughTime(Date cpyThroughTime) {
		this.cpyThroughTime = cpyThroughTime;
	}

	public String getCpyThroughUser() {
		return cpyThroughUser;
	}

	public void setCpyThroughUser(String cpyThroughUser) {
		this.cpyThroughUser = cpyThroughUser;
	}

	public String getCpyThroughIp() {
		return cpyThroughIp;
	}

	public void setCpyThroughIp(String cpyThroughIp) {
		this.cpyThroughIp = cpyThroughIp;
	}

	public String[] getaTownRanInterna() {
		return aTownRanInterna;
	}

	public void setaTownRanInterna(String[] aTownRanInterna) {
		this.aTownRanInterna = aTownRanInterna;
	}

	public String getCpyYjUserCode() {
		return cpyYjUserCode;
	}

	public void setCpyYjUserCode(String cpyYjUserCode) {
		this.cpyYjUserCode = cpyYjUserCode;
	}

	public String getCpyIsLock() {
		return cpyIsLock;
	}

	public void setCpyIsLock(String cpyIsLock) {
		this.cpyIsLock = cpyIsLock;
	}

	
	
}
