package com.erim.sz.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GroundOrderBean;
import com.erim.sz.orders.dao.GroundOrderDao;

/***
 * 
* @ClassName: GroundOrderService 
* @Description: 地接社订单接口 
* @author 龙龙
* @date 2015年7月30日 下午12:34:32 
*
 */
@Service("groundOrderService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GroundOrderService {

	@Autowired
	private GroundOrderDao groundOrderDao;

	public void showGround(ModelMap model, GroundOrderBean bean) {

		// 分页查询
		List<GroundOrderBean> groundList = groundOrderDao.selectPageGround(bean, model);

		// 回传信息
		model.put("groundList", groundList);
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
	public int insert(ModelMap model, GroundOrderBean bean) {

		// 插入数据
		return groundOrderDao.insertGround(bean);
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
	public int update(ModelMap model, GroundOrderBean bean) {
		System.out.println("获取到的ID是--------------"+bean.getGdoIsThrough());
		return  groundOrderDao.updateGround(bean);
	}
	
	/**
	 * 
	 * @Title: delete 
	 * @Description: 删除
	 * @param @param id    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void delete(GroundOrderBean bean){
		groundOrderDao.deleteGround(bean);
	}
}