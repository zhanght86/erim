package com.erim.sz.search.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaPackageBean;
import com.erim.sz.common.bean.CafeteriaPackageDishesBean;
import com.erim.sz.common.bean.CafeteriaPackageDishesFoodBean;

/**
 * @ClassName: CafeteriaPackageDao 
 * @Description: 套餐信息
 * @author maoxian
 * @date 2015年12月20日 下午2:52:14
 */
@Repository("cafeteriaPackageDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaPackageDao extends BaseDao{
   /**
    * 
    * @Title: selectPackageList 
    * @Description: 根据餐厅id查询特色餐
    * @param @param cdlID
    * @param @return    设定文件 
    * @return List<CafeteriaPackageBean>    返回类型 
    * @author maoxian
    * @date 2015年12月20日 下午2:52:44 
    * @throws
    */
    public List<CafeteriaPackageBean> selectPackageByCdlId(Integer cdlID) {
    	return getSqlSession().selectList("cafeteriapackage.selectPackageByCdlId", cdlID);
    }
    
    /**
     * @Title: selectDishesByCpeId 
     * @Description: 查询菜品
     * @param @param cpeId
     * @param @return    设定文件 
     * @return List<CafeteriaPackageDishesBean>    返回类型 
     * @author maoxian
     * @date 2015年12月20日 下午3:08:53 
     * @throws
     */
    public List<CafeteriaPackageDishesBean> selectDishesByCpeId(Integer cpeId) {
    	return getSqlSession().selectList("cafeteriapackage.selectDishesByCpeId", cpeId);
    }
    
    /**
     * @Title: selectFoodByCpdId 
     * @Description: 查询菜品中菜信息
     * @param @param cpdId
     * @param @return    设定文件 
     * @return List<CafeteriaPackageDishesFoodBean>    返回类型 
     * @author maoxian
     * @date 2015年12月20日 下午3:10:10 
     * @throws
     */
    public List<CafeteriaPackageDishesFoodBean> selectFoodByCpdId(Integer cpdId){
    	return this.getSqlSession().selectList("cafeteriapackage.selectFoodByCpdId", cpdId);
    }
}
