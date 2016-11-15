package com.erim.sz.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.CafeteriaOrderBean;
import com.erim.sz.common.bean.GroundOrderBean;
import com.erim.sz.common.bean.GuideOrderBean;
import com.erim.sz.common.bean.HotelOrderBean;
import com.erim.sz.common.bean.LineOrderBean;
import com.erim.sz.common.bean.ManagementOrderBean;
import com.erim.sz.common.bean.PlaneticketOrderBean;
import com.erim.sz.common.bean.TexiOrderBean;
import com.erim.sz.common.bean.TicketOrderBean;
import com.erim.sz.orders.service.CafeteriaOrderService;
import com.erim.sz.orders.service.GroundOrderService;
import com.erim.sz.orders.service.GuideOrderService;
import com.erim.sz.orders.service.HotelOrderService;
import com.erim.sz.orders.service.LineOrderService;
import com.erim.sz.orders.service.ManagementOrderService;
import com.erim.sz.orders.service.PlaneticketOrderService;
import com.erim.sz.orders.service.TexiOrderService;
import com.erim.sz.orders.service.TicketOrderService;

/**
 * 
 * @ClassName: OrdersController 
 * @Description: 订单管理
 * @author maoxian
 * @date 2015年9月16日 下午7:44:03 
 *
 */
@Controller
public class OrdersController {
	
	@Autowired
	private HotelOrderService 		hotelOrderService;
	@Autowired
	private TicketOrderService 		ticketOrderService;
	@Autowired
	private TexiOrderService 		texiOrderService;
	@Autowired
	private CafeteriaOrderService 	cafeteriaOrderService;
	@Autowired
	private GroundOrderService 		groundOrderService;
	@Autowired
	private GuideOrderService		guideOrderService;
	@Autowired
	private ManagementOrderService  managementOrderService;
	@Autowired
	private PlaneticketOrderService planeticketOrderService;
	@Autowired
	private LineOrderService        lineOrderService;
	/**
	 * @Title: list 
	 * @Description: 订单管理 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/orders/detail/show")
	public String list(){
		return "/orders/detail/show";
	}
	
	/**
	 * 
	 * @Title: hotel 
	 * @Description: 酒店订单
	 * @param @param orderBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/orders/hotel/list")
	public String hotel(ModelMap model,@ModelAttribute("hotelOrder")HotelOrderBean orderBean){
		hotelOrderService.showHotelOrder(model, orderBean);
		return "/orders/hotel/list";
	}
	
	/**
	 * 
	 * @Title: ticket 
	 * @Description: 门票订单
	 * @param @param orderBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/orders/ticket/list")
	public String ticket(TicketOrderBean orderBean,ModelMap model){
		ticketOrderService.showTicket(model, orderBean);
		return "/orders/ticket/list";
	}

	/**
	 * 
	 * @Title: texi 
	 * @Description: 租车订单
	 * @param @param orderBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/orders/texi/list")
	public String texi(TexiOrderBean orderBean,ModelMap model){
		texiOrderService.showTexi(model, orderBean);
		return "/orders/texi/list";
	}

	/**
	 * 
	 * @Title: cafeteria 
	 * @Description:特色餐订单
	 * @param @param orderBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/orders/cafeteria/list")
	public String cafeteria(CafeteriaOrderBean orderBean,ModelMap model){
		cafeteriaOrderService.showCafeteria(model, orderBean);
		return "/orders/cafeteria/list";
	}

	/**
	 * 
	 * @Title: ground 
	 * @Description: 当地旅游订单
	 * @param @param orderBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/orders/ground/list")
	public String ground(GroundOrderBean orderBean,ModelMap model){
		groundOrderService.showGround(model, orderBean);
		return "/orders/ground/list";
	}

	/**
	 * 
	 * @Title: guide 
	 * @Description: 导游订单 
	 * @param @param orderBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/orders/guide/list")
	public String guide(GuideOrderBean orderBean,ModelMap model){
		guideOrderService.showGuide(model, orderBean);
		return "/orders/guide/list";
	}

	/**
	 * 
	 * @Title: management 
	 * @Description: 专线订单
	 * @param @param orderBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/orders/management/list")
	public String management(ManagementOrderBean orderBean,ModelMap model){
		managementOrderService.showManagement(model, orderBean);
		return "/orders/management/list";
	}

	/**
	 * 
	 * @Title: planeticket 
	 * @Description: 机票订单
	 * @param @param orderBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/orders/planeticket/list")
	public String planeticket(PlaneticketOrderBean orderBean,ModelMap model){
		planeticketOrderService.showPlaneticket(model, orderBean);
		return "/orders/planeticket/list";
	}
	  /**
     * 
     * @Description: 专线订单列表页
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/orders/line/list")
    public String showList(ModelMap model, @ModelAttribute("lineOrder") LineOrderBean lineOrderBean) throws ErimException {
    	this.lineOrderService.showLine(model, lineOrderBean);
        return "/orders/line/list";
    }

}
