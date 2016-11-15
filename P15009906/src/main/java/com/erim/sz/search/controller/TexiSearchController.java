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

import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.common.bean.VTexiPriceBean;
import com.erim.sz.search.service.TexiDetailService;

/**
 * @ClassName: TexiSearchController 
 * @Description: 租车检索
 * @author maoxian
 * @date 2015年12月24日 下午11:32:47
 */
@Controller
public class TexiSearchController {
	
	@Autowired
	private TexiDetailService        texiDetailService;
	
	
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
	 * @Title: searchTexi 
	 * @Description: 租车
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/search/texi/list")
	public String searchTexi(ModelMap model, @ModelAttribute("texiDetail")TexiDetailBean Bean ){
	  texiDetailService.showTexi(model,Bean);
	  //查询字典
	  texiDetailService.setCode(model);
	  
	  this.setNowDate(model);
	  return "/search/texi/list";
	}
	
	/**
	 * @Title: searchTexiPrice 
	 * @Description: 租车量价 
	 * @param @param model
	 * @param @param price
	 * @param @return
	 * @param @throws ParseException    设定文件 
	 * @return List<VTexiPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 下午7:55:44 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/search/texi/price")
	public List<VTexiPriceBean> searchTexiPrice(ModelMap model,VTexiPriceBean price) throws ParseException{
		
		//获取开始时间
		String startDate = price.getStartDate();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
		c1.add(Calendar.DATE, 5);
		price.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime()));
		
		//返回时间类型
		//List<Map<String,VTexiPriceBean>> alist = new ArrayList<Map<String,VTexiPriceBean>>();
		List<VTexiPriceBean> alist = new ArrayList<VTexiPriceBean>();
		
		if(StringUtils.isNotBlank(startDate)){
			List<VTexiPriceBean> list = this.texiDetailService.selectTexiPrice(price);
			//如果数组大于0
			if(null != list && list.size() > 0){
				//时间类型 每天＋1  循环6天
				Calendar c = Calendar.getInstance();
				for(int i = 0 ; i < 6 ;i ++){
					c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
					c.add(Calendar.DATE, i);
					String sd = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
					
					boolean isTrue = false;
					for(VTexiPriceBean texi : list){
						if(sd.equals(texi.getTcpDate())){
							//alist.add(texi);
							isTrue = true;
							alist.add(texi);
						}
					}
					if(!isTrue) alist.add(new VTexiPriceBean());
				}
			}
		}
		
		return alist;
	}
}
