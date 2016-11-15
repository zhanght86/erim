package com.erim.sz.mall.comtroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.line.service.LineDetailService;
import com.erim.sz.mall.service.MallShopLineService;
import com.erim.sz.mall.service.MallShopService;

/**
 * 
 * @ClassName: MallShopController 
 * @Description: 商城会员
 * @author maoxian
 * @date 2015年9月16日 下午6:57:04 
 *
 */
@Controller
public class MallShopController {

    @Autowired
    private MallShopLineService    mallShopLineService;
    @Autowired
    private LineDetailService	   lineDetailService;

    /**
     * @Title: showList 
     * @Description: 旅游商城管理
     * @param @param model
     * @param @param bean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @author maoxian
     * @date 2015年12月4日 上午2:36:20 
     * @throws
     */
    @RequestMapping(value = "/mall/shop/list")
    public String showList(ModelMap model, HttpServletRequest request,LineDetailBean bean) throws ErimException {
    	
    	model.addAttribute("li", request.getParameter("li"));
    	model.addAttribute("aid", request.getParameter("aid"));
    	
    	
//    	//获取组团商城
//    	mallshopService.selectList(new MallShopBean(),model);
//    	//查询已经管理的
//		if(null != bean.getId() && null != bean.getMspId()){
//			MallShopLineBean param = new MallShopLineBean();
//			param.setMspId1(bean.getMspId());
//			param.setMspId2(bean.getId());
//			List<MallShopLineBean> list = this.mallShopLineService.listShopLine(param, model);
//			model.addAttribute("listLine", list);
//		}
//    	//根据选择的供应商查询所有的专线产品
//    	this.lineDetailService.selectAllListBean(model);
    	
    	this.lineDetailService.selectAllListBean(model,bean);
    	//this.mallshopService.selectList(new MallShopBean(), model);
    	return "/mall/shop/list";
    }
    
    /**
     * @Title: ajaxInsert 
     * @Description: 插入所有选择专线
     * @param @param request
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @author maoxian
     * @date 2015年12月4日 上午4:53:15 
     * @throws
     */
    @RequestMapping(value = "/mall/shop/insert")
    public @ResponseBody Integer ajaxInsert(HttpServletRequest request){
    	return this.mallShopLineService.insert(request);
     }
    
//    @RequestMapping(value = "/mall/shop/list")
//    public String showList(ModelMap model, @ModelAttribute("mallshop") MallShopBean bean) throws ErimException {
//    	//获取组团商城
//    	mallshopService.selectList(new MallShopBean(),model);
//		
//    	//查询已经管理的
//		if(null != bean.getId() && null != bean.getMspId()){
//			String cpyId = "";
//			MallShopLineBean param = new MallShopLineBean();
//			param.setMspId1(bean.getMspId());
//			param.setMspId2(bean.getId());
//			List<MallShopLineBean> list = this.mallLinecompanyService.selectList(param);
//			if(null!= list && list.size()>0){
//				for(MallShopLineBean b :list){
//					cpyId += b.getMspCpyId() + ",";
//				}
//				if(!"".equals(cpyId)) cpyId = cpyId.substring(0, cpyId.length()-1);
//				
//				//企业id
//				CompanyDetailBean detailBean = new CompanyDetailBean();
//				detailBean.setCid(cpyId.split(","));
//				//查询所有专线供应商
//				this.companyDetailService.selectLineCompany(detailBean, model);
//			}
//		}
//		//this.companyDetailService.selectPageCafeteria(new CompanyDetailBean(), model);
//		
//        return "/mall/shop/list";
//    }
}