package com.erim.sz.company.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CompanyContactPersonBean;

/**
 * 
 * @ClassName: CompanyContactPersonDao
 * @Description: 公司联系人
 * @Author: 宁晓强
 * @Date: 2015年10月1日 下午4:06:58
 *
 */
@Repository("companyContactPersonDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CompanyContactPersonDao extends BaseDao {

	/**
	 * 
	 * @Title: insert
	 * @Description: 插入公司联系人
	 * @param companyContactPersonBean
	 *
	 */
	public Integer insert(CompanyContactPersonBean companyContactPersonBean){
		return getSqlSession().insert("companycontact.insert", companyContactPersonBean);
	}
	
	/**
	 * 
	 * @方法名: update
	 * @描述: 修改公司联系人
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月28日 下午4:35:55 
	 * @param bean
	 * @return
	 *
	 */
	public Integer update(CompanyContactPersonBean bean) {
		return getSqlSession().update("companycontact.update", bean);
	}
	
	/**
	 * @方法名: getPersonById
	 * @描述: 根据ID获取一条公司联系人信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月29日 上午9:33:44 
	 * @param cpyId
	 * @return
	 */
	public CompanyContactPersonBean getPersonById(Integer cpyId) {
		
		return getSqlSession().selectOne("companycontact.getPersonById", cpyId);
	}
}
