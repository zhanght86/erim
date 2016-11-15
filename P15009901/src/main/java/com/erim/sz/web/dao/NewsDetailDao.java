package com.erim.sz.web.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PubNewsBean;

/**
 * 
 * @ClassName: NewsDetailDao
 * @Description: 新闻资讯实体操作数据层
 * @Author 宁晓强
 * @Date 2015年9月21日 下午1:43:37
 *
 */
@Repository("newsDetailDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class NewsDetailDao extends BaseDao {

	/**
	 * 
	 * @Title: selectPageNews
	 * @Description: 
	 * @param beseBean
	 * @param model
	 * @return
	 *
	 */
	public List<PubNewsBean> selectPageNews(PubNewsBean beseBean, ModelMap model, Integer limit) {
		List<PubNewsBean> list = getSqlSession().selectList("newsdetail.selectPageNews", beseBean, 
				new RowBounds(beseBean.getPageLinkBean().getStart(), limit));
		return list;
	}
	
	/**
	 * 
	 * @Title: selectNewsContext
	 * @Description: 
	 * @param map
	 * @param id
	 * @return
	 *
	 */
	public PubNewsBean selectNewsBean(ModelMap map, Integer id) {
		return getSqlSession().selectOne("newsdetail.selectNewsById", id);
	}
	
	/**
	 * 
	 * @Title: updateCheckById
	 * @Description: 点击数+1
	 * @param id
	 *
	 */
	public void updateClickById(Integer id) {
		getSqlSession().update("newsdetail.updateClick", id);
	}
}
