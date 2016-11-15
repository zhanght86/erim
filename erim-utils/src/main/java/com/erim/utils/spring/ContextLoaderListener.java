/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ContextLoaderListener.java : 2011-10-9 下午1:30:40
 */
package com.erim.utils.spring;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-9 下午1:30:40
 * @description 自定义ServletContextListener，用于加载Spring上下文。<br>
 *  web.xml添加如下内容，加载路径为ClassPath下的applicationContext.xml<br>
 *  &lt;listener&gt;<br>
 *  &lt;listener-class&gt;com.erim.utils.spring.ContextLoaderListener&lt;/listener-class&gt;<br>
 *  &lt;listener&gt;<br>
 */
public class ContextLoaderListener implements ServletContextListener {

    /**
     * 容器初始化执行，加载Spring上下文。
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ContextUtils.getContext();
    }

    /**
     * 容器销毁时执行。
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
