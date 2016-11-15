package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaVoucherPriceBean;
/**
 * 
 * @类名: CafeteriaVouchermoneyDao
 * @描述: 代金券面额
 * @作者: 王赛
 * @创建时间: 2015年11月24日 下午8:13:34
 *
 */
@Repository("VouchermoneyDao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CafeteriaVouchermoneyDao extends BaseDao{
	/**
	 * 
	 * @方法名: selectCafeteriaVoucherById
	 * @描述: 代金券面额
	 * @作者: 王赛
	 * @创建时间: 2015年11月24日 下午8:16:00 
	 * @param cdlId
	 * @return
	 *
	 */
	public List<CafeteriaVoucherPriceBean> showList(Integer djqId){
		CafeteriaVoucherPriceBean bean = new CafeteriaVoucherPriceBean();
		bean.setDjqId(djqId);
		return this.getSqlSession().selectList("cafeteriavoucherprice.showList", bean);
	}
}
