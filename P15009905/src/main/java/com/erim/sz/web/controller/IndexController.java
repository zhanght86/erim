/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * IndexController.java : 2013-06-30
 */
package com.erim.sz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.web.service.GuidePriceService;
import com.erim.sz.web.service.GuideScheduleService;

/**
 * @ClassName: IndexController 
 * @Description: 主页
 * @author maoxian
 * @date 2015年9月10日 下午4:23:15 
 */
@Controller
public class IndexController {

	@Autowired
	private GuideScheduleService guideScheduleService;
	@Autowired
	private GuidePriceService guidePriceService;

    /** 登录 */
    @RequestMapping(value = "/")
    public String root() {
        return "forward:/loginPage";
    }

    /** 登录 */
    @RequestMapping(value = "/loginPage")
    public String loginPage() {
        return "login";
    }
    
    /** 主页 */
    @RequestMapping(value = "/index")
    public String index(ModelMap model){
    	// 初始化页面信息
    	guidePriceService.refreshGuidePriceList(model);
    	return "index";
    }
}