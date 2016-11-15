package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: MallThemeBean 
 * @Description: 主题推荐
 * @author maoxian
 * @date 2015年12月4日 上午12:20:48
 */
public class MallThemeBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	//企业id
	private Integer cpyId;
	//1周末2海岛3游轮4夕阳红5蜜月6旅游购
	private String  mteNtype;
	//专线id
	private Integer lineId;
	//创建时间
	private Date    mteCreatetime;
	//创建用户
	private String  mteCreateuser;
	
	//主题名称
	private String  mteNtypeName;
	
	
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
	public String getMteNtype() {
		return mteNtype;
	}
	public void setMteNtype(String mteNtype) {
		this.mteNtype = mteNtype;
	}
	public Integer getLineId() {
		return lineId;
	}
	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}
	public Date getMteCreatetime() {
		return mteCreatetime;
	}
	public void setMteCreatetime(Date mteCreatetime) {
		this.mteCreatetime = mteCreatetime;
	}
	public String getMteCreateuser() {
		return mteCreateuser;
	}
	public void setMteCreateuser(String mteCreateuser) {
		this.mteCreateuser = mteCreateuser;
	}
	
	public String getMteNtypeName() {
		return mteNtypeName;
	}
	public void setMteNtypeName(String mteNtypeName) {
		this.mteNtypeName = mteNtypeName;
	}
	
	
}
