package com.erim.sz.sametown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.sametown.service.GroundDetailService;

/**
 * @ClassName: GroundDetailController
 * @Description: 当地游showGroundTown
 * @author maoxian
 * @date 2015年10月5日 下午6:49:13
 */
@Controller
public class GroundDetailController {

	@Autowired
	private GroundDetailService    groundService;

	/**
	 * @描述: 同业资源列表页
	 * @创建时间: 2015年11月22日 下午4:37:37
	 * @param model
	 * @param groundDetailBean
	 * @return
	 * @throws ErimException
	 */
	@RequestMapping(value = "/sametown/ground/detail")
	public String sametown(ModelMap model,@ModelAttribute("groundDetail") GroundDetailBean groundDetailBean) throws ErimException {
		
		groundService.showGroundTown(model, groundDetailBean);
		// 新增页面查询字典
		groundService.setCode(model);
		// 同城类型
		model.addAttribute("sametownntype", ErimConstants.TOWN_GROUND);
		return "/sametown/ground/detail";
	}


}