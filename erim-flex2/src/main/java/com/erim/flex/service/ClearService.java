/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ClearService.java : 2012-3-19 上午3:47:57
 */
package com.erim.flex.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.bean.Bean;
import com.erim.core.exception.ErimException;
import com.erim.flex.constant.BackConstants;
import com.erim.flex.util.ErimUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-3-19 上午3:47:57
 * @description 清空spring bean 为data和cdata的数据源
 */
@Service("clear")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ClearService extends AbstractService<Bean> {

    //--------------------------------------------------------------------------
    //
    //  Methods Implements
    //
    //--------------------------------------------------------------------------

    @Override
    public String getNameSpace() {
        return "";
    }

    //--------------------------------------------------------------------------
    //
    //  Methods Extends
    //
    //--------------------------------------------------------------------------

    @Override
    public void list() throws ErimException {
        ErimUtils.clearAll();
        _backFlag = BackConstants.BACK_RIGHT_SHOW;
        _outHashMap.put("message", "清除成功！");
    }

}
