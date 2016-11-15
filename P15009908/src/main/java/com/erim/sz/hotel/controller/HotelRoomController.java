package com.erim.sz.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.HotelRoomBean;
import com.erim.sz.hotel.service.HotelRoomService;

/**
 * 
 * @类名: HotelRoomController
 * @描述: 酒店房型信息实体操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年10月4日 下午3:29:11
 *
 */
@Controller
public class HotelRoomController {

	@Autowired
	private HotelRoomService hotelRoomService;
	
	/**
	 * 
	 * @方法名: showList
	 * @描述: 获取房型信息列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午4:23:28 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@RequestMapping(value = "/hotel/room/listPage")
	public String showList(ModelMap map, @ModelAttribute("roomBean") HotelRoomBean bean) {
		
		hotelRoomService.selectHotelRoomList(map, bean);
		return "/hotel/room/list";
	}

	/**
	 * 
	 * @方法名: showHotelRoomList
	 * @描述: 新增成功后展示房型信息 - 废弃
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午6:20:08 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@RequestMapping("/hotel/room/showListPage")
	public String showHotelRoomList(ModelMap map, HotelRoomBean bean) {
		
		// 获取数据
		hotelRoomService.showHotelRoomList(map, bean);
		
		return "/hotel/room/list";
	}
	
	/**
	 * 
	 * @方法名: insertRoomPage
	 * @描述: 打开新增房型信息页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午4:56:53 
	 * @param map
	 * @return
	 *
	 */
	@RequestMapping(value = "/hotel/room/insertPage")
	public String insertRoomPage(ModelMap map, Integer hdlId) {
		// 查询字典
    	hotelRoomService.setCode(map);
    	map.addAttribute("hdlId", hdlId);
		return "/hotel/room/insert";
	}
	
	/**
	 * 
	 * @方法名: insertRoom
	 * @描述: 保存房型信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午5:43:25 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/hotel/room/insertRoom")
	public Integer insertRoom(HotelRoomBean bean) {
		
		// 保存信息
		return hotelRoomService.insertRoom(bean);
		
	}
	
	/**
	 * 
	 * @方法名: updateStatus
	 * @描述: 更改上下架状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午7:58:11 
	 * @param bean
	 * @return
	 *
	 */
	@RequestMapping("/hotel/room/updateStatus")
	public String updateStatus(ModelMap map, HotelRoomBean bean) {
		
		// 更改上架状态
		hotelRoomService.updateStatus(bean);
		
		// 获取数据
		hotelRoomService.showHotelRoomList(map, bean);
		
		return "/hotel/room/list";
	}
	
	/**
	 * 
	 * @方法名: updateRoomPage
	 * @描述: 打开修改房型信息页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午8:29:16 
	 * @param map
	 * @return
	 *
	 */
	@RequestMapping(value = "/hotel/room/updatePage")
	public String updateRoomPage(ModelMap map, HotelRoomBean bean) {
		// 查询字典
    	hotelRoomService.setCode(map);
    	
		hotelRoomService.getRoomById(map, bean);
		
		return "/hotel/room/update";
	}
	
	/**
	 * 
	 * @方法名: updateRoomSave
	 * @描述: 修改房型信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午9:01:31 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/hotel/room/updateRoom")
	public Integer updateRoomSave(ModelMap map, HotelRoomBean bean) {
		
		// 保存房型
		return hotelRoomService.updateRoom(bean);
		
	}
}
