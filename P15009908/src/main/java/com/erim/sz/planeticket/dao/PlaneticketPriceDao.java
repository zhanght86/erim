package com.erim.sz.planeticket.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PlaneticketPriceBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @描述: 飞机票量价信息实体操作数据层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月8日 下午3:47:27
 */
@Repository("planeticketPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PlaneticketPriceDao extends BaseDao {

	/**
	 * @描述: 查询数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午4:33:42
	 * @param bean
	 * @param count
	 * @return
	 */
	public List<PlaneticketPriceBean> selectPlaneticketPriceList(PlaneticketPriceBean bean, String[] count) {
		
		List<PlaneticketPriceBean> list = new ArrayList<PlaneticketPriceBean>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("monthCount", count);
		map.put("bean", bean);
		
		list = getSqlSession().selectList("planeticketPrice.selectPriceList", map);
		return list;
	}
	
	/**
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午4:34:53
	 * @param bean
	 * @return
	 */
	public Integer insertPrice(PlaneticketPriceBean bean) {
		return getSqlSession().insert("planeticketPrice.insert", bean);
	}
	
	/**
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午4:35:41
	 * @param bean
	 * @return
	 */
	public Integer updatePrice(PlaneticketPriceBean bean) {
		return getSqlSession().update("planeticketPrice.updatePrice", bean);
	}
	
	/**
	 * @描述: 修改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午4:37:33
	 * @param bean
	 * @return
	 */
	public Integer updateIsOpen(PlaneticketPriceBean bean) {
		return getSqlSession().update("planeticketPrice.updateIsOpen", bean);
	}
	
	/**
	 * @描述: 批量更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午4:39:40
	 * @param bean
	 * @param count
	 * @return
	 */
	public Integer updateBatchIsOpen(PlaneticketPriceBean bean, String[] count) {
		Integer result = CommonUtil.ERROR;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
		
		result = getSqlSession().update("planeticketPrice.updateBatchIsOpen", map);
		return result;
	}
}
