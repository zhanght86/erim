package com.erim.sz.zy.service;

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

import com.erim.core.exception.ErimException;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.zy.bean.ZySystemRoleBean;
import com.erim.sz.zy.bean.ZySystemUserBean;
import com.erim.sz.zy.controller.ZySystemFuncController;
import com.erim.sz.zy.dao.ZySystemUserDao;

import common.Logger;

/**
 * 
 * @ClassName: CmsSystemUserService 
 * @Description: 商户用户
 * @author maoxian
 * @date 2015年8月1日 上午11:26:50
 */
@Service("zySystemUserService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ZySystemUserService {

	//声明日志
	private Logger logger = Logger.getLogger(ZySystemFuncController.class);
		
	@Autowired
	private ZySystemUserDao 	 zySystemUserDao;
	@Autowired
	private ZySystemRoleService zySystemRoleService;
	
	/**
	 * @Title: delete 
	 * @Description: 上下架
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer delete(ZySystemUserBean zySystemUserBean){
		return this.zySystemUserDao.delete(zySystemUserBean);
	}
	
	/**
	 * @Title: selectUserById 
	 * @Description: 根据ID 查询
	 * @param @param id
	 * @param @return    设定文件 
	 * @return ZySystemUserBean    返回类型 
	 * @throws
	 */
	public void selectUserById(Integer id,ModelMap model){
		model.addAttribute("zySystemUser", this.zySystemUserDao.selectUserById(id));
	}
	
	/**
	 * @Title: selectUserByLoginname 
	 * @Description: 根据用户名获取用户对象
	 * @param @param loginName
	 * @param @return    设定文件 
	 * @return CmsSystemUserBean    返回类型 
	 * @throws
	 */
	public ZySystemUserBean selectUserByLoginname(String loginName){
		return this.zySystemUserDao.selectUserByLoginname(loginName);
	}
	
	/**
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param zySystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insert(ZySystemUserBean zySystemUserBean) throws ErimException{
		
		//如果是合作用户 晴空角色栏信息
		if("1".equals(zySystemUserBean.getZyIsCooperation())){
			//插入角色
			ZySystemRoleBean rolebean = new ZySystemRoleBean();
			rolebean.setZyRoleName(zySystemUserBean.getZyUserRealname());
			rolebean.setCpyId(CommonUtil.getCpyId());
			rolebean.setZyRoleIsCooperation("1");
			this.zySystemRoleService.insert(rolebean);
			//获取插入角色id
			zySystemUserBean.setZyRoleId(rolebean.getId());
		}
		//密码加密
		zySystemUserBean.setZyUserPassword(DigestUtils.md5Hex(zySystemUserBean.getZyUserPassword()));
		//插入用户
		zySystemUserBean.setCpyId(CommonUtil.getCpyId());
		this.zySystemUserDao.insert(zySystemUserBean);
	}
	
	/**
	 * @描述: 修改方法
	 * @作者: 
	 * @创建时间: 2015年12月4日 下午12:32:07
	 * @param zySystemUserBean
	 * @return
	 */
	public Integer update(ZySystemUserBean zySystemUserBean){
		
		try {
			Integer result = zySystemUserDao.update(zySystemUserBean);
			return result;
		} catch (Exception e) {
			logger.error("用户更新出错", e);
    		return CommonUtil.ERROR;
		}
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
		ZySystemUserBean userBean = this.zySystemUserDao.selectUserByLoginname(loginname);
		return null != userBean?1:0;
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
			if("zyUserLoginname".equals(fieldId)){
				ZySystemUserBean userBean = this.zySystemUserDao.selectUserByLoginname(fieldValue);
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
	 * 
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
	            return true;
	        } catch (AuthenticationException e) {
	            model.put("errorMsg", e.getMessage());
	            return false;
	        }
		}
        return false;
	}
	
	public static void main(String[] args) {
		String str = DigestUtils.md5Hex("123123");
		System.out.println("str = " + str);
	}
	
	/**
	 * @Title: updateLogin 
	 * @Description: 修改这一次的登陆状态
	 * @param @param zySystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void updateLogin(ZySystemUserBean zySystemUserBean){
		this.zySystemUserDao.updateLogin(zySystemUserBean);
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
		
		String psd 		   = request.getParameter("zyUserPassword");
		
		if(StringUtils.isNotBlank(psd)){
			//获取用户ID
			Integer userid = (Integer)SecurityUtils.getSubject().getSession().getAttribute("userId");
			ZySystemUserBean parm = new ZySystemUserBean();
			parm.setId(userid);
			//将密码进行加密
			psd = DigestUtils.md5Hex(psd);
			parm.setZyUserPassword(psd);
			//执行修改密码操作
			this.zySystemUserDao.updatePsd(parm);
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
	 * @return List<ZySystemUserBean>    返回类型 
	 * @throws
	 */
	public void selectPage(ZySystemUserBean userBean, ModelMap model){
		
		userBean.setCpyId(CommonUtil.getCpyId());
		userBean.getPageLinkBean().setLimit(10);
		//分页查询
		List<ZySystemUserBean> userList  = this.zySystemUserDao.selectPage(userBean, model);
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
}