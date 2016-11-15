package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: CafeteriaDetailBean
 * @Description: 特色餐管理
 * @author 陈鹏
 * @date 2015年7月11日 下午1:19:24
 *
 */
public class MessageProjectBean extends BaseBean implements Serializable {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//产品id
	private Integer cid;
	//产品类型
	private String mptNtype;
	//生产商短信定制页面
	private String mptRemarkCrm;
	//组团社短信定制页面
	private String mptRemarkSell;
	//创建时间
	private Date mptCreatetime;
	//创建用户
	private String mptCreateuser;
	//企业id
	private Integer cpyId;
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getMptNtype() {
		return mptNtype;
	}
	public void setMptNtype(String mptNtype) {
		this.mptNtype = mptNtype;
	}
	public String getMptRemarkCrm() {
		return mptRemarkCrm;
	}
	public void setMptRemarkCrm(String mptRemarkCrm) {
		this.mptRemarkCrm = mptRemarkCrm;
	}
	public String getMptRemarkSell() {
		return mptRemarkSell;
	}
	public void setMptRemarkSell(String mptRemarkSell) {
		this.mptRemarkSell = mptRemarkSell;
	}
	public Date getMptCreatetime() {
		return mptCreatetime;
	}
	public void setMptCreatetime(Date mptCreatetime) {
		this.mptCreatetime = mptCreatetime;
	}
	public String getMptCreateuser() {
		return mptCreateuser;
	}
	public void setMptCreateuser(String mptCreateuser) {
		this.mptCreateuser = mptCreateuser;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}

}
