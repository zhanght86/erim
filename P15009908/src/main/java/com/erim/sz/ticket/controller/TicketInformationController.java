package com.erim.sz.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.ticket.service.TicketInformationService;

/**
 * 
* @ClassName: TicketInformationController 
* @Description: 酒店基本信息
* @author 陈鹏
* @date 2015年8月2日 下午11:19:35 
*
 */
@Controller
public class TicketInformationController {

    @Autowired
    private TicketInformationService ticketService;

    /**
     * 
     * @Description: 酒店列表页
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
//    @RequestMapping(value = "/ticket/information/ticketinformation")
//    public String showList(ModelMap model, @ModelAttribute("ticketInformation") TicketDetailBean ticketDetailBean) throws ErimException {
//    	this.ticketService.showTicket(model, ticketDetailBean);
//        return "/ticket/detail/list";
//    }
    
    /**
     * 
     * @Title: insertPage 
     * @Description: 新增页面
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/ticket/information/ticketinformationPage")
    public String insertPage() throws ErimException {
    	return "/ticket/information/ticketinformation";
    }

    /**
     * 
     * @Title: insert 
     * @Description: 新增方法
     * @param @param model
     * @param @param ticketDetailBean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/ticket/information/ticketinformation")
    public String insert(ModelMap model, @ModelAttribute("ticketInformation") TicketDetailBean ticketDetailBean) throws ErimException {
    	this.ticketService.insert(model, ticketDetailBean);
    	return "index";
    }
}