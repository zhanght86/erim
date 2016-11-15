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
 * @类名: GuidePriceDao
 * @描述: 导游量价信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年12月22日 下午4:00:18
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuidePriceDao extends BaseDao {

	/**
	 * @描述: 获取导游量价信息数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月22日 下午4:00:39
	 * @param bean
	 * @param count
	 * @return
	 */
	public List<GuidePriceBean> selectGuidePriceList(GuidePriceBean bean, String[] count) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
		
		return getSqlSession().selectList("guideprice.selectPriceList", map);
	}
	
	/**
	 * @描述: 根据量价ID更改导游档期
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 上午10:24:43
	 * @param bean
	 * @return
	 */
	public Integer updateIsOpen(GuidePriceBean bean) {
		return getSqlSession().update("guideprice.updateIsOpen", bean);
	}
	
	/**
	 * @描述: 根据导游ID和日期 批量更改导游档期
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 下午2:14:53
	 * @param bean
	 * @return
	 */
	public Integer updateBatchIsOpen(GuidePriceBean bean) {
		return getSqlSession().update("guideprice.updateBatchIsOpen", bean);
	}
}
