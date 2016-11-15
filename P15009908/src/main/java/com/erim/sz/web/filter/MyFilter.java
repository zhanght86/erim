/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * MyFilter.java : 2012-4-20 上午9:41:35
 */
package com.erim.sz.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.erim.core.exception.ErimException;
import com.erim.sz.company.service.CompanyDetailService;
import com.erim.sz.cus.bean.CusSystemUserBean;
import com.erim.sz.cus.dao.CusSystemUserDao;
import com.erim.sz.cus.service.CusSystemRescourceService;
import com.erim.utils.properties.PropertiesUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-4-20 上午9:41:35
 * @description 于每个handler执行前，设置static文件访问地址用于前端模板获取。
 */
public class MyFilter implements HandlerInterceptor {
	
	//声明日志
	private Logger logger          = Logger.getLogger(HandlerInterceptor.class);

	@Autowired
    private CusSystemUserDao 		  userDao;
	@Autowired
	private CusSystemRescourceService cusSystemRescourceService;
	@Autowired
	private CompanyDetailService      companyDetailService;
	
    /**
     * 动作交互之前拦截
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    /**
     * 动作交互之后，生成试图之前拦截
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    	
    	//System.out.println("拦截器:MyFilter:"+request.getRequestURI());
    	logger.info("拦截器:MyFilter:"+request.getRequestURI());
    	
        // 当ModelAndView为null时直接返回
        if (modelAndView == null) {
            return;
        }

        // 当视图名称为重定向时不进行拦截
        if (modelAndView.getViewName().indexOf("redirect:") != -1) {
            return;
        }

        // 将appRoot放入modelAndView
        modelAndView.addObject("staticRoot", PropertiesUtils.getPropertyByKey("app.staticRoot"));

        // 将root放入modelAndView
        modelAndView.addObject("appRoot", PropertiesUtils.getPropertyByKey("app.appRoot"));
        
        // 将插件地址放入request
        modelAndView.addObject("staticFilePlug", PropertiesUtils.getPropertyByKey("app.staticFilePlug"));
        
        // 将图片地址放入request
        modelAndView.addObject("staticFileRes", PropertiesUtils.getPropertyByKey("app.staticFileRes"));
        
        // 将外网网址放入request
        modelAndView.addObject("webRoot", PropertiesUtils.getPropertyByKey("app.webRoot"));
        
        // 将文件址放入request
        modelAndView.addObject("staticFileRes", PropertiesUtils.getPropertyByKey("app.staticFileRes"));

        //将上传路径地址放入request
        modelAndView.addObject("staticFileUpload", PropertiesUtils.getPropertyByKey("app.staticFileUpload"));
        
        // 删除服务器图片
        modelAndView.addObject("staticFileDelete", PropertiesUtils.getPropertyByKey("app.staticFileDelete"));
        
        
        //System.out.println("SecurityUtils.getSubject().isAuthenticated():" + SecurityUtils.getSubject().isAuthenticated());
        
        logger.info("SecurityUtils.getSubject().isAuthenticated():" + SecurityUtils.getSubject().isAuthenticated());
        
        // 将认证信息放入modelAndView
        if (SecurityUtils.getSubject().isAuthenticated()) {

            // 判断session是否有信息
            if (SecurityUtils.getSubject().getSession().getAttribute("userName") == null) {

                // 查询客户其他信息信息
            	CusSystemUserBean bean = userDao.selectUserByLoginname(SecurityUtils.getSubject().getPrincipal().toString());

                // 若账户已经被删除
                if (bean == null) {
                    SecurityUtils.getSubject().logout();
                    return;
                }

                //添加用户基本信息
	            SecurityUtils.getSubject().getSession().setAttribute("userName", bean.getCusUserLoginname());
	            SecurityUtils.getSubject().getSession().setAttribute("userRealname", bean.getCusUserRealname());
	            SecurityUtils.getSubject().getSession().setAttribute("userRoleId", bean.getCusRoleId());

	            //获取角色名称
	            SecurityUtils.getSubject().getSession().setAttribute("userRoleName", bean.getCusRoleId());
	            
	            //获取用户企业信息
	            SecurityUtils.getSubject().getSession().setAttribute("userCpyId",bean.getCpyId());
	            SecurityUtils.getSubject().getSession().setAttribute("userCpyName",bean.getCpyName());
	            SecurityUtils.getSubject().getSession().setAttribute("userCommpany", this.companyDetailService.selectById(bean.getCpyId()));
	            
            }else{
            	//获取当前路径
            	String uri = request.getRequestURI();
            	
            	if(!uri.contains("/index;")){
            		
            		//是否包含权限
                	boolean isHaveAuthorityByRoleUrl = this.cusSystemRescourceService.isHavaAuthorityByRoleUrl(uri);
                	if(!isHaveAuthorityByRoleUrl){
                		throw new ErimException("没有权限");
                	}
            	}
            }
        }
    }

    /**
     * VM页面渲染后执行，处理内存释放等
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}