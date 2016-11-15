package com.erim.sz.bean;

import java.io.Serializable;

/**
 * 
 * @ClassName: TrSystemOperateLogBean
 * @Description: 日志管理
 * @author maoxian
 * @date 2015年7月14日 下午5:50:43
 *
 */
public class TrSystemOperateLogBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化id
	 */
	private static final long serialVersionUID = 1L;
	// 自增ID
	private Integer operateId;
	// 功能ID(FK)
	private String funcId;
	// 用户ID(FK)
	private String userId;
	// 操作时间
	private String operateIp;
	// 操作IP
	private String operateTime;
	private String operateDetail;

	// /////////////////////////////// 自定义列 //////////////////////////
	// 功能名称
	private String funcName;
	// 用户账号
	private String userName;
	// 用户名
	private String userRealname;

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRealname() {
		return userRealname;
	}

	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}

	public Integer getOperateId() {
		return operateId;
	}

	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOperateIp() {
		return operateIp;
	}

	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperateDetail() {
		return operateDetail;
	}

	public void setOperateDetail(String operateDetail) {
		this.operateDetail = operateDetail;
	}

}
