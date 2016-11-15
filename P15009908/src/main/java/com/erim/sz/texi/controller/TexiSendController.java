package com.erim.sz.texi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.TexiSendBean;
import com.erim.sz.texi.service.TexiSendService;

/**
 * @ClassName:   TexiSendController 
 * @Description: 租车固定接送详细控制
 * @author       王赛
 * @date         2015年10月1日 上午4:06:34 
 */
@Controller
public class TexiSendController {
	
	@Autowired
	private TexiSendService texisendService;
	
	/**
     * @Title: showList
     * @Description: 租车管理固定接送线路信息列表
     * @param model
     * @param Bean
     * @return
     */
    @RequestMapping(value = "/texi/send/list")
    public String showList(ModelMap model, TexiSendBean Bean) {
    	
    	texisendService.showtrantTexi(model, Bean);
    	
    	texisendService.setCode(model);
    	
        return "/texi/send/send";
    }
    
    /**
     * @throws  		ErimException 
     * @Title: 			delete
     * @Description:    租车固定删除
     * @param @param    TexitransportBean
     * @param @return   设定文件
     * @return          int  返回类型 1代表上架，0代表下架
     * @throws
     */
    @ResponseBody
	@RequestMapping(value = "/texi/send/delete")
	public Integer delete(TexiSendBean bean){
    	return	texisendService.delete(bean.getId());
	}
    
    /**
     * @throws        ErimException 
     * @Title: 		  insert
     * @Description:  添加和修改
     * @param         TexiSendBean
     * @param     
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/texi/send/insert")
	public Integer update(ModelMap model, TexiSendBean bean){
    	// 新增或者修改线路信息
    	return texisendService.update(model, bean);
    }	
    
    /**
     * @方法名: updatePage
     * @描述: 跳转到修改页面
     * @作者: 宁晓强
     * @创建时间: 2015年10月12日 上午10:16:34 
     * @param model
     * @param bean
     * @return
     */
    @RequestMapping(value = "/texi/send/view")
    public String updatePage(ModelMap model,TexiSendBean bean){
    	
    	// 根据ID获取要修改的数据
    	texisendService.getTexiSendById(model, bean);
    	// 固定接送线路信息列表
    	texisendService.showtrantTexi(model, bean);
    	texisendService.setCode(model);
    	return "/texi/send/updateSend";
    }
}