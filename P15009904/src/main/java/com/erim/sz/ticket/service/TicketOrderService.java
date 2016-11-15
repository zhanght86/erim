package com.erim.sz.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TicketOrderBean;
import com.erim.sz.ticket.dao.TicketOrderDao;

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

	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public int insert(ModelMap model, TicketOrderBean bean) {

		// 插入数据
		return ticketOrderDao.insertTicket(bean);
	}

	/**
	 * @return 
	 * 
	 * @Title: update 
	 * @Description: 修改
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public int update(ModelMap model, TicketOrderBean bean) {
		return ticketOrderDao.updateTicket(bean);
		 
	}
	
	/**
	 * 
	 * @Title: delete 
	 * @Description: 删除
	 * @param @param id    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void delete(int id){
		ticketOrderDao.deleteTicket(id);
	}
}