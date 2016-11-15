package com.erim.sz.ticket.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TicketOrderBean;

/***
 * 
 * @ClassName: TicketOrderDao
 * @Description: 门票订单
 * @author 龙龙
 * @date 2015年7月30日 下午1:19:35
 *
 */
@Repository("ticketOrderDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TicketOrderDao extends BaseDao {

	/**
	 * 
	 * @Title: selectPageTicket
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return 设定文件
	 * @return List<TicketOrderBean> 返回类型
	 * @throws
	 */
	public List<TicketOrderBean> selectPageTicket(BaseBean baseBean,
			ModelMap model) {
		return getSqlSession().selectList(
				"ticketorder.selectPageTicket",
				baseBean,
				new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean
						.getPageLinkBean().getLimit()));
	}

	/**
	 * 
	 * @Title: selectTicket
	 * @Description: 根据id查询
	 * @param @param id
	 * @param @return 设定文件
	 * @return TicketOrderBean 返回类型
	 * @throws
	 */
	public TicketOrderBean selectTicket(Integer id) {
		return getSqlSession().selectOne("ticketorder.selectByBookId", id);
	}

	/**
	 * 
	 * @Title: insertTicket
	 * @Description: 插入
	 * @param @param bean
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int insertTicket(TicketOrderBean bean) {
		return getSqlSession().insert("ticketorder.insert", bean);
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
	    public int updateTicket(TicketOrderBean bean){
	    	
	    	return getSqlSession().update("ticketorder.receiveOrRefuse", bean);
	    }
	    

	/**
	 * 
	 * @Title: deleteTicket
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteTicket(int id) {
		getSqlSession().update("ticketorder.delete", id);
	}
}
