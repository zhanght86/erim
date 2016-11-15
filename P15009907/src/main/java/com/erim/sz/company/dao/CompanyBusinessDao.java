package com.erim.sz.company.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CompanyBusinessBean;

@Repository("companyBusinessDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CompanyBusinessDao extends BaseDao {

	/**
	 * @方法名: insert
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:04:01 
	 * @param bean
	 * @return
	 */
	public Integer insert(CompanyBusinessBean bean) {
		return getSqlSession().insert("companybusiness.insert", bean);
	}
	
	/**
	 * @方法名: update
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:15:10 
	 * @param bean
	 * @return
	 */
	public Integer update(CompanyBusinessBean bean) {
		return getSqlSession().update("companybusiness.update", bean);
	}
	
	/**
	 * @方法名: getBusinessById
	 * @描述: 根据ID获取一条公司业务范围信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:16:16 
	 * @param id
	 * @return
	 */
	public CompanyBusinessBean getBusinessById(Integer cpyId) {
		return getSqlSession().selectOne("companybusiness.getBusinessById", cpyId);
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
