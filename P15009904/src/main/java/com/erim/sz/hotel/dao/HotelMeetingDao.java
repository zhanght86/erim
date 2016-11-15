package com.erim.sz.hotel.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelMeetingBean;

/**
 * 
 * @类名: HotelMeetingDao
 * @描述: 酒店会议室信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月3日 下午1:14:50
 *
 */
@Repository("hotelMeetingDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelMeetingDao extends BaseDao {

	/**
	 * @描述: 根据酒店基础信息ID获取会议室信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月9日 下午8:43:12
	 * @param id
	 * @return
	 */
	public List<HotelMeetingBean> selectMeetingByHotelId(Integer id) {
		List<HotelMeetingBean> list = getSqlSession().selectList("hotelmeeting.selectMeetingByHotelId", id);
		return list;
	}
	
	/**
	 * 
	 * @方法名: getMeetingById
	 * @描述: 根据会议室ID获取一条数据
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午5:58:29 
	 * @param Id
	 * @return
	 *
	 */
	public HotelMeetingBean getMeetingById(Integer id) {
		HotelMeetingBean model = getSqlSession().selectOne("hotelmeeting.selectMeetingById", id);
		return model;
	}
	
	/**
	 * 
	 * @方法名: insertMeetingBean
	 * @描述: 新增酒店会议室信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午2:17:17 
	 * @param bean
	 * @return
	 *
	 */
	public Integer insertMeetingBean(HotelMeetingBean bean) {
		
		return getSqlSession().insert("hotelmeeting.insert", bean);
	}
	
	/**
	 * 
	 * @方法名: deleteMeeting
	 * @描述: 删除一条会议室信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午5:15:59 
	 * @param id
	 * @return
	 *
	 */
	public Integer deleteMeeting(Integer id) {
		
		return getSqlSession().delete("hotelmeeting.delete", id);
	}
	
	/**
	 * 
	 * @方法名: updateMeeting
	 * @描述: 修改一条会议室信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午6:20:10 
	 * @param id
	 * @return
	 *
	 */
	public Integer updateMeeting(HotelMeetingBean bean) {
		return getSqlSession().update("hotelmeeting.update", bean);
	}
}
