package com.erim.sz.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.common.bean.TicketPriceBean;
import com.erim.sz.web.service.TicketDetailService;
import com.erim.sz.web.service.TicketPriceService;
import com.erim.sz.web.service.TicketclassService;
import com.erim.sz.web.service.TmSystemRegionService;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.bean.CodeBean;
import com.erim.web.service.CodeService;

/**
 * @ClassName: TicketController 
 * @Description: 门票管理
 * @author maoxian
 * @date 2015年9月15日 下午1:44:51 
 */
@Controller
public class TicketController {
	
	@Autowired
	private TicketDetailService ticketDetailService;
	@Autowired
	private TicketPriceService ticketPriceService;
	@Autowired
	private TicketclassService classService;
	@Autowired
	private CodeService		   codeService;
	@Autowired 
	private TmSystemRegionService tmSystemRegionService;
	/**
	 * @Title: menpiao 
	 * @Description: 门票管理
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/ticket/menpiao")
	public String menpiao(ModelMap model,@ModelAttribute("ticket")TicketDetailBean bean) {
		
		
		
		this.ticketDetailService.showTicket(model, bean, 10);
		/*门票列表页搜索项*/
		//主题
		model.addAttribute("attractions", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ATTRACTIONS));
		//景点级别
		model.addAttribute("sceniclevel", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SCENICLEVEL));
		// 省份
	    model.addAttribute("provinces",        this.tmSystemRegionService.getSystemCodeListForProvince());
		return "/ticket/menpiao";
	}
	@RequestMapping(value = "/{cpyno}/ticket/menpiaoss/{adttrac}")
	public String menpiaoss(ModelMap model,@ModelAttribute("ticket")TicketDetailBean bean,@ModelAttribute("adttrac") String adttrac) {
		
		if(StringUtils.isEmpty(bean.getTplDate())){
			bean.setTplDate(DateUtil.getCuurentDate());
    	}
		
		this.ticketDetailService.showTicket(model, bean, 10);
		/*门票列表页搜索项*/
		//主题
		model.addAttribute("attractions", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ATTRACTIONS));
		//景点级别
		model.addAttribute("sceniclevel", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SCENICLEVEL));
		// 省份
	    model.addAttribute("provinces",        this.tmSystemRegionService.getSystemCodeListForProvince());
		return "/ticket/menpiao";
	}
	/**
	 * @Title: menpiaoxiang 
	 * @Description: 门票详情
	 * @param @param model
	 * @param @param id
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/ticket/menpiaoxiang/{id}/{tplDate}")
	public String menpiaoxiang(ModelMap model,@PathVariable("id") Integer id,@PathVariable("tplDate") String tplDate) {
		
		this.ticketDetailService.selectBeanByPriId(model, id);
		
		//门票票类管理
		classService.selectList(id, model,tplDate);
		return "/ticket/menpiaoxiang";
	}
	
	/**
	 * @Title: menpiaoView 
	 * @Description: 门票详情
	 * @param @param model
	 * @param @param id
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月12日 下午11:04:47 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/ticket/menpiaoxiang/{id}")
	public String menpiaoxiang(ModelMap model,@PathVariable("id") Integer id) {
		
		this.ticketDetailService.selectBeanByPriId(model, id);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String datestr = sdf.format(date);
		//门票票类管理
		classService.selectList(id, model,datestr);
		return "/ticket/menpiaoxiang";
	}
	
	/**
	 * @描述: 门票量价
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午4:19:46
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/{cpyno}/ticket/menpiaoxiang/price")
	public String priceList(ModelMap map, TicketPriceBean bean) {
		ticketPriceService.getTicketPriceList(map, bean);
		return "ticket/price";
	}
	
	/**
	 * @描述: 时间跳转
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午4:22:24
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/{cpyno}/ticket/menpiaoxiang/skipDate")
	public String skipPriceDate(ModelMap map, TicketPriceBean bean) {
		String portal = bean.getPortal();
		
		// 时间向前选择
		if ("01".equals(portal)) {
			ticketPriceService.forward(map, bean);
		} else if ("02".equals(portal)) {
			// 时间向后选择
			ticketPriceService.backwards(map, bean);
		}
		return "/ticket/price";
	}
	
	@ResponseBody
	@RequestMapping("/{cpyno}/ticket/menpiaoxiang/getPriceDetailById/{id}")
	public TicketPriceBean getDictionaryByValue(@PathVariable("id") Integer id) {
		TicketPriceBean tbean = ticketPriceService.getPriceBeanById(id);
		return tbean;
	}
}