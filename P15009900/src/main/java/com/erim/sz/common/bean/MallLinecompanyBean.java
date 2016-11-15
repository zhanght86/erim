package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: MallLinecompanyBean 
 * @Description: 商城选择专线 
 * @author maoxian
 * @date 2015年11月11日 下午10:59:35 
 *
 */
public class MallLinecompanyBean  implements Serializable{
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//企业id
	private Integer cpyId;
	//一级id
	private Integer mspId1;
	//二级id
	private Integer mspId2;
	//合作企业id
	private Integer mspCpyId;
	//合作时间
	private Date    mspCreatetime;
	//创建用户
	private String  mspCreateuser;
	
	
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
	public Integer getMspCpyId() {
		return mspCpyId;
	}
	public void setMspCpyId(Integer mspCpyId) {
		this.mspCpyId = mspCpyId;
	}
	public Date getMspCreatetime() {
		return mspCreatetime;
	}
	public void setMspCreatetime(Date mspCreatetime) {
		this.mspCreatetime = mspCreatetime;
	}
	public String getMspCreateuser() {
		return mspCreateuser;
	}
	public void setMspCreateuser(String mspCreateuser) {
		this.mspCreateuser = mspCreateuser;
	}
}
