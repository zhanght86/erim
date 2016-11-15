package com.erim.sz.sametown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.CafeteriaDetailBean;
import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.common.bean.PlaneticketOrderBean;
import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.sametown.service.CafeteriaDetailService;
import com.erim.sz.sametown.service.GuideDetailService;
import com.erim.sz.sametown.service.HotelDetailService;
import com.erim.sz.sametown.service.TexiDetailService;
import com.erim.sz.sametown.service.TicketDetailService;

/**
 * 
 * @类名: SameTownController
 * @描述: 同城同业
 * @作者: 李庆
 * @创建时间: 2015年10月25日 下午5:05:47
 *
 */
@Controller
public class SameTownController {

	@Autowired
	private HotelDetailService     hotelDetailService;
	@Autowired
	private CafeteriaDetailService cafeteriaDetailService;
	@Autowired
	private TicketDetailService    ticketDetailService;
	@Autowired
	private GuideDetailService     guideDetailService;
	@Autowired
	private TexiDetailService      texiDetailService;
	
	/**
	 * 
	 * @Title: hotel 
	 * @Description: 酒店
	 * @param @param Bean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/sametown/hotel/detail")
	public String hotel(HotelDetailBean Bean,ModelMap model){
		hotelDetailService.showHotel(model, Bean);
		return "/sametown/hotel/detail";
	}
	/**
	 * 
	 * @Title: ticket 
	 * @Description: 门票同城
	 * @param @param Bean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/sametown/ticket/detail")
	public String ticket(TicketDetailBean Bean,ModelMap model){
		ticketDetailService.showTicket(model, Bean);
		//查看字典
		ticketDetailService.setCode(model);
		return "/sametown/ticket/detail";
	}
	/**
	 * 
	 * @Title: texi 
	 * @Description: 租车同城
	 * @param @param Bean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/sametown/texi/detail")
	public String texi(TexiDetailBean Bean,ModelMap model){
		texiDetailService.showTexiTown(model, Bean);
		return "/sametown/texi/detail";
	}

	/**
	 * 
	 * @Title: cafeteria 
	 * @Description:特色餐同城
	 * @param @param Bean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/sametown/cafeteria/detail")
	public String cafeteria(CafeteriaDetailBean Bean,ModelMap model){
		cafeteriaDetailService.showCafeteria(model, Bean);
		return "/sametown/cafeteria/detail";
	}
	/**
	 * 
	 * @Title: ground 
	 * @Description: 当地旅游同城
	 * @param @param Bean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
//	@RequestMapping(value = "/sametown/ground/detail")
//	public String sametown(ModelMap model, @ModelAttribute("groundDetail")GroundDetailBean groundDetailBean) throws ErimException {
//		
//		this.groundDetailService.showGroundTown(model, groundDetailBean);
//		// 新增页面查询字典
//		groundDetailService.setCode(model);
//		// 同城类型
//		model.addAttribute("sametownntype", ErimConstants.TOWN_GROUND);
//		return "/sametown/ground/detail";
//	}
	/**
	 * 
	 * @Title: guide 
	 * @Description: 导游同城 
	 * @param @param Bean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/sametown/guide/detail")
	public String guide(GuideDetailBean Bean,ModelMap model){
		guideDetailService.showGuide(model, Bean);
		//查看字典
		guideDetailService.setCode(model);
		return "/sametown/guide/detail";
	}
	/**
	 * 
	 * @Title: planeticket 
	 * @Description: 机票同城
	 * @param @param Bean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/orders/planeticket/list")
	public String planeticket(PlaneticketOrderBean orderBean,ModelMap model){
		return "/orders/planeticket/list";
	}
}
