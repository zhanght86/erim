/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * BaseMapper.java : 2011-12-1 下午11:49:52
 */
package com.erim.core.persistence;

import java.util.List;

/**
 * @author 宋哲
 * @version 创建时间：2011-12-1 下午11:49:52
 * @description 持久层
 */
public interface BaseMapper<T> {

    /**
     * 插入数据实体
     * 
     * @param object 插入参数
     * @return 插入记录数
     */
    public Integer insert(Object object);

    /**
     * 删除数据实体
     * 
     * @param object 删除参数
     * @return 删除记录数
     */
    public Integer delete(Object object);

    /**
     * 修改数据实体
     * 
     * @param object 修改参数
     * @return 修改记录数
     */
    public Integer update(Object object);

    /**
     * 查询总记录数
     * 
     * @param object 查询参数
     * @return 总记录数
     */
    public Integer selectCount(Object object);

    /**
     * 查询所有数据
     * 
     * @param object 查询参数
     * @return 总记录集合
     */
    public List<T> selectAll(Object object);

    /**
     * 查询分页数据
     * 
     * @param object 查询参数
     * @return 分页数据集合
     */
    public List<T> selectPage(Object object);

    /**
     * 通过ID(PK)查询单条数据
     * 
     * @param object 查询参数
     * @return 单条数据
     */
    public T selectEntityById(Object object);

    /**
     * 通过Name(UQ)查询单条数据
     * 
     * @param object 查询参数
     * @return 单条数据
     */
    public T selectEntityByName(Object object);
    
    /**
     * 通过No(UQ)查询单条数据
     * 
     * @param object 查询参数
     * @return 单条数据
     */
    public T selectEntityByNo(Object object);

}
