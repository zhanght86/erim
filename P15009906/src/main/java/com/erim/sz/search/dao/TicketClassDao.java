package com.erim.sz.search.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TicketClassBean;

/**
 * @ClassName: TicketClassDao 
 * @Description: 票类接口
 * @author maoxian
 * @date 2015年12月20日 上午11:37:12
 */
@Repository("ticketClassDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TicketClassDao extends BaseDao{

	
	/**
	 * @Title: selectTicketClass 
	 * @Description: 根据门票id查询票类
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<TicketClassBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 上午11:37:52 
	 * @throws
	 */
	public List<TicketClassBean> selectTicketClass(Integer tdlId) {
		return getSqlSession().selectList("ticketclass.selectTicket", tdlId);
	}
}
