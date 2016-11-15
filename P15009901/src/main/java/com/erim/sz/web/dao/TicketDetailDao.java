package com.erim.sz.web.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.bean.BaseBean;
import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TicketClassBean;
import com.erim.sz.common.bean.TicketDetailBean;

/**
 * 
 * @ClassName: TicketDetailDao 
 * @Description: 门票管理
 * @author maoxian
 * @date 2015年9月15日 下午12:58:32 
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
	public List<TicketDetailBean> selectPageTicket(BaseBean baseBean, ModelMap model,Integer limit) {
		return getSqlSession().selectList(
				"ticketdetail.selectPageTicket",
				baseBean,
				new RowBounds(baseBean.getPageLinkBean().getStart(), limit));
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
	 * @Title: selectHoteTicket 
	 * @Description: 查询热门门票
	 * @param @return    设定文件 
	 * @return List<TicketDetailBean>    返回类型 
	 * @throws
	 */
	public List<TicketDetailBean> selectHoteTicket(){
		return this.getSqlSession().selectList("ticketdetail.selectHoteTicket");
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
	public List<TicketClassBean> selectTicketClassBeanList(Integer id) {
		return getSqlSession().selectOne("TicketClass.selectList2", id);
	}
}
