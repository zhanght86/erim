package com.erim.sz.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.ManagementPriceBean;
import com.erim.sz.management.service.ManagementPriceService;

/**
 * @描述: 签证价格管理信息实体操作控制层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月7日 下午3:15:30
 */
@Controller
public class ManagementPriceController {

	@Autowired
	private ManagementPriceService managementPriceService;
	
	/**
	 * @描述: 查询
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午3:17:31
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/management/price/list")
	public String showManagementPricePage(ModelMap map, ManagementPriceBean bean) {
		
		String portal = bean.getPortal();
		String page = "";
		
		// 签证管理 初始化量价
		if ("01".equals(portal)) {
			managementPriceService.managementPricePortal(map, bean);
			page = "/management/price/list";
		}
		// 签证管理 时间向前选择
		if ("02".equals(portal)) {
			managementPriceService.showListForward(map, bean);
			page = "/management/price/list";
		}
		// 签证管理 时间向后选择
		if ("03".equals(portal)) {
			managementPriceService.showListBackwards(map, bean);
			page = "/management/price/list";
		}
		// 签证管理 刷新页面
		if ("04".equals(portal)) {
			managementPriceService.refresh(map, bean);
			page = "/management/price/list";
		}
		// 同业管理 初始化量价
		if ("05".equals(portal)) {
			managementPriceService.managementPricePortal(map, bean);
			page = "/management/sametown/price";
		}
		// 同业管理向前选择
		if ("06".equals(portal)) {
			managementPriceService.showListForward(map, bean);
			page = "/management/sametown/price";
		}
		// 同业管理向后选择
		if ("07".equals(portal)) {
			managementPriceService.showListBackwards(map, bean);
			page = "/management/sametown/price";
		}
		
		// 获取数据
		bean = new ManagementPriceBean();
		managementPriceService.selectManagementPriceList(map, bean);
		
		return page;
	}
	
	/**
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午3:22:18
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/management/price/insertPrice")
	public Integer insertPrice(ModelMap map, ManagementPriceBean bean) {
		return managementPriceService.insertPrice(map, bean);
	}
	
	/**
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午3:23:09
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/management/price/updatePrice")
	public Integer updatePrice(ModelMap map, ManagementPriceBean bean) {
		return managementPriceService.updatePrice(bean);
	}
}
