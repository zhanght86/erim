/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * FuncService.java : 2012-2-2 下午4:27:30
 */
package com.erim.flex.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.exception.BusinessException;
import com.erim.core.exception.ErimException;
import com.erim.flex.bean.FuncBean;
import com.erim.flex.util.ErimUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-2-2 下午4:27:30
 * @description 功能管理
 */
@Service("func")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FuncService extends AbstractService<FuncBean> {

    // --------------------------------------------------------------------------
    //
    // Methods Implements
    //
    // --------------------------------------------------------------------------

    @Override
    public String getNameSpace() {
        return "func";
    }

    // --------------------------------------------------------------------------
    //
    // Methods Extends
    //
    // --------------------------------------------------------------------------

    /**
     * 增加前进行id存在性检验
     */
    @Override
    public void insert() throws ErimException {
        FuncBean bean = commonGetEntityById();
        if (bean != null) {
            throw new BusinessException("该ID已经存在！");
        }
        bean = getSqlSession().selectOne(namespace + ".selectEntityByAuth", _inHashMap);
        if (bean != null) {
            throw new BusinessException("该权限已经存在！");
        }
        super.insert();
        ErimUtils.clearFunc();
    }

    /**
     * 修改前进行id存在性检验
     */
    @Override
    public void update() throws ErimException {
        // 当更改id，判断是否已经存在
        if (commonGetColumn("id").equals(_inHashMap.getString("id"))) {
        } else {
            FuncBean bean = commonGetEntityById();
            if (bean != null) {
                throw new BusinessException("该ID已经存在！");
            }
        }
        // 当更改auth，判断是否已经存在
        if (commonGetColumn("auth").equals(_inHashMap.getString("auth"))) {
        } else {
            FuncBean bean = getSqlSession().selectOne(namespace + ".selectEntityByAuth", _inHashMap);
            if (bean != null) {
                throw new BusinessException("该权限已经存在！");
            }
        }
        super.update();
        ErimUtils.clearFunc();
    }

    /**
     * 删除数据后清空缓存静态变量
     */
    @Override
    public void delete() throws ErimException {
        super.delete();
        ErimUtils.clearFunc();
    }

}