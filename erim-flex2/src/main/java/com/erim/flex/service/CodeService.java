/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * CodeService.java : 2012-3-16 下午6:04:29
 */
package com.erim.flex.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.exception.BusinessException;
import com.erim.core.exception.ErimException;
import com.erim.flex.bean.CodeBean;
import com.erim.flex.util.ErimUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-3-16 下午6:04:29
 * @description 代码管理
 */
@Service("code")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CodeService extends AbstractService<CodeBean> {

    // --------------------------------------------------------------------------
    //
    // Methods Implements
    //
    // --------------------------------------------------------------------------

    @Override
    public String getNameSpace() {
        return "code";
    }

    // --------------------------------------------------------------------------
    //
    // Methods Extends
    //
    // --------------------------------------------------------------------------

    /**
     * 1.增加代码前判断代码是否已经存在。<br>
     * 2.增加代码后清空代码相关静态变量
     */
    @Override
    public void insert() throws ErimException {
        CodeBean bean = getSqlSession().selectOne(getNameSpace() + ".selectEntityById", _inHashMap);
        if (bean != null) {
            throw new BusinessException("该代码数据已经存在！");
        }
        super.insert();
        ErimUtils.clearCode();
    }

    /**
     * 1.修改代码前判断代码是否已经存在。<br>
     * 2.修改代码后清空代码相关静态变量
     */
    @Override
    public void update() throws ErimException {
        // 当更改id，判断是否已经存在
        if (commonGetColumn("codeId").equals(_inHashMap.getString("codeId")) && commonGetColumn("codeKey").equals(_inHashMap.getString("codeKey"))) {
        } else {
            CodeBean bean = getSqlSession().selectOne(getNameSpace() + ".selectEntityById", _inHashMap);
            if (bean != null) {
                throw new BusinessException("该代码数据已经存在！");
            }
        }
        super.update();
        ErimUtils.clearCode();
    }

    /**
     * 1.删除代码后清空代码相关静态变量
     */
    @Override
    public void delete() throws ErimException {
        super.delete();
        ErimUtils.clearCode();
    }

}