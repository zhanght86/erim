package com.erim.sz.zy.bean;

import java.io.Serializable;

/**
 * 
 * @ClassName: ZySystemFuncRescource 
 * @Description: 角色权限
 * @author maoxian
 * @date 2015年8月2日 上午12:54:07
 */
public class ZySystemFuncRescourceBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//编码
	private String  zyFuncCode;
	private String  zyFuncRescourceCode;
	//操作名称
	private String  zyFuncRescourceName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getZyFuncCode() {
		return zyFuncCode;
	}
	public void setZyFuncCode(String zyFuncCode) {
		this.zyFuncCode = zyFuncCode;
	}
	public String getZyFuncRescourceCode() {
		return zyFuncRescourceCode;
	}
	public void setZyFuncRescourceCode(String zyFuncRescourceCode) {
		this.zyFuncRescourceCode = zyFuncRescourceCode;
	}
	public String getZyFuncRescourceName() {
		return zyFuncRescourceName;
	}
	public void setZyFuncRescourceName(String zyFuncRescourceName) {
		this.zyFuncRescourceName = zyFuncRescourceName;
	}
	
}
