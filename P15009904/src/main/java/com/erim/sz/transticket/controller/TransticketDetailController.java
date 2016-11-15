package com.erim.sz.transticket.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.TransticketDetailBean;
import com.erim.sz.common.bean.TransticketDetailNumBean;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.transticket.service.TransticketDetailNumService;
import com.erim.sz.transticket.service.TransticketDetailService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: TransticketController 
 * @Description: 火车票
 * @author maoxian
 * @date 2015年7月28日 下午9:43:36
 */
@Controller
public class TransticketDetailController {

    @Autowired
    private TransticketDetailService    transticketService;
    @Autowired
    private TransticketDetailNumService transticketDetailNumService;
    @Autowired
	private TmSystemRegionService       tmSystemRegionService;
    @Autowired
    private CodeService 			    codeService;
    
    /**
     * @Title: sametown 
     * @Description: 同城
     * @param @param model
     * @param @param transticketDetailBean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/transticket/detail/sametown")
    public String sametown(ModelMap model, @ModelAttribute("transticketDetail") TransticketDetailBean transticketDetailBean) throws ErimException {
    	this.transticketService.showTransticketTown(model, transticketDetailBean);
        return "/transticket/detail/sametown";
    }
    

    /**
     * 
     * @Title: login 
     * @Description: 火车票列表页
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/transticket/detail/list")
    public String showList(ModelMap model, @ModelAttribute("transticketDetail") TransticketDetailBean transticketDetailBean) throws ErimException {
    	this.transticketService.showTransticket(model, transticketDetailBean);
        return "/transticket/detail/list";
    }
    /**
     * 
     * @Title: login 
     * @Description: 火车票列表页
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/transticket/detail/common")
    public String showList1(ModelMap model, @ModelAttribute("transticketDetail") TransticketDetailBean transticketDetailBean) throws ErimException {
    	this.transticketService.showTransticket(model, transticketDetailBean);
        return "/transticket/detail/common";
    }
    /**
     * @Title: update 
     * @Description: 票务管理
     * @param @param model
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/transticket/detail/update")
    public String update(ModelMap model,TransticketDetailBean bean){
    	if(null != bean.getId()){
    		//火车
    		TransticketDetailBean transticket = this.transticketService.selectTransticket(bean.getId());
    		//出发地点
    		model.addAttribute("startStation", transticket.getTtdStartStation1().split(","));
    		model.addAttribute("endProvinces", transticket.getTtdEndProvinces().split(","));
    		model.addAttribute("endTown", transticket.getTtdEndTown().split(","));
    		model.addAttribute("endCountry", transticket.getTtdEndCountry().split(","));
    		model.addAttribute("endCity", transticket.getTtdEndCity().split(","));
    		
    		model.addAttribute("transticket", transticket);
    		// 查询
			TransticketDetailNumBean numbean = new TransticketDetailNumBean();
			numbean.setTtdId(this.transticketService.selectTransticket(bean.getId()).getId());
			model.addAttribute("listtransticketnum", this.transticketDetailNumService.showList(numbean));
    	}
		//省市
		model.addAttribute("provinces",       this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		//坐席类别
		model.addAttribute("transtype", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ZUOXI));
		
    	return "/transticket/detail/update";
    }
    
    /**
     * @Title: insert 
     * @Description: 插入
     * @param @param bean
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/transticket/detail/insert")
    public int insert(HttpServletRequest request,ModelMap model){
		
    	return this.transticketService.update(model,request);
    }
    
}