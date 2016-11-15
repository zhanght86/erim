package com.erim.sz.common.bean;

import java.io.Serializable;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: PlaneticketMiddleBean 
 * @Description: 机票中转
 * @author maoxian
 * @date 2015年10月22日 下午10:06:15
 */
public class PlaneticketMiddleBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//航班id
	private Integer pdlId;
	//落地时间
	private String  pdrnMiddleTime;
	//时间类别 第一天 第二天 第三天
	private String  pdrnMiddleNtype;
	//中转国家 国内/国际
	private String pdrnMiddleState;
	//中转省（国内的）
	private String pdrnProvince;
    //中转市（国内的）
	private String pdrnMiddleCity;
	//中转国家（国际）
	private String pdrnForeign;
	//中转城市（国际）
	private String pdrnForeignCity;
	//中转地港澳台
	private String pdrnExternal;
	//中转市
	private String  pdrnMiddleTown;
	//到达时间
	private String  pdrnMiddleEndtime;
	//停留时间 
	private String  pdrnMiddleStay;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPdlId() {
		return pdlId;
	}
	public void setPdlId(Integer pdlId) {
		this.pdlId = pdlId;
	}
	public String getPdrnMiddleTime() {
		return pdrnMiddleTime;
	}
	public void setPdrnMiddleTime(String pdrnMiddleTime) {
		this.pdrnMiddleTime = pdrnMiddleTime;
	}
	public String getPdrnMiddleNtype() {
		return pdrnMiddleNtype;
	}
	public void setPdrnMiddleNtype(String pdrnMiddleNtype) {
		this.pdrnMiddleNtype = pdrnMiddleNtype;
	}
	public String getPdrnMiddleCity() {
		return pdrnMiddleCity;
	}
	public void setPdrnMiddleCity(String pdrnMiddleCity) {
		this.pdrnMiddleCity = pdrnMiddleCity;
	}
	public String getPdrnMiddleTown() {
		return pdrnMiddleTown;
	}
	public void setPdrnMiddleTown(String pdrnMiddleTown) {
		this.pdrnMiddleTown = pdrnMiddleTown;
	}
	public String getPdrnMiddleEndtime() {
		return pdrnMiddleEndtime;
	}
	public void setPdrnMiddleEndtime(String pdrnMiddleEndtime) {
		this.pdrnMiddleEndtime = pdrnMiddleEndtime;
	}
	public String getPdrnMiddleStay() {
		return pdrnMiddleStay;
	}
	public void setPdrnMiddleStay(String pdrnMiddleStay) {
		this.pdrnMiddleStay = pdrnMiddleStay;
	}
	public String getPdrnMiddleState() {
		return pdrnMiddleState;
	}
	public void setPdrnMiddleState(String pdrnMiddleState) {
		this.pdrnMiddleState = pdrnMiddleState;
	}
	public String getPdrnProvince() {
		return pdrnProvince;
	}
	public void setPdrnProvince(String pdrnProvince) {
		this.pdrnProvince = pdrnProvince;
	}
	public String getPdrnForeign() {
		return pdrnForeign;
	}
	public void setPdrnForeign(String pdrnForeign) {
		this.pdrnForeign = pdrnForeign;
	}
	public String getPdrnForeignCity() {
		return pdrnForeignCity;
	}
	public void setPdrnForeignCity(String pdrnForeignCity) {
		this.pdrnForeignCity = pdrnForeignCity;
	}
	public String getPdrnExternal() {
		return pdrnExternal;
	}
	public void setPdrnExternal(String pdrnExternal) {
		this.pdrnExternal = pdrnExternal;
	}
	
}