package com.erim.sz.common.bean;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: HotalMeetingBean
 * @Description: 酒店餐厅
 * @author 龙龙
 * @date 2015年7月20日 下午10:23
 *
 */
public class HotelCefeteriaBean extends BaseBean{
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//酒店id
	private Integer tdlId;
	//餐厅名称
	private String  hmgCafeterianame;
	//餐厅类型
	private String  hmgCafeteriatype;
	//餐厅面积
	private String  hmgCafeteriaarea;
	//餐厅可容纳人数
	private String  hmgCafeterianum;
	//餐厅可容纳人数至对少人
	private String  hmgCafeterianumend;
	//餐厅图片
	private String hmgCafeteriaimg;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTdlId() {
		return tdlId;
	}
	public void setTdlId(Integer tdlId) {
		this.tdlId = tdlId;
	}
	public String getHmgCafeterianame() {
		return hmgCafeterianame;
	}
	public void setHmgCafeterianame(String hmgCafeterianame) {
		this.hmgCafeterianame = hmgCafeterianame;
	}
	public String getHmgCafeteriatype() {
		return hmgCafeteriatype;
	}
	public void setHmgCafeteriatype(String hmgCafeteriatype) {
		this.hmgCafeteriatype = hmgCafeteriatype;
	}
	public String getHmgCafeteriaarea() {
		return hmgCafeteriaarea;
	}
	public void setHmgCafeteriaarea(String hmgCafeteriaarea) {
		this.hmgCafeteriaarea = hmgCafeteriaarea;
	}
	public String getHmgCafeterianum() {
		return hmgCafeterianum;
	}
	public void setHmgCafeterianum(String hmgCafeterianum) {
		this.hmgCafeterianum = hmgCafeterianum;
	}
	public String getHmgCafeterianumend() {
		return hmgCafeterianumend;
	}
	public void setHmgCafeterianumend(String hmgCafeterianumend) {
		this.hmgCafeterianumend = hmgCafeterianumend;
	}
	public String getHmgCafeteriaimg() {
		return hmgCafeteriaimg;
	}
	public void setHmgCafeteriaimg(String hmgCafeteriaimg) {
		this.hmgCafeteriaimg = hmgCafeteriaimg;
	}
	
	
	
}
