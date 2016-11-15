/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * DataService.java : 2012-8-22 上午2:26:09
 */
package com.erim.flexuser.server;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.exception.ErimException;
import com.erim.core.lang.ExtHashMap;
import com.erim.flex.service.AbstractService;
import com.erim.flexuser.bean.RoleBean;
import com.erim.flexuser.bean.UserBean;

/**
 * @author 宋哲
 * @version 创建时间：2012-8-13 上午2:26:09
 * @description 用户相关数据源及单例存储
 */
@Service("udata")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class UDataService extends AbstractService<UserBean> {

    // --------------------------------------------------------------------------
    //
    // Variables
    //
    // --------------------------------------------------------------------------

    /** 用户信息键值对{用户ID:用户名称，用于数据源 } */
    private ExtHashMap<String, String> hashMapUser;

    /** 用户信息键值对{角色ID:角色名称，用于数据源 } */
    private ExtHashMap<String, String> hashMapRole;

    // --------------------------------------------------------------------------
    //
    // Constructor
    //
    // --------------------------------------------------------------------------

    @PostConstruct
    public void initDataService() throws ErimException {
        hashMapUser = user();
        hashMapRole = role();
    }

    // --------------------------------------------------------------------------
    //
    // Methods Implements
    //
    // --------------------------------------------------------------------------

    @Override
    public String getNameSpace() {
        return "";
    }

    // --------------------------------------------------------------------------
    //
    // Methods extends
    //
    // --------------------------------------------------------------------------

    /**
     * 清空单例所有数据，便于重新加载数据
     */
    public void clearAll() {
        clearUser();
        clearRole();
    }

    // --------------------------------------------------------------------------
    //
    // Methods
    //
    // --------------------------------------------------------------------------

    /**
     * 数据源，数据源格式：[M]{udata;user}，获取内容格式：{userid,userid:username/realname}
     * 
     * @return 用户数据源键值对
     */
    public ExtHashMap<String, String> user() {
        if (hashMapUser == null) {
            hashMapUser = new ExtHashMap<String, String>();
            List<UserBean> list = getSqlSession().selectList("user.selectAll", _inHashMap);
            for (UserBean bean : list) {
                hashMapUser.put(bean.getUserId().toString(), bean.getUserId().toString() + ":" + bean.getUserName() + "/" + bean.getUserRealname());
            }
        }
        return hashMapUser;
    }

    /**
     * 清空单例用户相关数据
     */
    public void clearUser() {
        hashMapUser = null;
    }

    /**
     * 数据源，数据源格式：[M]{udata;role}，获取内容格式：{roleid,roleid:rolename}
     * 
     * @return 用户数据源键值对
     */
    public ExtHashMap<String, String> role() {
        if (hashMapRole == null) {
            hashMapRole = new ExtHashMap<String, String>();
            List<RoleBean> list = getSqlSession().selectList("role.selectAll", _inHashMap);
            for (RoleBean bean : list) {
                hashMapRole.put(bean.getRoleId().toString(), bean.getRoleId().toString() + ":" + bean.getRoleName());
            }
        }
        return hashMapRole;
    }

    /**
     * 清空单例用户相关数据
     */
    public void clearRole() {
        hashMapRole = null;
    }

}