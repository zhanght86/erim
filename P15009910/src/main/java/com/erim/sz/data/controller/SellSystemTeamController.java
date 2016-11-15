package com.erim.sz.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.SellSystemTeamBean;
import com.erim.sz.data.service.SellSystemTeamService;

/***
 * 
 * @ClassName: SellSystemTeamController 
 * @Description: TODO(佣金系统) 
 * @author wanzhiwei
 * @date 2015年12月15日 下午3:01:25 
 *
 */
@Controller
public class SellSystemTeamController {
	@Autowired
	private SellSystemTeamService sellSystemTeamService;
	/***
	 * 
	 * @Title: list 
	 * @Description: 参考数据列表
	 * @param @param model
	 * @param @param param
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/yj/data/list")
	public String list(ModelMap model,SellSystemTeamBean param){
		this.sellSystemTeamService.selectPageData(param, model);
		return "/data/referenc/list";
	}
}
