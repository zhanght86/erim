package com.erim.sz.common.bean;

import java.io.Serializable;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: CafeteriaCuisineBean
 * @Description: 特色菜管理
 * @author 贺渊博
 * @date 2015年9月25日 下午19:15:15
 *
 */
public class CafeteriaCuisineBean  extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer cdlID;
	//添加特色餐的类型
	private String  cslType;
	//菜系名称
	private String  cslName;
	//菜系价格
	private Integer cslPrice;
	//菜品介绍
	private String  cslIntroduce;
	//菜系照片
	private String  cslImag;
	//是否上架1是0否
	private String  cslIsDelStatus;
	//创建时间
	private String    cslCreatetime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCslName() {
		return cslName;
	}
	public void setCslName(String cslName) {
		this.cslName = cslName;
	}
	public Integer getCslPrice() {
		return cslPrice;
	}
	public void setCslPrice(Integer cslPrice) {
		this.cslPrice = cslPrice;
	}
	public String getCslIntroduce() {
		return cslIntroduce;
	}
	public void setCslIntroduce(String cslIntroduce) {
		this.cslIntroduce = cslIntroduce;
	}
	public String getCslImag() {
		return cslImag;
	}
	public void setCslImag(String cslImag) {
		this.cslImag = cslImag;
	}
	public String getCslIsDelStatus() {
		return cslIsDelStatus;
	}
	public void setCslIsDelStatus(String cslIsDelStatus) {
		this.cslIsDelStatus = cslIsDelStatus;
	}
	
	public String getCslCreatetime() {
		return cslCreatetime;
	}
	public void setCslCreatetime(String cslCreatetime) {
		this.cslCreatetime = cslCreatetime;
	}
	public String getCslType() {
		return cslType;
	}
	public void setCslType(String cslType) {
		this.cslType = cslType;
	}
	public Integer getCdlID() {
		return cdlID;
	}
	public void setCdlID(Integer cdlID) {
		this.cdlID = cdlID;
	}

}
