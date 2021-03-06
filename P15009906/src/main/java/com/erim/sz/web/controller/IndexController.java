/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * IndexController.java : 2013-06-30
 */
package com.erim.sz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.CompanyDetailBean;
import com.erim.sz.common.bean.PubNoticeBean;
import com.erim.sz.notice.service.PubNoticeService;
import com.erim.sz.system.service.SellSystemRoleFuncService;

/**
 * 
 * @ClassName: IndexController 
 * @Description: 主页
 * @author maoxian
 * @date 2015年8月1日 上午11:04:51
 */
@Controller
public class IndexController {

	@Autowired
	private SellSystemRoleFuncService sellSystemRoleFuncService;
	@Autowired
	private PubNoticeService          pubNoticeService;

    /**
     * 
     * @Title: root 
     * @Description: 主页跳转登录页
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/")
    public String root() {
        return "forward:/login";
    }
    
    /**
     * 
     * @Title: index 
     * @Description: 首页
     * @param @param model
     * @param @param request
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap model, HttpServletRequest request) {
    	//model.addAttribute("funcs", this.sellSystemFuncService.selectAll());
    	if(null != SecurityUtils.getSubject().getSession().getAttribute("userRoleId")){
    		this.sellSystemRoleFuncService.selectFuncByRoleId(SecurityUtils.getSubject().getSession().getAttribute("userRoleId").toString(),model);
    		return "index";
    	}
        return this.root();
    }

    /**
     * @Title: web 
     * @Description: 主页
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/web/detail/index")
    public String web(){
    	return "/web/index";
    }
    
    
    /**
     * @Title: welocome 
     * @Description: 欢迎
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/welcome")
    public String welocome(ModelMap model,PubNoticeBean bean){
    	this.pubNoticeService.showList(model, bean);
    	return "common/welcome";
    }
    /**
     * 
     * @描述: 公司详情
     * @作者: （李庆）
     * @创建时间: 2015年12月24日 下午2:24:13
     * @param map
     * @param bean
     * @return
     */
    @RequestMapping("/cpy/detail")
    public String companyDetail(ModelMap map, CompanyDetailBean bean){
    	
    	return "common/detail";
    }
}