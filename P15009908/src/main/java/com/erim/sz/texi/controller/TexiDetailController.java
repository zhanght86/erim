package com.erim.sz.texi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.texi.service.TexiDetailService;

/**
 * @ClassName:   TexiDetailController 
 * @Description: 租车详细控制
 * @author       王赛
 * @date         2015年10月1日 下午4:00:44 
 */
@Controller
public class TexiDetailController {
	
    @Autowired
    private TexiDetailService     texiService;
    
    /**
     * @Description: 租车列表页
     * @param model
     * @param request
     * @param 
     * @return String 返回类型 
     * 
     */
    @RequestMapping(value = "/texi/detail/list")
    public String showList(ModelMap model,@ModelAttribute("TexiDetail") TexiDetailBean texiDetailBean) {
    	//插入字典
    	this.texiService.setCode(model);
    	
    	texiService.showTexi(model, texiDetailBean);
    	
    	//同城类型
    	model.addAttribute("sametownntype", ErimConstants.TOWN_TEXI);
        return "/texi/detail/list";
    }
    
    /**
     * @描述: 同城同业
     * @作者: 
     * @创建时间: 2015年12月4日 下午1:58:25
     * @param model
     * @param texiDetailBean
     * @return
     * @throws ErimException
     */
    @RequestMapping(value = "/texi/detail/sametown")
    public String sametown(ModelMap model, @ModelAttribute("TexiDetail") TexiDetailBean texiDetailBean) throws ErimException {
    	
    	texiService.showTexiTown(model, texiDetailBean);
    	//插入字典
    	texiService.setCode(model);
        return "/texi/sametown/list";
    }
    
    /**
     * @Title:        insertPage 
     * @Description:  跳转新增页面
     * @param @return
     * @param @throws ErimException 设定文件 
     * @return        String  返回类型 
     * @throws
     */
    @RequestMapping(value = "/texi/detail/insertPage")
    public String insertPage(ModelMap model) throws ErimException {
    	//查询字典
    	this.texiService.setCode(model);
    	return "/texi/detail/insert";
    }
    /**
     * 
     * @方法名: updatePage
     * @描述: 跳转到修改租车页面
     * @作者: 宁晓强
     * @创建时间: 2015年10月12日 上午11:37:59 
     * @param model
     * @param id
     * @return
     * @throws ErimException
     *
     */
    @RequestMapping(value="/texi/detail/updatePage")
    public String updatePage(ModelMap map, TexiDetailBean bean) {
    	
    	texiService.getTexiDetialById(map, bean);
    	//查询字典
    	texiService.setCode(map);
    	
    	return "/texi/detail/update";
    }
    
    /**
     * @Title:        update 
     * @Description:  修改方法
     * @param @param  model
     * @param @param  texiDetailBean
     * @param @return 设定文件 
     * @return        Integer    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/texi/detail/update")
    public Integer update(ModelMap model,TexiDetailBean texiDetailBean){
    	return texiService.update(model, texiDetailBean);
    }
    
    /**
     * 
     * @方法名: insert
     * @描述: 租车管理车辆信息增加
     * @作者: 宁晓强
     * @创建时间: 2015年10月11日 下午3:22:48 
     * @param model
     * @param bean
     * @return
     *
     */
    @ResponseBody 
	@RequestMapping(value = "/texi/detail/insert")
	public Integer insertTexi(ModelMap model, TexiDetailBean bean){
    	
		return texiService.insertTexi(model, bean);
    }
    /**
     * @throws          ErimException 
     * @Title:          delete
     * @Description:    上下架
     * @param @param    texiDetailBean
     * @param @return   设定文件
     * @return          int  返回类型 1代表上架，0 代表下架
     * @throws
     */
    @RequestMapping(value = "/texi/detail/delete")
    public String delete(TexiDetailBean bean,ModelMap model) throws ErimException{
    	
    	this.texiService.delete(bean);
    	bean= new TexiDetailBean();
    	return this.showList(model, bean);
    }
    /**
     * @param 		   Id 
     * @Title:         view
     * @Description:   查看
     * @param @return  设定文件
     * @return         String  返回类型
     * @throws
     */
    @RequestMapping(value = "/texi/detail/view")
    public String view(ModelMap model,@RequestParam(value = "id") int id){
    	this.texiService.selectTexiDetialById(model, id);
    	return "/texi/detail/view";
    }
    /**
     * @Title: 		    delete
     * @Description:    根据主键删除指定签证数据
     * @param @param    cafeteriaDetailBean
     * @param @return   设定文件
     * @return 			int  返回类型 1代表删除成功，0 代表删除失败
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/texi/detail/delet")
    public int delete(TexiDetailBean bean){
    	return this.texiService.delete(bean.getId());
    }
    /**
     * 
     * @描述: 跳转预定方式页面
     * @作者: （李庆）
     * @创建时间: 2015年11月28日 下午3:50:24
     * @param map
     * @param bean
     * @return
     */
    @RequestMapping(value="/texi/detail/scheduledPage")
    public String scheduledPage(ModelMap map, TexiDetailBean bean) {
    	
    	texiService.getTexiDetialById(map, bean);
    	//查询字典
    	texiService.setCode(map);
    	
    	return "/texi/detail/scheduled";
    }
    
    /**
     * 
     * @描述:  修改预定方式
     * @作者: （李庆）
     * @创建时间: 2015年11月28日 下午3:50:42
     * @param model
     * @param texiDetailBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/texi/detail/scheduled")
    public Integer scheduled(ModelMap model,TexiDetailBean texiDetailBean){
    	return texiService.update1(model, texiDetailBean);
    }
}