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

import com.erim.core.dao.BaseDao;
import com.erim.sz.system.bean.ZxSystemLogBean;

/**
 * 
 * @ClassName: ZxSystemLogDao 
 * @Description: 日志管理
 * @author maoxian
 * @date 2015年8月6日 下午7:54:49
 */
@Repository("zxSystemLogDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ZxSystemLogDao extends BaseDao {

	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入日志
	 * @param @param zxSystemLogBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insert(ZxSystemLogBean zxSystemLogBean){
		this.getSqlSession().insert("zxsystemlog.insert",zxSystemLogBean);
	}
	
	/**
	 * 
	 * @Title: selectByLogFuncCode 
	 * @Description: 根据日志父级类型查询日志结果
	 * @param @param logFuncCode
	 * @param @return    设定文件 
	 * @return List<ZxSystemLogBean>    返回类型 
	 * @throws
	 */
	public List<ZxSystemLogBean> selectPageByLogFuncCode(ZxSystemLogBean zxSystemLogBean,ModelMap model){
		return this.getSqlSession().selectList("zxsystemlog.selectPageByLogFuncCode", zxSystemLogBean,new RowBounds(zxSystemLogBean.getPageLinkBean().getStart(), zxSystemLogBean.getPageLinkBean().getLimit()));
	}
}