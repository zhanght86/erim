package com.erim.sz.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.common.bean.HotelMeetingBean;
import com.erim.sz.hotel.service.HotelDetailService;
import com.erim.sz.hotel.service.HotelMeetingService;

/**
 * @类名: HotelDetailController
 * @描述: 酒店实体操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年10月2日 下午3:41:57
 */
@Controller
public class HotelDetailController {

	@Autowired
	private HotelDetailService  hotelDetailService;
	@Autowired
	private HotelMeetingService hotelMeetingService;
	
	/**
     * @Description: 同城酒店
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/hotel/detail/sametown")
    public String sametown(ModelMap model, @ModelAttribute("hotelDetail") HotelDetailBean hotelDetailBean) throws ErimException {
    	
    	hotelDetailService.showHotelTown(model, hotelDetailBean);
    	hotelDetailService.setCode(model);
        return "/hotel/sametown/list";
    }
    
	/**
	 * @方法名: showHotelList
	 * @描述: 酒店信息列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月2日 下午4:11:42 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping(value="/hotel/detail/list")
	public String showHotelList(ModelMap map, @ModelAttribute("hotelDetail") HotelDetailBean bean) {
		// 获取数据
		hotelDetailService.selectPageHotelList(map, bean);
		
		return "/hotel/detail/list";
	}
	
	/**
	 * 
	 * @方法名: insertPage
	 * @描述: 新增页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月2日 下午7:21:27 
	 * @param map
	 * @return
	 *
	 */
	@RequestMapping("/hotel/detail/insertPage")
	public String insertPage(ModelMap map) {
		
		// 查询字典
    	hotelDetailService.setCode(map);
    	
		return "/hotel/detail/insert";
	}
	
	/**
	 * 
	 * @方法名: hotelSave
	 * @描述: 保存酒店基础信息ID到Session
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月2日 下午9:14:21 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/hotel/detail/hotelSave")
	public Integer hotelSave(ModelMap map, HotelDetailBean bean) {
		// 成功返回1 失败返0
		return hotelDetailService.insertHotel(bean);
	}
	
	/**
	 * @描述: 打开酒店会议室新增页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月9日 下午8:39:06
	 * @param map
	 * @param id 酒店基础ID
	 * @return
	 */
	@RequestMapping(value = "/hotel/detail/meetinsertPage")
	public String meetinsertPage(ModelMap map,Integer id) {
		
		// 获取会议室信息
		hotelDetailService.selectMeetingByHotelId(map, id);
		// 字典
		hotelDetailService.setCode(map);
		
		return "/hotel/meeting/meetinsert";
	}
	
	/**
	 * 
	 * @方法名: meetingSave
	 * @描述: 保存会议室信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午2:11:05 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/hotel/meeting/insert")
	public Integer meetingSave(ModelMap map, HotelMeetingBean bean) {
		
		return hotelMeetingService.insertMeetingBean(bean);
	}
	
	/**
	 * 
	 * @方法名: cafeteriaPage
	 * @描述: 餐厅信息页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午3:00:48 
	 * @param map
	 * @return
	 *
	 */
	@RequestMapping(value = "/hotel/detail/cafeteriaPage")
	public String cafeteriaPage(ModelMap map, Integer id) {
		// 字典
		hotelDetailService.setCode(map);
		
		// 查询是否有餐厅信息
		hotelDetailService.getHotelDetailById(map, id);
		
		return "/hotel/cafeteria/insert";
	}
	
	/**
	 * 
	 * @方法名: insertCafeteria
	 * @描述: 新增餐厅信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午4:07:18 
	 * @param bean
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/hotel/detail/insertCafeteria")
	public Integer insertCafeteria(HotelDetailBean bean) {
		
		return hotelDetailService.insertCafeteria(bean);
	}
	
	/**
	 * @方法名: updateHotel
	 * @描述: 修改酒店基础信息页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午8:39:20 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/hotel/detail/updatePage")
	public String updateHotel(ModelMap map, Integer id) {
		// 字典
		hotelDetailService.setCode(map);
		
		hotelDetailService.showUpdateHotelPage(map, id);
		
		return "/hotel/detail/update";
	}
	
	/**
	 * 
	 * @方法名: updateHotel
	 * @描述: 修改酒店基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午9:27:26 
	 * @param bean
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/hotel/detail/update")
	public Integer updateHotel(HotelDetailBean bean) {
		return hotelDetailService.updateHotel(bean);
	}
	/**
	 * 
	 * @描述: 跳转酒店的预定方式
	 * @作者: （李庆）
	 * @创建时间: 2015年11月28日 下午3:07:10
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping("/hotel/detail/scheduledPage")
	public String updateScheduled(ModelMap map, Integer id) {
		// 字典
		hotelDetailService.setCode(map);
		
		hotelDetailService.showUpdateHotelPage(map, id);
		
		return "/hotel/detail/scheduled";
	}
	/**
	 * 修改酒店预定方法
	 * @描述: 
	 * @作者: （李庆）
	 * @创建时间: 2015年11月28日 下午3:07:51
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/hotel/detail/scheduled")
	public Integer updateScheduled(HotelDetailBean bean) {
		return hotelDetailService.updateHotel1(bean);
	}
	/**
	 * 
	 * @方法名: updateIsDelStatus
	 * @描述: 更改是否上架
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 上午9:41:46 
	 * @param bean
	 * @return
	 *
	 */
	@RequestMapping("/hotel/detail/updateIsDelStatus")
	public String updateIsDelStatus(ModelMap map, HotelDetailBean bean) {
		
		// 修改状态
		hotelDetailService.updateIsDelStatus(bean);
		
		// 获取数据列表
		hotelDetailService.selectPageHotelList(map, bean);
		
		return "/hotel/detail/list";
	}
	
}
