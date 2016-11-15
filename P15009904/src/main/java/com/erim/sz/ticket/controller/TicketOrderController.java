package com.erim.sz.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.TicketOrderBean;
import com.erim.sz.ticket.service.TicketOrderService;
import com.erim.sz.web.util.CommonUtil;

/***
 * 
* @ClassName: TicketOrderController 
* @Description: 门票订单详细控制
* @author 龙龙
* @date 2015年7月30日 下午1:21:25 
*
 */
@Controller
public class TicketOrderController {

    @Autowired
    private TicketOrderService ticketOrderService;

    /**
     * 
     * @Description: 门票订单列表页
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/ticket/order/list")
    public String showList(ModelMap model, @ModelAttribute("ticketOrder") TicketOrderBean ticketOrderBean) throws ErimException {
    	ticketOrderBean.setCpyId(CommonUtil.getCpyId());
    	this.ticketOrderService.showTicket(model, ticketOrderBean);
        return "/ticket/order/list";
    }
    /**
     * 
     * @方法名: insert
     * @描述:  添加同业订单
     * @作者: 李庆
     * @创建时间: 2015年11月5日 下午4:25:02 
     * @return
     *
     */
    @RequestMapping(value="/ticket/order/insert")
	public String insert(){
		return "/ticket/order/insert";
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
    @RequestMapping(value="/ticket/order/update")
   	public String update(){
   		return "/ticket/order/update";
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
   	
    @RequestMapping(value="/ticket/order/view")
   	public String view(){
   		return "/ticket/order/view";
   	}
    
    /**
     * 
     * @Title: insert
     * @Description: 修改为接单或拒接状态
     * @param @param model
     * @param @param bean
     * @param @return    设定文件
     * @return int    返回类型 1 代表修改成功，0 代表修改失败
     * @throws
     */
    @RequestMapping(value = "/ticket/order/delete")
    public String insert(ModelMap model,TicketOrderBean ticketOrderBean) throws ErimException{
    	ticketOrderService.update(model, ticketOrderBean);
    	return this.showList(model, ticketOrderBean);
    }
    

}