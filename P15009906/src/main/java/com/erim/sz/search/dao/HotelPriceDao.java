package com.erim.sz.search.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelPriceBean;

/**
 * @ClassName: HotelPriceDao 
 * @Description: 查询酒店量价信息
 * @author maoxian
 * @date 2015年12月17日 下午7:34:38
 */
@Repository("hotelPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelPriceDao extends BaseDao {
	
	/**
	 * @Title: listHotelPrice 
	 * @Description: 量价查询
	 * @param @param priceBean
	 * @param @return    设定文件 
	 * @return List<HotelPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月17日 下午7:35:31 
	 * @throws
	 */
	public List<HotelPriceBean> listHotelPrice(HotelPriceBean priceBean){
		return this.getSqlSession().selectList("hotelprice.listHotelPrice", priceBean);
	}
}
