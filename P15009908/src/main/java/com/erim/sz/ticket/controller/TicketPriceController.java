package com.erim.sz.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.TicketClassBean;
import com.erim.sz.common.bean.TicketPriceBean;
import com.erim.sz.ticket.service.TicketPriceService;

/**
 * @类名: TicketPriceController
 * @描述: 门票量价管理信息实体操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年10月17日 上午10:49:17
 */
@Controller
public class TicketPriceController {

	@Autowired
	private TicketPriceService ticketPriceService;
	
	/**
	 * @方法名: showTicketPricePage
	 * @描述: 票类量价管理列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午1:19:01 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/ticket/price/ticketPricePage")
   	public String showTicketPricePage(ModelMap map, TicketPriceBean bean) {
   		
		// 入口号
   		String portal = bean.getPortal();
   		String page = "";
   		
   		// 管理模块第一入口
   		if ("01".equals(portal)) {
   			// 更改页面参数
   			ticketPriceService.showTicketPricePortal(map, bean);
   	   		
   	   		page = "/ticket/price/list";
   		}
   		// 时间向前选择按钮
   		if ("02".equals(portal)) {
   			// 更改页面时间参数
   			ticketPriceService.showListForward(map, bean);
   	   		
   	   		page = "/ticket/price/list";
   		}
   		// 时间向后选择按钮
   		if ("03".equals(portal)) {
   			// 更改页面时间参数
   			ticketPriceService.showListBackwards(map, bean);
   	   		
   	   		page = "/ticket/price/list";
   		}
   		// 刷新页面
   		if ("04".equals(portal)) {
   			// 无更改，纯刷新
   			ticketPriceService.refresh(map, bean);
   	   		
   	   		page = "/ticket/price/list";
   		}
   		// 同业资源第一入口
   		if ("05".equals(portal)) {
   			ticketPriceService.showClassPricePortal(map, bean);
   	   		page = "/ticket/sametown/price";
   		}
   		// 同业资源时间向前选择按钮
   		if ("06".equals(portal)) {
   			// 更改页面时间参数
   			ticketPriceService.showListForward(map, bean);
   	   		page = "/ticket/sametown/price";
   		}
   		// 同业资源时间向后选择按钮
   		if ("07".equals(portal)) {
   			// 更改页面时间参数
   			ticketPriceService.showListBackwards(map, bean);
   			
   	   		page = "/ticket/sametown/price";
   		}
   		// 同业资源选择票类信息
   		if ("08".equals(portal)) {
   			// 选择票类iD
   			ticketPriceService.skipTicketClass(map, bean);
   	   		page = "/ticket/sametown/price";
   		}
   		// 获取数据
   		bean = new TicketPriceBean();
   		ticketPriceService.selectTicketPriceList(map, bean);
   		return page;
   	}
	
	/**
	 * @描述: 查询是否有票类信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月21日 上午11:49:55
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/ticket/price/getClassNum")
	public Integer getClassNum(ModelMap map, TicketClassBean bean) {
		return ticketPriceService.getTicketClassNum(map, bean);
	}
	
	/**
	 * @方法名: insertPrice
	 * @描述: 新增量价
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午2:45:16 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/ticket/price/insertPrice")
	public Integer insertPrice(ModelMap map, TicketPriceBean bean) {
		return ticketPriceService.insertPrice(map, bean);
	}
	
	/**
	 * @方法名: updateIsOpen
	 * @描述: 更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午2:47:40 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/ticket/price/updateIsOpen")
	public String updateIsOpen(ModelMap map, TicketPriceBean bean) {
		
		// 开关房
		ticketPriceService.updateIsOpen(bean);
		// 页面参数
		ticketPriceService.refresh(map, bean);
		// 获取数据
		bean = new TicketPriceBean();
		ticketPriceService.selectTicketPriceList(map, bean);
		
		return "/ticket/price/list";
	}
	
	/**
	 * @方法名: updatePrice
	 * @描述: 修改量价信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午2:49:00 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/ticket/price/updatePrice")
	public Integer updatePrice(ModelMap map, TicketPriceBean bean) {
		return ticketPriceService.updatePrice(bean);
	}
	
	/**
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量更改出售
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午2:51:22 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/ticket/price/updateBatchIsOpen")
	public String updateBatchIsOpen(ModelMap map, TicketPriceBean bean) {
		// 批量更改
		ticketPriceService.updateBatchIsOpen(bean, map);
		// 获取页面参数
		ticketPriceService.refresh(map, bean);
		// 获取数据
		bean = new TicketPriceBean();
		ticketPriceService.selectTicketPriceList(map, bean);
		
		return "/ticket/price/list";
	}
}