package com.erim.sz.system.bean;

import java.io.Serializable;

/**
 * @ClassName: SellSystemRescourceBean 
 * @Description: 权限路径表
 * @author maoxian
 * @date 2015年8月3日 下午1:17:28 
 *
 */
public class SellSystemRescourceBean implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	//编码
	private String  sellFuncRescourceCode;
	//名称
	private String  sellRescourceName;
	//路径
	private String  sellRescourceUrl;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSellFuncRescourceCode() {
		return sellFuncRescourceCode;
	}
	public void setSellFuncRescourceCode(String sellFuncRescourceCode) {
		this.sellFuncRescourceCode = sellFuncRescourceCode;
	}
	public String getSellRescourceName() {
		return sellRescourceName;
	}
	public void setSellRescourceName(String sellRescourceName) {
		this.sellRescourceName = sellRescourceName;
	}
	public String getSellRescourceUrl() {
		return sellRescourceUrl;
	}
	public void setSellRescourceUrl(String sellRescourceUrl) {
		this.sellRescourceUrl = sellRescourceUrl;
	}
}
