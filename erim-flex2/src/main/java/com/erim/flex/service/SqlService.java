/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * SqlSessionService.java : 2014-08-11 上午3:47:57
 */
package com.erim.flex.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.lang.ExtHashMap;
import com.erim.core.service.BaseService;

/**
 * @author 宋哲
 * @version 创建时间：2012-3-19 上午3:47:57
 * @description 清空spring bean 为data和cdata的数据源
 */
@Service("sql")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SqlService extends BaseService {

    /**
     * 根据传入的数据源定义查询SQL并返回
     * 
     * @param hashMap
     * @return
     */
    public ExtHashMap<String, String> executeSql(ExtHashMap<String, String> hashMap) {
        List<HashMap<String, String>> list = getSqlSession().selectList("sqlsession.selectData", hashMap);
        hashMap.remove("sql");
        for (HashMap<String, String> hm : list) {
            hashMap.put(String.valueOf(hm.get("skey")), String.valueOf(hm.get("skey")) + ":" + String.valueOf(hm.get("svalue")));
        }
        return hashMap;
    }

}