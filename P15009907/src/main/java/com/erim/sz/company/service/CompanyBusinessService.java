package com.erim.sz.company.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.ComBusRegionBean;
import com.erim.sz.common.bean.CompanyBusinessBean;
import com.erim.sz.company.dao.ComBusRegionDao;
import com.erim.sz.company.dao.CompanyBusinessDao;
import com.erim.sz.system.bean.ZxSystemUserBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @类名: CompanyBusinessService
 * @描述: 公司业务范围信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年11月4日 下午1:24:02
 */
@Service("companyBusinessService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CompanyBusinessService {

	@Autowired
	private CompanyBusinessDao companyBusinessDao;
	@Autowired
	private ComBusRegionDao    comBusRegionDao;
	
	
	/**
	 * @Title: selectBuinessByCpyId 
	 * @Description: 根据企业id 查询企业业务范围
	 * @param @param cpyId
	 * @param @return    设定文件 
	 * @return CompanyBusinessBean    返回类型 
	 * @author maoxian
	 * @date 2015年12月28日 下午9:06:03 
	 * @throws
	 */
	public CompanyBusinessBean selectBuinessByCpyId(Integer cpyId){
		return this.companyBusinessDao.getBusinessById(cpyId);
	}
	
	/**
	 * @方法名: insert
	 * @描述: 新增公司业务范围信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:21:08 
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer insert(ModelMap map, CompanyBusinessBean bean, String currDate, HttpServletRequest request) {
		Integer result = CommonUtil.ERROR;
		
		// 公司ID
		Integer cpyId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("cpyId");
		//　录入业务地区
		result = insertBusRegion(request, cpyId);
		// 如果录入异常直接返回失败
		if (result == CommonUtil.ERROR) {
			return result;
		}
		
		bean.setCpyId(cpyId);
		// 国际业务方向
		String servcieOuter = bean.getCbsServiceOuter();
		// 国际地接涉及区域 - 完全从国际业务方向获取
		bean.setCbsNurState(servcieOuter);
		// 国际其他业务方向
		String serviceRest = bean.getCbsServiceRest();
		// 当国际其他业务方向不为空时，添加到国际其他地接涉及区域。
		if (serviceRest != null && !"".equals(serviceRest)) {
			// 国际其他地接涉及区域
			String nurRest = bean.getCbsNurRest();
			bean.setCbsNurRest(serviceRest + "," + nurRest);
		}
		
		// 执行新增前，先预删除该企业ID相关的业务信息，防止重复。
		companyBusinessDao.deleteBusinessByCpyId(bean);
		// 执行新增
		companyBusinessDao.insert(bean);
		return CommonUtil.SUCCESS;
	}
	
	/**
	 * @描述: 录入业务地区
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月10日 下午6:00:18
	 * @param request
	 * @param cpyId
	 */
	public Integer insertBusRegion(HttpServletRequest request, Integer cpyId) {
		
		Integer result = CommonUtil.ERROR;
		try {
			// 业务区域
			ComBusRegionBean regionModel = new ComBusRegionBean();
			// 地接涉及区域省市县
			String[] nurProvinceA = request.getParameterValues("cbsNurProvince");
			String[] nurCityA = request.getParameterValues("cbsNurCity");
			String[] nurCountyA = request.getParameterValues("cbsNurCounty");
			// 录入地接涉及区域
			for (int i = 0; i < nurProvinceA.length; i++) {
				// 省
				String proStr = nurProvinceA[i];
				if (proStr != null && !"".equals(proStr)) {
					regionModel.setCpyId(cpyId);// 公司iD
					regionModel.setCbrBusType("01");// 01代表地接涉及区域
					regionModel.setCbrProvince(proStr);// 省
					regionModel.setCbrCity(nurCityA[i]);// 市
					regionModel.setCbrCounty(nurCountyA[i]);// 县
					// 执行新增前清库
					comBusRegionDao.deleteRegion(regionModel);
					// 执行新增
					comBusRegionDao.insert(regionModel);
				}
			}
			// 可服务地区省市县
			String[] srlProvinceA = request.getParameterValues("cbsSrlProvince");
			String[] srlCityA = request.getParameterValues("cbsSrlCity");
			String[] srlCountyA = request.getParameterValues("cbsSrlCounty");
			// 录入可服务地区
			for (int i = 0; i < srlProvinceA.length; i++) {
				// 省
				String proStr = srlProvinceA[i];
				if (proStr != null && !"".equals(proStr)) {
					regionModel.setCpyId(cpyId);// 公司iD
					regionModel.setCbrBusType("02");// 02代表可服务区域
					regionModel.setCbrProvince(proStr);// 省
					regionModel.setCbrCity(srlCityA[i]);// 市
					regionModel.setCbrCounty(srlCountyA[i]);// 县
					// 执行新增前清库
					comBusRegionDao.deleteRegion(regionModel);
					// 执行新增
					comBusRegionDao.insert(regionModel);
				}
			}
			result = CommonUtil.SUCCESS;
		} catch (Exception e) {
			result = CommonUtil.ERROR;
		}
		return result;
	}
	
	/**
	 * @方法名: showBusinessPage
	 * @描述: 打开修改业务范围信息页面 - 暂时废弃
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:22:54 
	 * @param map
	 * @param bean
	 */
	public void updateBusinessPage(ModelMap map, ZxSystemUserBean bean) {
		Integer cpyId = bean.getCpyId();
		CompanyBusinessBean model = new CompanyBusinessBean();
		// 根据ID获取一条信息
		model = companyBusinessDao.getBusinessById(cpyId);
		map.addAttribute("business", model);
		map.addAttribute("cpyId", cpyId);
	}
}
