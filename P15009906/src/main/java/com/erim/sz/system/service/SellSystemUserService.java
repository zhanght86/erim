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

import com.erim.sz.system.bean.SellSystemUserBean;
import com.erim.sz.system.dao.SellSystemUserDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: SellSystemUserService 
 * @Description: 商户用户
 * @author maoxian
 * @date 2015年8月1日 上午11:26:50
 */
@Service("sellSystemUserService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class SellSystemUserService {

	@Autowired
	private SellSystemUserDao sellSystemUserDao;
	
	/**
	 * 
	 * @Title: selectUserById 
	 * @Description: 根据ID 查询
	 * @param @param id
	 * @param @return    设定文件 
	 * @return SellSystemUserBean    返回类型 
	 * @throws
	 */
	public void selectUserById(Integer id,ModelMap model){
		model.addAttribute("sellSystemUser", this.sellSystemUserDao.selectUserById(id));
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
		SellSystemUserBean userBean = sellSystemUserDao.selectUserByLoginname(loginname);
		return null != userBean?1:0;
	}
	/**
	 * @方法名：checkOldPwd 
	 * @描述: 原密码
	 * @作者： 贺渊博
	 * @创建时间：2015年11月12日 下午4:16:48
	 * @param oldPwd
	 * @param sellUserLoginname
	 * @return
	 *
	 */
	public Integer checkOldPwd(String oldPwd){
		
		/**
		 * 1. 从Session中获取用户名    CommonUtil.getLoginName
		 * 2. 生命一个变量，接受用户名  String name= ""
		 * 3. 把用户名 赋给这个变量    name="CommonUtil.getLoginName"
		 * 4. 声明一个用户bean 
		 * 5. 把两个参数放进bean
		 * 6. 传到sql中去查询
		 */
	   String userName = CommonUtil.getLoginName();
		SellSystemUserBean bean = new SellSystemUserBean();
		bean.setSellUserLoginname(userName);
	    bean.setSellUserPassword(oldPwd);
		SellSystemUserBean user = sellSystemUserDao.selectByOldPwd(bean);
		return null != user?0:1;
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
	public void updateLogin(SellSystemUserBean zxSystemUserBean){
		this.sellSystemUserDao.updateLogin(zxSystemUserBean);
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
	public SellSystemUserBean selectUserByLoginname(String loginName){
		return this.sellSystemUserDao.selectUserByLoginname(loginName);
	}
	
	/**
	 * @Title: insert 
	 * @Description: 插入
	 * @param @param sellSystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insert(SellSystemUserBean bean) {
		bean.setCpyId(CommonUtil.getCpyId());
		bean.setSellUserPassword(DigestUtils.md5Hex(bean.getSellUserPassword()));
		sellSystemUserDao.insert(bean);
	}
	
	/**
	 * @描述: 注册专用插入用户
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月15日 下午6:00:21
	 * @param bean
	 */
	public void insertUser(SellSystemUserBean bean) {
		sellSystemUserDao.insert(bean);
	}
	
	/**
	 * @Title: update 
	 * @Description: 修改方法
	 * @param @param sellSystemUserBean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void update(SellSystemUserBean sellSystemUserBean){
		this.sellSystemUserDao.update(sellSystemUserBean);
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
			if("sellUserLoginname".equals(fieldId)){
				SellSystemUserBean userBean = this.sellSystemUserDao.selectUserByLoginname(fieldValue);
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
		String oldpassword = request.getParameter("oldPwd");
		if(StringUtils.isNotBlank(oldpassword)){
			oldpassword = DigestUtils.md5Hex(oldpassword);
			
			String password = (String)SecurityUtils.getSubject().getSession().getAttribute("userPswd");
			if(!oldpassword.equals(password)){
				return 2;
			}
		}else{
			return 3;
		}
		
		String psd 		   = request.getParameter("sellUserPassword");
		
		if(StringUtils.isNotBlank(psd)){
			//获取用户ID
			Integer userid = (Integer)SecurityUtils.getSubject().getSession().getAttribute("userId");
			SellSystemUserBean parm = new SellSystemUserBean();
			parm.setId(userid);
			//将密码进行加密
			psd = DigestUtils.md5Hex(psd);
			parm.setSellUserPassword(psd);
			//执行修改密码操作
			this.sellSystemUserDao.updatePsd(parm);
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
	 * @return List<SellSystemUserBean>    返回类型 
	 * @throws
	 */
	public void selectPage(SellSystemUserBean userBean, ModelMap model){
		
		userBean.setCpyId(CommonUtil.getCpyId());
		userBean.getPageLinkBean().setLimit(10);
		//分页查询
		List<SellSystemUserBean> userList  = this.sellSystemUserDao.selectPage(userBean, model);
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
	 * @描述: 是否停用
	 * @作者: （heyuanbo）
	 * @创建时间: 2015年12月30日 下午8:03:05
	 * @param bean
	 * @return 返回类型 Integer
	 */
	
	public  Integer delete(SellSystemUserBean bean){
		return this.sellSystemUserDao.delete(bean);
	}
}