package com.erim.sz.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.ManagementOrderBean;
import com.erim.sz.orders.dao.ManagementOrderDao;

/***
 * 
* @ClassName: ManagementOrderService 
* @Description: 签证订单接口
* @author 龙龙
* @date 2015年7月30日 下午1:04:03 
*
 */
@Service("managementOrderService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ManagementOrderService {

	@Autowired
	private ManagementOrderDao managementOrderDao;

	public void showManagement(ModelMap model, ManagementOrderBean bean) {

		// 分页查询
		List<ManagementOrderBean> managementList = managementOrderDao.selectPageManagement(bean, model);

		// 回传信息
		model.put("managementList", managementList);
		System.out.println("size:"+managementList.size());
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
	public int insert(ModelMap model,ManagementOrderBean bean) {
		// 插入数据
		return managementOrderDao.insertManagement(bean);
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
	public int update(ModelMap model, ManagementOrderBean bean) {
		return managementOrderDao.updateManagement(bean);
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
		managementOrderDao.deleteManagement(id);
	}
}