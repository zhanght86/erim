package com.erim.sz.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelOrderBean;
import com.erim.sz.orders.dao.HotelOrderDao;

/**
 * @ClassName: HotelOrderService 
 * @Description: 酒店订单管理 
 * @author maoxian
 * @date 2015年8月8日 下午3:56:07
 */
@Service("hotelOrderService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelOrderService {

	@Autowired
	private HotelOrderDao orderDao;

	/**
	 * @Title: showHotel 
	 * @Description: 酒店订单
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void showHotelOrder(ModelMap model, HotelOrderBean bean) {

		bean.setN(10);
		
		// 分页查询
		List<HotelOrderBean> orderList = orderDao.selectPageOrder(bean, model);

		// 回传信息
		model.put("orderList", orderList);
	}

	
}