package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaCuisineBean;

/**
 * 
 * @类名: CarteriaCuisineDao
 * @描述: 餐厅特色菜
 * @作者: 王赛
 * @创建时间: 2015年11月24日 下午6:05:52
 *
 */
@Repository("carteriacuisineDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CarteriaCuisineDao extends BaseDao {

	/**
	 * 
	 * @方法名: selectList
	 * @描述: 餐厅特色菜
	 * @作者: 王赛
	 * @创建时间: 2015年11月24日 下午5:03:43 
	 * @param parkBean
	 * @return
	 *
	 */
	public List<CafeteriaCuisineBean> selectList(CafeteriaCuisineBean Bean){
		return this.getSqlSession().selectList("CafeteriaCuisine.selectList", Bean);
	}
}
