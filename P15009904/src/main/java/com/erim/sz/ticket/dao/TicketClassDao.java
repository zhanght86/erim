package com.erim.sz.ticket.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TicketClassBean;

/**
 * @ClassName:   TicketclassDao 
 * @Description: 门票列表
 * @author 	         王赛
 * @date 		2015年10月10日 下午3:05:15 
 */
@Repository("ticketClassDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TicketClassDao extends BaseDao{

	/**
	 * @return 
	 * @Title: 		  selectPagetrantportTexi 
	 * @Description:  分页查询
	 * @param @param  baseBean
	 * @param @param  model
	 * @param @return 设定文件 
	 * @return        List<TexiDetailBean> 返回类型 
	 * @throws
	 */
	public List<TicketClassBean> selectPageTicketClass(TicketClassBean bean,ModelMap model) {
		return getSqlSession().selectList("ticketclass.selectTicket", bean);
	}
	
	/**
	 * @描述: 根据条件查询票类信息列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月21日 上午11:44:32
	 * @param bean
	 * @return
	 */
	public List<TicketClassBean> selectTicketClass(TicketClassBean bean) {
		return getSqlSession().selectList("ticketclass.selectTicket", bean);
	}
	
	/**
	 * @方法名: delete
	 * @描述: 票类上下架
	 * @作者: 王赛
	 * @创建时间: 2015年10月28日 下午5:12:49 
	 * @param id
	 */
	public void delete(TicketClassBean bean) {
		getSqlSession().update("ticketclass.delete",bean);
	}
	
	/**
 	 * @Title: 		 insert
 	 * @Description: 添加
 	 * @param @param id 设定文件
 	 * @return       void 返回类型
 	 * @throws
 	 */
 	public Integer insertclass(TicketClassBean bean) {
        return this.getSqlSession().insert("ticketclass.insert", bean);
    }
 	
 	/**
	 * @Title: 		 update 
	 * @Description: 修改
	 * @param @param TicketClassBean 设定文件 
	 * @return       void  返回类型 
	 * @throws
	 */
	public Integer update(TicketClassBean bean){
		return this.getSqlSession().update("ticketclass.update", bean);
	}
	
	/**
	 * @描述: 根据票类ID查询一条票类信息
	 * @作者: 
	 * @创建时间: 2015年11月28日 上午11:37:19
	 * @param bean
	 * @return
	 */
	public TicketClassBean selectClassend(TicketClassBean bean) {
    	return getSqlSession().selectOne("ticketclass.getTicketClassById", bean);
	}
}
