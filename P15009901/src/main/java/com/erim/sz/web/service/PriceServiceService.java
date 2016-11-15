package com.erim.sz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.PriceServiceBean;
import com.erim.sz.web.dao.PriceServiceDao;

/**
 * 
 * 充值接口
 * @author maoxian
 *
 */
@Service
public class PriceServiceService {

	@Autowired
	private PriceServiceDao priceServiceDao;
	
	/**
	 * 修改
	 * @param priceServiceBean
	 */
	public void update(PriceServiceBean priceServiceBean){
		this.priceServiceDao.update(priceServiceBean);
	}
	
	/**
	 * 根据订单编号查询订单
	 * @param pseNo
	 * @return
	 */
	public PriceServiceBean findPriceBeanByPseNo(String pseNo){
		return this.priceServiceDao.findPriceBeanByPseNo(pseNo);
	}
}
