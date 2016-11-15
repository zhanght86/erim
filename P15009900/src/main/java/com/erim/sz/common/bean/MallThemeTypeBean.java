package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @类名: MallThemeTypeBean
 * @描述: 商城所选择的主题类别
 * @作者: 国亚文
 * @创建时间: 2015年12月25日 下午4:01:51
 */

public class MallThemeTypeBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//企业id
	private Integer cpyId;
	//与字典对应
	private String  theme_type_id;
	//创建时间
	private Date    mteCreatetime;	
	//主题名称
	private String  mteNtypeName;	
	
	//操作类型
	private String  InsertOrDelete=""; //空值，不操作；0-删除 1-增加
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getTheme_type_id() {
		return theme_type_id;
	}
	public void setTheme_type_id(String theme_type_id) {
		this.theme_type_id = theme_type_id;
	}
	public Date getMteCreatetime() {
		return mteCreatetime;
	}
	public void setMteCreatetime(Date mteCreatetime) {
		this.mteCreatetime = mteCreatetime;
	}
	public String getMteNtypeName() {
		return mteNtypeName;
	}
	public void setMteNtypeName(String mteNtypeName) {
		this.mteNtypeName = mteNtypeName;
	}
	public String getInsertOrDelete() {
		return InsertOrDelete;
	}
	public void setInsertOrDelete(String insertOrDelete) {
		InsertOrDelete = insertOrDelete;
	}	
		
}
