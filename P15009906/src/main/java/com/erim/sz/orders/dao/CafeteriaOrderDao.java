package com.erim.sz.orders.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaOrderBean;

/***
 * 
* @ClassName: CafeteriaOrderDao 
* @Description: 特色餐订单
* @author 龙龙
* @date 2015年7月30日 上午11:36:46 
*
 */
@Repository("cafeteriaOrderDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaOrderDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPageCafeteria 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<CafeteriaOrderBean>    返回类型 
	 * @throws
	 */
    public List<CafeteriaOrderBean> selectPageCafeteria(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("cafeteriaorder.selectPageCafeteria", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    /**
     * 
     * @Title: selectCafeteria 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return CafeteriaOrderBean    返回类型 
     * @throws
     */
    public CafeteriaOrderBean selectCafeteria(Integer id) {
        return getSqlSession().selectOne("cafeteriaorder.selectByBookId", id);
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
    public int insertCafeteria(CafeteriaOrderBean bean) {
        return getSqlSession().insert("cafeteriaorder.insert", bean);
    }
    
   /**
 * @return 
    * 
    * @Title: updateCafeteria 
    * @Description: 修改为接单或拒接状态
    * @param @param bean    设定文件 
    * @return void    返回类型 
    * @throws
    */
    public int updateCafeteria(CafeteriaOrderBean bean){
    return	 getSqlSession().update("cafeteriaorder.receiveOrRefuse", bean);
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
    	getSqlSession().update("cafeteriaorder.delete", id);
    }
}
