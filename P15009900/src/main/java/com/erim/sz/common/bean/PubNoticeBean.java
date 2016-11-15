package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: PubNoticeBean 
 * @Description: TODO(通知公告) 
 * @author 贺渊博 
 * @date 2015年11月9日 下午9:55:25 
 *
 */

public class PubNoticeBean extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//08 生产商 07 专线商 06 组团社
	public String pneNtype;
	//通知标题
	public String pneTitle;
	//通知内容
	public String pneContent;
	//创建时间
	public Date pneCreatetime;
	//创建用户
	public String pneCreateuser;
	//是否发布
	public String pneIsShow;
	//浏览次数
	public Integer pneNumLl;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPneNtype() {
		return pneNtype;
	}
	public void setPneNtype(String pneNtype) {
		this.pneNtype = pneNtype;
	}
	public String getPneTitle() {
		return pneTitle;
	}
	public void setPneTitle(String pneTitle) {
		this.pneTitle = pneTitle;
	}
	public String getPneContent() {
		return pneContent;
	}
	public void setPneContent(String pneContent) {
		this.pneContent = pneContent;
	}
	public Date getPneCreatetime() {
		return pneCreatetime;
	}
	public void setPneCreatetime(Date pneCreatetime) {
		this.pneCreatetime = pneCreatetime;
	}
	public String getPneCreateuser() {
		return pneCreateuser;
	}
	public void setPneCreateuser(String pneCreateuser) {
		this.pneCreateuser = pneCreateuser;
	}
	public String getPneIsShow() {
		return pneIsShow;
	}
	public void setPneIsShow(String pneIsShow) {
		this.pneIsShow = pneIsShow;
	}
	public Integer getPneNumLl() {
		return pneNumLl;
	}
	public void setPneNumLl(Integer pneNumLl) {
		this.pneNumLl = pneNumLl;
	}
	
	

}
