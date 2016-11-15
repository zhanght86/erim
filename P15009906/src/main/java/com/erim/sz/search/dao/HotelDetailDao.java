package com.erim.sz.search.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelDetailBean;

/***
 * 
 * @ClassName: HotelDetailDao
 * @Description: 酒店
 * @author 龙龙
 * @date 2015年7月29日 上午11:25:51
 *
 */
@Repository("hoteldetailDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelDetailDao extends BaseDao {

	/**
	 * 
	 * @Title: selectPageHotel
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return 设定文件
	 * @return List<HotelDetailBean> 返回类型
	 * @throws
	 */
	public List<HotelDetailBean> selectPageHotel(BaseBean baseBean,
			ModelMap model) {
		return getSqlSession().selectList("hoteldetail.selectPageHotel",baseBean,new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}
	/**
	 * 
	 * @Title: selectHotel
	 * @Description: 根据id查询
	 * @param @param id
	 * @param @return 设定文件
	 * @return HotelDetailBean 返回类型
	 * @throws
	 */
	public HotelDetailBean selectHotel(Integer id) {
		return getSqlSession().selectOne("hoteldetail.selectBeanByPriId", id);
	}
	
	/**
	 * 
	 * @Title: insertHotel
	 * @Description: 插入
	 * @param @param bean
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int insertHotel(HotelDetailBean bean) {
		return getSqlSession().insert("hoteldetail.insert", bean);
	}

	/**
	 * 
	 * @Title: updateHotel
	 * @Description: 修改
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateHotel(HotelDetailBean bean) {
		getSqlSession().update("hoteldetail.update", bean);
	}

	/**
	 * 
	 * @Title: deleteHotel
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteHotel(HotelDetailBean bean) {
		getSqlSession().update("hoteldetail.delete", bean);
	}
	
	/**
	 * 
	 * @Title: selectBeanByPriId 
	 * @Description: 根据酒店ID查询酒店基础信息
	 * @param @param id
	 * @param @return    设定文件 
	 * @return HotelDetailBean    返回类型 
	 * @throws
	 */
	public HotelDetailBean selectBeanByPriId(Integer id){
		return getSqlSession().selectOne("hoteldetail.selectBeanByPriId", id);
	}
}
