package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: MallDestinationBean 
 * @Description: 商城目的地s
 * @author maoxian
 * @date 2015年11月11日 下午6:14:14 
 *
 */
public class MallDestinationBean  implements Serializable{
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	//主键
	private Integer id;
	//公司id
	private Integer cpyId;
	//栏目
	private String  mdnName;
	//创建时间
	private Date    mdnCreatetime;
	
	//区域等级   ：00-国内 01-香港 02-澳门 03-台湾 04-国际
	private String  mdnRegionLevel;
	//国内省市县编码
	private String  mdnRegionCode;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getMdnName() {
		return mdnName;
	}
	public void setMdnName(String mdnName) {
		this.mdnName = mdnName;
	}
	public Date getMdnCreatetime() {
		return mdnCreatetime;
	}
	public void setMdnCreatetime(Date mdnCreatetime) {
		this.mdnCreatetime = mdnCreatetime;
	}
	public String getMdnRegionLevel() {
		return mdnRegionLevel;
	}
	public void setMdnRegionLevel(String mdnRegionLevel) {
		this.mdnRegionLevel = mdnRegionLevel;
	}
	public String getMdnRegionCode() {
		return mdnRegionCode;
	}
	public void setMdnRegionCode(String mdnRegionCode) {
		this.mdnRegionCode = mdnRegionCode;
	}
	
}
