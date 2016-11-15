package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TicketClassBean;
import com.erim.sz.web.dao.TicketclasskDao;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: HotelMeetingService
 * @描述: 酒店会议室
 * @作者: 王赛
 * @创建时间: 2015年11月23日 下午4:42:29
 *
 */
@Service("classService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TicketclassService {

	@Autowired
	private TicketclasskDao        ticketclassDao;
	@Autowired
	private CodeService codeService;
	/**
	 * 
	 * @方法名: selectList
	 * @描述: 门票票类管理
	 * @作者: 王赛
	 * @创建时间: 2015年11月25日 下午11:41:37 
	 * @param hdlid
	 * @param model
	 *
	 */
	public void selectList(Integer tdlId,ModelMap model,String tplDate){
		
		TicketClassBean bean = new TicketClassBean();
		bean.setTdlId(tdlId);
		bean.setTplDate(tplDate);
		List<TicketClassBean> classlist = ticketclassDao.selectList(bean);
		
		model.addAttribute("ticketclass", classlist);
	}
}