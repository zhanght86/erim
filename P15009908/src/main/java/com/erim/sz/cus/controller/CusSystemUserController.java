package com.erim.sz.cus.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.util.AddressUtils;
import com.erim.sz.cus.bean.CusSystemUserBean;
import com.erim.sz.cus.service.CusSystemRoleService;
import com.erim.sz.cus.service.CusSystemUserService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.utils.ip.IP4;

import common.Logger;

/**
 * @ClassName: IndexController 
 * @Description: 登录
 * @author maoxian
 * @date 2015年8月1日 上午11:04:51
 */
@Controller
public class CusSystemUserController {

	//声明日志
	private Logger logger = Logger.getLogger(CusSystemFuncController.class);
	
	@Autowired
	private CusSystemUserService cusSystemUserService;
	@Autowired
	private CusSystemRoleService cusSystemRoleService;
	
	/**
	 * @Title: ajaxCheckLoginName 
	 * @Description: 判断用户是否重复
	 * @param @param loginname
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/ajaxCheckLoginName")
	public List<Object> ajaxCheckLoginName(String fieldId,String fieldValue){
		
		//检查用户名是否已经被注册
		return this.cusSystemUserService.ajaxCheckLoginName(fieldId,fieldValue);
	}
	
    /**
     * 
     * @Title: login 
     * @Description: 登录页
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/login")
    public String loginPage(){
    	return "/login/login";
    }

    /**
     * @Title: lgoin 
     * @Description: 登录方法
     * @param @param model
     * @param @param request
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/cus/user/login")
    public String login(ModelMap model,String username,String password,String checkcode,HttpServletRequest request){

    	System.out.println("登录Session = " + SecurityUtils.getSubject().getSession().getId());
    	// 验证码
    	String code = (String) SecurityUtils.getSubject().getSession().getAttribute("sessionCode");
    	// 判断用户名是否为空
    	if(StringUtils.isEmpty(username)) return "redirect:/login";
    	// 判断验证码/ 当Session中取得code为null时，也允许通过。
    	if (checkcode.equals(code)) {
    		// 判断是否登录
    		if(cusSystemUserService.isLogin(model,username, password)) {
    			// 用户登陆之后更改登陆时间 和登陆IP
    			String userName =  SecurityUtils.getSubject().getSession().getAttribute("userName").toString();
    			if(StringUtils.isNotBlank(userName)) {
    				// 获取当IP
    				String ip = IP4.getIP4(request);
    				CusSystemUserBean user = cusSystemUserService.selectUserByLoginname(userName);
    				user.setCusLastLoginIp(ip);
    				user.setCusLastLoginTime(new Date());
    				user.setCusLastLoginAddress(AddressUtils.getAddresses("ip=" + ip, "utf-8"));
    				// 修改登录状态
    				cusSystemUserService.updateLogin(user);
    			}
    			return "redirect:/index";
    		}
    	} else {
    		model.put("errorMsg", "验证码输入错误");
    	}
    	return loginPage();
    }
    
    /**
     * 
     * @Title: updatePsd 
     * @Description: 修改密码
     * @param @param model
     * @param @param loginname
     * @param @param psd
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/cus/user/updatePsd")
    public @ResponseBody Integer updatePsd(ModelMap model,HttpServletRequest request){
    	return this.cusSystemUserService.updatePsd(request);
    }
    
    
    /**
     * @Title: checkPassword 
     * @Description: 检查密码
     * @param @param model
     * @param @param request
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/cus/user/checkPassword")
    public String checkPassword(ModelMap model,HttpServletRequest request){
    	this.cusSystemUserService.updatePsd(request);
    	return this.updatePadPage();
    }
    
    /**
     * @Title: updatePadPage 
     * @Description: 跳转修改密码页面
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/cus/user/updatePadPage")
    public String updatePadPage(){
    	return "/cus/user/updatePsd";
    }
    
    /**
     * 
     * @Title: loginOut 
     * @Description: 注销用户
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping("loginOut")
    private String loginOut(){
    	this.cusSystemUserService.loginOut();
    	return this.loginPage();
    }
    
    
    ////////////////////////////////////////////////基本信息/////////////////////////////////////////////////////
    
    /**
     * 
     * @Title: showUser 
     * @Description: 用户信息列表
     * @param @param model
     * @param @param cmsSystemUserBean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/cus/user/list")
    public String showUser(ModelMap model,@ModelAttribute("cmsSystemUser") CusSystemUserBean cmsSystemUserBean) throws ErimException{
    	this.cusSystemUserService.selectPage(cmsSystemUserBean, model);
		return "/cus/user/list";
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增页面
     * @param @param model
     * @param @param cusSystemUserBean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/cus/user/insertPage")
    public String insertPage(ModelMap model){
    	int cpyid = CommonUtil.getCpyId();
    	model.addAttribute("roleList", this.cusSystemRoleService.selectCusSystemRoleByCpyId(cpyid));
    	return "/cus/user/insert";
    }
    
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增
     * @param @param model
     * @param @param cusSystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/cus/user/insert")
    public int insert(ModelMap model,CusSystemUserBean cusSystemUserBean){
    	try{
    		//获取新增用户名登录账号
    		String username = cusSystemUserBean.getCusUserLoginname();
    		if(StringUtils.isNotBlank(username)){
    			CusSystemUserBean user = this.cusSystemUserService.selectUserByLoginname(username);
    			//如果用户名存在则返回失败
    			if(null!=user) return 0;
    			cusSystemUserBean.setCusIsDelStatus("1");
    			this.cusSystemUserService.insert(cusSystemUserBean);
    			return 1;
    		}else{
    			return 0;
    		}
    	}catch(Exception e){
    		logger.error("用户新增出错", e);
    		return 0;
    	}
    }
    
    /**
     * 
     * @Title: updatePage 
     * @Description: 修改方法
     * @param @param model
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/cus/user/updatePage")
    public String updatePage(ModelMap model,int id){
    	//用户角色信息
    	int cpyid = CommonUtil.getCpyId();
    	model.addAttribute("roleList", this.cusSystemRoleService.selectCusSystemRoleByCpyId(cpyid));
    	//查询id值为id的对象
    	this.cusSystemUserService.selectUserById(id,model);
    	return "/cus/user/update";
    }
    
    /**
     * @描述: 修改用户保存
     * @作者: 
     * @创建时间: 2015年12月4日 下午12:30:38
     * @param model
     * @param cusSystemUserBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/cus/user/update")
    public Integer update(ModelMap model,CusSystemUserBean cusSystemUserBean){
    	return cusSystemUserService.update(cusSystemUserBean);
    }
    
    /**
     * @throws ErimException 
     * @Title: delete 
     * @Description:  停用
     * @param @param model
     * @param @param id
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @throws
     */
    @RequestMapping(value="/cus/user/delete")
    public String delete(ModelMap model,CusSystemUserBean cusSystemUserBean) throws ErimException{
		this.cusSystemUserService.delete(cusSystemUserBean);
		return this.showUser(model, cusSystemUserBean);
    }
}