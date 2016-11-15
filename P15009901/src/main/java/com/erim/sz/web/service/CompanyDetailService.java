package com.erim.sz.web.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.CompanyDetailBean;
import com.erim.sz.web.dao.CompanyDetailDao;

/**
 * 
 * @ClassName: CompanyDetailService 
 * @Description: 所有企业
 * @author maoxian
 * @date 2015年11月15日 上午11:25:13 
 *
 */
@Service("companyDetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CompanyDetailService {

	@Autowired
	private CompanyDetailDao companyDetailDao;
	
	/**
	 * @Title: totalSell 
	 * @Description: 
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
    public List<CompanyDetailBean> selectAll(){
    	return this.companyDetailDao.selectAll();
    }
    
    /**
     * @Title: selectOneByCode 
     * @Description: 根据企业编码查询企业信息
     * @param @param code
     * @param @return    设定文件 
     * @return CompanyDetailBean    返回类型 
     * @throws
     */
    public CompanyDetailBean selectOneByCode(String code){
    	return this.companyDetailDao.selectOneByCode(code);
    }
    
    /**
     * @param id
     * @return
     */
    public CompanyDetailBean selectByPriId(Integer id){
    	return this.companyDetailDao.selectByPriId(id);
    }
    
    /**
     * 
     * @Title: getCpyId 
     * @Description: 根据企业编码返回公司id
     * @param @param code
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @throws
     */
    public Integer getCpyId(String code){
    	if(StringUtils.isNotBlank(code)){
    		//根据公司编码获取公司信息
			CompanyDetailBean companyBean = this.selectOneByCode(code);
			if(null != companyBean){
				return companyBean.getId();
			}
    	}
    	return 0;
    }
}