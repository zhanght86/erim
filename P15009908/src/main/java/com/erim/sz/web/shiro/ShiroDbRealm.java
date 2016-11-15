package com.erim.sz.web.shiro;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.erim.sz.common.bean.CompanyDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.company.dao.CompanyBusinessDao;
import com.erim.sz.company.service.CompanyDetailService;
import com.erim.sz.cus.bean.CusSystemRoleFuncBean;
import com.erim.sz.cus.bean.CusSystemUserBean;
import com.erim.sz.cus.dao.CusSystemUserDao;
import com.erim.sz.cus.service.CusSystemRoleFuncService;

/**
 * @ClassName: ShiroDbRealm 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author maoxian
 * @date 2015年9月12日 下午3:43:24 
 */
@Component("shiroDbRealm")
public class ShiroDbRealm extends AuthorizingRealm {

    @Autowired
    private CusSystemUserDao         userDao;
    @Autowired
    private CompanyDetailService     companyDetailService;
    @Autowired
    private CompanyBusinessDao       companyBusinessDao;
    //@Autowired
    //private TmSystemRolefuncService  tmSystemRolefuncService;
    @Autowired
    private CusSystemRoleFuncService childListFunc;
    
    /**
     * 认证信息
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

    	System.out.println("进入权限认证1:~~~" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        // 获取传入客户信息-customerName
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        char[] userPswd = token.getPassword();

        System.out.println("权限认证中2:~~~" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        
        // 验证入参是否正确
        if (username == null || "".equals(username)) {
            throw new UnknownAccountException("未获取用户信息");
        }

        CusSystemUserBean bean = null;
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
        if (!String.valueOf(userPswd).equals(bean.getCusUserPassword())) {
            throw new IncorrectCredentialsException("帐号密码错误");
        }

        // 3、验证客户状态
//        if (ErimConstants.YESORNO_NO.equals(bean.getCusIsThrough())) {
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
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(bean.getCusUserLoginname(), bean.getCusUserPassword(), "shiroDbRealm");

        /////////////////////////////////添加session信息 start////////////////////////////////////////
        //添加用户基本信息
        SecurityUtils.getSubject().getSession().setAttribute("userId", bean.getId());
        SecurityUtils.getSubject().getSession().setAttribute("userName", bean.getCusUserLoginname());
        SecurityUtils.getSubject().getSession().setAttribute("userRealname", bean.getCusUserRealname());
        SecurityUtils.getSubject().getSession().setAttribute("userRoleId", bean.getCusRoleId());
        SecurityUtils.getSubject().getSession().setAttribute("userPswd", bean.getCusUserPassword());
        //是否合作用户
        SecurityUtils.getSubject().getSession().setAttribute("userIsCooperation", bean.getCusIsCooperation());
        
        //上次登陆信息
        SecurityUtils.getSubject().getSession().setAttribute("cusLastLoginTime", bean.getCusLastLoginTime());
        SecurityUtils.getSubject().getSession().setAttribute("cusLastLoginIp", bean.getCusLastLoginIp());
        SecurityUtils.getSubject().getSession().setAttribute("cusLastLoginAddress", bean.getCusLastLoginAddress());

        //获取角色名称
        SecurityUtils.getSubject().getSession().setAttribute("userRoleName", bean.getCusRoleName());
        
        //获取用户企业信息
        SecurityUtils.getSubject().getSession().setAttribute("userCpyId",bean.getCpyId());
        SecurityUtils.getSubject().getSession().setAttribute("userCpyName",bean.getCpyName());
        SecurityUtils.getSubject().getSession().setAttribute("userCpyLogo",bean.getCpyImg());
        SecurityUtils.getSubject().getSession().setAttribute("userCpyBrand",bean.getCpyBrand());
        
        SecurityUtils.getSubject().getSession().setAttribute("userCommpany", companyDetailService.selectById(bean.getCpyId()));
        
        SecurityUtils.getSubject().getSession().setAttribute("userBussiness", this.companyBusinessDao.getBusinessById(bean.getCpyId()));
        
        //获取角色所有权限
	    List<CusSystemRoleFuncBean> listCusSystemRoleFuncBean = childListFunc.selectRoleFuncByRoleId(bean.getCusRoleId().toString());
	    SecurityUtils.getSubject().getSession().setAttribute("roleFuncs",listCusSystemRoleFuncBean);
        /////////////////////////////////添加session信息 end////////////////////////////////////////
	    
	    System.out.println("权限认证完成4:~~~" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return authenticationInfo;
    }

    /**
     * 授权信息
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	System.out.println("权限认证中31 授权开始:~~~" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        String username = (String) super.getAvailablePrincipal(principals);
        if (username != null) {
            SimpleAuthorizationInfo info = (SimpleAuthorizationInfo)SecurityUtils.getSubject().getSession().getAttribute(username+"_SimpleAuthorizationInfo");
            if(null == info) {
            	info = new SimpleAuthorizationInfo();
			    //获取角色所有权限
//			    List<CusSystemRoleFuncBean> listCusSystemRoleFuncBean = childListFunc.selectRoleFuncByRoleId(SecurityUtils.getSubject().getSession().getAttribute("userRoleId").toString());
//			    SecurityUtils.getSubject().getSession().setAttribute("roleFuncs",listCusSystemRoleFuncBean);
            	List<CusSystemRoleFuncBean> listCusSystemRoleFuncBean = (List<CusSystemRoleFuncBean>)SecurityUtils.getSubject().getSession().getAttribute("roleFuncs");
			    //List<CusSystemRoleFuncBean> listCusSystemRoleFuncBean = this.tmSystemRolefuncService.getSystemCodeListByCodeNo(Integer.parseInt(SecurityUtils.getSubject().getSession().getAttribute("userRoleId").toString()));
			    if(null != listCusSystemRoleFuncBean && listCusSystemRoleFuncBean.size()>0){
				   	//将角色所有权限放置session中
				  	for(CusSystemRoleFuncBean bean : listCusSystemRoleFuncBean){
				  		info.addStringPermission(bean.getCusFuncCode());
				  	}
			    }
				//公共资源
				info.addStringPermission("1");
				SecurityUtils.getSubject().getSession().setAttribute(username+"_SimpleAuthorizationInfo",info);
            }
            System.out.println("权限认证中32 授权结束:~~~" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            return info;
        }
        return null;
    }
}