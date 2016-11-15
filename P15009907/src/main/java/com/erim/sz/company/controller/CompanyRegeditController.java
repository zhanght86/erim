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
import com.erim.sz.system.bean.ZxSystemUserBean;
import com.erim.sz.system.service.ZxSystemUserService;

/**
 * @ClassName: CompanyRegeditController 
 * @Description: 企业注册信息
 * @author maoxian
 * @date 2015年8月28日 下午1:59:54 
 */
@Controller
public class CompanyRegeditController {

	@Autowired
	private CompanyDetailService    companyDetailService;
	@Autowired
	private CompanyBusinessService	companyBusinessService;
	@Autowired
	private ZxSystemUserService     zxSystemUserService;

	///////////////////////////////////////////////// 通用  //////////////////////////////////////////////////////
	
	/**
	 * @方法名: regeditInfoPage
	 * @描述: 注册基本信息页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 上午11:38:01 
	 * @param map
	 * @return
	 */
	@RequestMapping("/company/regedit/info")
	public String regeditInfoPage(ModelMap map,HttpServletRequest request) {
		map.addAttribute("yjUserCode", request.getParameter("userCode"));
		companyDetailService.setCode(map);
		return "/company/regedit/info";
	}
	
	/**
	 * @描述: 保存公司基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月11日 上午10:49:25
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
			CompanyContactPersonBean personBean, ModelMap map, HttpServletRequest request, String currDate) {
		// 执行保存公司基础信息
		return companyDetailService.insertInfo(companyBean, personBean, map, request, currDate);
	}
	
	/**
	 * @方法名: regeditBusinewssPage
	 * @描述: 打开公司业务范围信息页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 上午11:41:23 
	 * @param companyBean 企业基础信息
	 * @param personBean 企业联系人信息
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("/company/regedit/business")
	public String regeditBusinewssPage(ModelMap map) {
		companyDetailService.setCode(map);
		return "/company/regedit/business";
	}
	
	/**
	 * @描述: 保存公司业务范围信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月11日 上午11:05:06
	 * @param bean
	 * @param map
	 * @param currDate
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/company/regedit/saveBusiness")
	public Integer regeditSaveBusiness(CompanyBusinessBean bean, ModelMap map, String currDate, HttpServletRequest request) {
		// 执行新增
		return companyBusinessService.insert(map, bean, currDate, request);
	}
	
	/**
	 * @方法名: regeditUserPage
	 * @描述: 打开登陆资料页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 上午11:43:56 
	 * @param bean
	 * @param map
	 * @return
	 */
	@RequestMapping("/company/regedit/user")
	public String regeditUserPage() {
		
		return "/company/regedit/user";
	}
	
	/**
	 * @描述: 保存登录资料
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月11日 上午11:13:57
	 * @param map
	 * @param bean
	 * @param cpyId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/company/regedit/saveUser")
	public Integer regeditSaveUser(ModelMap map, ZxSystemUserBean bean) {
		return companyDetailService.insertLoginUser(map, bean);
	}
	
	/**
	 * @方法名: regeditSuccessPage
	 * @描述: 跳转注册成功页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:28:28 
	 * @param map
	 * @param bean
	 * @param cpyId
	 * @return
	 */
	@RequestMapping("/company/regedit/success")
	public String regeditSuccessPage() {
		
		return "/company/regedit/success";
	}
	
	/**
	 * @方法名: updateBusinessPage
	 * @描述: 跳转公司业务范围信息修改页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:33:24 
	 * @param map
	 * @param bean
	 * @return
	 */
	public String updateBusinessPage(ModelMap map, ZxSystemUserBean bean) {
		
		companyBusinessService.updateBusinessPage(map, bean);
		
		return "/company/regedit/updateBusiness";
	}
	
	/**
	 * @方法名: updateDetailPage
	 * @描述: 修改公司基础信息页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午1:35:52 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/company/regedit/updateInfo")
	public String updateDetailPage(ModelMap map, CompanyBusinessBean bean) {
		
		// 获取数据
		companyDetailService.showInfoPage(map, bean);
		
		companyDetailService.setCode(map);
		
		return "/company/regedit/updateInfo";
	}
	
	/**
	 * @Title: ajaxCheckLoginName 
	 * @Description: 查看用户是否已经呗注册 
	 * @param @param loginanme
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/company/regedit/ajaxCheckLoginName")
	public @ResponseBody Integer ajaxCheckLoginName(String loginanme){
		return zxSystemUserService.checkLoginName(loginanme);
	}
}
