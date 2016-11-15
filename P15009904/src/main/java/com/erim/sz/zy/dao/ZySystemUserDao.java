/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserDao.java : 2013-06-30
 */
package com.erim.sz.zy.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.zy.bean.ZySystemUserBean;

/**
 * 
 * @ClassName: CmsSystemUserDao 
 * @Description: 商户用户
 * @author maoxian
 * @date 2015年8月1日 上午11:21:59
 */
@Repository("zySystemUserDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ZySystemUserDao extends BaseDao {

	/**
	 * @Title: selectUserById 
	 * @Description: 根据ID查询
	 * @param @param id
	 * @param @return    设定文件 
	 * @return ZySystemUserBean    返回类型 
	 * @throws
	 */
	public ZySystemUserBean selectUserById(Integer id){
		return this.getSqlSession().selectOne("zysystemuser.selectUserById", id);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer delete(ZySystemUserBean zySystemUserBean){
		return this.getSqlSession().delete("zysystemuser.delete", zySystemUserBean);
	}
	
	/**
	 * @Title: updateLogin 
	 * @Description: 修改上次登陆时间
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer updateLogin(ZySystemUserBean bean){
		return this.getSqlSession().update("zysystemuser.updateLogin", bean);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改方法 
	 * @param @param zySystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public Integer update(ZySystemUserBean zySystemUserBean){
		return getSqlSession().update("zysystemuser.update", zySystemUserBean);
	}
	
	/**
	 * @Title: selectUserByLoginname 
	 * @Description: 根据用户登录名获取用户信息
	 * @param @param loginName
	 * @param @return    设定文件 
	 * @return CmsSystemUserBean    返回类型 
	 * @throws
	 */
    public ZySystemUserBean selectUserByLoginname(String zyUserLoginname){
    	 return getSqlSession().selectOne("zysystemuser.selectUserByLoginname", zyUserLoginname);
    }

    /**
     * @Title: selectUserByRoleId 
     * @Description: 根据角色id 查询所有用户
     * @param @param roleid
     * @param @return    设定文件 
     * @return List<ZySystemUserBean>    返回类型 
     * @throws
     */
    public List<ZySystemUserBean> selectUserByRoleId(Integer zyRoleId){
    	return this.getSqlSession().selectList("zysystemuser.selectUserByRoleId", zyRoleId);
    }
    
    /**
     * @Title: insert 
     * @Description: 插入 
     * @param @param zySystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void insert(ZySystemUserBean bean){
    	this.getSqlSession().insert("zysystemuser.insert", bean);
    }
    
    /**
     * @描述: 根据公司ID删除用户信息
     * @作者: 宁晓强
     * @创建时间: 2016年1月5日 下午2:56:33
     * @param bean
     * @return
     */
    public Integer deleteUserByCpyId(ZySystemUserBean bean) {
    	return getSqlSession().delete("zysystemuser.deleteUserByCpyId", bean);
    }
    
    /**
     * @Title: selectPageLine 
     * @Description: 分页查询
     * @param @param baseBean
     * @param @param model
     * @param @return    设定文件 
     * @return List<LineDetailBean>    返回类型 
     * @throws
     */
    public List<ZySystemUserBean> selectPage(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("zysystemuser.selectPage", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
     * @Title: updatePsd 
     * @Description: 根据用户ID修改密码
     * @param @param zySystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void updatePsd(ZySystemUserBean zySystemUserBean){
    	this.getSqlSession().update("zysystemuser.updatePsd", zySystemUserBean);
    }
}