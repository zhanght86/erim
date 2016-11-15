/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserController.java : 2013-06-30
 */
package com.erim.sz.ground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.GroundTriplBean;
import com.erim.sz.ground.service.GroundTripService;
import com.erim.sz.web.util.CommonUtil;

/**
 * @类名: GroundTripController
 * @描述: 行程
 * @作者: 李庆
 * @创建时间: 2015年11月7日 下午10:12:11
 */
@Controller
public class GroundTripController {

	@Autowired
	private GroundTripService groundTripService;

	/**
	 * @描述: 打开行程管理页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月16日 下午2:31:44
	 * @param model
	 * @param tdlId
	 * @return
	 */
	@RequestMapping(value = "/ground/trip/showTrip")
	public String showPrice(ModelMap model, @ModelAttribute("tdlId") Integer tdlId) {
		
		// 执行打开行程管理获取参数
		groundTripService.getTripUpdatePage(tdlId, model);
		
		return "/ground/trip/update";
	}

	/**
	 * @描述: 保存行程管理
	 * @创建时间: 2015年11月15日 下午4:00:05
	 * @param model
	 * @param groundTriplBean
	 * @return
	 * @throws ErimException
	 */
	@ResponseBody
	@RequestMapping(value = "/ground/trip/insert")
	public Integer insert(ModelMap model, GroundTriplBean groundTriplBean) throws ErimException{
		return this.groundTripService.insert(groundTriplBean);
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
	@RequestMapping(value = "/ground/trip/update")
	public int update(ModelMap model, GroundTriplBean groundTriplBean) throws ErimException{
		return this.groundTripService.update(groundTriplBean);
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
	@RequestMapping(value = "/ground/trip/delete")
	public int delete(ModelMap model,Integer id){
		this.groundTripService.delete(id);
		return CommonUtil.SUCCESS;
	}
}