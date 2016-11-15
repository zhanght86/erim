package com.erim.sz.search.dao;

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
 * @创建时间: 2015年10月29日 下午12:13:52
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
		return getSqlSession().selectOne("ticketdetail.selectBeanByPriId", id);
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
	public int insertTicket(TicketDetailBean ticketDetailBean) {
		return getSqlSession().insert("ticketdetail.insert", ticketDetailBean);
	}

	/**
	 * 
	 * @Title: updateTicket
	 * @Description: 修改
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateTicket(TicketDetailBean bean) {
		getSqlSession().update("ticketdetail.update", bean);
	}

	/**
	 * 
	 * @Title: deleteTicket
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void deleteTicket(TicketDetailBean bean) {
		getSqlSession().update("ticketdetail.delete", bean);
	}
	
	

	/**
	 * 
	 * @Title: selectBeanByPriId 
	 * @Description: 根据门票ID查询酒店基础信息
	 * @param @param id
	 * @param @return    设定文件 
	 * @return TicketDetailBean    返回类型 
	 * @throws
	 */
	public TicketDetailBean selectBeanByPriId(Integer id){
		return getSqlSession().selectOne("ticketdetail.selectBeanByPriId", id);
	}
	
	
	 /**
     * 
     * @Title: deleteicket 
     * @Description: 删除
     * @param @param id    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void deleteTicket(int id){
    	getSqlSession().update("ticketdetail.delet", id);
    }
}
