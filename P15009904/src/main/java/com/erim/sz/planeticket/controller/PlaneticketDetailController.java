package com.erim.sz.planeticket.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.PlaneticketDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.planeticket.service.PlaneticketDetailService;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.DateUtil;

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
     * @Title: 		  sametown 
     * @Description:  同城-飞机
     * @param @param  model
     * @param @param  planeticketDetailBean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return 		  String 返回类型 
     * @throws
     */
    @RequestMapping(value = "/planeticket/detail/sametown")
    public String sametown(ModelMap model, @ModelAttribute("planeticketDetail") PlaneticketDetailBean bean) throws ErimException {
    	
    	planeticketService.showPlaneticketTown(model, bean);
    	planeticketService.setCode(model);
        return "/planeticket/sametown/list";
    }

	/**
     * @Title: showPlaneList 
     * @Description: 管理-机票-列表-单程直飞
     * @param @param map
     * @param @param bean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/planeticket/detail/list")
    public String showPlaneList(ModelMap map, @ModelAttribute("planeticketDetail") PlaneticketDetailBean bean) {
    	//设置类别为单程直飞
    	bean.setPtdNtype(ErimConstants.TRANSNTYPE_DCZF);
    	planeticketService.showPlaneticket(map, bean);
    	
    	map.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
    	
    	return "/planeticket/detail/list";
    }
    
    /**
     * @Title: 		  insertPage 
     * @Description:  新增页面
     * @param @return
     * @param @throws ErimException 设定文件 
     * @return 		  String 返回类型 
     * @throws
     */
    @RequestMapping(value = "/planeticket/detail/insertPage")
    public String insertPage(ModelMap model){
    	
    	//查询字典
    	this.planeticketService.setCode(model);
    	return "/planeticket/detail/insert";
    }
    /**
     * 
     * @Title: 			insert 
     * @Description:    新增方法
     * @param @param    model
     * @param @param    PlaneticketDetailBean
     * @param @return
     * @param @throws   ErimException 设定文件 
     * @return 			String  返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/planeticket/detail/insert")
    public Integer insert(ModelMap model ,PlaneticketDetailBean bean,HttpServletRequest request){
    	//设置类别为单程中转
    	bean.setPtdNtype(ErimConstants.TRANSNTYPE_DCZF);
    	
    	return planeticketService.insert(model, bean, request);
    
    }
    /**
     * 
     * @Title: 			 delete
     * @Description:     根据主键删除指定数据
     * @param @param     planeticketDetailBean
     * @param @return    设定文件
     * @return 			 int  返回类型 1删除成功，0 删除失败
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/planeticket/detail/delete")
    public int delete(PlaneticketDetailBean bean){
    	return this.planeticketService.delete(bean.getId());
    }
    /**
     * @Title: 		  update 
     * @Description:  修改方法
     * @param @param  model
     * @param @param  planeticketDetailBean
     * @param @return 设定文件 
     * @return        Integer    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/planeticket/detail/update")
    public Integer update(ModelMap model,PlaneticketDetailBean bean){
    	
    	return  planeticketService.update(model, bean);
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
    @RequestMapping(value="/planeticket/detail/updatePage")
    public String updatePage(ModelMap model,Integer id){
    	//根据ID查询实体
    	this.planeticketService.selectPlaneticketDetialById(model, id);
    	//查询字典
    	this.planeticketService.setCode(model);
    	return "/planeticket/detail/update";
    }
    
   /**
    * @Title: deletebean 
    * @Description: 上下架
    * @param @param bean
    * @param @param model
    * @param @return
    * @param @throws ErimException    设定文件 
    * @return String    返回类型 
    * @throws
    */
    @RequestMapping(value = "/planeticket/detail/deletebean")
    public String deletebean(PlaneticketDetailBean bean,ModelMap model) throws ErimException{
    	this.planeticketService.deletebean(bean);
    	return this.showPlaneList(model,  new  PlaneticketDetailBean());
    }
    
   
	/**
     * @Title: datetime 
     * @Description: 发班日期
     * @param @param id
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/planeticket/detail/datetime")
    public String datetime(Integer id){
    	return "/planeticket/detail/datetime";
    }
    /**
     * 
     * @描述: 跳转预定方式
     * @作者: （李庆）
     * @创建时间: 2015年11月28日 下午5:35:45
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value="/planeticket/detail/scheduledPage")
    public String scheduledPage(ModelMap model,Integer id){
    	//根据ID查询实体
    	this.planeticketService.selectPlaneticketDetialById(model, id);
    	//查询字典
    	this.planeticketService.setCode(model);
    	return "/planeticket/detail/scheduled";
    }
    /**
    *
    * @描述: 修改预定方式
    * @作者: （李庆）
    * @创建时间: 2015年11月28日 下午5:36:14
    * @param model
    * @param bean
    * @return
    */
	   @ResponseBody
	   @RequestMapping(value="/planeticket/detail/scheduled")
	   public Integer scheduled(ModelMap model,PlaneticketDetailBean bean){
	   	
	   	return  planeticketService.update1(model, bean);
	   }
}