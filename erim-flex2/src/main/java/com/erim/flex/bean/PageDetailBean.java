/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * PageDetailBean.java : 2012-02-03
 */
package com.erim.flex.bean;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author 宋哲
 * @version 创建时间：2012-02-03
 * @description 页面组件详细信息
 */
public class PageDetailBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID = 1L;

    /** 组件ID */
    private Integer           id;

    /** 页面ID */
    private Integer           pageid;

    /** 组件名称 */
    private String            name;

    /** 组件类型 */
    private String            type;

    /** 组件序号 */
    private Integer           no;

    /** 组件X轴坐标 */
    private String            x;

    /** 组件Y轴坐标 */
    private String            y;

    /** 组件宽度 */
    private String            width;

    /** 组件高度 */
    private String            height;

    /** 组件样式 */
    private String            style;

    /** 组件显示文本 */
    private String            text;

    /** 组件数据源 */
    private String            data;

    /** 组件动作 */
    private String            action;

    /** 组件验证信息 */
    private String            validator;

    /** 组件错误信息 */
    private String            errmsg;

    /** 组件是否可见 */
    private String            visable;

    /** 组件是否必输 */
    private String            required;

    /** 组件参数 */
    private String            args;

    /** 组件数据源转换 */
    @SuppressWarnings("rawtypes")
    private HashMap           dataProvider;

    /**
     * 默认构造函数
     */
    public PageDetailBean() {
        super();
    }

    /**
     * 取得组件ID
     * 
     * @return 组件ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置组件ID
     * 
     * @param id 组件ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 取得页面ID
     * 
     * @return 页面ID
     */
    public Integer getPageid() {
        return pageid;
    }

    /**
     * 设置页面ID
     * 
     * @param pageid 页面ID
     */
    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    /**
     * 取得组件名称
     * 
     * @return 组件名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置组件名称
     * 
     * @param name 组件名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 取得组件类型
     * 
     * @return 组件类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置组件类型
     * 
     * @param type 组件类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 取得组件序号
     * 
     * @return 组件序号
     */
    public Integer getNo() {
        return no;
    }

    /**
     * 设置组件序号
     * 
     * @param no 组件序号
     */
    public void setNo(Integer no) {
        this.no = no;
    }

    /**
     * 取得组件X轴坐标
     * 
     * @return 组件X轴坐标
     */
    public String getX() {
        return x;
    }

    /**
     * 设置组件X轴坐标
     * 
     * @param x 组件X轴坐标
     */
    public void setX(String x) {
        this.x = x;
    }

    /**
     * 取得组件Y轴坐标
     * 
     * @return 组件Y轴坐标
     */
    public String getY() {
        return y;
    }

    /**
     * 设置组件Y轴坐标
     * 
     * @param y 组件Y轴坐标
     */
    public void setY(String y) {
        this.y = y;
    }

    /**
     * 取得组件宽度
     * 
     * @return 组件宽度
     */
    public String getWidth() {
        return width;
    }

    /**
     * 设置组件宽度
     * 
     * @param width 组件宽度
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * 取得组件高度
     * 
     * @return 组件高度
     */
    public String getHeight() {
        return height;
    }

    /**
     * 设置组件高度
     * 
     * @param height 组件高度
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * 取得组件样式
     * 
     * @return 组件样式
     */
    public String getStyle() {
        return style;
    }

    /**
     * 设置组件样式
     * 
     * @param style 组件样式
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * 取得组件显示文本
     * 
     * @return 组件显示文本
     */
    public String getText() {
        return text;
    }

    /**
     * 设置组件显示文本
     * 
     * @param text 组件显示文本
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 取得组件数据源
     * 
     * @return 组件数据源
     */
    public String getData() {
        return data;
    }

    /**
     * 设置组件数据源
     * 
     * @param data 组件数据源
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * 取得组件动作
     * 
     * @return 组件动作
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置组件动作
     * 
     * @param action 组件动作
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 取得组件验证信息
     * 
     * @return 组件验证信息
     */
    public String getValidator() {
        return validator;
    }

    /**
     * 设置组件验证信息
     * 
     * @param validator 组件验证信息
     */
    public void setValidator(String validator) {
        this.validator = validator;
    }

    /**
     * 取得组件错误信息
     * 
     * @return 组件错误信息
     */
    public String getErrmsg() {
        return errmsg;
    }

    /**
     * 设置组件错误信息
     * 
     * @param errmsg 组件错误信息
     */
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    /**
     * 取得组件是否可见
     * 
     * @return 组件是否可见
     */
    public String getVisable() {
        return visable;
    }

    /**
     * 设置组件是否可见
     * 
     * @param visable 组件是否可见
     */
    public void setVisable(String visable) {
        this.visable = visable;
    }

    /**
     * 取得组件是否必输
     * 
     * @return 组件是否必输
     */
    public String getRequired() {
        return required;
    }

    /**
     * 设置组件是否必输
     * 
     * @param required 组件是否必输
     */
    public void setRequired(String required) {
        this.required = required;
    }

    /**
     * 取得组件参数
     * 
     * @return 组件参数
     */
    public String getArgs() {
        return args;
    }

    /**
     * 设置组件参数
     * 
     * @param args 组件参数
     */
    public void setArgs(String args) {
        this.args = args;
    }

    /**
     * 取得组件数据源转换
     * 
     * @return 组件数据源转换
     */
    @SuppressWarnings("rawtypes")
    public HashMap getDataProvider() {
        return dataProvider;
    }

    /**
     * 设置组件数据源转换
     * 
     * @param dataProvider 组件数据源转换
     */
    @SuppressWarnings("rawtypes")
    public void setDataProvider(HashMap dataProvider) {
        this.dataProvider = dataProvider;
    }

}