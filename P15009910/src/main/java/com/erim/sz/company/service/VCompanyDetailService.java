package com.erim.sz.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.company.dao.VCompanyDetailDao;
import com.erim.web.service.CodeService;

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
	@Autowired
	private CodeService		  codeService;
	
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
		model.addAttribute("companyList", vCompanyDetailDao.selectPage(baseBean, model));
    }
	
	/**
	 * @Title: setServiceInside 
	 * @Description: 所属专线 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月9日 下午1:44:33 
	 * @throws
	 */
	public void setServiceInside(ModelMap model){
		model.addAttribute("hoteline",  this.codeService.getSystemCodeListByCodeNo("C116"));
		model.addAttribute("countryine",this.codeService.getSystemCodeListByCodeNo("C118"));
	}
	
	/**
	 * @Title: selectById 
	 * @Description: 根据企业id查询信息
	 * @param @param id
	 * @param @return    设定文件 
	 * @return VCompanyDetailBean    返回类型 
	 * @author maoxian
	 * @date 2015年12月9日 下午12:36:02 
	 * @throws
	 */
	public VCompanyDetailBean selectById(Integer id){
		return this.vCompanyDetailDao.selectById(id);
	}
}
