package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelParkBean;

/**
 * 
 * @类名: HotelParkDao
 * @描述: 酒店停车场
 * @作者: 王赛
 * @创建时间: 2015年11月23日 下午4:55:43
 *
 */
@Repository("hotelparkDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelParkDao extends BaseDao {

	/**
	 * 
	 * @方法名: selectList
	 * @描述: 酒店停车场
	 * @作者: 王赛
	 * @创建时间: 2015年11月23日 下午4:56:53 
	 * @param parkBean
	 * @return
	 *
	 */
	public List<HotelParkBean> selectList(HotelParkBean parkBean){
		return this.getSqlSession().selectList("hotelpark.selectList", parkBean);
	}
}
