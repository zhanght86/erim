package com.erim.sz.web.dao;

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
@Repository("PackageDishesDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaPackageDishesDao extends BaseDao {

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
