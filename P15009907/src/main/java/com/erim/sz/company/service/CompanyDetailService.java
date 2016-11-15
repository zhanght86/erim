package com.erim.sz.company.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.CompanyBusinessBean;
import com.erim.sz.common.bean.CompanyContactPersonBean;
import com.erim.sz.common.bean.CompanyDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.common.mail.MailUtil;
import com.erim.sz.company.dao.CompanyDetailDao;
import com.erim.sz.system.bean.ZxSystemFuncRescourceBean;
import com.erim.sz.system.bean.ZxSystemRoleBean;
import com.erim.sz.system.bean.ZxSystemRoleFuncBean;
import com.erim.sz.system.bean.ZxSystemUserBean;
import com.erim.sz.system.dao.ZxSystemRoleDao;
import com.erim.sz.system.dao.ZxSystemUserDao;
import com.erim.sz.system.service.ZxSystemFuncRescourceService;
import com.erim.sz.system.service.ZxSystemRoleFuncService;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.utils.ip.IP4;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: CompanyDetailService 
 * @Description: 企业信息接口
 * @author maoxian
 * @date 2015年8月1日 上午11:54:28
 */
@Service("companyDetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CompanyDetailService {
	
	@Autowired
	private CompanyDetailDao 			 companyDetailDao;
	@Autowired
	private ZxSystemRoleDao 			 zxSystemRoleDao;
	@Autowired
	private ZxSystemUserDao		  	   	 zxSystemUserDao;
	@Autowired
	private CompanyContactPersonService  companyContactPersonService;
	@Autowired
	private CodeService 				 codeService;
	@Autowired
	private TmSystemRegionService 		 tmSystemRegionService;
	@Autowired
	private ZxSystemRoleFuncService      zxSystemRoleFuncService;
	@Autowired
	private ZxSystemFuncRescourceService zxSystemFuncRescourceService;
	
	/**
	 * @描述: 保存企业基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月10日 上午10:28:53
	 * @param companyBean 企业基础信息
	 * @param personBean 企业联系人信息
	 * @param map
	 * @param request
	 * @param currDate
	 * @return
	 */
	public Integer insertInfo(CompanyDetailBean companyBean, 
			CompanyContactPersonBean personBean, ModelMap map, HttpServletRequest request, String currDate) {
		
		try {
			Integer id = companyBean.getId();
			// 当ID不等于null时则为修改
			if (id != null && !"".equals(id)) {
				// 修改公司基础信息
				companyDetailDao.update(companyBean);
				// 人员
				personBean.setCpyId(id);
				companyContactPersonService.update(personBean);
				SecurityUtils.getSubject().getSession().setAttribute("cpyId", id);
				return CommonUtil.SUCCESS;
			}
			/*
			 * 公司基础信息
			 */
			// 获取当前时间
			companyBean.setCpyCreatedate(new Date());
			// 是否审核与否
			companyBean.setCpyIsThrough(ErimConstants.YESORNO_NO);
			// 获取当前ip
			companyBean.setCpyCreateip(IP4.getIP4(request));
			// 公司类型-专线商
			companyBean.setCpyRoe(ErimConstants.COMPANYROLE_LINE);
			companyDetailDao.insert(companyBean);
			/*
			 * 联系人信息
			 */
			Integer cpyId = companyBean.getId();
			personBean.setCpyId(cpyId);
			companyContactPersonService.insert(personBean);
			SecurityUtils.getSubject().getSession().setAttribute("cpyId", cpyId);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @Title: selectById 
	 * @Description: 根据企业id查询企业基本信息
	 * @param @param id
	 * @param @return    设定文件 
	 * @return CompanyDetailBean    返回类型 
	 * @author maoxian
	 * @date 2015年11月29日 上午10:50:13 
	 * @throws
	 */
	public CompanyDetailBean selectById(Integer id){
		return this.companyDetailDao.getDetailbyId(id);
	}
	
	/**
	 * @方法名: insertLoginUser
	 * @描述: 新增登陆信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 上午11:24:09 
	 * @param map
	 * @param bean
	 * @param cpyId
	 * @return
	 */
	public Integer insertLoginUser(ModelMap map, ZxSystemUserBean bean) {
		
		Integer result = CommonUtil.ERROR;
		
		/**
		 * 验证登录名是否存在
		 */
		ZxSystemUserBean userBean = new ZxSystemUserBean();
		// 登录名
		String userName = bean.getZxUserLoginname();
		userBean = zxSystemUserDao.selectUserByLoginname(userName);
		// 当登录名已存在时，直接返回失败。
		if (userBean != null) {
			return  CommonUtil.ERROR;
		}
		
		/**
		 * 执行插入
		 */
		try {
			/**
			 * 插入角色
			 */
			Integer cpyId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("cpyId"); 
			// 插入角色表
			ZxSystemRoleBean roleBean = new ZxSystemRoleBean();
			roleBean.setZxRoleName("主账户");
			roleBean.setCpyId(cpyId);
			zxSystemRoleDao.insert(roleBean);
			
			/**
			 * 插入权限
			 */
			List<ZxSystemFuncRescourceBean> listFunc = zxSystemFuncRescourceService.selectAll();
			List<ZxSystemRoleFuncBean> listRoleFuncBean = new ArrayList<ZxSystemRoleFuncBean>();
			for(ZxSystemFuncRescourceBean res : listFunc){
				ZxSystemRoleFuncBean rolefunbean = new ZxSystemRoleFuncBean();
				rolefunbean.setZxRoleId(roleBean.getId());
				rolefunbean.setZxFuncCode(res.getZxFuncRescourceCode());
				listRoleFuncBean.add(rolefunbean);
			}
			zxSystemRoleFuncService.insertList(listRoleFuncBean);;
			
			/**
			 * 插入用户
			 */
			bean.setZxRoleId(roleBean.getId());
			bean.setCpyId(cpyId);
			bean.setZxIsThrough(ErimConstants.YESORNO_NO);
			bean.setZxUserPassword(DigestUtils.md5Hex(bean.getZxUserPassword()));
			
			// 保存前，先清空该企业ID下面所有用户，防止重复
			zxSystemUserDao.deleteUserByCpyId(bean);
			// 执行新增
			zxSystemUserDao.insert(bean);
			
			// 发送邮件
			sendMail(cpyId);
			
			result = CommonUtil.SUCCESS;
		} catch (Exception e) {
			result = CommonUtil.ERROR;
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * @描述: 发送邮件
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月2日 下午5:25:07
	 * @param cpyId
	 */
	public void sendMail(Integer cpyId) {
		
		// 根据ID获取一条公司信息
		CompanyDetailBean company = selectById(cpyId);
		// 邮箱
		String cpyEmail = company.getCpyEmail();
		// 发送邮件
		MailUtil.sendMail(cpyEmail);
	}
	
	/**
	 * @Title: selectBeanById 
	 * @Description: 根据企业id查询企业基础信息
	 * @param @param id
	 * @param @return    设定文件 
	 * @return CompanyDetailBean    返回类型 
	 * @throws
	 */
	public CompanyDetailBean selectBeanById(int id){
		return companyDetailDao.getBeanById(id);
	}
	
	/**
	 * @方法名: showInfoPage
	 * @描述: 打开修改公司基础信息页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 上午11:29:28 
	 * @param map
	 * @param bean
	 * @return
	 */
	public CompanyDetailBean showInfoPage(ModelMap map, CompanyBusinessBean bean) {
		CompanyDetailBean model = new CompanyDetailBean();
		// 公司ID
		Integer id = (Integer) SecurityUtils.getSubject().getSession().getAttribute("cpyId");
		// 根据ID获取一条公司信息
		model = companyDetailDao.getBeanById(id);
		map.addAttribute("companyDetail", model);
		
		// 根据公司ID获取一条联系人信息
		CompanyContactPersonBean person = new CompanyContactPersonBean();
		person.setCpyId(id);
		CompanyContactPersonBean personModel = companyContactPersonService.getPersonById(person);
		map.addAttribute("personDetail", personModel);
		
		return model;
	}
	
	
	/**
	 * @Title: selectCompanyByBusiness 
	 * @Description: 获取专线可服务范围范围内的所有组团
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月2日 下午9:12:48 
	 * @throws
	 */
	public void selectCompanySellByBuiness(ModelMap model){
		
		//分页
		CompanyDetailBean baseBean = new CompanyDetailBean();
		baseBean.setN(10);
		baseBean.setCpyRoe(ErimConstants.COMPANYROLE_SELLER);
		// 查询同城列表
		List<CompanyDetailBean> listCompanyDetailBean =  companyDetailDao.selectPageSell(baseBean, model);
		for (int i = 0; i < listCompanyDetailBean.size(); i++) {
			CompanyDetailBean detail = listCompanyDetailBean.get(i);
			
			// 所在城市
			String cpyCity = detail.getCpyCity();
			if (cpyCity != null && !"".equals(cpyCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(cpyCity));
				detail.setCpyCity(str);
			}
			// 所在省
			String cpyProvince = detail.getCpyProvince();
			if (cpyProvince != null && !"".equals(cpyProvince)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(cpyProvince));
				detail.setCpyProvince(str);
			}
		}
		
		model.addAttribute("companyList", listCompanyDetailBean);
		
		//查询所有地接范围
//		List<ComBusRegionBean> listBusRegion = this.comBusRegionDao.listRegionBean("01");
//		//地接城市
//		StringBuffer sb = new StringBuffer();
//		//地接
//		for(ComBusRegionBean region : listBusRegion){
//			sb.append(region.getCbrCity()+",");
//		}
//		if(null != sb){
//			String[] region = sb.toString().split(",");
//			
//			//查询所有
//			this.companyDetailDao.ListSellByBusiness(region);
//			
//		}
		
		
	}
	
	
	/**
	 * @Title: selectPageCafeteria 
	 * @Description: 企业列表
	 * @param @param baseBean
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void selectPageCafeteria(CompanyDetailBean baseBean, ModelMap model){
		//生产商
		baseBean.setCpyRoe(ErimConstants.COMPANYROLE_CREATER);
		//分页
		baseBean.setN(10);
		List<CompanyDetailBean> companyList = this.companyDetailDao.selectPageCafeteria(baseBean, model);
		
		model.put("companyList", companyList);
	}
	
	/**
	 * 
	 * @方法名: setCode
	 * @描述: 字典
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 上午11:30:07 
	 * @param map
	 *
	 */
	public void setCode(ModelMap map) {
		// 省
		map.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		// 国家
		map.addAttribute("guojia", codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY));
		// 专线注册省
		map.addAttribute("lineProvince", codeService.getSystemCodeByCodeNo("C116"));
		// 专线注册国家
		map.addAttribute("lineCountry", codeService.getSystemCodeByCodeNo("C118"));
	}
	
	/**
	 * @Title: lockCpy 
	 * @Description: 用户锁定
	 * @param @param cpyid    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月22日 下午11:37:54 
	 * @throws
	 */
	public void lockCpy(Integer cpyid){
		this.companyDetailDao.lockCpy(cpyid);
	}
	
	/**
	 * @Title: unlock 
	 * @Description: 解除锁定
	 * @param @param cpyid    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月23日 下午12:29:23 
	 * @throws
	 */
	public void unlock(Integer cpyid){
		this.companyDetailDao.unlock(cpyid);
	}
}
