package com.erim.sz.hotel.dao;

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
 * @类名: HotelDetailDao
 * @描述: 酒店实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月2日 下午3:42:07
 */
@Repository("hotelDetailDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelDetailDao extends BaseDao {
	
	/**
	 * @方法名：selectPageTown 
	 * @描述: 同城同业
	 * @作者： 贺渊博
	 * @创建时间：2015年11月11日 下午4:07:23
	 * @param baseBean
	 * @param model
	 * @return
	 */
	public List<HotelDetailBean> selectPageTown(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("hoteldetail.selectPageTown", baseBean, 
        		new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}
	
	/**
	 * @方法名: insert
	 * @描述: 新增酒店基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月2日 下午3:45:34 
	 * @param hotelDetailBean
	 * @return
	 */
	public Integer insert(HotelDetailBean hotelDetailBean) {
		return getSqlSession().insert("hoteldetail.insert", hotelDetailBean);
	}
	
	/**
	 * @方法名: updateCode
	 * @描述: 酒店基础信息添加产品编码
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 上午10:02:36 
	 * @param bean
	 * @return
	 */
	public Integer updateCode(HotelDetailBean bean) {
		return getSqlSession().update("hoteldetail.updateCode", bean);
	}
	
	/**
	 * @方法名: getHotelDetailById
	 * @描述: 根据ID获取一条酒店信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月2日 下午3:48:04 
	 * @param hotelId
	 * @return
	 */
	public HotelDetailBean getHotelDetailById(Integer id) {
		return getSqlSession().selectOne("hoteldetail.getHotelById", id);
	}
	
	/**
	 * @方法名: selectHotelDetailPage
	 * @描述: 分页查询酒店信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月2日 下午3:52:59 
	 * @param bean
	 * @param map
	 * @return
	 */
	public List<HotelDetailBean> selectPageHotelList(BaseBean bean, ModelMap map) {
		
		List<HotelDetailBean> list = getSqlSession().selectList("hoteldetail.selectPageHotelList", bean, 
				new RowBounds(bean.getPageLinkBean().getStart(), bean.getPageLinkBean().getLimit()));
		return list;
	}
	
	/**
	 * @方法名: insertCafeteria
	 * @描述: 添加餐厅信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午4:02:48 
	 * @param bean
	 * @return
	 */
	public Integer insertCafeteria(HotelDetailBean bean) {
		
		Integer result = getSqlSession().update("hoteldetail.insertCafeteria", bean);
		
		return result;
	}
	
	/**
	 * @方法名: insertPark
	 * @描述: 添加停车场信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午4:42:00 
	 * @param bean
	 * @return
	 */
	public Integer insertPark(HotelDetailBean bean) {
		return getSqlSession().update("hoteldetail.insertPark", bean);
	}
	
	/**
	 * @方法名: updateHotel
	 * @描述: 修改酒店基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午9:18:40 
	 * @param bean
	 * @return
	 */
	public Integer updateHotel(HotelDetailBean bean) {
		return getSqlSession().update("hoteldetail.update", bean);
	}
	
	/**
	 * @方法名: updateIsDelStatus
	 * @描述: 修改是否上架状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月4日 上午9:36:18 
	 * @param bean
	 * @return
	 */
	public Integer updateIsDelStatus(HotelDetailBean bean) {
		return getSqlSession().update("hoteldetail.updateIsDelStatus", bean);
	}
	
	/**
	 * @方法名: updateHotel
	 * @描述: 修改酒店基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月3日 下午9:18:40 
	 * @param bean
	 * @return
	 */
	public Integer updateHotel1(HotelDetailBean bean) {
		return getSqlSession().update("hoteldetail.update1", bean);
	}
}
