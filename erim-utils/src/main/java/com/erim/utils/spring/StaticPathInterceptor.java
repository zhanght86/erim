/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * StaticInterceptor.java : 2012-4-20 上午9:41:35
 */
package com.erim.utils.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.erim.utils.properties.PropertiesUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-4-20 上午9:41:35
 * @description 于每个handler执行前，设置static文件访问地址用于前端模板获取。
 */
public class StaticPathInterceptor implements HandlerInterceptor {

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
        if (modelAndView.getViewName().indexOf("redirect:") == -1) {
            // 将appRoot放入request
            modelAndView.addObject("staticRoot", PropertiesUtils.getPropertyByKey("app.staticRoot"));
            // 将staticRoot放入request
            modelAndView.addObject("appRoot", PropertiesUtils.getPropertyByKey("app.appRoot"));
            // 将url放入到
            modelAndView.addObject("requestPath", request.getServletPath());
        }
    }

    /**
     * 最后执行，可用于释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}