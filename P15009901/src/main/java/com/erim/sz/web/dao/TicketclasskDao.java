package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TicketClassBean;

/**
 * 
 * @类名: ticketclasskDao
 * @描述: 门票票类管理
 * @作者: 王赛
 * @创建时间: 2015年11月25日 下午11:30:34
 *
 */
@Repository("ticketclassDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TicketclasskDao extends BaseDao {

	/***
	 * 
	 * @方法名: selectList
	 * @描述: 门票票类管理
	 * @作者: 王赛
	 * @创建时间: 2015年11月25日 下午11:30:14 
	 * @param parkBean
	 * @return
	 *
	 */
	public List<TicketClassBean> selectList(TicketClassBean classBean){
		return this.getSqlSession().selectList("TicketClass.selectList",classBean);
	}
	/**
	 * 
	 * @方法名: selectOne
	 * @描述: 查询一条信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月27日 下午8:05:56 
	 * @param bean
	 * @return
	 *
	 */
	public TicketClassBean  selectOne(TicketClassBean  bean){
		return this.getSqlSession().selectOne("TicketClass.selectone", bean);
	}
}
