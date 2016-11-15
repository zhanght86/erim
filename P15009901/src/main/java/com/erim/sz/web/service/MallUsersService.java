package com.erim.sz.web.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.MallUsersBean;
import com.erim.sz.web.dao.MallUsersDao;
import com.erim.utils.ip.IP4;

/**
 * @ClassName: MallDetailService 
 * @Description: 会员管理
 * @author maoxian
 * @date 2015年11月3日 下午4:02:09
 */
@Service("mallService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MallUsersService {

	@Autowired
	private MallUsersDao mallDao;
	
	/**
	 * @Title: insert 
	 * @Description: 新增
	 * @param @param user
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(MallUsersBean user,HttpServletRequest request){
		//密码加密
		user.setMluPassword(DigestUtils.md5Hex(user.getMluPassword()));
		//设置创建时间为当前时间
		user.setMluCreateTime(new Date());
		//设置登录ip为当前ip 
		user.setMluCreateIp(IP4.getIP4(request));
		//设置会员等级为1
		user.setMluLevel(1);
		return this.mallDao.insert(user);
	}
	
	/**
	 * @Title: login 
	 * @Description: 登录
	 * @param @param userBean
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean login(MallUsersBean userBean,ModelMap model){
		//帐户
		String username = userBean.getMluLoginname(); 
		//密码
		String password = userBean.getMluPassword();
		if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
			password = DigestUtils.md5Hex(password);
			
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
	        // shiro authz
	        //token.setRememberMe(true);
	        try {
	            SecurityUtils.getSubject().login(token);
//	            System.out.println(SecurityUtils.getSubject().isPermitted("1"));
	            return true;
	        } catch (AuthenticationException e) {
	            model.put("errorMsg", e.getMessage());
	            return false;
	        }
		}
		return false;
	}
	
	/**
	 * @Title: selectByLoginName 
	 * @Description: 根据
	 * @param @param loginname
	 * @param @return    设定文件 
	 * @return MallUsersBean    返回类型 
	 * @throws
	 */
	public MallUsersBean selectByLoginName(String loginname){
		MallUsersBean bean = new MallUsersBean();
		bean.setMluLoginname(loginname);
		return this.mallDao.selectByLogin(bean);
	}
}