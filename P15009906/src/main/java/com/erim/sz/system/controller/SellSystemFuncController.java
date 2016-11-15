package com.erim.sz.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.system.bean.SellSystemRoleFuncBean;
import com.erim.sz.system.service.SellSystemFuncService;
import com.erim.sz.system.service.SellSystemRoleFuncService;
import com.erim.sz.system.service.SellSystemRoleService;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: SellSystemFuncController 
 * @Description:  权限分配
 * @author maoxian
 * @date 2015年8月1日 下午11:42:18
 */
@Controller
public class SellSystemFuncController {

	@Autowired
	private SellSystemFuncService      sellSystemFuncService;
	@Autowired 
	private SellSystemRoleFuncService  sellSystemRoleFuncService;
	@Autowired
	private SellSystemRoleService      sellSystemRoleService;
   
	/**
	 * 
	 * @Title: show 
	 * @Description: 所有权限
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/sell/func/show")
	public String show(ModelMap model){
		
		//获取公司内所有角色
		model.addAttribute("listRole", this.sellSystemRoleService.selectSellSystemRoleByCpyId(CommonUtil.getCpyId()));
		this.sellSystemFuncService.selectFuncList(model);
		return "/sell/func/show";
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
	@RequestMapping("/sell/func/insert")
	public @ResponseBody Integer insert(ModelMap model,HttpServletRequest request){
		//获取角色名
		String roleid = request.getParameter("roleid");
		//获取权限
		String[] rescourceCode = request.getParameterValues("rescourceCode");
		
		//删除角色roleid的权限
		this.sellSystemRoleFuncService.deleteByRoleId(roleid);
		
		//插入角色编码
		List<SellSystemRoleFuncBean> listRoleFun = new ArrayList<SellSystemRoleFuncBean>();
		for(String rescode : rescourceCode){
			SellSystemRoleFuncBean param = new SellSystemRoleFuncBean();
			param.setSellFuncCode(rescode);
			param.setSellRoleId(Integer.parseInt(roleid));
			listRoleFun.add(param);
		}
		this.sellSystemRoleFuncService.insertList(listRoleFun);
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
	@RequestMapping("/sell/func/ajaxGetFunByRoleid")
	public List<SellSystemRoleFuncBean> ajaxGetFunByRoleid(String roleid){
		return this.sellSystemRoleFuncService.selectRoleFuncByRoleId(roleid);
	}
}