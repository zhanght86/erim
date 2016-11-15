/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * DataService.java : 2012-8-22 上午2:26:09
 */
package com.erim.sz.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.bean.Bean;
import com.erim.core.exception.ErimException;
import com.erim.core.lang.ExtHashMap;
import com.erim.flex.bean.RegionBean;
import com.erim.flex.service.AbstractService;
import com.erim.utils.dom4j.DOMUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-8-13 上午2:26:09
 * @description
 */
@Service("cdata")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CDataService extends AbstractService<Bean> {

    @Override
    public String getNameSpace() {
        return "cdata";
    }

    // --------------------------------------------------------------------------
    //
    // Variables
    //
    // --------------------------------------------------------------------------

    /** 类别信息集合 */
    private List<RegionBean>                 region;

    /** 类别XML Element数据 */
    private Element                          regionRoot;

    /** 类别信息键值对，key为固定值"xml"，value为xml字符串 */
    private ExtHashMap<String, String>       regionXml;

    /** 类别信息键值对，key为regionId，value为对应region所有父节点regionName拼接 */
    private ExtHashMap<String, String>       regionCXml;

    /** 类别信息键值对，key为regionId，value为对应region所有子节点regionId的集合 */
    private ExtHashMap<String, List<String>> regionChildList;

    /** 类别信息键值对，key为regionId，value为对应region所有父节点regionId的集合 */
    private ExtHashMap<String, List<String>> regionParentList;

    // --------------------------------------------------------------------------
    //
    // Constructor
    //
    // --------------------------------------------------------------------------

    @PostConstruct
    public void initDataService() throws ErimException {
        region = region();
        regionRoot = getRegionElement();
        regionXml = regionXml();
        regionCXml = regionCXml();
        regionChildList = regionChildList();
        regionParentList = regionParentList();
    }

    // --------------------------------------------------------------------------
    //
    // Properties Autowired
    //
    // --------------------------------------------------------------------------

    /**
     * 类型 读取数据库表 获得 Element root 对象
     * 
     * @return root
     */
    private Element getRegionElement() throws ErimException {
        if (regionRoot == null) {
            try {
                // 使用 DocumentHelper 类创建一个文档实例。
                Document document = DocumentHelper.createDocument();
                // 使用 addElement() 方法创建根元素 root
                regionRoot = document.addElement("root");

                HashMap<String, Element> elementMap = new HashMap<String, Element>();
                List<RegionBean> list = region();
                for (RegionBean bean : list) {
                    if (bean.getRegionPid() == null || "0".equals(bean.getRegionPid())) {
                        Element e = (Element) DocumentHelper.createElement("item");
                        e.addAttribute("key", bean.getRegionId().toString());
                        e.addAttribute("value", bean.getRegionName());
                        e.addAttribute("state", "0");
                        elementMap.put(bean.getRegionId().toString(), e);
                        regionRoot.add(e);
                    } else {
                        Element e = (Element) DocumentHelper.createElement("item");
                        e.addAttribute("key", bean.getRegionId().toString());
                        e.addAttribute("value", bean.getRegionName());
                        e.addAttribute("state", "0");
                        elementMap.put(bean.getRegionId().toString(), e);
                        if (elementMap.get(bean.getRegionPid().toString()) == null) {
                            throw new ErimException("构造XMl错误，地区ID：" + bean.getRegionPid().toString() + "不存在！");
                        }
                        elementMap.get(bean.getRegionPid().toString()).add(e);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return regionRoot;
    }

    /**
     * 获取类型集合
     * 
     * @return
     */
    public List<RegionBean> region() {
        if (region == null) {
            region = getSqlSession().selectList("region" + ".selectAll", null);
        }
        return region;
    }

    /**
     * 类型 仅含一个key的HashMap，key为xml，value为root.asXML() 用于组件数据源，可用组件包括：单选树形列表
     * 
     * @return
     * @throws ErimException
     */
    public ExtHashMap<String, String> regionXml() throws ErimException {
        if (regionXml == null) {
            regionXml = new ExtHashMap<String, String>();
            regionXml.put("xml", getRegionElement().asXML());
        }
        return regionXml;
    }

    /**
     * 类型 根据element生成ExtHashMap数据源
     * 
     * @return map
     */
    public ExtHashMap<String, String> regionCXml() throws ErimException {
        if (regionCXml == null) {
            regionCXml = new ExtHashMap<String, String>();
            List<Element> list = new ArrayList<Element>();
            DOMUtils.getElementChildList(getRegionElement(), list);
            for (Element e : list) {
                if (e.isRootElement()) {
                    continue;
                }
                String key = e.attribute("key").getValue();
                String value = "";
                for (; !e.isRootElement();) {
                    value = e.attribute("value").getValue() + " " + value;
                    e = e.getParent();
                }
                key = key.trim();
                value = value.trim();
                regionCXml.put(key, key + ":" + value);
            }
        }
        return regionCXml;
    }

    /**
     * 获取regionId对应子regionId的集合，不包括regionId
     * 
     * @return regionId对应子regionId的集合
     */
    public ExtHashMap<String, List<String>> regionChildList() throws ErimException {
        if (regionChildList == null) {
            regionChildList = new ExtHashMap<String, List<String>>();
            // 获取所有节点
            List<Element> list = new ArrayList<Element>();
            DOMUtils.getElementChildList(getRegionElement(), list);
            // 循环所有节点
            for (Element e : list) {
                if (e.isRootElement()) {
                    continue;
                }
                List<Element> nlist = new ArrayList<Element>();
                DOMUtils.getElementChildList(e, nlist);
                // 循环获取对应节点下所有子节点ID集合
                List<String> slist = new ArrayList<String>();
                for (Element e2 : nlist) {
                    if (e.attribute("key").getValue().equals(e2.attribute("key").getValue())) {
                        continue;
                    }
                    slist.add(e2.attribute("key").getValue());
                }
                regionChildList.put(e.attribute("key").getValue(), slist);
            }
        }
        return regionChildList;
    }

    /**
     * 获取regionId对应父regionId的集合，不包括regionId
     * 
     * @return regionId对应父regionId的集合
     */
    public ExtHashMap<String, List<String>> regionParentList() throws ErimException {
        if (regionParentList == null) {
            regionParentList = new ExtHashMap<String, List<String>>();
            List<Element> list = new ArrayList<Element>();
            DOMUtils.getElementChildList(getRegionElement(), list);
            for (Element e : list) {
                if (e.isRootElement()) {
                    continue;
                }
                String key = e.attribute("key").getValue();
                List<String> value = new ArrayList<String>();
                for (; !e.isRootElement();) {
                    value.add(e.attribute("key").getValue());
                    e = e.getParent();
                }
                regionParentList.put(key, value);
            }
        }
        return regionParentList;
    }

    /**
     * 根据regionId获取父ID集合
     * 
     * @param regionId
     * @return
     */
    public List<String> getChildListByRegionId(String regionId) throws ErimException {
        return regionChildList().get(regionId);
    }

    /**
     * 根据regionId获取父ID集合
     * 
     * @param regionId
     * @return
     */
    public List<String> getParentListByRegionId(String regionId) throws ErimException {
        return regionParentList().get(regionId);
    }

    @Override
    public void clearAll() {

        // 清除地区
        clearRegion();

        super.clearAll();
    }

    /**
     * 清空单例数据，便于重新加载数据
     */
    public void clearRegion() {

        // 清除本service下region相关的单例
        region = null;
        regionRoot = null;
        regionXml = null;
        regionCXml = null;
        regionChildList = null;
        regionParentList = null;
    }

}