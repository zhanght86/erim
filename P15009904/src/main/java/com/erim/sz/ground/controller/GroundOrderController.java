package com.erim.sz.ground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.GroundOrderBean;
import com.erim.sz.ground.service.GroundOrderService;
import com.erim.sz.web.util.CommonUtil;

/***
 * 
* @ClassName: GroundOrderController 
* @Description: 地接社订单详细控制 
* @author 龙龙
* @date 2015年7月30日 下午12:31:26 
*
 */
@Controller
public class GroundOrderController {

    @Autowired
    private GroundOrderService groundOrderService;

    /**
     * 
     * @Description: 地接社订单列表页
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/ground/order/list")
    public String showList(ModelMap model, @ModelAttribute("groundOrder") GroundOrderBean groundOrderBean) throws ErimException {
    	groundOrderBean.setCpyId(CommonUtil.getCpyId());
    	this.groundOrderService.showGround(model, groundOrderBean);
        return "/ground/order/list";
    }
    
    
    
    /**
     * 
     * @方法名: insert
     * @描述: 添加同业订单
     * @作者: 李庆
     * @创建时间: 2015年11月5日 下午4:15:03 
     * @return
     *
     */
    @RequestMapping(value="/ground/order/insert")
	public String insert(){
		return "/ground/order/insert";
	}
    /**
     * 
     * @方法名: update
     * @描述:  修改同业订单
     * @作者: 李庆
     * @创建时间: 2015年11月5日 下午4:15:41 
     * @return
     *
     */
    @RequestMapping(value="/ground/order/update")
   	public String update(){
   		return "/ground/order/update";
   	}
    /**
     * 
     * @方法名: view
     * @描述: 查看同业订单
     * @作者: 李庆
     * @创建时间: 2015年11月5日 下午4:16:33 
     * @return
     *
     */
   	
    @RequestMapping(value="/ground/order/view")
   	public String view(){
   		return "/ground/order/view";
   	}
    /**
     * 
     * @Title: insert
     * @Description: 修改为接单或拒接状态
     * @param @param model
     * @param @param bean
     * @param @return    设定文件
     * @return int    返回类型 1 代表修改成功，0 代表修改失败
     * @throws
     */
   
    @RequestMapping(value = "/ground/order/delete")
    public String insert(ModelMap model,GroundOrderBean groundOrderBean) throws ErimException{
    	groundOrderService.update(model, groundOrderBean);
    	return this.showList(model, groundOrderBean);
    }
}