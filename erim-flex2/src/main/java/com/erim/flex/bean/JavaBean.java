/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * JavaBean.java : 2011-10-09
 */
package com.erim.flex.bean;

import java.io.Serializable;

import flex.messaging.io.amf.ASObject;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-09
 * @description 由Flex端传至Java端的对象
 */
public class JavaBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID = 1L;

    /** bean名称 */
    private String            beanName;

    /** task名称 */
    private String            taskName;

    /** 传入参数 */
    private ASObject          args;

    /**
     * 默认构造函数
     */
    public JavaBean() {
        super();
    }

    /**
     * 取得bean名称
     * 
     * @return bean名称
     */
    public String getBeanName() {
        return beanName;
    }

    /**
     * 设置bean名称
     * 
     * @param beanName bean名称
     */
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    /**
     * 取得task名称
     * 
     * @return task名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置task名称
     * 
     * @param taskName task名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * 取得传入参数
     * 
     * @return 传入参数
     */
    public ASObject getArgs() {
        return args;
    }

    /**
     * 设置传入参数
     * 
     * @param args 传入参数
     */
    public void setArgs(ASObject args) {
        this.args = args;
    }

}