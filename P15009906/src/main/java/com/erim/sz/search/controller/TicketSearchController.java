package com.erim.sz.search.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.common.bean.TicketPriceBean;
import com.erim.sz.search.service.TicketDetailService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: TicketSearchController 
 * @Description: 门票检索
 * @author maoxian
 * @date 2015年12月24日 下午11:33:34
 */
@Controller
public class TicketSearchController {
	
	@Autowired
	private TicketDetailService      ticketDetailService;
	@Autowired
	private CodeService		   	     codeService;
	
	
	
	/**
	 * @Title: setNowDate 
	 * @Description: 获取当前时间 
	 * @param     设定文件 
	 * @return void    返回类型 
	 * @author maoxian
	 * @date 2015年12月19日 下午3:09:30 
	 * @throws
	 */
	public void setNowDate(ModelMap model){
		model.addAttribute("nowDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	}
	/**
	 * @Title: searchTicket 
	 * @Description: 门票
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/search/ticket/list")
	public String searchTicket(ModelMap model,@ModelAttribute("ticketDetail")TicketDetailBean Bean ){
	   ticketDetailService.showTicket(model,Bean);
	   //字典查询
	   ticketDetailService.setCode(model);
	   //获取当前时间
	   this.setNowDate(model);
	   return "/search/ticket/list";
	}
	
	/**
	 * @Title: searchTicketPrice 
	 * @Description: 门票量价计算
	 * @param @param model
	 * @param @param price
	 * @param @return
	 * @param @throws ParseException    设定文件 
	 * @return List<TicketPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 下午1:18:20 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/search/ticket/price")
	public List<TicketPriceBean> searchTicketPrice(ModelMap model,TicketPriceBean price) throws ParseException{
		
		//获取开始时间
		String startDate = price.getStartDate();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
		c1.add(Calendar.DATE, 5);
		price.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime()));
		
		//返回时间类型
		//List<Map<String,TicketPriceBean>> alist = new ArrayList<Map<String,TicketPriceBean>>();
		List<TicketPriceBean> alist = new ArrayList<TicketPriceBean>();
		
		if(StringUtils.isNotBlank(startDate)){
			List<TicketPriceBean> list = this.ticketDetailService.listTicketPrice(price);
			//如果数组大于0
			if(null != list && list.size() > 0){
				//时间类型 每天＋1  循环6天
				Calendar c = Calendar.getInstance();
				for(int i = 0 ; i < 6 ;i ++){
					c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
					c.add(Calendar.DATE, i);
					String sd = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
					
					boolean isTrue = false;
					for(TicketPriceBean ticket : list){
						if(sd.equals(ticket.getTplDate())){
							//alist.add(ticket);
							isTrue = true;
							alist.add(ticket);
						}
					}
					if(!isTrue) alist.add(new TicketPriceBean());
				}
			}
		}
		
		return alist;
	}
}
