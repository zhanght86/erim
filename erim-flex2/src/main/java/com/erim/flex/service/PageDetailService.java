/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * PageDetailService.java : 2012-2-3 下午1:46:09
 */
package com.erim.flex.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.exception.ErimException;
import com.erim.flex.bean.PageDetailBean;
import com.erim.flex.util.ErimUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-2-3 下午1:46:09
 * @description 页面明细管理
 */
@Service("pagedetail")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PageDetailService extends AbstractService<PageDetailBean> {

    // --------------------------------------------------------------------------
    //
    // Methods Implements
    //
    // --------------------------------------------------------------------------

    @Override
    public String getNameSpace() {
        return "pagedetail";
    }

    // --------------------------------------------------------------------------
    //
    // Methods Extends
    //
    // --------------------------------------------------------------------------

    /**
     * 增加页面后清空静态变量
     */
    @Override
    public void insert() throws ErimException {
        super.insert();
        ErimUtils.clearPage();
    }

    /**
     * 修改页面后清空静态变量
     */
    @Override
    public void update() throws ErimException {
        super.update();
        ErimUtils.clearPage();
    }

    /**
     * 修改页面后清空静态变量
     */
    @Override
    public void delete() throws ErimException {
        super.delete();
        ErimUtils.clearPage();
    }

}