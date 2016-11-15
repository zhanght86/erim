package com.erim.sz.aboutus.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.AboutUsBean;

/**
 * @类名: AboutUsDao
 * @描述: 关于我们信息实体操作数据层
 * @作者: 贺渊博
 * @创建时间: 2015年11月29日 下午5:42:39
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AboutUsDao extends BaseDao {
	
	/**
	 * @描述: 查询最新的一条关于我们信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月6日 下午3:05:13
	 * @param bean
	 * @return
	 */
	public AboutUsBean selectAboutUs(AboutUsBean bean) {
		return getSqlSession().selectOne("aboutus.selectAboutUs", bean);
	}
	
	/**
	 * @描述: 新增关于我们
	 * @作者: （heyuanbo）
	 * @创建时间: 2015年11月29日 下午5:51:29
	 * @param bean
	 * @return 返回类型 Integer
	 */
	public Integer insert(AboutUsBean bean){
		return getSqlSession().insert("aboutus.insert",bean);
		
	}
	
	/**
	 * @描述: 修改关于我们
	 * @作者: （heyuanbo）
	 * @创建时间: 2015年11月29日 下午5:52:51
	 * @param bean
	 * @return 返回类型 Integer
	 */
	public Integer update(AboutUsBean bean){
		return getSqlSession().update("aboutus.update",bean);
	}
}
