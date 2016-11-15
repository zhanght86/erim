/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * IndexController.java : 2013-06-30
 */
package com.erim.sz.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.system.bean.SellSystemLogBean;
import com.erim.sz.system.service.SellSystemLogService;

/**
 * 
 * @ClassName: SellSystemLogController 
 * @Description: 日志管理
 * @author maoxian
 * @date 2015年8月8日 上午11:35:20
 */
@Controller
public class SellSystemLogController {

	@Autowired
	private SellSystemLogService sellSystemLogService;
	
	/**
	 * 
	 * @Title: showHotel
	 * @Description: 日志
	 * @param @param model
	 * @param @param sellSystemLogBean
	 * @param @param ntype
	 * @param @param request
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("/sell/log/listAll")
	public String showHotel(ModelMap model,SellSystemLogBean sellSystemLogBean,
				HttpServletRequest request){
		
		//sellSystemLogBean.setLogFuncCode(ntype);
		model.addAttribute("usrBean", sellSystemLogBean);
		this.sellSystemLogService.selectByLogFuncCode(sellSystemLogBean, model);
		return "/sell/log/listAll";
	}
	
}