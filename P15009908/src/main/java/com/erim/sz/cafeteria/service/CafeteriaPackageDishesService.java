package com.erim.sz.cafeteria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.cafeteria.dao.CafeteriaPackageDishesDao;
import com.erim.sz.common.bean.CafeteriaPackageDishesBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: CafeteriaPackageDishesService 
 * @Description: 菜品
 * @author maoxian
 * @date 2015年11月8日 下午3:27:59
 */
@Service("cafeteriaPackageDishesService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CafeteriaPackageDishesService {

	@Autowired
	private CafeteriaPackageDishesDao cafeteriaPackageDishesDao;
	
	/**
	 * @Title: insert 
	 * @Description: 新增
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(CafeteriaPackageDishesBean bean){
		return this.cafeteriaPackageDishesDao.insert(bean);
	}
	
	
	/**
	 * @Title: update 
	 * @Description: 修改
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年11月22日 下午5:29:59 
	 * @throws
	 */
	public Integer update(CafeteriaPackageDishesBean bean){
		return this.cafeteriaPackageDishesDao.update(bean);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 根据id 删除菜品
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年11月22日 下午5:46:00 
	 * @throws
	 */
	public Integer delete(Integer id){
		this.cafeteriaPackageDishesDao.delete(id);
		return CommonUtil.SUCCESS;
	}
}
