package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: PriceCpyBean 
 * @Description: 担保金
 * @author maoxian
 * @date 2015年11月3日 上午11:10:16
 */
public class PriceServiceBean  extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//企业id
	private Integer cpyId;
	//订单编号
	private String  pseNo;
	//订单名称
	private String  pseName;
	//付款金额
	private Integer psePrice;
	//订单描述
	private String  pseRemark;
	//创建时间
	private Date    pseCreatetime;
	//创建用户
	private String  pseCreateuser;
	//是否生效 1 是 0 否
	private String  pseIsSx;
	//生效时间
	private Date    pseSxtime;
	//到期时间 
	private Date    pseJstime;
	//1生产 2销售 3专线
	private String  pseNtype;
	//支付宝交易号
	private String  tradeNo;
	//商品展示地址
	private String  pseShowurl;
	
	
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
	public String getPseNo() {
		return pseNo;
	}
	public void setPseNo(String pseNo) {
		this.pseNo = pseNo;
	}
	public String getPseName() {
		return pseName;
	}
	public void setPseName(String pseName) {
		this.pseName = pseName;
	}
	public Integer getPsePrice() {
		return psePrice;
	}
	public void setPsePrice(Integer psePrice) {
		this.psePrice = psePrice;
	}
	public String getPseRemark() {
		return pseRemark;
	}
	public void setPseRemark(String pseRemark) {
		this.pseRemark = pseRemark;
	}
	public Date getPseCreatetime() {
		return pseCreatetime;
	}
	public void setPseCreatetime(Date pseCreatetime) {
		this.pseCreatetime = pseCreatetime;
	}
	public String getPseCreateuser() {
		return pseCreateuser;
	}
	public void setPseCreateuser(String pseCreateuser) {
		this.pseCreateuser = pseCreateuser;
	}
	public String getPseIsSx() {
		return pseIsSx;
	}
	public void setPseIsSx(String pseIsSx) {
		this.pseIsSx = pseIsSx;
	}
	public Date getPseSxtime() {
		return pseSxtime;
	}
	public void setPseSxtime(Date pseSxtime) {
		this.pseSxtime = pseSxtime;
	}
	public Date getPseJstime() {
		return pseJstime;
	}
	public void setPseJstime(Date pseJstime) {
		this.pseJstime = pseJstime;
	}
	public String getPseNtype() {
		return pseNtype;
	}
	public void setPseNtype(String pseNtype) {
		this.pseNtype = pseNtype;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getPseShowurl() {
		return pseShowurl;
	}
	public void setPseShowurl(String pseShowurl) {
		this.pseShowurl = pseShowurl;
	}
}
