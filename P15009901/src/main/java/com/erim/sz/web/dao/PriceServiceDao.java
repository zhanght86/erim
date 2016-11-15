package com.erim.sz.web.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PriceServiceBean;

/**
 * 服务费
 * @author maoxian
 */
@Repository("priceServiceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PriceServiceDao extends BaseDao{
	
	/**
	 * 修改方法
	 * @param bean
	 */
	public void update(PriceServiceBean bean){
		this.getSqlSession().update("priceservice.update", bean);
	}
	
	/**
	 * 根据编码查询服务器
	 * @param pseNo
	 * @return
	 */
	public PriceServiceBean findPriceBeanByPseNo(String pseNo){
		return this.getSqlSession().selectOne("priceservice.findPriceBeanByPseNo", pseNo);
	}
}
