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

import com.erim.sz.system.bean.ZxSystemLogBean;
import com.erim.sz.system.service.ZxSystemLogService;

/**
 * 
 * @ClassName: ZxSystemLogController 
 * @Description: 日志管理
 * @author maoxian
 * @date 2015年8月8日 上午11:35:20
 */
@Controller
public class ZxSystemLogController {

	@Autowired
	private ZxSystemLogService zxSystemLogService;
	
	/**
	 * 
	 * @Title: showHotel
	 * @Description: 日志
	 * @param @param model
	 * @param @param zxSystemLogBean
	 * @param @param ntype
	 * @param @param request
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("/zx/log/{ntype}")
	public String showHotel(ModelMap model,ZxSystemLogBean zxSystemLogBean,@PathVariable("ntype") String ntype,HttpServletRequest request){
		
		//放置bean
		model.addAttribute("zxLogBean", zxSystemLogBean);
		
		//zxSystemLogBean.setLogFuncCode(ntype);
		this.zxSystemLogService.selectByLogFuncCode(zxSystemLogBean, model);
		return "/zx/log/listAll";
	}
	
}