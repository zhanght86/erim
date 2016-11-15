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
import com.erim.sz.system.bean.ZxSystemRoleFuncBean;

/**
 * 
 * @ClassName: ZxSystemRoleFuncDao 
 * @Description: 角色权限表
 * @author maoxian
 * @date 2015年8月2日 上午11:25:38
 */
@Repository("zxSystemRoleFuncDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ZxSystemRoleFuncDao extends BaseDao {
	
	/**
	 * 
	 * @Title: insertList 
	 * @Description: 插入角色权限数组
	 * @param @param zxSystemRoleFuncBeans    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insertList(List<ZxSystemRoleFuncBean> zxSystemRoleFuncBeans){
		this.getSqlSession().insert("zxsystemrolefunc.insertList", zxSystemRoleFuncBeans);
	}
	
	/**
	 * 
	 * @Title: selectRoleFuncByRoleCode 
	 * @Description: 根据角色编码查询所有权限
	 * @param @param roleCode
	 * @param @return    设定文件 
	 * @return List<ZxSystemRoleFuncBean>    返回类型 
	 * @throws
	 */
	public List<ZxSystemRoleFuncBean> selectRoleFuncByRoleId(String roleid){
		return this.getSqlSession().selectList("zxsystemrolefunc.selectRoleFuncByRoleId", roleid);
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
		this.getSqlSession().delete("zxsystemrolefunc.deleteByRoleCode", zxRoleId);
	}
}