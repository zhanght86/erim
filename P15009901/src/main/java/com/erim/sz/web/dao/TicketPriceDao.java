package com.erim.sz.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TicketPriceBean;

/**
 * @描述: 门票量价信息实体操作数据层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月27日 下午3:45:57
 */
@Repository("ticketPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TicketPriceDao extends BaseDao {

	/**
	 * @描述: 查询数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午3:57:47
	 * @param bean
	 * @param count
	 * @return
	 */
	public List<TicketPriceBean> selectProceList(TicketPriceBean bean, String[] count) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
		
		return getSqlSession().selectList("ticketprice.selectTicketPriceList", map);
	}
	
	public TicketPriceBean getPriceBeanById(Integer id) {
		
		return getSqlSession().selectOne("ticketprice.selectById", id);
	}
}
