package com.erim.sz.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.CompanyDetailBean;
import com.erim.sz.company.service.CompanyDetailService;

/**
 * 
 * @ClassName: CompanyDetailController
 * @Description: 企业信息
 * @author maoxian
 * @date 2015年8月1日 上午11:56:40
 */
@Controller
public class CompanyDetailController {
	@Autowired
	private CompanyDetailService companyDetailService;
	/**
	 * 
	 * @Title: sell 
	 * @Description: 销售商 
	 * @param @param model
	 * @param @param companyDetailBean
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/company/detail/sell")
	public String sell(ModelMap model,CompanyDetailBean companyDetailBean){
		this.companyDetailService.selectPageCafeteria(companyDetailBean, model);
		return "sell/company/list";
	}
	
}
