package com.erim.sz.system.service;

import java.util.ArrayList;

import java.util.List;

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

import com.erim.sz.system.bean.ZxSystemUserBean;
import com.erim.sz.system.dao.ZxSystemUserDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: CmsSystemUserService 
 * @Description: 商户用户
 * @author maoxian
 * @date 2015年8月1日 上午11:26:50
 */
@Service("zxSystemUserService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZxSystemUserService {

	@Autowired
	private ZxSystemUserDao zxSystemUserDao;
	
	/**
	 * 
	 * @Title: selectUserById 
	 * @Description: 根据ID 查询
	 * @param @param id
	 * @param @return    设定文件 
	 * @return ZxSystemUserBean    返回类型 
	 * @throws
	 */
	public void selectUserById(Integer id,ModelMap model){
		model.addAttribute("zxSystemUser", this.zxSystemUserDao.selectUserById(id));
	}
	
	/**
	 * @Title: checkLoginName 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param loginname
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public Integer checkLoginName(String loginname){
		ZxSystemUserBean userBean = zxSystemUserDao.selectUserByLoginname(loginname);
		return null != userBean?1:0;
	}
	
	/**
	 * @Title: updateLogin 
	 * @Description: 更新最后登陆地址
	 * @param @param zxSystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月2日 下午8:17:23 
	 * @throws
	 */
	public void updateLogin(ZxSystemUserBean zxSystemUserBean){
		this.zxSystemUserDao.updateLogin(zxSystemUserBean);
	}
	/**
	 * 
	 * @Title: selectUserByLoginname 
	 * @Description: 根据用户名获取用户对象
	 * @param @param loginName
	 * @param @return    设定文件 
	 * @return CmsSystemUserBean    返回类型 
	 * @throws
	 */
	public ZxSystemUserBean selectUserByLoginname(String loginName){
		return this.zxSystemUserDao.selectUserByLoginname(loginName);
	}
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param zxSystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insert(ZxSystemUserBean zxSystemUserBean){
		zxSystemUserBean.setZxIs("0");
		//密码加密
		zxSystemUserBean.setZxUserPassword(DigestUtils.md5Hex(zxSystemUserBean.getZxUserPassword()));
		//插入用户
		zxSystemUserBean.setCpyId(CommonUtil.getCpyId());
		this.zxSystemUserDao.insert(zxSystemUserBean);
	}
	
	
	/**
	 * @Title: update 
	 * @Description: 修改方法
	 * @param @param zxSystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(ZxSystemUserBean zxSystemUserBean){
		this.zxSystemUserDao.update(zxSystemUserBean);
	}
	
	
	/**
	 * @Title: ajaxCheckLoginName 
	 * @Description: 用户名是否已被注册
	 * @param @param request
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public List<Object> ajaxCheckLoginName(String fieldId,String fieldValue){
		//返回值
		boolean bol  = true;
		//如果key和value都不为空
		if(StringUtils.isNotBlank(fieldId) && StringUtils.isNotBlank(fieldValue)){
			if("zxUserLoginname".equals(fieldId)){
				ZxSystemUserBean userBean = this.zxSystemUserDao.selectUserByLoginname(fieldValue);
				if(null != userBean) bol = false;
			}
		}
		//返回参数
		List<Object> list = new ArrayList<Object>();
		list.add(fieldId);
		list.add(bol);
		return list;
	}
	
	/**
	 * @Title: isLogin 
	 * @Description: 判断是否登录
	 * @param @param model
	 * @param @param username
	 * @param @param password
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean isLogin(ModelMap model,String username,String password){
		if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){
			password = DigestUtils.md5Hex(password);
			// shiro token
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
	 * 
	 * @Title: updatePsd 
	 * @Description: 根据用户Id 修改密码
	 * @param @param loginname
	 * @param @param psd    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public Integer updatePsd(HttpServletRequest request){
		String oldpassword = request.getParameter("oldpassword");
		if(StringUtils.isNotBlank(oldpassword)){
			oldpassword = DigestUtils.md5Hex(oldpassword);
			
			String password = (String)SecurityUtils.getSubject().getSession().getAttribute("userPswd");
			if(!oldpassword.equals(password)){
				return 2;
			}
		}
		
		String psd 		= request.getParameter("zxUserPassword");
		
		if(StringUtils.isNotBlank(psd)){
			//获取用户ID
			Integer userid = (Integer)SecurityUtils.getSubject().getSession().getAttribute("userId");
			ZxSystemUserBean parm = new ZxSystemUserBean();
			parm.setId(userid);
			//将密码进行加密
			psd = DigestUtils.md5Hex(psd);
			parm.setZxUserPassword(psd);
			//执行修改密码操作
			this.zxSystemUserDao.updatePsd(parm);
			return 1;
		}
		return 2;
	}
	
	/**
	 * 
	 * @Title: selectPageLine 
	 * @Description: 分页查询
	 * @param @param baseBean
	 * @param @param model
	 * @param @return    设定文件 
	 * @return List<ZxSystemUserBean>    返回类型 
	 * @throws
	 */
	public void selectPage(ZxSystemUserBean userBean, ModelMap model){
		userBean.setCpyId(CommonUtil.getCpyId());
		userBean.getPageLinkBean().setLimit(10);
		//分页查询
		List<ZxSystemUserBean> userList  = this.zxSystemUserDao.selectPage(userBean, model);
		System.out.println("长度:"+userList.size());
		//回传
		model.addAttribute("userList", userList);
	}
	
	
	/**
	 * @Title: loginOut 
	 * @Description: 登出系统 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void loginOut(){
		// 退出shiro
        SecurityUtils.getSubject().logout();
	}

	/**
	 * @Title: delete 
	 * @Description: 上下架
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer delete(ZxSystemUserBean userBean){
		return this.zxSystemUserDao.delete(userBean);
	}
}