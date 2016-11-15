package com.erim.sz.price.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.price.service.PriceBackYjService;

/**
 * @ClassName: PriceBackYjController 
 * @Description: 已合作佣金
 * @author maoxian
 * @date 2015年12月17日 下午11:41:32
 */
@Controller
public class PriceBackYjController {
	
	@Autowired
	private PriceBackYjService priceBackYjService;

	/**
	 * @Title: cooperation 
	 * @Description: 佣金返利查看
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月17日 下午11:43:15 
	 * @throws
	 */
	@RequestMapping(value = "/priceback/yj/cooperation")
	public String cooperation(ModelMap model){
		//model.addAttribute("cooperation", this.priceBackYjService.selectCooperation());
		model.addAttribute("cooperation",this.priceBackYjService.selectPriceBackYj());
		return "/priceback/yj/cooperation";
	}
}