/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserDao.java : 2013-06-30
 */
package com.erim.sz.zy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.zy.bean.ZySystemRoleBean;

/**
 * 
 * @ClassName: CmsSystemUserDao 
 * @Description: 商户角色
 * @author maoxian
 * @date 2015年8月1日 上午11:21:59
 */
@Repository("zySystemRoleDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ZySystemRoleDao extends BaseDao {
	
	/**
	 * @Title: selectBeanByCooperation 
	 * @Description: 根据公司和合作角色查询用户
	 * @param @param rolebean
	 * @param @return    设定文件 
	 * @return List<ZySystemRoleBean>    返回类型 
	 * @throws
	 */
	public List<ZySystemRoleBean> selectBeanByCooperation(Integer cpyId){
		return this.getSqlSession().selectList("zysystemrole.selectBeanByCooperation", cpyId);
	}
	
	/**
	 * 
	 * @Title: selectPage 
	 * @Description: 查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<ZySystemUserBean>    返回类型 
	 * @throws
	 */
	public List<ZySystemRoleBean> selectPage(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("zysystemrole.selectPage", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }

	/**
	 * @Title: selectRoleIdByRolenameCpyid 
	 * @Description: 根据角色名称和公司id查询所属角色
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return ZySystemRoleBean    返回类型 
	 * @throws
	 */
	public ZySystemRoleBean selectRoleIdByRolenameCpyid(ZySystemRoleBean bean){
		return this.getSqlSession().selectOne("zysystemrole.selectRoleIdByRolenameCpyid", bean);
	}
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入角色信息
	 * @param @param zySystemRoleBean
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insert(ZySystemRoleBean zySystemRoleBean){
		return this.getSqlSession().insert("zysystemrole.insert", zySystemRoleBean);
	}
	
	/**
	 * @Title: selectZySystemRoleByCpyId 
	 * @Description: 根据公司id查询角色
	 * @param @param cpyId
	 * @param @return    设定文件 
	 * @return List<ZySystemRoleBean>    返回类型 
	 * @throws
	 */
	public List<ZySystemRoleBean> selectZySystemRoleByCpyId(@Param("cpyId") int cpyId){
		return this.getSqlSession().selectList("zysystemrole.selectZySystemRoleByCpyId", cpyId);
	}

	/**
	 * 
	 * @Title: selectBeanById 
	 * @Description: 根据id查询角色
	 * @param @param id
	 * @param @return    设定文件 
	 * @return ZySystemRoleBean    返回类型 
	 * @throws
	 */
	public ZySystemRoleBean selectBeanById(int id){
		return this.getSqlSession().selectOne("zysystemrole.selectBeanById", id);
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 角色修改
	 * @param @param zySystemRoleBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(ZySystemRoleBean zySystemRoleBean){
		this.getSqlSession().update("zysystemrole.update", zySystemRoleBean);
	}
}