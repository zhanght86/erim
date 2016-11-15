package com.erim.sz.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuideOrderBean;
import com.erim.sz.guide.dao.GuideOrderDao;

/***
 * 
* @ClassName: GuideOrderService 
* @Description: 导游订单接口 
* @author 龙龙
* @date 2015年7月30日 下午12:56:00 
*
 */
@Service("guideOrderService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuideOrderService {

	@Autowired
	private GuideOrderDao guideOrderDao;

	public void showGuide(ModelMap model, GuideOrderBean bean) {

		// 分页查询
		List<GuideOrderBean> guideList = guideOrderDao.selectPageGuide(bean, model);

		// 回传信息
		model.put("guideList", guideList);
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
	public int insert(ModelMap model, GuideOrderBean bean) {

		// 插入数据
		return guideOrderDao.insertGuide(bean);
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
	public int update(ModelMap model, GuideOrderBean bean) {
		return guideOrderDao.updateGuide(bean);
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
		guideOrderDao.deleteGuide(id);
	}
}