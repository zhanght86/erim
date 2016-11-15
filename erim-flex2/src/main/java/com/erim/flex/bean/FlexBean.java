/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * FlexBean.java : 2011-10-09
 */
package com.erim.flex.bean;

import java.io.Serializable;
import java.util.HashMap;

import flex.messaging.io.amf.ASObject;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-09
 * @description 由Java端返回Flex端的对象
 */
public class FlexBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID = 1L;

    /** 返回标志 */
    private String            backFlag;

    /** 返回内容 */
    private ASObject          asObject;

    /**
     * 默认构造函数
     */
    public FlexBean() {
        super();
    }

    /**
     * 取得返回标志
     * 
     * @return 返回标志
     */
    public String getBackFlag() {
        return backFlag;
    }

    /**
     * 设置返回标志
     * 
     * @param backFlag 返回标志
     */
    public void setBackFlag(String backFlag) {
        this.backFlag = backFlag;
    }

    /**
     * 取得返回内容
     * 
     * @return 返回内容
     */
    public ASObject getAsObject() {
        return asObject;
    }

    /**
     * 设置返回内容
     * 
     * @param asObject 返回内容
     */
    public void setAsObject(ASObject asObject) {
        this.asObject = asObject;
    }

    /**
     * 设置返回内容
     * 
     * @param asObject 返回内容
     */
    @SuppressWarnings("unchecked")
    public void setAsObject(HashMap<String, Object> hashMap) {
        this.asObject = new ASObject();
        this.asObject.putAll(hashMap);
    }

}