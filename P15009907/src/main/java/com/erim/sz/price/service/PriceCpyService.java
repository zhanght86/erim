package com.erim.sz.price.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.PriceCpyBean;
import com.erim.sz.price.dao.PriceCpyDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: PriceCpyService 
 * @Description: 佣金管理
 * @author maoxian
 * @date 2015年11月3日 上午11:34:28
 */
@Service("priceCpyService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PriceCpyService {

	@Autowired
	private PriceCpyDao priceDao;
	

	/**
	 * @Title: showLine 
	 * @Description: 信息查看
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void showLine(ModelMap model) {
		PriceCpyBean bean = new PriceCpyBean();
		bean.setCpyId(CommonUtil.getCpyId());
       // 分页查询
		List<PriceCpyBean> List = priceDao.selectPageLine(bean, model);
		// 回传信息
		model.put("pricelist", List);
	}

	/**
	 * 
	 * @Title: update 
	 * @Description: 修改
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public Integer update(ModelMap model, PriceCpyBean bean) {
		try{
			priceDao.updateLine(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	
	
}