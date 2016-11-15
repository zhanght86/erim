package com.erim.sz.search.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaPriceBean;

/**
 * @ClassName: CafeteriaPriceDao 
 * @Description: 特色餐量价
 * @author maoxian
 * @date 2015年12月20日 下午3:38:06
 */
@Repository("cafeteriaPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaPriceDao extends BaseDao {

	/**
	 * @Title: listHotelPrice 
	 * @Description: 量价查询
	 * @param @param priceBean
	 * @param @return    设定文件 
	 * @return List<CafeteriaPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 下午3:40:51 
	 * @throws
	 */
	public List<CafeteriaPriceBean> listCafeteriaPrice(CafeteriaPriceBean priceBean){
		return this.getSqlSession().selectList("cafeteriaprice.listCafeteriaPrice", priceBean);
	}
}
