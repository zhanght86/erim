/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserDao.java : 2013-06-30
 */
package com.erim.sz.zy.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.zy.bean.ZySystemRoleFuncBean;

/**
 * 
 * @ClassName: ZySystemRoleFuncDao 
 * @Description: 角色权限表
 * @author maoxian
 * @date 2015年8月2日 上午11:25:38
 */
@Repository("zySystemRoleFuncDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ZySystemRoleFuncDao extends BaseDao {
	
	/**
	 * 
	 * @Title: insertList 
	 * @Description: 插入角色权限数组
	 * @param @param zySystemRoleFuncBeans    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insertList(List<ZySystemRoleFuncBean> zySystemRoleFuncBeans){
		this.getSqlSession().insert("zysystemrolefunc.insertList", zySystemRoleFuncBeans);
	}
	
	/**
	 * 
	 * @Title: selectRoleFuncByRoleCode 
	 * @Description: 根据角色编码查询所有权限
	 * @param @param roleCode
	 * @param @return    设定文件 
	 * @return List<ZySystemRoleFuncBean>    返回类型 
	 * @throws
	 */
	public List<ZySystemRoleFuncBean> selectRoleFuncByRoleId(String roleid){
		return this.getSqlSession().selectList("zysystemrolefunc.selectRoleFuncByRoleId", roleid);
	}
	
	/**
	 * @Title: selectAll 
	 * @Description: 查询所有
	 * @param @return    设定文件 
	 * @return List<ZySystemRoleFuncBean>    返回类型 
	 * @author maoxian
	 * @date 2015年11月30日 下午10:13:32 
	 * @throws
	 */
	public List<ZySystemRoleFuncBean> selectAll(){
		return this.getSqlSession().selectList("zysystemrolefunc.selectAll");
	}
	
	/**
	 * 
	 * @Title: deleteByRoleCode 
	 * @Description: 根据角色编码删除
	 * @param @param roleCode    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void deleteByRoleId(String zyRoleId){
		this.getSqlSession().delete("zysystemrolefunc.deleteByRoleCode", zyRoleId);
	}
}