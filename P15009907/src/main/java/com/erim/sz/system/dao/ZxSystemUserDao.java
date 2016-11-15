/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserDao.java : 2013-06-30
 */
package com.erim.sz.system.dao;

import java.util.List;


import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.system.bean.ZxSystemUserBean;

/**
 * 
 * @ClassName: CmsSystemUserDao 
 * @Description: 商户用户
 * @author maoxian
 * @date 2015年8月1日 上午11:21:59
 */
@Repository("zxSystemUserDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ZxSystemUserDao extends BaseDao {

	
	/**
	 * @Title: updateLogin 
	 * @Description: 修改专线登陆
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月2日 下午8:17:57 
	 * @throws
	 */
	public Integer updateLogin(ZxSystemUserBean bean){
		return this.getSqlSession().update("zxsystemuser.updateLogin", bean);
	}
	
	/**
	 * @Title: selectUserById 
	 * @Description: 根据ID查询
	 * @param @param id
	 * @param @return    设定文件 
	 * @return ZxSystemUserBean    返回类型 
	 * @throws
	 */
	public ZxSystemUserBean selectUserById(Integer id){
		return this.getSqlSession().selectOne("zxsystemuser.selectUserById", id);
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改方法 
	 * @param @param zxSystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(ZxSystemUserBean zxSystemUserBean){
		this.getSqlSession().update("zxsystemuser.update", zxSystemUserBean);
	}
	/**
	 * 
	 * @Title: selectUserByLoginname 
	 * @Description: 根据用户登录名获取用户信息
	 * @param @param loginName
	 * @param @return    设定文件 
	 * @return CmsSystemUserBean    返回类型 
	 * @throws
	 */
    public ZxSystemUserBean selectUserByLoginname(String zxUserLoginname){
    	 return getSqlSession().selectOne("zxsystemuser.selectUserByLoginname", zxUserLoginname);
    }

    /**
     * 
     * @Title: insert 
     * @Description: 插入 
     * @param @param zxSystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void insert(ZxSystemUserBean zxSystemUserBean){
    	this.getSqlSession().insert("zxsystemuser.insert", zxSystemUserBean);
    }
    
    /**
     * @描述: 根据公司ID删除用户信息
     * @作者: 宁晓强
     * @创建时间: 2016年1月5日 下午3:32:07
     * @param bean
     * @return
     */
    public Integer deleteUserByCpyId(ZxSystemUserBean bean) {
    	return getSqlSession().delete("zxsystemuser.deleteUserByCpyId", bean);
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
    public List<ZxSystemUserBean> selectPage(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("zxsystemuser.selectPage", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
     * @Title: updatePsd 
     * @Description: 根据用户ID修改密码
     * @param @param zxSystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void updatePsd(ZxSystemUserBean zxSystemUserBean){
    	this.getSqlSession().update("zxsystemuser.updatePsd", zxSystemUserBean);
    }

    /**
	 * @Title: delete 
	 * @Description: 删除
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer delete(ZxSystemUserBean zxSystemUserBean){
		return this.getSqlSession().delete("zxsystemuser.delete", zxSystemUserBean);
	}
}