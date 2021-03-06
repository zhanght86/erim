package com.erim.sz.web.shiro;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.erim.sz.common.bean.CompanyBusinessBean;
import com.erim.sz.common.bean.CompanyDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.company.dao.CompanyBusinessDao;
import com.erim.sz.company.service.CompanyDetailService;
import com.erim.sz.system.bean.ZxSystemRoleFuncBean;
import com.erim.sz.system.bean.ZxSystemUserBean;
import com.erim.sz.system.dao.ZxSystemRoleFuncDao;
import com.erim.sz.system.dao.ZxSystemUserDao;

/**
 * 
 * @ClassName: ShiroDbRealm 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author maoxian
 * @date 2015年9月12日 下午3:43:24 
 *
 */
@Component("shiroDbRealm")
public class ShiroDbRealm extends AuthorizingRealm {

    @Autowired
    private ZxSystemUserDao      userDao;
    @Autowired
    private ZxSystemRoleFuncDao  childListFunc;
    @Autowired
    private CompanyDetailService companyDetailService;
    @Autowired
    private CompanyBusinessDao   companyBusinessDao;
    
    /**
     * 认证信息
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

    	 System.out.println("doGetAuthenticationInfo:~~~");
        // 获取传入客户信息-zxtomerName
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        char[] userPswd = token.getPassword();

        // 验证入参是否正确
        if (username == null || "".equals(username)) {
            throw new UnknownAccountException("未获取用户信息！");
        }

        ZxSystemUserBean bean = null;
        try {
            // 查询客户其他信息信息
            bean = userDao.selectUserByLoginname(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 1、验证客户是否存在，抛出异常UnknownAccountException
        if (bean == null) {
            throw new UnknownAccountException("用户不存在");
        }

        // 2、验证密码是否正确，抛出异常IncorrectCredentialsException
        if (!String.valueOf(userPswd).equals(bean.getZxUserPassword())) {
            throw new IncorrectCredentialsException("帐号密码错误");
        }

        // 3、验证客户状态
//        if (ErimConstants.YESORNO_NO.equals(bean.getZxIsThrough())) {
//            throw new LockedAccountException("用户未激活");
//        }
        // 4、验证是否过期
        if (null != bean.getCpyId()){
        	//如果审核时间为空 则提示未激活
        	CompanyDetailBean companyDetail = this.companyDetailService.selectBeanById(bean.getCpyId());
        	if(null == companyDetail.getCpyThroughTime() || !ErimConstants.YESORNO_YES.equals(companyDetail.getCpyIsThrough())){
        		throw new LockedAccountException("用户未激活");
        	}
    		//如果没有支付 或者 没有被锁 走锁定接口
        	if(!"1".equals(companyDetail.getPseIsSx())){
        		if(ErimConstants.LOCK_USER_YES.equals(companyDetail.getCpyIsLock())){
            		SecurityUtils.getSubject().getSession().setAttribute("lockuser", ErimConstants.LOCK_USER_YES);
            	}else{
	        		Date nowDate     = new Date();
	            	Date throughTime = companyDetail.getCpyThroughTime();
	            	long diff = nowDate.getTime() - throughTime.getTime();//这样得到的差值是微秒级别
	            	long days = diff / (1000 * 60 * 60 * 24);
	            	//如果相差大于1天 则锁定用户
	            	if(days-1>=0){
	            		this.companyDetailService.lockCpy(bean.getCpyId());
	            		SecurityUtils.getSubject().getSession().setAttribute("lockuser", ErimConstants.LOCK_USER_YES);
	            	}else{
	            		SecurityUtils.getSubject().getSession().setAttribute("lockuser", ErimConstants.LOCK_USER_TEST);
	            	}
            	}
        	}else{
        		if(ErimConstants.LOCK_USER_YES.equals(companyDetail.getCpyIsLock())){
        			//解除锁定
            		this.companyDetailService.unlock(bean.getCpyId());
        		}
        		SecurityUtils.getSubject().getSession().setAttribute("lockuser", ErimConstants.LOCK_USER_PAY);
        	}
        }else{
        	throw new LockedAccountException("用户未激活");
        }

        // 认证
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(bean.getZxUserLoginname(), bean.getZxUserPassword(), "shiroDbRealm");

        /////////////////////////////////添加session信息 start////////////////////////////////////////
        //添加用户基本信息
        SecurityUtils.getSubject().getSession().setAttribute("userId", bean.getId());
        SecurityUtils.getSubject().getSession().setAttribute("userName", bean.getZxUserLoginname());
        SecurityUtils.getSubject().getSession().setAttribute("userRealname", bean.getZxUserRealname());
        SecurityUtils.getSubject().getSession().setAttribute("userRoleId", bean.getZxRoleId());
        SecurityUtils.getSubject().getSession().setAttribute("userPswd", bean.getZxUserPassword());

        //获取角色名称
        SecurityUtils.getSubject().getSession().setAttribute("userRoleName", bean.getZxRoleName());
        
        //获取用户企业信息
        SecurityUtils.getSubject().getSession().setAttribute("userCpyId",bean.getCpyId());
        SecurityUtils.getSubject().getSession().setAttribute("userCpyName",bean.getCpyName());
        SecurityUtils.getSubject().getSession().setAttribute("userCpyLogo",bean.getCpyImg());
        SecurityUtils.getSubject().getSession().setAttribute("userCpyBrand",bean.getCpyBrand());
     
        
        //企业用户信息
        SecurityUtils.getSubject().getSession().setAttribute("userBean",bean);
        
        //获取公司信息
        SecurityUtils.getSubject().getSession().setAttribute("userCommpany", companyDetailService.selectById(bean.getCpyId()));
        //企业服务范围
        CompanyBusinessBean buiness =  this.companyBusinessDao.getBusinessById(bean.getCpyId());
        SecurityUtils.getSubject().getSession().setAttribute("userBussiness", buiness);
        SecurityUtils.getSubject().getSession().setAttribute("userIsManagement", "01".equals(buiness.getCbsSerInland())||StringUtils.isNotBlank(buiness.getCbsSerInterna())?"1":"0");
        
        SecurityUtils.getSubject().getSession().setAttribute("userCbsSerProvince",this.companyBusinessDao.getBusinessById(bean.getCpyId()));
        /////////////////////////////////添加session信息 end////////////////////////////////////////
        return authenticationInfo;
    }

    /**
     * 授权信息
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) super.getAvailablePrincipal(principals);
        if (username != null) {
            SimpleAuthorizationInfo info = (SimpleAuthorizationInfo)SecurityUtils.getSubject().getSession().getAttribute(username+"_SimpleAuthorizationInfo");
            if(null == info) {
            	info = new SimpleAuthorizationInfo();
			    //获取角色所有权限
			    List<ZxSystemRoleFuncBean> listZxSystemRoleFuncBean = childListFunc.selectRoleFuncByRoleId(SecurityUtils.getSubject().getSession().getAttribute("userRoleId").toString());
			    if(null != listZxSystemRoleFuncBean && listZxSystemRoleFuncBean.size()>0){
				   	//将角色所有权限放置session中
				  	for(ZxSystemRoleFuncBean bean : listZxSystemRoleFuncBean){
				  		info.addStringPermission(bean.getZxFuncCode());
				  	}
			    }
				//公共资源
				info.addStringPermission("1");
				SecurityUtils.getSubject().getSession().setAttribute(username+"_SimpleAuthorizationInfo",info);
            }
            return info;
        }
        return null;
    }
}