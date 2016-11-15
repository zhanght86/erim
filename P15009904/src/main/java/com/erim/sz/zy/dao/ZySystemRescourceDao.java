/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserDao.java : 2013-06-30
 */
package com.erim.sz.zy.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.zy.bean.ZySystemRescourceBean;

/**
 * 
 * @ClassName: ZySystemRescourceDao 
 * @Description: 权限路径表
 * @author maoxian
 * @date 2015年8月3日 下午1:19:53 
 *
 */
@Repository("zySystemRescourceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ZySystemRescourceDao extends BaseDao {
	
	/**
	 * 
	 * @Title: zySystemRescourceBean 
	 * @Description: 根据路径返回实体
	 * @param @param zyRescourceUrl
	 * @param @return    设定文件 
	 * @return ZySystemRescourceBean    返回类型 
	 * @throws
	 */
	public ZySystemRescourceBean selectZySystemRescourceBean(String zyRescourceUrl){
		return this.getSqlSession().selectOne("zysystemrescource.selectRescourceByUrl", zyRescourceUrl);
	}
}