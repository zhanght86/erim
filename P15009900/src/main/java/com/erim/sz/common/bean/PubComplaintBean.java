package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/***
 * 
 * @ClassName: PubComplaintBean
 * @Description: 投诉管理
 * @author 龙龙
 * @date 2015年7月23日 下午4:53:15
 *
 */
public class PubComplaintBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	// 投诉公司ID
	private Integer cpyId;
	// 投诉内容
	private String pbcCommnet;
	// 投诉人
	private String pbcCreateuser;
	// 投诉时间
	private Date pbcCreatetime;
	// 是否处理
	private String pbcIsHandle;
	// 处理人
	private String pbcHandler;

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

	public String getPbcCommnet() {
		return pbcCommnet;
	}

	public void setPbcCommnet(String pbcCommnet) {
		this.pbcCommnet = pbcCommnet;
	}

	public String getPbcCreateuser() {
		return pbcCreateuser;
	}

	public void setPbcCreateuser(String pbcCreateuser) {
		this.pbcCreateuser = pbcCreateuser;
	}

	public Date getPbcCreatetime() {
		return pbcCreatetime;
	}

	public void setPbcCreatetime(Date pbcCreatetime) {
		this.pbcCreatetime = pbcCreatetime;
	}

	public String getPbcIsHandle() {
		return pbcIsHandle;
	}

	public void setPbcIsHandle(String pbcIsHandle) {
		this.pbcIsHandle = pbcIsHandle;
	}

	public String getPbcHandler() {
		return pbcHandler;
	}

	public void setPbcHandler(String pbcHandler) {
		this.pbcHandler = pbcHandler;
	}

}
