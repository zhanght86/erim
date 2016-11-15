package com.erim.sz.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.ManagementOrderBean;
import com.erim.sz.management.service.ManagementOrderService;
import com.erim.sz.web.util.CommonUtil;

/***
 * 
* @ClassName: ManagementOrderController 
* @Description: 签证订单详细控制
* @author 于宪洋
* @date 2015年7月30日 下午1:06:24 
*
 */
@Controller
public class ManagementOrderController {

    @Autowired
    private ManagementOrderService managementOrderService;

    /**
     * 
     * @Description: 签证订单列表页
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/management/order/list")
    public String showList(ModelMap model, @ModelAttribute("managementOrder") ManagementOrderBean managementOrderBean) throws ErimException {
    	managementOrderBean.setCpyId(CommonUtil.getCpyId());
    	this.managementOrderService.showManagement(model, managementOrderBean);
        return "/management/order/list";
    }

    /**
     * 
     * @方法名: insert
     * @描述:  添加同业订单
     * @作者: 李庆
     * @创建时间: 2015年11月5日 下午4:21:02 
     * @return
     *
     */
    @RequestMapping(value="/management/order/insert")
	public String insert(){
		return "/management/order/insert";
	}
    /**
     * 
     * @方法名: update
     * @描述:  修改同业订单
     * @作者: 李庆
     * @创建时间: 2015年11月5日 下午4:21:02 
     * @return
     *
     */
    @RequestMapping(value="/management/order/update")
   	public String update(){
   		return "/management/order/update";
   	}
    /**
     * 
     * @方法名: view
     * @描述: 查看同业订单
     * @作者: 李庆
     * @创建时间: 2015年11月5日 下午4:21:02 
     * @return
     *
     */
   	
    @RequestMapping(value="/management/order/view")
   	public String view(){
   		return "/management/order/view";
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
    @RequestMapping(value = "/management/order/delete")
    public String insert(ModelMap model, ManagementOrderBean managementOrderBean) throws ErimException{
    	 managementOrderService.update(model, managementOrderBean);
    	 return this.showList(model, managementOrderBean);
    }
    
    

}