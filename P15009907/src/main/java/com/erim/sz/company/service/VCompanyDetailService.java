package com.erim.sz.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.company.dao.VCompanyDetailDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: VCompanyDetailService 
 * @Description: 企业相关
 * @author maoxian
 * @date 2015年12月6日 下午11:46:10
 */
@Service("vCompanyDetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class VCompanyDetailService {

	@Autowired
	private VCompanyDetailDao vCompanyDetailDao;
	
	/**
	 * @Title: selectPage 
	 * @Description: 企业相关
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<VCompanyDetailBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月6日 下午11:46:38 
	 * @throws
	 */
	public void selectPage(VCompanyDetailBean baseBean, ModelMap model) {
		
		baseBean.setCpyRoe(ErimConstants.COMPANYROLE_SELLER);
		baseBean.setZscFromCpyid(CommonUtil.getCpyId());
		model.addAttribute("companyList", vCompanyDetailDao.selectPage(baseBean, model));
    }
}
