package com.erim.sz.zy.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: ZySystemFuncBean 
 * @Description: 模块分类
 * @author maoxian
 * @date 2015年8月1日 下午9:13:06
 */
public class ZySystemFuncBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	//编号
	private String  zyFuncCode;
	//父级编号
	private String  zyFuncParentcode;
	//名称
	private String  zyFuncName;
	//动作
	private String  zyFuncAction;
	//图片路径
	private String  zyFuncImg;
	//排序
	private Integer zyFuncOrder;
	
	
	////////////////////////////////////////////自定义 start ////////////////////////////////////////////////////////////////////
	
	//子级数量
	private Integer childSize;
	
	private List<ZySystemFuncBean> childListZySystemFuncBean;
	
	private List<ZySystemFuncRescourceBean> childListZySystemFuncRescourceBean;
	
	////////////////////////////////////////////自定义 end////////////////////////////////////////////////////////////////////
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZyFuncCode() {
		return zyFuncCode;
	}
	public void setZyFuncCode(String zyFuncCode) {
		this.zyFuncCode = zyFuncCode;
	}
	public String getZyFuncParentcode() {
		return zyFuncParentcode;
	}
	public void setZyFuncParentcode(String zyFuncParentcode) {
		this.zyFuncParentcode = zyFuncParentcode;
	}
	public String getZyFuncName() {
		return zyFuncName;
	}
	public void setZyFuncName(String zyFuncName) {
		this.zyFuncName = zyFuncName;
	}
	public String getZyFuncAction() {
		return zyFuncAction;
	}
	public void setZyFuncAction(String zyFuncAction) {
		this.zyFuncAction = zyFuncAction;
	}
	public Integer getZyFuncOrder() {
		return zyFuncOrder;
	}
	public void setZyFuncOrder(Integer zyFuncOrder) {
		this.zyFuncOrder = zyFuncOrder;
	}
	public String getZyFuncImg() {
		return zyFuncImg;
	}
	public void setZyFuncImg(String zyFuncImg) {
		this.zyFuncImg = zyFuncImg;
	}
	public Integer getChildSize() {
		return childSize;
	}
	public void setChildSize(Integer childSize) {
		this.childSize = childSize;
	}
	public List<ZySystemFuncBean> getChildListZySystemFuncBean() {
		return childListZySystemFuncBean;
	}
	public void setChildListZySystemFuncBean(List<ZySystemFuncBean> childListZySystemFuncBean) {
		this.childListZySystemFuncBean = childListZySystemFuncBean;
	}
	public List<ZySystemFuncRescourceBean> getChildListZySystemFuncRescourceBean() {
		return childListZySystemFuncRescourceBean;
	}
	public void setChildListZySystemFuncRescourceBean(List<ZySystemFuncRescourceBean> childListZySystemFuncRescourceBean) {
		this.childListZySystemFuncRescourceBean = childListZySystemFuncRescourceBean;
	}
	
}
