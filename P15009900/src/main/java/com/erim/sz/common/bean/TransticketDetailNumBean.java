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
public class TransticketDetailNumBean extends BaseBean implements Serializable {
	/**
	 *  @Fields serialVersionUID : 序列化版本ID
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer ttdId;
	//出发车站
	private String  tdlStartStation;
	//车次
	private String  tdlNo;
	//发车时间
	private String  tdlStartTime;
	//到达站点
	private String  tdlArrivedStation;
	//到达时间
	private String  tdlArrivedTime;
	//上下架
	private String  tdlIsDelStatus;
	
	private Date    tdlCreatetime;
	//创建用户
	private String  tdlCreateuser;
	//坐席
	private String  tdlNtype;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTtdId() {
		return ttdId;
	}
	public void setTtdId(Integer ttdId) {
		this.ttdId = ttdId;
	}
	public String getTdlStartStation() {
		return tdlStartStation;
	}
	public void setTdlStartStation(String tdlStartStation) {
		this.tdlStartStation = tdlStartStation;
	}
	public String getTdlNo() {
		return tdlNo;
	}
	public void setTdlNo(String tdlNo) {
		this.tdlNo = tdlNo;
	}
	public String getTdlStartTime() {
		return tdlStartTime;
	}
	public void setTdlStartTime(String tdlStartTime) {
		this.tdlStartTime = tdlStartTime;
	}
	public String getTdlArrivedStation() {
		return tdlArrivedStation;
	}
	public void setTdlArrivedStation(String tdlArrivedStation) {
		this.tdlArrivedStation = tdlArrivedStation;
	}
	public String getTdlArrivedTime() {
		return tdlArrivedTime;
	}
	public void setTdlArrivedTime(String tdlArrivedTime) {
		this.tdlArrivedTime = tdlArrivedTime;
	}
	public String getTdlIsDelStatus() {
		return tdlIsDelStatus;
	}
	public void setTdlIsDelStatus(String tdlIsDelStatus) {
		this.tdlIsDelStatus = tdlIsDelStatus;
	}
	public Date getTdlCreatetime() {
		return tdlCreatetime;
	}
	public void setTdlCreatetime(Date tdlCreatetime) {
		this.tdlCreatetime = tdlCreatetime;
	}
	public String getTdlCreateuser() {
		return tdlCreateuser;
	}
	public void setTdlCreateuser(String tdlCreateuser) {
		this.tdlCreateuser = tdlCreateuser;
	}
	public String getTdlNtype() {
		return tdlNtype;
	}
	public void setTdlNtype(String tdlNtype) {
		this.tdlNtype = tdlNtype;
	}
}
