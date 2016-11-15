package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaPackageBean;

/**
 * 
 * @类名: CarteriaPackageDao
 * @描述: 餐厅套餐
 * @作者: 王赛
 * @创建时间: 2015年11月24日 下午5:37:31
 *
 */
@Repository("(CafeteriaPackageDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CarteriaPackageDao extends BaseDao {

	/**
	 * 
	 * @方法名: selectList
	 * @描述: 餐厅套餐
	 * @作者: 王赛
	 * @创建时间: 2015年11月24日 下午5:31:55 
	 * @param Bean
	 * @return
	 *
	 */
	public List<CafeteriaPackageBean> selectList(CafeteriaPackageBean PackageBean){
		return this.getSqlSession().selectList("CafeteriaPackage.selectList", PackageBean);
	}
	
}
