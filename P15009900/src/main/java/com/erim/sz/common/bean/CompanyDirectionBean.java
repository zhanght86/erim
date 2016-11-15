package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: CompanyDirectionBean 
 * @Description: 公司服务区域
 * @author maoxian
 * @date 2015年8月29日 下午5:16:26
 */
public class CompanyDirectionBean implements Serializable {

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//合作性质
	private String  dirNature;
	//合作方向
	private String  dirDirection;
	//销售地区-省
	private String  dirProvince;
	//销售地区-市
	private String  dirCity;
	//销售地区-县
	private String  dirTown;
	//创建时间
	private Date    dirCreatedate;
	//创建用户
	private String  dirCreateuser;
	//公司id
	private Integer cpyId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDirNature() {
		return dirNature;
	}
	public void setDirNature(String dirNature) {
		this.dirNature = dirNature;
	}
	public String getDirDirection() {
		return dirDirection;
	}
	public void setDirDirection(String dirDirection) {
		this.dirDirection = dirDirection;
	}
	public String getDirProvince() {
		return dirProvince;
	}
	public void setDirProvince(String dirProvince) {
		this.dirProvince = dirProvince;
	}
	public String getDirCity() {
		return dirCity;
	}
	public void setDirCity(String dirCity) {
		this.dirCity = dirCity;
	}
	public Date getDirCreatedate() {
		return dirCreatedate;
	}
	public void setDirCreatedate(Date dirCreatedate) {
		this.dirCreatedate = dirCreatedate;
	}
	public String getDirCreateuser() {
		return dirCreateuser;
	}
	public void setDirCreateuser(String dirCreateuser) {
		this.dirCreateuser = dirCreateuser;
	}
	public Integer getCpyId() {
		return cpyId;
	}
	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}
	public String getDirTown() {
		return dirTown;
	}
	public void setDirTown(String dirTown) {
		this.dirTown = dirTown;
	}

}
