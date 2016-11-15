/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * UserService.java : 2011-10-21 上午1:48:26
 */
package com.erim.flexuser.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.exception.BusinessException;
import com.erim.core.exception.ErimException;
import com.erim.flex.bean.FuncBean;
import com.erim.flex.bean.PageDetailBean;
import com.erim.flex.constant.BackConstants;
import com.erim.flex.service.AbstractService;
import com.erim.flexuser.bean.UserBean;
import com.erim.flexuser.constant.UserConstants;
import com.erim.flexuser.util.ErimUtils;
import com.erim.utils.security.MaskUtils;

/**
 * @author 宋哲
 * @version 创建时间：2011-10-21 上午1:48:26
 * @description 用户管理
 */
@Service("user")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@SuppressWarnings("unchecked")
public class UserService extends AbstractService<UserBean> {

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
    // Methods Extends
    //
    // --------------------------------------------------------------------------

    @Override
    public void dealPageDetail(PageDetailBean bean) throws ErimException {

        // 先执行父类
        super.dealPageDetail(bean);

        // 找到要处理的bean
        if ("userAuth".equals(bean.getName())) {

            // 绑定新的数据源数组对象
            List<String> value = new ArrayList<String>();

            // 获取有权限的数据
            String auth = commonGetColumn("userAuth");

            // 将符合条件的功能ID加入value中
            List<FuncBean> list = com.erim.flex.util.ErimUtils.getFuncList();
            for (FuncBean funcBean : list) {
                if (MaskUtils.getMask(auth, funcBean.getId())) {
                    value.add(funcBean.getId().toString());
                }
            }

            // 添加数据源
            bean.getDataProvider().put("value", value);
        }
    }

    /**
     * 增加用户前对密码进行加密处理,验证用户名邮箱是否存在
     */
    @Override
    public void insert() throws ErimException {

        Integer nameCount = getSqlSession().selectOne(namespace + ".verifyUserName", _inHashMap.getString("userName"));
        Integer emailCount = getSqlSession().selectOne(namespace + ".verifyUserEmail", _inHashMap.getString("userEmail"));

        // 验证用户名是否存在
        if (nameCount != null && nameCount != 0) {
            throw new BusinessException("该用户名已经存在！");
        }

        // 验证邮箱是否存在
        if (emailCount != null && emailCount != 0) {
            throw new BusinessException("该邮箱已经存在！");
        }

        // 密码加密
        _inHashMap.put("userPswd", DigestUtils.md5Hex(_inHashMap.getString("userPswd")).toString());

        // 初始化管理员状态为“正常”状态
        _inHashMap.put("userState", UserConstants.USER_STATE_NORMAL);

        // 插入数据
        super.insert();

        // 清除数据源
        ErimUtils.clearUser();
    }

    /**
     * 修改前验证用户名邮箱是否已经存在
     */
    @Override
    public void update() throws ErimException {

        // 验证邮箱是否相同
        if (commonColumnIsChange("userEmail")) {
            Integer emailCount = getSqlSession().selectOne(namespace + ".verifyUserEmail", _inHashMap.getString("userEmail"));
            // 验证邮箱是否存在
            if (emailCount != null && emailCount != 0) {
                throw new BusinessException("该邮箱已经存在！");
            }
        }

        super.update();

        // 清除数据源
        ErimUtils.clearUser();
    }

    // --------------------------------------------------------------------------
    //
    // Methods
    //
    // --------------------------------------------------------------------------

    /**
     * 授权
     * 
     * @throws ErimException
     */
    public void auth() throws ErimException {

        // 若为空则直接返回，不进行处理
        Object[] oos = (Object[]) _inHashMap.get("userAuth");
        String auth = "0";
        for (Object s : oos) {
            auth = MaskUtils.setMask(auth, Integer.parseInt(s.toString()), 1);
        }

        // 替换传入的权限参数
        _inHashMap.put("userAuth", auth);

        // 执行授权动作
        getSqlSession().update(namespace + ".auth", _inHashMap);

        // 返回标志，部分刷新
        _backFlag = BackConstants.BACK_DATAGRID_REFRESH;
    }

    /**
     * 强行修改密码
     * 
     * @throws ErimException
     */
    public void updatepswd() throws ErimException {

        // 获取表单
        String newpassword = _inHashMap.getString("newpassword");
        String renewpassword = _inHashMap.getString("renewpassword");

        // 新密码和重复密码是否相等
        if (newpassword.equals(renewpassword)) {
            _inHashMap.put("userPswd", DigestUtils.md5Hex(_inHashMap.getString("newpassword")).toString());
            getSqlSession().update(namespace + ".updatepswd", _inHashMap);
        } else {
            throw new BusinessException("两次输入的新密码不一样，请重新输入！");
        }

        // 返回标志，部分刷新
        _backFlag = BackConstants.BACK_DATAGRID_REFRESH;
    }

    /**
     * 注销用户
     * 
     * @throws ErimException
     */
    public void cancel() throws ErimException {

        // 获取表单
        String state = commonGetColumn("userState");

        // 修改用户状态
        if (UserConstants.USER_STATE_FORBID.equals(state)) {
            throw new BusinessException("该用户已经禁用，请勿重复禁用！");
        } else {
            _inHashMap.put("userState", UserConstants.USER_STATE_FORBID);
            getSqlSession().update(namespace + ".enable", _inHashMap);
        }

        // 返回标志，部分刷新
        _backFlag = BackConstants.BACK_DATAGRID_REFRESH;
    }

    /**
     * 启用用户
     * 
     * @throws ErimException
     */
    public void enable() throws ErimException {

        // 获取表单
        String state = commonGetColumn("userState");

        // 修改用户状态
        if (UserConstants.USER_STATE_NORMAL.equals(state)) {
            throw new BusinessException("该用户已经启用，请勿重复启用！！！");
        } else {
            _inHashMap.put("userState", UserConstants.USER_STATE_NORMAL);
            getSqlSession().update(namespace + ".enable", _inHashMap);
        }

        // 返回标志，部分刷新
        _backFlag = BackConstants.BACK_DATAGRID_REFRESH;
    }

    /**
     * 个人信息修改
     * 
     * @throws ErimException
     */
    public void authupdate() throws ErimException {

        // 获取表单
        String oldEmail = getSessionObject("userEmail") == null ? null : getSessionObject("userEmail").toString();
        String newEmail = _inHashMap.getString("userEmail");

        // 验证邮箱是否相同
        if (oldEmail == null || !oldEmail.equals(newEmail)) {
            Integer emailCount = getSqlSession().selectOne(namespace + ".verifyUserEmail", _inHashMap.getString("userEmail"));

            // 验证邮箱是否存在
            if (emailCount != null && emailCount != 0) {
                throw new BusinessException("该邮箱已经存在！");
            }
        }

        // 设置ID
        _inHashMap.put("userId", getSessionString("userId"));
        getSqlSession().update(namespace + ".supdate", _inHashMap);
        setSession("userEmail", newEmail);
        setSession("userRealname", _inHashMap.getString("userRealname"));
        setSession("userPhone", _inHashMap.getString("userPhone"));

        // 返回信息
        _outHashMap.put("message", "信息修改成功！");

        // 返回标志
        _backFlag = BackConstants.BACK_RIGHT_SHOW;

        // 清除数据源
        ErimUtils.clearUser();
    }

    /**
     * 个人修改密码
     * 
     * @throws ErimException
     */
    public void authupdatepswd() throws ErimException {

        // 验证原始密码
        if (DigestUtils.md5Hex(_inHashMap.getString("oldpassword")).toString().equals(getSessionString("userPswd"))) {
        } else {
            throw new BusinessException("原始密码输入错误！");
        }
        String newpassword = _inHashMap.getString("newpassword");
        String renewpassword = _inHashMap.getString("renewpassword");

        // 新密码和重复密码是否相等
        if (newpassword.equals(renewpassword)) {
            _inHashMap.put("userId", getSessionString("userId"));
            _inHashMap.put("userPswd", DigestUtils.md5Hex(_inHashMap.getString("newpassword")).toString());
            getSqlSession().update(namespace + ".supdatepswd", _inHashMap);
        } else {
            throw new BusinessException("两次输入的新密码不一样，请重新输入！");
        }

        // 返回信息
        _outHashMap.put("message", "密码修改成功！");

        // 返回标志
        _backFlag = BackConstants.BACK_RIGHT_SHOW;
    }
}