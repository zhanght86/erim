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
import com.erim.sz.system.bean.SellSystemUserBean;

/**
 * @ClassName: CmsSystemUserDao 
 * @Description: 商户用户
 * @author maoxian
 * @date 2015年8月1日 上午11:21:59
 */
@Repository("sellSystemUserDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SellSystemUserDao extends BaseDao {

	/**
	 * @Title: updateLogin 
	 * @Description: 更新最后登陆信息
	 * @param @param zxSystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月2日 下午11:33:01 
	 * @throws
	 */
	public void updateLogin(SellSystemUserBean zxSystemUserBean){
		this.getSqlSession().update("sellsystemuser.updateLogin", zxSystemUserBean);
	}
	
	/**
	 * @Title: selectUserById 
	 * @Description: 根据ID查询
	 * @param @param id
	 * @param @return    设定文件 
	 * @return SellSystemUserBean    返回类型 
	 * @throws
	 */
	public SellSystemUserBean selectUserById(Integer id){
		return this.getSqlSession().selectOne("sellsystemuser.selectUserById", id);
	}
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改方法 
	 * @param @param sellSystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(SellSystemUserBean sellSystemUserBean){
		this.getSqlSession().update("sellsystemuser.update", sellSystemUserBean);
	}
	
	/**
	 * @Title: selectUserByLoginname 
	 * @Description: 根据用户登录名获取用户信息
	 * @param @param loginName
	 * @param @return    设定文件 
	 * @return CmsSystemUserBean    返回类型 
	 * @throws
	 */
    public SellSystemUserBean selectUserByLoginname(String sellUserLoginname){
    	 return getSqlSession().selectOne("sellsystemuser.selectUserByLoginname", sellUserLoginname);
    }
    
    /**
     * @方法名：selectByOldPwd 
     * @描述: 根据原密码和用户名查询信息
     * @作者：  贺渊博
     * @创建时间：2015年11月12日 下午4:11:08
     * @param oldPwd
     * @param sellUserLoginname
     * @return
     */
    public SellSystemUserBean selectByOldPwd(SellSystemUserBean bean){
    	return getSqlSession().selectOne("sellsystemuser.selectByOldPwd",bean);
    }
    
    /**
     * @Title: insert 
     * @Description: 插入 
     * @param @param sellSystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void insert(SellSystemUserBean sellSystemUserBean){
    	this.getSqlSession().insert("sellsystemuser.insert", sellSystemUserBean);
    }
    
    /**
     * @描述: 根据公司ID删除用户信息
     * @作者: 宁晓强
     * @创建时间: 2016年1月5日 下午2:56:33
     * @param bean
     * @return
     */
    public Integer deleteUserByCpyId(SellSystemUserBean bean) {
    	return getSqlSession().delete("sellsystemuser.deleteUserByCpyId", bean);
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
    public List<SellSystemUserBean> selectPage(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("sellsystemuser.selectPage", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
     * @Title: updatePsd 
     * @Description: 根据用户ID修改密码
     * @param @param sellSystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void updatePsd(SellSystemUserBean sellSystemUserBean){
    	this.getSqlSession().update("sellsystemuser.updatePsd", sellSystemUserBean);
    }
    /**
     * @描述:  是否停用
     * @作者: （heyuanbo）
     * @创建时间: 2015年12月30日 下午7:56:29
     * @param sellSystemUserBean
     * @return 返回类型 Integer
     */
    public Integer delete(SellSystemUserBean sellSystemUserBean){
    	return this.getSqlSession().delete("sellsystemuser.delete",sellSystemUserBean);
    }
    
    
}