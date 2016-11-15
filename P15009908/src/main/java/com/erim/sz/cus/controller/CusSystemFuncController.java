/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * IndexController.java : 2013-06-30
 */
package com.erim.sz.cus.controller;

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

import com.erim.sz.cus.bean.CusSystemCooperationBean;
import com.erim.sz.cus.bean.CusSystemRoleFuncBean;
import com.erim.sz.cus.service.CusSystemCooperationService;
import com.erim.sz.cus.service.CusSystemFuncService;
import com.erim.sz.cus.service.CusSystemRoleFuncService;
import com.erim.sz.cus.service.CusSystemRoleService;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: CusSystemFuncController 
 * @Description:  权限分配
 * @author maoxian
 * @date 2015年8月1日 下午11:42:18
 */
@Controller
public class CusSystemFuncController {

	@Autowired
	private CusSystemFuncService        cusSystemFuncService;
	@Autowired 
	private CusSystemRoleFuncService    cusSystemRoleFuncService;
	@Autowired
	private CusSystemRoleService        cusSystemRoleService;
	@Autowired
	private CusSystemCooperationService cusSystemCooperationService;

	
	/**
	 * @Title: addChildUser 
	 * @Description: 添加子账户
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/cus/func/addChildUser")
	public String addChildUser(ModelMap model,
					@ModelAttribute("ntype") String ntype,
					@ModelAttribute("cid") String cid){
		
		//获取合作角色的所有用户
		this.cusSystemRoleService.selectBeanByCooperation(model);
		
		//获取所有权限
		this.cusSystemFuncService.selectFuncList(model,ntype);
		
		//获取已分配角色用户
		this.cusSystemCooperationService.selectCooperation(model,ntype,cid);
		
		return "/cus/func/addChildUser";
	}
	
	/**
	 * @Title: show 
	 * @Description: 所有权限
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/cus/func/show")
	public String show(ModelMap model){
		//企业id
		Integer cpyid = CommonUtil.getCpyId();
		//获取公司内所有角色
		model.addAttribute("listRole", this.cusSystemRoleService.selectCusSystemRoleByCpyId(cpyid));
		
		//获取所有权限
		this.cusSystemFuncService.selectFuncList(model,"");
		return "/cus/func/show";
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
	@RequestMapping("/cus/func/insert")
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
		this.cusSystemRoleFuncService.deleteByRoleId(roleid);
		
		//插入角色编码
		List<CusSystemRoleFuncBean> listRoleFun = new ArrayList<CusSystemRoleFuncBean>();
		for(String rescode : rescourceCode){
			CusSystemRoleFuncBean param = new CusSystemRoleFuncBean();
			param.setCusFuncCode(rescode);
			param.setCusRoleId(Integer.parseInt(roleid));
			listRoleFun.add(param);
		}
		this.cusSystemRoleFuncService.insertList(listRoleFun);
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
	@RequestMapping("/cus/func/insertChildFunc")
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
			CusSystemCooperationBean cusSystemCooperationBean = new CusSystemCooperationBean();
			cusSystemCooperationBean.setCooNtype(cooNtype);
			cusSystemCooperationBean.setCooCid(Integer.parseInt(cooCid));
			cusSystemCooperationBean.setRoleId(Integer.parseInt(roleid));
			this.cusSystemCooperationService.insert(cusSystemCooperationBean);
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
	@RequestMapping("/cus/func/ajaxGetFunByRoleid")
	public List<CusSystemRoleFuncBean> ajaxGetFunByRoleid(String roleid){
		return this.cusSystemRoleFuncService.selectRoleFuncByRoleId(roleid);
	}
}