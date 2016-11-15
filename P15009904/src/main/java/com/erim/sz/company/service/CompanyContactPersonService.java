package com.erim.sz.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.CompanyContactPersonBean;
import com.erim.sz.company.dao.CompanyContactPersonDao;

/**
 * @ClassName: CompanyContactPersonService
 * @Description: 公司联系人
 * @Author: 宁晓强
 * @Date: 2015年10月1日 下午4:05:24
 */
@Service("companyContactPersonService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CompanyContactPersonService {

	@Autowired
	private CompanyContactPersonDao companyContactPersonDao;
	
	/**
	 * @Title: insert
	 * @Description: 插入公司联系人
	 * @param companyContactPersonBean
	 */
	public Integer insert(CompanyContactPersonBean companyContactPersonBean){
		return companyContactPersonDao.insert(companyContactPersonBean);
	}
	
	/**
	 * @方法名: update
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月28日 下午4:36:19 
	 * @param bean
	 * @return
	 */
	public Integer update(CompanyContactPersonBean bean) {
		return companyContactPersonDao.update(bean);
	}
	
	/**
	 * @方法名: getPersonById
	 * @描述: 根据ID获取一条信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月29日 上午9:40:28 
	 * @param bean
	 * @return
	 */
	public CompanyContactPersonBean getPersonById(CompanyContactPersonBean bean) {
		return companyContactPersonDao.getPersonById(bean.getCpyId());
	}
}
