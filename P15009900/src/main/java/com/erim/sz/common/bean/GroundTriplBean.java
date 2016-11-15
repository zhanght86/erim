package com.erim.sz.common.bean;

import java.io.Serializable;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: 	 GroundTriplBean
 * @Description: 行程管理
 * @author 		  陈鹏
 * @date 		 2015年7月11日 下午1:19:24
 */
public class GroundTriplBean extends BaseBean implements Serializable {
	 
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//产品id
	private Integer tdlId;
	//线路
	private String 	gddLine;
	//工具
	private String 	gddTool;
	//到达地
	private String 	gddLineup;
	//上午
	private String 	gddAm;
	//图片1
	private String 	gddImg1;
	//图片2
	private String 	gddImg2;
	//中餐
	private String 	gddLunch;
	//下午
	private String 	gddAfternoon;
	//晚餐
	private String 	gddDinner;
	//补充说明
	private String 	gddSupplement;

	///////////////拓展字段
	
	private String[] agddTool;
	
	private String[] agddLineup;

	public Integer getId() {
		return id;
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

	public String getGddLine() {
		return gddLine;
	}

	public void setGddLine(String gddLine) {
		this.gddLine = gddLine;
	}

	public String getGddTool() {
		return gddTool;
	}

	public void setGddTool(String gddTool) {
		this.gddTool = gddTool;
	}

	public String getGddLineup() {
		return gddLineup;
	}

	public void setGddLineup(String gddLineup) {
		this.gddLineup = gddLineup;
	}

	public String getGddAm() {
		return gddAm;
	}

	public void setGddAm(String gddAm) {
		this.gddAm = gddAm;
	}

	public String getGddImg1() {
		return gddImg1;
	}

	public void setGddImg1(String gddImg1) {
		this.gddImg1 = gddImg1;
	}

	public String getGddImg2() {
		return gddImg2;
	}

	public void setGddImg2(String gddImg2) {
		this.gddImg2 = gddImg2;
	}

	public String getGddLunch() {
		return gddLunch;
	}

	public void setGddLunch(String gddLunch) {
		this.gddLunch = gddLunch;
	}

	public String getGddAfternoon() {
		return gddAfternoon;
	}

	public void setGddAfternoon(String gddAfternoon) {
		this.gddAfternoon = gddAfternoon;
	}

	public String getGddDinner() {
		return gddDinner;
	}

	public void setGddDinner(String gddDinner) {
		this.gddDinner = gddDinner;
	}

	public String getGddSupplement() {
		return gddSupplement;
	}

	public void setGddSupplement(String gddSupplement) {
		this.gddSupplement = gddSupplement;
	}

	public String[] getAgddTool() {
		return agddTool;
	}

	public void setAgddTool(String[] agddTool) {
		this.agddTool = agddTool;
	}

	public String[] getAgddLineup() {
		return agddLineup;
	}

	public void setAgddLineup(String[] agddLineup) {
		this.agddLineup = agddLineup;
	}
	
}
