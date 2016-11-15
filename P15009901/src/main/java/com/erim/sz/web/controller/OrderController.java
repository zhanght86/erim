package com.erim.sz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @描述: 订单预定页面
 * @作者: （heyuanbo）
 * @创建时间: 2015年11月26日 下午2:44:43
 */

@Controller
public class OrderController {
	/**
	 * @描述: 点击租车预定跳转页面
	 * @作者: （heyuanbo）
	 * @创建时间: 2015年11月26日 下午10:33:50
	 * @return String
	 */
	
	@RequestMapping(value = "/{cpyno}/texi/carorder")
	public String texiOrder(){
		return "texi/carorder";
	}
	

}
