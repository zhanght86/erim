package com.erim.sz.planeticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.PlaneticketDetailBean;
import com.erim.sz.common.bean.PlaneticketReturnBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.planeticket.service.PlaneticketReturnService;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: PlaneticketReturnController 
 * @Description: 往返-直飞航班
 * @author maoxian
 * @date 2015年10月23日 上午1:06:25 
 *
 */
@Controller
public class PlaneticketReturnController {
	
	@Autowired
	private PlaneticketReturnService planeticketReturnService;
	
   /**
    * @Title: showPlaneList 
    * @Description: 管理-机票-列表-往返中转
    * @param @param map
    * @param @param bean
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
    */
    @RequestMapping(value = "/planeticket/return/list")
    public String showPlaneList(ModelMap map, PlaneticketReturnBean bean) {
    	this.planeticketReturnService.showPlaneticket(map, bean);
    	return "/planeticket/return/list";
    }
   
    /**
     * 
     * @Title: 		  insertPage 
     * @Description:  新增页面
     * @param @return
     * @param @throws ErimException 设定文件 
     * @return 		  String 返回类型 
     * @throws
     */
    @RequestMapping(value = "/planeticket/return/insertPage")
    public String insertPage(ModelMap model){
    	
    	//设置类别为单程直飞
    	PlaneticketDetailBean planeticketDetailBean = new PlaneticketDetailBean();
    	planeticketDetailBean.setPtdNtype(ErimConstants.TRANSNTYPE_DCZF);
    	planeticketDetailBean.setCpyId(CommonUtil.getCpyId());
    	model.addAttribute("listPlaneticket", this.planeticketReturnService.listPlaneticketDetailBean(planeticketDetailBean));
    	
    	planeticketDetailBean = new PlaneticketDetailBean();
    	planeticketDetailBean.setPtdNtype(ErimConstants.TRANSNTYPE_DCZZ);
    	planeticketDetailBean.setCpyId(CommonUtil.getCpyId());
    	model.addAttribute("listPlaneticketZz", this.planeticketReturnService.listPlaneticketDetailBean(planeticketDetailBean));
    	
    	//设置单程往返
    	return "/planeticket/return/insert";
    }
    
    
    /**
     * @Title: updatePage 
     * @Description: 修改页面
     * @param @param model
     * @param @return    设定文件 
     * @return String    返回类型 
     * @author maoxian
     * @date 2015年11月23日 下午11:37:36 
     * @throws
     */
    @RequestMapping(value = "/planeticket/return/updatePage")
    public String updatePage(ModelMap model,Integer id){
    	model.addAttribute("planeticket", this.planeticketReturnService.selectById(id));
    	
    	//设置类别为单程直飞
    	PlaneticketDetailBean planeticketDetailBean = new PlaneticketDetailBean();
    	planeticketDetailBean.setPtdNtype(ErimConstants.TRANSNTYPE_DCZF);
    	model.addAttribute("listPlaneticket", this.planeticketReturnService.listPlaneticketDetailBean(planeticketDetailBean));
    	
    	planeticketDetailBean = new PlaneticketDetailBean();
    	planeticketDetailBean.setPtdNtype(ErimConstants.TRANSNTYPE_DCZZ);
    	model.addAttribute("listPlaneticketZz", this.planeticketReturnService.listPlaneticketDetailBean(planeticketDetailBean));
    	
    	return "/planeticket/return/update";
    }
    
    /**
     * @Title: update 
     * @Description: 修改
     * @param @param model
     * @param @param returnBean
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @author maoxian
     * @date 2015年11月24日 上午12:06:58 
     * @throws
     */
    @RequestMapping(value = "/planeticket/return/update")
    public @ResponseBody Integer update(ModelMap model,PlaneticketReturnBean returnBean){
    	this.planeticketReturnService.update(returnBean);
    	return 1;
    }
    
    /**
     * @Title: insert 
     * @Description: 插入
     * @param @param model
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/planeticket/return/insert")
    public @ResponseBody Integer insert(ModelMap model,PlaneticketReturnBean returnBean){
    	this.planeticketReturnService.insert(returnBean);
    	return 1;
    }
}