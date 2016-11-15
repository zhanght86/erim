package com.erim.sz.zy.controller;

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
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.zy.bean.ZySystemUserBean;
import com.erim.sz.zy.service.ZySystemRoleService;
import com.erim.sz.zy.service.ZySystemUserService;
import com.erim.utils.ip.IP4;

import common.Logger;

/**
 * @ClassName: IndexController 
 * @Description: 登录
 * @author maoxian
 * @date 2015年8月1日 上午11:04:51
 */
@Controller
public class ZySystemUserController {

	//声明日志
	private Logger logger = Logger.getLogger(ZySystemFuncController.class);
	
	@Autowired
	private ZySystemUserService zySystemUserService;
	@Autowired
	private ZySystemRoleService zySystemRoleService;
	
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
		return this.zySystemUserService.ajaxCheckLoginName(fieldId,fieldValue);
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
    @RequestMapping(value="/zy/user/login")
    public String login(ModelMap model,String username,String password,String checkcode,HttpServletRequest request){

    	System.out.println("登录Session = " + SecurityUtils.getSubject().getSession().getId());
    	// 验证码
    	String code = (String) SecurityUtils.getSubject().getSession().getAttribute("sessionCode");
    	// 判断用户名是否为空
    	if(StringUtils.isEmpty(username)) return "redirect:/login";
    	// 判断验证码/ 当Session中取得code为null时，也允许通过。
    	if (checkcode.equals(code)) {
    		// 判断是否登录
    		if(zySystemUserService.isLogin(model,username, password)) {
    			// 用户登陆之后更改登陆时间 和登陆IP
    			String userName =  SecurityUtils.getSubject().getSession().getAttribute("userName").toString();
    			if(StringUtils.isNotBlank(userName)) {
    				// 获取当IP
    				String ip = IP4.getIP4(request);
    				ZySystemUserBean user = zySystemUserService.selectUserByLoginname(userName);
    				user.setZyLastLoginIp(ip);
    				user.setZyLastLoginTime(new Date());
    				user.setZyLastLoginAddress(AddressUtils.getAddresses("ip=" + ip, "utf-8"));
    				// 修改登录状态
    				zySystemUserService.updateLogin(user);
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
    @RequestMapping(value="/zy/user/updatePsd")
    public @ResponseBody Integer updatePsd(ModelMap model,HttpServletRequest request){
    	return this.zySystemUserService.updatePsd(request);
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
    @RequestMapping(value="/zy/user/checkPassword")
    public String checkPassword(ModelMap model,HttpServletRequest request){
    	this.zySystemUserService.updatePsd(request);
    	return this.updatePadPage();
    }
    
    /**
     * @Title: updatePadPage 
     * @Description: 跳转修改密码页面
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/zy/user/updatePadPage")
    public String updatePadPage(){
    	return "/zy/user/updatePsd";
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
    	this.zySystemUserService.loginOut();
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
    @RequestMapping(value="/zy/user/list")
    public String showUser(ModelMap model,@ModelAttribute("cmsSystemUser") ZySystemUserBean cmsSystemUserBean) throws ErimException{
    	this.zySystemUserService.selectPage(cmsSystemUserBean, model);
		return "/zy/user/list";
    }
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增页面
     * @param @param model
     * @param @param zySystemUserBean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/zy/user/insertPage")
    public String insertPage(ModelMap model){
    	int cpyid = CommonUtil.getCpyId();
    	model.addAttribute("roleList", this.zySystemRoleService.selectZySystemRoleByCpyId(cpyid));
    	return "/zy/user/insert";
    }
    
    
    /**
     * 
     * @Title: insert 
     * @Description: 新增
     * @param @param model
     * @param @param zySystemUserBean    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/zy/user/insert")
    public int insert(ModelMap model,ZySystemUserBean zySystemUserBean){
    	try{
    		//获取新增用户名登录账号
    		String username = zySystemUserBean.getZyUserLoginname();
    		if(StringUtils.isNotBlank(username)){
    			ZySystemUserBean user = this.zySystemUserService.selectUserByLoginname(username);
    			//如果用户名存在则返回失败
    			if(null!=user) return 0;
    			zySystemUserBean.setZyIsDelStatus("1");
    			this.zySystemUserService.insert(zySystemUserBean);
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
    @RequestMapping(value="/zy/user/updatePage")
    public String updatePage(ModelMap model,int id){
    	//用户角色信息
    	int cpyid = CommonUtil.getCpyId();
    	model.addAttribute("roleList", this.zySystemRoleService.selectZySystemRoleByCpyId(cpyid));
    	//查询id值为id的对象
    	this.zySystemUserService.selectUserById(id,model);
    	return "/zy/user/update";
    }
    
    /**
     * @描述: 修改用户保存
     * @作者: 
     * @创建时间: 2015年12月4日 下午12:30:38
     * @param model
     * @param zySystemUserBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/zy/user/update")
    public Integer update(ModelMap model,ZySystemUserBean zySystemUserBean){
    	return zySystemUserService.update(zySystemUserBean);
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
    @RequestMapping(value="/zy/user/delete")
    public String delete(ModelMap model,ZySystemUserBean zySystemUserBean) throws ErimException{
		this.zySystemUserService.delete(zySystemUserBean);
		return this.showUser(model, zySystemUserBean);
    }
}