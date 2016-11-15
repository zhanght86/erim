/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * RegionBean.java : 2011-10-08
 */
package com.erim.flex.bean;

import java.io.Serializable;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-08
 * @description 代码信息，因为key和mybatis的关键字重复，故使用全称。
 */
public class RegionBean implements Serializable {

    /** 序列化版本ID */
    private static final long serialVersionUID = 1L;

    /** 地区代码ID */
    private String            regionId;

    /** 地区代码序号 */
    private String            regionNo;

    /** 地区代码父ID */
    private String            regionPid;

    /** 地区代码级别 */
    private String            regionLevel;

    /** 地区代码名称 */
    private String            regionName;

    /** 地区代码全拼 */
    private String            regionSpell;

    /** 地区代码备注 */
    private String            regionRemark;

    /**
     * 默认构造函数
     */
    public RegionBean() {
        super();
    }

    /**
     * 取得地区代码ID
     * 
     * @return 地区代码ID
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * 设置地区代码ID
     * 
     * @param regionId 地区代码ID
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * 取得地区代码序号
     * 
     * @return 地区代码序号
     */
    public String getRegionNo() {
        return regionNo;
    }

    /**
     * 设置地区代码序号
     * 
     * @param regionNo 地区代码序号
     */
    public void setRegionNo(String regionNo) {
        this.regionNo = regionNo;
    }

    /**
     * 取得地区代码父ID
     * 
     * @return 地区代码父ID
     */
    public String getRegionPid() {
        return regionPid;
    }

    /**
     * 设置地区代码父ID
     * 
     * @param regionPid 地区代码父ID
     */
    public void setRegionPid(String regionPid) {
        this.regionPid = regionPid;
    }

    /**
     * 取得地区代码级别
     * 
     * @return 地区代码级别
     */
    public String getRegionLevel() {
        return regionLevel;
    }

    /**
     * 设置地区代码级别
     * 
     * @param regionLevel 地区代码级别
     */
    public void setRegionLevel(String regionLevel) {
        this.regionLevel = regionLevel;
    }

    /**
     * 取得地区代码名称
     * 
     * @return 地区代码名称
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * 设置地区代码名称
     * 
     * @param regionName 地区代码名称
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     * 取得地区代码全拼
     * 
     * @return 地区代码全拼
     */
    public String getRegionSpell() {
        return regionSpell;
    }

    /**
     * 设置地区代码全拼
     * 
     * @param regionSpell 地区代码全拼
     */
    public void setRegionSpell(String regionSpell) {
        this.regionSpell = regionSpell;
    }

    /**
     * 取得地区代码备注
     * 
     * @return 地区代码备注
     */
    public String getRegionRemark() {
        return regionRemark;
    }

    /**
     * 设置地区代码备注
     * 
     * @param regionRemark 地区代码备注
     */
    public void setRegionRemark(String regionRemark) {
        this.regionRemark = regionRemark;
    }

}