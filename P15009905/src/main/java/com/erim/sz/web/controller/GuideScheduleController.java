package com.erim.sz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.GuideScheduleBean;
import com.erim.sz.web.service.GuideScheduleService;

/**
 * 
 * @ClassName: GuideScheduleController 
 * @Description: 导游档期和金额控制 
 * @author maoxian
 * @date 2015年9月11日 下午3:47:51 
 *
 */
@Controller
public class GuideScheduleController {

	@Autowired
	private GuideScheduleService guideScheduleService;
	
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param model
	 * @param @param guideScheduleBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/guide/schedule/insert")
	public @ResponseBody Integer insert(ModelMap model,GuideScheduleBean guideScheduleBean){
		return this.guideScheduleService.insert(guideScheduleBean, model);
	}
}
