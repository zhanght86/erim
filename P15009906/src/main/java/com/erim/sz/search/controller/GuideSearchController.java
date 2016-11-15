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

import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.common.bean.GuidePriceBean;
import com.erim.sz.search.service.GuideDetailService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: GuideSearchController 
 * @Description: 导游检索
 * @author maoxian
 * @date 2015年12月24日 下午11:30:43
 */
@Controller
public class GuideSearchController {
	@Autowired
	private GuideDetailService       guideDetailService;
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
	 * @Title: searchguide
	 * @Description: 导游
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/search/guide/list")
	public String searchGuide(ModelMap model,@ModelAttribute("guideDetail")GuideDetailBean Bean ){
		//性别
		model.addAttribute("sex", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SEX));
		//语种
		model.addAttribute("language", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.LANGUAGE));
		//公司评级
		model.addAttribute("rating",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.RATING));
		
		String s=Bean.getGdlServer();
		if (s!=null)
		{
			if (s.equals("01")) {
				// 02
				Bean.setGdlNationalProvince(null);
				Bean.setGdlNationalCity(null);
				Bean.setGdlNationalCounty(null);
				// 03
				Bean.setGdlLeaderProvince(null);
				Bean.setGdlLeaderCity(null);
				Bean.setGdlLeaderCounty(null);
				Bean.setGdlDestination(null);
				// 04
				Bean.setGdlGaidLokal(null);

			} else if (s.equals("02")) {
				// 01
				Bean.setGdlLocalProvince(null);
				Bean.setGdlLocalCity(null);
				Bean.setGdlLocalCounty(null);

				// 03
				Bean.setGdlLeaderProvince(null);
				Bean.setGdlLeaderCity(null);
				Bean.setGdlLeaderCounty(null);
				Bean.setGdlDestination(null);
				// 04
				Bean.setGdlGaidLokal(null);

			} else if (s.equals("03")) {
				// 01
				Bean.setGdlLocalProvince(null);
				Bean.setGdlLocalCity(null);
				Bean.setGdlLocalCounty(null);

				// 02
				Bean.setGdlNationalProvince(null);
				Bean.setGdlNationalCity(null);
				Bean.setGdlNationalCounty(null);
				// 04
				Bean.setGdlGaidLokal(null);
				
				Bean.setGdlDestination(null);
			}

			else if (s.equals("04")) {
				// 01
				Bean.setGdlLocalProvince(null);
				Bean.setGdlLocalCity(null);
				Bean.setGdlLocalCounty(null);
				// 02
				Bean.setGdlNationalProvince(null);
				Bean.setGdlNationalCity(null);
				Bean.setGdlNationalCounty(null);
				// 03
				Bean.setGdlLeaderProvince(null);
				Bean.setGdlLeaderCity(null);
				Bean.setGdlLeaderCounty(null);
				Bean.setGdlDestination(null);

			} else {
				// 01
				Bean.setGdlLocalProvince(null);
				Bean.setGdlLocalCity(null);
				Bean.setGdlLocalCounty(null);
				// 02
				Bean.setGdlNationalProvince(null);
				Bean.setGdlNationalCity(null);
				Bean.setGdlNationalCounty(null);
				// 03
				Bean.setGdlLeaderProvince(null);
				Bean.setGdlLeaderCity(null);
				Bean.setGdlLeaderCounty(null);
				Bean.setGdlDestination(null);
				// 04
				Bean.setGdlGaidLokal(null);

			}
		}
		
		guideDetailService.showGuide(model,Bean);
		guideDetailService.setCode(model);
		
		//初始化时间
		this.setNowDate(model);
		return "/search/guide/list";
	}
	
	/**
	 * @Title: searchGuidePrice 
	 * @Description: 导游量价检索
	 * @param @param model
	 * @param @param price
	 * @param @return
	 * @param @throws ParseException    设定文件 
	 * @return List<GuidePriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 下午11:23:35 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/search/guide/price")
	public List<GuidePriceBean> searchGuidePrice(ModelMap model,GuidePriceBean price) throws ParseException{
		
		//获取开始时间
		String startDate = price.getStartDate();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
		c1.add(Calendar.DATE, 5);
		price.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime()));
		
		//返回时间类型
		//List<Map<String,GuidePriceBean>> alist = new ArrayList<Map<String,GuidePriceBean>>();
		List<GuidePriceBean> alist = new ArrayList<GuidePriceBean>();
		
		if(StringUtils.isNotBlank(startDate)){
			List<GuidePriceBean> list = this.guideDetailService.selectPriceList(price);
			//如果数组大于0
			if(null != list && list.size() > 0){
				//时间类型 每天＋1  循环6天
				Calendar c = Calendar.getInstance();
				for(int i = 0 ; i < 6 ;i ++){
					c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
					c.add(Calendar.DATE, i);
					String sd = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
					
					boolean isTrue = false;
					for(GuidePriceBean guide : list){
						if(sd.equals(guide.getGpeDate())){
							//alist.add(guide);
							isTrue = true;
							alist.add(guide);
						}
					}
					if(!isTrue) alist.add(new GuidePriceBean());
				}
			}
		}
		
		return alist;
	}
}
