package com.erim.sz.search.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.ManagementPriceBean;

/**
 * @ClassName: ManagementPriceDao 
 * @Description: 签证查询量价
 * @author maoxian
 * @date 2015年12月24日 下午9:52:23
 */
@Repository("managementPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ManagementPriceDao extends BaseDao {

	/**
	 * @Title: listManagementPrice 
	 * @Description:量价查询
	 * @param @param priceBean
	 * @param @return    设定文件 
	 * @return List<ManagementPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月24日 下午9:53:05 
	 * @throws
	 */
	public List<ManagementPriceBean> selectPriceList(ManagementPriceBean priceBean){
		return this.getSqlSession().selectList("managementprice.listManagementPrice", priceBean);
	}
	
}
