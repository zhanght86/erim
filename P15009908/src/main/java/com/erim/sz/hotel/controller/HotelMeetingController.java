package com.erim.sz.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.HotelMeetingBean;
import com.erim.sz.hotel.service.HotelDetailService;
import com.erim.sz.hotel.service.HotelMeetingService;

/**
 * 
 * @类名: HotelMeetingController
 * @描述: 酒店会议室信息实体操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年10月3日 下午9:40:15
 *
 */
@Controller
public class HotelMeetingController {

	@Autowired
	private HotelMeetingService hotelMeetingService;
	@Autowired
	private HotelDetailService hotelDetailService;
	
	/**
	 * 
	 * @方法名: deleteMeeting
	 * @描述: 删除会议室信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午5:33:59 
	 * @param id
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/hotel/meeting/delete")
	public Integer deleteMeeting(Integer id) {
		Integer result = hotelMeetingService.deleteMeeting(id);
		return result;
	}
	
	/**
	 * 
	 * @方法名: updeteMeeting
	 * @描述: 修改会议室信息页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午5:43:00 
	 * @param id
	 * @return
	 *
	 */
	@RequestMapping("/hotel/meeting/updatePage")
	public String meetinsertPage(ModelMap map, HotelMeetingBean bean) {
		
		// 获取会议室信息
		hotelMeetingService.selectMeetingByHotelId(map, bean);
		// 字典
		hotelDetailService.setCode(map);
		
		return "/hotel/meeting/meetupdate";
	}
	
	/**
	 * 
	 * @方法名: updateMeeting
	 * @描述: 修改会议室信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午6:29:38 
	 * @param bean
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/hotel/meeting/update")
	public Integer updateMeeting(HotelMeetingBean bean) {
		return hotelMeetingService.updateMeeting(bean);
	}
}
