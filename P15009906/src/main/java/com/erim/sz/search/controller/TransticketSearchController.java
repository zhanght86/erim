package com.erim.sz.search.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.TransticketDetailBean;
import com.erim.sz.search.service.TransticketDetailService;

/**
 * @ClassName: TransticketSearchController 
 * @Description: 火车票检索
 * @author maoxian
 * @date 2015年12月24日 下午11:28:15
 */
@Controller
public class TransticketSearchController {
	
	@Autowired
	private TransticketDetailService transticketDetailService;
	
	
	
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
	 * @Title: searchtransticket
	 * @Description: 火车票
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/search/transticket/list")
	public String searchTransticket(ModelMap model ,@ModelAttribute("transticketDetail") TransticketDetailBean Bean ){
		transticketDetailService.showTransticket(model,Bean);
		return "/search/transticket/list";
	}
}
