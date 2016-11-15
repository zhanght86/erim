/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * PageService.java : 2012-2-2 下午2:52:36
 */
package com.erim.flex.service;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erim.core.exception.BusinessException;
import com.erim.core.exception.ErimException;
import com.erim.flex.bean.PageBean;
import com.erim.flex.bean.PageDetailBean;
import com.erim.flex.util.ErimUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-2-2 下午2:52:36
 * @description 页面管理
 */
@Service("page")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PageService extends AbstractService<PageBean> {

    // --------------------------------------------------------------------------
    //
    // Methods Implements
    //
    // --------------------------------------------------------------------------

    @Override
    public String getNameSpace() {
        return "page";
    }

    // --------------------------------------------------------------------------
    //
    // Methods Extends
    //
    // --------------------------------------------------------------------------

    /**
     * 1.增加页面前检查ID是否存在<br>
     * 2.增加页面后清空缓存静态变量
     */
    @Override
    public void insert() throws ErimException {
        PageBean bean = commonGetEntityById();
        if (bean != null) {
            throw new BusinessException("该ID已经存在！");
        }
        PageBean page = ErimUtils.getPageBeanByPageName(_inHashMap.getString("name"));
        if (page != null) {
            throw new BusinessException("该页面已经存在！");
        }
        super.insert();
        ErimUtils.clearPage();
    }

    /**
     * 1.修改页面前检查ID是否存在<br>
     * TODO-更改为从缓存中查找是否存在<br>
     * 2.修改页面后清空缓存静态变量
     */
    @Override
    @Transactional(rollbackFor = ErimException.class)
    public void update() throws ErimException {

        // 当更改id，判断是否已经存在
        if (commonGetColumn("id").equals(_inHashMap.getString("id"))) {
        } else {
            PageBean bean = commonGetEntityById();
            if (bean != null) {
                throw new BusinessException("该ID已经存在！");
            }
        }

        // 当更改pagename，判断是否已经存在
        if (commonGetColumn("name").equals(_inHashMap.getString("name"))) {
        } else {
            PageBean page = ErimUtils.getPageBeanByPageName(_inHashMap.getString("name"));
            if (page != null) {
                throw new BusinessException("该页面已经存在！");
            }
        }

        _inHashMap.put("oldid", commonGetColumn("id"));
        super.update();

        // 若id发生更改则同步修改TM_SYSTEM_PAGE_DETAIL中的数据
        if (commonGetColumn("id").equals(_inHashMap.getString("id"))) {
        } else {
            getSqlSession().update("pagedetail.updatepageid", _inHashMap);
        }

        // 清空页面相关缓存
        ErimUtils.clearPage();
    }

    /**
     * 本次删除只可删除一次
     * 删除页面后清空缓存静态变量
     */
    @Override
    public void delete() throws ErimException {

        String id = commonGetColumn("id");

        // 塞入数据
        _inHashMap.put("pageid", id);

        // 判断该页面下面是否有明细
        List<PageDetailBean> list = getSqlSession().selectList("pagedetail.selectListByPageId", _inHashMap);

        // 判断明细
        if (list.size() != 0) {
            throw new BusinessException("该页面有明细，请先将明细删除再删除页面！");
        }

        // 删除数据
        super.delete();

        // 清空页面相关缓存
        ErimUtils.clearPage();
    }

}