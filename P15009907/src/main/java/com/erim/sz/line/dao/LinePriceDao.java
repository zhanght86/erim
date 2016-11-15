package com.erim.sz.line.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.LinePriceBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @描述: 专线量价管理信息实体操作数据层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月5日 下午8:17:14
 */
@Repository("linePriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LinePriceDao extends BaseDao {

	/**
	 * @描述: 查询数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:20:56
	 * @param bean
	 * @param count
	 * @return
	 */
	public List<LinePriceBean> selectLinePriceList(LinePriceBean bean, String[] count) {
		List<LinePriceBean> list=  new ArrayList<LinePriceBean>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
		
		list = getSqlSession().selectList("lineprice.selectPriceList", map);
		
		return list;
	}
	
	/**
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:23:18
	 * @param bean
	 * @return
	 */
	public Integer insertPrice(LinePriceBean bean) {
		return getSqlSession().insert("lineprice.insert", bean);
	}
	
	/**
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:24:02
	 * @param bean
	 * @return
	 */
	public Integer updatePrice(LinePriceBean bean) {
		return getSqlSession().update("lineprice.update", bean);
	}
	
	/**
	 * @描述: 修改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:25:01
	 * @param bean
	 * @return
	 */
	public Integer updateIsOpen(LinePriceBean bean) {
		return getSqlSession().update("lineprice.updateIsOpen", bean);
	}
	
	/**
	 * @描述: 批量更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:27:13
	 * @param bean
	 * @param count
	 * @return
	 */
	public Integer updateBatchIsOpen(LinePriceBean bean, String[] count) {
		Integer result = CommonUtil.ERROR;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
		result = getSqlSession().update("lineprice.updateBatchIsOpen", map);
		return result;
	}
}
