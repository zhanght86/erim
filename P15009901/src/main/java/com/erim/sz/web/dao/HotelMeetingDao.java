package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelMeetingBean;

/**
 * 
 * @类名: HotelMeetingDao
 * @描述: 酒店会议室
 * @作者: 王赛
 * @创建时间: 2015年11月23日 下午4:39:02
 *
 */
@Repository("hotelmeetDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelMeetingDao extends BaseDao {

	/**
	 * 
	 * @方法名: selectList
	 * @描述: 酒店会议室
	 * @作者: 王赛
	 * @创建时间: 2015年11月23日 下午4:39:41 
	 * @param roomBean
	 * @return
	 *
	 */
	public List<HotelMeetingBean> selectList(HotelMeetingBean meetBean){
		return this.getSqlSession().selectList("hotelmeet.selectList", meetBean);
	}
}
