package com.erim.sz.cus.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: CusSystemFuncBean 
 * @Description: 模块分类
 * @author maoxian
 * @date 2015年8月1日 下午9:13:06
 */
public class CusSystemFuncBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	//编号
	private String  cusFuncCode;
	//父级编号
	private String  cusFuncParentcode;
	//名称
	private String  cusFuncName;
	//动作
	private String  cusFuncAction;
	//图片路径
	private String  cusFuncImg;
	//排序
	private Integer cusFuncOrder;
	
	
	////////////////////////////////////////////自定义 start ////////////////////////////////////////////////////////////////////
	
	//子级数量
	private Integer childSize;
	
	private List<CusSystemFuncBean> childListCusSystemFuncBean;
	
	private List<CusSystemFuncRescourceBean> childListCusSystemFuncRescourceBean;
	
	////////////////////////////////////////////自定义 end////////////////////////////////////////////////////////////////////
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCusFuncCode() {
		return cusFuncCode;
	}
	public void setCusFuncCode(String cusFuncCode) {
		this.cusFuncCode = cusFuncCode;
	}
	public String getCusFuncParentcode() {
		return cusFuncParentcode;
	}
	public void setCusFuncParentcode(String cusFuncParentcode) {
		this.cusFuncParentcode = cusFuncParentcode;
	}
	public String getCusFuncName() {
		return cusFuncName;
	}
	public void setCusFuncName(String cusFuncName) {
		this.cusFuncName = cusFuncName;
	}
	public String getCusFuncAction() {
		return cusFuncAction;
	}
	public void setCusFuncAction(String cusFuncAction) {
		this.cusFuncAction = cusFuncAction;
	}
	public Integer getCusFuncOrder() {
		return cusFuncOrder;
	}
	public void setCusFuncOrder(Integer cusFuncOrder) {
		this.cusFuncOrder = cusFuncOrder;
	}
	public String getCusFuncImg() {
		return cusFuncImg;
	}
	public void setCusFuncImg(String cusFuncImg) {
		this.cusFuncImg = cusFuncImg;
	}
	public Integer getChildSize() {
		return childSize;
	}
	public void setChildSize(Integer childSize) {
		this.childSize = childSize;
	}
	public List<CusSystemFuncBean> getChildListCusSystemFuncBean() {
		return childListCusSystemFuncBean;
	}
	public void setChildListCusSystemFuncBean(List<CusSystemFuncBean> childListCusSystemFuncBean) {
		this.childListCusSystemFuncBean = childListCusSystemFuncBean;
	}
	public List<CusSystemFuncRescourceBean> getChildListCusSystemFuncRescourceBean() {
		return childListCusSystemFuncRescourceBean;
	}
	public void setChildListCusSystemFuncRescourceBean(List<CusSystemFuncRescourceBean> childListCusSystemFuncRescourceBean) {
		this.childListCusSystemFuncRescourceBean = childListCusSystemFuncRescourceBean;
	}
	
}
