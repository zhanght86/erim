package com.erim.sz.web.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.erim.sz.common.bean.MallUsersBean;
import com.erim.sz.web.service.MallUsersService;

/**
 * @ClassName: ShiroDbRealm 
 * @Description: 权限认证
 * @author maoxian
 * @date 2015年11月3日 下午4:10:46
 */
@Component("shiroDbRealm")
public class ShiroDbRealm extends AuthorizingRealm {

    @Autowired
    private MallUsersService userService;

    /**
     * 认证信息
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        // 获取传入客户信息-customerName
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String userName = token.getUsername();
        char[] userPswd = token.getPassword();

        // 验证入参是否正确
        if (userName == null || "".equals(userName)) {
            throw new UnknownAccountException("参数捕获失败，未获取用户信息！");
        }

        MallUsersBean bean = null;
        try {
            // 查询客户其他信息信息
            bean = userService.selectByLoginName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 1、验证客户是否存在，抛出异常UnknownAccountException
        if (bean == null) {
            throw new UnknownAccountException("用户不存在！");
        }

        // 2、验证密码是否正确，抛出异常IncorrectCredentialsException
        if (!String.valueOf(userPswd).equals(bean.getMluPassword())) {
            throw new IncorrectCredentialsException("该用户书写错误或密码错误！");
        }

        // 认证
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(bean.getMluLoginname(), bean.getMluPassword(), "shiroDbRealm");

        // 添加session信息--userName/userRealname/userSex/userRole
        SecurityUtils.getSubject().getSession().setAttribute("loginName", bean.getMluLoginname());

        return authenticationInfo;
    }

    /**
     * 授权信息
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) super.getAvailablePrincipal(principals);
        if (username != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole(SecurityUtils.getSubject().getSession().getAttribute("loginName").toString());
            return info;
        }
        return null;
    }
}