package com.erim.sz.cus.service;

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
import com.erim.sz.cus.bean.CusSystemRoleBean;
import com.erim.sz.cus.bean.CusSystemUserBean;
import com.erim.sz.cus.controller.CusSystemFuncController;
import com.erim.sz.cus.dao.CusSystemUserDao;
import com.erim.sz.web.util.CommonUtil;

import common.Logger;

/**
 * 
 * @ClassName: CmsSystemUserService 
 * @Description: 商户用户
 * @author maoxian
 * @date 2015年8月1日 上午11:26:50
 */
@Service("cusSystemUserService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CusSystemUserService {

	//声明日志
	private Logger logger = Logger.getLogger(CusSystemFuncController.class);
		
	@Autowired
	private CusSystemUserDao 	 cusSystemUserDao;
	@Autowired
	private CusSystemRoleService cusSystemRoleService;
	
	/**
	 * @Title: delete 
	 * @Description: 上下架
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer delete(CusSystemUserBean cusSystemUserBean){
		return this.cusSystemUserDao.delete(cusSystemUserBean);
	}
	
	/**
	 * @Title: selectUserById 
	 * @Description: 根据ID 查询
	 * @param @param id
	 * @param @return    设定文件 
	 * @return CusSystemUserBean    返回类型 
	 * @throws
	 */
	public void selectUserById(Integer id,ModelMap model){
		model.addAttribute("cusSystemUser", this.cusSystemUserDao.selectUserById(id));
	}
	
	/**
	 * @Title: selectUserByLoginname 
	 * @Description: 根据用户名获取用户对象
	 * @param @param loginName
	 * @param @return    设定文件 
	 * @return CmsSystemUserBean    返回类型 
	 * @throws
	 */
	public CusSystemUserBean selectUserByLoginname(String loginName){
		return this.cusSystemUserDao.selectUserByLoginname(loginName);
	}
	
	/**
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param cusSystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insert(CusSystemUserBean cusSystemUserBean) throws ErimException{
		
		//如果是合作用户 晴空角色栏信息
		if("1".equals(cusSystemUserBean.getCusIsCooperation())){
			//插入角色
			CusSystemRoleBean rolebean = new CusSystemRoleBean();
			rolebean.setCusRoleName(cusSystemUserBean.getCusUserRealname());
			rolebean.setCpyId(CommonUtil.getCpyId());
			rolebean.setCusRoleIsCooperation("1");
			this.cusSystemRoleService.insert(rolebean);
			//获取插入角色id
			cusSystemUserBean.setCusRoleId(rolebean.getId());
		}
		//密码加密
		cusSystemUserBean.setCusUserPassword(DigestUtils.md5Hex(cusSystemUserBean.getCusUserPassword()));
		//插入用户
		cusSystemUserBean.setCpyId(CommonUtil.getCpyId());
		this.cusSystemUserDao.insert(cusSystemUserBean);
	}
	
	/**
	 * @描述: 修改方法
	 * @作者: 
	 * @创建时间: 2015年12月4日 下午12:32:07
	 * @param cusSystemUserBean
	 * @return
	 */
	public Integer update(CusSystemUserBean cusSystemUserBean){
		
		try {
			Integer result = cusSystemUserDao.update(cusSystemUserBean);
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
		CusSystemUserBean userBean = this.cusSystemUserDao.selectUserByLoginname(loginname);
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
			if("cusUserLoginname".equals(fieldId)){
				CusSystemUserBean userBean = this.cusSystemUserDao.selectUserByLoginname(fieldValue);
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
	 * @param @param cusSystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void updateLogin(CusSystemUserBean cusSystemUserBean){
		this.cusSystemUserDao.updateLogin(cusSystemUserBean);
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
		
		String psd 		   = request.getParameter("cusUserPassword");
		
		if(StringUtils.isNotBlank(psd)){
			//获取用户ID
			Integer userid = (Integer)SecurityUtils.getSubject().getSession().getAttribute("userId");
			CusSystemUserBean parm = new CusSystemUserBean();
			parm.setId(userid);
			//将密码进行加密
			psd = DigestUtils.md5Hex(psd);
			parm.setCusUserPassword(psd);
			//执行修改密码操作
			this.cusSystemUserDao.updatePsd(parm);
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
	 * @return List<CusSystemUserBean>    返回类型 
	 * @throws
	 */
	public void selectPage(CusSystemUserBean userBean, ModelMap model){
		
		userBean.setCpyId(CommonUtil.getCpyId());
		userBean.getPageLinkBean().setLimit(10);
		//分页查询
		List<CusSystemUserBean> userList  = this.cusSystemUserDao.selectPage(userBean, model);
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