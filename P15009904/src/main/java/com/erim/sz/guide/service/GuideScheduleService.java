package com.erim.sz.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuideScheduleBean;
import com.erim.sz.guide.dao.GuideScheduleDao;

/***
 * 
* @ClassName: GuideScheduleService 
* @Description: 导游档期接口
* @author 龙龙
* @date 2015年7月30日 下午5:26:07 
*
 */
@Service("guideScheduleService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuideScheduleService {

	@Autowired
	private GuideScheduleDao guideScheduleDao;

	public void showGuide(ModelMap model, GuideScheduleBean bean) {

		// 分页查询
		List<GuideScheduleBean> guideList = guideScheduleDao.selectPageGuide(bean, model);

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
	public void insert(ModelMap model, GuideScheduleBean bean) {

		// 插入数据
		guideScheduleDao.insertGuide(bean);
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
	public void update(ModelMap model, GuideScheduleBean bean) {
		guideScheduleDao.updateGuide(bean);
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
		guideScheduleDao.deleteGuide(id);
	}
}