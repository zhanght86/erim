package com.erim.sz.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.ticket.service.TicketDetailService;
import com.erim.sz.ticket.service.TicketPriceService;
import com.erim.web.service.CodeService;

/**
 * @ClassName: 	TicketDetailController 
 * @Description: 门票详细控制
 * @author 		陈鹏
 * @date 		2015年7月29日 下午3:54:58 
 */
@Controller
public class TicketDetailController {
	
	@Autowired
	private TicketDetailService     ticketService;
	@Autowired
	private CodeService             codeService;
	@Autowired
	private TicketPriceService      ticketPriceService;
    
	/**
	 * @描述: 同城同业-门票
	 * @作者: 
	 * @创建时间: 2015年12月1日 下午5:37:31
	 * @param model
	 * @param bean
	 * @return
	 */
    @RequestMapping("/ticket/detail/sametown")
    public String sametown(ModelMap model,@ModelAttribute("ticketDetail") TicketDetailBean bean) throws ErimException {
    	ticketService.showTicketTown(model, bean);
    	ticketService.setCode(model);
        return "/ticket/sametown/list";
    }
    
    /**
     * @Title: 		  login 
     * @Description:  门票列表页
     * @param @param  model
     * @param @param  request
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return        String    返回类型 
     * @throws
     * 
     */
    @RequestMapping(value = "/ticket/detail/list")
    public String showList(ModelMap model, @ModelAttribute("TicketDetail") TicketDetailBean ticketDetailBean) throws ErimException {
    	
    	ticketService.showTicket(model, ticketDetailBean);
    	ticketService.setCode(model);
        return "/ticket/detail/list";
    }
    
    /**
     * 
     * @Title: 		  view 
     * @Description:  价格 
     * @param @param  id
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return        String    返回类型 
     * @throws
     */
    @RequestMapping(value= "/ticket/detail/detail")
    public String list(@ModelAttribute("id")String id,ModelMap model,@ModelAttribute("ntype") String ntype) throws ErimException{
    	return "/ticket/detail/detail";
    }
    
    /**
     * @throws 			ErimException 
     * @Title: 			delete
     * @Description:    下架产品
     * @param @param    ticketDetailBean
     * @param @return   设定文件
     * @return int      返回类型 1删除成功，0 删除失败
     * @throws
     */
    @RequestMapping(value = "/ticket/detail/delete")
    public String delete(TicketDetailBean bean,ModelMap model) throws ErimException{
    	ticketService.delete(bean);
    	bean=new TicketDetailBean();
    	return this.showList(model, bean);
    }
    
    /**
     * 
     * @Title: 		  insertPage 
     * @Description:  新增页面
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return        String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/ticket/detail/insertPage")
    public String insertPage(ModelMap model) throws ErimException {
    	
    	ticketService.setCode(model);
    	return "/ticket/detail/insert";
    }

    /**
     * 
     * @Title: 			 insert 
     * @Description:     新增方法
     * @param @param     model
     * @param @param     ticketDetailBean
     * @param @return
     * @param @throws    ErimException    设定文件 
     * @return 			 String     返回类型 
     * @throws
     */
    @ResponseBody 
   	@RequestMapping(value = "/ticket/detail/insert")
   	public Integer insert(ModelMap model, TicketDetailBean bean){
       	
   		return ticketService.insert(model, bean);
       }
    /**
     * 
     * @Title: 		  view 
     * @Description:  查看方法 
     * @param @param  id
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return        String    返回类型 
     * @throws
     */
    @RequestMapping(value= "/ticket/detail/view")
    public String view(Integer id,ModelMap model){
    	this.ticketService.selectBeanByPriId(model, id);
    	return "/ticket/detail/view";
    }

    /**
     * @Title: 		  updatePage 
     * @Description:  跳转修改页面
     * @param @param  model
     * @param @return
     * @param @throws ErimException    设定文件 
     * @return        String    返回类型 
     * @throws
     */
    @RequestMapping(value="/ticket/detail/updatePage")
    public String updatePage(ModelMap model,Integer id){
    	//根据ID查询实体
    	ticketService.selectBeanByPriIdUpdete(model, id);
    	//查询字典
    	ticketService.setCode(model);
    	return "/ticket/detail/update";
    }
    
    /**
     * @Title: 		  update 
     * @Description:  修改方法
     * @param @param  model
     * @param @param  ticketDetailBean
     * @param @return 设定文件 
     * @return 		  Integer 返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value="/ticket/detail/update")
    public Integer update(ModelMap model,TicketDetailBean ticketDetailBean) {
    	return this.ticketService.update(model, ticketDetailBean);
    }
    
    /**
     * 
     * @Title: 			 delete
     * @Description:     根据主键删除指定签证数据
     * @param @param     ticketDetailBean
     * @param @return    设定文件
     * @return int       返回类型 1删除成功，0 删除失败
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/ticket/detail/delet")
    public int delete(TicketDetailBean bean){
    	return this.ticketService.delete(bean.getId());
    }
   
    /**
     * 
     * @描述: 跳转预定方式页面
     * @作者: （李庆）
     * @创建时间: 2015年11月28日 下午3:27:36
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value="/ticket/detail/scheduledPage")
    public String scheduledPage(ModelMap model,Integer id){
    	//根据ID查询实体
    	this.ticketService.selectBeanByPriIdUpdete(model, id);
    	//查询字典
    	this.ticketService.setCode(model);
    	return "/ticket/detail/scheduled";
    }
    /**
     * 
     * @描述: 修改预定方式
     * @作者: （李庆）
     * @创建时间: 2015年11月28日 下午3:27:57
     * @param model
     * @param ticketDetailBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/ticket/detail/scheduled")
    public Integer scheduled(ModelMap model,TicketDetailBean ticketDetailBean){
    	return this.ticketService.update1(model, ticketDetailBean);
    }

}