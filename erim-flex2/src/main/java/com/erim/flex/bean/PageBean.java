/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * PageBean.java : 2012-02-02
 */
package com.erim.flex.bean;

import java.io.Serializable;

/**
 * @author 宋哲
 * @version 创建时间：2012-02-02
 * @description 页面信息
 */
public class PageBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer           id;

    /** 页面名称 */
    private String            name;

    /** 页面标题 */
    private String            title;

    /** 页面宽度 */
    private String            width;

    /** 页面高度 */
    private String            height;

    /**
     * 默认构造函数
     */
    public PageBean() {
        super();
    }

    /**
     * 取得ID
     * 
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     * 
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 取得页面名称
     * 
     * @return 页面名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置页面名称
     * 
     * @param name 页面名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 取得页面标题
     * 
     * @return 页面标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置页面标题
     * 
     * @param title 页面标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 取得页面宽度
     * 
     * @return 页面宽度
     */
    public String getWidth() {
        return width;
    }

    /**
     * 设置页面宽度
     * 
     * @param width 页面宽度
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * 取得页面高度
     * 
     * @return 页面高度
     */
    public String getHeight() {
        return height;
    }

    /**
     * 设置页面高度
     * 
     * @param height 页面高度
     */
    public void setHeight(String height) {
        this.height = height;
    }

}