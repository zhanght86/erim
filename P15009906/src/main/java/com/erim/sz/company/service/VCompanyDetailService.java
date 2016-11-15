package com.erim.sz.company.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.company.dao.VCompanyDetailDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.web.bean.CodeBean;
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
		
		baseBean.setCpyRoe(ErimConstants.COMPANYROLE_LINE);
		baseBean.setZscSellCpyid(CommonUtil.getCpyId());
		List<VCompanyDetailBean> list = vCompanyDetailDao.selectPage(baseBean, model);
		model.addAttribute("companyList", list);
		
		VCompanyDetailBean query = new VCompanyDetailBean();
		query.setCpyRoe(ErimConstants.COMPANYROLE_LINE);
		query.setZscSellCpyid(CommonUtil.getCpyId());
		query.setN(9999);
		//设置线路
		this.setLine(vCompanyDetailDao.selectPage(query, model), model);
    }
	
	/**
	 * @Title: setLine 
	 * @Description: 设置线路
	 * @param @param list
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 上午2:14:30 
	 * @throws
	 */
	public void setLine(List<VCompanyDetailBean> list,ModelMap model){
		//国内
		List<CodeBean> setList116  = new ArrayList<CodeBean>();
		List<CodeBean> listCode116 = this.codeService.getSystemCodeListByCodeNo("C116");
		//国际
		List<CodeBean> setList118  = new ArrayList<CodeBean>();
		List<CodeBean> listCode118 = this.codeService.getSystemCodeListByCodeNo("C118");
		//港澳台
		List<CodeBean> setList108  = new ArrayList<CodeBean>();
		List<CodeBean> listCode108 = this.codeService.getSystemCodeListByCodeNo("C108");
		//企业信息
		for(VCompanyDetailBean vcdb : list){
			//国内所属专线
			String cbsServiceInside = vcdb.getCbsServiceInside();
			//国际所属专线
			String cbsServiceOuter  = vcdb.getCbsServiceOuter();
			
			String cbsSerInterna    = vcdb.getCbsSerInterna();
			
			
			
			if(StringUtils.isNotBlank(cbsServiceInside)){
				//如果现有产品包含国内编码 则放置返回list中
				for(CodeBean code :listCode116){
					if(cbsServiceInside.contains(code.getCodeKey()) && !setList116.contains(code)){
						setList116.add(code);
					}
				}
			}
			if(StringUtils.isNotBlank(cbsServiceOuter)){
				//如果现有产品包含国际编码 则放置返回list中
				for(CodeBean code :listCode118){
					
					
					if(cbsServiceOuter.contains(code.getCodeKey()) && !setList118.contains(code)){
						setList118.add(code);
						
						
					}
				}
				
			}
			if(StringUtils.isNotBlank(cbsSerInterna)){
				//如果现有产品包含国际编码 则放置返回list中
				for(CodeBean code :listCode108){
					if(null!= cbsServiceOuter && cbsServiceOuter.contains(code.getCodeKey()) && !setList108.contains(code)){
						setList108.add(code);
					}
				}
			}
		}
		
		model.addAttribute("hoteline",  setList116);
		model.addAttribute("countryine",setList118);
		model.addAttribute("interline", setList108);
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
