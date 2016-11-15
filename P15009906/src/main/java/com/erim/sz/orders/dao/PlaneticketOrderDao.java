package com.erim.sz.orders.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PlaneticketOrderBean;

/***
 * 
* @ClassName: PlaneticketOrderDao 
* @Description: 飞机票订单
* @author 龙龙
* @date 2015年7月30日 下午1:08:09 
*
 */
@Repository("planeticketOrderDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PlaneticketOrderDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPagePlaneticket 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<PlaneticketOrderBean>    返回类型 
	 * @throws
	 */
    public List<PlaneticketOrderBean> selectPagePlaneticket(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("planeticketorder.selectPagePlaneticket", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    /**
     * 
     * @Title: selectPlaneticket 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return PlaneticketOrderBean    返回类型 
     * @throws
     */
    public PlaneticketOrderBean selectPlaneticket(Integer id) {
        return getSqlSession().selectOne("planeticketorder.selectByBookId", id);
    }
	
    /**
     * @return 
        * 
        * @Title: updatePlaneticket
        * @Description: 修改
        * @param @param bean    设定文件 
        * @return void    返回类型 
        * @throws
        */
        public int updatePlaneticket(PlaneticketOrderBean bean){
        	return getSqlSession().update("planeticketorder.receiveOrRefuse", bean);
        }
    
  
}
