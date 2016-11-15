/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * PageLinkBean.java : 2012-02-06
 */
package com.erim.core.bean;

import java.io.Serializable;

/**
 * @author 宋哲
 * @version 创建时间：2012-02-06
 * @description 分页信息
 */
public class PageLinkBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID = 1L;

    /** 起始行号 */
    private int               start            = 0;

    /** 显示行数 */
    private int               limit            = 0;

    /** 全部数据数量 */
    private int               count            = 0;

    /** 当前数据数量 */
    private int               pageCount        = 0;

    /** 总页数 */
    private int               size             = 0;

    /** 当前页数 */
    private int               pageSize         = 0;

    /**
     * 默认构造函数
     */
    public PageLinkBean() {
        super();
    }

    /**
     * 取得起始行号
     * 
     * @return 起始行号
     */
    public int getStart() {
        return start;
    }

    /**
     * 设置起始行号
     * 
     * @param start 起始行号
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 取得显示行数
     * 
     * @return 显示行数
     */
    public int getLimit() {
        return limit;
    }

    /**
     * 设置显示行数
     * 
     * @param limit 显示行数
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * 取得全部数据数量
     * 
     * @return 全部数据数量
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置全部数据数量
     * 
     * @param count 全部数据数量
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 取得当前数据数量
     * 
     * @return 当前数据数量
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * 设置当前数据数量
     * 
     * @param pageCount 当前数据数量
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * 取得总页数
     * 
     * @return 总页数
     */
    public int getSize() {
        return size;
    }

    /**
     * 设置总页数
     * 
     * @param size 总页数
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 取得当前页数
     * 
     * @return 当前页数
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置当前页数
     * 
     * @param pageSize 当前页数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}