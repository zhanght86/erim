package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.CafeteriaVoucherBean;
import com.erim.sz.common.bean.CafeteriaVoucherPriceBean;
import com.erim.sz.web.dao.CarteriaVoucherDao;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;
/**
 * 
 * @类名: CarteriaVoucherService
 * @描述: 餐厅代金券
 * @作者: 王赛
 * @创建时间: 2015年11月24日 下午7:25:23
 *
 */
@Service("carteriavoucherservice")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CarteriaVoucherService {
	@Autowired
	private CarteriaVoucherDao carteriavoucherdao;
	@Autowired
    private CarteriaVouchermoneyService vouchermoneyservice;
	@Autowired
	private CodeService codeService;
	/**
	 * 
	 * @方法名: selectDriveById
	 * @描述: 餐厅代金券
	 * @作者: 王赛
	 * @创建时间: 2015年11月24日 下午7:24:51 
	 * @param model
	 * @param id
	 *
	 */
	public void selectvoucherById(ModelMap model,Integer id){
		
		CafeteriaVoucherBean cafeteriaVoucherBean = new CafeteriaVoucherBean();
		cafeteriaVoucherBean.setCdlID(id);
		List<CafeteriaVoucherBean> beanlist = carteriavoucherdao.selectVoucherByCdlId(cafeteriaVoucherBean);
		for(CafeteriaVoucherBean bean : beanlist){
			//转码
			//包间使用情况
			String djqVoucher = bean.getDjqVoucher();
			if (djqVoucher != null && !"".equals(djqVoucher)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.VOUCHER, djqVoucher);
				bean.setDjqVoucher(str);
			}
			
		}
		model.addAttribute("CafeteriaVoucher",beanlist);
//		//查询代金券金额
//    	List<CafeteriaVoucherPriceBean> list = this.vouchermoneyservice.showList(bean.getId());
//    	if (list == null || list.size() == 0) {
//    		list.add(new CafeteriaVoucherPriceBean());
//    		//如果代金券list为null,则放进一个null的list
//    		model.addAttribute("listVoucherPrice", list);
//    	} else {
//    		model.addAttribute("listVoucherPrice", list);
//    	}
	}
}
