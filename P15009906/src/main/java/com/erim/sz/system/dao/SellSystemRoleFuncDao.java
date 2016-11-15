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
import com.erim.sz.system.bean.SellSystemRoleFuncBean;

/**
 * 
 * @ClassName: SellSystemRoleFuncDao 
 * @Description: 角色权限表
 * @author maoxian
 * @date 2015年8月2日 上午11:25:38
 */
@Repository("sellSystemRoleFuncDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SellSystemRoleFuncDao extends BaseDao {
	
	/**
	 * 
	 * @Title: insertList 
	 * @Description: 插入角色权限数组
	 * @param @param sellSystemRoleFuncBeans    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insertList(List<SellSystemRoleFuncBean> sellSystemRoleFuncBeans){
		this.getSqlSession().insert("sellsystemrolefunc.insertList", sellSystemRoleFuncBeans);
	}
	
	/**
	 * 
	 * @Title: selectRoleFuncByRoleCode 
	 * @Description: 根据角色编码查询所有权限
	 * @param @param roleCode
	 * @param @return    设定文件 
	 * @return List<SellSystemRoleFuncBean>    返回类型 
	 * @throws
	 */
	public List<SellSystemRoleFuncBean> selectRoleFuncByRoleId(String roleid){
		return this.getSqlSession().selectList("sellsystemrolefunc.selectRoleFuncByRoleId", roleid);
	}
	/**
	 * 
	 * @Title: deleteByRoleCode 
	 * @Description: 根据角色编码删除
	 * @param @param roleCode    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void deleteByRoleId(String zxRoleId){
		this.getSqlSession().delete("sellsystemrolefunc.deleteByRoleCode", zxRoleId);
	}
}