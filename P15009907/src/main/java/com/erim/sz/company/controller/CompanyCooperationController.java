package com.erim.sz.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.CompanyDetailBean;
import com.erim.sz.company.service.CompanyDetailService;

/**
 * 
 * @ClassName: CompanyCooperationController 
 * @Description: 合作管理
 * @author maoxian
 * @date 2015年8月28日 下午2:01:21 
 *
 */
@Controller
public class CompanyCooperationController {

	@Autowired
	private CompanyDetailService  companyDetailService;

	
	/**
	 * 
	 * @Title: cooperation 
	 * @Description: 合作管理
	 * @param @param model
	 * @param @param ntype
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/company/cooperation/{ntype}")
	public String cooperation(ModelMap model,@PathVariable("ntype") String ntype,CompanyDetailBean param){
		this.companyDetailService.selectPageCafeteria(param, model);
		return "/company/cooperation/list";
	}
}
