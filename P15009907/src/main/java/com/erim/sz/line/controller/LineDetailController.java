package com.erim.sz.line.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.company.service.VCompanyDetailService;
import com.erim.sz.line.service.LineDetailService;
import com.erim.sz.line.service.LineTripService;

/**
 * 
 * @类名: LineDetailController
 * @描述: 专线详细控制
 * @作者: 李庆
 * @创建时间: 2015年10月16日 下午4:12:56
 *
 */
@Controller
public class LineDetailController {

    @Autowired
    private LineDetailService     lineService;
    @Autowired
    private LineTripService       linetripService;
    @Autowired
    private VCompanyDetailService vcompanyDetailService;
    
    /**
     * 
     * @Description: 专线列表页
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/line/detail/list")
    public String showList(ModelMap model, @ModelAttribute("lineDetail")LineDetailBean lineDetailBean) throws ErimException {
    	this.lineService.showLine(model, lineDetailBean);
    	this.lineService.setCode(model);
        return "/line/detail/list";
    }

    /**
     * @Title: cooperation 
     * @Description: 专线合作管理
     * @param @param model
     * @param @param lineDetailBean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @author maoxian
     * @date 2015年12月8日 下午2:01:12 
     * @throws
     */
    @RequestMapping(value = "/line/detail/cooperation")
    public String cooperation(ModelMap model,@ModelAttribute("vcompany") VCompanyDetailBean bean) throws ErimException {
    	
    	this.vcompanyDetailService.selectPage(bean, model);
    	
        return "/line/detail/cooperation";
    }
    /**
     * 
     * @Title: insertPage 
     * @Description: 新增页面
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/line/detail/insertPage")
    public String insertPage(ModelMap model){
    	 //放置字典
    	 this.lineService.setCode(model);
    	return "/line/detail/insert";
    }
    /**
     * 
     * @Title: insert 
     * @Description: 新增方法
     * @param @param model
     * @param @param lineDetailBean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/line/detail/insert")
    public Integer insert(ModelMap model,LineDetailBean lineDetailBean){
    	 return lineService.insert(model, lineDetailBean);
    	
    }
    /**
     * @Title: updatePage 
     * @Description: 跳转修改页面
     * @param @param model
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value="/line/detail/updatePage")
    public String updatePage(ModelMap model,LineDetailBean bean){
    	//根据ID查询实体
    	lineService.selectLineDetialById(model, bean);
    	//查询字典
    	lineService.setCode(model);
    	return "/line/detail/update";
    }
    /**
     * 
     * @Title: delete
     * @Description:     根据主键删除指定签证数据
     * @param @param     lineDetailBean
     * @param @return    设定文件
     * @return int       返回类型 1删除成功，0 删除失败
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/line/detail/delete")
    public int delete(LineDetailBean bean){
    	
    	return this.lineService.delete(bean.getId());
    }
    /**
     * @Title: update 
     * @Description: 修改方法
     * @param @param model
     * @param @param lineDetailBean
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/line/detail/update")
    public Integer update(ModelMap model,LineDetailBean lineDetailBean){
    	return this.lineService.update(model, lineDetailBean);
     	
    }
    /**
     * @Title: update 
     * @Description: 修改方法行程
     * @param @param model
     * @param @param lineDetailBean
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/line/detail/updatetrip")
    public Integer updatetrip(ModelMap model,LineDetailBean lineDetailBean,Integer tdlId,HttpServletRequest request){
    	 this.linetripService.insertList(request,tdlId);
    	 return lineService.updatetrip(model,lineDetailBean,tdlId);
     	
    }
    /**
     * @throws ErimException 
     * 
     * @Title: delete
     * @Description:     上下架
     * @param @param     LineDetailBean
     * @param @return    设定文件
     * @return int       返回类型 1上架，0 下架
     * @throws
     */
    @RequestMapping(value = "/line/detail/delet")
    public String delete(LineDetailBean bean,ModelMap model) throws ErimException{
    	
    	this.lineService.delete(bean);
    	 bean =new LineDetailBean();
    	return this.showList(model,bean);
    }
    /**
     * 
     * @描述: 跳转行程
     * @作者: （李庆）
     * @创建时间: 2015年11月29日 下午5:04:38
     * @param map
     * @param bean
     * @return
     */
	@RequestMapping("/line/detail/skipTrip")
	public String insertGround(ModelMap map, LineDetailBean bean) {

		// 保存当地游基础信息
		lineService.insertGround(map, bean);
		// 产品ID
		Integer tdlId = bean.getId();
		// 根据产品ID获取行程管理信息
		linetripService.getTripUpdatePage(tdlId, map);

		return "/line/trip/update";
	}
	
	/**
	 * 
	 * @描述: 复制一条当地游信息 - 包含行程管理，同业管理。不包含量价
	 * @作者: （李庆）
	 * @创建时间: 2015年11月30日 下午2:12:51
	 * @param bean
	 * @return
	 */
//	@ResponseBody
//	@RequestMapping("/line/detail/copy")
//	public Integer copyGrounDetail(LineDetailBean bean) {
//		// 执行复制
//		return lineService.copyGroundDetail(bean);
//	} 
	
	/**
	 * 
	 * @描述: 跳转预定方式页面
	 * @作者: （李庆）
	 * @创建时间: 2015年11月28日 下午4:39:41
	 * @param model
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/line/detail/scheduledPage")
	public String scheduledPage(ModelMap model, LineDetailBean bean) {
		// 修改页面查询字典
		lineService.setCode(model);
		// 修改页面查询一条
		this.lineService.selectLineDetialById(model, bean);
		return "/line/detail/scheduled";
	}

	/**
	 * 修改预定方式
	 * @描述: 
	 * @作者: （李庆）
	 * @创建时间: 2015年11月28日 下午4:40:07
	 * @param model
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/line/detail/scheduled")
	public Integer update1(ModelMap model, LineDetailBean bean) {

		return lineService.update1(model, bean);
	}

}