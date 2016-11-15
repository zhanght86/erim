/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * DataService.java : 2012-8-22 上午2:26:09
 */
package com.erim.flex.service;

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
import com.erim.core.lang.ExtHashMap;
import com.erim.flex.bean.CodeBean;
import com.erim.flex.bean.FuncBean;
import com.erim.flex.bean.PageBean;
import com.erim.flex.bean.PageDetailBean;

/**
 * @author 宋哲
 * @version 创建时间：2012-8-13 上午2:26:09
 * @description Singletion模式的数据源
 */
@Service("data")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class DataService extends AbstractService<Bean> {

    // --------------------------------------------------------------------------
    //
    // Variables
    //
    // --------------------------------------------------------------------------

    /** 功能信息集合，用于便捷获取 */
    private List<FuncBean>                                 listFunc;

    /** 功能信息键值对{权限:ID，用于便捷获取} */
    private ExtHashMap<String, Integer>                    mapFunc;

    /** 页面信息集合，用于便捷获取 */
    private List<PageBean>                                 listPage;

    /** 页面信息键值对{页面名称:页面信息，用于便捷获取} */
    private ExtHashMap<String, PageBean>                   mapPageName;

    /** 页面信息键值对{页面ID:页面信息，用于便捷获取} */
    private ExtHashMap<String, PageBean>                   mapPageId;

    /** 页面明细信息键值对{页面名称:页面明细列表信息，用于便捷获取} */
    private ExtHashMap<String, List<PageDetailBean>>       mapPageDetail;

    /** 页面明细信息键值对，未经过非数据源的处理如文件和富文本编辑器的处理{页面名称:页面明细列表信息，用于便捷获取} */
    private ExtHashMap<String, List<PageDetailBean>>       mapPageDetailTools;

    /** 功能信息xml字符串，用于数据源 */
    private ExtHashMap<String, String>                     dataFunc;

    /** 代码信息键值对{代码序号:代码对应的数据源，用于便捷获取与数据源} */
    private ExtHashMap<String, ExtHashMap<String, String>> dataCode;

    /** 页面信息键值对{页面ID:页面标题，用于数据源} */
    private ExtHashMap<String, String>                     dataPage;

    // --------------------------------------------------------------------------
    //
    // Constructor
    //
    // --------------------------------------------------------------------------

    @PostConstruct
    public void initDataService() {
        
        // 功能
        listFunc = getFuncList();
        dataFunc = func();
        mapFunc = getMapFunc();

        // 页面
        listPage = getPageList();
        mapPageName = getMapPageName();
        mapPageId = getMapPageId();
        mapPageDetail = getMapPageDetail();
        mapPageDetailTools = getMapPageDetailTools();
        dataPage = page();

        // 代码
        dataCode = getSystemCode();
    }

    // --------------------------------------------------------------------------
    //
    // Methods implements
    //
    // --------------------------------------------------------------------------

    @Override
    public String getNameSpace() {
        return "";
    }

    // --------------------------------------------------------------------------
    //
    // Methods
    //
    // --------------------------------------------------------------------------

    /**
     * 便捷获取，获取功能信息列表集合
     * 
     * @return
     */
    public List<FuncBean> getFuncList() {
        if (listFunc == null) {
            listFunc = getSqlSession().selectList("func.selectAll");
        }
        return listFunc;
    }

    /**
     * 便捷获取，获取页面信息列表集合
     * 
     * @return 
     */
    public List<PageBean> getPageList() {
        if (listPage == null) {
            listPage = getSqlSession().selectList("page.selectAll");
        }
        return listPage;
    }

    /**
     * 便捷获取，获取功能权限集合，键为func_auth，获取内容格式：{func_auth,func_id}
     * 
     * @return
     */
    public ExtHashMap<String, Integer> getMapFunc() {
        if (mapFunc == null) {
            mapFunc = new ExtHashMap<String, Integer>();
            List<FuncBean> list = getFuncList();
            for (FuncBean bean : list) {
                mapFunc.put(bean.getAuth(), bean.getId());
            }
        }
        return mapFunc;
    }

    /**
     * 便捷获取，获取页面对象集合，键为pagename，获取内容格式：{pagename,PageBean}
     * 
     * @return
     */
    public ExtHashMap<String, PageBean> getMapPageName() {
        if (mapPageName == null) {
            mapPageName = new ExtHashMap<String, PageBean>();
            List<PageBean> list = getPageList();
            for (PageBean bean : list) {
                mapPageName.put(bean.getName(), bean);
            }
        }
        return mapPageName;
    }

    /**
     * 便捷获取，获取页面对象集合，键为pageid，获取内容格式：{pageid,PageBean}
     * 
     * @return
     */
    public ExtHashMap<String, PageBean> getMapPageId() {
        if (mapPageId == null) {
            mapPageId = new ExtHashMap<String, PageBean>();
            List<PageBean> list = getPageList();
            for (PageBean bean : list) {
                mapPageId.put(bean.getId().toString(), bean);
            }
        }
        return mapPageId;
    }

    /**
     * 便捷获取，获取页面明细列表集合，键为pagename，获取内容格式：{pagename,List<PageDetailBean>}
     * 
     * @return
     */
    public ExtHashMap<String, List<PageDetailBean>> getMapPageDetail() {
        if (mapPageDetail == null) {
            mapPageDetail = new ExtHashMap<String, List<PageDetailBean>>();
            List<PageDetailBean> list = getSqlSession().selectList("pagedetail.selectAll");
            for (PageDetailBean bean : list) {

                // 根据pageid获取pagename
                String pagename = getMapPageId().get(bean.getPageid().toString()).getName();

                // 不存在则重新put进key为pagename的页面明细集合
                if (mapPageDetail.get(pagename) == null) {
                    mapPageDetail.put(pagename, new ArrayList<PageDetailBean>());
                }

                // 填充新的键值对到对应集合中
                mapPageDetail.get(pagename).add(bean);
            }
        }
        return mapPageDetail;
    }

    /**
     * 便捷获取，获取页面明细信息键值对，未经过非数据源的处理如文件和富文本编辑器的处理，键为pagename，获取内容格式：{pagename,List<PageDetailBean>}
     * 
     * @return
     */
    public ExtHashMap<String, List<PageDetailBean>> getMapPageDetailTools() {
        if (mapPageDetailTools == null) {
            mapPageDetailTools = new ExtHashMap<String, List<PageDetailBean>>();
            List<PageDetailBean> list = getSqlSession().selectList("pagedetail.selectAll");
            for (PageDetailBean bean : list) {
                // 根据pageid获取pagename
                String pagename = getMapPageId().get(bean.getPageid().toString()).getName();
                // 不存在则重新put进key为pagename的页面明细集合
                if (mapPageDetailTools.get(pagename) == null) {
                    mapPageDetailTools.put(pagename, new ArrayList<PageDetailBean>());
                }
                // 填充新的键值对到对应集合中
                mapPageDetailTools.get(pagename).add(bean);
            }
        }
        return mapPageDetailTools;
    }

    /**
     * 便捷获取，获取代码信息键值对，键为代码序号，获取内容格式：{codeid,ExtHashMap<key,value>}
     * 
     * @return
     */
    public ExtHashMap<String, ExtHashMap<String, String>> getSystemCode() {
        if (dataCode == null) {
            dataCode = new ExtHashMap<String, ExtHashMap<String, String>>();
            List<CodeBean> list = getSqlSession().selectList("code.selectAll");
            for (int i = 0; i < list.size(); i++) {

                // 不存在则重新put进key为no的数据源
                if (dataCode.get(list.get(i).getCodeId()) == null) {
                    dataCode.put(list.get(i).getCodeId(), new ExtHashMap<String, String>());
                }

                // 填充新的键值对到对应数据源中
                dataCode.get(list.get(i).getCodeId()).put(String.valueOf(i), list.get(i).getCodeKey() + ":" + list.get(i).getCodeValue());
            }
        }
        return dataCode;
    }

    /**
     * 数据源，数据源格式：[M]{data;func}，获取内容格式xml格式字符串
     * @return
     */
    public ExtHashMap<String, String> func() {
        if (dataFunc == null) {
            dataFunc = new ExtHashMap<String, String>();

            // 加载有权限的功能菜单，获取为一个Element
            List<FuncBean> funcinfo = getFuncList();

            // 使用 DocumentHelper 类创建一个文档实例。
            Document document = DocumentHelper.createDocument();

            // 使用 addElement() 方法创建根元素 root
            Element menu = document.addElement("root");
            HashMap<String, Element> hm = new HashMap<String, Element>();
            for (FuncBean bean : funcinfo) {
                Element menuitem = (Element) DocumentHelper.createElement("item");
                menuitem.addAttribute("key", bean.getId().toString());
                menuitem.addAttribute("value", bean.getName());
                menuitem.addAttribute("state", "0");
                hm.put(bean.getId().toString(), menuitem);
                if (bean.getId() == bean.getPid()) {
                    menu.add(menuitem);
                } else {
                    hm.get(bean.getPid().toString()).add(menuitem);
                }
            }
            dataFunc.put("xml", menu.asXML());
        }
        return dataFunc;
    }

    /**
     * 数据源，数据源格式：[M]{data;page}，获取内容格式：{pageid,pageid:pagename}
     * 
     * @return 页面数据源键值对
     */
    public ExtHashMap<String, String> page() {
        if (dataPage == null) {
            dataPage = new ExtHashMap<String, String>();
            List<PageBean> list = getSqlSession().selectList("page.selectAll");
            for (PageBean bean : list) {
                dataPage.put(bean.getId().toString(), bean.getId().toString() + ":" + bean.getName());
            }
        }
        return dataPage;
    }

    /**
     * 清空单例所有数据，便于重新加载数据
     */
    public void clearAll() {
        clearFunc();
        clearPage();
        clearCode();
    }

    /**
     * 情况单例功能相关数据
     */
    public void clearFunc() {
        listFunc = null;
        dataFunc = null;
        mapFunc = null;
    }

    /**
     * 清空单例页面相关数据
     */
    public void clearPage() {
        listPage = null;
        mapPageName = null;
        mapPageId = null;
        mapPageDetail = null;
        mapPageDetailTools = null;
        dataPage = null;
    }

    /**
     * 清空单例代码相关数据
     */
    public void clearCode() {
        dataCode = null;
    }

}