/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * IndexController.java : 2013-06-30
 */
package com.erim.sz.cus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.cus.bean.CusSystemRoleBean;
import com.erim.sz.cus.service.CusSystemRoleService;

import common.Logger;

/**
 * 
 * @ClassName: CusSystemRoleController 
 * @Description: 角色管理
 * @author maoxian
 * @date 2015年8月19日 下午3:53:58 
 *
 */
@Controller
public class CusSystemRoleController {
	

	//声明日志
	private Logger logger = Logger.getLogger(CusSystemRoleController.class);
	
	@Autowired
	private CusSystemRoleService cusSystemRoleService;
	
    
    /**
     * 
     * @Title: showRole 
     * @Description: 角色信息列表
     * @param @param model
     * @param @param cmsSystemRoleBean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/cus/role/list")
    public String showRole(ModelMap model,@ModelAttribute("cmsSystemRole") CusSystemRoleBean cmsSystemRoleBean) throws ErimException{
    	this.cusSystemRoleService.selectPage(cmsSystemRoleBean, model);
		return "/cus/role/list";
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增页面
     * @param @param model
     * @param @param cusSystemRoleBean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/cus/role/insertPage")
    public String insertPage(ModelMap model){
    	return "/cus/role/insert";
    }
    
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增
     * @param @param model
     * @param @param cusSystemRoleBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/cus/role/insert")
    public int insert(ModelMap model,CusSystemRoleBean cusSystemRoleBean){
    	try{
    		this.cusSystemRoleService.insert(cusSystemRoleBean);
    		return 1;
    	}catch(Exception e){
    		logger.error("角色新增出错", e);
    		return 0;
    	}
    }
    
    /**
     * 
     * @Title: updatePage 
     * @Description: 修改方法
     * @param @param model
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/cus/role/updatePage")
    public String updatePage(ModelMap model,int id){
    	this.cusSystemRoleService.selectBeanById(id, model);
    	return "/cus/role/update";
    }
    
    @ResponseBody
    @RequestMapping(value="/cus/role/update")
    public int update(ModelMap model,CusSystemRoleBean cusSystemRoleBean){
    	try{
    		this.cusSystemRoleService.update(cusSystemRoleBean);
    		return 1;
    	}catch(Exception e){
    		logger.error("角色更新出错", e);
    		return 0;
    	}
    }
}