package com.erim.sz.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.CafeteriaDetailBean;
import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.common.bean.ManagementDetailBean;
import com.erim.sz.common.bean.PlaneticketDetailBean;
import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.common.bean.TransticketDetailBean;

/**
 * @ClassName: ReservationController 
 * @Description: 预订页面
 * @author maoxian
 * @date 2015年11月4日 下午4:43:03
 */
@Controller
public class ReservationController {

	/**
	 * @Title: searchHotel 
	 * @Description: TODO(酒店) 
	 * @param @param Bean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/reservation/hotel/page")
	public String searchHotel(HotelDetailBean Bean,ModelMap model ){
		return "/reservation/hotel";
	}
	/**
	 * @方法名：searchTicket 
	 * @描述:  门票
	 * @创建时间：2015年11月4日 下午5:11:21
	 */
	@RequestMapping(value = "/reservation/ticket/page")
	public String searchTicket(TicketDetailBean Bean,ModelMap model){
		return "/reservation/ticket";
	}
	/**
	 * @方法名：searchTicket 
	 * @描述:  租车
	 * @创建时间：2015年11月4日 下午5:13:37
	 * @param Bean
	 * @param model
	 */
	@RequestMapping(value = "/reservation/texi/page")
	public String searchTexi(TexiDetailBean Bean,ModelMap model){
		return "/reservation/texi";
	}
	/**
	 * @方法名：searchTexi 
	 * @描述: 特色餐
	 * @创建时间：2015年11月4日 下午5:14:22
	 * @param Bean
	 * @param model
	 */
	@RequestMapping(value = "/reservation/cafeteria/page")
	public String searchCafeteria(CafeteriaDetailBean Bean,ModelMap model){
		return "/reservation/cafeteria";
	}
	/**
	 * @方法名：searchCafeteria 
	 * @描述:  专线
	 * @创建时间：2015年11月4日 下午5:16:02
	 * @param Bean
	 * @param model
	 *
	 */
	@RequestMapping(value = "/reservation/line/page")
	public String searchLine(LineDetailBean Bean,ModelMap model){
		return "/reservation/line";
	}
	/**
	 * @方法名：searchGround 
	 * @描述: 当地游
	 * @创建时间：2015年11月4日 下午5:17:45
	 * @param Bean
	 * @param model
	 *
	 */
	
	@RequestMapping(value = "/reservation/ground/page")
	public String searchGround(GroundDetailBean Bean,ModelMap model){
		return "/reservation/ground";
	}
	
	/**
	 * @方法名：searchGuide 
	 * @描述:  导游
	 * @创建时间：2015年11月4日 下午5:19:25
	 * @param Bean
	 * @param model
	 */
	@RequestMapping(value = "/reservation/guide/page")
	public String searchGuide(GuideDetailBean Bean,ModelMap model){
		return "/reservation/guide";
	}
	/**
	 * @方法名：searchManagement 
	 * @描述: 签证
	 * @创建时间：2015年11月4日 下午5:20:26
	 * @param Bean
	 * @param model
	 */
	@RequestMapping(value = "/reservation/management/page")
	public String searchManagement(ManagementDetailBean Bean,ModelMap model){
		return "/reservation/management";
	}
	/**
	 * @方法名：searchPlaneticket 
	 * @描述: 机票
	 * @作者： 
	 * @创建时间：2015年11月4日 下午5:20:58
	 * @param Bean
	 * @param model
	 */
	@RequestMapping(value = "/reservation/planeticket/page")
	public String searchPlaneticket(PlaneticketDetailBean Bean,ModelMap model){
		return "/reservation/planeticket";
	}
	/**
	 * @方法名：searchTransticket 
	 * @描述: 火车票
	 * @创建时间：2015年11月4日 下午5:22:35
	 * @param Bean
	 * @param model
	 */
	@RequestMapping(value = "/reservation/transticket/page")
	public String searchTransticket(TransticketDetailBean Bean,ModelMap model){
		return "/reservation/transticket";
	}

}
