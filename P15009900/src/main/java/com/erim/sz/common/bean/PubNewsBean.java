package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @类名: PubNewsBean
 * @描述: 新闻资讯信息实体
 * @作者: 宁晓强
 * @创建时间: 2015年10月22日 下午3:55:16
 *
 */
public class PubNewsBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	// 标题
	private String 	newTitle;
	// 内容
	private String 	newContent;
	// 创建时间
	private Date 	newCreateTime;
	// 创建用户
	private String 	newCreateUser;
	// 企业ID
	private Integer cpyId;
	// 点击次数
	private Integer newClick;
	// 类型
	private String 	newType;
	// 是否门户显示
	private String 	newIsShow;
	// 是否审核
	private String	newIsCheck;
	//提交审核
	private String newIsDelstatus;
	////////////////////////company_detail///////////////////////////////
	private String cpyName;
	private String cpyTelephone;
	private String cpyBrand;
	private String ccpName;
	private String ccpTelephone;
	private String ccpEmail;
	private String ccpQq;
	//////////////////////////////////////////////////////////转码参数 ////////////////////////////////////////////////////////////////////////////////
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNewTitle() {
		return newTitle;
	}
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	public String getNewContent() {
		return newContent;
	}
	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}
	public Date getNewCreateTime() {
		return newCreateTime;
	}
	public void setNewCreateTime(Date newCreateTime) {
		this.newCreateTime = newCreateTime;
	}
	public String getNewCreateUser() {
		return newCreateUser;
	}
	public void setNewCreateUser(String newCreateUser) {
		this.newCreateUser = newCreateUser;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public Integer getNewClick() {
		return newClick;
	}
	public void setNewClick(Integer newClick) {
		this.newClick = newClick;
	}
	public String getNewType() {
		return newType;
	}
	public void setNewType(String newType) {
		this.newType = newType;
	}
	public String getNewIsShow() {
		return newIsShow;
	}
	public void setNewIsShow(String newIsShow) {
		this.newIsShow = newIsShow;
	}
	public String getNewIsCheck() {
		return newIsCheck;
	}
	public void setNewIsCheck(String newIsCheck) {
		this.newIsCheck = newIsCheck;
	}
	public String getNewIsDelstatus() {
		return newIsDelstatus;
	}
	public void setNewIsDelstatus(String newIsDelstatus) {
		this.newIsDelstatus = newIsDelstatus;
	}
	public String getCpyTelephone() {
		return cpyTelephone;
	}
	public void setCpyTelephone(String cpyTelephone) {
		this.cpyTelephone = cpyTelephone;
	}
	public String getCpyBrand() {
		return cpyBrand;
	}
	public void setCpyBrand(String cpyBrand) {
		this.cpyBrand = cpyBrand;
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
	public String getCpyName() {
		return cpyName;
	}
	public void setCpyName(String cpyName) {
		this.cpyName = cpyName;
	}
	

}
