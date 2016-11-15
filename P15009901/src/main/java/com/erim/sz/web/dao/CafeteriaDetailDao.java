package com.erim.sz.web.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaDetailBean;

/**
 * 
 * @ClassName: CafeteriaDetailDao 
 * @Description: 特色餐
 * @author maoxian
 * @date 2015年9月14日 下午7:43:43 
 *
 */
@Repository("cafeteriaDao")
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
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
    public List<CafeteriaDetailBean> selectPageCafeteria(BaseBean baseBean, ModelMap model,Integer limit) {
        return getSqlSession().selectList("cafeteriadetail.selectPageCafeteria", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), limit));
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
    
}
