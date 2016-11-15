/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * SecurityService.java : 2011-10-8 下午3:03:51
 */
package com.erim.flexuser.server;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.exception.BusinessException;
import com.erim.core.exception.ErimException;
import com.erim.flex.bean.FlexBean;
import com.erim.flex.bean.FuncBean;
import com.erim.flex.constant.BackConstants;
import com.erim.flex.constant.FuncConstants;
import com.erim.flex.service.AbstractService;
import com.erim.flex.util.ErimUtils;
import com.erim.flexuser.bean.RoleBean;
import com.erim.flexuser.bean.UserBean;
import com.erim.flexuser.constant.UserConstants;
import com.erim.utils.security.MaskUtils;

import flex.messaging.FlexContext;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-8 下午3:03:51
 * @description 登入登出
 */
@Service("security")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SecurityService extends AbstractService<UserBean> {

    // --------------------------------------------------------------------------
    //
    // Methods Implements
    //
    // --------------------------------------------------------------------------

    @Override
    public String getNameSpace() {
        return "user";
    }

    // --------------------------------------------------------------------------
    //
    // Methods
    //
    // --------------------------------------------------------------------------

    /**
     * 登入系统
     * 
     * @return 抽象类的FlexBean
     * @throws ErimException
     */
    public FlexBean login() throws ErimException {

        // 查询用户
        UserBean userinfo = commonGetEntityByName();

        // 检测用户是否存在
        if (userinfo == null) {
            throw new BusinessException("该用户不存在，或用户名密码错误，请检测后重新输入！");
        }

        // 检测密码是否正确
        if (DigestUtils.md5Hex(_inHashMap.get("userPswd").toString()).equals(userinfo.getUserPswd())) {
        } else {
            throw new BusinessException("该用户不存在，或用户名密码错误，请检测后重新输入！");
        }

        // 检测用户状态
        if (UserConstants.USER_STATE_NORMAL.equals(userinfo.getUserState())) {
        } else {
            throw new BusinessException("该用户状态异常，请联系系统管理员！");
        }

        // 根据用户查询角色
        _inHashMap.put("roleId", userinfo.getRoleId());
        RoleBean roleinfo = getSqlSession().selectOne("role.selectEntityById", _inHashMap);

        // 检测角色是否存在
        if (roleinfo == null) {
            throw new BusinessException("该角色不存在或已经被删除，请联系系统管理员！");
        }

        // 检测用户的权限是否设定
        if (UserConstants.USER_AUTH_USER.equals(userinfo.getUserAccessType())) {
            if (userinfo.getUserAuth() == null || "".equals(userinfo.getUserAuth())) {
                throw new BusinessException("该用户还未进行授权，请联系系统管理员！");
            }
        } else {
            if (roleinfo.getRoleAuth() == null || "".equals(roleinfo.getRoleAuth())) {
                throw new BusinessException("该用户角色还未进行授权，请联系系统管理员！");
            }
        }

        // 设置session非权限参数
        FlexContext.getFlexSession().setAttribute("userId", userinfo.getUserId());
        FlexContext.getFlexSession().setAttribute("userName", userinfo.getUserName());
        FlexContext.getFlexSession().setAttribute("userPswd", userinfo.getUserPswd());
        FlexContext.getFlexSession().setAttribute("userRealname", userinfo.getUserRealname());
        FlexContext.getFlexSession().setAttribute("userPhone", userinfo.getUserPhone());
        FlexContext.getFlexSession().setAttribute("userEmail", userinfo.getUserEmail());
        FlexContext.getFlexSession().setAttribute("userAccessType", userinfo.getUserAccessType());
        FlexContext.getFlexSession().setAttribute("roleId", userinfo.getRoleId());

        // 设置session权限参数
        if (UserConstants.USER_AUTH_USER.equals(userinfo.getUserAccessType())) {
            FlexContext.getFlexSession().setAttribute("userAuth", userinfo.getUserAuth());
        } else {
            FlexContext.getFlexSession().setAttribute("userAuth", roleinfo.getRoleAuth());
        }

        // 加载有权限的功能菜单，获取为一个Element
        List<FuncBean> funcinfo = ErimUtils.getFuncList();
        Element menu = (Element) DocumentHelper.createElement("");
        HashMap<String, Element> hm = new HashMap<String, Element>();
        try {
            for (FuncBean bean : funcinfo) {

                // 当功能类型为按钮时继续，不生成菜单
                if (FuncConstants.FUNC_TYPE_BUTN.equals(bean.getType())) {
                    continue;
                }

                // 判断是否有菜单的权限
                if (!MaskUtils.getMask(getSessionString("userAuth"), bean.getId())) {
                    continue;
                }

                // 菜单类别
                Element menuitem = (Element) DocumentHelper.createElement("menuitem");
                menuitem.addAttribute("id", bean.getId().toString());
                menuitem.addAttribute("name", bean.getName());
                menuitem.addAttribute("action", bean.getAction());
                hm.put(bean.getId().toString(), menuitem);
                if (bean.getId() == bean.getPid()) {
                    menu.add(menuitem);
                } else {
                    hm.get(bean.getPid().toString()).add(menuitem);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("导航菜单错误，请检测TM_FUNC数据是否正确！");
        }

        // 判断功能菜单是否为空
        if (hm.keySet().size() == 0) {
            throw new BusinessException("用户没有授权任何功能菜单，请联系管理员！");
        }

        // 设置参数
        _backFlag = BackConstants.BACK_LOGIN_SUCCESS_COMMON;
        _outHashMap.put("roleinfo", roleinfo);
        _outHashMap.put("userinfo", userinfo);
        _outHashMap.put("funcinfo", menu.asXML());

        // 返回FlexBean
        return _flexBean;
    }

}