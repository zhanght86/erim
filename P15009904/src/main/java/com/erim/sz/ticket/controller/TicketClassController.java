/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserController.java : 2013-06-30
 */
package com.erim.sz.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.TicketClassBean;
import com.erim.sz.ticket.service.TicketClassService;

/**
 * @ClassName:   TexiSendController 
 * @Description: 门票新增详细控制
 * @author       王赛
 * @date         2015年10月10日 上午3:06:34 
 */
@Controller
public class TicketClassController {
	
	@Autowired
	private TicketClassService ticketclassService;
  
	/**
	 * @方法名: showList
	 * @描述: 票类管理新增、列表页
	 * @作者: 王赛
	 * @创建时间: 2015年10月12日 下午6:34:25 
	 * @param model
	 * @param Bean
	 * @return
	 * @throws ErimException
	 */
	@RequestMapping(value = "/ticketclass/detail/insertticket")
	public String showList(ModelMap model, TicketClassBean Bean) {
		
		ticketclassService.showTicket(model, Bean);
		
		return "/ticket/class/insert";
	}

	/**
	 * @方法名: delete
	 * @描述: 票类上下架
	 * @作者: 王赛
	 * @创建时间: 2015年11月2日 下午12:27:58 
	 * @param bean
	 * @param model
	 * @return
	 * @throws ErimException
	 */
    @RequestMapping(value = "/ticketclass/detail/delete")
    public String delete(TicketClassBean bean,ModelMap model) throws ErimException {
    	//执行上架下架方法
		ticketclassService.delete(bean);
		//new一个新的票类bean
		bean = new TicketClassBean();
		//执行完上下架方法后走查询列表的方法
		return this.showList(model, bean);
    }
	    
    /**
     * @描述: 保存票类信息
     * @作者: 宁晓强
     * @创建时间: 2015年12月1日 下午2:34:04
     * @param model
     * @param Bean
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/ticketclass/detail/insert")
	public Integer update(ModelMap model, TicketClassBean Bean) {
    	return ticketclassService.update(Bean);
	}
	    
    /**
     * @描述: 打开票类修改、列表页
     * @作者: 宁晓强
     * @创建时间: 2015年12月1日 下午2:46:08
     * @param model
     * @param bean
     * @return
     */
    @RequestMapping(value = "/ticketclass/detail/view")
    public String updatePage(ModelMap model,TicketClassBean bean){
    	
    	// 根据ID获取一条数据
    	ticketclassService.selectclassById(model, bean);
    	// 获取数据列表
    	ticketclassService.showTicket(model, bean);
    	
    	return "/ticket/class/update";
    }
}
 