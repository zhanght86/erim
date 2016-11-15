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

import com.erim.sz.common.bean.ManagementDetailBean;
import com.erim.sz.common.bean.ManagementPriceBean;
import com.erim.sz.search.service.ManagementDetailService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: ManagementSearchController 
 * @Description: 签证检索
 * @author maoxian
 * @date 2015年12月24日 下午11:30:04
 */
@Controller
public class ManagementSearchController {
	
	@Autowired
	private ManagementDetailService  managementDetailService;
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
	 * @Title: searchManagement
	 * @Description: 签证
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/search/management/list")
	public String searchManagement(ModelMap model ,@ModelAttribute("managementDetail")ManagementDetailBean Bean ){
		//面签需要
		model.addAttribute("face",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.INTERVIEW));
		//签证类型
		model.addAttribute("models",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.NTYPE)); 
		//送签地
		model.addAttribute("send",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SEND));
		managementDetailService.showManagement(model,Bean);
		managementDetailService.setCode(model);
		
		//初始化时间
		this.setNowDate(model);
		return "/search/management/list";
	}
	
	/**
	 * @Title: searchGuidePrice 
	 * @Description: 签证量价
	 * @param @param model
	 * @param @param price
	 * @param @return
	 * @param @throws ParseException    设定文件 
	 * @return List<GuidePriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月24日 下午9:46:38 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/search/management/price")
	public List<ManagementPriceBean> searchManagementPrice(ModelMap model,ManagementPriceBean price) throws ParseException{
		
		//获取开始时间
		String startDate = price.getStartDate();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
		c1.add(Calendar.DATE, 5);
		price.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime()));
		
		//返回时间类型
		//List<Map<String,ManagementPriceBean>> alist = new ArrayList<Map<String,ManagementPriceBean>>();
		List<ManagementPriceBean> alist = new ArrayList<ManagementPriceBean>();
		
		if(StringUtils.isNotBlank(startDate)){
			List<ManagementPriceBean> list = this.managementDetailService.selectPriceList(price);
			//如果数组大于0
			if(null != list && list.size() > 0){
				//时间类型 每天＋1  循环6天
				Calendar c = Calendar.getInstance();
				for(int i = 0 ; i < 6 ;i ++){
					c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
					c.add(Calendar.DATE, i);
					String sd = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
					
					boolean isTrue = false;
					for(ManagementPriceBean management : list){
						if(sd.equals(management.getMdlDate())){
							//alist.add(management);
							isTrue = true;
							alist.add(management);
						}
					}
					if(!isTrue) alist.add(new ManagementPriceBean());
				}
			}
		}
		
		return alist;
	}
}
