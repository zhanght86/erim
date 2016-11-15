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
import com.erim.sz.cus.bean.CusSystemFuncBean;

/**
 * 
 * @ClassName: CusSystemFunc 
 * @Description: 菜单列表
 * @author maoxian
 * @date 2015年8月1日 下午9:15:05
 */
@Repository("cusSystemFuncDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CusSystemFuncDao extends BaseDao {
	
	/**
	 * 
	 * @Title: selectAll 
	 * @Description: 查询菜单
	 * @param @return    设定文件 
	 * @return List<CusSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<CusSystemFuncBean> selectAll(){
		return this.getSqlSession().selectList("cussystemfunc.selectAll");
	}
	
	/**
	 * 
	 * @Title: selectFuncByParentcode 
	 * @Description: 根据parentcode查询子级别
	 * @param @param cusFuncParentcode
	 * @param @return    设定文件 
	 * @return List<CusSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<CusSystemFuncBean> selectFuncByParentcode(String cusFuncParentcode){
		return this.getSqlSession().selectList("cussystemfunc.selectFuncByParentcode",cusFuncParentcode);
	}
	
	/**
	 * 
	 * @Title: selectFuncByCode 
	 * @Description: 根据code查询权限
	 * @param @param code
	 * @param @return    设定文件 
	 * @return List<CusSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<CusSystemFuncBean> selectFuncByCode(String[] code){
		return this.getSqlSession().selectList("cussystemfunc.selectFuncByCode",code);
	}
}