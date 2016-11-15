package com.erim.sz.search.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelRoomBean;

/**
 * @ClassName: HotelRoomDao 
 * @Description: 酒店房型
 * @author maoxian
 * @date 2015年12月17日 下午3:37:33
 */
@Repository("hotelRoomDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelRoomDao extends BaseDao {

	/**
	 * @Title: selectHotelRoomList 
	 * @Description: 根据酒店信息查询房型
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<HotelRoomBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月17日 下午3:45:09 
	 * @throws
	 */
	public List<HotelRoomBean> selectHotelRoomList(Integer hdlId) {
		return getSqlSession().selectList("hotelroom.selectHotelRoomList", hdlId);
	}
	
}
