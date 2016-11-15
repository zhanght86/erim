package com.erim.sz.cafeteria.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaPackageDishesFoodBean;


/**
 * @ClassName: CafeteriaPackageDishesFoodDishesFoodDao 
 * @Description: 菜品名称管理
 * @author maoxian
 * @date 2015年11月7日 下午5:50:37
 */
@Repository("cafeteriaPackageDishesFoodDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaPackageDishesFoodDao extends BaseDao {
	
	/**
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param cafeteriaPackageDishesFoodBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(List<CafeteriaPackageDishesFoodBean> list){
		return this.getSqlSession().insert("cafeteriapackagedishesfood.insert", list);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改
	 * @param @param cafeteriaPackageDishesFoodBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer update(CafeteriaPackageDishesFoodBean cafeteriaPackageDishesFoodBean){
		return this.getSqlSession().update("cafeteriapackagedishesfood.update", cafeteriaPackageDishesFoodBean);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除id
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer delete(Integer id){
		return this.getSqlSession().delete("cafeteriapackagedishesfood.delete", id);
	}
	
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
}
