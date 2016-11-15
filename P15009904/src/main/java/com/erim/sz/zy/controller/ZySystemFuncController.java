/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * IndexController.java : 2013-06-30
 */
package com.erim.sz.zy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.zy.bean.ZySystemCooperationBean;
import com.erim.sz.zy.bean.ZySystemRoleFuncBean;
import com.erim.sz.zy.service.ZySystemCooperationService;
import com.erim.sz.zy.service.ZySystemFuncService;
import com.erim.sz.zy.service.ZySystemRoleFuncService;
import com.erim.sz.zy.service.ZySystemRoleService;

/**
 * 
 * @ClassName: ZySystemFuncController 
 * @Description:  权限分配
 * @author maoxian
 * @date 2015年8月1日 下午11:42:18
 */
@Controller
public class ZySystemFuncController {

	@Autowired
	private ZySystemFuncService        zySystemFuncService;
	@Autowired 
	private ZySystemRoleFuncService    zySystemRoleFuncService;
	@Autowired
	private ZySystemRoleService        zySystemRoleService;
	@Autowired
	private ZySystemCooperationService zySystemCooperationService;

	
	/**
	 * @Title: addChildUser 
	 * @Description: 添加子账户
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/zy/func/addChildUser")
	public String addChildUser(ModelMap model,
					@ModelAttribute("ntype") String ntype,
					@ModelAttribute("cid") String cid){
		
		//获取合作角色的所有用户
		this.zySystemRoleService.selectBeanByCooperation(model);
		
		//获取所有权限
		this.zySystemFuncService.selectFuncList(model,ntype);
		
		//获取已分配角色用户
		this.zySystemCooperationService.selectCooperation(model,ntype,cid);
		
		return "/zy/func/addChildUser";
	}
	
	/**
	 * @Title: show 
	 * @Description: 所有权限
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/zy/func/show")
	public String show(ModelMap model){
		//企业id
		Integer cpyid = CommonUtil.getCpyId();
		//获取公司内所有角色
		model.addAttribute("listRole", this.zySystemRoleService.selectZySystemRoleByCpyId(cpyid));
		
		//获取所有权限
		this.zySystemFuncService.selectFuncList(model,"");
		return "/zy/func/show";
	}
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 权限录入
	 * @param @param model
	 * @param @param request
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/zy/func/insert")
	public @ResponseBody Integer insert(ModelMap model,HttpServletRequest request){
		this.insfunc(model, request);
		return 1;
	}
	
	/**
	 * 
	 * @Title: insfunc 
	 * @Description: 插入权限
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void insfunc(ModelMap model,HttpServletRequest request){
		//获取角色名
		String roleid = request.getParameter("roleid");
		//获取权限
		String[] rescourceCode = request.getParameterValues("rescourceCode");
		
		//删除角色roleid的权限
		this.zySystemRoleFuncService.deleteByRoleId(roleid);
		
		//插入角色编码
		List<ZySystemRoleFuncBean> listRoleFun = new ArrayList<ZySystemRoleFuncBean>();
		for(String rescode : rescourceCode){
			ZySystemRoleFuncBean param = new ZySystemRoleFuncBean();
			param.setZyFuncCode(rescode);
			param.setZyRoleId(Integer.parseInt(roleid));
			listRoleFun.add(param);
		}
		this.zySystemRoleFuncService.insertList(listRoleFun);
	}

	/**
	 * @Title: insertChildFunc 
	 * @Description: 插入自权限
	 * @param @param model
	 * @param @param request
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	@RequestMapping("/zy/func/insertChildFunc")
	public @ResponseBody Integer insertChildFunc(ModelMap model,HttpServletRequest request){
		//插入权限
		this.insfunc(model, request);
		//获取角色名
		String roleid = request.getParameter("roleid");
		
		//子账号录入权限
		String cooNtype = request.getParameter("cooNtype");
		String cooCid   = request.getParameter("cooCid");
		
		if(StringUtils.isNotBlank(cooNtype) && StringUtils.isNotBlank(cooCid)){
			//权限控制
			ZySystemCooperationBean zySystemCooperationBean = new ZySystemCooperationBean();
			zySystemCooperationBean.setCooNtype(cooNtype);
			zySystemCooperationBean.setCooCid(Integer.parseInt(cooCid));
			zySystemCooperationBean.setRoleId(Integer.parseInt(roleid));
			this.zySystemCooperationService.insert(zySystemCooperationBean);
		}
		return 1;
	}
	
	
	/**
	 * @Title: ajaxGetFunByRoleid 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param roleid
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("/zy/func/ajaxGetFunByRoleid")
	public List<ZySystemRoleFuncBean> ajaxGetFunByRoleid(String roleid){
		return this.zySystemRoleFuncService.selectRoleFuncByRoleId(roleid);
	}
}