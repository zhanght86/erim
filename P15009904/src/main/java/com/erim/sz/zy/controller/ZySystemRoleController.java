/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * IndexController.java : 2013-06-30
 */
package com.erim.sz.zy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.zy.bean.ZySystemRoleBean;
import com.erim.sz.zy.service.ZySystemRoleService;

import common.Logger;

/**
 * 
 * @ClassName: ZySystemRoleController 
 * @Description: 角色管理
 * @author maoxian
 * @date 2015年8月19日 下午3:53:58 
 *
 */
@Controller
public class ZySystemRoleController {
	

	//声明日志
	private Logger logger = Logger.getLogger(ZySystemRoleController.class);
	
	@Autowired
	private ZySystemRoleService zySystemRoleService;
	
    
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
    @RequestMapping(value="/zy/role/list")
    public String showRole(ModelMap model,@ModelAttribute("cmsSystemRole") ZySystemRoleBean cmsSystemRoleBean) throws ErimException{
    	this.zySystemRoleService.selectPage(cmsSystemRoleBean, model);
		return "/zy/role/list";
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增页面
     * @param @param model
     * @param @param zySystemRoleBean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/zy/role/insertPage")
    public String insertPage(ModelMap model){
    	return "/zy/role/insert";
    }
    
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增
     * @param @param model
     * @param @param zySystemRoleBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/zy/role/insert")
    public int insert(ModelMap model,ZySystemRoleBean zySystemRoleBean){
    	try{
    		this.zySystemRoleService.insert(zySystemRoleBean);
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
    @RequestMapping(value="/zy/role/updatePage")
    public String updatePage(ModelMap model,int id){
    	this.zySystemRoleService.selectBeanById(id, model);
    	return "/zy/role/update";
    }
    
    @ResponseBody
    @RequestMapping(value="/zy/role/update")
    public int update(ModelMap model,ZySystemRoleBean zySystemRoleBean){
    	try{
    		this.zySystemRoleService.update(zySystemRoleBean);
    		return 1;
    	}catch(Exception e){
    		logger.error("角色更新出错", e);
    		return 0;
    	}
    }
}