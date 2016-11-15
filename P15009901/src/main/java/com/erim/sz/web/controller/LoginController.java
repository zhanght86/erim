package com.erim.sz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.MallUsersBean;
import com.erim.sz.web.service.MallUsersService;

/**
 * @ClassName: LoginController 
 * @Description: 登陆页面
 * @author maoxian
 * @date 2015年10月5日 上午11:48:32
 */
@Controller
public class LoginController {

	@Autowired
	private MallUsersService mallUsersService;
	
	/**
	 * @Title: login 
	 * @Description: 登陆页面
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/login/login")
	public String login(MallUsersBean userBean,ModelMap model){
		if(this.mallUsersService.login(userBean,model)){
			return "redirect:/index";
		}
		return "/login/login";
	}
	
	/**
	 * @Title: loginout 
	 * @Description: 注销登录
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/login/loginout")
	public String loginout(){
		// 退出shiro
        SecurityUtils.getSubject().logout();
		return "redirect:/index";
	}
	
	/**
	 * @Title: registerPage 
	 * @Description: 注册页面
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/login/registerPage")
	public String registerPage(){
		return "/login/register";
	}
	/**
	 * @描述:  条款查询页
	 * @作者: （heyuanbo）
	 * @创建时间: 2015年11月26日 下午10:38:25
	 * @return String
	 */
	@RequestMapping(value = "/{cpyno}/login/tiaokuan")
	public String tiaokuan(){
		return "/login/tiaokuan";
	};
	
	/**
	 * @Title: register 
	 * @Description: 注册方法
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/login/register")
	public String register(MallUsersBean usersBean,HttpServletRequest request){
		this.mallUsersService.insert(usersBean,request);
		return "/login/success";
	}
}