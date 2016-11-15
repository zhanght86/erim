/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ContextUtils.java : 2011-10-8 下午12:49:19
 */
package com.erim.utils.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-8 下午12:49:19
 * @description Spring中ApplicationContext工具集合
 */
public class ContextUtils {

    /**
     * ApplicationContext 单子实例
     */
    private static ApplicationContext context;

    /**
     * 设置ApplicationContext
     */
    public void setContext(ApplicationContext context) {
        ContextUtils.context = context;
    }

    /**
     * 获取ApplicationContext
     */
    public static ApplicationContext getContext() {
        if (context == null) {
            context = loadContext();
        }
        return context;
    }

    /**
     * 释放ApplicationContext
     */
    public static synchronized void releaseContext() {
        context = null;
        context = loadContext();
    }

    /**
     * 加载ApplicationContext
     */
    public static synchronized ApplicationContext loadContext() {
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }

}