package com.erim.sz.mall.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.MallWebBean;

/**
 * 
 * @ClassName: MallWebDao
 * @Description: 热门精选
 * @author maoxian
 * @date 2015年11月12日 上午2:17:19
 *
 */
@Repository("mallWebDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MallWebDao extends BaseDao {

	/**
	 * @Title: insert @Description: 插入 @param @param bean @param @return
	 * 设定文件 @return Integer 返回类型 @throws
	 */
	public Integer insert(MallWebBean bean) {
		return this.getSqlSession().insert("mallweb.insert", bean);
	}

	/**
	 * @Title: update 
	 * @Description: 修改
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer update(MallWebBean bean){
		return this.getSqlSession().update("mallweb.update", bean);
	}
	
	/**
	 * @Title: findId 
	 * @Description: 根据id 检索
	 * @param @param id
	 * @param @return    设定文件 
	 * @return MallWebBean    返回类型 
	 * @throws
	 */
	public MallWebBean findId(Integer cpyId){
		return this.getSqlSession().selectOne("mallweb.findId", cpyId);
	}
}
