/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * SystemException.java : 2011-10-9 下午12:56:47
 */
package com.erim.core.exception;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-9 下午12:56:47
 * @description 系统异常
 */
public class SystemException extends ErimException {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 6957188613786951756L;

    /**
     * 无参构造函数
     */
    public SystemException() {
        super();
    }

    /**
     * 构造函数
     * @param message 错误信息
     */
    public SystemException(String message) {
        super("错误类别：系统错误\n错误信息：" + message);
    }

    /**
     * 构造函数
     * @param e 转发异常
     */
    public SystemException(Throwable e) {
        super(e);
    }

}
