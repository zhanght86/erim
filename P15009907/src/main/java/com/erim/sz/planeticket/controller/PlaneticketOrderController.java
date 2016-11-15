package com.erim.sz.planeticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.PlaneticketOrderBean;
import com.erim.sz.planeticket.service.PlaneticketOrderService;
import com.erim.sz.web.util.CommonUtil;

/***
 * 
* @ClassName: PlaneticketOrderController 
* @Description: 飞机票订单详细控制 
* @author 龙龙
* @date 2015年7月30日 下午1:10:17 
*
 */
@Controller
public class PlaneticketOrderController {

    @Autowired
    private PlaneticketOrderService planeticketOrderService;

    /**
     * 
     * @Description: 飞机票订单列表页
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/planeticket/order/list")
    public String showList(ModelMap model, @ModelAttribute("planeticketOrder") PlaneticketOrderBean planeticketOrderBean) throws ErimException {
    	planeticketOrderBean.setCpyId(CommonUtil.getCpyId());
    	this.planeticketOrderService.showPlaneticket(model, planeticketOrderBean);
        return "/planeticket/order/list";
    }
    /**
     * 
     * @方法名: insert
     * @描述:  添加同业订单
     * @作者: 李庆
     * @创建时间: 2015年11月5日 下午4:25:02 
     * @return
     *
     */
    @RequestMapping(value="/planeticket/order/insert")
	public String insert(){
		return "/planeticket/order/insert";
	}
    /**
     * 
     * @方法名: update
     * @描述:  修改同业订单
     * @作者: 李庆
     * @创建时间: 2015年11月5日 下午4:25:02 
     * @return
     *
     */
    @RequestMapping(value="/planeticket/order/update")
   	public String update(){
   		return "/planeticket/order/update";
   	}
    /**
     * 
     * @方法名: view
     * @描述: 查看同业订单
     * @作者: 李庆
     * @创建时间: 2015年11月5日 下午4:25:02 
     * @return
     *
     */
   	
    @RequestMapping(value="/planeticket/order/view")
   	public String view(){
   		return "/planeticket/order/view";
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
    
    @RequestMapping(value = "/planeticket/order/delete")
    public String insert(ModelMap model,PlaneticketOrderBean planeticketOrderBean) throws ErimException{
    	planeticketOrderService.update(model, planeticketOrderBean);
    	return this.showList(model, planeticketOrderBean);
    }
   
}