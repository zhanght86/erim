/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserController.java : 2013-06-30
 */
package com.erim.sz.line.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.LineTripBean;
import com.erim.sz.line.service.LineTripService;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @类名: LineTripController
 * @描述: 专线行程
 * @作者: 李庆
 * @创建时间: 2015年11月3日 下午10:12:11
 *
 */
@Controller
public class LineTripController {

	@Autowired
	private LineTripService lineTripService;

	/**
	 * 
	 * @Title: showPrice 
	 * @Description: 所有行程 
	 * @param @param model
	 * @param @param tdlId
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/line/trip/showTrip")
	public String showPrice(ModelMap model, @ModelAttribute("tdlId") Integer tdlId) {
		//执行打开行程管理获取参数
	   lineTripService.getTripUpdatePage(tdlId, model);
		return "/line/trip/update";
	}
	/**
	 * 
	 * @描述: 保存行程管理
	 * @作者: （李庆）
	 * @创建时间: 2015年12月1日 下午7:07:25
	 * @param model
	 * @param lineTripBean
	 * @return
	 * @throws ErimException
	 */

	@ResponseBody
	@RequestMapping(value = "/line/trip/insert")
	public int insert(ModelMap model, LineTripBean lineTripBean) throws ErimException{
		return this.lineTripService.insert(lineTripBean);
	}
	/**
	 * @Title: update 
	 * @Description: 修改地址
	 * @param @param model
	 * @param @param lineTripBean
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/line/trip/update")
	public int update(ModelMap model, LineTripBean lineTripBean) throws ErimException{
		return this.lineTripService.update(lineTripBean);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除
	 * @param @param model
	 * @param @param id    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/line/trip/delete")
	public int delete(ModelMap model,Integer id){
		this.lineTripService.delete(id);
		return CommonUtil.SUCCESS;
	}
}