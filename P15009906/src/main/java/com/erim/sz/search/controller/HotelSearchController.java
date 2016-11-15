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

import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.common.bean.HotelPriceBean;
import com.erim.sz.search.service.HotelDetailService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: HotelSearchController 
 * @Description: 酒店检索
 * @author maoxian
 * @date 2015年12月24日 下午11:34:14
 */
@Controller
public class HotelSearchController {
	
	@Autowired
	private HotelDetailService       hotelDetailService;
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
	 * @Title: searchHotel 
	 * @Description: 酒店
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/search/hotel/list")
	public String searchHotel(ModelMap model,@ModelAttribute("hotelDetail") HotelDetailBean Bean ){
	   hotelDetailService.showHotel(model,Bean);
	   //酒店档次
	   model.addAttribute("startlevel", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STARTLEVEL));
	   //查询字典
	   hotelDetailService.setCode(model);
	   //获取当前时间
	   this.setNowDate(model);
	   return "/search/hotel/list";
	}
	
	/**
	 * @throws ParseException 
	 * @Title: searchHotelPrice 
	 * @Description: 量价查询
	 * @param @param model
	 * @param @param price
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月17日 下午7:31:48 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/search/hotel/price")
	public List<HotelPriceBean> searchHotelPrice(ModelMap model,HotelPriceBean price) throws ParseException{
		
		//获取开始时间
		String startDate = price.getStartDate();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
		c1.add(Calendar.DATE, 5);
		price.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime()));
		
		//返回时间类型
		//List<Map<String,HotelPriceBean>> alist = new ArrayList<Map<String,HotelPriceBean>>();
		List<HotelPriceBean> alist = new ArrayList<HotelPriceBean>();
		
		if(StringUtils.isNotBlank(startDate)){
			List<HotelPriceBean> list = this.hotelDetailService.listHotelPrice(price);
			//如果数组大于0
			if(null != list && list.size() > 0){
				//时间类型 每天＋1  循环6天
				Calendar c = Calendar.getInstance();
				for(int i = 0 ; i < 6 ;i ++){
					c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
					c.add(Calendar.DATE, i);
					String sd = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
					
					boolean isTrue = false;
					for(HotelPriceBean hotel : list){
						if(sd.equals(hotel.getHnpDate())){
							//alist.add(hotel);
							isTrue = true;
							alist.add(hotel);
						}
					}
					if(!isTrue) alist.add(new HotelPriceBean());
				}
			}
		}
		
		return alist;
	}
}
