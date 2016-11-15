package com.erim.sz.system.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: YjSystemFuncBean 
 * @Description: 模块分类
 * @author maoxian
 * @date 2015年8月1日 下午9:13:06
 */
public class YjSystemFuncBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	//编号
	private String  yjFuncCode;
	//父级编号
	private String  yjFuncParentcode;
	//名称
	private String  yjFuncName;
	//动作
	private String  yjFuncAction;
	//图片路径
	private String  yjFuncImg;
	//排序
	private Integer yjFuncOrder;
	
	
	////////////////////////////////////////////自定义 start ////////////////////////////////////////////////////////////////////
	
	//子级数量
	private Integer childSize;
	
	private List<YjSystemFuncBean> childListYjSystemFuncBean;
	
	private List<YjSystemFuncRescourceBean> childListYjSystemFuncRescourceBean;
	
	////////////////////////////////////////////自定义 end////////////////////////////////////////////////////////////////////
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYjFuncCode() {
		return yjFuncCode;
	}
	public void setYjFuncCode(String yjFuncCode) {
		this.yjFuncCode = yjFuncCode;
	}
	public String getYjFuncParentcode() {
		return yjFuncParentcode;
	}
	public void setYjFuncParentcode(String yjFuncParentcode) {
		this.yjFuncParentcode = yjFuncParentcode;
	}
	public String getYjFuncName() {
		return yjFuncName;
	}
	public void setYjFuncName(String yjFuncName) {
		this.yjFuncName = yjFuncName;
	}
	public String getYjFuncAction() {
		return yjFuncAction;
	}
	public void setYjFuncAction(String yjFuncAction) {
		this.yjFuncAction = yjFuncAction;
	}
	public Integer getYjFuncOrder() {
		return yjFuncOrder;
	}
	public void setYjFuncOrder(Integer yjFuncOrder) {
		this.yjFuncOrder = yjFuncOrder;
	}
	public String getYjFuncImg() {
		return yjFuncImg;
	}
	public void setYjFuncImg(String yjFuncImg) {
		this.yjFuncImg = yjFuncImg;
	}
	public Integer getChildSize() {
		return childSize;
	}
	public void setChildSize(Integer childSize) {
		this.childSize = childSize;
	}
	public List<YjSystemFuncBean> getChildListYjSystemFuncBean() {
		return childListYjSystemFuncBean;
	}
	public void setChildListYjSystemFuncBean(List<YjSystemFuncBean> childListYjSystemFuncBean) {
		this.childListYjSystemFuncBean = childListYjSystemFuncBean;
	}
	public List<YjSystemFuncRescourceBean> getChildListYjSystemFuncRescourceBean() {
		return childListYjSystemFuncRescourceBean;
	}
	public void setChildListYjSystemFuncRescourceBean(List<YjSystemFuncRescourceBean> childListYjSystemFuncRescourceBean) {
		this.childListYjSystemFuncRescourceBean = childListYjSystemFuncRescourceBean;
	}
	
}
