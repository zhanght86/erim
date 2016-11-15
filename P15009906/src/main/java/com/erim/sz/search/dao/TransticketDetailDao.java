package com.erim.sz.search.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TransticketDetailBean;

/**
 * 
 * @类名: TransticketDetailDao
 * @描述: 火车票
 * @作者: 李庆
 * @创建时间: 2015年10月25日 下午5:14:07
 *
 */
@Repository("transticketDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TransticketDetailDao extends BaseDao {

	/**
	 * 
	 * @Title: selectPageTransticket
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return 设定文件
	 * @return List<TransticketDetailBean> 返回类型
	 * @throws
	 */
	public List<TransticketDetailBean> selectPageTransticket(BaseBean baseBean,
			ModelMap model) {
		return getSqlSession().selectList(
				"transticketdetail.selectPageTransticket",
				baseBean,
				new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean
						.getPageLinkBean().getLimit()));
	}

}
