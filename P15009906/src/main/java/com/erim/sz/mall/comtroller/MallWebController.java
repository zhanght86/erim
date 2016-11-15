package com.erim.sz.mall.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.MallWebBean;
import com.erim.sz.mall.service.MallWebService;

/**
 * 
 * @ClassName: MallWebController 
 * @Description: 关联外网
 * @author maoxian
 * @date 2015年11月12日 下午3:13:53 
 *
 */
@Controller
public class MallWebController {

	
	@Autowired
	private MallWebService mallWebService;
	
	/**
	 * @Title: show 
	 * @Description: 商城主页
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/mall/web/show")
	public String show(ModelMap model){
		this.mallWebService.getMallWeb(model);
		return "/mall/web/show";
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改
	 * @param @param model
	 * @param @param webean
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/mall/web/update")
	public @ResponseBody Integer update(ModelMap model,MallWebBean webean){
		return this.mallWebService.update(webean);
	}
}