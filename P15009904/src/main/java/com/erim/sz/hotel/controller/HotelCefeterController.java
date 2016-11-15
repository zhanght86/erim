package com.erim.sz.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.HotelCefeteriaBean;
import com.erim.sz.hotel.service.HotelCefeteriaService;
import com.erim.sz.hotel.service.HotelDetailService;

/**
 * 
 * @类名: HotelMeetingController
 * @描述: 酒店餐厅信息实体操作控制层
 * @作者: 王赛
 * @创建时间: 2015年11月3日 下午9:40:15
 *
 */
@Controller
public class HotelCefeterController {
	
	@Autowired
	private HotelCefeteriaService hotelCefeteriaService;
	@Autowired
	private HotelDetailService hotelDetailService;
	
	/**
	 * @描述: 餐厅列表页
	 * @作者: 王赛
	 * @创建时间: 2015年11月9日 下午8:57:05
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/hotel/Cefeteria/updatePage")
	public String CefeteriaPage(ModelMap map, HotelCefeteriaBean bean) {
		
		// 获取餐厅信息
		hotelCefeteriaService.selectCafeteriaByHotelId(map, bean);
		// 字典
		hotelDetailService.setCode(map);
		
		return "/hotel/cafeteria/insert";
	}
	/**
	 * 
	 * @方法名: deleteCefeteria
	 * @描述: 删除餐厅信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月3日 下午10:06:28 
	 * @param id
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/hotel/Cefeteria/delete")
	public Integer deleteCefeteria(Integer id) {
		Integer result = hotelCefeteriaService.deleteCafeter(id);
		return result;
	}
	
	/**
	 * @方法名: updateCefeteria
	 * @描述: 修改餐厅信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月3日 下午10:12:47 
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/hotel/Cefeteria/update")
	public Integer updateCefeteria(ModelMap map,HotelCefeteriaBean bean) {
		return hotelCefeteriaService.insertCefeteriaBean(bean);
	}
	
	/**
	 * @方法名: view
	 * @描述: 跳转修改页面根据餐厅id查询一条信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月4日 上午9:52:29 
	 * @param model
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/hotel/Cefeteria/view")
    public String view(ModelMap model,HotelCefeteriaBean bean){
		
		// 字典
		hotelDetailService.setCode(model);
    	// 根据ID获取一条数据
		hotelCefeteriaService.selectCefeteriaById(model, bean);
    	// 获取数据列表
		hotelCefeteriaService.selectCafeteriaByHotelId(model, bean);
    	
    	return "/hotel/cafeteria/update";
    }
}
