/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * DispatchService.java : 2011-10-8 下午12:55:19
 */
package com.erim.flex.dispatch;

import org.springframework.context.ApplicationContext;

import com.erim.core.exception.ErimException;
import com.erim.core.exception.SystemException;
import com.erim.flex.bean.FlexBean;
import com.erim.flex.bean.JavaBean;
import com.erim.flex.service.AbstractService;
import com.erim.flex.util.ErimUtils;
import com.erim.flex.util.FlexUtils;
import com.erim.utils.lang.DateUtils;
import com.erim.utils.reflect.ReflectionUtils;
import com.erim.utils.spring.ContextUtils;

import flex.messaging.FlexContext;
import flex.messaging.io.amf.ASObject;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-8 下午12:55:19
 * @description flex端与java端进行通信的服务转发类
 */
public class DispatchService {

    /**
     * 分发服务
     * 
     * @param remoteObject flex端传入对象
     * @return 返回flex端的值
     * @throws ErimException
     */
    public FlexBean dispatchService(ASObject asobject) throws ErimException {

        // Spring上下文
        ApplicationContext context = null;

        // 业务逻辑类
        @SuppressWarnings("rawtypes")
        AbstractService service = null;

        // 传入值
        JavaBean javaBean = null;

        // 返回值
        FlexBean flexBean = null;

        context = ContextUtils.getContext();
        javaBean = FlexUtils.convertASObject(asobject);

        String beanName = javaBean.getBeanName();
        String taskName = javaBean.getTaskName();

        System.out.println("＝＝＝＝S＝＝＝＝＞" + beanName + ":" + taskName);

        // 权限验证，当登录和使用tools的时候不进行验证
        if (("security".equals(beanName) && "login".equals(taskName))) {
        } else {

            // 判断是否已经登录
            if (FlexContext.getFlexSession().getAttribute("userId") == null) {
                throw new SystemException("用户会话过期，请重新登录!");
            }

            // 验证权限
            // 1.当taskname为init的时候不进行权限验证（即菜单和按钮通过其他途径验证）
            // 2.当taskname以auth开头的时候不进行权限验证 
            if ("init".equals(taskName) || (taskName.length() > 4 && "auth".equals(taskName.substring(0, 4)))) {
            } else {
                // 当taskname以auth开始的时候不进行权限验证
                if (!ErimUtils.hasAuth(beanName + "_" + taskName)) {
                    throw new SystemException("用户没有该动作权限，请联系系统管理员!");
                }
            }

        }

        // 获取Spring管理的Bean
        try {
            service = context.getBean(beanName, AbstractService.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException("Spring上下文无法获取名为" + javaBean.getBeanName() + "的Bean!");
        }

        // 映射执行对应的方法
        try {

            // 直接调用init方法
            flexBean = service.initArgs(javaBean.getArgs());

            // 直接调用before方法
            service.before();

            // 反射调用task方法
            if ("init".equals(taskName)) {
                service.init();
            } else if ("list".equals(taskName)) {
                service.list();
            } else if ("query".equals(taskName)) {
                service.query();
            } else if ("insert".equals(taskName)) {
                service.insert();
            } else if ("update".equals(taskName)) {
                service.update();
            } else if ("delete".equals(taskName)) {
                service.delete();
            } else if ("select".equals(taskName)) {
                service.select();
            } else {
                ReflectionUtils.invokeMethod(service, javaBean.getTaskName(), null, null);
            }

            // 直接调用after方法
            service.after();

            // 记录操作日志，当登录和使用tools以及不需要验证权限的均不进行操作日志记录，若需要则自己在方法里添加
            if (("security".equals(beanName) && "login".equals(taskName)) || "init".equals(taskName) || (taskName.length() > 4 && "auth".equals(taskName.substring(0, 4)))) {
            } else {
                service.insertOperateLog();
            }

            System.out.println("＝＝＝＝E＝＝＝＝＞" + flexBean.getBackFlag() + ":" + DateUtils.getCurrentDate() + ":" + FlexContext.getFlexSession().getAttribute("userName") + "\n");

        } catch (ErimException e) {
            throw new ErimException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErimException(e.getMessage());
        }

        // 返回
        return flexBean;
    }
}