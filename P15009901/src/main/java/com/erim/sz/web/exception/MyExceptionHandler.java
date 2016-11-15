/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * MyExceptionHandler.java : 2013-06-30
 */
package com.erim.sz.web.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import com.erim.sz.common.bean.MallUsersBean;
import com.erim.sz.web.service.MallUsersService;
import com.erim.utils.properties.PropertiesUtils;

/**
 * @author 宋哲
 * @version 创建时间：2013-6-30 下午05:09:43
 * @description 用于拦截错误页面显示，带入配置文件中的值
 */
public class MyExceptionHandler extends HandlerExceptionResolverComposite {

	@Autowired
    private MallUsersService userService;

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        // 打印错误详细信息
        ex.printStackTrace();

        // 获取错误详细信息
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw, true));

        Map<String, Object> model = new HashMap<String, Object>();

        // 错误信息
        model.put("exception", ex);

        // 错误明细
        model.put("exdetail", sw.toString());

        // 将appRoot放入request
        model.put("staticRoot", PropertiesUtils.getPropertyByKey("app.staticRoot"));

        // 将fileRes放到modelAndView
        model.put("staticFileRes", PropertiesUtils.getPropertyByKey("app.staticFileRes"));
        
        // 将root放入request
        model.put("appRoot", PropertiesUtils.getPropertyByKey("app.appRoot"));

        // 将认证信息放入modelAndView
        if (SecurityUtils.getSubject().isAuthenticated() || SecurityUtils.getSubject().isRemembered()) {

            // 判断session是否有信息
            if (SecurityUtils.getSubject().getSession().getAttribute("userName") == null) {

                // 查询客户其他信息信息
            	MallUsersBean bean = userService.selectByLoginName(SecurityUtils.getSubject().getPrincipal().toString());

                // 若账户已经被删除
                if (bean == null) {
                    SecurityUtils.getSubject().logout();
                    return new ModelAndView("html/http/5001", model);
                }

                // 添加session信息--customerRealname/customerIsVip/customerProfession/customerSex
                SecurityUtils.getSubject().getSession().setAttribute("loginName", bean.getMluLoginname());
            }

            // 设置其他属性
            model.put("globalUserName", SecurityUtils.getSubject().getSession().getAttribute("userRealname"));

            // 设置登录状态
            model.put("globalIsLogin", true);
        }

        return new ModelAndView("html/http/5001", model);
    }
}
