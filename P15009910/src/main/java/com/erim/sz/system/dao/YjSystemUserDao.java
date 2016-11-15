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
import com.erim.sz.common.bean.YjSystemUserBean;

/**
 * 
 * @ClassName: CmsSystemUserDao 
 * @Description: 商户用户
 * @author maoxian
 * @date 2015年8月1日 上午11:21:59
 */
@Repository("yjSystemUserDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class YjSystemUserDao extends BaseDao {

	
	/**
	 * @Title: updateLogin 
	 * @Description: 更新最后登陆信息
	 * @param @param zxSystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月2日 下午11:33:01 
	 * @throws
	 */
	public void updateLogin(YjSystemUserBean zxSystemUserBean){
		this.getSqlSession().update("yjsystemuser.updateLogin", zxSystemUserBean);
	}
	
	/**
	 * @Title: selectUserById 
	 * @Description: 根据ID查询
	 * @param @param id
	 * @param @return    设定文件 
	 * @return YjSystemUserBean    返回类型 
	 * @throws
	 */
	public YjSystemUserBean selectUserById(Integer id){
		return this.getSqlSession().selectOne("yjsystemuser.selectUserById", id);
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改方法 
	 * @param @param yjSystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(YjSystemUserBean yjSystemUserBean){
		this.getSqlSession().update("yjsystemuser.update", yjSystemUserBean);
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
    public YjSystemUserBean selectUserByLoginname(String yjUserLoginname){
    	 return getSqlSession().selectOne("yjsystemuser.selectUserByLoginname", yjUserLoginname);
    }
    /**
     * @方法名：selectByOldPwd 
     * @描述: 根据原密码和用户名查询信息
     * @作者：  贺渊博
     * @创建时间：2015年11月12日 下午4:11:08
     * @param oldPwd
     * @param yjUserLoginname
     * @return
     *
     */
    public YjSystemUserBean selectByOldPwd(YjSystemUserBean bean){
    	return getSqlSession().selectOne("yjsystemuser.selectByOldPwd",bean);
    }
    /**
     * 
     * @Title: insert 
     * @Description: 插入 
     * @param @param yjSystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void insert(YjSystemUserBean yjSystemUserBean){
    	this.getSqlSession().insert("yjsystemuser.insert", yjSystemUserBean);
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
    public List<YjSystemUserBean> selectPage(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("yjsystemuser.selectPage", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
     * @Title: updatePsd 
     * @Description: 根据用户ID修改密码
     * @param @param yjSystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void updatePsd(YjSystemUserBean yjSystemUserBean){
    	this.getSqlSession().update("yjsystemuser.updatePsd", yjSystemUserBean);
    }
}