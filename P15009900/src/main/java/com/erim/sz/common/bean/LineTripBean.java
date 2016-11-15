package com.erim.sz.common.bean;

import java.io.Serializable;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: LineTripBean
 * @Description: 专线行程介绍管理
 * @author 龙龙
 * @date 2015年7月20日 下午9:05:06
 *
 */
public class LineTripBean extends BaseBean implements Serializable{
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer tdlId;
	// 天数
	private String ltpDate;
	// 线路始发地
	private String ltpStartplace;
	// 线路终点站
	private String ltpEndplace;
	// 行程安排
	private String ltpRoad;
	// 行程特色
	private String ltpRoadTrip;
	// 用餐安排
	private String ltpFood;
	// 用餐特色
	private String ltpFoodTrip;
	// 上午
	private String ltpRoad1;
	// 中午
	private String ltpRoadTrip1;
	// 下午
	private String ltpFood1;
	// 晚上
	private String ltpFoodTrip1;
	// 类型早:中:晚
	private String ltpNtype;
	// 行程图片
	private String ltpRoadImg;
	// 费用包含
	private String ldlMoneyContain;
	// 费用不包含
	private String ldlMoneyContainOff;
	// 项目参考
	private String ldlProject;
	// 预定须知
	private String ldlScheduleTravel;
	//备注
	private String ltpRemark;
	//图片1
	private String 	gddImg1;
	//图片2
	private String 	gddImg2;
	//行程交通工具
	private String ldlTripTraffic;
	//经理推荐
	private String ldlRecommend;
	//产品特色
	private String ldlFeatures;

///////////////拓展字段
	
	private String[] agddTool;
	
	private String[] agddLineup;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getLtpDate() {
		return ltpDate;
	}

	public void setLtpDate(String ltpDate) {
		this.ltpDate = ltpDate;
	}

	public String getLtpStartplace() {
		return ltpStartplace;
	}

	public void setLtpStartplace(String ltpStartplace) {
		this.ltpStartplace = ltpStartplace;
	}

	public String getLtpEndplace() {
		return ltpEndplace;
	}

	public void setLtpEndplace(String ltpEndplace) {
		this.ltpEndplace = ltpEndplace;
	}

	public String getLtpRoad() {
		return ltpRoad;
	}

	public void setLtpRoad(String ltpRoad) {
		this.ltpRoad = ltpRoad;
	}

	public String getLtpRoadTrip() {
		return ltpRoadTrip;
	}

	public void setLtpRoadTrip(String ltpRoadTrip) {
		this.ltpRoadTrip = ltpRoadTrip;
	}

	public String getLtpFood() {
		return ltpFood;
	}

	public void setLtpFood(String ltpFood) {
		this.ltpFood = ltpFood;
	}

	public String getLtpFoodTrip() {
		return ltpFoodTrip;
	}

	public void setLtpFoodTrip(String ltpFoodTrip) {
		this.ltpFoodTrip = ltpFoodTrip;
	}

	public String getLtpNtype() {
		return ltpNtype;
	}

	public void setLtpNtype(String ltpNtype) {
		this.ltpNtype = ltpNtype;
	}

	public String getLtpRoadImg() {
		return ltpRoadImg;
	}

	public void setLtpRoadImg(String ltpRoadImg) {
		this.ltpRoadImg = ltpRoadImg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLtpRoad1() {
		return ltpRoad1;
	}

	public void setLtpRoad1(String ltpRoad1) {
		this.ltpRoad1 = ltpRoad1;
	}

	public String getLtpRoadTrip1() {
		return ltpRoadTrip1;
	}

	public void setLtpRoadTrip1(String ltpRoadTrip1) {
		this.ltpRoadTrip1 = ltpRoadTrip1;
	}

	public String getLtpFood1() {
		return ltpFood1;
	}

	public void setLtpFood1(String ltpFood1) {
		this.ltpFood1 = ltpFood1;
	}

	public String getLtpFoodTrip1() {
		return ltpFoodTrip1;
	}

	public void setLtpFoodTrip1(String ltpFoodTrip1) {
		this.ltpFoodTrip1 = ltpFoodTrip1;
	}

	public String getLdlMoneyContain() {
		return ldlMoneyContain;
	}

	public void setLdlMoneyContain(String ldlMoneyContain) {
		this.ldlMoneyContain = ldlMoneyContain;
	}

	public String getLdlMoneyContainOff() {
		return ldlMoneyContainOff;
	}

	public void setLdlMoneyContainOff(String ldlMoneyContainOff) {
		this.ldlMoneyContainOff = ldlMoneyContainOff;
	}

	public String getLdlProject() {
		return ldlProject;
	}

	public void setLdlProject(String ldlProject) {
		this.ldlProject = ldlProject;
	}

	public String getLdlScheduleTravel() {
		return ldlScheduleTravel;
	}

	public void setLdlScheduleTravel(String ldlScheduleTravel) {
		this.ldlScheduleTravel = ldlScheduleTravel;
	}

	public String getLtpRemark() {
		return ltpRemark;
	}

	public void setLtpRemark(String ltpRemark) {
		this.ltpRemark = ltpRemark;
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

	public String getLdlTripTraffic() {
		return ldlTripTraffic;
	}

	public void setLdlTripTraffic(String ldlTripTraffic) {
		this.ldlTripTraffic = ldlTripTraffic;
	}

	public String getLdlRecommend() {
		return ldlRecommend;
	}

	public void setLdlRecommend(String ldlRecommend) {
		this.ldlRecommend = ldlRecommend;
	}

	public String getLdlFeatures() {
		return ldlFeatures;
	}

	public void setLdlFeatures(String ldlFeatures) {
		this.ldlFeatures = ldlFeatures;
	}

	public Integer getTdlId() {
		return tdlId;
	}

	public void setTdlId(Integer tdlId) {
		this.tdlId = tdlId;
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
