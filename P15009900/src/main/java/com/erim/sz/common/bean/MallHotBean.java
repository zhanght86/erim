package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: MallHotBean 
 * @Description: 热门精选
 * @author maoxian
 * @date 2015年11月12日 上午2:15:54 
 *
 */
public class MallHotBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	//企业id
	private Integer cpyId;
	//类别 1周边 2国内 3 港澳台/日韩/东南亚 4朝鲜/俄罗斯/欧洲/美洲
	private String  mhtNtype;
		//专线id
	private Integer lineId;
	//创建时间
	private Date    mhtCreatetime;
	//创建用户
	private String  mhtCreateuser;
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
	public String getMhtNtype() {
		return mhtNtype;
	}
	public void setMhtNtype(String mhtNtype) {
		this.mhtNtype = mhtNtype;
	}
	public Integer getLineId() {
		return lineId;
	}
	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}
	public Date getMhtCreatetime() {
		return mhtCreatetime;
	}
	public void setMhtCreatetime(Date mhtCreatetime) {
		this.mhtCreatetime = mhtCreatetime;
	}
	public String getMhtCreateuser() {
		return mhtCreateuser;
	}
	public void setMhtCreateuser(String mhtCreateuser) {
		this.mhtCreateuser = mhtCreateuser;
	}
}
