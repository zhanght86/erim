package com.erim.sz.company.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.CompanyBusinessBean;
import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.company.dao.VCompanyDetailDao;

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
	 * @描述: 组团社资源列表
	 * @作者: 王健
	 * @创建时间: 2015年12月6日 下午11:46:38
	 * @param baseBean
	 * @param model
	 * @return
	 */
	public List<VCompanyDetailBean> selectPageSell(VCompanyDetailBean baseBean, ModelMap model) {
		
		if(ErimConstants.COMPANYROLE_LINE.equals(baseBean.getCpyRoe())){
			CompanyBusinessBean business =  (CompanyBusinessBean)SecurityUtils.getSubject().getSession().getAttribute("userBussiness");
			//获取所有省
			String bus = "";
			if(StringUtils.isNotBlank(business.getCbsRanProvince1())) bus += business.getCbsRanProvince1() + ",";
			if(StringUtils.isNotBlank(business.getCbsRanProvince2())) bus += business.getCbsRanProvince2() + ",";
			if(StringUtils.isNotBlank(business.getCbsRanProvince3())) bus += business.getCbsRanProvince3() + ",";
			if(StringUtils.isNotBlank(business.getCbsRanProvince4())) bus += business.getCbsRanProvince4() + ",";
			if(StringUtils.isNotBlank(business.getCbsRanProvince5())) bus += business.getCbsRanProvince5() + ",";
			if(!"".equals(bus)) {
				bus = bus.substring(0,bus.length()-1);
				baseBean.setAstrprovince(bus.split(","));
			}
		}
		return vCompanyDetailDao.selectPage(baseBean, model);
    }
	
	
	/**
	 * @Title: selectPageLine 
	 * @Description: 地接社资源
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<VCompanyDetailBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月22日 下午2:32:10 
	 * @throws
	 */
	public List<VCompanyDetailBean> selectPageLine(VCompanyDetailBean baseBean, ModelMap model) {
		
		if(ErimConstants.COMPANYROLE_CREATER.equals(baseBean.getCpyRoe())){
			VCompanyDetailBean vdb = (VCompanyDetailBean)SecurityUtils.getSubject().getSession().getAttribute("userCommpany");
			if(null != vdb){
				String county   = vdb.getCbsProCounty();
				String city     = vdb.getCbsProCity();
				String province = vdb.getCbsProProvince();
				
				baseBean.setZyCountry(county);
				baseBean.setZyCity(city);
				baseBean.setZyProvince(province);
			}
		}
		
		List<VCompanyDetailBean> list = vCompanyDetailDao.selectPage(baseBean, model);
		
		return list;
    }
	
	
	/**
	 * @Title: selectById 
	 * @Description: 根据企业id查询企业信息
	 * @param @param id
	 * @param @return    设定文件 
	 * @return VCompanyDetailBean    返回类型 
	 * @author maoxian
	 * @date 2015年12月22日 下午1:26:16 
	 * @throws
	 */
	public VCompanyDetailBean selectById(Integer id){
		return this.vCompanyDetailDao.selectById(id);
	}
}
