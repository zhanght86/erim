package com.erim.sz.company.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CompanyBusinessBean;

/**
 * 
 * @类名: CompanyBusinessDao
 * @描述: 公司业务范围信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年11月4日 下午2:07:39
 *
 */
@Repository("companyBusinessDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CompanyBusinessDao extends BaseDao {

	/**
	 * 
	 * @方法名: insert
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:04:01 
	 * @param bean
	 * @return
	 *
	 */
	public Integer insert(CompanyBusinessBean bean) {
		return getSqlSession().insert("companybusiness.insertBusiness", bean);
	}
	
	/**
	 * 
	 * @方法名: update
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:15:10 
	 * @param bean
	 * @return
	 *
	 */
	public Integer update(CompanyBusinessBean bean) {
		return getSqlSession().update("companybusiness.update", bean);
	}
	
	/**
	 * 
	 * @方法名: getBusinessById
	 * @描述: 根据ID获取一条公司业务范围信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:16:16 
	 * @param id
	 * @return
	 *
	 */
	public CompanyBusinessBean getBusinessById(Integer id) {
		return getSqlSession().selectOne("companybusiness.getBusinessById", id);
	}
	
	
	/**
	 * @Title: getBusinessByCpyId 
	 * @Description: 根据企业id 查询业务范围
	 * @param @param cpyid
	 * @param @return    设定文件 
	 * @return CompanyBusinessBean    返回类型 
	 * @author maoxian
	 * @date 2015年12月9日 上午1:18:01 
	 * @throws
	 */
	public CompanyBusinessBean getBusinessByCpyId(Integer cpyid) {
		return getSqlSession().selectOne("companybusiness.getBusinessByCpyId", cpyid);
	}
}
