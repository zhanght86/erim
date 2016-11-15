package com.erim.sz.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.common.bean.HotelMeetingBean;
import com.erim.sz.hotel.dao.HotelDetailDao;
import com.erim.sz.hotel.dao.HotelMeetingDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: HotelMeetingService
 * @描述: 酒店会议室信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年10月11日 上午9:50:22
 *
 */
@Service("hotelMeetingService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelMeetingService {

	@Autowired
	private HotelMeetingDao hotelMeetingDao;
	@Autowired
	private CodeService codeService;
	@Autowired
	private HotelDetailDao hotelDetailDao;
	
	/**
	 * @描述: 根据酒店ID查询酒店会议室信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月9日 下午8:49:24
	 * @param map
	 * @param bean 酒店会议室
	 */
	public void selectMeetingByHotelId(ModelMap map, HotelMeetingBean bean) {
		// 酒店ID
		Integer hdlId = bean.getHdlId();
		// 根据酒店基础ID查询酒店名称，返回页面
		HotelDetailBean hotelBean = hotelDetailDao.getHotelDetailById(hdlId);
		map.addAttribute("hotelBean", hotelBean);
		// 会议室ID
		Integer id = bean.getId();
		List<HotelMeetingBean> list = new ArrayList<HotelMeetingBean>();
		if (hdlId != null) {
			// 根据酒店基础信息ID获取所有该酒店会议室
			list = hotelMeetingDao.selectMeetingByHotelId(hdlId);
			// 转码
			for (int i = 0; i < list.size(); i++) {
				HotelMeetingBean meeting = list.get(i);
				// 会议室人数
				Integer numSta = meeting.getHmgPersonnum();
				Integer numEnd = meeting.getHmgPersonNumEnd();
				if (numSta != null && numEnd != null) {
					meeting.setPersonNum(numSta + "~" + numEnd + "人");
				}
				// 摆放形式
				String hmgShape = meeting.getHmgShape();
				if (hmgShape != null && !"".equals(hmgShape)) {
					String str = codeService.getValueByCodeKeys(DictionaryUtil.SHAPE, hmgShape);
					meeting.setHmgShape(str);
				}
			}
		}
		// 该酒店的所有会议室
		map.addAttribute("meetingList", list);
		// 根据会议室ID获取信息
		HotelMeetingBean meeting = hotelMeetingDao.getMeetingById(id);
		map.addAttribute("meeting", meeting);
	}
	
	/**
	 * 
	 * @方法名: insertMeetingBean
	 * @描述: 保存会议室信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午2:25:28 
	 * @param bean
	 * @return
	 *
	 */
	public Integer insertMeetingBean(HotelMeetingBean bean) {
		
		Integer hdlId = bean.getHdlId();
		if (hdlId != null) {
			return hotelMeetingDao.insertMeetingBean(bean);
		}
		return CommonUtil.ERROR;
	}
	
	/**
	 * 
	 * @方法名: deleteMeeting
	 * @描述: 删除一条会议室信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午5:18:41 
	 * @param id
	 * @return
	 *
	 */
	public Integer deleteMeeting(Integer id) {
		
		Integer result = hotelMeetingDao.deleteMeeting(id);
		return result;
	}
	
	/**
	 * 
	 * @方法名: updateMeeting
	 * @描述: 修改一条会议室信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午6:28:07 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateMeeting(HotelMeetingBean bean) {
		Integer result = hotelMeetingDao.updateMeeting(bean);
		return result;
	}
}
