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

import com.erim.sz.common.bean.CafeteriaDetailBean;
import com.erim.sz.common.bean.CafeteriaPriceBean;
import com.erim.sz.search.service.CafeteriaDetailService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: CafeteriaSearchController 
 * @Description: 特色餐检索
 * @author maoxian
 * @date 2015年12月24日 下午11:25:33
 */
@Controller
public class CafeteriaSearchController {
	
	@Autowired
	private CafeteriaDetailService   cafeteriaDetailService;
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
	 * @Title: searchcafeteria
	 * @Description: 特色餐
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/search/cafeteria/list")
	public String searchCafeteria(ModelMap model ,@ModelAttribute("cafeteriaDetail")CafeteriaDetailBean Bean ){
		cafeteriaDetailService.showCafeteria(model,Bean);
		//餐厅业务
		model.addAttribute("business",	this.codeService.getSystemCodeByCodeNo(DictionaryUtil.BUSINESS));
		//查询字典
		cafeteriaDetailService.setCode(model);
		//获取当前时间
	    this.setNowDate(model);
		return "/search/cafeteria/list";
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
	@RequestMapping(value = "/search/cafeteria/price")
	public List<CafeteriaPriceBean> searchCafeteriaPrice(ModelMap model,CafeteriaPriceBean price) throws ParseException{
		
		//获取开始时间
		String startDate = price.getStartDate();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
		c1.add(Calendar.DATE, 5);
		price.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime()));
		
		//返回时间类型
		//List<Map<String,CafeteriaPriceBean>> alist = new ArrayList<Map<String,CafeteriaPriceBean>>();
		List<CafeteriaPriceBean> alist = new ArrayList<CafeteriaPriceBean>();
		
		if(StringUtils.isNotBlank(startDate)){
			List<CafeteriaPriceBean> list = this.cafeteriaDetailService.listCafeteriaPrice(price);
			//如果数组大于0
			if(null != list && list.size() > 0){
				//时间类型 每天＋1  循环6天
				Calendar c = Calendar.getInstance();
				for(int i = 0 ; i < 6 ;i ++){
					c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
					c.add(Calendar.DATE, i);
					String sd = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
					
					boolean isTrue = false;
					for(CafeteriaPriceBean cafeteria : list){
						if(sd.equals(cafeteria.getCpcDate())){
							//alist.add(cafeteria);
							isTrue = true;
							alist.add(cafeteria);
						}
					}
					if(!isTrue) alist.add(new CafeteriaPriceBean());
				}
			}
		}
		
		return alist;
	}
}
