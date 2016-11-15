package com.erim.sz.system.bean;

import java.io.Serializable;

/**
 * @ClassName: ZxSystemRescourceBean 
 * @Description: 权限路径表
 * @author maoxian
 * @date 2015年8月3日 下午1:17:28 
 *
 */
public class ZxSystemRescourceBean implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	//编码
	private String  zxFuncRescourceCode;
	//名称
	private String  zxRescourceName;
	//路径
	private String  zxRescourceUrl;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZxFuncRescourceCode() {
		return zxFuncRescourceCode;
	}
	public void setZxFuncRescourceCode(String zxFuncRescourceCode) {
		this.zxFuncRescourceCode = zxFuncRescourceCode;
	}
	public String getZxRescourceName() {
		return zxRescourceName;
	}
	public void setZxRescourceName(String zxRescourceName) {
		this.zxRescourceName = zxRescourceName;
	}
	public String getZxRescourceUrl() {
		return zxRescourceUrl;
	}
	public void setZxRescourceUrl(String zxRescourceUrl) {
		this.zxRescourceUrl = zxRescourceUrl;
	}
}
