package com.erim.sz.web.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MallUsersBean;

/**
 * @ClassName: TexiDetailDao
 * @Description: 租车详情
 * @author maoxian
 * @date 2015年9月12日 下午5:31:37
 *
 */
@Repository("mallUserDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MallUsersDao extends BaseDao {

	/**
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param userBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(MallUsersBean userBean){
		return this.getSqlSession().insert("malluser.insert", userBean);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改
	 * @param @param usersBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer update(MallUsersBean usersBean){
		return this.getSqlSession().update("malluser.update", usersBean);
	}
	
	/**
	 * @Title: selectByLogin 
	 * @Description: 根据帐号密码登录
	 * @param @param usersBean
	 * @param @return    设定文件 
	 * @return MallUsersBean    返回类型 
	 * @throws
	 */
	public MallUsersBean selectByLogin(MallUsersBean usersBean){
		return this.getSqlSession().selectOne("malluser.selectByLogin", usersBean);
	}
}
