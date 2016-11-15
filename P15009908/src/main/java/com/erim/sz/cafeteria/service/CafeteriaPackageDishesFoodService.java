package com.erim.sz.cafeteria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.cafeteria.dao.CafeteriaPackageDishesFoodDao;
import com.erim.sz.common.bean.CafeteriaPackageDishesFoodBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: CafeteriaPackageDishesService 
 * @Description: 菜品
 * @author maoxian
 * @date 2015年11月8日 下午3:27:59
 */
@Service("cafeteriaPackageDishesFoodService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CafeteriaPackageDishesFoodService {

	@Autowired
	private CafeteriaPackageDishesFoodDao foodDao;
	
	/**
	 * @Title: insert 
	 * @Description: 插入数组
	 * @param @param list
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(List<CafeteriaPackageDishesFoodBean> list){
		return this.foodDao.insert(list);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年11月22日 下午5:50:17 
	 * @throws
	 */
	public Integer delete(Integer id){
		this.foodDao.delete(id);
		return CommonUtil.SUCCESS;
	}
}
