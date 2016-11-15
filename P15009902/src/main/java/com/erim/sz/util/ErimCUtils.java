/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ErimUtils.java : 2012-3-19 上午1:55:29
 */
package com.erim.sz.util;

import java.util.List;

import com.erim.core.exception.ErimException;
import com.erim.sz.service.CDataService;
import com.erim.utils.spring.ContextUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-3-19 上午1:55:29
 * @description
 */
public class ErimCUtils {

    /**
     * 清空地区单例数据相关数据
     */
    public static void clearBusiRegion() {
        ContextUtils.getContext().getBean("cdata", CDataService.class).clearRegion();
    }

    /**
     * 根据regionId获取父ID集合，不包括regionId
     * @param regionId
     */
    public static List<String> getParentListByRegionId(String regionId) throws ErimException {
        return ContextUtils.getContext().getBean("cdata", CDataService.class).getParentListByRegionId(regionId);
    }

    /**
     * 根据regionId获取子ID集合，不包括regionId
     * @param regionId
     */
    public static List<String> getChildListByRegionId(String regionId) throws ErimException {
        return ContextUtils.getContext().getBean("cdata", CDataService.class).getChildListByRegionId(regionId);
    }

}