package com.erim.sz.sametown.dao;

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
 * @类名: CafeteriaDetailDao
 * @描述: 特色餐管理
 * @作者: 李庆
 * @创建时间: 2015年10月26日 下午2:13:10
 *
 */
@Repository("cafeteriadao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaDetailDao extends BaseDao {
		/**
		 * @Title:        selectPageCafeteria
		 * @Description:  分页查询
		 * @param         baseBean
		 * @return        List<CafeteriaDetailBean> 返回类型
		 */
	public List<CafeteriaDetailBean> selectPageCafeteria(BaseBean baseBean,ModelMap model ){
		return getSqlSession().selectList("cafeteriadetail.selectPageCafeteria",baseBean,new RowBounds(baseBean.getPageLinkBean().getStart(),baseBean.getPageLinkBean().getLimit()));
			
		}

	}
