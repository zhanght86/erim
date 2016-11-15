package com.erim.sz.cus.bean;

import java.io.Serializable;

/**
 * @ClassName: CusSystemRescourceBean 
 * @Description: 权限路径表
 * @author maoxian
 * @date 2015年8月3日 下午1:17:28 
 *
 */
public class CusSystemRescourceBean implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	//编码
	private String  cusFuncRescourceCode;
	//名称
	private String  cusRescourceName;
	//路径
	private String  cusRescourceUrl;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCusFuncRescourceCode() {
		return cusFuncRescourceCode;
	}
	public void setCusFuncRescourceCode(String cusFuncRescourceCode) {
		this.cusFuncRescourceCode = cusFuncRescourceCode;
	}
	public String getCusRescourceName() {
		return cusRescourceName;
	}
	public void setCusRescourceName(String cusRescourceName) {
		this.cusRescourceName = cusRescourceName;
	}
	public String getCusRescourceUrl() {
		return cusRescourceUrl;
	}
	public void setCusRescourceUrl(String cusRescourceUrl) {
		this.cusRescourceUrl = cusRescourceUrl;
	}
}
