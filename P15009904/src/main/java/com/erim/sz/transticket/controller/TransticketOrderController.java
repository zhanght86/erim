package com.erim.sz.transticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @类名: TicketOrderController
 * @描述: 火车票订单
 * @作者: 李庆
 * @创建时间: 2015年11月5日 下午5:45:13
 *
 */
@Controller
public class TransticketOrderController {
    /**
     * 
     * @方法名: insert
     * @描述:  添加同业订单
     * @作者: 李庆
     * @创建时间: 2015年11月5日 下午4:25:02 
     * @return
     *
     */
    @RequestMapping(value="/transticket/order/insert")
	public String insert(){
		return "/transticket/order/insert";
	}
    /**
     * 
     * @方法名: update
     * @描述:  修改同业订单
     * @作者: 李庆
     * @创建时间: 2015年11月5日 下午4:25:02 
     * @return
     *
     */
    @RequestMapping(value="/transticket/order/update")
   	public String update(){
   		return "/transticket/order/update";
   	}
    /**
     * 
     * @方法名: view
     * @描述: 查看同业订单
     * @作者: 李庆
     * @创建时间: 2015年11月5日 下午4:25:02 
     * @return
     *
     */
   	
    @RequestMapping(value="/transticket/order/view")
   	public String view(){
   		return "/transticket/order/view";
   	}
    
}