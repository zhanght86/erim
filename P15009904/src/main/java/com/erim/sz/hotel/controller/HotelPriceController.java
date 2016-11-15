package com.erim.sz.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.HotelPriceBean;
import com.erim.sz.hotel.service.HotelPriceService;

/**
 * @类名: HotelPriceController
 * @描述: 酒店量价信息实体操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年10月5日 下午1:23:30
 */
@Controller
public class HotelPriceController {
	
	@Autowired
	private HotelPriceService hotelPriceService;

	/**
	 * @方法名: showListForward
	 * @描述: 酒店量价管理列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月5日 下午4:49:59 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/hotel/price/listPagePortal")
	public String showListPortal(ModelMap map, HotelPriceBean bean) {
		
		// 入口号
		String portal = bean.getPortal();
		// 返回页面
		String page = "";
		
		// 01酒店管理 初始化
		if ("01".equals(portal)) {
			hotelPriceService.showListPortal(map, bean);
			
			// 获取数据
			bean = new HotelPriceBean();
			hotelPriceService.selectPriceList(map, bean);
			
			page = "/hotel/price/list";
		}
		// 02酒店管理 房型选择
		if ("02".equals(portal)) {
			hotelPriceService.showListRoom(map, bean);
			
			// 获取数据
			bean = new HotelPriceBean();
			hotelPriceService.selectPriceList(map, bean);
			
			page = "/hotel/price/list";
		}
		// 03酒店管理  时间向前选择
		if ("03".equals(portal)) {
			hotelPriceService.showListForward(map, bean);
			
			// 获取数据
			bean = new HotelPriceBean();
			hotelPriceService.selectPriceList(map, bean);
			
			page = "/hotel/price/list";
		}
		// 04酒店管理 时间向后选择
		if ("04".equals(portal)) {
			hotelPriceService.showListBackwards(map, bean);
			
			// 获取数据
			bean = new HotelPriceBean();
			hotelPriceService.selectPriceList(map, bean);
			
			page = "/hotel/price/list";
		}
		// 05酒店管理 刷新页面
		if ("05".equals(portal)) {
			hotelPriceService.insertRefresh(map, bean);
			
			// 获取数据
			bean = new HotelPriceBean();
			hotelPriceService.selectPriceList(map, bean);
			
			page = "/hotel/price/list";
		}
		// 06同业资源 初始化
		if ("06".equals(portal)) {
			hotelPriceService.showTownListPortal(map, bean);
			
			// 获取数据
			bean = new HotelPriceBean();
			hotelPriceService.selectPriceList(map, bean);
			
			page = "/hotel/sametown/price";
		}
		// 07同业资源 时间向前选择
		if ("07".equals(portal)) {
			hotelPriceService.showListForward(map, bean);
			
			// 获取数据
			bean = new HotelPriceBean();
			hotelPriceService.selectPriceList(map, bean);
			
			page = "/hotel/sametown/price";
		}
		// 08同业资源 时间向后选择
		if ("08".equals(portal)) {
			hotelPriceService.showListBackwards(map, bean);
			
			// 获取数据
			bean = new HotelPriceBean();
			hotelPriceService.selectPriceList(map, bean);
			
			page = "/hotel/sametown/price";
		}
		// 09同业资源 房型选择
		if ("09".equals(portal)) {
			hotelPriceService.showListRoom(map, bean);
			
			// 获取数据
			bean = new HotelPriceBean();
			hotelPriceService.selectPriceList(map, bean);
			
			page = "/hotel/sametown/price";
		}
		
		return page;
	}
	
	/**
	 * @方法名: getRoomNum
	 * @描述: 查询是否有房型信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月30日 下午8:29:04 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/hotel/price/getRoomNum")
	public Integer getRoomNum(ModelMap map, HotelPriceBean bean) {
		return hotelPriceService.getRoomNum(map, bean);
	}
	
	/**
	 * @方法名: insertPrice
	 * @描述: 新增量价管理信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月6日 上午11:07:04 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/hotel/price/insertPrice")
	public Integer insertPrice(ModelMap map, HotelPriceBean bean) {
		
		// 插入数据
		return hotelPriceService.insertPrice(map, bean);
	}
	
	/**
	 * @方法名: updateOpen
	 * @描述: 开关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月8日 下午5:49:27 
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/hotel/price/updateOpen")
	public String updateOpen(ModelMap map, HotelPriceBean bean) {
		
		// 开关房
		hotelPriceService.updateOpen(bean);
		// 获取Session参数
		hotelPriceService.insertRefresh(map, bean);
		// 获取数据
		bean = new HotelPriceBean();
		hotelPriceService.selectPriceList(map, bean);
		
		return "/hotel/price/list";
	}
	
	/**
	 * @方法名: updatePrice
	 * @描述: 修改房量
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月8日 下午6:31:02 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/hotel/price/updatePrice")
	public Integer updatePrice(ModelMap map, HotelPriceBean bean) {
		
		return hotelPriceService.updatePrice(bean);
	}
	
	/**
	 * @方法名: updateBatchOpen
	 * @描述: 批量关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月8日 下午7:38:08 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/hotel/price/updateBatchOpen")
	public String updateBatchOpen(ModelMap map, HotelPriceBean bean) {
		
		// 批量关房
		hotelPriceService.updateBatchIsOpen(bean,map);
		// 获取Session参数
		hotelPriceService.insertRefresh(map, bean);
		// 获取数据
		bean = new HotelPriceBean();
		hotelPriceService.selectPriceList(map, bean);
		
		return "/hotel/price/list";
	}
	
}
