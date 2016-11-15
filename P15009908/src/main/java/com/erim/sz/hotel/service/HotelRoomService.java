package com.erim.sz.hotel.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelRoomBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.hotel.dao.HotelRoomDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: HotelRoomService
 * @描述: 酒店房型信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年10月4日 下午4:22:45
 *
 */
@Service("hotelRoomService")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelRoomService {

	@Autowired
	private HotelRoomDao hotelRoomDao;
	@Autowired
	private CodeService codeService;
	/**
	 * 
	 * @方法名: selectHotelRoomList
	 * @描述: 获取房型信息列表 - 从酒店基础信息列表过来， 需保存酒店基础ID到Session
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午4:23:09 
	 * @param map
	 * @param bean
	 *
	 */
	public void selectHotelRoomList(ModelMap map, HotelRoomBean bean) {
		
		bean.getPageLinkBean().setLimit(10);
		
		Integer hdlId = bean.getHdlId();
		
		// 从酒店基础模块进来，ID则已有，存入Session
		if (hdlId != null) {
			SecurityUtils.getSubject().getSession().setAttribute("hotelID", hdlId);
		} else {
			
			// 非酒店基础模块进来，查询房型数据列表，从Session获取酒店基础ID
			hdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("hotelID");
			bean.setHdlId(hdlId);
		}
		
		// 查询数据
		List<HotelRoomBean> list = hotelRoomDao.selectHotelRoomList(bean, map);
		
		map.addAttribute("hdlId", hdlId);
		map.addAttribute("roomList", list);
	}
	
	/**
	 * 
	 * @方法名: insertRoom
	 * @描述: 新增房型信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午6:00:47 
	 * @param bean
	 *
	 */
	public Integer insertRoom(HotelRoomBean bean) {
		
		// 创建时间
		bean.setHheCreatetime(new Date());
		// 创建用户
		bean.setHheCreateuser(CommonUtil.getLoginName());
		// 公司ID
		bean.setCpyId(CommonUtil.getCpyId());
		// 是否上架
		bean.setHheIsDelStatus(ErimConstants.YESORNO_YES);
		
		// 执行保存
		Integer result = hotelRoomDao.insertRoom(bean);
		
		return result;
		
	}
	
	/**
	 * 
	 * @方法名: showHotelRoomList
	 * @描述: 获取房型信息列表  
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午6:15:51 
	 * @param map
	 * @param bean
	 *
	 */
	public void showHotelRoomList(ModelMap map, HotelRoomBean bean) {
		
		
		List<HotelRoomBean> list = new ArrayList<HotelRoomBean>();
		// 获取酒店基础ID
		Integer hdlId = bean.getHdlId();
		
		// 当获取到ID后查询数据
		if (hdlId != null) {
			// 分页
			bean.getPageLinkBean().setLimit(10);
			// 执行查询
			list = hotelRoomDao.selectPageHotelRoomList(bean, map);
		}
		map.addAttribute("hdlId", hdlId);
		map.addAttribute("roomList", list);
	}
	
	
	/**
	 * 
	 * @方法名: setCode
	 * @描述: 放置字典
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月2日 下午7:38:01 
	 * @param model
	 *
	 */
	public void setCode(ModelMap model) {
		
		//加床
	    model.addAttribute("bed",       	   this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ADDBED));
	    //房间设施
	    model.addAttribute("roomequipment",    this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ROOMEQUIPMENT));
	   //一次性用品
	    model.addAttribute("supplies",    this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SUPPLIES));
	}
	
	/**
	 * 
	 * @方法名: updateStatus
	 * @描述: 更改上下架状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午7:57:15 
	 * @param bean
	 *
	 */
	public Integer updateStatus(HotelRoomBean bean) {
		
		Integer result = hotelRoomDao.updateStatus(bean);
		
		// 更改完成后，清空上架状态，留待查询时bean是空的
		bean.setHheIsDelStatus(null);
		
		return result;
	}
	
	/**
	 * 
	 * @方法名: getRoomById
	 * @描述: 根据房型ID获取一条数据，返回到修改页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午8:40:40 
	 * @param bean
	 * @return
	 *
	 */
	public void getRoomById(ModelMap map, HotelRoomBean bean) {
		
		HotelRoomBean model = new HotelRoomBean();
		
		Integer id = bean.getId();
		if (id != null && !"".equals(id)) {
			model = hotelRoomDao.getRoombyId(bean);
		}
		// 酒店ID
		Integer hdlId = model.getHdlId();
		map.addAttribute("hdlId", hdlId);
		map.addAttribute("roomBean", model);
	}
	
	/**
	 * 
	 * @方法名: updateRoom
	 * @描述: 修改房型信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午9:07:37 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateRoom(HotelRoomBean bean) {
		
		Integer result = hotelRoomDao.updateRoom(bean);
		return result;
	}
}
