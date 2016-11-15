package com.erim.sz.system.bean;

import java.io.Serializable;

/**
 * @ClassName: YjSystemRescourceBean 
 * @Description: 权限路径表
 * @author maoxian
 * @date 2015年8月3日 下午1:17:28 
 *
 */
public class YjSystemRescourceBean implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	//编码
	private String  yjFuncRescourceCode;
	//名称
	private String  yjRescourceName;
	//路径
	private String  yjRescourceUrl;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYjFuncRescourceCode() {
		return yjFuncRescourceCode;
	}
	public void setYjFuncRescourceCode(String yjFuncRescourceCode) {
		this.yjFuncRescourceCode = yjFuncRescourceCode;
	}
	public String getYjRescourceName() {
		return yjRescourceName;
	}
	public void setYjRescourceName(String yjRescourceName) {
		this.yjRescourceName = yjRescourceName;
	}
	public String getYjRescourceUrl() {
		return yjRescourceUrl;
	}
	public void setYjRescourceUrl(String yjRescourceUrl) {
		this.yjRescourceUrl = yjRescourceUrl;
	}
}
