package com.erim.sz.system.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: SellSystemFuncBean 
 * @Description: 模块分类
 * @author maoxian
 * @date 2015年8月1日 下午9:13:06
 */
public class SellSystemFuncBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	//编号
	private String  sellFuncCode;
	//父级编号
	private String  sellFuncParentcode;
	//名称
	private String  sellFuncName;
	//动作
	private String  sellFuncAction;
	//图片路径
	private String  sellFuncImg;
	//排序
	private Integer sellFuncOrder;
	
	
	////////////////////////////////////////////自定义 start ////////////////////////////////////////////////////////////////////
	
	//子级数量
	private Integer childSize;
	
	private List<SellSystemFuncBean> childListSellSystemFuncBean;
	
	private List<SellSystemFuncRescourceBean> childListSellSystemFuncRescourceBean;
	
	////////////////////////////////////////////自定义 end////////////////////////////////////////////////////////////////////
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSellFuncCode() {
		return sellFuncCode;
	}
	public void setSellFuncCode(String sellFuncCode) {
		this.sellFuncCode = sellFuncCode;
	}
	public String getSellFuncParentcode() {
		return sellFuncParentcode;
	}
	public void setSellFuncParentcode(String sellFuncParentcode) {
		this.sellFuncParentcode = sellFuncParentcode;
	}
	public String getSellFuncName() {
		return sellFuncName;
	}
	public void setSellFuncName(String sellFuncName) {
		this.sellFuncName = sellFuncName;
	}
	public String getSellFuncAction() {
		return sellFuncAction;
	}
	public void setSellFuncAction(String sellFuncAction) {
		this.sellFuncAction = sellFuncAction;
	}
	public Integer getSellFuncOrder() {
		return sellFuncOrder;
	}
	public void setSellFuncOrder(Integer sellFuncOrder) {
		this.sellFuncOrder = sellFuncOrder;
	}
	public String getSellFuncImg() {
		return sellFuncImg;
	}
	public void setSellFuncImg(String sellFuncImg) {
		this.sellFuncImg = sellFuncImg;
	}
	public Integer getChildSize() {
		return childSize;
	}
	public void setChildSize(Integer childSize) {
		this.childSize = childSize;
	}
	public List<SellSystemFuncBean> getChildListSellSystemFuncBean() {
		return childListSellSystemFuncBean;
	}
	public void setChildListSellSystemFuncBean(List<SellSystemFuncBean> childListSellSystemFuncBean) {
		this.childListSellSystemFuncBean = childListSellSystemFuncBean;
	}
	public List<SellSystemFuncRescourceBean> getChildListSellSystemFuncRescourceBean() {
		return childListSellSystemFuncRescourceBean;
	}
	public void setChildListSellSystemFuncRescourceBean(List<SellSystemFuncRescourceBean> childListSellSystemFuncRescourceBean) {
		this.childListSellSystemFuncRescourceBean = childListSellSystemFuncRescourceBean;
	}
	
}
