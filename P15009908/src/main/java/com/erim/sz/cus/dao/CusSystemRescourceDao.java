/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserDao.java : 2013-06-30
 */
package com.erim.sz.cus.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.cus.bean.CusSystemRescourceBean;

/**
 * 
 * @ClassName: CusSystemRescourceDao 
 * @Description: 权限路径表
 * @author maoxian
 * @date 2015年8月3日 下午1:19:53 
 *
 */
@Repository("cusSystemRescourceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CusSystemRescourceDao extends BaseDao {
	
	/**
	 * 
	 * @Title: cusSystemRescourceBean 
	 * @Description: 根据路径返回实体
	 * @param @param cusRescourceUrl
	 * @param @return    设定文件 
	 * @return CusSystemRescourceBean    返回类型 
	 * @throws
	 */
	public CusSystemRescourceBean selectCusSystemRescourceBean(String cusRescourceUrl){
		return this.getSqlSession().selectOne("cussystemrescource.selectRescourceByUrl", cusRescourceUrl);
	}
}