/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserDao.java : 2013-06-30
 */
package com.erim.sz.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.YjSystemUserBean;
import com.erim.sz.system.bean.YjSystemRoleBean;

/**
 * 
 * @ClassName: CmsSystemUserDao 
 * @Description: 商户角色
 * @author maoxian
 * @date 2015年8月1日 上午11:21:59
 */
@Repository("yjSystemRoleDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class YjSystemRoleDao extends BaseDao {
	
	
	/**
	 * 
	 * @Title: selectPage 
	 * @Description: 查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<YjSystemUserBean>    返回类型 
	 * @throws
	 */
	public List<YjSystemRoleBean> selectPage(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("yjsystemrole.selectPage", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }

	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入角色信息
	 * @param @param yjSystemRoleBean
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insert(YjSystemRoleBean yjSystemRoleBean){
		return this.getSqlSession().insert("yjsystemrole.insert", yjSystemRoleBean);
	}
	
	
	public List<YjSystemRoleBean> selectYjSystemRoleByCpyId(@Param("cpyId") int cpyId){
		return this.getSqlSession().selectList("yjsystemrole.selectYjSystemRoleByCpyId", cpyId);
	}

	/**
	 * 
	 * @Title: selectBeanById 
	 * @Description: 根据id查询角色
	 * @param @param id
	 * @param @return    设定文件 
	 * @return YjSystemRoleBean    返回类型 
	 * @throws
	 */
	public YjSystemRoleBean selectBeanById(int id){
		return this.getSqlSession().selectOne("yjsystemrole.selectBeanById", id);
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 角色修改
	 * @param @param yjSystemRoleBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(YjSystemRoleBean yjSystemRoleBean){
		this.getSqlSession().update("yjsystemrole.update", yjSystemRoleBean);
	}

	public List<YjSystemUserBean> selectYjSystemUserByCpyId(int cpyid) {
		return this.getSqlSession().selectList("yjsystemuser.selectYjSystemUserByCpyId", cpyid);
	}
}