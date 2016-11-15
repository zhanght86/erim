package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: HotalRoomBean
 * @Description: 房型管理
 * @author 龙龙
 * @date 2015年7月19日 下午03:40
 *
 */
public class HotelRoomBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	//主键
	private Integer id;
	//酒店ID
	private Integer hdlId;
	//房型名称
	private String  hheName;
	//入住人数
	private Integer hhePresonnum;
	//房屋面积
	private int    	hheArea;
	//房间层数开始
	private Integer hheLayerstart;
	//房间层数结束
	private Integer hheLayerend;
	//房间数
	private Integer hheHomenum;
	//是否加床
	private String  hheIsAddbed;
	//一次性用品有无
	private String 	hheYes;
	// 是否有窗
	private String  hheIsWindow;
	//房间设施
	private String  hheDevice;
	//企业ID
    private Integer cpyId;
    //是否上架 01否 02是
 	private String  hheIsDelStatus;
 	//创建时间
	private Date    hheCreatetime;
	//创建用户
	private String  hheCreateuser;
	// 图片1
	private String 	hheImg1;
	// 图片2
	private String 	hheImg2;
	// 图片3
	private String 	hheImg3;
	// 图片4
	private String 	hheImg4;
	// 床型
	private String  hdlBedtype;
	//阳台
	private String  hheBalcony;
	
	////////////////////////////room_price/////////////////////////////////////
	//价格
	private Integer	hnpRetailPrice;
	
	/**
	 * 其他暂未使用字段
	 */
	//其他设备
	private String  hheDeviceOther;
	//床宽 
	private String  hheBedWidth;
	//网络设施
	private String  WiFi;
	//一次性用品
	private String  yongPin;
	
	public Integer getCpyId() {
		return cpyId;
	}

	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}

	public String getHheIsDelStatus() {
		return hheIsDelStatus;
	}

	public void setHheIsDelStatus(String hheIsDelStatus) {
		this.hheIsDelStatus = hheIsDelStatus;
	}

	public Integer getHdlId() {
		return hdlId;
	}

	public void setHdlId(Integer hdlId) {
		this.hdlId = hdlId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHheName() {
		return hheName;
	}

	public void setHheName(String hheName) {
		this.hheName = hheName;
	}

	public Integer getHheLayerstart() {
		return hheLayerstart;
	}

	public void setHheLayerstart(Integer hheLayerstart) {
		this.hheLayerstart = hheLayerstart;
	}

	public Integer getHheLayerend() {
		return hheLayerend;
	}

	public void setHheLayerend(Integer hheLayerend) {
		this.hheLayerend = hheLayerend;
	}

	public Integer getHhePresonnum() {
		return hhePresonnum;
	}

	public void setHhePresonnum(Integer hhePresonnum) {
		this.hhePresonnum = hhePresonnum;
	}

	public Integer getHheHomenum() {
		return hheHomenum;
	}

	public void setHheHomenum(Integer hheHomenum) {
		this.hheHomenum = hheHomenum;
	}

	public String getHheIsAddbed() {
		return hheIsAddbed;
	}

	public void setHheIsAddbed(String hheIsAddbed) {
		this.hheIsAddbed = hheIsAddbed;
	}

	public String getHheDevice() {
		return hheDevice;
	}

	public void setHheDevice(String hheDevice) {
		this.hheDevice = hheDevice;
	}

	public String getHheDeviceOther() {
		return hheDeviceOther;
	}

	public void setHheDeviceOther(String hheDeviceOther) {
		this.hheDeviceOther = hheDeviceOther;
	}

	public int getHheArea() {
		return hheArea;
	}

	public void setHheArea(int hheArea) {
		this.hheArea = hheArea;
	}

	public String getHheBedWidth() {
		return hheBedWidth;
	}

	public void setHheBedWidth(String hheBedWidth) {
		this.hheBedWidth = hheBedWidth;
	}

	public Date getHheCreatetime() {
		return hheCreatetime;
	}

	public void setHheCreatetime(Date hheCreatetime) {
		this.hheCreatetime = hheCreatetime;
	}

	public String getHheCreateuser() {
		return hheCreateuser;
	}

	public void setHheCreateuser(String hheCreateuser) {
		this.hheCreateuser = hheCreateuser;
	}

	public String getHdlBedtype() {
		return hdlBedtype;
	}

	public void setHdlBedtype(String hdlBedtype) {
		this.hdlBedtype = hdlBedtype;
	}

	public String getYongPin() {
		return yongPin;
	}

	public void setYongPin(String yongPin) {
		this.yongPin = yongPin;
	}

	public String getWiFi() {
		return WiFi;
	}

	public void setWiFi(String wiFi) {
		WiFi = wiFi;
	}

	public String getHheYes() {
		return hheYes;
	}

	public void setHheYes(String hheYes) {
		this.hheYes = hheYes;
	}

	public String getHheIsWindow() {
		return hheIsWindow;
	}

	public void setHheIsWindow(String hheIsWindow) {
		this.hheIsWindow = hheIsWindow;
	}

	public String getHheImg1() {
		return hheImg1;
	}

	public void setHheImg1(String hheImg1) {
		this.hheImg1 = hheImg1;
	}

	public String getHheImg2() {
		return hheImg2;
	}

	public void setHheImg2(String hheImg2) {
		this.hheImg2 = hheImg2;
	}

	public String getHheImg3() {
		return hheImg3;
	}

	public void setHheImg3(String hheImg3) {
		this.hheImg3 = hheImg3;
	}

	public String getHheImg4() {
		return hheImg4;
	}

	public void setHheImg4(String hheImg4) {
		this.hheImg4 = hheImg4;
	}

	public String getHheBalcony() {
		return hheBalcony;
	}

	public void setHheBalcony(String hheBalcony) {
		this.hheBalcony = hheBalcony;
	}

	public Integer getHnpRetailPrice() {
		return hnpRetailPrice;
	}

	public void setHnpRetailPrice(Integer hnpRetailPrice) {
		this.hnpRetailPrice = hnpRetailPrice;
	}
	

}
