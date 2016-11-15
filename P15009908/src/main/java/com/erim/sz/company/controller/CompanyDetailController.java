package com.erim.sz.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.company.service.VCompanyDetailService;

/**
 * @描述: 组团社资源信息操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年12月3日 下午4:26:17
 * 
 * @Description 修改原有接口为视图接口
 * @author maoxian
 * @date 2015年12月6日 下午11:49:29
 */
@Controller
public class CompanyDetailController {
	
	@Autowired
	private VCompanyDetailService companyDetailService;
	//private CompanyDetailService companyDetailService;
	
	/**
	 * @描述: 销售资源 - 组团社资源数据列表
	 * @作者: 
	 * @创建时间: 2015年12月3日 下午4:27:11
	 * @param model
	 * @param baseBean
	 * @return
	 */
	@RequestMapping(value = "/company/detail/sell")
	public String sell(ModelMap model,@ModelAttribute("companyDetail") VCompanyDetailBean baseBean) {
		
		baseBean.setCpyRoe(ErimConstants.COMPANYROLE_SELLER);
		
		// 获取数据列表
		model.addAttribute("sellList", companyDetailService.selectPageSell(baseBean, model));
		
		return "/company/detail/sell";
	}
	
	/**
	 * @描述: 销售资源-专线资源
	 * @作者: 
	 * @创建时间: 2015年12月3日 下午4:56:24
	 * @param model
	 * @param baseBean
	 * @return
	 */
	@RequestMapping(value = "/company/detail/line")
	public String line(ModelMap model,@ModelAttribute("companyList") VCompanyDetailBean baseBean) {
		
		baseBean.setCpyRoe(ErimConstants.COMPANYROLE_LINE);
		baseBean.setAstrprovince(null);
		
		model.addAttribute("lineList", companyDetailService.selectPageLine(baseBean, model));
		
		return "/company/detail/line";
	}
}
