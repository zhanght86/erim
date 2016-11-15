/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ErimUtils.java : 2012-3-19 上午1:55:29
 */
package com.erim.flexuser.util;

import com.erim.flexuser.server.UDataService;
import com.erim.utils.spring.ContextUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-3-19 上午1:55:29
 * @description
 */
public class ErimUtils {

    /**
     * 清空单例管理员相关数据
     */
    public static void clearUser() {
        ContextUtils.getContext().getBean("udata", UDataService.class).clearUser();
    }

    /**
     * 清空单例管理员角色相关数据
     */
    public static void clearRole() {
        ContextUtils.getContext().getBean("udata", UDataService.class).clearRole();
    }

}