package com.erim.sz.sametown.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelDetailBean;

/**
 * 
 * @类名: HotelDetailDao
 * @描述: 酒店
 * @作者: 李庆
 * @创建时间: 2015年10月25日 下午5:07:06
 *
 */
@Repository("hotelDetailDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelDetailDao extends BaseDao {
	
	/**
	 * 
	 * @方法名: selectPageHotelList
	 * @描述: 分页查询酒店信息
	 * @作者: 李庆
	 * @创建时间: 2015年10月27日 下午2:20:49 
	 * @param bean
	 * @param map
	 * @return
	 *
	 */

	public List<HotelDetailBean> selectPageHotelList(BaseBean bean, ModelMap map) {
		
		List<HotelDetailBean> list = getSqlSession().selectList("hoteldetail.selectPageHotelList", bean, 
				new RowBounds(bean.getPageLinkBean().getStart(), bean.getPageLinkBean().getLimit()));
		return list;
	}
}
