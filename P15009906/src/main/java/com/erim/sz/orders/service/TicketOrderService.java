package com.erim.sz.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TicketOrderBean;
import com.erim.sz.orders.dao.TicketOrderDao;

/***
 * 
* @ClassName: TicketOrderService 
* @Description: 门票订单接口
* @author 龙龙
* @date 2015年7月30日 下午1:20:29 
*
 */
@Service("ticketOrderService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TicketOrderService {

	@Autowired
	private TicketOrderDao ticketOrderDao;

	public void showTicket(ModelMap model, TicketOrderBean bean) {

		bean.setN(10);
		// 分页查询
		List<TicketOrderBean> ticketList = ticketOrderDao.selectPageTicket(bean, model);

		// 回传信息
		model.put("ticketList", ticketList);
	}

	
}