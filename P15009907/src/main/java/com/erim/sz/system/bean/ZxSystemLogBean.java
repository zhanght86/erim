package com.erim.sz.system.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: ZxSystemLogDao 
 * @Description: 客户平台日志管理
 * @author maoxian
 * @date 2015年8月5日 下午6:07:41 
 *
 */
public class ZxSystemLogBean extends BaseBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String  logUsername;
	//创建日期
	private Date    logCreatedate;
	//日志内容
	private String  logContent;
	//用户所做的操作
	private String  logOperation;
	//用户公司Id
	private Integer logUsercpyid;
	//用户ID
	private Integer logUserid;
	//用户名字真实 
	private String  logUserrealname;
	//用户ip
	private String  logIp;
	//路径
	private String  logUrl;
	//resource编码
	private String  logFuncResourceCode;
	//功能编码
	private String  logFuncCode;
	//路径名称
	private String  logResourceName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogUsername() {
		return logUsername;
	}
	public void setLogUsername(String logUsername) {
		this.logUsername = logUsername;
	}
	public Date getLogCreatedate() {
		return logCreatedate;
	}
	public void setLogCreatedate(Date logCreatedate) {
		this.logCreatedate = logCreatedate;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	public String getLogOperation() {
		return logOperation;
	}
	public void setLogOperation(String logOperation) {
		this.logOperation = logOperation;
	}
	public Integer getLogUsercpyid() {
		return logUsercpyid;
	}
	public void setLogUsercpyid(Integer logUsercpyid) {
		this.logUsercpyid = logUsercpyid;
	}
	public Integer getLogUserid() {
		return logUserid;
	}
	public void setLogUserid(Integer logUserid) {
		this.logUserid = logUserid;
	}
	public String getLogUserrealname() {
		return logUserrealname;
	}
	public void setLogUserrealname(String logUserrealname) {
		this.logUserrealname = logUserrealname;
	}
	public String getLogIp() {
		return logIp;
	}
	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}
	public String getLogUrl() {
		return logUrl;
	}
	public void setLogUrl(String logUrl) {
		this.logUrl = logUrl;
	}
	public String getLogFuncResourceCode() {
		return logFuncResourceCode;
	}
	public void setLogFuncResourceCode(String logFuncResourceCode) {
		this.logFuncResourceCode = logFuncResourceCode;
	}
	public String getLogFuncCode() {
		return logFuncCode;
	}
	public void setLogFuncCode(String logFuncCode) {
		this.logFuncCode = logFuncCode;
	}
	public String getLogResourceName() {
		return logResourceName;
	}
	public void setLogResourceName(String logResourceName) {
		this.logResourceName = logResourceName;
	}
	
	
}
