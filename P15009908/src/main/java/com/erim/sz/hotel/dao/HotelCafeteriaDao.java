package com.erim.sz.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelCefeteriaBean;

/**
 * 
 * @类名: HotelCafeteriaDao
 * @描述: 酒店餐厅信息实体操作层
 * @作者: 王赛
 * @创建时间: 2015年11月3日 下午9:37:29
 *
 */
@Repository("hotelCafdeteriaDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelCafeteriaDao extends BaseDao {

	/**
	 * 
	 * @方法名: selectCafdeteriaByHotelId
	 * @描述: 根据酒店信息获取餐厅信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月3日 下午9:36:01 
	 * @param id
	 * @return
	 *
	 */
	public List<HotelCefeteriaBean> selectPageCefeteriaList(BaseBean baseBean,
			ModelMap model) {
	return getSqlSession().selectList("hotelcafeteria.selectPageCefeteriaList", baseBean,
				new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}
	/**
	 * 
	 * @方法名: getCefeteriaById
	 * @描述: 根据餐厅id获取一条数据信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月3日 下午9:36:35 
	 * @param id
	 * @return
	 *
	 */
	public HotelCefeteriaBean getCefeteriaById(HotelCefeteriaBean bean) {
		return this.getSqlSession().selectOne("hotelcafeteria.selectCafdeteriaById", bean);
	}
	
	/**
	 * 
	 * @方法名: insertCefeteriaBean
	 * @描述: 新增一条餐厅信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月3日 下午9:40:05 
	 * @param bean
	 * @return
	 *
	 */
	public Integer insertCefeteriaBean(HotelCefeteriaBean bean) {
		
		return getSqlSession().insert("hotelcafeteria.insert", bean);
	}
	/**
	 * 
	 * @方法名: deleteCefeteria
	 * @描述: 删除一条餐厅信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月3日 下午9:39:45 
	 * @param id
	 * @return
	 *
	 */
	public Integer deleteCefeteria(Integer id) {
		
		return getSqlSession().delete("hotelcafeteria.delete", id);
	}
	
	/**
	 * 
	 * @方法名: updateCefeteria
	 * @描述: 修改餐厅信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月3日 下午9:39:27 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateCefeteria(HotelCefeteriaBean bean) {
		return getSqlSession().update("hotelcafeteria.update", bean);
	}
}
