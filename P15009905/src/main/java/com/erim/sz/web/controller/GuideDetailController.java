package com.erim.sz.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.web.service.GuideDetailService;
import com.erim.sz.web.service.GuidePriceService;

/**
 * @ClassName: GuideDetailController 
 * @Description: 导游管理
 * @author maoxian
 * @date 2015年9月10日 上午10:52:26 
 */
@Controller
public class GuideDetailController {

    @Autowired
    private GuideDetailService guideDetailService;
    @Autowired
    private GuidePriceService guidePriceService;
    
    /**
     * @Title: login 
     * @Description: 登录系统
     * @param model
     * @param username
     * @param password
     * @param 设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/login")
    public String login(ModelMap model,String username,String password){
    	
    	if (guideDetailService.login(model, username, password)) {
    		// 初始化档期信息
    		guidePriceService.refreshGuidePriceList(model);
    		
    		return "index";
    	}
    	return "login";
    	// return this.guideDetailService.login(model, username, password)?"index":"login";
    }
    
    /**
     * @Title: userinfo 
     * @Description: 个人信息
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/userinfo")
    public String userinfo(ModelMap map){
    	
    	guideDetailService.getGuideDetail(map);
    	
    	return "userinfo";
    }
    
    /**
     * @描述: 导游个人信息修改页面
     * @作者: 宁晓强
     * @创建时间: 2015年12月22日 上午10:36:19
     * @param model
     * @return
     */
    @RequestMapping(value = "/profilePage")
    public String profilePage(ModelMap model){
    	
    	guideDetailService.getGuideDetail(model);
    	
    	return "profile";
    }
    
    /**
     * @描述: 修改密码页面
     * @作者: 宁晓强
     * @创建时间: 2015年12月30日 上午10:37:20
     * @param map
     * @return
     */
    @RequestMapping("/updPassPage")
    public String updPassPage(ModelMap map) {
    	return "updPass";
    }
    
    /**
     * @描述: 修改导游密码
     * @作者: 宁晓强
     * @创建时间: 2015年12月30日 上午11:27:08
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/updatePsd")
    public Integer updatePsd(HttpServletRequest request) {
    	return guideDetailService.updatePad(request);
    }
    
    /**
     * @描述: 保存导游信息
     * @作者: 宁晓强
     * @创建时间: 2015年12月23日 下午4:00:09
     * @param model
     * @param bean
     * @return
     */
    @RequestMapping(value="/profile")
    public String profile(ModelMap model, GuideDetailBean bean) {
    	
    	guideDetailService.update(model, bean);
    	
    	return "userinfo";
    }
}
