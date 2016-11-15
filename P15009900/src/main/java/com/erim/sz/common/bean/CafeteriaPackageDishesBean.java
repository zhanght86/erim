package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: CafeteriaPackageDishesBean 
 * @Description: 菜品
 * @author maoxian
 * @date 2015年11月7日 下午5:41:20
 */
public class CafeteriaPackageDishesBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	// 套餐ID
	private Integer cpeId;
	// 元/道
	private Integer cpdPrice;
	// 可选道数
	private Integer cpdAvenue;
	// 菜品号
	private Integer	cpdNumber;
	// 创建时间
	private Date    cpdCreatetime;
	
	/*
	 * 业务字段
	 */
	private List<CafeteriaPackageDishesFoodBean> foodList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCpeId() {
		return cpeId;
	}
	public void setCpeId(Integer cpeId) {
		this.cpeId = cpeId;
	}
	public Integer getCpdPrice() {
		return cpdPrice;
	}
	public void setCpdPrice(Integer cpdPrice) {
		this.cpdPrice = cpdPrice;
	}
	public Integer getCpdAvenue() {
		return cpdAvenue;
	}
	public void setCpdAvenue(Integer cpdAvenue) {
		this.cpdAvenue = cpdAvenue;
	}
	public Integer getCpdNumber() {
		return cpdNumber;
	}
	public void setCpdNumber(Integer cpdNumber) {
		this.cpdNumber = cpdNumber;
	}
	public Date getCpdCreatetime() {
		return cpdCreatetime;
	}
	public void setCpdCreatetime(Date cpdCreatetime) {
		this.cpdCreatetime = cpdCreatetime;
	}
	public List<CafeteriaPackageDishesFoodBean> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<CafeteriaPackageDishesFoodBean> foodList) {
		this.foodList = foodList;
	}
	
	
}