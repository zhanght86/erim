package com.erim.sz.web.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.VCompanyDetailBean;

/**
 * @ClassName: VCompanyDetailDao 
 * @Description: 企业信息
 * @author maoxian
 * @date 2016年1月4日 下午7:00:47
 */
@Repository("vcompanyDetailDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VCompanyDetailDao extends BaseDao {

	/**
	 * @Title: selectCompanyById 
	 * @Description: 根据id查询企业信息
	 * @param @param id
	 * @param @return    设定文件 
	 * @return VCompanyDetailBean    返回类型 
	 * @author maoxian
	 * @date 2016年1月4日 下午7:02:16 
	 * @throws
	 */
	public VCompanyDetailBean selectCompanyByCode(String cpyCode){
		return this.getSqlSession().selectOne("vcompanydetail.selectCompanyByCode", cpyCode);
	}
}
