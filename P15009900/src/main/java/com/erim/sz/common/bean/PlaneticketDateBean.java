package com.erim.sz.common.bean;

import java.io.Serializable;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: PlaneticketDetailBean 
 * @Description: 机票出发日期
 * @author maoxian
 * @date 2015年10月22日 下午8:50:10
 */
public class PlaneticketDateBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer ptdId;
	
	private String  pteDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPtdId() {
		return ptdId;
	}

	public void setPtdId(Integer ptdId) {
		this.ptdId = ptdId;
	}

	public String getPteDate() {
		return pteDate;
	}

	public void setPteDate(String pteDate) {
		this.pteDate = pteDate;
	}
}