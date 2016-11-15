/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * ErimException.java : 2011-10-9 上午9:44:16
 */
package com.erim.core.exception;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-9 上午9:44:16
 * @description Erim基类异常
 */
public class ErimException extends Exception {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 8018869419729224935L;

    /**
     * 错误信息
     */
    private String            message;

    /**
     * 转发异常
     */
    private Throwable         throwable;

    /**
     * 无参构造函数
     */
    public ErimException() {
    }

    /**
     * 构造函数
     * @param message 错误信息
     */
    public ErimException(String message) {
        this.message = message;
    }

    /**
     * 构造函数
     * @param e 转发异常
     */
    public ErimException(Throwable e) {
        this.throwable = e;
    }

    /**
     * 重写getMessage方法，用于获取错误信息
     * @return 错误信息
     */
    public String getMessage() {
        if (throwable != null)
            return throwable.getMessage();
        if (message == null || message == "")
            return "系统错误:未知错误！";
        return message;
    }

    /**
     * 设置错误信息
     * @param message 信息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取转发异常
     * @return 转发异常
     */
    public Throwable getThrowable() {
        return throwable;
    }

    /**
     * 设置转发异常
     * @param throwable 转发异常
     */
    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
