package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.sz.common.bean.CafeteriaVoucherPriceBean;
import com.erim.sz.web.dao.CafeteriaVouchermoneyDao;
import com.erim.web.service.CodeService;
/**
 * 
 * @类名: CarteriaVoucherService
 * @描述: 餐厅代金券
 * @作者: 王赛
 * @创建时间: 2015年11月24日 下午7:25:23
 *
 */
@Service("vouchermoneyservice")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CarteriaVouchermoneyService {
	@Autowired
	private CafeteriaVouchermoneyDao VouchermoneyDao;
	@Autowired
	private CodeService codeService;
	/**
	 * 
	 * @方法名: showList
	 * @描述: 餐厅代金券
	 * @作者: 王赛
	 * @创建时间: 2015年11月25日 下午2:34:54 
	 * @param djqId
	 * @return
	 *
	 */
	public List<CafeteriaVoucherPriceBean> showList(Integer djqId){
		return this.VouchermoneyDao.showList(djqId);
	}
	
}
