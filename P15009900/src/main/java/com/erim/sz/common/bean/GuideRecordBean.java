package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: GuideRecordBean 
 * @Description: 导游动态
 * @author maoxian
 * @date 2015年9月10日 下午7:50:20 
 *
 */
public class GuideRecordBean implements Serializable {
	
	/**
	 * @Fields serialVersionUID : 序列化 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//导游id
	private Integer gdlId;
	//内容
	private String  grdRemark;
	//图片1
	private String  grdImg1;
	//图片2
	private String  grdImg2;
	//图片3
	private String  grdImg3;
	//图片4
	private String  grdImg4;
	//创建时间
	private Date    grdCreatetime;
	
	// 转码字段
	private String	dateStr;
	
	
	
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGdlId() {
		return gdlId;
	}
	public void setGdlId(Integer gdlId) {
		this.gdlId = gdlId;
	}
	public String getGrdRemark() {
		return grdRemark;
	}
	public void setGrdRemark(String grdRemark) {
		this.grdRemark = grdRemark;
	}
	public String getGrdImg1() {
		return grdImg1;
	}
	public void setGrdImg1(String grdImg1) {
		this.grdImg1 = grdImg1;
	}
	public String getGrdImg2() {
		return grdImg2;
	}
	public void setGrdImg2(String grdImg2) {
		this.grdImg2 = grdImg2;
	}
	public String getGrdImg3() {
		return grdImg3;
	}
	public void setGrdImg3(String grdImg3) {
		this.grdImg3 = grdImg3;
	}
	public String getGrdImg4() {
		return grdImg4;
	}
	public void setGrdImg4(String grdImg4) {
		this.grdImg4 = grdImg4;
	}
	public Date getGrdCreatetime() {
		return grdCreatetime;
	}
	public void setGrdCreatetime(Date grdCreatetime) {
		this.grdCreatetime = grdCreatetime;
	}
}
