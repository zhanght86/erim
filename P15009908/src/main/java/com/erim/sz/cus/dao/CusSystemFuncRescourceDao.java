/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserDao.java : 2013-06-30
 */
package com.erim.sz.cus.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.cus.bean.CusSystemFuncRescourceBean;

/**
 * 
 * @ClassName: CusSystemFuncRescourceDao 
 * @Description: 角色权限
 * @author maoxian
 * @date 2015年8月2日 上午12:55:49
 */
@Repository("cusSystemFuncRescourceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CusSystemFuncRescourceDao extends BaseDao {
	
	/**
	 * 
	 * @Title: selectAll 
	 * @Description: 查询菜单
	 * @param @return    设定文件 
	 * @return List<CusSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<CusSystemFuncRescourceBean> selectAll(){
		return this.getSqlSession().selectList("cussystemfuncrescource.selectAll");
	}
	
	/**
	 * 
	 * @Title: selectRecourceByFuncCode 
	 * @Description: 通过权限code获取功能
	 * @param @param funcCode
	 * @param @return    设定文件 
	 * @return List<CusSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<CusSystemFuncRescourceBean> selectRecourceByFuncCode(String cusFuncCode){
		return this.getSqlSession().selectList("cussystemfuncrescource.selectRecourceByFuncCode",cusFuncCode);
	}
}