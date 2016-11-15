package com.erim.sz.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.system.bean.ZxSystemRoleFuncBean;
import com.erim.sz.system.service.ZxSystemFuncService;
import com.erim.sz.system.service.ZxSystemRoleFuncService;
import com.erim.sz.system.service.ZxSystemRoleService;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: ZxSystemFuncController 
 * @Description:  权限分配
 * @author maoxian
 * @date 2015年8月1日 下午11:42:18
 */
@Controller
public class ZxSystemFuncController {

	@Autowired
	private ZxSystemFuncService      zxSystemFuncService;
	@Autowired 
	private ZxSystemRoleFuncService  zxSystemRoleFuncService;
	@Autowired
	private ZxSystemRoleService      zxSystemRoleService;
   
	
	/**
	 * @Title: addChildUser 
	 * @Description: 添加子账户
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/zx/func/addChildUser")
	public String addChildUser(ModelMap model,@ModelAttribute("ntype") String ntype){
		//企业id
		Integer cpyid = CommonUtil.getCpyId();
		//获取公司内所有角色
		model.addAttribute("listRole", this.zxSystemRoleService.selectZxSystemRoleByCpyId(cpyid));
		
		//获取所有权限
		this.zxSystemFuncService.selectFuncList(model);
		
		return "/zx/func/addChildUser";
	}
	/**
	 * 
	 * @Title: show 
	 * @Description: 所有权限
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/zx/func/show")
	public String show(ModelMap model){
		//企业id
		Integer cpyid = CommonUtil.getCpyId();
		//获取公司内所有角色
		model.addAttribute("listRole", this.zxSystemRoleService.selectZxSystemRoleByCpyId(cpyid));
				
		this.zxSystemFuncService.selectFuncList(model);
		return "/zx/func/show";
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
	@RequestMapping("/zx/func/insert")
	public @ResponseBody Integer insert(ModelMap model,HttpServletRequest request){
		this.insfunc(model, request);
		return 1;
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
	public void insfunc(ModelMap model,HttpServletRequest request){
		//获取角色名
		String roleid = request.getParameter("roleid");
		//获取权限
		String[] rescourceCode = request.getParameterValues("rescourceCode");
		
		//删除角色roleid的权限
		this.zxSystemRoleFuncService.deleteByRoleId(roleid);
		
		//插入角色编码
		List<ZxSystemRoleFuncBean> listRoleFun = new ArrayList<ZxSystemRoleFuncBean>();
		for(String rescode : rescourceCode){
			ZxSystemRoleFuncBean param = new ZxSystemRoleFuncBean();
			param.setZxFuncCode(rescode);
			param.setZxRoleId(Integer.parseInt(roleid));
			listRoleFun.add(param);
		}
		this.zxSystemRoleFuncService.insertList(listRoleFun);
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
	@RequestMapping("/zx/func/ajaxGetFunByRoleid")
	public List<ZxSystemRoleFuncBean> ajaxGetFunByRoleid(String roleid){
		return this.zxSystemRoleFuncService.selectRoleFuncByRoleId(roleid);
	}
}