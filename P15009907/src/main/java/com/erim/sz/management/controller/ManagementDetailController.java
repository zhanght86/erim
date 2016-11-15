package com.erim.sz.management.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.ManagementDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.management.service.ManagementDetailService;
import com.erim.web.service.CodeService;

/***
 * @ClassName: ManagementDetailController
 * @Description: 签证详细控制
 * @author 于宪洋
 * @date 2015年7月29日 下午4:53:44
 */
@Controller
public class ManagementDetailController {

	@Autowired
	private ManagementDetailService managementService;
	@Autowired
    private CodeService             codeService;
	
	/**
	 * @描述: 同业资源列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月21日 上午10:03:06
	 * @param model
	 * @param bean
	 * @return
	 * @throws ErimException
	 */
	@RequestMapping(value = "/management/detail/sametown")
	public String sametown(ModelMap model ,@ModelAttribute("managementDetail") ManagementDetailBean bean)
			throws ErimException {
		
		managementService.showManagementTown(model,bean);
		
		//查看字典
		managementService.setCode(model);
		
		return "/management/sametown/list";
	}

	/**
	 * @Description: 签证列表页
	 * @param @param model
	 * @param @param request
	 * @param @return
	 * @param @throws ErimException 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/management/detail/list")
	public String showList(ModelMap model ,@ModelAttribute("managementDetail") ManagementDetailBean bean) throws ErimException {
		this.managementService.setCode(model);
		this.managementService.showManagement(model,bean);
		//同城类型签证类型
    	model.addAttribute("sametownntype", ErimConstants.TOWN_MANAGEMENT);
		return "/management/detail/list";
	}
	
	/**
     * @Title:        insertPage 
     * @Description:  新增页面
     * @param @throws ErimException    设定文件 
     * @return        String    返回类型 
     */
    @RequestMapping(value = "/management/detail/insertPage")
    public String insertPage(ModelMap model) throws ErimException {
    	//查询字典
    	this.managementService.setCode(model);
    	return "/management/detail/insert";
    }

    /**
     * @描述: 新增签证信息
     * @作者: 
     * @创建时间: 2015年11月30日 下午9:18:35
     * @param model
     * @param bean
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/management/detail/insert")
    public Integer insert(ModelMap model,ManagementDetailBean bean,HttpServletRequest request) {
    	return managementService.insert(model,bean,request);
    }
    
    /**
     * @Title: deleteMaterial 
     * @Description: 删除材料
     * @param @param id
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @author maoxian
     * @date 2015年11月23日 上午4:22:33 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/management/detail/deleteMaterial")
    public Integer deleteMaterial(Integer id){
    	return this.managementService.deleteMaterial(id);
    }
    
    /**
     * @Title:           delete
     * @Description:     上下架
     * @param @param     managementDetailBean
     * @param @return    设定文件
     * @return int       返回类型 1下架成功，0 失败
     * @throws
     */
    @RequestMapping(value = "/management/detail/delete")
    public String delete(ManagementDetailBean managementDetailBean,ModelMap model) throws ErimException{
    	this.managementService.delete(managementDetailBean);
    	managementDetailBean= new ManagementDetailBean(); 
    	return this.showList(model, managementDetailBean);
    }
    
    /**
     * @Title:         updatePage
     * @Description:   跳转修改签证数据页面
     * @param @param   model
     * @param @throws  ErimException    设定文件
     * @return         String    返回类型 代表签证页面
     */
    @RequestMapping(value = "/management/detail/updatePage")
    public String updatePage(ModelMap model, Integer id) throws ErimException {
    	
    	// 执行查询
    	ManagementDetailBean bean = managementService.selectManagement(model, id);
    	
    	//根据主键查询实体
    	model.addAttribute("managementDetail", bean);
    	//查询字典
    	managementService.setCode(model);
    	
    	return "/management/detail/update";
    }
   
    /**
     * @Title: update
     * @Description: 修改签证数据
     * @param @param model
     * @param @param bean
     * @param @return    设定文件
     * @return int    返回类型 1 代表修改成功 0 代表修改失败
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/management/detail/update")
    public Integer update(ModelMap model,ManagementDetailBean managementDetailBean,HttpServletRequest request){
    	return managementService.update(model, managementDetailBean,request);
    }
    
    /**
     * @方法名：      updatePrice 
     * @描述:    修改签证价格
     * @作者：          贺渊博
     * @创建时间： 2015年10月27日 下午4:22:26
     * @param  model
     * @param  bean
     * @return int 返回类型
     *
     */
	@ResponseBody
	@RequestMapping(value = "/management/price/update")
	public Integer updatePrice(ModelMap model,ManagementDetailBean bean){
    	return managementService.updatePrice(model, bean);
	}
    
    /**
     * 
     * @Title: view
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    @RequestMapping(value = "/management/detail/view")
    public String view(ModelMap model,@RequestParam(value = "id") int id){
    	//查询签证类型
    	model.addAttribute("models", this.codeService.getSystemCodeByCodeNo("C017"));
    	//查询签证实体
    	model.addAttribute("managementDetail", this.managementService.selectManagementUpdate(id));
    	return "/management/detail/view";
    }
    /**
     * 
     * @描述: 跳转预定方式
     * @作者: （李庆）
     * @创建时间: 2015年11月28日 下午5:20:33
     * @param model
     * @param id
     * @return
     * @throws ErimException
     */
    @RequestMapping(value = "/management/detail/scheduledPage")
    public String scheduledPage(ModelMap model,Integer id) throws ErimException{
    	//根据主键查询实体
    	model.addAttribute("managementDetail",this.managementService.selectManagement(model,id));
    	//查询字典
    	this.managementService.setCode(model);
    	return "/management/detail/scheduled";
    }
   
    /**
     * 
     * @描述: 修改预定方式
     * @作者: （李庆）
     * @创建时间: 2015年11月28日 下午5:20:53
     * @param model
     * @param managementDetailBean
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/management/detail/scheduled")
    public Integer scheduled(ModelMap model,ManagementDetailBean managementDetailBean){
    	return managementService.update1(model, managementDetailBean);
    }
    
}