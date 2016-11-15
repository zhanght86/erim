package com.erim.sz.texi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TexiCarPriceBean;

/**
 * 
 * @类名: TexiCarPriceDao
 * @描述: 租车管理包车量价管理信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月15日 下午2:05:59
 *
 */
@Repository("texiCarPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TexiCarPriceDao extends BaseDao {

	/**
	 * 
	 * @方法名: selectCarPriceList
	 * @描述: 租车管理包车量价管理数据列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午2:12:24 
	 * @param bean
	 * @param count
	 * @return
	 *
	 */
	public List<TexiCarPriceBean> selectCarPriceList(TexiCarPriceBean bean, String[] count) {
		
		List<TexiCarPriceBean> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("monthCount", count);
		map.put("bean", bean);
		
		try {
			list = getSqlSession().selectList("carPrice.selectCarPriceList", map);
		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		return list;
	}
	
	/**
	 * 
	 * @方法名: insertCarPrice
	 * @描述: 新增量价管理
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午2:13:33 
	 * @param bean
	 * @return
	 *
	 */
	public Integer insertCarPrice(TexiCarPriceBean bean) {
		return getSqlSession().insert("carPrice.insert", bean);
	}
	
	/**
	 * 
	 * @方法名: updateCarPrice
	 * @描述: 修改量价管理
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午2:14:23 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateCarPrice(TexiCarPriceBean bean) {
		return getSqlSession().update("carPrice.updatePrice", bean);
	}
	
	/**
	 * 
	 * @方法名: updateIsOpen
	 * @描述: 修改上架状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午2:15:12 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateIsOpen(TexiCarPriceBean bean) {
		return getSqlSession().update("carPrice.updateIsOpen", bean);
	}
	
	/**
	 * 
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午2:18:10 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateBatchIsOpen(TexiCarPriceBean bean) {
		return getSqlSession().update("carPrice.updateBatchOpen", bean);
	}
}
