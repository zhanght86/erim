package com.erim.sz.cafeteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.cafeteria.service.CafeteriaOrderService;
import com.erim.sz.common.bean.CafeteriaOrderBean;
import com.erim.sz.web.util.CommonUtil;

/***
 * 
* @ClassName: CafeteriaOrderController 
* @Description: 特色餐订单详细控制
* @author 龙龙
* @date 2015年7月30日 上午11:31:48 
*
 */
@Controller
public class CafeteriaOrderController {

    @Autowired
    private CafeteriaOrderService cafeteriaOrderService;

    /**
     * 
     * @Description: 特色餐订单列表页
     * @param @param model
     * @param @param request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/cafeteria/order/list")
    public String showList(ModelMap model, @ModelAttribute("cafeteriaOrder") CafeteriaOrderBean cafeteriaOrderBean) throws ErimException {
    	cafeteriaOrderBean.setCpyId(CommonUtil.getCpyId());
    	this.cafeteriaOrderService.showCafeteria(model, cafeteriaOrderBean);
        return "/cafeteria/order/list";
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
    @RequestMapping(value="/cafeteria/order/insert")
	public String insert(){
		return "/cafeteria/order/insert";
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
    @RequestMapping(value="/cafeteria/order/update")
   	public String update(){
   		return "/cafeteria/order/update";
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
   	
    @RequestMapping(value="/cafeteria/order/view")
   	public String view(){
   		return "/cafeteria/order/view";
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
    @RequestMapping(value = "/cafeteria/order/delete")
    public String insert(ModelMap model, CafeteriaOrderBean cafeteriaOrderBean) throws ErimException{
    	cafeteriaOrderService.update(model, cafeteriaOrderBean);
    	return this.showList(model, cafeteriaOrderBean);
    }
    
}