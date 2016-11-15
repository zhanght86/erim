package com.erim.sz.sametown.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TicketDetailBean;

/**
 * 
 * @类名: TicketDetailDao
 * @描述: 门票
 * @作者: 李庆
 * @创建时间: 2015年10月25日 下午5:07:39
 *
 */
@Repository("ticketDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TicketDetailDao extends BaseDao {

	/**
	 * 
	 * @Title: selectPageTicket
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return 设定文件
	 * @return List<TicketDetailBean> 返回类型
	 * @throws
	 */
	public List<TicketDetailBean> selectPageTicket(BaseBean baseBean,
			ModelMap model) {
		return getSqlSession().selectList(
				"ticketdetail.selectPageTicket",
				baseBean,
				new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean
						.getPageLinkBean().getLimit()));
	}

    
}
