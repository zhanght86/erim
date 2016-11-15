package com.erim.sz.company.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CompanyDirectionBean;

/**
 * @ClassName: CompanyDirectionDao 
 * @Description: 公司服务区域
 * @author maoxian
 * @date 2015年8月29日 下午5:18:27
 */
@Repository("companyDirectionDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CompanyDirectionDao extends BaseDao {

	/**
	 * @Title: insert 
	 * @Description: 插入方法
	 * @param @param companyDirectionBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insert(CompanyDirectionBean companyDirectionBean){
		this.getSqlSession().insert("companydirection.insert",companyDirectionBean);
	}
}
