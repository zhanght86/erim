/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * IndexController.java : 2013-06-30
 */
package com.erim.sz.system.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.YjSystemUserBean;
import com.erim.sz.common.util.AddressUtils;
import com.erim.sz.system.service.YjSystemRoleService;
import com.erim.sz.system.service.YjSystemUserService;
import com.erim.utils.ip.IP4;

import common.Logger;

/**
 * 
 * @ClassName: IndexController 
 * @Description: 登录
 * @author maoxian
 * @date 2015年8月1日 上午11:04:51
 */
@Controller
public class YjSystemUserController {

	//声明日志
	private Logger logger = Logger.getLogger(YjSystemFuncController.class);
	
	@Autowired
	private YjSystemUserService yjSystemUserService;
	@Autowired
	private YjSystemRoleService yjSystemRoleService;
	
	/**
	 * @Title: ajaxCheckLoginName 
	 * @Description: 判断用户是否重复
	 * @param @param loginname
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/ajaxCheckLoginName")
	public List<Object> ajaxCheckLoginName(String fieldId,String fieldValue){
		
		//检查用户名是否已经被注册
		return this.yjSystemUserService.ajaxCheckLoginName(fieldId,fieldValue);
	}
	
    /**
     * 
     * @Title: login 
     * @Description: 登录页
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/login")
    public String loginPage(){
    	return "/login/login";
    }


    /**
     * 
     * @Title: lgoin 
     * @Description: 登录方法
     * @param @param model
     * @param @param request
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/yj/user/login")
    public String login(ModelMap model,String username,String password, String checkcode,HttpServletRequest request) {
    	
    	String code = (String) SecurityUtils.getSubject().getSession().getAttribute("sessionCode");
    	
    	if (StringUtils.isEmpty(username)) return "redirect:/login";
    	
    	if (!checkcode.equals(code)) {
    		model.addAttribute("errorMsg", "验证码输入错误");
    		return loginPage();
    	}
    	
    	//判断是否登录
    	if(yjSystemUserService.isLogin(model,username, password)) {
    		// 用户登陆之后更改登陆时间 和登陆IP
			String userName =  SecurityUtils.getSubject().getSession().getAttribute("userName").toString();
			if(StringUtils.isNotBlank(userName)) {
				// 获取当IP
				String ip = IP4.getIP4(request);
				YjSystemUserBean user = yjSystemUserService.selectUserByLoginname(userName);
				user.setYjLastLoginIp(ip);
				user.setYjLastLoginTime(new Date());
				user.setYjLastLoginAddress(AddressUtils.getAddresses("ip=" + ip, "utf-8"));
				// 修改登录状态
				yjSystemUserService.updateLogin(user);
			}
    		return "redirect:/index";
    	}
    	return loginPage();
    }
    
    /**
     * 
     * @Title: updatePsd 
     * @Description: 修改密码
     * @param @param model
     * @param @param loginname
     * @param @param psd
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/yj/user/updatePsd")
    public @ResponseBody Integer updatePsd(HttpServletRequest request){
    	return this.yjSystemUserService.updatePsd(request);
    }
    
    /**
     * @Title: updatePadPage 
     * @Description: 跳转修改密码页面
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/yj/user/updatePadPage")
    public String updatePadPage(){
    	return "/yj/user/updatePsd";
    }
    /**
     * @方法名：ajaxCheckOldPwd 
     * @描述: 判断原密码是否正确
     * @作者： 贺渊博
     * @创建时间：2015年11月12日 下午3:59:07
     * @param oldPwd
     * @param yjUserLoginname
     */
    @RequestMapping(value="/yj/user/oldPwd")
    public @ResponseBody Integer ajaxCheckOldPwd(String oldPwd){
    	return yjSystemUserService.checkOldPwd(oldPwd);
    }
    
    /**
     * 
     * @Title: loginOut 
     * @Description: 注销用户
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping("loginOut")
    private String loginOut(){
    	this.yjSystemUserService.loginOut();
    	return this.loginPage();
    }
    
    
    ////////////////////////////////////////////////基本信息/////////////////////////////////////////////////////
    
    /**
     * 
     * @Title: showUser 
     * @Description: 用户信息列表
     * @param @param model
     * @param @param cmsSystemUserBean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/yj/user/list")
    public String showUser(ModelMap model,@ModelAttribute("cmsSystemUser") YjSystemUserBean cmsSystemUserBean) throws ErimException{
    	this.yjSystemUserService.selectPage(cmsSystemUserBean, model);
		return "/yj/user/list";
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增页面
     * @param @param model
     * @param @param yjSystemUserBean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/yj/user/insertPage")
    public String insertPage(ModelMap model){
    	int cpyid = (Integer)SecurityUtils.getSubject().getSession().getAttribute("userCpyId");
    	model.addAttribute("roleList", this.yjSystemRoleService.selectYjSystemRoleByCpyId(cpyid));
    	model.addAttribute("userList", this.yjSystemRoleService.selectYjSystemUserByCpyId(cpyid));
    	return "/yj/user/insert";
    }
    
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增
     * @param @param model
     * @param @param yjSystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/yj/user/insert")
    public int insert(ModelMap model,YjSystemUserBean yjSystemUserBean){
    	try{
    		//获取新增用户名登录账号
    		String username = yjSystemUserBean.getYjUserLoginname();
    		String yjParentLoginname=yjSystemUserBean.getYjParentLoginname();
    		if(StringUtils.isNotBlank(username)){
    			YjSystemUserBean user = this.yjSystemUserService.selectUserByLoginname(username);
    			//如果用户名存在则返回失败
    			if(null!=user) return 0;
    			this.yjSystemUserService.insert(yjSystemUserBean);
    			return 1;
    		}else{
    			return 0;
    		}
    	}catch(Exception e){
    		logger.error("用户新增出错", e);
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
    @RequestMapping(value="/yj/user/updatePage")
    public String updatePage(ModelMap model,int id){
    	//用户角色信息
    	int cpyid = (Integer)SecurityUtils.getSubject().getSession().getAttribute("userCpyId");
    	model.addAttribute("roleList", this.yjSystemRoleService.selectYjSystemRoleByCpyId(cpyid));
    	//查询id值为id的对象
    	this.yjSystemUserService.selectUserById(id,model);
    	return "/yj/user/update";
    }
    
    @ResponseBody
    @RequestMapping(value="/yj/user/update")
    public int update(ModelMap model,YjSystemUserBean yjSystemUserBean){
    	try{
    		this.yjSystemUserService.update(yjSystemUserBean);
    		return 1;
    	}catch(Exception e){
    		logger.error("用户更新出错", e);
    		return 0;
    	}
    }
}