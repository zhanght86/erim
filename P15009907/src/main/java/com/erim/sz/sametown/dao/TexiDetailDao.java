package com.erim.sz.sametown.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TexiDetailBean;

/**
 * 
 * @类名: TexiDetailDao
 * @描述: 租车
 * @作者: 李庆
 * @创建时间: 2015年10月26日 下午1:24:40
 *
 */
 @Repository("texiDao")
 @Scope(BeanDefinition.SCOPE_PROTOTYPE)
 public class TexiDetailDao extends BaseDao{
	 
	
    /**
	 * @Title: 		  selectPageTexi 
	 * @Description:  同城同业
	 * @param @param  baseBean
	 * @param @param  model
	 * @param @return 设定文件 
	 * @return        List<TexiDetailBean>    返回类型 
	 * @throws
	 */
    public List<TexiDetailBean> selectPageTown(BaseBean baseBean, ModelMap model) {
        return getSqlSession().selectList("texidetail.selectPageTown", baseBean, new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
    }
    
}
