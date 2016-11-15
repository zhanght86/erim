package com.erim.sz.line.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.LineOrderBean;

/***
 * 
 * @类名: LineOrderDao
 * @描述: 专线订单
 * @作者: 李庆
 * @创建时间: 2015年10月16日 下午4:14:52
 *
 */
@Repository("lineOrderDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LineOrderDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPageLine 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<LineOrderBean>    返回类型 
	 * @throws
	 */
    public List<LineOrderBean> selectPageLine(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("lineorder.selectPageLine", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    /**
     * 
     * @Title: selectLine 
     * @Description: 根据id查询
     * @param @param id
     * @param @return    设定文件 
     * @return LineOrderBean    返回类型 
     * @throws
     */
    public LineOrderBean selectLine(Integer id) {
        return getSqlSession().selectOne("lineorder.selectByBookId", id);
    }
    

    
   /**
 * @return 
    * 
    * @Title: updateLine 
    * @Description: 修改
    * @param @param bean    设定文件 
    * @return void    返回类型 
    * @throws
    */
    public int updateLine(LineOrderBean bean){
    	return getSqlSession().update("lineorder.receiveOrRefuse", bean);
    }
    
    
}
