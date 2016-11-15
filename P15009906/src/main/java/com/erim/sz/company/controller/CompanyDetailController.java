package com.erim.sz.company.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.company.service.VCompanyDetailService;

/**
 * @ClassName: CompanyDetailController
 * @Description: 企业信息
 * @author maoxian
 * @date 2015年8月1日 上午11:56:40
 */
@Controller
public class CompanyDetailController {
	
	@Autowired
	private VCompanyDetailService vCompanyDetailService;
	
	/**
	 * @Title: suppliers 
	 * @Description: 供应商管理
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/company/detail/suppliers")
	public String suppliers(ModelMap model,VCompanyDetailBean vCompanyDetailBean,HttpServletRequest request){
		//获取li
		String li =  request.getParameter("li");
//		if(StringUtils.isNotBlank(li)){
			//查询所有专线供应商
			vCompanyDetailBean.setN(9999);
			this.vCompanyDetailService.selectPage(vCompanyDetailBean, model);
			
			
//		}
		
		model.addAttribute("li",li);
		model.addAttribute("liname", request.getParameter("liname"));
		
		//设置所属专线
		//this.vCompanyDetailService.setServiceInside(model);
		return "/company/detail/suppliers";
	}
	
}
