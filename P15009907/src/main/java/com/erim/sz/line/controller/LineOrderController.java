package com.erim.sz.line.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.LineOrderBean;
import com.erim.sz.line.service.LineOrderService;

/***
 * 
 * @类名: LineOrderController
 * @描述: 专线订单详细控制
 * @作者: 李庆
 * @创建时间: 2015年10月16日 下午4:13:12
 *
 */
@Controller
public class LineOrderController {

    @Autowired
    private LineOrderService lineOrderService;

    /**
     * 
     * @Description: 专线订单列表页
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/line/order/list")
    public String showList(ModelMap model, @ModelAttribute("lineOrder") LineOrderBean lineOrderBean) throws ErimException {
    	this.lineOrderService.showLine(model, lineOrderBean);
    	lineOrderBean.setCpyId((Integer)SecurityUtils.getSubject().getSession().getAttribute("userCpyId"));
        return "/line/order/list";
    }

   
    
    /**
     * @throws ErimException 
     * 
     * @Title: insert
     * @Description: 修改为接单或拒接状态
     * @param @param model
     * @param @param bean
     * @param @return    设定文件
     * @return int    返回类型 1 代表修改成功，0 代表修改失败
     * @throws
     */
    @RequestMapping(value = "/line/order/update")
    public String insert(ModelMap model,LineOrderBean lineOrderBean) throws ErimException{
    	lineOrderService.update(model, lineOrderBean);
    	return this.showList(model, lineOrderBean);
    }
    

}