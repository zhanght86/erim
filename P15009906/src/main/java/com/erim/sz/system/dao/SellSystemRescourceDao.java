/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserDao.java : 2013-06-30
 */
package com.erim.sz.system.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.system.bean.SellSystemRescourceBean;

/**
 * 
 * @ClassName: SellSystemRescourceDao 
 * @Description: 权限路径表
 * @author maoxian
 * @date 2015年8月3日 下午1:19:53 
 *
 */
@Repository("sellSystemRescourceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SellSystemRescourceDao extends BaseDao {
	
	/**
	 * 
	 * @Title: sellSystemRescourceBean 
	 * @Description: 根据路径返回实体
	 * @param @param zxRescourceUrl
	 * @param @return    设定文件 
	 * @return SellSystemRescourceBean    返回类型 
	 * @throws
	 */
	public SellSystemRescourceBean selectSellSystemRescourceBean(String zxRescourceUrl){
		return this.getSqlSession().selectOne("sellsystemrescource.selectRescourceByUrl", zxRescourceUrl);
	}
}