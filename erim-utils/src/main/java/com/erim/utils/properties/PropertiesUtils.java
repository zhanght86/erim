/**
 * Copyright (c) e-rimming.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * PropertiesUtils.java : 2012-7-12 下午06:29:10
 */
package com.erim.utils.properties;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-7-12 下午06:29:10
 * @description 加载application.properties配置文件
 */
public class PropertiesUtils {

    /**
     * 全局静态Properties
     */
    private static Properties p;

    /**
     * 设置Properties
     * 
     * @param p
     */
    public void setProperties(Properties p) {
        PropertiesUtils.p = p;
    }

    /**
     * 获取Properties
     * 
     * @return
     */
    public static Properties getProperties() {
        if (p == null) {
            try {
                p = loadProperties();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    /**
     * 获取Properties文件中对应的key值
     * 
     * @param key
     * @return value
     */
    public static String getPropertyByKey(String key) {
        return getProperties().getProperty(key);
    }

    /**
     * 加载全部properties文件
     * @throws IOException 
     */
    public static synchronized Properties loadProperties() throws IOException {
        return PropertiesLoaderUtils.loadAllProperties("application.properties");
    }

}
