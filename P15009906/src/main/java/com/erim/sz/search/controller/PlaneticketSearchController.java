package com.erim.sz.search.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.PlaneticketDetailBean;
import com.erim.sz.search.service.PlaneticketDetailService;

/**
 * @ClassName: PlaneticketSearchController 
 * @Description: 机票检索
 * @author maoxian
 * @date 2015年12月24日 下午11:29:09
 */
@Controller
public class PlaneticketSearchController {
	
	@Autowired
	private PlaneticketDetailService planeticketDetailService;
	
	
	
	/**
	 * @Title: setNowDate 
	 * @Description: 获取当前时间 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月19日 下午3:09:30 
	 * @throws
	 */
	public void setNowDate(ModelMap model){
		model.addAttribute("nowDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	}
	
	/**
	 * @Title: searchPlaneticket 
	 * @Description: 机票检索
	 * @param @param model
	 * @param @param Bean
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月24日 下午11:28:49 
	 * @throws
	 */
	@RequestMapping(value = "/search/planeticket/list")
	public String searchPlaneticket(ModelMap model,@ModelAttribute("planeticketDetail") PlaneticketDetailBean Bean ){
		planeticketDetailService.showPlaneticket(model,Bean);
		planeticketDetailService.setCode(model);
		return "/search/planeticket/list";
	}
}
