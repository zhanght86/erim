package com.erim.sz.hotel.dao;

import java.util.*;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.HotelPriceBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @类名: HotelPriceDao
 * @描述: 酒店量价信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月5日 下午3:09:01
 */
@Repository("hotelPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HotelPriceDao extends BaseDao {

	/**
	 * @方法名: insertPrice
	 * @描述: 保存量价信息 - 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月6日 上午11:00:53 
	 * @param bean
	 * @return
	 */
	public Integer insertPrice(HotelPriceBean bean) {
		
		return getSqlSession().insert("hotelprice.insert", bean);
	}
	
	/**
	 * @描述: 保存量价信息 - 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月19日 下午3:08:14
	 * @param bean
	 * @return
	 */
	public Integer update(HotelPriceBean bean) {
		return getSqlSession().update("hotelprice.update", bean);
	}
	
	/**
	 * @方法名: selectPriceList
	 * @描述: 量价管理数据查询
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月9日 上午9:20:34 
	 * @param bean
	 * @return
	 */
	public List<HotelPriceBean> selectPriceList(HotelPriceBean bean, String[] monthCount) {
		
		// 接收数据list
		List<HotelPriceBean> list = new ArrayList<HotelPriceBean>();
		// mybatis 传值用map
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("monthCount", monthCount);
		map.put("bean", bean);
		// 获取数据
		list = getSqlSession().selectList("hotelprice.selectPriceList", map);
		
		return list;
	}
	
	/**
	 * @方法名: updateOpen
	 * @描述: 开关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月8日 下午5:45:07 
	 * @param bean
	 * @return
	 */
	public Integer updateOpen(HotelPriceBean bean) {
		
		Integer result = CommonUtil.ERROR;
		result = getSqlSession().update("hotelprice.updateOpen", bean);
		return result;
	}
	
	/**
	 * @方法名: updatePrice
	 * @描述: 修改房量
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月8日 下午6:37:46 
	 * @param bean
	 * @return
	 */
	public Integer updatePrice(HotelPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = getSqlSession().update("hotelprice.updatePrice", bean);
		return result;
	}
	
	/**
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月31日 上午11:18:14 
	 * @param bean
	 * @param count
	 * @return
	 */
	public Integer updateBatchIsOpen(HotelPriceBean bean, String[] count) {
		Integer result = CommonUtil.ERROR;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("monthCount", count);
		map.put("bean", bean);
		
		// 执行修改
		result = getSqlSession().update("hotelprice.updateBatchIsOpen", map);
		return result;
	}
	
	/**
	 * @描述: 根据房型ID和录入时间 获取最新的一条信息。
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月19日 下午2:56:19
	 * @param bean
	 * @return
	 */
	public HotelPriceBean getPriceByRoomDate(HotelPriceBean bean) {
		return getSqlSession().selectOne("hotelprice.getPriceByRoomDate", bean);
	}
}
