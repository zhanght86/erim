/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * IndexController.java : 2013-06-30
 */
package com.erim.sz.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.system.bean.SellSystemRoleBean;
import com.erim.sz.system.service.SellSystemRoleService;
import common.Logger;

/**
 * 
 * @ClassName: SellSystemRoleController 
 * @Description: 角色管理
 * @author maoxian
 * @date 2015年8月19日 下午3:53:58 
 *
 */
@Controller
public class SellSystemRoleController {
	

	//声明日志
	private Logger logger = Logger.getLogger(SellSystemRoleController.class);
	
	@Autowired
	private SellSystemRoleService sellSystemRoleService;
	
    
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
    @RequestMapping(value="/sell/role/list")
    public String showRole(ModelMap model,@ModelAttribute("cmsSystemRole") SellSystemRoleBean cmsSystemRoleBean) throws ErimException{
    	this.sellSystemRoleService.selectPage(cmsSystemRoleBean, model);
		return "/sell/role/list";
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增页面
     * @param @param model
     * @param @param sellSystemRoleBean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/sell/role/insertPage")
    public String insertPage(ModelMap model){
    	return "/sell/role/insert";
    }
    
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增
     * @param @param model
     * @param @param sellSystemRoleBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/sell/role/insert")
    public int insert(ModelMap model,SellSystemRoleBean sellSystemRoleBean){
    	try{
    		this.sellSystemRoleService.insert(sellSystemRoleBean);
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
    @RequestMapping(value="/sell/role/updatePage")
    public String updatePage(ModelMap model,int id){
    	this.sellSystemRoleService.selectBeanById(id, model);
    	return "/sell/role/update";
    }
    
    /**
     * @Title: update 
     * @Description: 修改角色名称 
     * @param @param model
     * @param @param sellSystemRoleBean
     * @param @return    设定文件 
     * @return int    返回类型 
     * @author maoxian
     * @date 2015年12月10日 下午7:44:50 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/sell/role/update")
    public int update(ModelMap model,SellSystemRoleBean sellSystemRoleBean){
    	try{
    		this.sellSystemRoleService.update(sellSystemRoleBean);
    		return 1;
    	}catch(Exception e){
    		logger.error("角色更新出错", e);
    		return 0;
    	}
    }
}