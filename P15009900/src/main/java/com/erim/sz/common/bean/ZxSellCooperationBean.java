package com.erim.sz.common.bean;

import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: ZxSellCooperationBean 
 * @Description: 专线 组团合作管理
 * @author maoxian
 * @date 2015年12月8日 下午3:41:38
 */
public class ZxSellCooperationBean extends BaseBean {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//产品id
	private Integer cid;
	//专线id
	private Integer cpyId;
	//组团社id
	private Integer sellCpyId;
	//是否合作
	private String  zscIsCoopertion;
	//创建时间
	private Date    zscCreatetime;
	//创建用户
	private String  zscCreateuser;
	//合作时间
	private Date    zscCooperiontime;
	//合作用户
	private String  zscCooperionuser;
	
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
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
	public Integer getSellCpyId() {
		return sellCpyId;
	}
	public void setSellCpyId(Integer sellCpyId) {
		this.sellCpyId = sellCpyId;
	}
	public String getZscIsCoopertion() {
		return zscIsCoopertion;
	}
	public void setZscIsCoopertion(String zscIsCoopertion) {
		this.zscIsCoopertion = zscIsCoopertion;
	}
	public Date getZscCreatetime() {
		return zscCreatetime;
	}
	public void setZscCreatetime(Date zscCreatetime) {
		this.zscCreatetime = zscCreatetime;
	}
	public String getZscCreateuser() {
		return zscCreateuser;
	}
	public void setZscCreateuser(String zscCreateuser) {
		this.zscCreateuser = zscCreateuser;
	}
	public Date getZscCooperiontime() {
		return zscCooperiontime;
	}
	public void setZscCooperiontime(Date zscCooperiontime) {
		this.zscCooperiontime = zscCooperiontime;
	}
	public String getZscCooperionuser() {
		return zscCooperionuser;
	}
	public void setZscCooperionuser(String zscCooperionuser) {
		this.zscCooperionuser = zscCooperionuser;
	}
}
