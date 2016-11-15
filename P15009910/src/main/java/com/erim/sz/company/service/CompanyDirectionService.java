package com.erim.sz.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.CompanyDirectionBean;
import com.erim.sz.company.dao.CompanyDirectionDao;

/**
 * @ClassName: CompanyDirectionService 
 * @Description: 公司服务区域
 * @author maoxian
 * @date 2015年8月29日 下午5:20:18
 */
@Service("companyDirectionService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CompanyDirectionService {

	@Autowired
	private CompanyDirectionDao companyDirectionDao;
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入合作方向
	 * @param @param companyDirectionBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insert(CompanyDirectionBean companyDirectionBean){
		this.companyDirectionDao.insert(companyDirectionBean);
	}
}
