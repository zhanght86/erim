package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelPriceBean;
import com.erim.sz.common.bean.HotelRoomBean;

/**
 * 
 * @ClassName: HotelRoomDao 
 * @Description: 酒店详情
 * @author maoxian
 * @date 2015年9月15日 下午12:47:37 
 *
 */
@Repository("hotelroomDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelRoomDao extends BaseDao {

	/**
	 * @Title: listHotelRoomBean 
	 * @Description: 酒店房型
	 * @param @param roomBean
	 * @param @return    设定文件 
	 * @return List<HotelRoomBean>    返回类型 
	 * @throws
	 */
	public List<HotelRoomBean> selectList(HotelPriceBean roomBean){
		return this.getSqlSession().selectList("hotelroom.selectList", roomBean);
	}
}
