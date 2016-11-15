/**
 * Copyright (c) e-rimming.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * PageLinkUtils.java : 2012-7-19 下午03:48:45
 */
package com.erim.utils.pagelink;

import com.erim.core.bean.BaseBean;
import com.erim.core.bean.PageLinkBean;

/**
 * @author 宋哲
 * @version 创建时间：2012-7-19 下午03:48:45
 * @description
 */
public class PageLinkUtils {

    /**
     * 处理带翻页的bean
     * 
     * @param bean 待处理的bean
     * @param count 查询总条数
     */
    public static void dealBaseBean(BaseBean bean, int count) {

        // 获取当前页
        int p = bean.getP();

        // 获取每页显示行数
        int n = bean.getN();

        // 设置页号最小值为1
        if (p == 0) {
            p = 1;
        }

        // 设置每页显示数值
        if (n == 0) {
            n = 10;
        }

        // 获取已经实例化的PageLinkBean
        PageLinkBean page = bean.getPageLinkBean();

        // 设置查询数据起始行数
        page.setStart(p * n - n);

        // 设置查询数据结束行数
        page.setLimit(n);

        // 设置查询数据的总条数
        page.setCount(count);

        // 设置查询数据总页数
        if (count % n == 0) {
            page.setSize(count / n);
        } else {
            page.setSize(count / n + 1);
        }

        // 设置查询数据当前页数
        page.setPageSize(p);

        // 设置查询数据的每页显示条数
        if (page.getPageSize() == page.getSize()) {
            page.setPageCount(count % n);
        } else {
            page.setPageCount(n);
        }
    }

    /**
     * 处理带翻页的bean，不需要显示页号所以只查询当前页数据
     * 
     * @param bean 待处理的bean 查询总条数为当前页
     */
    public static void dealBaseBean(BaseBean bean) {
        dealBaseBean(bean, bean.getN());
    }
}
