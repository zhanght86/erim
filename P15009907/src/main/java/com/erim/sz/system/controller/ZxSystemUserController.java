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
import com.erim.sz.common.util.AddressUtils;
import com.erim.sz.system.bean.ZxSystemUserBean;
import com.erim.sz.system.service.ZxSystemRoleService;
import com.erim.sz.system.service.ZxSystemUserService;
import com.erim.sz.web.util.CommonUtil;
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
public class ZxSystemUserController {

	//声明日志
	private Logger logger = Logger.getLogger(ZxSystemFuncController.class);
	
	@Autowired
	private ZxSystemUserService zxSystemUserService;
	@Autowired
	private ZxSystemRoleService zxSystemRoleService;
	
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
		return this.zxSystemUserService.ajaxCheckLoginName(fieldId,fieldValue);
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
    @RequestMapping(value="/zx/user/login")
    public String login(ModelMap model,String username,String password, String checkcode,HttpServletRequest request){
    	
    	// 验证码
    	String code = (String) SecurityUtils.getSubject().getSession().getAttribute("sessionCode");
    	
    	// 判断用户名是否为空
    	if(StringUtils.isEmpty(username)) return "redirect:/login";
    	
    	// 判断验证码是否正确
    	if (!checkcode.equals(code)) {
    		model.put("errorMsg", "验证码输入错误");
    		return loginPage();
    	}
    		
		//判断是否登录
		if(this.zxSystemUserService.isLogin(model,username, password)){
			// 用户登陆之后更改登陆时间 和登陆IP
			String userName =  SecurityUtils.getSubject().getSession().getAttribute("userName").toString();
			if(StringUtils.isNotBlank(userName)) {
				// 获取当IP
				String ip = IP4.getIP4(request);
				ZxSystemUserBean user = zxSystemUserService.selectUserByLoginname(userName);
				user.setZxLastLoginIp(ip);
				user.setZxLastLoginTime(new Date());
				user.setZxLastLoginAddress(AddressUtils.getAddresses("ip=" + ip, "utf-8"));
				// 修改登录状态
				zxSystemUserService.updateLogin(user);
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
    @RequestMapping(value="/zx/user/updatePsd")
    public  @ResponseBody Integer updatePsd(ModelMap model,HttpServletRequest request){
    	return this.zxSystemUserService.updatePsd(request);
    }
    
    /**
     * @Title: updatePadPage 
     * @Description: 跳转修改密码页面
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/zx/user/updatePadPage")
    public String updatePadPage(){
    	return "/zx/user/updatePsd";
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
    	this.zxSystemUserService.loginOut();
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
    @RequestMapping(value="/zx/user/list")
    public String showUser(ModelMap model,@ModelAttribute("cmsSystemUser") ZxSystemUserBean cmsSystemUserBean) throws ErimException{
    	this.zxSystemUserService.selectPage(cmsSystemUserBean, model);
		return "/zx/user/list";
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增页面
     * @param @param model
     * @param @param zxSystemUserBean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/zx/user/insertPage")
    public String insertPage(ModelMap model){
    	int cpyid = CommonUtil.getCpyId();
    	model.addAttribute("roleList", this.zxSystemRoleService.selectZxSystemRoleByCpyId(cpyid));
    	return "/zx/user/insert";
    }
    
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增
     * @param @param model
     * @param @param zxSystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/zx/user/insert")
    public int insert(ModelMap model,ZxSystemUserBean zxSystemUserBean){
    	try{
    		//获取新增用户名登录账号
    		String username = zxSystemUserBean.getZxUserLoginname();
    		if(StringUtils.isNotBlank(username)){
    			ZxSystemUserBean user = this.zxSystemUserService.selectUserByLoginname(username);
    			//如果用户名存在则返回失败
    			if(null!=user) return 0;
    			this.zxSystemUserService.insert(zxSystemUserBean);
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
    @RequestMapping(value="/zx/user/updatePage")
    public String updatePage(ModelMap model,int id){
    	//用户角色信息
    	int cpyid = CommonUtil.getCpyId();
    	model.addAttribute("roleList", this.zxSystemRoleService.selectZxSystemRoleByCpyId(cpyid));
    	//查询id值为id的对象
    	this.zxSystemUserService.selectUserById(id,model);
    	return "/zx/user/update";
    }
    
    @ResponseBody
    @RequestMapping(value="/zx/user/update")
    public int update(ModelMap model,ZxSystemUserBean zxSystemUserBean){
    	try{
    		this.zxSystemUserService.update(zxSystemUserBean);
    		return 1;
    	}catch(Exception e){
    		logger.error("用户更新出错", e);
    		return 0;
    	}
    }
    /**
     * @throws ErimException 
     * @Title: delete 
     * @Description:  停用
     * @param @param model
     * @param @param id
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @throws
     */
    @RequestMapping(value="/zx/user/delete")
    public String delete(ModelMap model,ZxSystemUserBean zxSystemUserBean) throws ErimException{
		this.zxSystemUserService.delete(zxSystemUserBean);
		return this.showUser(model, zxSystemUserBean);
    }
}