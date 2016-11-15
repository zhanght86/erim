package com.erim.sz.ground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.GroundPriceBean;
import com.erim.sz.ground.service.GroundPriceService;

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
	@RequestMapping("/ground/price/list")
	public String showGroundPricePage(ModelMap map, GroundPriceBean bean) {
		
		String portal = bean.getPortal();
		String page = "";
		
		// 当地游管理 初始化
		if ("01".equals(portal)) {
			groundPriceService.showGroundPricePortal(map, bean);
			page = "/ground/price/list";
		}
		// 当地游管理 时间向前选择
		if ("02".equals(portal)) {
			groundPriceService.showListForward(map, bean);
			page = "/ground/price/list";
		}
		// 当地游管理 时间向后选择
		if ("03".equals(portal)) {
			groundPriceService.showListBackwards(map, bean);
			page = "/ground/price/list";
		}
		// 当地游管理 刷新页面
		if ("04".equals(portal)) {
			groundPriceService.refresh(map, bean);
			page = "/ground/price/list";
		}
		// 同业资源 初始化
		if ("05".equals(portal)) {
			groundPriceService.showGroundPricePortal(map, bean);
			page = "/ground/sametown/price";
		}
		// 同业资源 时间向前选择
		if ("06".equals(portal)) {
			groundPriceService.showListForward(map, bean);
			page = "/ground/sametown/price";
		}
		// 同业资源 时间向后选择
		if ("07".equals(portal)) {
			groundPriceService.showListBackwards(map, bean);
			page = "/ground/sametown/price";
		}
		
		// 获取数据
		bean = new GroundPriceBean();
		groundPriceService.selectGroundPriceList(map, bean);
		
		return page;
	}
	
	/**
	 * @方法名: insertPrice
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午5:37:51 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/ground/price/insert")
	public Integer insertPrice(ModelMap map, GroundPriceBean bean) {
		return groundPriceService.insertPrice(map, bean);
	}
	
	/**
	 * @方法名: updateIsOpen
	 * @描述: 更改是否出售
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午5:39:48 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/ground/price/updateIsOpen")
	public String updateIsOpen(ModelMap map, GroundPriceBean bean) {
		
		// 执行更改
		groundPriceService.updateIsOpen(bean);
		// 参数
		groundPriceService.refresh(map, bean);
		// 数据
		bean = new GroundPriceBean();
		groundPriceService.selectGroundPriceList(map, bean);
		return "/ground/price/list";
	}
	
	/**
	 * @方法名: updatePrice
	 * @描述: 修改量价信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午5:41:02 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/ground/price/updatePrice")
	public Integer updatePrice(ModelMap map, GroundPriceBean bean) {
		return groundPriceService.updatePrice(bean);
	}
	
	/**
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午5:43:13 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/ground/price/updateBatchIsOpen")
	public String updateBatchIsOpen(ModelMap map, GroundPriceBean bean) {
		// 更改
		groundPriceService.updateBatchIsOpen(bean, map);
		// 参数
		groundPriceService.refresh(map, bean);
		// 数据
		bean = new GroundPriceBean();
		groundPriceService.selectGroundPriceList(map, bean);
		
		return "/ground/price/list";
	}
	
}