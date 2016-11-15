/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * BusiRegionService.java : 2013-06-28 下午13:04
 */
package com.erim.sz.service;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erim.core.exception.BusinessException;
import com.erim.core.exception.ErimException;
import com.erim.flex.bean.RegionBean;
import com.erim.flex.constant.BackConstants;
import com.erim.flex.service.AbstractService;
import com.erim.sz.util.ErimCUtils;

import flex.messaging.io.amf.ASObject;

/**
 * @author 宋哲
 * @version 创建时间：2015-08-28 下午13:04
 * @description 持久层，地区管理表(TM_BUSI_SORT)
 */
@Service("region")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RegionService extends AbstractService<RegionBean> {

    // --------------------------------------------------------------------------
    //
    // Properties Autowired
    //
    // --------------------------------------------------------------------------

    @Override
    public String getNameSpace() {
        return "region";
    }

    @Override
    public void before() {
        // 处理查询
        if ("query".equals(taskname)) {
            // 处理页面下拉树的值，用于查询动作
            if (_inHashMap.get("regionPid") instanceof ASObject) {
                ASObject object = (ASObject) _inHashMap.get("regionPid");
                if (object == null || object.get("item") == null) {
                    return;
                } else {
                    List<String> list = null;
                    try {
                        list = ErimCUtils.getChildListByRegionId(object.get("item").toString());
                    } catch (ErimException e) {
                        e.printStackTrace();
                    }
                    list.add(object.get("item").toString());
                    _inHashMap.put("regionPids", list.toArray());
                }
            }
        }
        // 处理增加，修改
        else if ("insert".equals(taskname) || "update".equals(taskname)) {
            // 处理页面下拉树的值，用于增加、修改动作
            if (_inHashMap.get("regionPid") instanceof ASObject) {
                ASObject object = (ASObject) _inHashMap.get("regionPid");
                if (object == null || object.get("item") == null) {
                    return;
                } else {
                    _inHashMap.put("regionPid", object.get("item").toString());
                }
            }
        }
        super.before();
    }

    @Override
    public void list() throws ErimException {
        super.list();
        _backFlag = BackConstants.BACK_DATAGRID_SHOW_ALL;
    }

    @Override
    public void insert() throws ErimException {

        // 验证"地区名称"是否存在
        int nameCount = getSqlSession().selectOne(namespace + ".verifyRegionName", _inHashMap);
        if (nameCount != 0) {
            throw new BusinessException("该地区名称本级已经存在！");
        }

        // 验证"地区ID"是否存在
        int idCount = getSqlSession().selectOne(namespace + ".verifyRegionId", _inHashMap);
        if (idCount != 0) {
            throw new BusinessException("该地区ID已经存在！");
        }

        // 验证"地区序号"是否存在
        int noCount = getSqlSession().selectOne(namespace + ".verifyRegionNo", _inHashMap);
        if (noCount != 0) {
            throw new BusinessException("该地区序号已经存在！");
        }

        // 插入数据
        super.insert();
        ErimCUtils.clearBusiRegion();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update() throws ErimException {

        // 验证"不能将地区修改为自己的子地区"
        if (commonGetColumn("regionId").equals(_inHashMap.getString("regionPid"))) {
            throw new BusinessException("不能将地区修改为自己的子地区！");
        }

        // 验证地区名称
        if (commonColumnIsChange("regionName")) {
            int nameCount = getSqlSession().selectOne(namespace + ".verifyRegionName", _inHashMap);
            if (nameCount != 0) {
                throw new BusinessException("该地区名称本级已经存在！");
            }
        }

        // 验证地区ID
        if (commonColumnIsChange("regionId")) {
            int noCount = getSqlSession().selectOne(namespace + ".verifyRegionId", _inHashMap);
            if (noCount != 0) {
                throw new BusinessException("该地区ID已经存在！");
            }
        }

        // 验证地区序号
        if (commonColumnIsChange("regionNo")) {
            int idCount = getSqlSession().selectOne(namespace + ".verifyRegionNo", _inHashMap);
            if (idCount != 0) {
                throw new BusinessException("该地区序号已经存在！");
            }
        }

        // 修改数据
        super.update();

        // 修改子项父ID
        if (commonColumnIsChange("regionId")) {
            getSqlSession().update(namespace + ".updateRegionPid", _inHashMap);
        }

        ErimCUtils.clearBusiRegion();
    }

    @Override
    public void delete() throws ErimException {

        // 查询"子地区数量"用于删除验证
        int countByPid = getSqlSession().selectOne(namespace + ".selectCountByPid", commonGetColumn("regionId"));
        if (countByPid != 0) {
            throw new BusinessException("该地区包含子地区，请删除子地区后再删除该地区！");
        }

        super.delete();
        ErimCUtils.clearBusiRegion();
    }
}