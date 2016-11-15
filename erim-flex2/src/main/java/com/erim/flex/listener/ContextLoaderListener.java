/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ContextLoaderListener.java : 2011-10-9 下午1:30:40
 */
package com.erim.flex.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.erim.utils.spring.ContextUtils;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-9 下午1:30:40
 * @description 自定义ServletContextListener，用于加载Spring上下文
 */
public class ContextLoaderListener implements ServletContextListener {

    /**
     * 初始化加载Spring上下文
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ContextUtils.getContext();
    }

    /**
     * 销毁
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
