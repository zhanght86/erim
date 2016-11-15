package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.CafeteriaPackageBean;
import com.erim.sz.common.bean.CafeteriaPackageDishesBean;
import com.erim.sz.common.bean.CafeteriaPackageDishesFoodBean;
import com.erim.sz.web.dao.CafeteriaPackageDishesDao;
import com.erim.sz.web.dao.CafeteriaPackageDishesFoodDao;
import com.erim.sz.web.dao.CarteriaPackageDao;

/**
 * 
 * @类名: CarteriaPackageService
 * @描述: 餐厅套餐
 * @作者: 王赛
 * @创建时间: 2015年11月24日 下午5:35:26
 *
 */
@Service("carteriapackageService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CarteriaPackageService {

	@Autowired
	private CarteriaPackageDao             CafeteriaPackageDao;
	@Autowired
	private CafeteriaPackageDishesFoodDao  DishesFoodDao;
	@Autowired
	private CafeteriaPackageDishesDao      PackageDishesDao;
	/**
	 * 
	 * @Title: selectList 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param cdlID
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月15日 上午4:39:12 
	 * @throws
	 */
	public void selectList(Integer cdlID,ModelMap model){
		
		//根据餐厅id查询餐厅内套餐
		CafeteriaPackageBean bean = new CafeteriaPackageBean();
		bean.setCdlID(cdlID);
		List<CafeteriaPackageBean> carteriapackage = CafeteriaPackageDao.selectList(bean);
		
		//遍历套餐 查询菜品
		for(CafeteriaPackageBean b : carteriapackage){
			//根据套餐查询菜品
			List<CafeteriaPackageDishesBean> dishesList = PackageDishesDao.selectListByCpeId(b.getId());
			//遍历菜品查询菜
			for (CafeteriaPackageDishesBean c : dishesList) {
				c.setFoodList(DishesFoodDao.selectFoodByCpdId(c.getId()));
			}
			b.setDishesList(dishesList);
			//根据套餐ID,菜品类型="其它",菜品ID=0,获取其它菜品列表
			CafeteriaPackageDishesFoodBean foodBean = new CafeteriaPackageDishesFoodBean();
			foodBean.setCpfNtype("其它");// 菜品类型
			foodBean.setCpdId(0);// 菜品ID
			foodBean.setCpeId(b.getId()); // 套餐ID
			List<CafeteriaPackageDishesFoodBean> qitaList = DishesFoodDao.selectFoodByFood(foodBean);
			//其它菜品、
			b.setFoodOtherList(qitaList);
		}
		
		//套餐信息
		model.addAttribute("listPackage", carteriapackage);
	}
	
}