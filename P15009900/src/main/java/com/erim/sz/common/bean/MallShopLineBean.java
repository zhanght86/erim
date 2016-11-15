package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: MailShopBean 
 * @Description: 旅游商城
 * @author maoxian
 * @date 2015年11月1日 下午11:36:45
 */
public class MallShopLineBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer  id;
	//企业id
	private Integer  cpyId;
	//shop父级id
	private Integer  mspId1;
	//子集id
	private Integer  mspId2;
	//专线id
	private Integer  mslLineid;
	//专线所属企业id
	private Integer  mslCpyid;
	//创建时间
	private Date     mslCreatetime;
	//创建用户 
	private String   mslCreateuser;
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
	public Integer getMspId1() {
		return mspId1;
	}
	public void setMspId1(Integer mspId1) {
		this.mspId1 = mspId1;
	}
	public Integer getMspId2() {
		return mspId2;
	}
	public void setMspId2(Integer mspId2) {
		this.mspId2 = mspId2;
	}
	public Integer getMslLineid() {
		return mslLineid;
	}
	public void setMslLineid(Integer mslLineid) {
		this.mslLineid = mslLineid;
	}
	public Integer getMslCpyid() {
		return mslCpyid;
	}
	public void setMslCpyid(Integer mslCpyid) {
		this.mslCpyid = mslCpyid;
	}
	public Date getMslCreatetime() {
		return mslCreatetime;
	}
	public void setMslCreatetime(Date mslCreatetime) {
		this.mslCreatetime = mslCreatetime;
	}
	public String getMslCreateuser() {
		return mslCreateuser;
	}
	public void setMslCreateuser(String mslCreateuser) {
		this.mslCreateuser = mslCreateuser;
	}
}
