/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * BusiUserBean.java : 2014-04-14
 */
package com.erim.sz.common.bean;

import java.io.Serializable;

/**
 * @author 李洪元
 * @version 创建时间：2014-04-14
 * @description 注册用户信息
 */
public class UserBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Integer           userId           = null;

    /** 用户名 */
    private String            userName         = null;

    /** 登录密码 */
    private String            userPswd         = null;

    /** 用户状态 */
    private String            userStatus       = null;

    /** 用户角色 */
    private String            userRole         = null;

    /** 用户头像 */
    private String            userPhoto        = null;

    /** 真实姓名 */
    private String            userRealname     = null;

    /** 性别 */
    private String            userSex          = null;

    /** 出生日期 */
    private String            userBornDate     = null;

    /** 电子邮箱 */
    private String            userEmail        = null;

    /** 电话 */
    private String            userPhone        = null;

    /** 地址 */
    private String            userAddress      = null;

    /** 注册时间 */
    private String            registerTime     = null;

    /** 上次登录时间 */
    private String            lastLogonTime    = null;

    /** 上次登录IP */
    private String            lastLogonIp      = null;

    /**
     * 默认构造函数
     */
    public UserBean() {
        super();
    }

    /**
     * 取得用户ID
     * 
     * @return 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     * 
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 取得用户名
     * 
     * @return 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     * 
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 取得登录密码
     * 
     * @return 登录密码
     */
    public String getUserPswd() {
        return userPswd;
    }

    /**
     * 设置登录密码
     * 
     * @param userPswd 登录密码
     */
    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd;
    }

    /**
     * 取得用户状态
     * 
     * @return 用户状态
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户状态
     * 
     * @param userStatus 用户状态
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 取得用户角色
     * 
     * @return 用户角色
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 设置用户角色
     * 
     * @param userRole 用户角色
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * 取得用户头像
     * 
     * @return 用户头像
     */
    public String getUserPhoto() {
        return userPhoto;
    }

    /**
     * 设置用户头像
     * 
     * @param userPhoto 用户头像
     */
    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    /**
     * 取得真实姓名
     * 
     * @return 真实姓名
     */
    public String getUserRealname() {
        return userRealname;
    }

    /**
     * 设置真实姓名
     * 
     * @param userRealname 真实姓名
     */
    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    /**
     * 取得性别
     * 
     * @return 性别
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * 设置性别
     * 
     * @param userSex 性别
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * 取得出生日期
     * 
     * @return 出生日期
     */
    public String getUserBornDate() {
        return userBornDate;
    }

    /**
     * 设置出生日期
     * 
     * @param userBornDate 出生日期
     */
    public void setUserBornDate(String userBornDate) {
        this.userBornDate = userBornDate;
    }

    /**
     * 取得电子邮箱
     * 
     * @return 电子邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置电子邮箱
     * 
     * @param userEmail 电子邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * 取得电话
     * 
     * @return 电话
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置电话
     * 
     * @param userPhone 电话
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 取得地址
     * 
     * @return 地址
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 设置地址
     * 
     * @param userAddress 地址
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * 取得注册时间
     * 
     * @return 注册时间
     */
    public String getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置注册时间
     * 
     * @param registerTime 注册时间
     */
    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 取得上次登录时间
     * 
     * @return 上次登录时间
     */
    public String getLastLogonTime() {
        return lastLogonTime;
    }

    /**
     * 设置上次登录时间
     * 
     * @param lastLogonTime 上次登录时间
     */
    public void setLastLogonTime(String lastLogonTime) {
        this.lastLogonTime = lastLogonTime;
    }

    /**
     * 取得上次登录IP
     * 
     * @return 上次登录IP
     */
    public String getLastLogonIp() {
        return lastLogonIp;
    }

    /**
     * 设置上次登录IP
     * 
     * @param lastLogonIp 上次登录IP
     */
    public void setLastLogonIp(String lastLogonIp) {
        this.lastLogonIp = lastLogonIp;
    }

}