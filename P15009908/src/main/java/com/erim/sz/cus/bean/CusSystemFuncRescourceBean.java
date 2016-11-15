package com.erim.sz.cus.bean;

import java.io.Serializable;

/**
 * 
 * @ClassName: CusSystemFuncRescource 
 * @Description: 角色权限
 * @author maoxian
 * @date 2015年8月2日 上午12:54:07
 */
public class CusSystemFuncRescourceBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//编码
	private String  cusFuncCode;
	private String  cusFuncRescourceCode;
	//操作名称
	private String  cusFuncRescourceName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCusFuncCode() {
		return cusFuncCode;
	}
	public void setCusFuncCode(String cusFuncCode) {
		this.cusFuncCode = cusFuncCode;
	}
	public String getCusFuncRescourceCode() {
		return cusFuncRescourceCode;
	}
	public void setCusFuncRescourceCode(String cusFuncRescourceCode) {
		this.cusFuncRescourceCode = cusFuncRescourceCode;
	}
	public String getCusFuncRescourceName() {
		return cusFuncRescourceName;
	}
	public void setCusFuncRescourceName(String cusFuncRescourceName) {
		this.cusFuncRescourceName = cusFuncRescourceName;
	}
	
}
