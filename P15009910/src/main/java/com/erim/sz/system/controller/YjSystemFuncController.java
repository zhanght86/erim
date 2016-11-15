package com.erim.sz.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.system.bean.YjSystemRoleFuncBean;
import com.erim.sz.system.service.YjSystemFuncService;
import com.erim.sz.system.service.YjSystemRoleFuncService;
import com.erim.sz.system.service.YjSystemRoleService;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: YjSystemFuncController 
 * @Description:  权限分配
 * @author maoxian
 * @date 2015年8月1日 下午11:42:18
 */
@Controller
public class YjSystemFuncController {

	@Autowired
	private YjSystemFuncService      yjSystemFuncService;
	@Autowired 
	private YjSystemRoleFuncService  yjSystemRoleFuncService;
	@Autowired
	private YjSystemRoleService      yjSystemRoleService;
   
	/**
	 * 
	 * @Title: show 
	 * @Description: 所有权限
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/yj/func/show")
	public String show(ModelMap model){
		
		//获取公司内所有角色
		model.addAttribute("listRole", this.yjSystemRoleService.selectYjSystemRoleByCpyId(CommonUtil.getCpyId()));
		this.yjSystemFuncService.selectFuncList(model);
		return "/yj/func/show";
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
	@RequestMapping("/yj/func/insert")
	public @ResponseBody Integer insert(ModelMap model,HttpServletRequest request){
		//获取角色名
		String roleid = request.getParameter("roleid");
		//获取权限
		String[] rescourceCode = request.getParameterValues("rescourceCode");
		
		//删除角色roleid的权限
		this.yjSystemRoleFuncService.deleteByRoleId(roleid);
		
		//插入角色编码
		List<YjSystemRoleFuncBean> listRoleFun = new ArrayList<YjSystemRoleFuncBean>();
		for(String rescode : rescourceCode){
			YjSystemRoleFuncBean param = new YjSystemRoleFuncBean();
			param.setYjFuncCode(rescode);
			param.setYjRoleId(Integer.parseInt(roleid));
			listRoleFun.add(param);
		}
		this.yjSystemRoleFuncService.insertList(listRoleFun);
		return CommonUtil.SUCCESS;
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
	@RequestMapping("/yj/func/ajaxGetFunByRoleid")
	public List<YjSystemRoleFuncBean> ajaxGetFunByRoleid(String roleid){
		return this.yjSystemRoleFuncService.selectRoleFuncByRoleId(roleid);
	}
}