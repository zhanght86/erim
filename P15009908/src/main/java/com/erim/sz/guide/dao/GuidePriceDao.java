package com.erim.sz.guide.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GuidePriceBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @类名: GuidePriceDao
 * @描述: 导游管理信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月20日 下午3:04:21
 */
@Repository("guidePriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GuidePriceDao extends BaseDao {

	/**
	 * @方法名: selectCafeteriaPriceList
	 * @描述: 查询数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午3:22:54 
	 * @param bean
	 * @param count
	 * @return
	 */
	public List<GuidePriceBean> selectGuidePriceList(GuidePriceBean bean, String[] count) {
		List<GuidePriceBean> list = new ArrayList<GuidePriceBean>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
		
		try {
			list = getSqlSession().selectList("guideprice.selectPriceList", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 
	 * @方法名: insertPrice
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午3:23:20 
	 * @param bean
	 * @return
	 *
	 */
	public Integer insertPrice(GuidePriceBean bean) {
		return getSqlSession().insert("guideprice.insert", bean);
	}
	
	/**
	 * 
	 * @方法名: updatePrice
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午3:23:40 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updatePrice(GuidePriceBean bean) {
		return getSqlSession().update("guideprice.update", bean);
	}
	
	/**
	 * 
	 * @方法名: updateIsOpen
	 * @描述: 更改是否领队状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午3:24:02 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateIsOpen(GuidePriceBean bean) {
		return getSqlSession().update("guideprice.updateIsOpen", bean);
	}
	
	/**
	 * 
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量更改是否领队状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午3:24:40 
	 * @param bean
	 * @param count
	 * @return
	 *
	 */
	public Integer updateBatchIsOpen(GuidePriceBean bean, String[] count) {
		Integer result = CommonUtil.ERROR;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
		// 执行更改
		result = getSqlSession().update("guideprice.updateBatchIsOpen", map);
		return result;
	}
}
