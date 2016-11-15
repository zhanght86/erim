package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: CompanyContactPerson 
 * @Description: 公司联系人
 * @author maoxian
 * @date 2015年8月28日 下午12:38:15 
 *
 */
public class CompanyContactPersonBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//联系人名称
	private String  ccpName;
	//QQ
	private String  ccpQq;
	//联系方式
	private String  ccpTelephone;
	//邮箱
	private String  ccpEmail;
	//身份证号
	private String  ccpCard;
	//身份证正面
	private String  ccpImgCard1;
	//身份证背面
	private String  ccpImgCard2;
	//创建时间
	private Date    ccpCreatetime;
	//公司ID
	private Integer cpyId;
	
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
}
