package com.erim.sz.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelRoomBean;

/**
 * @类名: HotelRoomDao
 * @描述: 酒店房型信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月4日 下午3:32:06
 */
@Repository("hotelRoomDao")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelRoomDao extends BaseDao {

	
	/**
	 * @方法名: selectHotelRoomList
	 * @描述: 查询房型信息列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午4:18:12 
	 * @param bean
	 * @return
	 */
	public List<HotelRoomBean> selectPageHotelRoomList(BaseBean bean, ModelMap map) {
		return getSqlSession().selectList("hotelroom.selectPageHotelRoomList", bean, 
					new RowBounds(bean.getPageLinkBean().getStart(), bean.getPageLinkBean().getLimit()));
	}
	
	/**
	 * @描述: 搜索数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月4日 下午9:10:19
	 * @param bean
	 * @param map
	 * @return
	 */
	public List<HotelRoomBean> selectHotelRoomList(BaseBean bean, ModelMap map) {
		return getSqlSession().selectList("hotelroom.selectPageHotelRoomList", bean);
	}

	/**
	 * @方法名: insertRoom
	 * @描述: 保存房型信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午5:53:40 
	 * @param bean
	 * @return
	 *
	 */
	public Integer insertRoom(HotelRoomBean bean) {
		return getSqlSession().insert("hotelroom.insertRoom", bean);
	}
	
	/**
	 * 
	 * @方法名: updateStatus
	 * @描述: 更改上架状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午7:54:38 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateStatus(HotelRoomBean bean) {
		Integer result = getSqlSession().update("hotelroom.updateStatus", bean);
		return result;
	}
	
	/**
	 * @方法名: getRoombyId
	 * @描述: 根据房型ID获取一条信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午8:34:41 
	 * @param bean
	 * @return
	 */
	public HotelRoomBean getRoombyId(HotelRoomBean bean) {
		return getSqlSession().selectOne("hotelroom.getRoomById", bean);
	}
	
	/**
	 * 
	 * @方法名: updateRoom
	 * @描述: 修改房型信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 下午9:02:57 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateRoom(HotelRoomBean bean) {
		return getSqlSession().update("hotelroom.updateRoom", bean);
	}
	
}
