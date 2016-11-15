package com.erim.sz.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TexiOrderBean;
import com.erim.sz.orders.dao.TexiOrderDao;

/***
 * 
* @ClassName: TexiOrderService 
* @Description:  租车订单接口
* @author 龙龙
* @date 2015年7月30日 下午1:16:51 
*
 */
    @Service("texiOrderService")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public class TexiOrderService {

	@Autowired
	private TexiOrderDao texiOrderDao;

	public void showTexi(ModelMap model, TexiOrderBean bean) {

		// 分页查询
		List<TexiOrderBean> texiList = texiOrderDao.selectPageTexi(bean, model);

		// 回传信息
		model.put("texiList", texiList);
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
	public int update(ModelMap model, TexiOrderBean bean) {
		return texiOrderDao.updateTexi(bean);
	}
	
}