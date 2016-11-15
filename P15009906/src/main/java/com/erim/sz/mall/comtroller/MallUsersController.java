package com.erim.sz.mall.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.MallUsersBean;
import com.erim.sz.mall.service.MallUsersService;

/**
 * 
 * @ClassName: MallUsersController 
 * @Description: 商城会员
 * @author maoxian
 * @date 2015年9月16日 下午6:57:04 
 *
 */
@Controller
public class MallUsersController {

    @Autowired
    private MallUsersService mallusersService;

    /**
     * 
     * @Title: login 
     * @Description: 一般会员
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throwsf
     */
    @RequestMapping(value = "/mall/users/list")
    public String showList(ModelMap model, @ModelAttribute("mallusers") MallUsersBean malluserBean) throws ErimException {
    	malluserBean.setMluLevel(1);
    	this.mallusersService.showMallUsers(model, malluserBean);
        return "/mall/users/list";
    }

    /**
     * @Title: showVipList 
     * @Description: VIP 会员
     * @param @param model
     * @param @param malluserBean
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/mall/users/showVipList")
    public String showVipList(ModelMap model,MallUsersBean malluserBean){
    	malluserBean.setMluLevel(2);
    	this.mallusersService.showMallUsers(model, malluserBean);
    	return "/mall/users/showVipList";
    }
    
    /**
     * @Title: fygl 
     * @Description: 帐号管理
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/mall/users/gygl")
    public String fygl(){
    	return "/mall/users/gygl";
    }
	/**
	 * @方法名：upgrade 
	 * @描述: 会员升级
	 * @作者： 贺渊博
	 * @创建时间：2015年11月12日 上午11:37:45
	 * @param bean
	 * @param model
	 * @throws ErimException
	 *
	 */
 @RequestMapping(value="/mall/users/upgrade")
 public String upgrade(MallUsersBean bean,ModelMap model) throws ErimException{
	 this.mallusersService.upgrade(bean);
	 return this.showList(model, bean);
 }
 }