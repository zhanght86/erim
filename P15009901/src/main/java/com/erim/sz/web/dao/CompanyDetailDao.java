package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CompanyDetailBean;

/**
 * 
 * @ClassName: CompanyDetailDao 
 * @Description: 企业
 * @author maoxian
 * @date 2015年11月15日 上午11:23:01 
 *
 */
@Repository("companyDetailDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CompanyDetailDao extends BaseDao {

	/**
	 * @Title: totalSell 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
    public List<CompanyDetailBean> selectAll(){
    	return this.getSqlSession().selectList("companydetail.selectAll");
    }
    
    /**
     * @Title: selectOneByCode 
     * @Description: 根据企业编码查询企业id
     * @param @param code
     * @param @return    设定文件 
     * @return CompanyDetailBean    返回类型 
     * @throws
     */
    public CompanyDetailBean selectOneByCode(String code){
    	return this.getSqlSession().selectOne("companydetail.selectOneByCode", code);
    }
    
    /**
     * 根据企业查询id
     * @param id
     * @return
     */
    public CompanyDetailBean selectByPriId(Integer id){
    	return this.getSqlSession().selectOne("companydetail.selectByPriId", id);
    }
}
