/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * CodeBean.java : 2011-10-08
 */
package com.erim.web.bean;

import java.io.Serializable;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-08
 * @description 代码信息，因为key和mybatis的关键字重复，故使用全称。
 */
public class CodeBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID = 1L;

    /** 代码序号 */
    private String            codeId;

    /** 代码键 */
    private String            codeKey;

    /** 代码值 */
    private String            codeValue;

    /** 代码序号 */
    private Integer           codeNo;

    /** 代码备注 */
    private String            codeMark;

    /**
     * 默认构造函数
     */
    public CodeBean() {
        super();
    }

    /**
     * 取得代码序号
     * 
     * @return 代码序号
     */
    public String getCodeId() {
        return codeId;
    }

    /**
     * 设置代码序号
     * 
     * @param codeId 代码序号
     */
    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    /**
     * 取得代码键
     * 
     * @return 代码键
     */
    public String getCodeKey() {
        return codeKey;
    }

    /**
     * 设置代码键
     * 
     * @param codeKey 代码键
     */
    public void setCodeKey(String codeKey) {
        this.codeKey = codeKey;
    }

    /**
     * 取得代码值
     * 
     * @return 代码值
     */
    public String getCodeValue() {
        return codeValue;
    }

    /**
     * 设置代码值
     * 
     * @param codeValue 代码值
     */
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    /**
     * 取得代码序号
     * 
     * @return 代码序号
     */
    public Integer getCodeNo() {
        return codeNo;
    }

    /**
     * 设置代码序号
     * 
     * @param codeNo 代码序号
     */
    public void setCodeNo(Integer codeNo) {
        this.codeNo = codeNo;
    }

    /**
     * 取得代码备注
     * 
     * @return 代码备注
     */
    public String getCodeMark() {
        return codeMark;
    }

    /**
     * 设置代码备注
     * 
     * @param codeMark 代码备注
     */
    public void setCodeMark(String codeMark) {
        this.codeMark = codeMark;
    }

}