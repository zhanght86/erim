package com.erim.sz.price.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.PriceBackYwBean;
import com.erim.sz.price.dao.PriceBackYwDao;

/**
 * @ClassName: PriceBackYwService 
 * @Description: 运维返利
 * @author maoxian
 * @date 2015年12月18日 上午12:34:17
 */
@Service("priceBackYwService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PriceBackYwService {
	
	@Autowired
	private PriceBackYwDao priceBackYwDao;
	
	/**
	 * @Title: selectPageYw 
	 * @Description: 分页查询运维费支付历史
	 * @param @param baseBean
	 * @param @return    设定文件 
	 * @return List<PriceBackYwBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月18日 上午1:56:41 
	 * @throws
	 */
	public void selectPage(PriceBackYwBean baseBean,ModelMap model){
		//return this.priceBackYwDao.selectPageYw(baseBean);
		model.addAttribute("listYw", this.priceBackYwDao.selectPage(baseBean,model));
	}
	
}