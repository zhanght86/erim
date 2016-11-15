/**    
 * 文件名：GuideScheduleBean.java    
 *    
 * 版本信息：    
 * 日期：2015年7月12日    
 *    
 */
package com.erim.sz.common.bean;

import java.io.Serializable;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: GuideScheduleBean 
 * @Description: 导游档期、金额
 * @author maoxian
 * @date 2015年9月11日 下午3:30:21 
 *
 */
public class GuideScheduleBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = -5641810469791731222L;

	private Integer id;
	//开始时间
	private String  gseDateStart;
	//是否空闲
	private String  gseIsFree;
	//导游ID
	private Integer gdlId;
	//结束时间
	private String  gseDateEnd;
	//金额
	private Integer gsePrice;
	//1是档期 2 金额
	private String  gseNtype;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGseDateStart() {
		return gseDateStart;
	}
	public void setGseDateStart(String gseDateStart) {
		this.gseDateStart = gseDateStart;
	}
	public String getGseIsFree() {
		return gseIsFree;
	}
	public void setGseIsFree(String gseIsFree) {
		this.gseIsFree = gseIsFree;
	}
	public Integer getGdlId() {
		return gdlId;
	}
	public void setGdlId(Integer gdlId) {
		this.gdlId = gdlId;
	}
	public String getGseDateEnd() {
		return gseDateEnd;
	}
	public void setGseDateEnd(String gseDateEnd) {
		this.gseDateEnd = gseDateEnd;
	}
	public Integer getGsePrice() {
		return gsePrice;
	}
	public void setGsePrice(Integer gsePrice) {
		this.gsePrice = gsePrice;
	}
	public String getGseNtype() {
		return gseNtype;
	}
	public void setGseNtype(String gseNtype) {
		this.gseNtype = gseNtype;
	}
}
