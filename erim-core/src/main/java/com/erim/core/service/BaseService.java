/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * BaseService.java : 2012-7-6 上午10:42:20
 */
package com.erim.core.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 宋哲
 * @version 创建时间：2012-7-6 上午10:42:20
 * @description 已经注入mybatis sqlsession的服务基类
 */
public abstract class BaseService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private SqlSession        sqlSession;

    /**
     * 获取sqlsession
     * 
     * @return
     */
    public SqlSession getSqlSession() {
        return sqlSession;
    }

    /**
     * 获取sqlsessionfactory
     * 
     * @return
     */
    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}
