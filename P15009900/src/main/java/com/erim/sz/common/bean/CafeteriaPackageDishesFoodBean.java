package com.erim.sz.common.bean;

import java.io.Serializable;
import java.util.Date;

import com.erim.core.bean.BaseBean;

/**
 * @ClassName: CafeteriaPackageDishesFoodBean
 * @Description: 菜
 * @author maoxian
 * @date 2015年11月7日 下午5:42:50
 */
public class CafeteriaPackageDishesFoodBean extends BaseBean implements Serializable {
	/**
	 * @Fields serialVersionUID : 序列化
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	// 套餐ID
	private Integer cpeId;
	// 菜品ID
	private Integer cpdId;
	// 菜品类型
	private String cpfNtype;
	// 菜名
	private String cpfName;
	// 数量
	private String cpfNumber;
	// 单价
	private Integer cpfPrice;
	// 图片
	private String cpfImg1;
	// 图片2
	private String cpfImg2;
	// 创建时间
	private Date cpfCreatetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpfName() {
		return cpfName;
	}

	public void setCpfName(String cpfName) {
		this.cpfName = cpfName;
	}

	public Integer getCpfPrice() {
		return cpfPrice;
	}

	public void setCpfPrice(Integer cpfPrice) {
		this.cpfPrice = cpfPrice;
	}

	public String getCpfImg1() {
		return cpfImg1;
	}

	public void setCpfImg1(String cpfImg1) {
		this.cpfImg1 = cpfImg1;
	}

	public String getCpfImg2() {
		return cpfImg2;
	}

	public void setCpfImg2(String cpfImg2) {
		this.cpfImg2 = cpfImg2;
	}

	public String getCpfNtype() {
		return cpfNtype;
	}

	public void setCpfNtype(String cpfNtype) {
		this.cpfNtype = cpfNtype;
	}

	public Date getCpfCreatetime() {
		return cpfCreatetime;
	}

	public void setCpfCreatetime(Date cpfCreatetime) {
		this.cpfCreatetime = cpfCreatetime;
	}

	public Integer getCpdId() {
		return cpdId;
	}

	public void setCpdId(Integer cpdId) {
		this.cpdId = cpdId;
	}

	public Integer getCpeId() {
		return cpeId;
	}

	public void setCpeId(Integer cpeId) {
		this.cpeId = cpeId;
	}

	public String getCpfNumber() {
		return cpfNumber;
	}

	public void setCpfNumber(String cpfNumber) {
		this.cpfNumber = cpfNumber;
	}

}