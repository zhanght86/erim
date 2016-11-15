package com.erim.sz.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelPriceBean;

/**
 * @描述: 酒店量价信息实体操作数据层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月26日 下午4:53:46
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelPriceDao extends BaseDao {

	/**
	 * @描述: 量价管理数据查询
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月26日 下午4:57:28
	 * @param bean
	 * @param monthCount
	 * @return
	 */
	public List<HotelPriceBean> getHotelPriceList(HotelPriceBean bean, String[] monthCount) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("monthCount", monthCount);
		map.put("bean", bean);
		
		return getSqlSession().selectList("hotelprice.selectPriceList", map);
	}
}
