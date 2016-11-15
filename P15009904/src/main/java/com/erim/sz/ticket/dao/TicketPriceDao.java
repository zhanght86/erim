package com.erim.sz.ticket.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TicketPriceBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @类名: TicketPriceDao
 * @描述: 门票量价管理信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月17日 上午10:47:23
 *
 */
@Repository("ticketPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TicketPriceDao extends BaseDao{

	/**
	 * 
	 * @方法名: selectTicketPriceList
	 * @描述: 查询数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 上午10:52:35 
	 * @param bean
	 * @param count
	 * @return
	 *
	 */
	public List<TicketPriceBean> selectTicketPriceList(TicketPriceBean bean, String[] count) {
		List<TicketPriceBean> list = new ArrayList<TicketPriceBean>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
		
		try {
			list = getSqlSession().selectList("ticketprice.selectTicketPriceList", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * @方法名: insertTicketPrice
	 * @描述: 新增量价管理
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 上午11:00:13 
	 * @param bean
	 * @return
	 *
	 */
	public Integer insertTicketPrice(TicketPriceBean bean) {
		return getSqlSession().insert("ticketprice.insert", bean);
	}
	
	/**
	 * @描述: 保存量价信息 - 修改(逻辑上是新增，实际为修改)
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月19日 下午4:47:48
	 * @param bean
	 * @return
	 */
	public Integer update(TicketPriceBean bean) {
		return getSqlSession().update("ticketprice.updatePrice", bean);
	}
	
	/**
	 * 
	 * @方法名: updateTicketPrice
	 * @描述: 修改量价管理
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 上午11:00:52 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateTicketPrice(TicketPriceBean bean) {
		return getSqlSession().update("ticketprice.update", bean);
	}
	
	/**
	 * 
	 * @方法名: updateIsOpen
	 * @描述: 更新是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 上午11:03:05 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateIsOpen(TicketPriceBean bean) {
		return getSqlSession().update("ticketprice.updateIsOpen", bean);
	}
	
	/**
	 * 
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量更新是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 上午11:06:22 
	 * @param bean
	 * @param count
	 * @return
	 *
	 */
	public Integer updateBatchIsOpen(TicketPriceBean bean, String[] count) {
		
		Integer result = CommonUtil.ERROR;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("bean", bean);
		// 执行更改
		result = getSqlSession().update("ticketprice.updateBatchIsOpen", map);
		return result;
	}
	
	/**
	 * @描述: 根据票类ID和录入时间 获取最新的一条信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月19日 下午4:37:42
	 * @param bean
	 * @return
	 */
	public TicketPriceBean getPriceByClassDate(TicketPriceBean bean) {
		return getSqlSession().selectOne("ticketprice.getPriceByClassDate", bean);
	}
}
