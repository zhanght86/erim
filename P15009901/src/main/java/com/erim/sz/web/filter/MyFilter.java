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

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.erim.sz.common.bean.MallUsersBean;
import com.erim.sz.web.service.MallUsersService;
import com.erim.utils.properties.PropertiesUtils;
import com.erim.utils.request.RequestUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-4-20 上午9:41:35
 * @description 于每个handler执行前，设置static文件访问地址用于前端模板获取。
 */
public class MyFilter implements HandlerInterceptor {

	@Autowired
    private MallUsersService userService;

    /**
     * 动作交互之前拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    /**
     * 动作交互之后，生成试图之前拦截
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

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
        // 将fileRes放到modelAndView
        modelAndView.addObject("staticFileRes", PropertiesUtils.getPropertyByKey("app.staticFileRes"));
        // 将root放入modelAndView
        modelAndView.addObject("appRoot", PropertiesUtils.getPropertyByKey("app.appRoot"));
        // 讲导游图片地址放进ModelAndView
        modelAndView.addObject("guideRoot", PropertiesUtils.getPropertyByKey("app.guideRoot"));

        // 将认证信息放入modelAndView
        if (SecurityUtils.getSubject().isAuthenticated() || SecurityUtils.getSubject().isRemembered()) {

            // 判断session是否有信息
            if (SecurityUtils.getSubject().getSession().getAttribute("userName") == null) {

                // 查询客户其他信息信息
            	MallUsersBean bean = userService.selectByLoginName(SecurityUtils.getSubject().getPrincipal().toString());

                // 若账户已经被删除
                if (bean == null) {
                    SecurityUtils.getSubject().logout();
                    return;
                }


                // 添加session信息--customerRealname/customerIsVip/customerProfession/customerSex
                SecurityUtils.getSubject().getSession().setAttribute("loginName", bean.getMluLoginname());
            }

            // 设置登录状态
            modelAndView.addObject("globalIsLogin", true);

            // 设置其他属性
            modelAndView.addObject("globalUserName", SecurityUtils.getSubject().getSession().getAttribute("userRealname"));
        }

        // 是否为Iphone或Android操作系统
        if (RequestUtils.isIphoneOrAndroid(request)) {

            // 将isIphoneOrAndroid放入modelAndView
            modelAndView.addObject("isIphoneOrAndroid", true);

            // 仅处理article开头的链接
            if (modelAndView.getViewName().indexOf("article") >= 0) {
                modelAndView.setViewName("m/" + modelAndView.getViewName());
            }
        }

    }

    /**
     * VM页面渲染后执行，处理内存释放等
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}