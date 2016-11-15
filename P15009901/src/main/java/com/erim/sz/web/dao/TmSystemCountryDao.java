package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.web.bean.TmSystemCountryBean;

/**
 * @ClassName: TmSystemCountryDao 
 * @Description: 国家省市
 * @author maoxian
 * @date 2015年10月23日 下午1:04:54
 */
@Repository("tmSystemCountryDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TmSystemCountryDao extends BaseDao{
	

	/**
	 * @Title: selectAllCode 
	 * @Description: 查询所有国家地区
	 * @param @return    设定文件 
	 * @return List<TmSystemCountryBean>    返回类型 
	 * @throws
	 */
	public List<TmSystemCountryBean> selectAllCode(){
		return this.getSqlSession().selectList("tmsystemcountry.selectList");
	}
	
	/**
	 * 
	 * @Title: getSystemCountryById
	 * @Description: 根据主键ID获取一条信息
	 * @param id
	 * @return
	 *
	 */
	public TmSystemCountryBean getSystemCountryById(Integer countryId) {
		return this.getSqlSession().selectOne("tmsystemcountry.getSystemCountryById", countryId);
	}
}
