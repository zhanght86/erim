package com.erim.sz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.web.dao.VCompanyDetailDao;

/**
 * @ClassName: VCompanyDetailService 
 * @Description: 企业相关
 * @author maoxian
 * @date 2015年12月6日 下午11:46:10
 */
@Service("vCompanyDetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class VCompanyDetailService {

	@Autowired
	private VCompanyDetailDao vCompanyDetailDao;
	
	/**
	 * @Title: selectCompanyById 
	 * @Description: 根据id查询企业信息 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return VCompanyDetailBean    返回类型 
	 * @author maoxian
	 * @date 2016年1月4日 下午7:03:26 
	 * @throws
	 */
	public VCompanyDetailBean selectCompanyByCode(String cpyCode){
		return this.vCompanyDetailDao.selectCompanyByCode(cpyCode);
	}
}
