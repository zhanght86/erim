package com.erim.sz.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.HotelOrderBean;
import com.erim.sz.hotel.service.HotelOrderService;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: HotelOrderController 
 * @Description: 酒店订单管理
 * @author maoxian
 * @date 2015年8月8日 下午3:57:33
 */
@Controller
public class HotelOrderController {

    @Autowired
    private HotelOrderService orderService;

    /**
     * 
     * @Description: 酒店列表页
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/hotel/order/list")
    public String showList(ModelMap model, @ModelAttribute("hotelOrder") HotelOrderBean hotelOrderBean) throws ErimException {
    	hotelOrderBean.setCpyId(CommonUtil.getCpyId());
    	this.orderService.showHotelOrder(model, hotelOrderBean);
    	System.out.println(hotelOrderBean.getHloNum());
        return "/hotel/order/list";
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
    @RequestMapping(value="/hotel/order/insert")
	public String insert(){
		return "/hotel/order/insert";
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
    @RequestMapping(value="/hotel/order/update")
   	public String update(){
   		return "/hotel/order/update";
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
   	
    @RequestMapping(value="/hotel/order/view")
   	public String view(){
   		return "/hotel/order/view";
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
    @RequestMapping(value = "/hotel/order/delete")
    public String insert(ModelMap model,HotelOrderBean hotelOrderBean) throws ErimException{
    	orderService.update(model, hotelOrderBean);
    	return this.showList(model, hotelOrderBean);
    }
}