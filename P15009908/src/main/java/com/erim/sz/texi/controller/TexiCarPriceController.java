package com.erim.sz.texi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.TexiCarPriceBean;
import com.erim.sz.texi.service.TexiCarPriceService;

/**
 * 
 * @类名: TexiCarPriceController
 * @描述: 租车管理包车量价管理信息实体操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年10月15日 上午10:14:37
 *
 */
@Controller
public class TexiCarPriceController {

	@Autowired
	private TexiCarPriceService texiCarPriceService;
	
	/**
	 * @方法名: showCarPricePage
	 * @描述: 包车量价管理信息列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 上午10:16:27 
	 * @param map
	 * @return
	 */
	@RequestMapping("/texi/car/carPricePage")
	public String showCarPricePage(ModelMap map, TexiCarPriceBean bean) {
		
		String portal = bean.getDicPortal();
		// 第一入口
		if ("01".equals(portal)) {
			// 获取页面参数
			texiCarPriceService.showCarPricePortal(map, bean);
			
			// 获取数据
			bean = new TexiCarPriceBean();
			texiCarPriceService.selectCarPirceList(map, bean);
		}
		// 时间向前选择
		if ("02".equals(portal)) {
			texiCarPriceService.showListForward(map, bean);
			
			// 获取数据
			bean = new TexiCarPriceBean();
			texiCarPriceService.selectCarPirceList(map, bean);
		}
		// 时间向后选择
		if ("03".equals(portal)) {
			texiCarPriceService.showListBackwards(map, bean);
			
			// 获取数据
			bean = new TexiCarPriceBean();
			texiCarPriceService.selectCarPirceList(map, bean);
		}
		// 选择包车类型
		if ("04".equals(portal)) {
			texiCarPriceService.showListCarType(map, bean);
			
			// 数据
			bean = new TexiCarPriceBean();
			texiCarPriceService.selectCarPirceList(map, bean);
		}
		// 刷新
		if ("05".equals(portal)) {
			texiCarPriceService.refresh(map, bean);
			
			// 获取数据
			bean = new TexiCarPriceBean();
			texiCarPriceService.selectCarPirceList(map, bean);
		}
		
		// 获取车辆名称
		texiCarPriceService.getTdlName(map, bean);
		
		return "/texi/car/carPrice";
	}
	
	/**
	 * 
	 * @方法名: insertCarPrice
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午5:45:24 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/texi/car/insertPrice")
	public Integer insertCarPrice(ModelMap map, TexiCarPriceBean bean) {
		return texiCarPriceService.insertPrice(map, bean);
	}
	
	/**
	 * 
	 * @方法名: updateIsOpen
	 * @描述: 修改上架状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午5:47:28 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@RequestMapping("/texi/car/updateIsOpen")
	public String updateIsOpen(ModelMap map, TexiCarPriceBean bean) {
		
		// 开关房
		texiCarPriceService.updateIsOpen(bean);
		// 参数
		texiCarPriceService.refresh(map, bean);
		// 数据
		bean = new TexiCarPriceBean();
		texiCarPriceService.selectCarPirceList(map, bean);
		
		return "/texi/car/carPrice";
	}
	
	/**
	 * 
	 * @方法名: updatePrice
	 * @描述: 修改房量
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午5:48:50 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/texi/car/updatePrice")
	public Integer updatePrice(ModelMap map, TexiCarPriceBean bean) {
		
		return texiCarPriceService.updatePrice(bean);
	}
	
	/**
	 * 
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午5:50:22 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@RequestMapping("/texi/car/updateBatchIsOpen")
	public String updateBatchIsOpen(ModelMap map, TexiCarPriceBean bean) {
		// 批量关房
		texiCarPriceService.updateBatchIsOpen(bean, map);
		// 参数
		texiCarPriceService.refresh(map, bean);
		// 数据
		bean = new TexiCarPriceBean();
		texiCarPriceService.selectCarPirceList(map, bean);
		
		return "/texi/car/carPrice";
	}
	
}
