package com.erim.sz.planeticket.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.PlaneticketDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.planeticket.service.PlaneticketDetailService;
import com.erim.sz.planeticket.service.PlaneticketMiddleService;

/**
 * 
 * @ClassName: PlaneticketDetailReturnController 
 * @Description: 单程-中转航班 管理 
 * @author maoxian
 * @date 2015年10月24日 上午1:02:54 
 *
 */
@Controller
public class PlaneticketDetailMiddleController {
    @Autowired
    private PlaneticketDetailService planeticketDetailService;
    @Autowired
    private PlaneticketMiddleService planeticketMiddleService;
    
    /**
     * @Title: showPlaneList 
     * @Description: 管理-机票-列表-单程中转
     * @param @param map
     * @param @param bean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/planeticket/detailMiddle/list")
    public String showPlaneListReturn(ModelMap map,@ModelAttribute("planeticketDetail") PlaneticketDetailBean bean) {
    	//设置类别为单程中转
    	bean.setPtdNtype(ErimConstants.TRANSNTYPE_DCZZ);
    	planeticketDetailService.showPlaneticket(map, bean);
    	return "/planeticket/detailMiddle/list";
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
    @RequestMapping(value = "/planeticket/detailMiddle/insertPage")
    public String insertPage(ModelMap model){
    	
    	//查询字典
    	this.planeticketDetailService.setCode(model);
    	return "/planeticket/detailMiddle/insert";
    }
    
    /**
     * @Title: insert 
     * @Description: 增加
     * @param @param model
     * @param @param bean
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @throws
     */
    @RequestMapping(value = "/planeticket/detailMiddle/insert")
    public @ResponseBody Integer insert(ModelMap model,PlaneticketDetailBean bean,HttpServletRequest request){
    	//设置类别为单程中转
    	bean.setPtdNtype(ErimConstants.TRANSNTYPE_DCZZ);
    	
    	return this.planeticketDetailService.insert(model, bean, request);
    }
    
    /**
     * @Title: 		  updatePage 
     * @Description:  跳转修改页面
     * @param @param  model
     * @param @return
     * @param @throws ErimException  设定文件 
     * @return 		  String 返回类型 
     * @throws
     */
    @RequestMapping(value="/planeticket/detailMiddle/updatePage")
    public String updatePage(ModelMap model,Integer id){
    	//根据ID查询实体
    	this.planeticketDetailService.selectPlaneticketDetialById(model, id);
    	//查询字典
    	this.planeticketDetailService.setCode(model);
    	//根据ID查询中转实体
    	this.planeticketMiddleService.selectPlaneticketDetailMiddleById(model,id);
    	return "/planeticket/detailMiddle/update";
    }
    
    /**
     * @Title: update 
     * @Description: 机票中转修改
     * @param @param model
     * @param @param bean
     * @param @param request
     * @param @return    设定文件 
     * @return String    返回类型 
     * @author maoxian
     * @date 2015年11月24日 上午1:06:45 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/planeticket/detailMiddle/update")
    public Integer update(ModelMap model,PlaneticketDetailBean bean,HttpServletRequest request){
    	return planeticketDetailService.updateMiddle(model, bean,request);
    }
}