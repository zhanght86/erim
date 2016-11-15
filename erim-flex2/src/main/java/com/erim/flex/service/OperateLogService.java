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

import com.erim.flex.bean.FuncBean;

/**
 * @author 宋哲
 * @version 创建时间：2012-2-2 下午4:27:30
 * @description 功能管理
 */
@Service("operatelog")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class OperateLogService extends AbstractService<FuncBean> {

    // --------------------------------------------------------------------------
    //
    // Methods Implements
    //
    // --------------------------------------------------------------------------

    @Override
    public String getNameSpace() {
        return "operatelog";
    }

    // --------------------------------------------------------------------------
    //
    // Methods Extends
    //
    // --------------------------------------------------------------------------

}