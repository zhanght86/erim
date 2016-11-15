/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * FileBean.java : 2012-12-04
 */
package com.erim.flex.bean;

import java.io.Serializable;

/**
 * @author 宋哲
 * @version 创建时间：2012-12-04
 * @description 文件信息
 */
public class FileBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID = 1L;

    /** 文件ID */
    private String            id               = null;

    /** 文件原始名称 */
    private String            name             = null;

    /** 文件批次号 */
    private String            batch            = null;

    /** 文件大小 */
    private String            size             = null;

    /** 文件存储相对路径 */
    private String            path             = null;

    /** 文件后缀名 */
    private String            suffix           = null;

    /**
     * 默认构造函数
     */
    public FileBean() {
        super();
    }

    /**
     * 取得文件ID
     * 
     * @return 文件ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置文件ID
     * 
     * @param id 文件ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 取得文件原始名称
     * 
     * @return 文件原始名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置文件原始名称
     * 
     * @param name 文件原始名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 取得文件批次号
     * 
     * @return 文件批次号
     */
    public String getBatch() {
        return batch;
    }

    /**
     * 设置文件批次号
     * 
     * @param bath 文件批次号
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * 取得文件大小
     * 
     * @return 文件大小
     */
    public String getSize() {
        return size;
    }

    /**
     * 设置文件大小
     * 
     * @param size 文件大小
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * 取得文件存储相对路径
     * 
     * @return 文件存储相对路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置文件存储相对路径
     * 
     * @param path 文件存储相对路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 取得文件后缀名
     * 
     * @return 文件后缀名
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * 设置文件后缀名
     * 
     * @param suffix 文件后缀名
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

}