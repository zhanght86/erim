package com.erim.sz.price.dao;

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
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param service    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月5日 上午8:34:04 
	 * @throws
	 */
	public void insert(PriceServiceBean service){
		this.getSqlSession().insert("priceservice.insert", service);
	}
	
	/**
	 * 
	 * @Title: getServiceByCpyId 
	 * @Description: 根据企业id查询
	 * @param @param cpyId
	 * @param @return    设定文件 
	 * @return PriceServiceBean    返回类型 
	 * @author maoxian
	 * @date 2015年12月5日 下午4:49:57 
	 * @throws
	 */
	public PriceServiceBean getServiceByCpyId(Integer cpyId){
		return this.getSqlSession().selectOne("priceservice.getServiceByCpyId", cpyId);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改方法
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月29日 下午3:25:44 
	 * @throws
	 */
	public void update(PriceServiceBean bean){
		this.getSqlSession().update("priceservice.update", bean);
	}
}
