package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * 
 * @ClassName: MallWebBean 
 * @Description: 商城设计
 * @author maoxian
 * @date 2015年11月12日 下午2:51:19 
 *
 */
public class MallWebBean extends BaseBean implements Serializable{

	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//企业id
	private Integer cpyId;
	//网站名成
	private String  webTitle;
	//网站logo
	private String  webLogo;
	//客户类型
	private String  webKh;
	//公司名称：
	private String  webCpyname;
	//图片1
	private String  webImg1;
	//图片2
	private String  webImg2;
	//图片3
	private String  webImg3;
	//图片4
	private String  webImg4;
	//24小时应急/投诉电话
	private String  webTeletephone;
	//营业执照号
	private String  webCard;
	//旅行社经营许可证号
	private String  webLvyoucard;
	//办公地址
	private String  webCpyaddress;
	//办公电话
	private String  webCpytelephone;
	//创建时间
	private Date    webCreatetime;
	//创建用户
	private String  webCreateuser;
	//web QQ
	private String  webQq;
	
	
	public String getWebQq() {
		return webQq;
	}
	public void setWebQq(String webQq) {
		this.webQq = webQq;
	}
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
	public String getWebTitle() {
		return webTitle;
	}
	public void setWebTitle(String webTitle) {
		this.webTitle = webTitle;
	}
	public String getWebLogo() {
		return webLogo;
	}
	public void setWebLogo(String webLogo) {
		this.webLogo = webLogo;
	}
	public String getWebKh() {
		return webKh;
	}
	public void setWebKh(String webKh) {
		this.webKh = webKh;
	}
	public String getWebCpyname() {
		return webCpyname;
	}
	public void setWebCpyname(String webCpyname) {
		this.webCpyname = webCpyname;
	}
	public String getWebImg1() {
		return webImg1;
	}
	public void setWebImg1(String webImg1) {
		this.webImg1 = webImg1;
	}
	public String getWebImg2() {
		return webImg2;
	}
	public void setWebImg2(String webImg2) {
		this.webImg2 = webImg2;
	}
	public String getWebImg3() {
		return webImg3;
	}
	public void setWebImg3(String webImg3) {
		this.webImg3 = webImg3;
	}
	public String getWebImg4() {
		return webImg4;
	}
	public void setWebImg4(String webImg4) {
		this.webImg4 = webImg4;
	}
	public String getWebTeletephone() {
		return webTeletephone;
	}
	public void setWebTeletephone(String webTeletephone) {
		this.webTeletephone = webTeletephone;
	}
	public String getWebCard() {
		return webCard;
	}
	public void setWebCard(String webCard) {
		this.webCard = webCard;
	}
	public String getWebLvyoucard() {
		return webLvyoucard;
	}
	public void setWebLvyoucard(String webLvyoucard) {
		this.webLvyoucard = webLvyoucard;
	}
	public String getWebCpyaddress() {
		return webCpyaddress;
	}
	public void setWebCpyaddress(String webCpyaddress) {
		this.webCpyaddress = webCpyaddress;
	}
	public String getWebCpytelephone() {
		return webCpytelephone;
	}
	public void setWebCpytelephone(String webCpytelephone) {
		this.webCpytelephone = webCpytelephone;
	}
	public Date getWebCreatetime() {
		return webCreatetime;
	}
	public void setWebCreatetime(Date webCreatetime) {
		this.webCreatetime = webCreatetime;
	}
	public String getWebCreateuser() {
		return webCreateuser;
	}
	public void setWebCreateuser(String webCreateuser) {
		this.webCreateuser = webCreateuser;
	}
}
