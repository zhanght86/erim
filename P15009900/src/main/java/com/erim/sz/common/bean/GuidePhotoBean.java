package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: GuidePhotoBean 
 * @Description: 导游相册
 * @author maoxian
 * @date 2015年9月10日 下午7:16:48 
 */
public class GuidePhotoBean implements Serializable {
	
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//导游id
	private Integer gdlId;
	//图片路径
	private String  gptImgUrl;
	//创建用户
	private String  gptCreateuser;
	//创建时间
	private Date    gptCreatetime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGdlId() {
		return gdlId;
	}
	public void setGdlId(Integer gdlId) {
		this.gdlId = gdlId;
	}
	public String getGptImgUrl() {
		return gptImgUrl;
	}
	public void setGptImgUrl(String gptImgUrl) {
		this.gptImgUrl = gptImgUrl;
	}
	public String getGptCreateuser() {
		return gptCreateuser;
	}
	public void setGptCreateuser(String gptCreateuser) {
		this.gptCreateuser = gptCreateuser;
	}
	public Date getGptCreatetime() {
		return gptCreatetime;
	}
	public void setGptCreatetime(Date gptCreatetime) {
		this.gptCreatetime = gptCreatetime;
	}

}
