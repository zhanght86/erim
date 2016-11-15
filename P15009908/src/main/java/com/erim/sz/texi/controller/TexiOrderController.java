package com.erim.sz.texi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.TexiOrderBean;
import com.erim.sz.texi.service.TexiOrderService;
import com.erim.sz.web.util.CommonUtil;

   /**
	* 
	* @ClassName: TexiOrderController 
	* @Description: 租车订单详细控制
	* @author 王赛
	* @date 2015年10月1日 下午4:18:19 
	*
	*/
    @Controller
    public class TexiOrderController {

    @Autowired
    private TexiOrderService texiOrderService;

    /**
     * @Title: 		  showList
     * @Description:  租车订单列表页
     * @param @param  model
     * @param @param  request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return        String 返回类型 
     * @throws
     */
    @RequestMapping(value = "/texi/order/list")
    public String showList(ModelMap model, @ModelAttribute("texiOrder") TexiOrderBean texiOrderBean) throws ErimException {
    	texiOrderBean.setCpyId(CommonUtil.getCpyId());
    	this.texiOrderService.showTexi(model, texiOrderBean);
        return "/texi/order/list";
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
    @RequestMapping(value="/texi/order/insert")
	public String insert(){
		return "/texi/order/insert";
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
    @RequestMapping(value="/texi/order/update")
   	public String update(){
   		return "/texi/order/update";
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
   	
    @RequestMapping(value="/texi/order/view")
   	public String view(){
   		return "/texi/order/view";
   	}
    
    /**
     * 
     * @Title: 		  update
     * @Description:  修改为接单或拒接状态
     * @param @param  model
     * @param @param  bean
     * @param @return 设定文件
     * @return        int 返回类型 1 代表修改接单，0 代表修改拒单
     * @throws
     */
    @RequestMapping(value = "/texi/order/delete")
    public String update(ModelMap model,TexiOrderBean texiOrderBean) throws ErimException{
    	texiOrderService.update(model, texiOrderBean);
    	return this.showList(model, texiOrderBean);
    }
}