package com.erim.sz.system.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: ZxSystemFuncBean 
 * @Description: 模块分类
 * @author maoxian
 * @date 2015年8月1日 下午9:13:06
 */
public class ZxSystemFuncBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	//编号
	private String  zxFuncCode;
	//父级编号
	private String  zxFuncParentcode;
	//名称
	private String  zxFuncName;
	//动作
	private String  zxFuncAction;
	//图片路径
	private String  zxFuncImg;
	//排序
	private Integer zxFuncOrder;
	
	
	////////////////////////////////////////////自定义 start ////////////////////////////////////////////////////////////////////
	
	//子级数量
	private Integer childSize;
	
	private List<ZxSystemFuncBean> childListZxSystemFuncBean;
	
	private List<ZxSystemFuncRescourceBean> childListZxSystemFuncRescourceBean;
	
	////////////////////////////////////////////自定义 end////////////////////////////////////////////////////////////////////
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZxFuncCode() {
		return zxFuncCode;
	}
	public void setZxFuncCode(String zxFuncCode) {
		this.zxFuncCode = zxFuncCode;
	}
	public String getZxFuncParentcode() {
		return zxFuncParentcode;
	}
	public void setZxFuncParentcode(String zxFuncParentcode) {
		this.zxFuncParentcode = zxFuncParentcode;
	}
	public String getZxFuncName() {
		return zxFuncName;
	}
	public void setZxFuncName(String zxFuncName) {
		this.zxFuncName = zxFuncName;
	}
	public String getZxFuncAction() {
		return zxFuncAction;
	}
	public void setZxFuncAction(String zxFuncAction) {
		this.zxFuncAction = zxFuncAction;
	}
	public Integer getZxFuncOrder() {
		return zxFuncOrder;
	}
	public void setZxFuncOrder(Integer zxFuncOrder) {
		this.zxFuncOrder = zxFuncOrder;
	}
	public String getZxFuncImg() {
		return zxFuncImg;
	}
	public void setZxFuncImg(String zxFuncImg) {
		this.zxFuncImg = zxFuncImg;
	}
	public Integer getChildSize() {
		return childSize;
	}
	public void setChildSize(Integer childSize) {
		this.childSize = childSize;
	}
	public List<ZxSystemFuncBean> getChildListZxSystemFuncBean() {
		return childListZxSystemFuncBean;
	}
	public void setChildListZxSystemFuncBean(List<ZxSystemFuncBean> childListZxSystemFuncBean) {
		this.childListZxSystemFuncBean = childListZxSystemFuncBean;
	}
	public List<ZxSystemFuncRescourceBean> getChildListZxSystemFuncRescourceBean() {
		return childListZxSystemFuncRescourceBean;
	}
	public void setChildListZxSystemFuncRescourceBean(List<ZxSystemFuncRescourceBean> childListZxSystemFuncRescourceBean) {
		this.childListZxSystemFuncRescourceBean = childListZxSystemFuncRescourceBean;
	}
	
}
