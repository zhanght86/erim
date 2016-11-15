package com.erim.sz.zy.bean;

import java.io.Serializable;

/**
 * @ClassName: ZySystemRescourceBean 
 * @Description: 权限路径表
 * @author maoxian
 * @date 2015年8月3日 下午1:17:28 
 *
 */
public class ZySystemRescourceBean implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	//编码
	private String  zyFuncRescourceCode;
	//名称
	private String  zyRescourceName;
	//路径
	private String  zyRescourceUrl;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZyFuncRescourceCode() {
		return zyFuncRescourceCode;
	}
	public void setZyFuncRescourceCode(String zyFuncRescourceCode) {
		this.zyFuncRescourceCode = zyFuncRescourceCode;
	}
	public String getZyRescourceName() {
		return zyRescourceName;
	}
	public void setZyRescourceName(String zyRescourceName) {
		this.zyRescourceName = zyRescourceName;
	}
	public String getZyRescourceUrl() {
		return zyRescourceUrl;
	}
	public void setZyRescourceUrl(String zyRescourceUrl) {
		this.zyRescourceUrl = zyRescourceUrl;
	}
}
