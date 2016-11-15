package com.erim.sz.planeticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.PlaneticketPriceBean;
import com.erim.sz.planeticket.service.PlaneticketPriceService;

/**
 * @描述: 飞机票量价信息实体操作控制层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月8日 下午3:49:41
 */
@Controller
public class PlaneticketPriceController {

	@Autowired
	private PlaneticketPriceService planeticketPriceService;
	
	/**
	 * @描述: 查询
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午6:13:45
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/planeticket/price/list")
	public String showPlaneticketPricePage(ModelMap map, PlaneticketPriceBean bean) {
		
		String portal = bean.getPortal();
		String page = "";

		// 机票管理 初始化量价
		if ("01".equals(portal)) {
			planeticketPriceService.showPlaneticketPricePortal(map, bean);
			
			page = "/planeticket/price/list";
		}
		// 机票管理 时间向前选择按钮
		if ("02".equals(portal)) {
			planeticketPriceService.showListForward(map, bean);
			
			page = "/planeticket/price/list";
		}
		// 机票管理 时间向后选择按钮
		if ("03".equals(portal)) {
			planeticketPriceService.showListBackwards(map, bean);
			
			page = "/planeticket/price/list";
		}
		// 机票管理 刷新页面
		if ("04".equals(portal)) {
			planeticketPriceService.refresh(map, bean);
			
			page = "/planeticket/price/list";
		}
		// 同业资源 初始化
		if ("05".equals(portal)) {
			planeticketPriceService.showPlaneticketPricePortal(map, bean);
			
			page = "/planeticket/sametown/price";
		}
		// 同业资源 时间向前选择按钮
		if ("06".equals(portal)) {
			planeticketPriceService.showListForward(map, bean);
			
			page = "/planeticket/sametown/price";
		}
		// 同业资源 时间向后选择按钮
		if ("07".equals(portal)) {
			planeticketPriceService.showListBackwards(map, bean);
			
			page = "/planeticket/sametown/price";
		}
		// 机票管理 更改当前选择舱位
		if ("08".equals(portal)) {
			planeticketPriceService.skipPtdClass(map, bean);
			
			page = "/planeticket/price/list";
		}
		// 同业资源 更改当前选择舱位
		if ("09".equals(portal)) {
			planeticketPriceService.skipPtdClass(map, bean);
			
			page = "/planeticket/sametown/price";
		}
		
		// 获取数据
		bean = new PlaneticketPriceBean();
		planeticketPriceService.selectPlaneticketPriceList(map, bean);
		
		return page;
	}
	
	/**
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午6:11:28
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/planeticket/price/insert")
	public Integer insertPrice(ModelMap map, PlaneticketPriceBean bean) {
		return planeticketPriceService.insertPrice(map, bean);
	}
	
	/**
	 * @描述: 更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午6:11:42
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/planeticket/price/updateIsOpen")
	public String updateIsOpen(ModelMap map, PlaneticketPriceBean bean) {
		
		// 执行更改
		planeticketPriceService.updateIsOpen(bean);
		// 参数
		planeticketPriceService.refresh(map, bean);
		// 数据
		bean = new PlaneticketPriceBean();
		planeticketPriceService.selectPlaneticketPriceList(map, bean);
		return "/planeticket/price/list";
	}
	
	/**
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午6:11:59
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/planeticket/price/updatePrice")
	public Integer updatePrice(ModelMap map, PlaneticketPriceBean bean) {
		return planeticketPriceService.updatePrice(bean);
	}
	
	/**
	 * @描述: 批量更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月8日 下午6:12:10
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/planeticket/price/updateBatchIsOpen")
	public String updateBatchIsOpen(ModelMap map, PlaneticketPriceBean bean) {
		// 更改
		planeticketPriceService.updateBatchIsOpen(bean, map);
		// 参数
		planeticketPriceService.refresh(map, bean);
		// 数据
		bean = new PlaneticketPriceBean();
		planeticketPriceService.selectPlaneticketPriceList(map, bean);
		
		return "/planeticket/price/list";
	}
}
