package com.erim.sz.company.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CompanyContactPersonBean;

/**
 * @ClassName: CompanyContactPersonDao 
 * @Description: 公司联系人
 * @author maoxian
 * @date 2015年8月28日 下午1:47:43 
 *
 */
@Repository("companyContactPersonDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CompanyContactPersonDao extends BaseDao{

	/**
	 * @Title: insert 
	 * @Description: 插入公司联系人
	 * @param @param companyContactPersonBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public Integer insert(CompanyContactPersonBean companyContactPersonBean){
		return getSqlSession().insert("companycontact.insert", companyContactPersonBean);
	}
	
	/**
	 * 
	 * @方法名: update
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:56:55 
	 * @param bean
	 * @return
	 *
	 */
	public Integer update(CompanyContactPersonBean bean) {
		return getSqlSession().update("companycontact.update", bean);
	}
	
	/**
	 * @方法名: getPersonById
	 * @描述: 根据ID查询一条信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:58:31 
	 * @param cpyId
	 * @return
	 */
	public CompanyContactPersonBean getPersonById(Integer cpyId) {
		return getSqlSession().selectOne("companycontact.getPersonById", cpyId);
	}
}
