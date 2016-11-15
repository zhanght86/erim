/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * OperateLogBean.java : 2011-10-08
 */
package com.erim.flex.bean;

import java.io.Serializable;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-08
 * @description 操作日志信息
 */
public class OperateLogBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID = 1L;

    /** 操作日志ID */
    private String            operateId        = null;

    /** 功能ID */
    private String            funcId           = null;

    /** 管理员ID */
    private String            userId           = null;

    /** 操作IP */
    private String            operateIp        = null;

    /** 操作时间 */
    private String            operateTime      = null;

    /** 操作时间1 */
    private String            operateTime1     = null;

    /** 操作时间2 */
    private String            operateTime2     = null;

    /** 操作明细 */
    private String            operateDetail    = null;

    /** 功能名称 */
    private String            funcName         = null;

    /** 管理员名称 */
    private String            userName         = null;

    /**
     * 默认构造函数
     */
    public OperateLogBean() {
        super();
    }

    /**
     * 取得操作日志ID
     * 
     * @return 操作日志ID
     */
    public String getOperateId() {
        return operateId;
    }

    /**
     * 设置操作日志ID
     * 
     * @param operateId 操作日志ID
     */
    public void setOperateId(String operateId) {
        this.operateId = operateId;
    }

    /**
     * 取得功能ID
     * 
     * @return 功能ID
     */
    public String getFuncId() {
        return funcId;
    }

    /**
     * 设置功能ID
     * 
     * @param funcId 功能ID
     */
    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    /**
     * 取得管理员ID
     * 
     * @return 管理员ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置管理员ID
     * 
     * @param userId 管理员ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 取得操作IP
     * 
     * @return 操作IP
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * 设置操作IP
     * 
     * @param operateIp 操作IP
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }

    /**
     * 取得操作时间
     * 
     * @return 操作时间
     */
    public String getOperateTime() {
        return operateTime;
    }

    /**
     * 设置操作时间
     * 
     * @param operateTime 操作时间
     */
    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 取得操作时间1
     * 
     * @return 操作时间1
     */
    public String getOperateTime1() {
        return operateTime1;
    }

    /**
     * 设置操作时间1
     * 
     * @param operateTime1 操作时间1
     */
    public void setOperateTime1(String operateTime1) {
        this.operateTime1 = operateTime1;
    }

    /**
     * 取得操作时间2
     * 
     * @return 操作时间2
     */
    public String getOperateTime2() {
        return operateTime2;
    }

    /**
     * 设置操作时间2
     * 
     * @param operateTime2 操作时间2
     */
    public void setOperateTime2(String operateTime2) {
        this.operateTime2 = operateTime2;
    }

    /**
     * 取得操作明细
     * 
     * @return 操作明细
     */
    public String getOperateDetail() {
        return operateDetail;
    }

    /**
     * 设置操作明细
     * 
     * @param operateDetail 操作明细
     */
    public void setOperateDetail(String operateDetail) {
        this.operateDetail = operateDetail;
    }

    /**
     * 取得功能名称
     * 
     * @return 功能名称
     */
    public String getFuncName() {
        return funcName;
    }

    /**
     * 设置功能名称
     * 
     * @param funcName 功能名称
     */
    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    /**
     * 取得管理员名称
     * 
     * @return 管理员名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置管理员名称
     * 
     * @param userName 管理员名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

}