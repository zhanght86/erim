package com.erim.sz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.GuideOrderBean;
import com.erim.sz.web.service.GuideOrderService;

/**
 * 
 * @ClassName: GuideOrderController
 * @Description: 导游订单查看
 * @author maoxian
 * @date 2015年9月10日 下午6:32:47
 *
 */
@Controller
public class GuideOrderController {

	@Autowired
	private GuideOrderService guideOrderService;

	/**
	 * 
	 * @Description: 导游订单列表页
	 * @param @param model
	 * @param @param request
	 * @param @return
	 * @param @throws ErimException 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/order")
	public String showList(ModelMap model,
			@ModelAttribute("guideOrder") GuideOrderBean guideOrderBean)
			throws ErimException {
		this.guideOrderService.showGuide(model, guideOrderBean);
		return "order";
	}

}