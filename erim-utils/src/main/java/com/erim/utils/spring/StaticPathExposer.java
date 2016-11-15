/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * StaticPathExposer.java : 2012-4-20 上午11:36:39
 */
package com.erim.utils.spring;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

import com.erim.utils.properties.PropertiesUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-4-20 上午11:36:39
 * @description 容器加载的时候用于初始化mvc:resources的mapping
 */
public class StaticPathExposer implements ServletContextAware {

    /**
     * WEB上下文
     */
    private ServletContext servletContext;

    /**
     * 静态资源映射路径，主要为CSS\JS\IMG
     */
    private String         staticMapping;

    /**
     * 自动调用
     */
    public void init() {
        // 获取静态资源映射路径
        staticMapping = PropertiesUtils.getPropertyByKey("app.staticMapping");
        // 设置页面的静态资源映射路径,可在前端获取(JSP/VM)
        getServletContext().setAttribute("staticMapping", staticMapping);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public String getStaticMapping() {
        return staticMapping;
    }

}