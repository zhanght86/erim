package com.erim.sz.search.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuidePriceBean;

/**
 * @ClassName: GuidePriceDao 
 * @Description: 导游量价查询
 * @author maoxian
 * @date 2015年12月20日 下午11:20:32
 */
@Repository("guidePriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuidePriceDao extends BaseDao {

	/**
	 * @Title: selectPriceList 
	 * @Description: 查询导游量价
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<GuidePriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 下午11:21:26 
	 * @throws
	 */
	public List<GuidePriceBean> selectPriceList(GuidePriceBean bean){
		return this.getSqlSession().selectList("guideprice.selectPriceList", bean);
	}
	
}
