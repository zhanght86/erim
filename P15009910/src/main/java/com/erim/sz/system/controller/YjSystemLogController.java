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

import com.erim.sz.system.bean.YjSystemLogBean;
import com.erim.sz.system.service.YjSystemLogService;

/**
 * 
 * @ClassName: YjSystemLogController 
 * @Description: 日志管理
 * @author maoxian
 * @date 2015年8月8日 上午11:35:20
 */
@Controller
public class YjSystemLogController {

	@Autowired
	private YjSystemLogService yjSystemLogService;
	
	/**
	 * 
	 * @Title: showHotel
	 * @Description: 日志
	 * @param @param model
	 * @param @param yjSystemLogBean
	 * @param @param ntype
	 * @param @param request
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("/yj/log/{ntype}")
	public String showHotel(ModelMap model,YjSystemLogBean yjSystemLogBean,@PathVariable("ntype") String ntype,HttpServletRequest request){
		
		yjSystemLogBean.setLogFuncCode(ntype);
		this.yjSystemLogService.selectByLogFuncCode(yjSystemLogBean, model);
		return "/yj/log/listAll";
	}
	
}