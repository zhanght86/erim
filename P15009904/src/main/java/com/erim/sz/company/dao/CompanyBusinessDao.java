package com.erim.sz.company.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CompanyBusinessBean;

/**
 * @类名: CompanyBusinessDao
 * @描述: 公司业务范围信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月27日 下午7:49:18
 */
@Repository("companyBusinessDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CompanyBusinessDao extends BaseDao {

	/**
	 * @方法名: insertBusinewss
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月27日 下午7:49:08 
	 * @param bean
	 * @return
	 */
	public Integer insertBusiness(CompanyBusinessBean bean) {
		return getSqlSession().insert("companybusiness.insertBusiness", bean);
	}
	
	/**
	 * @方法名: updateBusiness
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月28日 下午6:14:56 
	 * @param bean
	 * @return
	 */
	public Integer updateBusiness(CompanyBusinessBean bean) {
		return getSqlSession().update("companybusiness.updateBusiness", bean);
	}
	
	/**
	 * @方法名: getBusinessById
	 * @描述: 根据公司ID获取一条业务范围信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月28日 下午6:18:01 
	 * @param id
	 * @return
	 */
	public CompanyBusinessBean getBusinessById(Integer id) {
		CompanyBusinessBean bean = getSqlSession().selectOne("companybusiness.getBusinessById", id);
		return bean;
	}
	
	/**
	 * @描述: 根据企业ID删除公司业务范围信息
	 * @作者: 宁晓强
	 * @创建时间: 2016年1月5日 下午2:03:11
	 * @param bean
	 * @return
	 */
	public Integer deleteBusinessByCpyId(CompanyBusinessBean bean) {
		return getSqlSession().delete("companybusiness.deleteBusinessByCpyId", bean);
	}
}
