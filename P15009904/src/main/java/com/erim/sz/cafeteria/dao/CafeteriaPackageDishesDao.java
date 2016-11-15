package com.erim.sz.cafeteria.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaPackageDishesBean;


/**
 * @ClassName: CafeteriaPackageDishesDishesDao 
 * @Description: 菜品管理
 * @author maoxian
 * @date 2015年11月7日 下午5:50:09
 */
@Repository("cafeteriaPackageDishesDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaPackageDishesDao extends BaseDao {

	/**
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param cafeteriaPackageDishesBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(CafeteriaPackageDishesBean cafeteriaPackageDishesBean){
		return this.getSqlSession().insert("cafeteriapackagedishes.insert", cafeteriaPackageDishesBean);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改
	 * @param @param cafeteriaPackageDishesBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer update(CafeteriaPackageDishesBean cafeteriaPackageDishesBean){
		return this.getSqlSession().update("cafeteriapackagedishes.update", cafeteriaPackageDishesBean);
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
		return this.getSqlSession().delete("cafeteriapackagedishes.delete", id);
	}
	
	/**
	 * @Title: showList 
	 * @Description: 查询
	 * @param @param cafeteriaPackageDishesBean
	 * @param @return    设定文件 
	 * @return List<CafeteriaPackageDishesBean>    返回类型 
	 * @throws
	 */
	public List<CafeteriaPackageDishesBean> showList(CafeteriaPackageDishesBean cafeteriaPackageDishesBean){
		return this.getSqlSession().selectList("cafeteriapackagedishes.select", cafeteriaPackageDishesBean);
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
