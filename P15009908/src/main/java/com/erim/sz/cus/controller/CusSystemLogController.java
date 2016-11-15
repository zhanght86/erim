/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * IndexController.java : 2013-06-30
 */
package com.erim.sz.cus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.cus.bean.CusSystemLogBean;
import com.erim.sz.cus.service.CusSystemLogService;

/**
 * 
 * @ClassName: CusSystemLogController 
 * @Description: 日志管理
 * @author maoxian
 * @date 2015年8月8日 上午11:35:20
 */
@Controller
public class CusSystemLogController {

	@Autowired
	private CusSystemLogService cusSystemLogService;
	
	/**
	 * 
	 * @Title: showHotel
	 * @Description: 日志
	 * @param @param model
	 * @param @param cusSystemLogBean
	 * @param @param ntype
	 * @param @param request
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("/cus/log/{ntype}")
	public String showHotel(ModelMap model,CusSystemLogBean cusSystemLogBean,@PathVariable("ntype") String ntype,HttpServletRequest request){
		
		if(!"listAll".equals(ntype)){
			cusSystemLogBean.setLogFuncCode(ntype);
		}
		this.cusSystemLogService.selectByLogFuncCode(cusSystemLogBean, model);
		return "/cus/log/listAll";
	}
	
}