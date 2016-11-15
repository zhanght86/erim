package com.erim.sz.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.PlaneticketOrderBean;
import com.erim.sz.orders.dao.PlaneticketOrderDao;

/***
 * 
* @ClassName: PlaneticketOrderService 
* @Description: 机票订单接口
* @author 龙龙
* @date 2015年7月30日 下午1:09:20 
*
 */
@Service("planeticketOrderService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PlaneticketOrderService {

	@Autowired
	private PlaneticketOrderDao planeticketOrderDao;

	public void showPlaneticket(ModelMap model, PlaneticketOrderBean bean) {

		// 分页查询
		List<PlaneticketOrderBean> planeticketList = planeticketOrderDao.selectPagePlaneticket(bean, model);

		// 回传信息
		model.put("planeticketList", planeticketList);
	}

	/**
	 * @return 
	 * 
	 * @Title: update 
	 * @Description: 修改
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public int update(ModelMap model,PlaneticketOrderBean bean) {
		return planeticketOrderDao.updatePlaneticket(bean);
	}

	



		
	 
}