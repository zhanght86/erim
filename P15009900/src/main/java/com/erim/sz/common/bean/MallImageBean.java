package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: MallBean 
 * @Description: 组团社大图
 * @author maoxian
 * @date 2015年12月3日 下午8:47:21
 */
public class MallImageBean  extends BaseBean implements Serializable {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//图片路径 
	private String  mieImageurl;
	//创建时间
	private Date    mieCreatetime;
	//创建用户
	private String  mieCreateuser;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMieImageurl() {
		return mieImageurl;
	}
	public void setMieImageurl(String mieImageurl) {
		this.mieImageurl = mieImageurl;
	}
	public Date getMieCreatetime() {
		return mieCreatetime;
	}
	public void setMieCreatetime(Date mieCreatetime) {
		this.mieCreatetime = mieCreatetime;
	}
	public String getMieCreateuser() {
		return mieCreateuser;
	}
	public void setMieCreateuser(String mieCreateuser) {
		this.mieCreateuser = mieCreateuser;
	}
}
