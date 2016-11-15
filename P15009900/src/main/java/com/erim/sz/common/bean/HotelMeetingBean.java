package com.erim.sz.common.bean;

import java.io.Serializable;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: HotalMeetingBean
 * @Description: 酒店会议室
 * @author 龙龙
 * @date 2015年7月20日 下午10:23
 *
 */
public class HotelMeetingBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	// 会议室名称
	private String  hmgName;
	// 面积
	private String  hmgArea;
	
	// 容纳人数-最小值
	private Integer hmgPersonnum;
	// 容纳人数-最大值
	private Integer hmgPersonNumEnd;
	
	// 茶歇 / 设施
	private String  hmgIsTea;
	// led
	private String  hmgIsLed;
	// 激光
	private String  hmgIsLaser;
	// 横幅
	private String  hmgIsBanner;
	// 翻页
	private String  hmgIsNext;
	// 投影
	private String  hmgIsProjection;
	// 纸
	private String  hmgIsPage;
	
	// 摆放形式
	private String  hmgShape;
	// 最近装修日期
	private String  hmgRenovationDate;
	// 酒店id
	private Integer hdlId;
	// 会议室图片
	private String  hmgImg;
	
	// 其他
	private String  hmgIsOther;
	// 是否关闭启动1启动2关闭
	private String hmgIsDelStatus;
	// 企业ID
    private Integer cpyId;
    
    /**
     * 转码用字段
     */
	private String personNum;

	public String getPersonNum() {
		return personNum;
	}

	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}

	public Integer getCpyId() {
		return cpyId;
	}

	public void setCpyId(Integer cpyId) {
		this.cpyId = cpyId;
	}

	public String getHmgIsDelStatus() {
		return hmgIsDelStatus;
	}

	public void setHmgIsDelStatus(String hmgIsDelStatus) {
		this.hmgIsDelStatus = hmgIsDelStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHmgName() {
		return hmgName;
	}

	public void setHmgName(String hmgName) {
		this.hmgName = hmgName;
	}

	public String getHmgArea() {
		return hmgArea;
	}

	public void setHmgArea(String hmgArea) {
		this.hmgArea = hmgArea;
	}

	public Integer getHmgPersonnum() {
		return hmgPersonnum;
	}

	public void setHmgPersonnum(Integer hmgPersonnum) {
		this.hmgPersonnum = hmgPersonnum;
	}

	public String getHmgIsTea() {
		return hmgIsTea;
	}

	public void setHmgIsTea(String hmgIsTea) {
		this.hmgIsTea = hmgIsTea;
	}

	public String getHmgIsLed() {
		return hmgIsLed;
	}

	public void setHmgIsLed(String hmgIsLed) {
		this.hmgIsLed = hmgIsLed;
	}

	public String getHmgIsLaser() {
		return hmgIsLaser;
	}

	public void setHmgIsLaser(String hmgIsLaser) {
		this.hmgIsLaser = hmgIsLaser;
	}

	public String getHmgIsBanner() {
		return hmgIsBanner;
	}

	public void setHmgIsBanner(String hmgIsBanner) {
		this.hmgIsBanner = hmgIsBanner;
	}

	public String getHmgIsNext() {
		return hmgIsNext;
	}

	public void setHmgIsNext(String hmgIsNext) {
		this.hmgIsNext = hmgIsNext;
	}

	public String getHmgIsProjection() {
		return hmgIsProjection;
	}

	public void setHmgIsProjection(String hmgIsProjection) {
		this.hmgIsProjection = hmgIsProjection;
	}

	public String getHmgIsPage() {
		return hmgIsPage;
	}

	public void setHmgIsPage(String hmgIsPage) {
		this.hmgIsPage = hmgIsPage;
	}

	public String getHmgIsOther() {
		return hmgIsOther;
	}

	public void setHmgIsOther(String hmgIsOther) {
		this.hmgIsOther = hmgIsOther;
	}

	public Integer getHdlId() {
		return hdlId;
	}

	public void setHdlId(Integer hdlId) {
		this.hdlId = hdlId;
	}

	public Integer getHmgPersonNumEnd() {
		return hmgPersonNumEnd;
	}

	public void setHmgPersonNumEnd(Integer hmgPersonNumEnd) {
		this.hmgPersonNumEnd = hmgPersonNumEnd;
	}

	public String getHmgShape() {
		return hmgShape;
	}

	public void setHmgShape(String hmgShape) {
		this.hmgShape = hmgShape;
	}

	public String getHmgRenovationDate() {
		return hmgRenovationDate;
	}

	public void setHmgRenovationDate(String hmgRenovationDate) {
		this.hmgRenovationDate = hmgRenovationDate;
	}

	public String getHmgImg() {
		return hmgImg;
	}

	public void setHmgImg(String hmgImg) {
		this.hmgImg = hmgImg;
	}

	
}
