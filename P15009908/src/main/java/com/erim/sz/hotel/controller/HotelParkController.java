package com.erim.sz.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.HotelParkBean;
import com.erim.sz.hotel.service.HotelDetailService;
import com.erim.sz.hotel.service.HotelParkService;

/**
 * @ClassName: HotelParkController 
 * @Description: TODO(酒店停车场信息实体操作控制层) 
 * @author    贺渊博
 * @date 2015年11月3日 下午10:54:28 
 */
@Controller
public class HotelParkController {
	
	@Autowired
	private HotelParkService hotelParkService;
	@Autowired
	private HotelDetailService hotelDetailService;
	
	/**
	 * @方法名: parkInsertPage
	 * @描述: 停车场列表页
	 * @作者: 王赛
	 * @创建时间: 2015年11月4日 下午4:42:00 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/hotel/park/insertPage")
	public String parkInsertPage(ModelMap map, HotelParkBean bean) {
		// 获取餐厅信息
		hotelParkService.selectParkByHotelId(map, bean);
		// 字典
		hotelDetailService.setCode(map);
		return "/hotel/park/insert";
	}
	
	/**
     * @方法名：updatePark 
     * @描述: 修改停车场信息
     * @作者： 贺渊博
     * @创建时间：2015年11月3日 下午11:06:40
     * @param bean
     * @return
     */
    @ResponseBody
	@RequestMapping("/hotel/park/savePark")
	public Integer savePark(ModelMap map,HotelParkBean bean) {
		
		return hotelParkService.savePark(bean);
		
	}
    
	/**
	 * 
	 * @方法名：deletePark 
	 * @描述: 删除停车场信息
	 * @作者： 贺渊博
	 * @创建时间：2015年11月3日 下午10:58:30
	 * @param id
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/hotel/park/delete")
	public Integer deletePark(Integer id){
		Integer result = hotelParkService.deletePark(id);
		return result;
	}
	
    /**
     * @方法名: view
     * @描述: 根据id查询跳转修改页面
     * @作者: 王赛
     * @创建时间: 2015年11月4日 下午4:49:18 
     * @param model
     * @param bean
     * @return
     */
    @RequestMapping(value = "/hotel/park/view")
    public String view(ModelMap model,HotelParkBean bean){
		// 字典
    	hotelParkService.setCode(model);
    	// 根据ID获取一条数据
    	hotelParkService.selectparkById(model, bean);
    	// 获取数据列表
    	hotelParkService.selectParkByHotelId(model, bean);
    	
    	return "/hotel/park/update";
    }
}
