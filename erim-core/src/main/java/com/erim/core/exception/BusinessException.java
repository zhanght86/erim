/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * BusinessException.java : 2011-10-9 下午12:58:02
 */
package com.erim.core.exception;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-9 下午12:58:02
 * @description 业务异常
 */
public class BusinessException extends ErimException {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 3352462527427742996L;

    /**
     * 无参构造函数
     */
    public BusinessException() {
        super();
    }

    /**
     * 构造函数
     * @param message 错误信息
     */
    public BusinessException(String message) {
        super("错误类别：业务错误\n错误信息：" + message);
    }

    /**
     * 构造函数
     * @param e 转发异常
     */
    public BusinessException(Throwable e) {
        super(e);
    }

}
