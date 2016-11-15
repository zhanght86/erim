package com.erim.sz.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.CafeteriaOrderBean;
import com.erim.sz.orders.dao.CafeteriaOrderDao;

/***
 * 
* @ClassName: CafeteriaOrderService 
* @Description: 特色餐订单接口 
* @author 龙龙
* @date 2015年7月30日 上午11:34:00 
*
 */
@Service("cafeteriaOrderService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CafeteriaOrderService {

	@Autowired
	private CafeteriaOrderDao cafeteriaOrderDao;

	public void showCafeteria(ModelMap model, CafeteriaOrderBean bean) {

		// 分页查询
		List<CafeteriaOrderBean> cafeteriaList = cafeteriaOrderDao.selectPageCafeteria(bean, model);

		// 回传信息
		model.put("cafeteriaList", cafeteriaList);
	}

	
}