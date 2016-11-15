package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: TransticketDetailBean 
 * @Description: 火车票管理
 * @author maoxian
 * @date 2015年10月13日 下午11:42:15 
 *
 */
public class TransticketDetailBean extends BaseBean implements Serializable {
	/**
	 *  @Fields serialVersionUID : 序列化版本ID
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//企业ID
	private Integer cpyId;
	//创建时间
	private Date   ttdCreatetime;
	//创建用户
	private String ttdCreateuser;
	//上下架
	private String ttdIsDelStatus;
	//出发城市
	private String ttdStartCity;
	//出发站点
	private String ttdStartStation1;
	//目的地
	private String ttdEndStatcion;
	//编码
	private String ttdNo;
	
	private String ttdStartStation2;
	
	private String ttdStartStation3;
	
	private String ttdStartStation4;
	//出发省
	private String ttdStartProvinces;
	//县
	private String ttdStartTown;
	//是否全国
	private String ttdEndIsDomestic;
	//到达省
	private String ttdEndProvinces;
	
	private String ttdEndTown;
	//香港
	private String ttdEndIsXg;
	//澳门
	private String ttdEndIsAm;
	//台湾
	private String ttdEndIsTw;
	//国家
	private String ttdEndCountry;
	//国家 城市
	private String ttdEndCity;
	
	
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
	
	public String getTtdEndIsDomestic() {
		return ttdEndIsDomestic;
	}
	public void setTtdEndIsDomestic(String ttdEndIsDomestic) {
		this.ttdEndIsDomestic = ttdEndIsDomestic;
	}
	public String getTtdEndProvinces() {
		return ttdEndProvinces;
	}
	public void setTtdEndProvinces(String ttdEndProvinces) {
		this.ttdEndProvinces = ttdEndProvinces;
	}
	public String getTtdEndTown() {
		return ttdEndTown;
	}
	public void setTtdEndTown(String ttdEndTown) {
		this.ttdEndTown = ttdEndTown;
	}
	public String getTtdEndIsXg() {
		return ttdEndIsXg;
	}
	public void setTtdEndIsXg(String ttdEndIsXg) {
		this.ttdEndIsXg = ttdEndIsXg;
	}
	public String getTtdEndIsAm() {
		return ttdEndIsAm;
	}
	public void setTtdEndIsAm(String ttdEndIsAm) {
		this.ttdEndIsAm = ttdEndIsAm;
	}
	public String getTtdEndIsTw() {
		return ttdEndIsTw;
	}
	public void setTtdEndIsTw(String ttdEndIsTw) {
		this.ttdEndIsTw = ttdEndIsTw;
	}
	public String getTtdEndCountry() {
		return ttdEndCountry;
	}
	public void setTtdEndCountry(String ttdEndCountry) {
		this.ttdEndCountry = ttdEndCountry;
	}
	public String getTtdEndCity() {
		return ttdEndCity;
	}
	public void setTtdEndCity(String ttdEndCity) {
		this.ttdEndCity = ttdEndCity;
	}
	public String getTtdStartProvinces() {
		return ttdStartProvinces;
	}
	public void setTtdStartProvinces(String ttdStartProvinces) {
		this.ttdStartProvinces = ttdStartProvinces;
	}
	public String getTtdStartTown() {
		return ttdStartTown;
	}
	public void setTtdStartTown(String ttdStartTown) {
		this.ttdStartTown = ttdStartTown;
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
	public Date getTtdCreatetime() {
		return ttdCreatetime;
	}
	public void setTtdCreatetime(Date ttdCreatetime) {
		this.ttdCreatetime = ttdCreatetime;
	}
	public String getTtdCreateuser() {
		return ttdCreateuser;
	}
	public void setTtdCreateuser(String ttdCreateuser) {
		this.ttdCreateuser = ttdCreateuser;
	}
	public String getTtdIsDelStatus() {
		return ttdIsDelStatus;
	}
	public void setTtdIsDelStatus(String ttdIsDelStatus) {
		this.ttdIsDelStatus = ttdIsDelStatus;
	}
	public String getTtdStartCity() {
		return ttdStartCity;
	}
	public void setTtdStartCity(String ttdStartCity) {
		this.ttdStartCity = ttdStartCity;
	}
	public String getTtdEndStatcion() {
		return ttdEndStatcion;
	}
	public void setTtdEndStatcion(String ttdEndStatcion) {
		this.ttdEndStatcion = ttdEndStatcion;
	}
	public String getTtdNo() {
		return ttdNo;
	}
	public void setTtdNo(String ttdNo) {
		this.ttdNo = ttdNo;
	}
	public String getTtdStartStation1() {
		return ttdStartStation1;
	}
	public void setTtdStartStation1(String ttdStartStation1) {
		this.ttdStartStation1 = ttdStartStation1;
	}
	public String getTtdStartStation2() {
		return ttdStartStation2;
	}
	public void setTtdStartStation2(String ttdStartStation2) {
		this.ttdStartStation2 = ttdStartStation2;
	}
	public String getTtdStartStation3() {
		return ttdStartStation3;
	}
	public void setTtdStartStation3(String ttdStartStation3) {
		this.ttdStartStation3 = ttdStartStation3;
	}
	public String getTtdStartStation4() {
		return ttdStartStation4;
	}
	public void setTtdStartStation4(String ttdStartStation4) {
		this.ttdStartStation4 = ttdStartStation4;
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

	
}
