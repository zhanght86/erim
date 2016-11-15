package com.erim.sz.web.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PlaneticketDetailBean;

/**
 * 
 * @ClassName: PlaneticketDetailDao 
 * @Description: 飞机票
 * @author maoxian
 * @date 2015年9月15日 下午12:55:43 
 *
 */
@Repository("planeticketDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PlaneticketDetailDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPagePlaneticket 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<PlaneticketDetailBean>    返回类型 
	 * @throws
	 */
    public List<PlaneticketDetailBean> selectPagePlaneticket(BaseBean baseBean, ModelMap model, Integer limit) {
        return getSqlSession().selectList(
        		"planeticketdetail.selectPagePlaneticketTest", 
        		    baseBean,
        		       new RowBounds(baseBean.getPageLinkBean().getStart(), limit));
    } 
    /**
     * 
     * @Title: selectPlaneticket 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return PlaneticketDetailBean    返回类型 
     * @throws
     */
    public PlaneticketDetailBean selectPlaneticket(Integer id) {
        return getSqlSession().selectOne("planeticketdetail.selectBeanByPriId", id);
    }
    
}
