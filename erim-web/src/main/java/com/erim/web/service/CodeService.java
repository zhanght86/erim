/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * SortService.java : 2013-06-30
 */
package com.erim.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.lang.ExtHashMap;
import com.erim.web.bean.CodeBean;
import com.erim.web.dao.CodeDao;

/**
 * @author 宋哲
 * @version 创建时间：2014-3-27 下午16:42:43
 * @description 系统代码相关服务
 */
@Service("codeService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CodeService {

    @Autowired
    private CodeDao                                        codeDao;

    /** 代码信息列表 */
    private List<CodeBean>                                 codeList;

    /** 代码信息键值对{代码序号:代码对应的数据源，用于flexweb项目便捷获取与数据源} */
    private ExtHashMap<String, ExtHashMap<String, String>> codeHashMap;

    /** 代码信息键值对{代码序号:代码对应的数据源，用于普通web项目获取数据源} */
    private ExtHashMap<String, List<CodeBean>>             codeHashMapList;

    @PostConstruct
    public void initCodeService() {
        // 代码
        codeList = getCodeList();
        codeHashMap = getSystemCode();
        codeHashMapList = getSystemCodeList();
    }

    /**
     * 获取代码列表集合
     * 
     * @return
     */
    public List<CodeBean> getCodeList() {
        if (codeList == null) {
            codeList = codeDao.selectAllCode();
        }
        return codeList;
    }

    /**
     * 便捷获取，获取代码信息键值对，键为代码序号，获取内容格式：{codeid,ExtHashMap<key,value>}
     * 
     * @return
     */
    public ExtHashMap<String, ExtHashMap<String, String>> getSystemCode() {
        if (codeHashMap == null) {
            codeHashMap = new ExtHashMap<String, ExtHashMap<String, String>>();

            // 查询全部code数据
            List<CodeBean> list = getCodeList();
            for (int i = 0; i < list.size(); i++) {

                // 不存在则重新put进key为no的数据源
                if (codeHashMap.get(list.get(i).getCodeId()) == null) {
                    codeHashMap.put(list.get(i).getCodeId(), new ExtHashMap<String, String>());
                }

                // 填充新的键值对到对应数据源中
                codeHashMap.get(list.get(i).getCodeId()).put(list.get(i).getCodeKey(), list.get(i).getCodeValue());
            }
        }
        return codeHashMap;
    }

    /**
     * 便捷获取，获取代码信息键值对，键为代码序号，获取内容格式：{codeid,List<CodeBean>}
     * 
     * @return
     */
    public ExtHashMap<String, List<CodeBean>> getSystemCodeList() {
        if (codeHashMapList == null) {
            codeHashMapList = new ExtHashMap<String, List<CodeBean>>();

            // 查询全部code数据
            List<CodeBean> list = getCodeList();
            for (int i = 0; i < list.size(); i++) {

                // 不存在则重新put进key为no的数据源
                if (codeHashMapList.get(list.get(i).getCodeId()) == null) {
                    codeHashMapList.put(list.get(i).getCodeId(), new ArrayList<CodeBean>());
                }

                // 填充新的键值对到对应数据源中
                codeHashMapList.get(list.get(i).getCodeId()).add(list.get(i));
            }
        }
        return codeHashMapList;
    }

    /**
     * 根据代码序号获取该代码的键值对信息
     * 
     * @param codeNo 代码序号
     * 
     * @return 代码键值对
     */
    public ExtHashMap<String, String> getSystemCodeByCodeNo(String codeNo) {
        return getSystemCode().get(codeNo);
    }

    /**
     * 根据代码序号获取该代码的CodeBean集合信息
     * 
     * @param codeNo 代码序号
     * 
     * @return CodeBean集合
     */
    public List<CodeBean> getSystemCodeListByCodeNo(String codeNo) {
        return getSystemCodeList().get(codeNo);
    }

    /**
     * 根据代码序号及代码键返回代码值
     * 
     * @param codeNo 代码序号
     * @param key 代码键
     * 
     * @return value 代码值
     */
    public String getValueByCodeNoAndKey(String codeNo, String key) {

        // 若key为null则直接返回null
        if (key == null) {
            return null;
        }

        // 若codeNo不存在，则返回key
        if (codeHashMap.get(codeNo) == null) {
            return key;
        } else {
            // 若codeNo下key对应的valye不存在，则返回key
            if (codeHashMap.get(codeNo).get(key) == null) {
                return key;
            } else {
                return codeHashMap.get(codeNo).get(key);
            }
        }

    }

    /**
     * 根据代码序号及代码键返回代码值 - 当代码健为多个 以','分割时
     * 
     * @param codeNo 代码序号
     * @param keys 多个代码键
     * 
     * @return value 代码值
     */
    public String getValueByCodeKeys(String codeNo, String key) {

        // 若key为null则直接返回null
        if (key == null || "".equals(key)) {
            return "";
        }
        // 若codeNo不存在，则返回key
        if (codeHashMap.get(codeNo) == null) {
            return key;
        } else {
            String[] str = key.split(",");
            String value = "";
            for (int i = 0; i < str.length; i++) {
                String strKey = str[i];
                String strCode = codeHashMap.get(codeNo).get(strKey);
                if (i > 0) {
                    value += "," + strCode;
                } else {
                    value = strCode;
                }
            }
            return value;
        }
    }
}