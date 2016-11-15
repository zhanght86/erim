package com.erim.sz.management.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.ManagementPriceBean;

/**
 * @描述: 签证价格管理信息实体操作数据层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月7日 下午2:20:59
 */
@Repository("managementPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ManagementPriceDao extends BaseDao {

	/**
	 * @描述: 查询数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午2:26:20
	 * @param bean
	 * @param count
	 * @return
	 */
	public List<ManagementPriceBean> selectManagementPriceList(ManagementPriceBean bean, String[] count) {
		
		List<ManagementPriceBean> list = new ArrayList<ManagementPriceBean>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
		list = getSqlSession().selectList("managementprice.selectPriceList", map);
		return list;
	}
	
	/**
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午2:27:06
	 * @param bean
	 * @return
	 */
	public Integer insertPrice(ManagementPriceBean bean) {
		return getSqlSession().insert("managementprice.insert", bean);
	}
	
	/**
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午2:28:19
	 * @param bean
	 * @return
	 */
	public Integer updatePrice(ManagementPriceBean bean) {
		return getSqlSession().update("managementprice.update", bean);
	}
	
}
