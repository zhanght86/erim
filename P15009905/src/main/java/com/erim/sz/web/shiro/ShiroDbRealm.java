package com.erim.sz.web.shiro;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.web.dao.GuideDetailDao;
import com.erim.sz.web.tm.service.TmSystemRegionService;

/**
 * @author 宋哲
 * @version 创建时间：2013-1-15 下午3:00:40
 * @description
 */
@Component("shiroDbRealm")
public class ShiroDbRealm extends AuthorizingRealm {

   @Autowired
   private GuideDetailDao guideDetailDao;
   @Autowired
   private TmSystemRegionService tmSystemRegionService;

    /**
     * 认证信息
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        // 获取传入客户信息-customerName
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String userName = token.getUsername();
        char[] userPswd  = token.getPassword();

        // 验证入参是否正确
        if (userName == null || "".equals(userName)) {
            throw new UnknownAccountException("参数捕获失败，未获取用户信息！");
        }

        GuideDetailBean bean = null;
        try {
            // 查询客户其他信息信息
            bean = guideDetailDao.selectGuideByGdlCodePwd(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 1、验证客户是否存在，抛出异常UnknownAccountException
        if (bean == null) {
            throw new UnknownAccountException("该用户不存在！");
        }

        // 2、验证密码是否正确，抛出异常IncorrectCredentialsException
        if (!String.valueOf(userPswd).equals(bean.getGdlPwd())) {
            throw new IncorrectCredentialsException("该用户书写错误或密码错误！");
        }

        // 3、验证客户状态
//        if (ErimConstants.STATE_FORBIDDEN.equals(bean.getUserStatus())) {
//            throw new LockedAccountException("该邮箱用户已被禁用，请联系管理员！");
//        }

        // 认证
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(bean.getGdlCode(), bean.getGdlPwd(), "shiroDbRealm");

        // 添加session信息--userName/userRealname/userSex/userRole
        SecurityUtils.getSubject().getSession().setAttribute("id", bean.getId());
        SecurityUtils.getSubject().getSession().setAttribute("userName", bean.getGdlMobileUsers());
        SecurityUtils.getSubject().getSession().setAttribute("userRealName", bean.getGdlName());
        SecurityUtils.getSubject().getSession().setAttribute("userSex", bean.getGdlSex());
        
        SecurityUtils.getSubject().getSession().setAttribute("guideDetail", bean);
        // 处理城市字段
        cityUtil(bean);
        return authenticationInfo;
    }
    
    /**
     * @描述: 处理城市字段
     * @作者: 宁晓强
     * @创建时间: 2015年12月22日 上午10:15:20
     * @param bean
     */
    public void cityUtil(GuideDetailBean bean) {
    	// 国内地陪城市
    	String localCity = bean.getGdlLocalCity();
    	if (localCity != null && !"".equals(localCity)) {
    		String[] acity = localCity.split(",");
    		String str = "";
    		if (acity.length > 1) {
    			for (int j = 0; j < acity.length-1; j++) {
    				if (StringUtils.isEmpty(acity[j])) continue;
    				str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(acity[j]))+",";
    			}
    			str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(acity[acity.length-1]));
    		} else if (acity.length == 1) {
    			str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(acity[0]));
    		}
    		bean.setGdlLocalCity(str);
    	}
    	// 国内全陪
    	String nationalCity = bean.getGdlNationalCity();
    	if (nationalCity != null && !"".equals(nationalCity)) {
    		String[] anationalCity = nationalCity.split(",");
    		String str = "";
    		if (anationalCity.length > 1) {
    			for (int j = 0; j < anationalCity.length-1; j++) {
    				if (StringUtils.isEmpty(anationalCity[j])) continue;
    				str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(anationalCity[j]))+",";
    			}
    			str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(anationalCity[anationalCity.length-1]));
    		} else if (anationalCity.length == 1) {
    			str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(anationalCity[0]));
    		}
    		bean.setGdlNationalCity(str);
    	}
    	// 国际港澳台领队
    	String leaderCity = bean.getGdlLeaderCity();
    	if (leaderCity != null && !"".equals(leaderCity)) {
    		String[] aleaderCity = leaderCity.split(",");
    		String str = "";
    		if (aleaderCity.length > 1) {
    			for (int j = 0; j < aleaderCity.length-1; j++) {
    				if (StringUtils.isEmpty(aleaderCity[j])) continue;
    				str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(aleaderCity[j]))+",";
    			}
    			str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(aleaderCity[aleaderCity.length-1]));
    		} else if (aleaderCity.length == 1) {
    			str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(aleaderCity[0]));
    		}
    		bean.setGdlLeaderCity(str);
    	}
    	SecurityUtils.getSubject().getSession().setAttribute("guideDetail", bean);
    }

    /**
     * 授权信息
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}