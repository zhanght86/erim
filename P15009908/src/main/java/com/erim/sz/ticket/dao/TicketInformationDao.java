package com.erim.sz.ticket.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TicketDetailBean;

/***
 * 
 * @ClassName: TicketInformationDao
 * @Description: 酒店
 * @author 龙龙
 * @date 2015年7月29日 上午11:25:51
 *
 */
@Repository("ticketinformationDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TicketInformationDao extends BaseDao {

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
		return getSqlSession().selectList("ticketdetail.selectPageTicket",baseBean,new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}

	/**
	 * 
	 * @Title: selectTicket
	 * @Description: 根据id查询
	 * @param @param id
	 * @param @return 设定文件
	 * @return TicketDetailBean 返回类型
	 * @throws
	 */
	public TicketDetailBean selectTicket(Integer id) {
		return getSqlSession().selectOne("ticketdetail.selectByBookId", id);
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
	public int insertTicket(TicketDetailBean bean) {
		return getSqlSession().insert("ticketdetail.insert", bean);
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
		getSqlSession().update("ticketInformation.delete", id);
	}

	public void updateTicket(TicketDetailBean bean) {
		// TODO Auto-generated method stub
		
	}
}
