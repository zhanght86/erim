package com.erim.sz.cafeteria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.cafeteria.dao.CafeteriaOrderDao;
import com.erim.sz.common.bean.CafeteriaOrderBean;

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

	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insert(ModelMap model, CafeteriaOrderBean bean) {

		// 插入数据
		cafeteriaOrderDao.insertCafeteria(bean);
	}

	/**
	 * 
	 * @Title: update 
	 * @Description: 修改
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public int update(ModelMap model, CafeteriaOrderBean bean) {
		return cafeteriaOrderDao.updateCafeteria(bean);
	}
	
	/**
	 * 
	 * @Title: delete 
	 * @Description: 删除
	 * @param @param id    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void delete(int id){
		cafeteriaOrderDao.deleteCafeteria(id);
	}
}