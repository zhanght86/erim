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
 * @author maoxian
 * @date 2015年8月28日 下午1:50:00 
 *
 */
@Service("companyContactPersonService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CompanyContactPersonService {
	
	@Autowired
	private CompanyContactPersonDao companyContactPersonDao;

	/**
	 * @Title: insert 
	 * @Description: 插入公司联系人
	 * @param @param companyContactPersonBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insert(CompanyContactPersonBean companyContactPersonBean){
		this.companyContactPersonDao.insert(companyContactPersonBean);
	}
	
	/**
	 * 
	 * @方法名: update
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:58:59 
	 * @param bean
	 * @return
	 *
	 */
	public Integer update(CompanyContactPersonBean bean) {
		return companyContactPersonDao.update(bean);
	}

	
	/**
	 * @方法名: getPersonById
	 * @描述: 根据ID查询
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:59:13 
	 * @param bean
	 * @return
	 */
	public CompanyContactPersonBean getPersonById(CompanyContactPersonBean bean) {
		CompanyContactPersonBean model = new CompanyContactPersonBean();
		model = companyContactPersonDao.getPersonById(bean.getCpyId());
		return model;
	}
}
