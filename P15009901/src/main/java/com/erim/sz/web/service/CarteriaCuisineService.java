package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.CafeteriaCuisineBean;
import com.erim.sz.web.dao.CarteriaCuisineDao;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: CarteriaCuisineService
 * @描述: 餐厅特色菜
 * @作者: 王赛
 * @创建时间: 2015年11月24日 下午5:40:40
 *
 */
@Service("carteriacuisineService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CarteriaCuisineService {

	@Autowired
	private CarteriaCuisineDao        carteriacuisineDao;
	@Autowired
	private CodeService codeService;
	/**
	 * 
	 * @方法名: selectList
	 * @描述: 餐厅特色菜
	 * @作者: 王赛
	 * @创建时间: 2015年11月24日 下午5:08:48 
	 * @param cdlID
	 * @param model
	 *
	 */
	public void selectList(Integer cdlID,ModelMap model){
		
		CafeteriaCuisineBean bean = new CafeteriaCuisineBean();
		bean.setCdlID(cdlID);
		List<CafeteriaCuisineBean> carteriacuisine = carteriacuisineDao.selectList(bean);
		
		model.addAttribute("listCuisine", carteriacuisine);
	}
}