package com.erim.sz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.CafeteriaDetailBean;
import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.common.bean.ManagementDetailBean;
import com.erim.sz.common.bean.PlaneticketDetailBean;
import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.web.service.CafeteriaDetailService;
import com.erim.sz.web.service.HotelDetailService;
import com.erim.sz.web.service.ManagementDetailService;
import com.erim.sz.web.service.PlaneticketDetailService;
import com.erim.sz.web.service.TexiDetailService;
import com.erim.sz.web.service.TicketDetailService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: SuperfreeController 
 * @Description: 超级自由行
 * @author maoxian
 * @date 2015年9月15日 下午12:32:30 
 *
 */
@Controller
public class SuperfreeController {

	//租车
	@Autowired
	private TexiDetailService 	   		TexiDetailService;
	//特色餐
	@Autowired
	private CafeteriaDetailService 		cafeteriaDetailService;
	//酒店
	@Autowired
	private HotelDetailService     		hotelDetailService;
	//门票
	@Autowired
	private TicketDetailService    		ticketDetailService;
	//签证
	@Autowired
	private ManagementDetailService     managementDetailService;
	//机票
	@Autowired
	private PlaneticketDetailService    planeticketDetailService;
	@Autowired
	private CodeService codeService;
	/**
	 * @Title: superfree 
	 * @Description: 首页
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/superfree/superfree")
	public String superfree(ModelMap model,String searchModel) {
		//租车
		this.TexiDetailService.showTexiSend(model, new TexiDetailBean(),5);
		//特色餐
		this.cafeteriaDetailService.showCafeteria(model, new CafeteriaDetailBean(),10);
		//酒店
		this.hotelDetailService.showHotel(model, new HotelDetailBean(), 10);
		//门票
		this.ticketDetailService.showTicket(model, new TicketDetailBean(), 10);
		//签证
		this.managementDetailService.showManagement(model, new ManagementDetailBean(), 12);
		//机票
		this.planeticketDetailService.showPlaneticket(model, new PlaneticketDetailBean(), 16);
		
		
		 // 酒店特色
	 	model.addAttribute("hotelfeatures",    this.codeService.getSystemCodeByCodeNo(DictionaryUtil.HOTELFEATURES));
	 	//门票 景点主题
	 	model.addAttribute("attractions", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ATTRACTIONS));
	 	//餐厅主打菜系
	 	model.addAttribute("sort",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SORT));
	 	
	 	model.addAttribute("searchModel", searchModel);
		return "/superfree/superfree";
	}
}