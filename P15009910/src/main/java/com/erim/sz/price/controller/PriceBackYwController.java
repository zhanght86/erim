package com.erim.sz.price.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.PriceBackYwBean;
import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.company.service.VCompanyDetailService;
import com.erim.sz.price.service.PriceBackYwService;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: PriceBackYwController 
 * @Description: 运维返利
 * @author maoxian
 * @date 2015年12月18日 上午12:34:32
 */
@Controller
public class PriceBackYwController {
	
	@Autowired
	private PriceBackYwService    priceBackYwService;
	@Autowired
	private VCompanyDetailService vCompanyDetailService;
	
	
	/**
	 * @Title: yw 
	 * @Description: 运维费详细
	 * @param @param model
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月18日 上午1:53:36 
	 * @throws
	 */
	@RequestMapping(value = "/priceback/yw/yw")
	public String yw(ModelMap model,PriceBackYwBean bean){
		this.priceBackYwService.selectPage(bean,model);
		return "/priceback/yw/list";
	}

	/**
	 * @Title: show 
	 * @Description: 运维返利
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月18日 上午12:37:31 
	 * @throws
	 */
	@RequestMapping(value = "/priceback/yw/show")
	public String show(ModelMap model,VCompanyDetailBean bean){
		bean.setYjUserCode(CommonUtil.getYjUserCode());
		this.vCompanyDetailService.selectPage(bean, model);
		return "/priceback/yw/show";
	}
	
	/**
	 * @Title: cshow 
	 * @Description: 二级运维返利
	 * @param @param model
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月18日 上午1:00:05 
	 * @throws
	 */
	@RequestMapping(value = "/priceback/yw/cshow")
	public String cshow(ModelMap model,VCompanyDetailBean bean){
		this.vCompanyDetailService.selectPage(bean, model);
		return "/priceback/yw/cshow";
	}
}