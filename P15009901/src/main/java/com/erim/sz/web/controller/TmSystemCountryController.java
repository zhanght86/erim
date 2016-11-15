package com.erim.sz.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.lang.ExtHashMap;
import com.erim.sz.web.service.TmSystemCountryService;

/**
 * @ClassName: TmSystemCountryController 
 * @Description: 国家 省
 * @author maoxian
 * @date 2015年10月23日 下午1:07:33
 */
@Controller
public class TmSystemCountryController {
	
	@Autowired
	private TmSystemCountryService tmSystemCountryService;
	
	/**
     * @Title: ajaxGetRegion 
     * @Description: 获取子集省市县返回json
     * @param @param regionid
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/{cpyno}/ajaxGetCountry")
    public ExtHashMap<Integer, String> ajaxGetRegion(String countryid){
    	return StringUtils.isNotBlank(countryid)?this.tmSystemCountryService.getSystemCodeByCodeNo(Integer.parseInt(countryid)):null;
    }
}
