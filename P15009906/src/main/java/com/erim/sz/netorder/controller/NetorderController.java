package com.erim.sz.netorder.controller;

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
 * @ClassName: NetorderController 
 * @Description: 外网订单
 * @author maoxian
 * @date 2015年11月4日 下午2:52:06
 */
@Controller
public class NetorderController {
	
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
	@RequestMapping(value = "/netorder/detail/show")
	public String list(){
		return "/netorder/detail/show";
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
	@RequestMapping(value = "/netorder/hotel/list")
	public String hotel(HotelOrderBean orderBean,ModelMap model){
		hotelOrderService.showHotelOrder(model, orderBean);
		return "/netorder/hotel/list";
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
	@RequestMapping(value = "/netorder/ticket/list")
	public String ticket(TicketOrderBean orderBean,ModelMap model){
		ticketOrderService.showTicket(model, orderBean);
		return "/netorder/ticket/list";
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
	@RequestMapping(value = "/netorder/texi/list")
	public String texi(TexiOrderBean orderBean,ModelMap model){
		texiOrderService.showTexi(model, orderBean);
		return "/netorder/texi/list";
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
	@RequestMapping(value = "/netorder/cafeteria/list")
	public String cafeteria(CafeteriaOrderBean orderBean,ModelMap model){
		cafeteriaOrderService.showCafeteria(model, orderBean);
		return "/netorder/cafeteria/list";
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
	@RequestMapping(value = "/netorder/ground/list")
	public String ground(GroundOrderBean orderBean,ModelMap model){
		groundOrderService.showGround(model, orderBean);
		return "/netorder/ground/list";
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
	@RequestMapping(value = "/netorder/guide/list")
	public String guide(GuideOrderBean orderBean,ModelMap model){
		guideOrderService.showGuide(model, orderBean);
		return "/netorder/guide/list";
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
	@RequestMapping(value = "/netorder/management/list")
	public String management(ManagementOrderBean orderBean,ModelMap model){
		managementOrderService.showManagement(model, orderBean);
		return "/netorder/management/list";
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
	@RequestMapping(value = "/netorder/planeticket/list")
	public String planeticket(PlaneticketOrderBean orderBean,ModelMap model){
		planeticketOrderService.showPlaneticket(model, orderBean);
		return "/netorder/planeticket/list";
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
    @RequestMapping(value = "/netorder/line/list")
    public String showList(ModelMap model, @ModelAttribute("lineOrder") LineOrderBean lineOrderBean) throws ErimException {
    	this.lineOrderService.showLine(model, lineOrderBean);
        return "/netorder/line/list";
    }

}
