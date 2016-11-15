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
import com.erim.sz.system.bean.SellSystemFuncRescourceBean;
import com.erim.sz.system.bean.SellSystemRoleBean;
import com.erim.sz.system.bean.SellSystemRoleFuncBean;
import com.erim.sz.system.bean.SellSystemUserBean;
import com.erim.sz.system.dao.SellSystemUserDao;
import com.erim.sz.system.service.SellSystemFuncRescourceService;
import com.erim.sz.system.service.SellSystemRoleFuncService;
import com.erim.sz.system.service.SellSystemRoleService;
import com.erim.sz.system.service.SellSystemUserService;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.utils.ip.IP4;
import com.erim.web.service.CodeService;

/**
 * @ClassName: CompanyDetailService 
 * @Description: 企业信息接口
 * @author maoxian
 * @date 2015年8月1日 上午11:54:28
 */
@Service("companyDetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CompanyDetailService {
	
	@Autowired
	private CompanyDetailDao            companyDetailDao;
	@Autowired
	private SellSystemRoleService       sellSystemRoleService;
	@Autowired
	private SellSystemUserService       sellSystemUserService;
	@Autowired
	private CompanyContactPersonService companyContactPersonService;
	@Autowired
	private TmSystemRegionService 		tmSystemRegionService;
	@Autowired
	private CodeService					codeService;
	@Autowired
	private SellSystemUserDao 			sellSystemUserDao;
	@Autowired
	private SellSystemFuncRescourceService sellSystemFuncRescourceService;
	@Autowired
	private SellSystemRoleFuncService sellSystemRoleFuncService;
	
	/**
	 * @Title: insert 
	 * @Description: 插入方法
	 * @param @param companyDetailBean
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public Integer insert(CompanyDetailBean        companyDetailBean,
			           CompanyContactPersonBean companyContactPersonBean,
					   SellSystemUserBean        sellSystemUserBean,
					   HttpServletRequest       request){
		try{
			
			////////////////////////////////////////插入公司表///////////////////////////////////////////////////////////
			//获取当前时间
			companyDetailBean.setCpyCreatedate(new Date());
			//是否审核为否
			companyDetailBean.setCpyIsThrough(ErimConstants.YESORNO_NO);
			//获取当前ip
			companyDetailBean.setCpyCreateip(IP4.getIP4(request));
			this.companyDetailDao.insert(companyDetailBean);
			
			////////////////////////////////////////插入联系人表//////////////////////////////////////////////////////////
			
			companyContactPersonBean.setCpyId(companyDetailBean.getId());
			this.companyContactPersonService.insert(companyContactPersonBean);
			
			////////////////////////////////////////插入角色表///////////////////////////////////////////////////////////
			
			SellSystemRoleBean roleBean = new SellSystemRoleBean();
			roleBean.setSellRoleName("主账号");
			roleBean.setCpyId(companyDetailBean.getId());
			this.sellSystemRoleService.insert(roleBean);
			
			////////////////////////////////////////插入用户表///////////////////////////////////////////////////////////
			
			sellSystemUserBean.setSellRoleId(roleBean.getId());
			sellSystemUserBean.setCpyId(companyDetailBean.getId());
			sellSystemUserBean.setSellIsThrough(ErimConstants.YESORNO_NO);
			sellSystemUserBean.setSellUserPassword(DigestUtils.md5Hex(sellSystemUserBean.getSellUserPassword()));
			this.sellSystemUserService.insert(sellSystemUserBean);
			
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @方法名: insertInfo
	 * @描述: 新增公司基础信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午2:05:11 
	 * @param companyBean
	 * @param personBean
	 * @param map
	 * @param request
	 * @return
	 */
	public Integer insertInfo(CompanyDetailBean companyBean, 
			CompanyContactPersonBean personBean, ModelMap map, HttpServletRequest request) {
		
		try {
			Integer id = companyBean.getId();
			// 当ID不等于nul时则为修改
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
			// 公司类型-组团社
			companyBean.setCpyRoe(ErimConstants.COMPANYROLE_SELLER);
			companyDetailDao.insert(companyBean);
			
			// 返回公司ID
			Integer cpyId = companyBean.getId();
			/*
			 * 修改编码
			 */
			CompanyDetailBean codeBean = new CompanyDetailBean();
			//　生成一个编码
			Integer code = 19891106;
			code = code+cpyId;
			codeBean.setId(cpyId);
			codeBean.setCpyCode(String.valueOf(code));
			companyDetailDao.updateCode(codeBean);
			/*
			 * 联系人信息
			 */
			personBean.setCpyId(cpyId);
			companyContactPersonService.insert(personBean);
			
			SecurityUtils.getSubject().getSession().setAttribute("cpyId", cpyId);
			System.out.println(" sessionid = " + SecurityUtils.getSubject().getSession().getId());
			
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @方法名: insertLoginUser
	 * @描述: 保存登陆信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 下午2:00:23 
	 * @param map
	 * @param bean
	 * @param cpyId
	 * @return
	 */
	public Integer insertLoginUser(ModelMap map, SellSystemUserBean bean) {
		Integer result = CommonUtil.ERROR;
		
		try {
			
			/**
			 * 验证登录名是否存在
			 */
			SellSystemUserBean userBean = new SellSystemUserBean();
			// 登录名
			String userName = bean.getSellUserLoginname();
			userBean = sellSystemUserDao.selectUserByLoginname(userName);
			// 当登录名已存在时，直接返回失败
			if (userBean != null) {
				return CommonUtil.ERROR;
			}
			System.out.println(" sessionid = " + SecurityUtils.getSubject().getSession().getId());
			Integer cpyId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("cpyId");
			
			// 插入角色表
			SellSystemRoleBean roleBean = new SellSystemRoleBean();
			roleBean.setSellRoleName("主账号");
			roleBean.setCpyId(cpyId);
			sellSystemRoleService.insertRole(roleBean);
			
			/**
			 * 插入权限
			 */
			List<SellSystemFuncRescourceBean> listFunc = sellSystemFuncRescourceService.selectAll();
			List<SellSystemRoleFuncBean> listRoleFuncBean = new ArrayList<SellSystemRoleFuncBean>();
			for(SellSystemFuncRescourceBean res : listFunc) {
				SellSystemRoleFuncBean rolefunBean = new SellSystemRoleFuncBean();
				rolefunBean.setSellRoleId(roleBean.getId());
				rolefunBean.setSellFuncCode(res.getSellFuncRescourceCode());
				listRoleFuncBean.add(rolefunBean);
			} 
			sellSystemRoleFuncService.insertList(listRoleFuncBean);
			
			/**
			 * 插入用户表
			 */
			bean.setSellRoleId(roleBean.getId());
			bean.setCpyId(cpyId);
			bean.setSellIsThrough(ErimConstants.YESORNO_NO);
			bean.setSellUserPassword(DigestUtils.md5Hex(bean.getSellUserPassword()));
			
			// 保存前，先清空该企业ID下面所有用户，防止重复
			sellSystemUserDao.deleteUserByCpyId(bean);
			// 执行新增
			sellSystemUserDao.insert(bean);
			
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
		CompanyDetailBean company = selectBeanById(cpyId);
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
		CompanyDetailBean copmy=companyDetailDao.selectBeanById(id);
		return copmy;
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
		model = companyDetailDao.selectBeanById(id);
		map.addAttribute("companyDetail", model);
		
		// 根据公司ID获取一条联系人信息
		CompanyContactPersonBean person = new CompanyContactPersonBean();
		person.setCpyId(id);
		CompanyContactPersonBean personModel = companyContactPersonService.getPersonById(person);
		map.addAttribute("personDetail", personModel);
		
		return model;
	}
	
	
	/**
	 * @Title: selectLineCompany 
	 * @Description: 所有专线商
	 * @param @param bean
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void selectLineCompany(CompanyDetailBean bean,ModelMap model){
		bean.setCpyRoe(ErimConstants.COMPANYROLE_LINE);
		model.addAttribute("companyList", this.companyDetailDao.selectLineCompany(bean));
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
		//专线商
		baseBean.setCpyRoe(ErimConstants.COMPANYROLE_LINE);
		//分页
		baseBean.setN(10);
		
		List<CompanyDetailBean> listCompanyDetailBean = this.companyDetailDao.selectPageCafeteria(baseBean, model);
		model.addAttribute("companyList", listCompanyDetailBean);
	}
	
	/**
	 * @方法名: setCode
	 * @描述: 字典
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月4日 上午11:30:07 
	 * @param map
	 */
	public void setCode(ModelMap map) {
		// 省
		map.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		//国家
		map.addAttribute("guojia", codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY));
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
