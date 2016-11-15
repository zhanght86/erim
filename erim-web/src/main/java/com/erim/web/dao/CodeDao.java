/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * SortDao.java : 2013-06-30
 */
package com.erim.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.web.bean.CodeBean;

/**
 * @author 宋哲
 * @version 创建时间：2014-3-27 下午16:42:43
 * @description tm_system_code相关数据库操作
 */
@Repository("codeDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CodeDao extends BaseDao {

    /**
     * 查找所有代码参数
     */
    public List<CodeBean> selectAllCode() {
        return getSqlSession().selectList("code.selectAllCode");
    }

}