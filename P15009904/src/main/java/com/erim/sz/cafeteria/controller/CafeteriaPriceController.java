package com.erim.sz.cafeteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.cafeteria.service.CafeteriaPriceService;
import com.erim.sz.common.bean.CafeteriaPackageBean;
import com.erim.sz.common.bean.CafeteriaPriceBean;

/**
 * @类名: CafeteriaPriceController
 * @描述: 特色餐套餐量价信息实体操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年10月18日 上午11:12:13
 */
@Controller
public class CafeteriaPriceController {

	@Autowired
	private CafeteriaPriceService cafeteriaPriceService;
	
	/**
	 * @方法名: showCafeteriaPricePage
	 * @描述: 列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 下午1:31:29 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/cafeteria/price/list")
	public String showCafeteriaPricePage(ModelMap map, CafeteriaPriceBean bean) {
		
		String portal = bean.getPortal();
		String page = "";
		
		// 01 套餐管理 量价初始化
		if ("01".equals(portal)) {
			cafeteriaPriceService.showCafeteriaPricePortal(map, bean);
			page = "/cafeteria/price/list";
		}
		// 02 套餐管理 时间向前选择
		if ("02".equals(portal)) {
			cafeteriaPriceService.showListForward(map, bean);
			page = "/cafeteria/price/list";
		}
		// 03 套餐管理 时间向后选择
		if ("03".equals(portal)) {
			cafeteriaPriceService.showListBackwards(map, bean);
			page = "/cafeteria/price/list";
		}
		// 04 套餐管理 刷新页面
		if ("04".equals(portal)) {
			cafeteriaPriceService.refresh(map, bean);
			page = "/cafeteria/price/list";
		}
		// 05 同业管理 初始化
		if ("05".equals(portal)) {
			cafeteriaPriceService.showPackagePricePortal(map, bean);
			page = "/cafeteria/sametown/price";
		}
		// 06 同业管理 时间向前选择
		if ("06".equals(portal)) {
			cafeteriaPriceService.showListForward(map, bean);
			page = "/cafeteria/sametown/price";
		}
		// 07 同业管理 时间向后选择
		if ("07".equals(portal)) {
			cafeteriaPriceService.showListBackwards(map, bean);
			page = "/cafeteria/sametown/price";
		}
		// 08 同业管理 套餐选择
		if ("08".equals(portal)) {
			cafeteriaPriceService.skipCafeteriaPackage(map, bean);
			page = "/cafeteria/sametown/price";
		}
		// 获取数据
		bean = new CafeteriaPriceBean();
		cafeteriaPriceService.selectCafeteriaPriceList(map, bean);
		return page;
	}
	
	/**
	 * @描述: 查询是否有套餐信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月22日 下午1:16:25
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/cafeteria/price/getPackageNum")
	public Integer getPackageNum(ModelMap map, CafeteriaPackageBean bean) {
		return  cafeteriaPriceService.getCafeteriaPackageNum(map, bean);
	}
	
	/**
	 * @方法名: insertPrice
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 下午1:32:42 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/cafeteria/price/insert")
	public Integer insertPrice(ModelMap map, CafeteriaPriceBean bean) {
		return cafeteriaPriceService.insertPrice(map, bean);
	}
	
	/**
	 * @方法名: updateIsOpen
	 * @描述: 更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 下午1:34:54 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/cafeteria/price/updateIsOpen")
	public String updateIsOpen(ModelMap map, CafeteriaPriceBean bean) {
		
		// 开关房
		cafeteriaPriceService.updateIsOpen(bean);
		// 页面参数
		cafeteriaPriceService.refresh(map, bean);
		// 数据
		bean = new CafeteriaPriceBean();
		cafeteriaPriceService.selectCafeteriaPriceList(map, bean);
		
		return "/cafeteria/price/list";
		
	}
	
	/**
	 * @方法名: updatePrice
	 * @描述: 修改量价信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 下午1:36:20 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/cafeteria/price/updatePrice")
	public Integer updatePrice(ModelMap map, CafeteriaPriceBean bean) {
		return cafeteriaPriceService.updatePrice(bean);
	}
	
	/**
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量更改出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 下午1:37:53 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/cafeteria/price/updateBatchIsOpen")
	public String updateBatchIsOpen(ModelMap map, CafeteriaPriceBean bean) {
		
		// 更改
		cafeteriaPriceService.updateBatchIsOpen(bean, map);
		// 页面参数
		cafeteriaPriceService.refresh(map, bean);
		// 数据
		bean = new CafeteriaPriceBean();
		cafeteriaPriceService.selectCafeteriaPriceList(map, bean);
		
		return "/cafeteria/price/list";
	}
}
