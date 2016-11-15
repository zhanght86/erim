package com.erim.sz.web.dao;

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
 * @ClassName: HotelDetailDao 
 * @Description: 酒店详情
 * @author maoxian
 * @date 2015年9月15日 下午12:47:37 
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
	public List<HotelDetailBean> selectPageHotel(BaseBean baseBean, ModelMap model, Integer limit) {
		return getSqlSession().selectList("hoteldetail.selectPageHotel",baseBean,new RowBounds(baseBean.getPageLinkBean().getStart(), limit));
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
	public HotelDetailBean selectHotel(HotelDetailBean bean) {
		List<HotelDetailBean> list = getSqlSession().selectList("hoteldetail.selectBeanByPriId", bean);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
}
