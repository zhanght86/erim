/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserController.java : 2013-06-30
 */
package com.erim.sz.line.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.common.bean.LinePriceBean;
import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.company.service.VCompanyDetailService;
import com.erim.sz.line.service.LineDetailService;
import com.erim.sz.line.service.LinePriceService;

/**
 * 
 * @ClassName: LineDetailController 
 * @Description: 旅游产品
 * @author maoxian
 * @date 2015年9月16日 下午6:09:26 
 *
 */
@Controller
public class LineDetailController {

    @Autowired
    private LineDetailService 	  lineService;
    @Autowired
    private LinePriceService	  linePriceService;
    @Autowired
    private VCompanyDetailService vCompanyDetailService;

    /**
   	 * @Title: searchHotel 
   	 * @Description: 专线
   	 * @param @return    设定文件 
   	 * @return String    返回类型 
   	 * @throws
   	 */
   	@RequestMapping(value = "/search/line/list")
   	public String searchLine(ModelMap model,@ModelAttribute("lineDetail") LineDetailBean Bean ){
   		lineService.showLine(model,Bean);
   		lineService.setCode(model);
   		
   		//初始化时间
   		model.addAttribute("nowDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
   		return "/search/line/list";
   	}
   	/**
   	 * @Title: searchGuidePrice 
   	 * @Description: 专线量价
   	 * @param @param model
   	 * @param @param price
   	 * @param @return
   	 * @param @throws ParseException    设定文件 
   	 * @return List<GuidePriceBean>    返回类型 
   	 * @author maoxian
   	 * @date 2015年12月25日 上午1:47:24 
   	 * @throws
   	 */
   	@ResponseBody
	@RequestMapping(value = "/search/line/price")
	public List<LinePriceBean> searchLinePrice(ModelMap model,LinePriceBean price) throws ParseException{
		
		//获取开始时间
		String startDate = price.getStartDate();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
		c1.add(Calendar.DATE, 5);
		price.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime()));
		
		//返回时间类型
		//List<Map<String,LinePriceBean>> alist = new ArrayList<Map<String,LinePriceBean>>();
		List<LinePriceBean> alist = new ArrayList<LinePriceBean>();
		
		if(StringUtils.isNotBlank(startDate)){
			List<LinePriceBean> list = this.linePriceService.selectLinePriceList(price);
			//如果数组大于0
			if(null != list && list.size() > 0){
				//时间类型 每天＋1  循环6天
				Calendar c = Calendar.getInstance();
				for(int i = 0 ; i < 6 ;i ++){
					c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
					c.add(Calendar.DATE, i);
					String sd = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
					
					boolean isTrue = false;
					for(LinePriceBean line : list){
						if(sd.equals(line.getLpeDate())){
							//alist.add(line);
							isTrue = true;
							alist.add(line);
						}
					}
					if(!isTrue) alist.add(new LinePriceBean());
				}
			}
		}
		
		return alist;
	}
   	
   	
    /**
     * @Title: list 
     * @Description: 产品详情
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/tourism/detail/linelist")
    public String linelist(String cpyid,ModelMap model){
    	if(StringUtils.isNotBlank(cpyid)){
    		//根据企业i查询企业信息
    		VCompanyDetailBean cpy = this.vCompanyDetailService.selectById(Integer.parseInt(cpyid));
    		model.addAttribute("company", cpy);
    		
    		//根据企业id查询所有专线
    		List<LineDetailBean> listLine = this.lineService.selectLineByCpyid(Integer.parseInt(cpyid));
    		model.addAttribute("listLine", listLine);
    	}
    	return "/tourism/detail/linelist";
    }
    
    
    /**
     * @Title: surrounding 
     * @Description: 周边
     * @param @param model
     * @param @param lineDetailBean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/tourism/detail/surrounding")
    public String surrounding(ModelMap model, @ModelAttribute("lineDetail") LineDetailBean lineDetailBean) throws ErimException {
    	this.lineService.showLine(model, lineDetailBean);
        return "/tourism/detail/surrounding";
    }
    
    /**
     * 
     * @Title: domestic 
     * @Description: 国内
     * @param @param model
     * @param @param lineDetailBean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/tourism/detail/domestic")
    public String domestic(ModelMap model, @ModelAttribute("lineDetail") LineDetailBean lineDetailBean) throws ErimException {
    	this.lineService.showLine(model, lineDetailBean);
    	return "/tourism/detail/domestic";
    }
    
    /**
     * 
     * @Title: International 
     * @Description: 国际旅游
     * @param @param model
     * @param @param lineDetailBean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/tourism/detail/international")
    public String international(ModelMap model, @ModelAttribute("lineDetail") LineDetailBean lineDetailBean) throws ErimException {
    	this.lineService.showLine(model, lineDetailBean);
    	return "/tourism/detail/international";
    }
    
    /**
     * 
     * @Title: list 
     * @Description: 产品经理推荐
     * @param @param model
     * @param @param lineDetailBean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/tourism/detail/list")
    public String list(ModelMap model, @ModelAttribute("lineDetail") LineDetailBean lineDetailBean) throws ErimException {
    	this.lineService.showLine(model, lineDetailBean);
    	return "/tourism/detail/list";
    }
}