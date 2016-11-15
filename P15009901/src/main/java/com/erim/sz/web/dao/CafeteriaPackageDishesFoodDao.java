package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaPackageDishesBean;
import com.erim.sz.common.bean.CafeteriaPackageDishesFoodBean;


/**
 * @ClassName: CafeteriaPackageDishesFoodDishesFoodDao 
 * @Description: 菜品名称管理
 * @author maoxian
 * @date 2015年11月7日 下午5:50:37
 */
@Repository("DishesFoodDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaPackageDishesFoodDao extends BaseDao {
	
	/**
	 * @描述: 根据菜品ID查询菜列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月13日 下午2:41:39
	 * @param cpdId
	 * @return
	 */
	public List<CafeteriaPackageDishesFoodBean> selectFoodByCpdId(Integer cpdId) {
		return getSqlSession().selectList("cafeteriapackagedishesfood.selectFoodByCpdId", cpdId);
	}
	
	/**
	 * @描述: 查询其它菜品列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月13日 下午3:43:39
	 * @param bean
	 * @return
	 */
	public List<CafeteriaPackageDishesFoodBean> selectFoodByFood(CafeteriaPackageDishesFoodBean bean) {
		return getSqlSession().selectList("cafeteriapackagedishesfood.selectFoodByFood", bean);
	}
	
	/**
	 * @Title: showList 
	 * @Description: 查询
	 * @param @param cafeteriaPackageDishesFoodBean
	 * @param @return    设定文件 
	 * @return List<CafeteriaPackageDishesFoodBean>    返回类型 
	 * @throws
	 */
	public List<CafeteriaPackageDishesFoodBean> showList(CafeteriaPackageDishesFoodBean cafeteriaPackageDishesFoodBean){
		return this.getSqlSession().selectList("cafeteriapackagedishesfood.select", cafeteriaPackageDishesFoodBean);
	}
	/**
	 * @描述: 根据套餐ID查询一条套餐信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月13日 下午2:26:39
	 * @param cpeId
	 * @return
	 */
	public List<CafeteriaPackageDishesBean> selectListByCpeId(Integer cpeId) {
		return getSqlSession().selectList("cafeteriapackagedishes.selectListByCpeId", cpeId);
	}
}
