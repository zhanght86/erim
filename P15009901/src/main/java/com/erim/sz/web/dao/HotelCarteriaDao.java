package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelCefeteriaBean;

/**
 * 
 * @类名: HotelCarteriaDao
 * @描述: 酒店餐厅
 * @作者: 王赛
 * @创建时间: 2015年11月23日 下午5:07:06
 *
 */
@Repository("hotelcarteriadao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelCarteriaDao extends BaseDao {

	/**
	 * 
	 * @方法名: selectList
	 * @描述: 酒店餐厅
	 * @作者: 王赛
	 * @创建时间: 2015年11月23日 下午5:08:09 
	 * @param Bean
	 * @return
	 *
	 */
	public List<HotelCefeteriaBean> selectList(HotelCefeteriaBean Bean){
		return this.getSqlSession().selectList("hotelcarteria.selectList", Bean);
	}
}
