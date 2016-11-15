/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * CodeService.java : 2012-3-16 下午6:04:29
 */
package com.erim.flexuser.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.erim.core.exception.BusinessException;
import com.erim.core.exception.ErimException;
import com.erim.flex.bean.FuncBean;
import com.erim.flex.bean.PageDetailBean;
import com.erim.flex.constant.BackConstants;
import com.erim.flex.service.AbstractService;
import com.erim.flexuser.bean.RoleBean;
import com.erim.flexuser.constant.RoleConstants;
import com.erim.flexuser.util.ErimUtils;
import com.erim.utils.security.MaskUtils;

/**
 * @author 宋哲
 * @version 创建时间：2012-03-21 上午10:45:54
 * @description 管理员角色管理
 */
@Service("role")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class RoleService extends AbstractService<RoleBean> {

    // --------------------------------------------------------------------------
    //
    // Methods Implements
    //
    // --------------------------------------------------------------------------

    @Override
    public String getNameSpace() {
        return "role";
    }

    // --------------------------------------------------------------------------
    //
    // Methods Extends
    //
    // --------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
    @Override
    public void dealPageDetail(PageDetailBean bean) throws ErimException {

        // 先执行父类
        super.dealPageDetail(bean);

        // 找到要处理的bean
        if ("roleAuth".equals(bean.getName())) {

            // 绑定新的数据源数组对象
            List<String> value = new ArrayList<String>();

            // 获取有权限的数据
            String auth = commonGetColumn("roleAuth");

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

    @Override
    public void insert() throws ErimException {

        // 添加前，验证角色名称是否已经存在
        Integer nameCount = getSqlSession().selectOne(namespace + ".verifyRoleName", _inHashMap.getString("roleName"));
        if (nameCount != null && nameCount != 0) {
            throw new BusinessException("该角色名称已经存在！");
        }

        // 增加数据
        super.insert();

        // 清空单例管理员角色相关数据
        ErimUtils.clearRole();
    }

    @Override
    public void update() throws ErimException {

        // 修改前，验证角色名称是否已经存在
        if (commonGetColumn("roleName").equals(_inHashMap.getString("roleName"))) {
        } else {
            Integer nameCount = getSqlSession().selectOne(namespace + ".verifyRoleName", _inHashMap.getString("roleName"));
            if (nameCount != null && nameCount != 0) {
                throw new BusinessException("该角色名称已经存在！");
            }

        }

        // 修改数据
        super.update();

        // 清空单例管理员角色相关数据
        ErimUtils.clearRole();
    }

    @Override
    public void delete() throws ErimException {

        // 不能删除默认角色
        if (RoleConstants.ROLE_ID_DEFAULT.equals(commonGetColumn("roleId"))) {
            throw new BusinessException("该角色为管理员默认角色，不允许删除！");
        }

        // 删除角色
        super.delete();

        // 清空单例管理员角色相关数据
        ErimUtils.clearRole();
    }

    /**
     * 授权
     * 
     * @throws ErimException
     */
    public void auth() throws ErimException {

        // 若为空则直接返回，不进行处理
        Object[] oos = (Object[]) _inHashMap.get("roleAuth");
        String auth = "0";
        for (Object s : oos) {
            auth = MaskUtils.setMask(auth, Integer.parseInt(s.toString()), 1);
        }

        // 替换传入的权限参数
        _inHashMap.put("roleAuth", auth);

        // 执行授权动作
        getSqlSession().update(namespace + ".auth", _inHashMap);

        // 返回标志，部分刷新
        _backFlag = BackConstants.BACK_DATAGRID_REFRESH;
    }
}
