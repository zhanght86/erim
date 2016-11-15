package com.erim.sz.common.bean;

import java.io.Serializable;

import com.erim.core.bean.BaseBean;

/**
 * 
 * 
 * 项目名称：P15009902 
 * 类名称：GroundpriceBean 
 * 类描述： 地接旅行价格 
 * 创建人：龙龙 
 * 创建时间：2015年9月11号
 * 修改备注：
 * 
 * @version
 *
 */
public class GroundwalkBean extends BaseBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//价格id
	private Integer tdlId;
	//天数
	private String  gddDay;
	//当天行程安排
	private String  gddWalk;
	
	
	public String getGddDay() {
		return gddDay;
	}
	public void setGddDay(String gddDay) {
		this.gddDay = gddDay;
	}
	public String getGddWalk() {
		return gddWalk;
	}
	public void setGddWalk(String gddWalk) {
		this.gddWalk = gddWalk;
	}
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
	
	
}
