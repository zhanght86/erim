package com.erim.sz.sametown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.GroundPriceBean;
import com.erim.sz.sametown.service.GroundPriceService;

/**
 * @类名: GroundPriceController
 * @描述: 当地游量价信息实体操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年10月25日 上午10:08:25
 */
@Controller
public class GroundPriceController {
	
	@Autowired
	private GroundPriceService groundPriceService;
	
	/**
	 * @方法名: showGroundPricePage
	 * @描述: 列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午5:38:09 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/sametown/ground/list")
	public String showGroundPricePage(ModelMap map, GroundPriceBean bean) {
		
		String portal = bean.getPortal();
		String page = "";
		
		// 当地游管理 初始化
		if ("01".equals(portal)) {
			groundPriceService.showGroundPricePortal(map, bean);
			page = "/sametown/ground/list";
		}
		// 当地游管理 时间向前选择
		if ("02".equals(portal)) {
			groundPriceService.showListForward(map, bean);
			page = "/sametown/ground/list";
		}
		// 当地游管理 时间向后选择
		if ("03".equals(portal)) {
			groundPriceService.showListBackwards(map, bean);
			page = "/sametown/ground/list";
		}
		// 当地游管理 刷新页面
		if ("04".equals(portal)) {
			groundPriceService.refresh(map, bean);
			page = "/sametown/ground/list";
		}
		// 同业资源 初始化
		if ("05".equals(portal)) {
			groundPriceService.showGroundPricePortal(map, bean);
			page = "/sametown/ground/price";
		}
		// 同业资源 时间向前选择
		if ("06".equals(portal)) {
			groundPriceService.showListForward(map, bean);
			page = "/sametown/ground/price";
		}
		// 同业资源 时间向后选择
		if ("07".equals(portal)) {
			groundPriceService.showListBackwards(map, bean);
			page = "/sametown/ground/price";
		}
		
		// 获取数据
		bean = new GroundPriceBean();
		groundPriceService.selectGroundPriceList(map, bean);
		
		return page;
	}
	
	
}