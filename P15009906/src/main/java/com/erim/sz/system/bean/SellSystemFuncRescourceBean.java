package com.erim.sz.system.bean;

import java.io.Serializable;

/**
 * 
 * @ClassName: SellSystemFuncRescource 
 * @Description: 角色权限
 * @author maoxian
 * @date 2015年8月2日 上午12:54:07
 */
public class SellSystemFuncRescourceBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//编码
	private String  sellFuncCode;
	private String  sellFuncRescourceCode;
	//操作名称
	private String  sellFuncRescourceName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSellFuncCode() {
		return sellFuncCode;
	}
	public void setSellFuncCode(String sellFuncCode) {
		this.sellFuncCode = sellFuncCode;
	}
	public String getSellFuncRescourceCode() {
		return sellFuncRescourceCode;
	}
	public void setSellFuncRescourceCode(String sellFuncRescourceCode) {
		this.sellFuncRescourceCode = sellFuncRescourceCode;
	}
	public String getSellFuncRescourceName() {
		return sellFuncRescourceName;
	}
	public void setSellFuncRescourceName(String sellFuncRescourceName) {
		this.sellFuncRescourceName = sellFuncRescourceName;
	}
	
}
