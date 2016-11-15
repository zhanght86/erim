package com.erim.sz.web.dao;

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
	 * @描述: 根据id查询一条数据
	 * @作者: 吴哲元
	 * @创建时间: 2015年12月26日 下午3:02:29
	 * @param id
	 * @return
	 */
	public PubNewsBean getPubNewsById(Integer id) {
		PubNewsBean bean = new PubNewsBean();
		bean = getSqlSession().selectOne("pubnews.getPubNewsById", id);
		return bean;
	}
	
	public void click(Integer id) {
		getSqlSession().selectOne("pubnews.click", id);
	}
	
}
