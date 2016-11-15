/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserDao.java : 2013-06-30
 */
package com.erim.sz.cus.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.cus.bean.CusSystemUserBean;

/**
 * 
 * @ClassName: CmsSystemUserDao 
 * @Description: 商户用户
 * @author maoxian
 * @date 2015年8月1日 上午11:21:59
 */
@Repository("cusSystemUserDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CusSystemUserDao extends BaseDao {

	/**
	 * @Title: selectUserById 
	 * @Description: 根据ID查询
	 * @param @param id
	 * @param @return    设定文件 
	 * @return CusSystemUserBean    返回类型 
	 * @throws
	 */
	public CusSystemUserBean selectUserById(Integer id){
		return this.getSqlSession().selectOne("cussystemuser.selectUserById", id);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer delete(CusSystemUserBean cusSystemUserBean){
		return this.getSqlSession().delete("cussystemuser.delete", cusSystemUserBean);
	}
	
	/**
	 * @Title: updateLogin 
	 * @Description: 修改上次登陆时间
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer updateLogin(CusSystemUserBean bean){
		return this.getSqlSession().update("cussystemuser.updateLogin", bean);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改方法 
	 * @param @param cusSystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public Integer update(CusSystemUserBean cusSystemUserBean){
		return getSqlSession().update("cussystemuser.update", cusSystemUserBean);
	}
	
	/**
	 * @Title: selectUserByLoginname 
	 * @Description: 根据用户登录名获取用户信息
	 * @param @param loginName
	 * @param @return    设定文件 
	 * @return CmsSystemUserBean    返回类型 
	 * @throws
	 */
    public CusSystemUserBean selectUserByLoginname(String cusUserLoginname){
    	 return getSqlSession().selectOne("cussystemuser.selectUserByLoginname", cusUserLoginname);
    }

    /**
     * @Title: selectUserByRoleId 
     * @Description: 根据角色id 查询所有用户
     * @param @param roleid
     * @param @return    设定文件 
     * @return List<CusSystemUserBean>    返回类型 
     * @throws
     */
    public List<CusSystemUserBean> selectUserByRoleId(Integer cusRoleId){
    	return this.getSqlSession().selectList("cussystemuser.selectUserByRoleId", cusRoleId);
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 插入 
     * @param @param cusSystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void insert(CusSystemUserBean bean) {
    	this.getSqlSession().insert("cussystemuser.insert", bean);
    }
    
    /**
     * 
     * @Title: selectPageLine 
     * @Description: 分页查询
     * @param @param baseBean
     * @param @param model
     * @param @return    设定文件 
     * @return List<LineDetailBean>    返回类型 
     * @throws
     */
    public List<CusSystemUserBean> selectPage(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("cussystemuser.selectPage", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
     * @Title: updatePsd 
     * @Description: 根据用户ID修改密码
     * @param @param cusSystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void updatePsd(CusSystemUserBean cusSystemUserBean){
    	this.getSqlSession().update("cussystemuser.updatePsd", cusSystemUserBean);
    }
    
    /**
     * @描述: 根据公司ID删除用户信息
     * @作者: 宁晓强
     * @创建时间: 2016年1月5日 下午2:56:33
     * @param bean
     * @return
     */
    public Integer deleteUserByCpyId(CusSystemUserBean bean) {
    	return getSqlSession().delete("cussystemuser.deleteUserByCpyId", bean);
    }
}