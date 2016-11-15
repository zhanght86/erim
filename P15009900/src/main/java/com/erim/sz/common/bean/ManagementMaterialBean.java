package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: ManagementMaterialBean 
 * @Description: 签证材料
 * @author maoxian
 * @date 2015年11月22日 下午11:53:01
 */
public class ManagementMaterialBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//企业ID
	private Integer cpyId;
	//签证ID
	private Integer mdlId;
	//材料名称
	private String  mmlMaterial;
	//材料说明
	private String  mmlKnow;
	//传文本
	private String  mmlText;
	//上传图片
	private String  mmlImg;
	//创建时间
	private Date    mmlCreatetime;
	//分类 
	private String  mmlNtype;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMdlId() {
		return mdlId;
	}
	public void setMdlId(Integer mdlId) {
		this.mdlId = mdlId;
	}
	public String getMmlMaterial() {
		return mmlMaterial;
	}
	public void setMmlMaterial(String mmlMaterial) {
		this.mmlMaterial = mmlMaterial;
	}
	public String getMmlKnow() {
		return mmlKnow;
	}
	public void setMmlKnow(String mmlKnow) {
		this.mmlKnow = mmlKnow;
	}
	public String getMmlText() {
		return mmlText;
	}
	public void setMmlText(String mmlText) {
		this.mmlText = mmlText;
	}
	public String getMmlImg() {
		return mmlImg;
	}
	public void setMmlImg(String mmlImg) {
		this.mmlImg = mmlImg;
	}
	public String getMmlNtype() {
		return mmlNtype;
	}
	public void setMmlNtype(String mmlNtype) {
		this.mmlNtype = mmlNtype;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public Date getMmlCreatetime() {
		return mmlCreatetime;
	}
	public void setMmlCreatetime(Date mmlCreatetime) {
		this.mmlCreatetime = mmlCreatetime;
	}
}
