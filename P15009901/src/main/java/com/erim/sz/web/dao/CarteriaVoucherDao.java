package com.erim.sz.web.dao;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.erim.core.dao.BaseDao;
import com.erim.sz.common.bean.CafeteriaVoucherBean;
/**
 * 
 * @类名: CarteriaVoucherDao
 * @描述: 餐厅代金券
 * @作者: 王赛
 * @创建时间: 2015年11月24日 下午6:16:26
 *
 */
@Repository("carteriavoucherdao")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CarteriaVoucherDao extends BaseDao{
	
	/**
	 * 
	 * @方法名: selectvoucher
	 * @描述: 餐厅代金券
	 * @作者: 王赛
	 * @创建时间: 2015年11月24日 下午6:16:49 
	 * @param id
	 * @return
	 *
	 */
	public List<CafeteriaVoucherBean> selectVoucherByCdlId(CafeteriaVoucherBean bean){
		return getSqlSession().selectList("cafeteriaVoucher.selectVoucherByCdlId",bean);
	}

}
