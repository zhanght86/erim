package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: PubHelpBean 
 * @Description: 外网帮助中心
 * @author maoxian
 * @date 2015年10月3日 下午8:15:16
 */
public class PubHelpBean  extends BaseBean implements Serializable {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//类别1
	private String  helpType1;
	//类别2
	private String  helpType2;
	//内容
	private String  helpContent;
	//最后更新用户
	private String  helpUpdateuser;
	//最后更新时间
	private Date    helpUpdatetime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHelpType1() {
		return helpType1;
	}
	public void setHelpType1(String helpType1) {
		this.helpType1 = helpType1;
	}
	public String getHelpType2() {
		return helpType2;
	}
	public void setHelpType2(String helpType2) {
		this.helpType2 = helpType2;
	}
	public String getHelpContent() {
		return helpContent;
	}
	public void setHelpContent(String helpContent) {
		this.helpContent = helpContent;
	}
	public String getHelpUpdateuser() {
		return helpUpdateuser;
	}
	public void setHelpUpdateuser(String helpUpdateuser) {
		this.helpUpdateuser = helpUpdateuser;
	}
	public Date getHelpUpdatetime() {
		return helpUpdatetime;
	}
	public void setHelpUpdatetime(Date helpUpdatetime) {
		this.helpUpdatetime = helpUpdatetime;
	}
}
