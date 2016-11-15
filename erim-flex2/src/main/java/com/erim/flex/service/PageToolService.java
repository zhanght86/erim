/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ToolService.java : 2012-2-21 上午10:45:46
 */
package com.erim.flex.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erim.core.exception.ErimException;
import com.erim.core.exception.SystemException;
import com.erim.flex.bean.PageBean;
import com.erim.flex.bean.PageDetailBean;
import com.erim.flex.constant.BackConstants;
import com.erim.flex.util.ErimUtils;
import com.erim.flex.util.ParseUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-2-21 上午10:45:46
 * @description 可视化图形工具
 */
@Service("tool")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PageToolService extends AbstractService<PageBean> {

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
    // Methods
    //
    // --------------------------------------------------------------------------

    /**
     * 读取页面
     * 
     * @throws ErimException
     */
    public void read() throws ErimException {

        // 获取页面名称
        String pagename = _inHashMap.getString("pagename");

        // 获取所要跳转页面的信息
        PageBean pageinfo = ErimUtils.getPageBeanByPageName(pagename);

        // 检测页面是否存在
        if (pageinfo == null) {
            throw new SystemException("查询页面不存在，请检查参数pagename是否输入正确！");
        }

        // 获取所要跳转页面的详细信息，由于tools下的页面不对上传、下载、富文本编辑器做处理，所以需要重新查询，但save的时候还是需要清空
        List<PageDetailBean> pagedetail = ErimUtils.getPageDetailListToolsByPageName(pagename);

        // 非空转换，否则前后端显示没有详细内容的页面报错
        if (pagedetail == null) {
            pagedetail = new ArrayList<PageDetailBean>();
        }

        // 处理组件，解析数据源并添加
        for (PageDetailBean bean : pagedetail) {
            if (bean.getData() == null) {
            } else {
                bean.setDataProvider(ParseUtils.parseData(bean, null));
            }
        }

        // 设置参数
        _outHashMap.put("pageinfo", pageinfo);
        _outHashMap.put("pagedetail", pagedetail);
        _backFlag = BackConstants.BACK_TOOLS_READ;
    }

    /**
     * 存储页面
     * @throws ErimException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Transactional
    public void save() throws ErimException {

        // 获取所要跳转页面的信息
        PageBean pageinfo = ErimUtils.getPageBeanByPageName(_inHashMap.getString("pagename"));

        // 检测页面是否存在
        if (pageinfo == null) {
            throw new SystemException("查询页面不存在，请检查参数pagename是否输入正确！");
        }

        // 修改页面信息
        _inHashMap.put("id", pageinfo.getId());
        _inHashMap.put("oldid", pageinfo.getId());
        getSqlSession().update("page.update", _inHashMap);

        // 删除页面组件
        getSqlSession().delete("pagedetail.deleteByPageId", pageinfo.getId());

        // 为每一条记录加入pageid的参数
        for (HashMap item : (ArrayList<HashMap>) _inHashMap.get("dataitems")) {
            item.put("pageid", pageinfo.getId().toString());
        }
        if (((ArrayList<HashMap>) _inHashMap.get("dataitems")).size() > 0) {
            getSqlSession().insert("pagedetail.insertbatch", _inHashMap);
        }
        _backFlag = BackConstants.BACK_TOOLS_SAVE;
        ErimUtils.clearAll();
    }

}
