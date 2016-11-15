package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * 
 * 项目名称：P15009902 
 * 类名称：GuideOrderBean 
 * 类描述： 导游订单 
 * 创建人：lbo 
 * 创建时间：2015年7月12日上午10:17:37 
 * 修改人：lbo 
 * 修改时间：2015年7月12日 上午10:17:37 
 * 修改备注：
 * 
 * @version
 *
 */
public class GuideOrderBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = -3083995676098155358L;

	private Integer id;

	// 订单编号
	private String  gorCode;

	// 总价格
	private int  gdlTotalprice;

	// 确认订单
	private String  gdlIssure;
 
	// 线上支付
	private int  gdlPayOnline;

	// 线下支付
	private int  gdlPayOffline;

	// 最终支付
	private int  gdlPayMoney;

	// 确认/拒接
	private String  gdlNtype;

	// 创建时间
	private Date    gdlCreatetime;

	// 创建用户
	private String  gdlCreateuser;

	// 是否审核通过 1 是 0 否
	private String  gdlIsThrough;
	
	//接单拒单
	private String gdlNtp;
	//企业ID
    private Integer cpyId;
	

	public Integer getCpyId() {
		return cpyId;
	}

	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}

	public String getGdlNtp() {
		return gdlNtp;
	}

	public void setGdlNtp(String gdlNtp) {
		this.gdlNtp = gdlNtp;
	}

	public String getGdlIsThrough() {
		return gdlIsThrough;
	}

	public void setGdlIsThrough(String gdlIsThrough) {
		this.gdlIsThrough = gdlIsThrough;
	}

	/**
	 * id
	 * 
	 * @return the id
	 * @since CodingExample Ver(编码范例查看) 1.0
	 */

	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * gorCode
	 * 
	 * @return the gorCode
	 * @since CodingExample Ver(编码范例查看) 1.0
	 */

	public String getGorCode() {
		return this.gorCode;
	}

	/**
	 * @param gorCode
	 *            the gorCode to set
	 */
	public void setGorCode(String gorCode) {
		this.gorCode = gorCode;
	}

	/**
	 * gdlTotalprice
	 * 
	 * @return the gdlTotalprice
	 * @since CodingExample Ver(编码范例查看) 1.0
	 */

	

	/**
	 * @param gdlTotalprice
	 *            the gdlTotalprice to set
	 */
	
	/**
	 * gdlIssure
	 * 
	 * @return the gdlIssure
	 * @since CodingExample Ver(编码范例查看) 1.0
	 */

	public String getGdlIssure() {
		return this.gdlIssure;
	}

	/**
	 * @param gdlIssure
	 *            the gdlIssure to set
	 */
	public void setGdlIssure(String gdlIssure) {
		this.gdlIssure = gdlIssure;
	}

	/**
	 * gdlPayOnline
	 * 
	 * @return the gdlPayOnline
	 * @since CodingExample Ver(编码范例查看) 1.0
	 */

	/**
	 * @param gdlPayOnline
	 *            the gdlPayOnline to set
	 */
	
	/**
	 * gdlPayOffline
	 * 
	 * @return the gdlPayOffline
	 * @since CodingExample Ver(编码范例查看) 1.0
	 */

	
	/**
	 * @param gdlPayOffline
	 *            the gdlPayOffline to set
	 */
	
	/**
	 * gdlPayMoney
	 * 
	 * @return the gdlPayMoney
	 * @since CodingExample Ver(编码范例查看) 1.0
	 */

	

	/**
	 * @param gdlPayMoney
	 *            the gdlPayMoney to set
	 */
	

	/**
	 * gdlNtype
	 * 
	 * @return the gdlNtype
	 * @since CodingExample Ver(编码范例查看) 1.0
	 */

	public String getGdlNtype() {
		return this.gdlNtype;
	}

	public int getGdlTotalprice() {
		return gdlTotalprice;
	}

	public void setGdlTotalprice(int gdlTotalprice) {
		this.gdlTotalprice = gdlTotalprice;
	}

	public int getGdlPayOnline() {
		return gdlPayOnline;
	}

	public void setGdlPayOnline(int gdlPayOnline) {
		this.gdlPayOnline = gdlPayOnline;
	}

	public int getGdlPayMoney() {
		return gdlPayMoney;
	}

	public void setGdlPayMoney(int gdlPayMoney) {
		this.gdlPayMoney = gdlPayMoney;
	}

	public int getGdlPayOffline() {
		return gdlPayOffline;
	}

	public void setGdlPayOffline(int gdlPayOffline) {
		this.gdlPayOffline = gdlPayOffline;
	}

	/**
	 * @param gdlNtype
	 *            the gdlNtype to set
	 */
	public void setGdlNtype(String gdlNtype) {
		this.gdlNtype = gdlNtype;
	}

	/**
	 * gdlCreatetime
	 * 
	 * @return the gdlCreatetime
	 * @since CodingExample Ver(编码范例查看) 1.0
	 */

	public Date getGdlCreatetime() {
		return this.gdlCreatetime;
	}

	/**
	 * @param gdlCreatetime
	 *            the gdlCreatetime to set
	 */
	public void setGdlCreatetime(Date gdlCreatetime) {
		this.gdlCreatetime = gdlCreatetime;
	}

	/**
	 * gdlCreateuser
	 * 
	 * @return the gdlCreateuser
	 * @since CodingExample Ver(编码范例查看) 1.0
	 */

	public String getGdlCreateuser() {
		return this.gdlCreateuser;
	}

	/**
	 * @param gdlCreateuser
	 *            the gdlCreateuser to set
	 */
	public void setGdlCreateuser(String gdlCreateuser) {
		this.gdlCreateuser = gdlCreateuser;
	}

}
