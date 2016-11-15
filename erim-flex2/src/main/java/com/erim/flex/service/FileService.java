/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * FileService.java : 2012-12-4
 */
package com.erim.flex.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erim.core.exception.ErimException;
import com.erim.flex.bean.FileBean;
import com.erim.flex.constant.BackConstants;
import com.erim.utils.file.FileUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-12-4
 * @description 文件管理
 */
@Service("file")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FileService extends AbstractService<FileBean> {

    // --------------------------------------------------------------------------
    //
    // Methods Implements
    //
    // --------------------------------------------------------------------------

    @Override
    public String getNameSpace() {
        return "file";
    }

    // --------------------------------------------------------------------------
    //
    // Methods Extends
    //
    // --------------------------------------------------------------------------

    @Override
    @Transactional(rollbackFor = ErimException.class)
    public void insert() throws ErimException {
        commonInsertFile("file");
        _backFlag = BackConstants.BACK_DATAGRID_REFRESH;
    }

    public void update() throws ErimException {
        _inHashMap.put("suffix", FileUtils.getSuffixByFileName(_inHashMap.getString("name")));
        super.update();
    }

    @Transactional(rollbackFor = ErimException.class)
    public void fupdate() throws ErimException {
        commonUpdateFile(commonGetColumn("id"), "file");
        _backFlag = BackConstants.BACK_DATAGRID_REFRESH;
    }

}
