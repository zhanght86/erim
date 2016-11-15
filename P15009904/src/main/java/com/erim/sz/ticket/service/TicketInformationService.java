package com.erim.sz.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.ticket.dao.TicketInformationDao;

/***
 * 
 * @ClassName: TicketInformationService
 * @Description: 酒店接口
 * @author 龙龙
 * @date 2015年7月29日 上午11:19:37
 *
 */
@Service("ticketinformationService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TicketInformationService {

	@Autowired
	private TicketInformationDao ticketDao;

	public void showTicket(ModelMap model, TicketDetailBean bean) {

		bean.getPageLinkBean().setLimit(10);
		
		// 分页查询
		List<TicketDetailBean> ticketList = ticketDao.selectPageTicket(bean, model);

		// 回传信息
		model.put("ticketList", ticketList);
	}

	/**
	 * 
	 * @Title: insert
	 * @Description: 插入
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void insert(ModelMap model, TicketDetailBean bean) {
		// 插入数据
		ticketDao.insertTicket(bean);
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 修改
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void update(ModelMap model, TicketDetailBean bean) {
		ticketDao.updateTicket(bean);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void delete(int id) {
		ticketDao.deleteTicket(id);
	}
}