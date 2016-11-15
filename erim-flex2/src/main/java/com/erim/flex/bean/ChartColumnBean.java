/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ChartColumnBean.java : 2012-04-11
 */
package com.erim.flex.bean;

import java.io.Serializable;

/**
 * @author 宋哲
 * @version 创建时间：2012-04-11
 * @description 柱状图柱信息描述。
 */
public class ChartColumnBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID  = 1L;

    /** 列显示字段 */
    private String            columnDisplayName = null;

    /** 列Y轴字段 */
    private String            columnYField      = null;

    /** 列显示颜色 */
    private String            columnColor       = null;

    /**
     * 默认构造函数
     */
    public ChartColumnBean() {
        super();
    }

    /**
     * 取得列显示字段
     * 
     * @return 列显示字段
     */
    public String getColumnDisplayName() {
        return columnDisplayName;
    }

    /**
     * 设置列显示字段
     * 
     * @param columnDisplayName 列显示字段
     */
    public void setColumnDisplayName(String columnDisplayName) {
        this.columnDisplayName = columnDisplayName;
    }

    /**
     * 取得列Y轴字段
     * 
     * @return 列Y轴字段
     */
    public String getColumnYField() {
        return columnYField;
    }

    /**
     * 设置列Y轴字段
     * 
     * @param columnYField 列Y轴字段
     */
    public void setColumnYField(String columnYField) {
        this.columnYField = columnYField;
    }

    /**
     * 取得列显示颜色
     * 
     * @return 列显示颜色
     */
    public String getColumnColor() {
        return columnColor;
    }

    /**
     * 设置列显示颜色
     * 
     * @param columnColor 列显示颜色
     */
    public void setColumnColor(String columnColor) {
        this.columnColor = columnColor;
    }

}