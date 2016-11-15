package com.erim.sz.search.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaDetailBean;

/***
 * 
* @ClassName: CafeteriaDetailDao 
* @Description: 特色餐
* @author 龙龙
* @date 2015年7月29日 下午4:38:07 
*
 */
@Repository("cafeteriaDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaDetailDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPageCafeteria 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<CafeteriaDetailBean>    返回类型 
	 * @throws
	 */
    public List<CafeteriaDetailBean> selectPageCafeteria(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("cafeteriadetail.selectPageCafeteria", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    /**
     * 
     * @Title: selectCafeteria 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return CafeteriaDetailBean    返回类型 
     * @throws
     */
    public CafeteriaDetailBean selectCafeteria(Integer id) {
        return getSqlSession().selectOne("cafeteriadetail.selectCafeteriaDetialById", id);
    }
    

    /**
     * 
     * @Title: insertCafeteria 
     * @Description: 插入
     * @param @param bean
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws
     */
    public int insertCafeteria(CafeteriaDetailBean bean) {
        return getSqlSession().insert("cafeteriadetail.insert", bean);
    }
    
   /**
    * 
    * @Title: updateCafeteria 
    * @Description: 修改
    * @param @param bean    设定文件 
    * @return void    返回类型 
    * @throws
    */
    public void updateCafeteria(CafeteriaDetailBean bean){
    	getSqlSession().update("cafeteriadetail.update", bean);
    }
    /**
 	 * 
 	 * @Title: deleteCafeteria
 	 * @Description: 上下架
 	 * @param @param id 设定文件
 	 * @return void 返回类型
 	 * @throws
 	 */
 	public void deleteCafeteria(CafeteriaDetailBean bean) {
 		getSqlSession().update("cafeteriadetail.delete", bean);
 	}
    
    /**
     * 
     * @Title: deleteCafeteria 
     * @Description: 删除
     * @param @param id    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void deleteCafeteria(int id){
    	getSqlSession().update("cafeteriadetail.cafeteriadelete", id);
    }
}
