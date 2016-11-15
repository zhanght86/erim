package com.erim.sz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.PlaneticketDetailBean;
import com.erim.sz.web.service.PlaneticketDetailService;
import com.erim.sz.web.service.TmSystemRegionService;



/**
 * @ClassName: PlaneticketDetailController 
 * @Description:单程-直飞航班
 * @author maoxian
 * @date 2015年10月22日 下午10:00:26
 */
@Controller
public class PlaneticketDetailController {
    @Autowired
    private PlaneticketDetailService planeticketService;
    @Autowired
	private TmSystemRegionService 	 tmSystemRegionService;
    
   

	/**
     * @Title: showPlaneList 
     * @Description: 管理-机票-列表-单程直飞
     * @param @param map
     * @param @param bean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/{cpyno}/planeticket/jipiao")
    public String showPlaneList(ModelMap map, @ModelAttribute("planeticketDetail") PlaneticketDetailBean bean) {
    	
    	planeticketService.showPlaneticket(map, bean, 10);
    	
    	map.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
    	
    	return "/planeticket/jipiao";
    }
  
}