package com.erim.sz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.SellSystemTeamBean;
import com.erim.sz.web.service.CompanyDetailService;
import com.erim.sz.web.service.MallWebService;
import com.erim.sz.web.service.SellSystemTeamService;
import com.erim.sz.web.service.TmSystemRegionService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: IndexController 
 * @Description: 主页
 * @author maoxian
 * @date 2015年10月3日 下午1:37:31
 */
@Controller
public class IndexController {

	@Autowired
	private MallWebService        mallWebService;
	@Autowired
	private SellSystemTeamService sellSystemTeamService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	@Autowired
	private CompanyDetailService  companyDetailService;
	@Autowired
	private CodeService		   	  codeService;
	
	//默认企业id
	private String   initCpyId = "19891406";

   /**
    * @Title: root 
    * @Description: 跳转首页
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
    */
    @RequestMapping(value = "/{cpyno}")
    public String root(@PathVariable("cpyno") String cpyno,HttpServletRequest request,ModelMap model) {
    	Integer cpyId = this.companyDetailService.getCpyId(cpyno);
    	if(0 == cpyId){
    		return "redirect:/"+initCpyId;
    	}
    	
    	// 省份
	    model.addAttribute("provinces",        this.tmSystemRegionService.getSystemCodeListForProvince());
	    // 酒店特色
	 	model.addAttribute("hotelfeatures",    this.codeService.getSystemCodeByCodeNo(DictionaryUtil.HOTELFEATURES));
	 	//门票 景点主题
	 	model.addAttribute("attractions",      this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ATTRACTIONS));
	 	//餐厅主打菜系
	 	model.addAttribute("sort",             this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SORT));
	 	//如果企业编码不为空
    	if(cpyId > 0 || "1".equals(cpyno) ){
    		request.getSession().setAttribute("cpyno", cpyno);
    		this.mallWebService.setMallWeb(cpyno, model, request);
    		
            return "index";
    	}
    	return this.index(model,request);
    }
    
    /**
     * 
     * @Title: index 
     * @Description: 公司名为空 跳转联合主页
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/")
    public String index(ModelMap model,HttpServletRequest request) {
    	request.getSession().setAttribute("cpyno", initCpyId);
    	this.mallWebService.setMallWeb(initCpyId, model, request);
    	return "index";
    	//model.addAttribute("listCompany", this.companyDetailService.selectAll());
        //return this.lianhe(model,"北京市");
    }
    
    
    /**
     * @Title: lianhe 
     * @Description: 返回旅行社页面
     * @param @param model
     * @param @return    设定文件 
     * @return String    返回类型 
     * @author maoxian
     * @date 2015年11月26日 下午7:28:27 
     * @throws
     */
    @RequestMapping(value = "/lianhe/{ntype}")
    public String lianhe(ModelMap model,@PathVariable("ntype")String ntype){
    	SellSystemTeamBean team = new SellSystemTeamBean();
    	team.setSstCity(ntype);
    	model.addAttribute("listSell", this.sellSystemTeamService.selectAll(team));
    	model.addAttribute("listRegion", this.tmSystemRegionService.getCodeList());
    	return "lianhe";
    }

    /**
     * @Title: index 
     * @Description: 首页
     * @param @param model
     * @param @param request
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/index")
    public String index1(ModelMap model, HttpServletRequest request) {
        return this.index(model,request);
    }
    
}