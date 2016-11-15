/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ErimUtils.java : 2012-3-19 上午1:55:29
 */
package com.erim.flex.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.erim.core.lang.ExtHashMap;
import com.erim.flex.bean.FuncBean;
import com.erim.flex.bean.PageBean;
import com.erim.flex.bean.PageDetailBean;
import com.erim.flex.service.AbstractService;
import com.erim.flex.service.DataService;
import com.erim.utils.security.MaskUtils;
import com.erim.utils.spring.ContextUtils;

import flex.messaging.FlexContext;

/**
 * @author 宋哲
 * @version 创建时间：2012-3-19 上午1:55:29
 * @description
 */
public class ErimUtils {

    /**
     * 通过session获取用户是否对某一功能权限名有权限
     * 
     * @param auth 功能权限名
     * @return 是否有权限
     */
    public static boolean hasAuth(String auth) {

        // 若auth为空则不需要验证权限，返回true，用于链接按钮显示
        if (auth == null || "".equals(auth)) {
            return true;
        }

        // session获取权限对应键值
        Object omask = FlexContext.getFlexSession().getAttribute("userAuth");

        // 当session中无值时返回无权限
        if (omask == null) {
            return false;
        }

        // 字符型权限
        String mask = FlexContext.getFlexSession().getAttribute("userAuth").toString();

        // 需要验证权限对应的功能ID
        Integer funcId = ErimUtils.getFuncIdByAuth(auth);

        if (funcId == null) {
            return false;
        }

        return MaskUtils.getMask(mask, funcId);
    }

    /**
     * 根据权限字符串获取功能ID
     * 
     * @param auth 将要验证的功能字符串
     * @return 功能
     */
    public static Integer getFuncIdByAuth(String auth) {
        return ContextUtils.getContext().getBean("data", DataService.class).getMapFunc().get(auth);
    }

    /**
     * 根据pagename获取页面信息
     * 
     * @param pagename
     * @return PageBean
     */
    public static PageBean getPageBeanByPageName(String pagename) {
        return ContextUtils.getContext().getBean("data", DataService.class).getMapPageName().get(pagename);
    }

    /**
     * 根据页面名称获取页面详细列表
     * 
     * @param pagename
     * @return List<PageDetailBean>
     */
    public static List<PageDetailBean> getPageDetailListByPageName(String pagename) {
        return ContextUtils.getContext().getBean("data", DataService.class).getMapPageDetail().get(pagename);
    }

    /**
     * 根据页面名称获取页面详细列表，仅用于工具类，显示原生组件，除数据源外，其他的不做更改
     * 
     * @param pagename
     * @return List<PageDetailBean>
     */
    public static List<PageDetailBean> getPageDetailListToolsByPageName(String pagename) {
        return ContextUtils.getContext().getBean("data", DataService.class).getMapPageDetailTools().get(pagename);
    }

    /**
     * 根据代码序号获取对应的键值对集合(数据源)
     * 
     * @param codeNo 代码序号
     * @return 数据源
     */
    public static ExtHashMap<String, String> getCodeByCodeId(String codeNo) {
        return ContextUtils.getContext().getBean("data", DataService.class).getSystemCode().get(codeNo);
    }

    /**
     * 根据代码序号获取对应的键值对的值
     * 
     * @param codeNo 代码序号
     * @param codeKey 代码键
     * @return codeValue 代码值
     */
    public static String getCodeValyeByCodeIdAndCodeKey(String codeNo, String codeKey) {
        return ContextUtils.getContext().getBean("data", DataService.class).getSystemCode().get(codeNo).get(codeKey);
    }

    /**
     * 获取功能信息列表集合
     * 
     * @return
     */
    public static List<FuncBean> getFuncList() {
        return ContextUtils.getContext().getBean("data", DataService.class).getFuncList();
    }

    /**
     * 清空单例所有数据，便于重新加载数据
     */
    public static void clearAll() {

        // 清空公共数据源单例对象
        ContextUtils.getContext().getBean("data", AbstractService.class).clearAll();

        // 清空私有数据源单例对象
        ContextUtils.getContext().getBean("cdata", AbstractService.class).clearAll();

        // 清空用户相关数据源单例对象
        ContextUtils.getContext().getBean("udata", AbstractService.class).clearAll();
    }

    /**
     * 清空单例功能相关数据
     */
    public static void clearFunc() {
        ContextUtils.getContext().getBean("data", DataService.class).clearFunc();
    }

    /**
     * 清空单例页面相关数据
     */
    public static void clearPage() {
        ContextUtils.getContext().getBean("data", DataService.class).clearPage();
    }

    /**
     * 清空单例代码相关数据
     */
    public static void clearCode() {
        ContextUtils.getContext().getBean("data", DataService.class).clearCode();
    }

    /**
     * 根据flex传入的key值获取选中行对应的value
     * 
     * @param map 
     * @param key
     * @return value
     */
    public static String getColumnByExtMap(ExtHashMap<String, Object> map, String key) {
        if (map.get("dataitems") == null) {
            return null;
        }
        @SuppressWarnings("unchecked")
        ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>) map.get("dataitems");
        if (list.get(0).get(key) == null) {
            return null;
        }
        return list.get(0).get(key).toString();
    }

}