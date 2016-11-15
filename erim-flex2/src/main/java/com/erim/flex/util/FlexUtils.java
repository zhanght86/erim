/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * FlexUtils.java : 2011-10-9 上午10:23:07
 */
package com.erim.flex.util;

import com.erim.core.exception.BusinessException;
import com.erim.core.exception.ErimException;
import com.erim.core.exception.SystemException;
import com.erim.flex.bean.JavaBean;

import flex.messaging.io.amf.ASObject;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-9 上午10:23:07
 * @description Flex信息传输工具集合
 */
public class FlexUtils {

    /**
     * 转换Flex端传入的对象为JavaBean
     * 
     * @param asobject
     * @return JavaBean
     * @throws ErimException
     */
    @SuppressWarnings("unchecked")
    public static JavaBean convertASObject(ASObject asobject) throws ErimException {

        // 验证入参是否为null
        if (asobject.get("beanName") == null)
            throw new BusinessException("由Flex端传入数据格式错误，找不到对应的BeanName!");
        if (asobject.get("taskName") == null)
            throw new BusinessException("由Flex端传入数据格式错误，找不到对应的TaskName!");

        // 获取beanName和taskName
        String beanName = asobject.get("beanName").toString();
        String taskName = asobject.get("taskName").toString();

        // 验证入参是否为空
        if (beanName == "")
            throw new SystemException("由Flex端传入数据格式错误，BeanName为空字符串!");
        if (taskName == "")
            throw new SystemException("由Flex端传入数据格式错误，TaskName为空字符串!");

        // 创建JavaBean
        JavaBean javabean = new JavaBean();
        javabean.setBeanName(beanName);
        javabean.setTaskName(taskName);
        javabean.setArgs((ASObject) asobject.get("args"));
        javabean.getArgs().put("beanname", beanName);
        javabean.getArgs().put("taskname", taskName);

        // 返回JavaBean
        return javabean;
    }

}
