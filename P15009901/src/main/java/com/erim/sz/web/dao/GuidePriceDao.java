package com.erim.sz.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuidePriceBean;

/**
 * @描述: 导游导服费信息实体操作数据层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月12日 下午12:14:50
 */
@Repository("guidePriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuidePriceDao extends BaseDao {

	/**
	 * @描述: 查询导游导服费信息数据列表 
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月12日 下午12:17:22
	 * @param bean
	 * @return
	 */
	public List<GuidePriceBean> selectGuidePriceList(GuidePriceBean bean, String[] count) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("monthCount", count);
		map.put("bean", bean);
		return getSqlSession().selectList("guideprice.selectGuidePriceList", map);
	}
}
