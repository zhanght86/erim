package com.erim.sz.search.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GroundPriceBean;

/**
 * @ClassName: GroundPriceDao 
 * @Description: 当地游价格
 * @author maoxian
 * @date 2015年12月25日 上午12:21:11
 */
@Repository("groundPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GroundPriceDao extends BaseDao{

	/**
	 * @Title: selectPriceList 
	 * @Description: 当地游价格
	 * @param @param priceBean
	 * @param @return    设定文件 
	 * @return List<GroundPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 上午12:22:10 
	 * @throws
	 */
	public List<GroundPriceBean> selectPriceList(GroundPriceBean price){
		return this.getSqlSession().selectList("groundprice.selectPriceList", price);
	}
}
