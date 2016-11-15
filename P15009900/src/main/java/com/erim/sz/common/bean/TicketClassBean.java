package com.erim.sz.common.bean;

import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: 	 TicketDetailBean
 * @Description: 票类新增
 * @author       王赛
 * @date 		 2015年10月10日 下午2:30:48
 */
public class TicketClassBean extends BaseBean {
	
	/**
	 * @Fields serialVersionUID : 序列化版本ID
	 */
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//产品id
	private Integer tdlId;
	//票类名称
	private String  tdlTicket;
	//费用说明
	private String  tdlMoneyshow;
	//兑票方式
	private String  tdlExpiry;
	//预订限制
	private String  tdlLimited;
	//退改规则
	private String  tdlChange;
	//补充说明
	private String  tdlSupplement;
	//上架下架
	private String  tdlDelStatus;
	//创建时间
	private String  tdlCreattime;
	
	
	
	//////////////////////////////////////////////////////
		private Integer priceId;
		// 票类ID
		private Integer tclId;
		// 票类名称
		private String  tclType;
		// 日期 yyyy-MM-dd
		private String	tplDate;
		// 是否出售
		private String	tplIsOpen;
		// 星期
		private String	tplWeek;
		// 可售票数
		private String	tplSign;
		// 可售票数是否限量
		private String	tplIsSign;
		// 同业价
		private Integer	tplTradePrice;
		// 批发价
		private Integer tplCombinationPrice;
		// 零售价
		private Integer tplRetailPrice;
		// 可选服务/保险
		private Integer	tplInsurePrice;
		// 可选服务说明
		private String	tplExplain;
		// 预订时间类型
		private String	tplDateType;
		// 预订时间当日-时
		private String 	tplSameH;
		// 预订时间当日-分
		private String	tplSameM;
		// 预订时间游玩前-日
		private String	tplForwardD;
		// 预订时间游玩前-时
		private String	tplForwardH;
		// 预订时间游玩前-分
		private String	tplForwardM;
		// 创建时间
		private Date	tplCreateTime;
		// 创建用户
		private String	tplCreateUser;
		// 公司ID
		private Integer	cpyId;
		
		
	//////////////////////////////////////////////////////////////////	
		
		
		
	public Integer getId() {
		return id;
	}
	public Integer getPriceId() {
		return priceId;
	}
	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}
	public Integer getTclId() {
		return tclId;
	}
	public void setTclId(Integer tclId) {
		this.tclId = tclId;
	}
	public String getTclType() {
		return tclType;
	}
	public void setTclType(String tclType) {
		this.tclType = tclType;
	}
	public String getTplDate() {
		return tplDate;
	}
	public void setTplDate(String tplDate) {
		this.tplDate = tplDate;
	}
	public String getTplIsOpen() {
		return tplIsOpen;
	}
	public void setTplIsOpen(String tplIsOpen) {
		this.tplIsOpen = tplIsOpen;
	}
	public String getTplWeek() {
		return tplWeek;
	}
	public void setTplWeek(String tplWeek) {
		this.tplWeek = tplWeek;
	}
	public String getTplSign() {
		return tplSign;
	}
	public void setTplSign(String tplSign) {
		this.tplSign = tplSign;
	}
	public String getTplIsSign() {
		return tplIsSign;
	}
	public void setTplIsSign(String tplIsSign) {
		this.tplIsSign = tplIsSign;
	}
	public Integer getTplTradePrice() {
		return tplTradePrice;
	}
	public void setTplTradePrice(Integer tplTradePrice) {
		this.tplTradePrice = tplTradePrice;
	}
	public Integer getTplCombinationPrice() {
		return tplCombinationPrice;
	}
	public void setTplCombinationPrice(Integer tplCombinationPrice) {
		this.tplCombinationPrice = tplCombinationPrice;
	}
	public Integer getTplRetailPrice() {
		return tplRetailPrice;
	}
	public void setTplRetailPrice(Integer tplRetailPrice) {
		this.tplRetailPrice = tplRetailPrice;
	}
	public Integer getTplInsurePrice() {
		return tplInsurePrice;
	}
	public void setTplInsurePrice(Integer tplInsurePrice) {
		this.tplInsurePrice = tplInsurePrice;
	}
	public String getTplExplain() {
		return tplExplain;
	}
	public void setTplExplain(String tplExplain) {
		this.tplExplain = tplExplain;
	}
	public String getTplDateType() {
		return tplDateType;
	}
	public void setTplDateType(String tplDateType) {
		this.tplDateType = tplDateType;
	}
	public String getTplSameH() {
		return tplSameH;
	}
	public void setTplSameH(String tplSameH) {
		this.tplSameH = tplSameH;
	}
	public String getTplSameM() {
		return tplSameM;
	}
	public void setTplSameM(String tplSameM) {
		this.tplSameM = tplSameM;
	}
	public String getTplForwardD() {
		return tplForwardD;
	}
	public void setTplForwardD(String tplForwardD) {
		this.tplForwardD = tplForwardD;
	}
	public String getTplForwardH() {
		return tplForwardH;
	}
	public void setTplForwardH(String tplForwardH) {
		this.tplForwardH = tplForwardH;
	}
	public String getTplForwardM() {
		return tplForwardM;
	}
	public void setTplForwardM(String tplForwardM) {
		this.tplForwardM = tplForwardM;
	}
	public Date getTplCreateTime() {
		return tplCreateTime;
	}
	public void setTplCreateTime(Date tplCreateTime) {
		this.tplCreateTime = tplCreateTime;
	}
	public String getTplCreateUser() {
		return tplCreateUser;
	}
	public void setTplCreateUser(String tplCreateUser) {
		this.tplCreateUser = tplCreateUser;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTdlId() {
		return tdlId;
	}
	public void setTdlId(Integer tdlId) {
		this.tdlId = tdlId;
	}
	public String getTdlTicket() {
		return tdlTicket;
	}
	public void setTdlTicket(String tdlTicket) {
		this.tdlTicket = tdlTicket;
	}
	public String getTdlMoneyshow() {
		return tdlMoneyshow;
	}
	public void setTdlMoneyshow(String tdlMoneyshow) {
		this.tdlMoneyshow = tdlMoneyshow;
	}
	public String getTdlExpiry() {
		return tdlExpiry;
	}
	public void setTdlExpiry(String tdlExpiry) {
		this.tdlExpiry = tdlExpiry;
	}
	public String getTdlLimited() {
		return tdlLimited;
	}
	public void setTdlLimited(String tdlLimited) {
		this.tdlLimited = tdlLimited;
	}
	public String getTdlChange() {
		return tdlChange;
	}
	public void setTdlChange(String tdlChange) {
		this.tdlChange = tdlChange;
	}
	public String getTdlSupplement() {
		return tdlSupplement;
	}
	public void setTdlSupplement(String tdlSupplement) {
		this.tdlSupplement = tdlSupplement;
	}
	public String getTdlDelStatus() {
		return tdlDelStatus;
	}
	public void setTdlDelStatus(String tdlDelStatus) {
		this.tdlDelStatus = tdlDelStatus;
	}
	public String getTdlCreattime() {
		return tdlCreattime;
	}
	public void setTdlCreattime(String tdlCreattime) {
		this.tdlCreattime = tdlCreattime;
	}
	
	
}
