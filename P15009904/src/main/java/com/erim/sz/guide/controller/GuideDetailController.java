package com.erim.sz.guide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.guide.service.GuideDetailService;
import com.erim.sz.zy.service.ZySystemCooperationService;

/**
 * @ClassName: GuideController 
 * @Description: 导游
 * @author maoxian
 * @date 2015年7月28日 下午9:43:36
 */
@Controller
public class GuideDetailController {

    @Autowired
    private GuideDetailService guideService;
    @Autowired
	private ZySystemCooperationService  zySystemCooperationService;

    /**
     * @Title: sametown 
     * @Description: 同城同业	
     * @param @param model
     * @param @param guideDetailBean
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/guide/detail/sametown")
    public String sametown(ModelMap model, GuideDetailBean bean) throws ErimException {
    	
    	guideService.showGuideTown(model, bean);
    	//查询字典
    	guideService.setCode(model);
    	
        return "/guide/sametown/list";
    }
    
    /**
     * @Title: showList 
     * @Description: 导游列表
     * @param model
     * @param guideDetailBean
     * @param 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping("/guide/detail/list")
    public String showList(ModelMap model,@ModelAttribute("guideDetail") GuideDetailBean bean) {
    	// 执行查询
    	guideService.showGuide(model, bean);
    	//查询字典
    	guideService.setCode(model);
        return "/guide/detail/list";
    }
    
    /**
     * @Title: insertPage 
     * @Description: 新增页面
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/guide/detail/insertPage")
    public String insertPage(ModelMap model) throws ErimException {
    	
    	//查询字典
    	guideService.setCode(model);
    	
    	return "/guide/detail/insert";
    }

    /**
     * @描述: 导游信息新增
     * @作者: 宁晓强
     * @创建时间: 2015年12月9日 下午3:56:15
     * @param model
     * @param guideDetailBean
     * @return
     * @throws ErimException
     */
    @ResponseBody
    @RequestMapping(value = "/guide/detail/insert")
    public Integer insert(ModelMap model, GuideDetailBean bean) throws ErimException {
	     return guideService.insert(model, bean);
    }
    
    /**
     * @Title: delete
     * @Description:     根据主键删除指定签证数据
     * @param @param     guideDetailBean
     * @param @return    设定文件
     * @return int       返回类型 1删除成功，0 删除失败
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/guide/detail/delete")
    public int delete(GuideDetailBean bean){
    	return this.guideService.delete(bean.getId());
    }
    
    /**
     * @throws ErimException 
     * 
     * @Title: delete
     * @Description:     下架产品
     * @param @param     hotelDetailBean
     * @param @return    设定文件
     * @return int       返回类型 1删除成功，0 删除失败
     * @throws
     */
    @RequestMapping(value = "/guide/detail/deletebean")
    public String delete(GuideDetailBean bean,ModelMap model) throws ErimException{
    	this.guideService.updateStatus(model, bean);
    	bean =new GuideDetailBean();
    	return this.showList(model, bean);
    }
    
    /**
     * @Title: update 
     * @Description: 修改方法
     * @param @param model
     * @param @param guideDetailBean
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/guide/detail/update")
    public Integer update(ModelMap model,GuideDetailBean guideDetailBean){
    	return guideService.update(model, guideDetailBean);
    }
    
    /**
     * @描述: 跳转修改页面
     * @作者: 宁晓强
     * @创建时间: 2015年12月9日 下午3:47:06
     * @param model
     * @param bean
     * @return
     * @throws ErimException
     */
    @RequestMapping(value="/guide/detail/updatePage")
    public String updatePage(ModelMap model,GuideDetailBean bean) throws ErimException {
    	
    	//根据ID查询实体
    	guideService.selectGuideDetialById(model,bean);
    	
    	//查询字典
    	guideService.setCode(model);
    	
    	return "/guide/detail/update";
    }
   
    /**
     * @描述: 跳转预定方式
     * @作者: （李庆）
     * @创建时间: 2015年11月28日 下午5:02:29
     * @param model
     * @param bean
     * @return
     * @throws ErimException
     */
    @RequestMapping(value="/guide/detail/scheduledPage")
    public String scheduledPage(ModelMap model,GuideDetailBean bean) throws ErimException{
    	//根据ID查询实体
    	this.guideService.selectGuideDetialById(model,bean);
    	//查询字典
    	this.guideService.setCode(model);
    	return "/guide/detail/scheduled";
    }
    /**
     * 
     * @描述: 修改预定方式
     * @作者: （李庆）
     * @创建时间: 2015年11月28日 下午5:02:54
     * @param model
     * @param guideDetailBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/guide/detail/scheduled")
    public Integer scheduled(ModelMap model,GuideDetailBean guideDetailBean){
    	return guideService.update1(model, guideDetailBean);
    }
    /**
     * 
     * @描述: 查看用户是否已经被注册
     * @作者: （李庆）
     * @创建时间: 2015年12月27日 下午4:24:03
     * @param loginanme
     * @return
     */
	@RequestMapping(value = "/guide/detail/view")
	public @ResponseBody Integer ajaxCheckLoginName(String loginanme){
		return this.guideService.checkLoginName(loginanme);
	}
    
}
    

