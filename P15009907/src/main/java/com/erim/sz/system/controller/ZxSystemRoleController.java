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
import com.erim.sz.system.bean.ZxSystemRoleBean;
import com.erim.sz.system.service.ZxSystemRoleService;
import common.Logger;

/**
 * 
 * @ClassName: ZxSystemRoleController 
 * @Description: 角色管理
 * @author maoxian
 * @date 2015年8月19日 下午3:53:58 
 *
 */
@Controller
public class ZxSystemRoleController {
	

	//声明日志
	private Logger logger = Logger.getLogger(ZxSystemRoleController.class);
	
	@Autowired
	private ZxSystemRoleService zxSystemRoleService;
	
    
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
    @RequestMapping(value="/zx/role/list")
    public String showRole(ModelMap model,@ModelAttribute("cmsSystemRole") ZxSystemRoleBean cmsSystemRoleBean) throws ErimException{
    	this.zxSystemRoleService.selectPage(cmsSystemRoleBean, model);
		return "/zx/role/list";
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增页面
     * @param @param model
     * @param @param zxSystemRoleBean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/zx/role/insertPage")
    public String insertPage(ModelMap model){
    	return "/zx/role/insert";
    }
    
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增
     * @param @param model
     * @param @param zxSystemRoleBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/zx/role/insert")
    public int insert(ModelMap model,ZxSystemRoleBean zxSystemRoleBean){
    	try{
    		this.zxSystemRoleService.insert(zxSystemRoleBean);
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
    @RequestMapping(value="/zx/role/updatePage")
    public String updatePage(ModelMap model,int id){
    	this.zxSystemRoleService.selectBeanById(id, model);
    	return "/zx/role/update";
    }
    
    @ResponseBody
    @RequestMapping(value="/zx/role/update")
    public int update(ModelMap model,ZxSystemRoleBean zxSystemRoleBean){
    	try{
    		this.zxSystemRoleService.update(zxSystemRoleBean);
    		return 1;
    	}catch(Exception e){
    		logger.error("角色更新出错", e);
    		return 0;
    	}
    }
}