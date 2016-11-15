/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserDao.java : 2013-06-30
 */
package com.erim.sz.system.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.system.bean.SellSystemFuncBean;

/**
 * 
 * @ClassName: SellSystemFunc 
 * @Description: 菜单列表
 * @author maoxian
 * @date 2015年8月1日 下午9:15:05
 */
@Repository("sellSystemFuncDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SellSystemFuncDao extends BaseDao {
	
	/**
	 * 
	 * @Title: selectAll 
	 * @Description: 查询菜单
	 * @param @return    设定文件 
	 * @return List<SellSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<SellSystemFuncBean> selectAll(){
		return this.getSqlSession().selectList("sellsystemfunc.selectAll");
	}
	
	/**
	 * 
	 * @Title: selectFuncByParentcode 
	 * @Description: 根据parentcode查询子级别
	 * @param @param zxFuncParentcode
	 * @param @return    设定文件 
	 * @return List<SellSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<SellSystemFuncBean> selectFuncByParentcode(String zxFuncParentcode){
		return this.getSqlSession().selectList("sellsystemfunc.selectFuncByParentcode",zxFuncParentcode);
	}
	
	/**
	 * 
	 * @Title: selectFuncByCode 
	 * @Description: 根据code查询权限
	 * @param @param code
	 * @param @return    设定文件 
	 * @return List<SellSystemFuncBean>    返回类型 
	 * @throws
	 */
	public List<SellSystemFuncBean> selectFuncByCode(String[] code){
		return this.getSqlSession().selectList("sellsystemfunc.selectFuncByCode",code);
	}
}