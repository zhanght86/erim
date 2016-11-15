package com.erim.sz.company.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.CompanyBusinessBean;
import com.erim.sz.common.bean.CompanyContactPersonBean;
import com.erim.sz.common.bean.CompanyDetailBean;
import com.erim.sz.company.service.CompanyBusinessService;
import com.erim.sz.company.service.CompanyDetailService;
import com.erim.sz.cus.bean.CusSystemUserBean;
import com.erim.sz.cus.service.CusSystemUserService;
import com.erim.web.service.CodeService;

/**
 * @ClassName: CompanyRegeditController
 * @Description: 企业注册信息
 * @Author: 宁晓强
 * @Date: 2015年10月1日 下午3:40:37
 */
@Controller
public class CompanyRegeditController {
	
	@Autowired
	private CodeService codeService;
	@Autowired
	private CompanyDetailService  companyDetailService;
	@Autowired
	private CompanyBusinessService companyBusinessService;
	@Autowired
	private CusSystemUserService cusSystemUserService;
	
	/**
	 * @Title: infoCreater
	 * @Description: 注册基本信息页面
	 * @param map
	 * @return 注册基本信息页面
	 */
	@RequestMapping(value = "/company/regedit/info")
	public String regeditInfoPage(ModelMap map,HttpServletRequest request) {
		map.addAttribute("yjUserCode", request.getParameter("userCode"));
		companyDetailService.setCode(map);
		return "/company/regedit/info";
	}

	/**
	 * @描述: 保存公司基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月10日 下午10:22:24
	 * @param companyBean
	 * @param personBean
	 * @param map
	 * @param request
	 * @param currDate
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/company/regedit/saveInfo")
	public Integer regeditSaveInfo(CompanyDetailBean companyBean, 
			CompanyContactPersonBean personBean,ModelMap map,HttpServletRequest request) {
		// 执行保存企业基础信息
		return companyDetailService.insertCompany(companyBean, personBean, map, request);
	}
	
	/**
	 * @方法名: businessCreater
	 * @描述:	　打开业务范围页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月27日 下午2:39:03 
	 * @param map
	 * @return
	 */
	@RequestMapping("/company/regedit/business")
	public String regeditBusinessPage(CompanyDetailBean companyBean, 
			CompanyContactPersonBean personBean, ModelMap map, HttpServletRequest request) {
		
		// 获取业务范围页面参数
		companyDetailService.setCode(map);
		
		return "/company/regedit/business";
	}

	/**
	 * @描述: 保存公司业务范围信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月10日 下午10:27:53
	 * @param bean
	 * @param map
	 * @param currDate
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/company/regedit/saveBusiness")
	public Integer regeditSaveBusiness(CompanyBusinessBean bean, ModelMap map) {
		// 执行保存业务范围信息
		return companyBusinessService.insertBusinewss(map, bean);
	}
	
	/**
	 * @方法名: regeditUserPage
	 * @描述: 打开登陆资料页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月27日 下午6:17:27 
	 * @param bean
	 * @param map
	 * @return
	 */
	@RequestMapping("/company/regedit/user")
	public String regeditUserPage() {
		
		return "/company/regedit/user";
	}
	
	/**
	 * @方法名: loginUserCreater
	 * @描述: 保存登陆资料信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月28日 上午11:25:50 
	 * @param map
	 * @param bean
	 * @param cpyId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/company/regedit/saveUser")
	public Integer regeditSaveUser(ModelMap map, CusSystemUserBean bean, Integer cpyId) {
		
		return companyDetailService.insertLoginUser(map, bean, cpyId);
	}
	
	/**
	 * @描述: 打开注册成功页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月10日 下午8:16:41
	 * @return
	 */
	@RequestMapping("/company/regedit/success")
	public String regeditSuccessPage() {
		
		return "/company/regedit/success";
	}
	
	/**
	 * @方法名: showInfoPage
	 * @描述: 返回公司基础信息修改页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月28日 下午3:42:37 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/company/regedit/updateInfo")
	public String updateInfoPage(ModelMap map, CompanyBusinessBean bean) {
		// 获取数据
		companyDetailService.showInfoPage(map, bean);
		// 返回页面所需的参数
		companyDetailService.setCode(map);
		
		return "/company/regedit/updateInfo";
	}

	/**
	 * @Title: ajaxCheckLoginName 
	 * @Description: 查看用户是否已经被注册 
	 * @param @param loginanme
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/company/regedit/ajaxCheckLoginName")
	public @ResponseBody Integer ajaxCheckLoginName(String loginanme){
		return this.cusSystemUserService.checkLoginName(loginanme);
	}
	
}
