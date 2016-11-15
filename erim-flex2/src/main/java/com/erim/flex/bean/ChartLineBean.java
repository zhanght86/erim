/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ChartLineBean.java : 2011-4-11
 */
package com.erim.flex.bean;

import java.io.Serializable;

/**
 * @author 宋哲
 * @version 创建时间：2011-4-11
 * @description 线形图表线条信息，描述线条在flex端的基本属性。
 */
public class ChartLineBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID = 1L;

    /** 线条显示字段 */
    private String            lineDisplayName  = null;

    /** 线条颜色值 */
    private String            lineColor        = null;

    /** 两点线条连接模式 */
    private String            lineForm         = null;

    /** 线条Y轴字段 */
    private String            lineYField       = null;

    /**
     * 默认构造函数
     */
    public ChartLineBean() {
        super();
    }

    /**
     * 取得线条显示字段
     * 
     * @return 线条显示字段
     */
    public String getLineDisplayName() {
        return lineDisplayName;
    }

    /**
     * 设置线条显示字段
     * 
     * @param lineDisplayName 线条显示字段
     */
    public void setLineDisplayName(String lineDisplayName) {
        this.lineDisplayName = lineDisplayName;
    }

    /**
     * 取得线条颜色值
     * 
     * @return 线条颜色值
     */
    public String getLineColor() {
        return lineColor;
    }

    /**
     * 设置线条颜色值
     * 
     * @param lineColor 线条颜色值
     */
    public void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }

    /**
     * 取得两点线条连接模式
     * 
     * @return 两点线条连接模式
     */
    public String getLineForm() {
        return lineForm;
    }

    /**
     * 设置两点线条连接模式
     * 
     * @param lineForm 两点线条连接模式
     */
    public void setLineForm(String lineForm) {
        this.lineForm = lineForm;
    }

    /**
     * 取得线条Y轴字段
     * 
     * @return 线条Y轴字段
     */
    public String getLineYField() {
        return lineYField;
    }

    /**
     * 设置线条Y轴字段
     * 
     * @param lineYField 线条Y轴字段
     */
    public void setLineYField(String lineYField) {
        this.lineYField = lineYField;
    }

}