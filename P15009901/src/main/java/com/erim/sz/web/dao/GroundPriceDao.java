package com.erim.sz.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GroundPriceBean;

/**
 * @描述: 当地游量价信息实体操作数据层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月28日 下午1:38:08
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GroundPriceDao extends BaseDao {

	/**
	 * @描述: 量价列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月28日 下午1:40:16
	 * @param bean
	 * @return
	 */
	public List<GroundPriceBean> getGroundPriceList(GroundPriceBean bean, String[] count) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
		
		return getSqlSession().selectList("groundprice.selectPriceList", map);
	}
}
