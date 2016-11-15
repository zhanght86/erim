package com.erim.sz.search.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.TicketPriceBean;

/**
 * @ClassName: TicketPriceDao 
 * @Description: 票类量价查询
 * @author maoxian
 * @date 2015年12月20日 下午1:02:00
 */
@Repository("ticketPriceDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TicketPriceDao extends BaseDao{

	/**
	 * @Title: selectTicketPrice 
	 * @Description: 票类量价查询
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<TicketPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 下午1:02:23 
	 * @throws
	 */
	public List<TicketPriceBean> selectTicketPrice(TicketPriceBean bean) {
		return this.getSqlSession().selectList("ticketprice.selectTicketPrice", bean);
	}
}
