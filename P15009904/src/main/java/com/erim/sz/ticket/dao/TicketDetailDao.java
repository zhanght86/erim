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

/**
 * @ClassName: TicketDetailDao
 * @Description: 门票
 * @author 陈鹏
 * @date 2015年7月29日 下午8:04:34
 */
@Repository("ticketDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TicketDetailDao extends BaseDao {

	/**
	 * @描述: 查询列表
	 * @作者: 
	 * @创建时间: 2015年11月30日 下午4:39:40
	 * @param baseBean
	 * @param model
	 * @return
	 */
	public List<TicketDetailBean> selectPageTown(BaseBean baseBean, ModelMap model){
        return getSqlSession().selectList("ticketdetail.selectPageTown", baseBean, 
        		new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}
	
	/**
	 * @Title: selectPageTicket
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return 设定文件
	 * @return List<TicketDetailBean> 返回类型
	 * @throws
	 */
	public List<TicketDetailBean> selectPageTicket(BaseBean baseBean, ModelMap model) {
		return getSqlSession().selectList("ticketdetail.selectPageTicket", baseBean,
				new RowBounds(baseBean.getPageLinkBean().getStart(), baseBean.getPageLinkBean().getLimit()));
	}

	/**
	 * @描述: 根据ID查询一条景点信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月1日 下午2:26:37
	 * @param id
	 * @return
	 */
	public TicketDetailBean getTicketById(Integer id) {
		return getSqlSession().selectOne("ticketdetail.selectBeanByPriId", id);
	}
	
	/**
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
	 * @Title: updateTicket1
	 * @Description: 修改预定方式
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void updateTicket1(TicketDetailBean bean) {
		getSqlSession().update("ticketdetail.update1", bean);
	}
	
	/**
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
     * @Title: deleteicket 
     * @Description: 删除
     * @param @param id    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void deleteTicket(int id){
    	getSqlSession().update("ticketdetail.delet", id);
    }
    
    /**
     * @方法名: updateTicketcode
     * @描述:  自动生成编码
     * @作者: 王赛
     * @创建时间: 2015年10月15日 上午11:35:36 
     * @param bean
     * @return
     */
    public Integer updateTicketcode(TicketDetailBean bean){
    	
    	return getSqlSession().update("ticketdetail.updateTicketcode", bean);
    }
}
