/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * FuncBean.java : 2011-11-06
 */
package com.erim.flex.bean;

import java.io.Serializable;

/**
 * @author 宋哲
 * @version 创建时间：2011-11-06
 * @description 功能信息
 */
public class FuncBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID = 1L;

    /** 功能ID */
    private Integer           id;

    /** 功能父ID */
    private Integer           pid;

    /** 功能序号 */
    private Integer           no;

    /** 功能类型 */
    private String            type;

    /** 功能名称 */
    private String            name;

    /** 功能权限 */
    private String            auth;

    /** 功能动作 */
    private String            action;

    /**
     * 默认构造函数
     */
    public FuncBean() {
        super();
    }

    /**
     * 取得功能ID
     * 
     * @return 功能ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置功能ID
     * 
     * @param id 功能ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 取得功能父ID
     * 
     * @return 功能父ID
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置功能父ID
     * 
     * @param pid 功能父ID
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 取得功能序号
     * 
     * @return 功能序号
     */
    public Integer getNo() {
        return no;
    }

    /**
     * 设置功能序号
     * 
     * @param no 功能序号
     */
    public void setNo(Integer no) {
        this.no = no;
    }

    /**
     * 取得功能类型
     * 
     * @return 功能类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置功能类型
     * 
     * @param type 功能类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 取得功能名称
     * 
     * @return 功能名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置功能名称
     * 
     * @param name 功能名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 取得功能权限
     * 
     * @return 功能权限
     */
    public String getAuth() {
        return auth;
    }

    /**
     * 设置功能权限
     * 
     * @param auth 功能权限
     */
    public void setAuth(String auth) {
        this.auth = auth;
    }

    /**
     * 取得功能动作
     * 
     * @return 功能动作
     */
    public String getAction() {
        return action;
    }

    /**
     * 设置功能动作
     * 
     * @param action 功能动作
     */
    public void setAction(String action) {
        this.action = action;
    }

}