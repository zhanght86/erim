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
import com.erim.sz.system.bean.SellSystemUserBean;
import com.erim.sz.system.service.SellSystemRoleService;
import com.erim.sz.system.service.SellSystemUserService;
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
public class SellSystemUserController {

	//声明日志
	private Logger logger = Logger.getLogger(SellSystemFuncController.class);
	
	@Autowired
	private SellSystemUserService sellSystemUserService;
	@Autowired
	private SellSystemRoleService sellSystemRoleService;
	
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
		return this.sellSystemUserService.ajaxCheckLoginName(fieldId,fieldValue);
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
     * @Title: lgoin 
     * @Description: 登录方法
     * @param @param model
     * @param @param request
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/sell/user/login")
    public String login(ModelMap model,String username,String password, String checkcode,HttpServletRequest request) {
    	
    	String code = (String) SecurityUtils.getSubject().getSession().getAttribute("sessionCode");
    	
    	if (StringUtils.isEmpty(username)) return "redirect:/login";
    	
    	if (!checkcode.equals(code)) {
    		model.addAttribute("errorMsg", "验证码输入错误");
    		return loginPage();
    	}
    	
    	//判断是否登录
    	if(sellSystemUserService.isLogin(model,username, password)) {
    		// 用户登陆之后更改登陆时间 和登陆IP
			String userName =  SecurityUtils.getSubject().getSession().getAttribute("userName").toString();
			if(StringUtils.isNotBlank(userName)) {
				// 获取当IP
				String ip = IP4.getIP4(request);
				SellSystemUserBean user = sellSystemUserService.selectUserByLoginname(userName);
				user.setSellLastLoginIp(ip);
				user.setSellLastLoginTime(new Date());
				user.setSellLastLoginAddress(AddressUtils.getAddresses("ip=" + ip, "utf-8"));
				// 修改登录状态
				sellSystemUserService.updateLogin(user);
			}
    		return "redirect:/index";
    	}
    	return loginPage();
    }
    
    /**
     * @Title: updatePsd 
     * @Description: 修改密码
     * @param @param model
     * @param @param loginname
     * @param @param psd
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/sell/user/updatePsd")
    public @ResponseBody Integer updatePsd(HttpServletRequest request){
    	return this.sellSystemUserService.updatePsd(request);
    }
    
    /**
     * @Title: updatePadPage 
     * @Description: 跳转修改密码页面
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/sell/user/updatePadPage")
    public String updatePadPage(){
    	return "/sell/user/updatePsd";
    }
    
    /**
     * @方法名：ajaxCheckOldPwd 
     * @描述: 判断原密码是否正确
     * @作者： 贺渊博
     * @创建时间：2015年11月12日 下午3:59:07
     * @param oldPwd
     * @param sellUserLoginname
     */
    @RequestMapping(value="/sell/user/oldPwd")
    public @ResponseBody Integer ajaxCheckOldPwd(String oldPwd){
    	return sellSystemUserService.checkOldPwd(oldPwd);
    }
    
    /**
     * @Title: loginOut 
     * @Description: 注销用户
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping("loginOut")
    private String loginOut(){
    	this.sellSystemUserService.loginOut();
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
    @RequestMapping(value="/sell/user/list")
    public String showUser(ModelMap model,@ModelAttribute("cmsSystemUser") SellSystemUserBean cmsSystemUserBean) throws ErimException{
    	this.sellSystemUserService.selectPage(cmsSystemUserBean, model);
		return "/sell/user/list";
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增页面
     * @param @param model
     * @param @param sellSystemUserBean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/sell/user/insertPage")
    public String insertPage(ModelMap model){
    	int cpyid = (Integer)SecurityUtils.getSubject().getSession().getAttribute("userCpyId");
    	model.addAttribute("roleList", this.sellSystemRoleService.selectSellSystemRoleByCpyId(cpyid));
    	return "/sell/user/insert";
    }
    
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增
     * @param @param model
     * @param @param sellSystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/sell/user/insert")
    public int insert(ModelMap model,SellSystemUserBean sellSystemUserBean){
    	try{
    		//获取新增用户名登录账号
    		String username = sellSystemUserBean.getSellUserLoginname();
    		if(StringUtils.isNotBlank(username)){
    			SellSystemUserBean user = this.sellSystemUserService.selectUserByLoginname(username);
    			//如果用户名存在则返回失败
    			if(null!=user) return 0;
    			sellSystemUserBean.setSellIsDelStatus("1");
    			this.sellSystemUserService.insert(sellSystemUserBean);
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
    @RequestMapping(value="/sell/user/updatePage")
    public String updatePage(ModelMap model,int id){
    	//用户角色信息
    	int cpyid = (Integer)SecurityUtils.getSubject().getSession().getAttribute("userCpyId");
    	model.addAttribute("roleList", this.sellSystemRoleService.selectSellSystemRoleByCpyId(cpyid));
    	//查询id值为id的对象
    	this.sellSystemUserService.selectUserById(id,model);
    	return "/sell/user/update";
    }
    
    @ResponseBody
    @RequestMapping(value="/sell/user/update")
    public int update(ModelMap model,SellSystemUserBean sellSystemUserBean){
    	try{
    		this.sellSystemUserService.update(sellSystemUserBean);
    		return 1;
    	}catch(Exception e){
    		logger.error("用户更新出错", e);
    		return 0;
    	}
    }
   /**
    * @描述: 是否停用
    * @作者: （heyuanbo）
    * @创建时间: 2015年12月30日 下午8:07:30
    * @param model
    * @param bean
    * @return 返回类型 String
    * @throws ErimException
    */
 @RequestMapping(value="/sell/user/delete")   
public String delete(ModelMap model,SellSystemUserBean bean) throws ErimException{
    	this.sellSystemUserService.delete(bean);
    	return this.showUser(model, bean);
    }
}