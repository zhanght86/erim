package com.erim.sz.cafeteria.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaPackageBean;

/**
 * @ClassName:    CafeteriaPackageDao 
 * @Description:  TODO(套餐) 
 * @author        贺渊博 
 * @date          2015年10月2日 下午1:52:48 
 */
@Repository("cafeteriaPackageDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaPackageDao extends BaseDao{
	
	/**
	 * @Title:       selectPageCafeteria 
	 * @Description: 套餐分页查询
	 * @param        baseBeana
	 * @param        model
	 * @return       设定文件 
	 * @return       List<CafeteriaPackageBean>    返回类型 
	 */
    public List<CafeteriaPackageBean> selectPageCafeteria(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("cafeteriapackage.selectPageCafeteria", baseBean, 
        		new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
    /**
     * @描述: 根据条件查询套餐信息列表
     * @作者: 宁晓强
     * @创建时间: 2015年11月22日 下午3:20:55
     * @param bean
     * @return
     */
    public List<CafeteriaPackageBean> selectPackageList(CafeteriaPackageBean bean) {
    	return getSqlSession().selectList("cafeteriapackage.selectPageCafeteria", bean);
    }
	    
    /**
     * @Title:       selectCafeteriaPackage 
     * @Description: 根据id查询
     * @param        id
     * @param        设定文件 
     * @return       CafeteriaPackageBean    返回类型 
     */
    public CafeteriaPackageBean selectCafeteriaPackage(Integer id) {
        return getSqlSession().selectOne("cafeteriapackage.selectCafeteriaPackageById", id);
    }
    
    /**
     * @描述: 新增套餐
     * @作者: 
     * @创建时间: 2015年12月3日 下午3:01:32
     * @param bean
     * @return
     */
    public Integer insertCafeteria(CafeteriaPackageBean bean) {
        return this.getSqlSession().insert("cafeteriapackage.insert", bean);
    }
    
    /**
     * @描述: 修改套餐方法
     * @作者: 
     * @创建时间: 2015年12月3日 下午2:53:42
     * @param bean
     */
	public Integer updateCafeteriaPackage(CafeteriaPackageBean bean) {
		return getSqlSession().update("cafeteriapackage.update", bean);
	}
	
	/**
 	 * @Title:        deleteCafeteria
 	 * @Description:  上下架
 	 * @param @param  id 设定文件
 	 * @return        void 返回类型
 	 * @throws
 	 */
 	public void deleteCafeteria(CafeteriaPackageBean bean) {
 		getSqlSession().update("cafeteriapackage.delete", bean);
 	}
 	
 	/**
 	 * @Title:          updatecode 
 	 * @Description:    TODO(修改编码) 
 	 * @param @param    updateCodeBean    设定文件 
 	 * @return          void    返回类型 
 	 */
	public Integer updatecode(CafeteriaPackageBean bean) {
		return getSqlSession().update("cafeteriapackage.updatecode",bean);
		
	}
}
