package com.erim.sz.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelParkBean;

/**
 * @ClassName:   HotelParkDao 
 * @Description: TODO(酒店停车场) 
 * @author       贺渊博
 * @date         2015年11月3日 下午9:51:27 
 */
@Repository("hotelParkDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelParkDao extends BaseDao {
	
	/**
	 * @方法名：selectParkById 
	 * @描述:  根据酒店Id获取停车场
	 * @作者：   贺渊博
	 * @创建时间：2015年11月3日 下午9:56:51
	 * @param id
	 * @return
	 */
	public List<HotelParkBean> selectPageparkList(BaseBean baseBean, ModelMap model) {
		return getSqlSession().selectList("hotelpark.selectPageparkList", baseBean,
				new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}
	
	/**
	 * @方法名：getParkById 
	 * @描述: 根据停车场id获取一条数据信息
	 * @作者：  贺渊博
	 * @创建时间：2015年11月3日 下午10:01:35
	 * @param id
	 * @return 返回类型 HotelParkBean
	 */
	public HotelParkBean getparkById(HotelParkBean bean) {
		return this.getSqlSession().selectOne("hotelpark.selectParkById", bean);
	}
	
	/**
	 * @方法名：deletePark 
	 * @描述:  删除一条停车场信息
	 * @作者：  贺渊博
	 * @创建时间：2015年11月3日 下午10:12:33
	 * @param id
	 * @return
	 */
	public Integer deletePark (Integer id) {
		return getSqlSession().delete("hotelpark.delete",id);
	}
	
	/**
	 * @方法名：insertPark 
	 * @描述:  新增停车场信息
	 * @作者：   贺渊博
	 * @创建时间：2015年11月3日 下午10:07:37
	 * @param bean
	 * @return
	 */
	public Integer insertPark(HotelParkBean bean){
		return getSqlSession().insert("hotelpark.insert",bean);
	}
	
    /**
     * @方法名：updatePark 
     * @描述: 修改停车场
     * @作者： 贺渊博
     * @创建时间：2015年11月3日 下午10:10:44
     * @param bean
     * @return 返回类型 Integer
     */
	public Integer updatePark(HotelParkBean bean){
		return getSqlSession().update("hotelpark.update",bean);
	}

}
