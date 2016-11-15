package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.List;

import com.erim.core.bean.BaseBean;
import com.erim.web.bean.CodeBean;

/**
 * @ClassName: MailShopBean 
 * @Description: 旅游商城
 * @author maoxian
 * @date 2015年11月1日 下午11:36:45
 */
public class MallShopBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	//一级标题
	private String  mspName;
	//等级
	private Integer mspLevel;
	//父级id
	private Integer mspId;
	//排序
	private Integer mspOrder;
	//编码
	private String  mspNo;
	//图片class
	private String  mspImgClass;
	
	/////////////////////////////////////////// 自定义字段 start  //////////////////////////////////////////////////
	
	//数组
	private List<CodeBean> listCode;
	//查询参数
	private String         queryLink;
	
	/////////////////////////////////////////// 自定义字段 end  ////////////////////////////////////////////////////
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMspName() {
		return mspName;
	}
	public void setMspName(String mspName) {
		this.mspName = mspName;
	}
	public Integer getMspLevel() {
		return mspLevel;
	}
	public void setMspLevel(Integer mspLevel) {
		this.mspLevel = mspLevel;
	}
	public Integer getMspId() {
		return mspId;
	}
	public void setMspId(Integer mspId) {
		this.mspId = mspId;
	}
	public Integer getMspOrder() {
		return mspOrder;
	}
	public void setMspOrder(Integer mspOrder) {
		this.mspOrder = mspOrder;
	}
	public String getMspNo() {
		return mspNo;
	}
	public void setMspNo(String mspNo) {
		this.mspNo = mspNo;
	}
	public String getMspImgClass() {
		return mspImgClass;
	}
	public void setMspImgClass(String mspImgClass) {
		this.mspImgClass = mspImgClass;
	}
	public List<CodeBean> getListCode() {
		return listCode;
	}
	public void setListCode(List<CodeBean> listCode) {
		this.listCode = listCode;
	}
	public String getQueryLink() {
		return queryLink;
	}
	public void setQueryLink(String queryLink) {
		this.queryLink = queryLink;
	}
}
