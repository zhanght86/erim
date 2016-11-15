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

import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.bean.GroundPriceBean;
import com.erim.sz.search.service.GroundDetailService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: GroundSearchController 
 * @Description: 当地游检索
 * @author maoxian
 * @date 2015年12月24日 下午11:26:45
 */
@Controller
public class GroundSearchController {
	
	@Autowired
	private GroundDetailService      groundDetailService;
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
	 * @Title: searchground
	 * @Description: 当地旅游
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/search/ground/list")
	public String searchGround(ModelMap model,@ModelAttribute("groundDetail")GroundDetailBean Bean ){
		groundDetailService.showGround(model,Bean);
		//产品主题
		model.addAttribute("theme", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.THEME));
		//产品标准
		model.addAttribute("standards", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STANDARDS));
		//产品形态
		model.addAttribute("product", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.PRODUCT));
		//学生活动
		model.addAttribute("game", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.GAME));
		//查询字典
		groundDetailService.setCode(model);
		
		this.setNowDate(model);
		return "/search/ground/list";
	}
	
	
	/**
	 * @Title: searchGroundPrice 
	 * @Description: 当地游量价
	 * @param @param model
	 * @param @param price
	 * @param @return
	 * @param @throws ParseException    设定文件 
	 * @return List<GroundPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 上午12:16:29 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/search/ground/price")
	public List<GroundPriceBean> searchGroundPrice(ModelMap model,GroundPriceBean price) throws ParseException{
		
		//获取开始时间
		String startDate = price.getStartDate();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
		c1.add(Calendar.DATE, 5);
		price.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime()));
		
		//返回时间类型
		//List<Map<String,GroundPriceBean>> alist = new ArrayList<Map<String,GroundPriceBean>>();
		List<GroundPriceBean> alist = new ArrayList<GroundPriceBean>();
		
		if(StringUtils.isNotBlank(startDate)){
			List<GroundPriceBean> list = this.groundDetailService.selectPriceList(price);
			//如果数组大于0
			if(null != list && list.size() > 0){
				//时间类型 每天＋1  循环6天
				Calendar c = Calendar.getInstance();
				for(int i = 0 ; i < 6 ;i ++){
					c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
					c.add(Calendar.DATE, i);
					String sd = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
					
					boolean isTrue = false;
					for(GroundPriceBean ground : list){
						if(sd.equals(ground.getGpeDate())){
							//alist.add(ground);
							isTrue = true;
							alist.add(ground);
						}
					}
					if(!isTrue) alist.add(new GroundPriceBean());
				}
			}
		}
		
		return alist;
	}
}
