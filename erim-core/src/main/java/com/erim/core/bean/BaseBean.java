/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * BaseBean.java : 2012-02-06
 */
package com.erim.core.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 宋哲
 * @version 创建时间：2012-02-06
 * @description 页面信息
 */
public class BaseBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID = 1L;

    /** 翻页对象 */
    private PageLinkBean      pageLinkBean     = new PageLinkBean(); ;

    /** 当前页号 */
    private int               p                = 0;

    /** 每页显示行数 */
    private int               n                = 0;

    /** 创建时间 */
    private Date              gmtCreat         = null;

    /** 最后修改时间 */
    private Date              gmtModify        = null;

    /**
     * 默认构造函数
     */
    public BaseBean() {
        super();
    }

    /**
     * 取得翻页对象
     * 
     * @return 翻页对象
     */
    public PageLinkBean getPageLinkBean() {
        return pageLinkBean;
    }

    /**
     * 设置翻页对象
     * 
     * @param PageLinkBean 翻页对象
     */
    public void setPageLinkBean(PageLinkBean PageLinkBean) {
        this.pageLinkBean = PageLinkBean;
    }

    /**
     * 取得当前页号
     * 
     * @return 当前页号
     */
    public int getP() {
        return p;
    }

    /**
     * 设置当前页号
     * 
     * @param p 当前页号
     */
    public void setP(int p) {
        this.p = p;
    }

    /**
     * 取得每页显示行数
     * 
     * @return 每页显示行数
     */
    public int getN() {
        return n;
    }

    /**
     * 设置每页显示行数
     * 
     * @param n 每页显示行数
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * 取得创建时间
     * 
     * @return 创建时间
     */
    public Date getGmtCreat() {
        return gmtCreat;
    }

    /**
     * 设置创建时间
     * 
     * @param gmtCreat 创建时间
     */
    public void setGmtCreat(Date gmtCreat) {
        this.gmtCreat = gmtCreat;
    }

    /**
     * 取得最后修改时间
     * 
     * @return 最后修改时间
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * 设置最后修改时间
     * 
     * @param gmtModify 最后修改时间
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

}