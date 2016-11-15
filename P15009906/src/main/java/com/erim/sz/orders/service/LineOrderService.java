package com.erim.sz.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.LineOrderBean;
import com.erim.sz.orders.dao.LineOrderDao;

/***
 * 
 * @类名: LineOrderService
 * @描述: 专线订单接口
 * @作者: 李庆
 * @创建时间: 2015年10月16日 下午4:15:47
 *
 */
@Service("lineOrderService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class LineOrderService {

	@Autowired
	private LineOrderDao lineOrderDao;

	public void showLine(ModelMap model, LineOrderBean bean) {

		// 分页查询
		List<LineOrderBean> lineList = lineOrderDao.selectPageLine(bean, model);

		// 回传信息
		model.put("lineList", lineList);
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
	public int update(ModelMap model, LineOrderBean bean) {
		return lineOrderDao.updateLine(bean);
	}
	
	
}