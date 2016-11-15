package com.erim.sz.sametown.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.GroundDetailBean;

/***
 * 
 * @类名: GroundDetailDao
 * @描述: 当地游
 * @作者: 李庆
 * @创建时间: 2015年10月25日 下午5:06:39
 *
 */
@Repository("groundDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GroundDetailDao extends BaseDao{

	/**
	 * 
	 * @Title: selectPageGround 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<GroundDetailBean>    返回类型 
	 * @throws
	 */
	public List<GroundDetailBean> selectPageTown(BaseBean baseBean,ModelMap model) {
		return getSqlSession().selectList("grounddetail.selectPageTown",baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));

	}
    
	 /**
     * @描述: 根据当地游信息ID查询一条信息
     * @作者: 
     * @创建时间: 2015年11月25日 下午4:01:07
     * @param id 当地游信息ID
     * @return
     */
    public GroundDetailBean selectById(Integer id){
    	return getSqlSession().selectOne("grounddetail.selectBeanByPriId", id);
    }
}
