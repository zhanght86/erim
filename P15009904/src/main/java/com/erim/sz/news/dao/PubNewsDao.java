package com.erim.sz.news.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.PubNewsBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @类名: PubNewsDao
 * @描述: 新闻资讯信息实体操作数据层
 * @作者: 宁晓强
 * @创建时间: 2015年10月22日 下午3:11:16
 *
 */
@Repository("pubNewsDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PubNewsDao extends BaseDao {

	/**
	 * @方法名: insertNews
	 * @描述: 新增新闻
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午3:31:41 
	 * @param bean
	 * @return
	 */
	public Integer insertNews(PubNewsBean bean) {
		Integer result = CommonUtil.ERROR;
		result = getSqlSession().insert("pubnews.insert", bean);
		return result;
	}
	
	/**
	 * 
	 * @方法名: deleteNews
	 * @描述: 删除
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午3:32:51 
	 * @param bean
	 * @return
	 *
	 */
	public Integer deleteNews(PubNewsBean bean) {
		Integer result = CommonUtil.ERROR;
		result = getSqlSession().delete("pubnews.delete", bean);
		return result;
	}
	
	/**
	 * @方法名: selectPubNewsPageList
	 * @描述: 查询数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午3:35:33 
	 * @param bean
	 * @param map
	 * @return
	 */
	public List<PubNewsBean> selectPageNews(BaseBean bean, ModelMap map) {
		
		return getSqlSession().selectList("pubnews.selectPageNews", bean, 
				new RowBounds(bean.getPageLinkBean().getStart(), bean.getPageLinkBean().getLimit()));
	}
	
	/**
	 * @方法名: getPubNewsById
	 * @描述: 根据ID查询一条数据
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午3:37:00 
	 * @param id
	 * @return
	 */
	public PubNewsBean getPubNewsById(Integer id) {
		PubNewsBean bean = new PubNewsBean();
		bean = getSqlSession().selectOne("pubnews.getPubNewsById", id);
		return bean;
	}
	
	/**
	 * @方法名: updateNews
	 * @描述: 修改新闻资讯
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午3:38:08 
	 * @param bean
	 * @return
	 */
	public Integer updateNews(PubNewsBean bean) {
		return getSqlSession().update("pubnews.update", bean);
	}
	
	/**
	 * @方法名: updateIsShow
	 * @描述: 修改是否显示
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月23日 上午10:39:29 
	 * @param bean
	 * @return
	 */
	public Integer updateIsShow(PubNewsBean bean) {
		return getSqlSession().update("pubnews.updateIsShow", bean);
	}
}
