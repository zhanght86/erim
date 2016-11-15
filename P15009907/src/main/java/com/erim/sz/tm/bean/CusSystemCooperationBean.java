package com.erim.sz.tm.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: CusSystemCooperationBean 
 * @Description: 合作用户权限设置 
 * @author maoxian
 * @date 2015年11月5日 上午2:02:12
 */
public class CusSystemCooperationBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//角色id
	private Integer roleId;
	//企业id
	private Integer cpyId;
	//类别
	private String  cooNtype;
	//产品id
	private Integer cooCid;
	//创建时间
	private Date    cooCreatetime;
	//创建用户
	private String  cooCreateuser;
	
	///////////////////////////////////////// 自定义转义字段开始 ///////////////////////////////////////
	
	private String rolename;
	
	///////////////////////////////////////// 自定义转义字段结束 ///////////////////////////////////////
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getCooNtype() {
		return cooNtype;
	}
	public void setCooNtype(String cooNtype) {
		this.cooNtype = cooNtype;
	}
	public Integer getCooCid() {
		return cooCid;
	}
	public void setCooCid(Integer cooCid) {
		this.cooCid = cooCid;
	}
	public Date getCooCreatetime() {
		return cooCreatetime;
	}
	public void setCooCreatetime(Date cooCreatetime) {
		this.cooCreatetime = cooCreatetime;
	}
	public String getCooCreateuser() {
		return cooCreateuser;
	}
	public void setCooCreateuser(String cooCreateuser) {
		this.cooCreateuser = cooCreateuser;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
}
