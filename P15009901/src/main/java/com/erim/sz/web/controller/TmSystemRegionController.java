package com.erim.sz.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.lang.ExtHashMap;
import com.erim.sz.web.service.TmSystemRegionService;

/**
 * @ClassName: TmSystemRegionController 
 * @Description:  省市县
 * @author maoxian
 * @date 2015年8月19日 下午11:20:27 
 *
 */
@Controller
public class TmSystemRegionController {
	
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	
	/**
     * @Title: ajaxGetRegion 
     * @Description: 获取子集省市县返回json
     * @param @param regionid
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/ajaxGetRegion")
    public ExtHashMap<Integer, String> ajaxGetRegion(String regionid){
    	return StringUtils.isNotBlank(regionid)?this.tmSystemRegionService.getSystemCodeByCodeNo(Integer.parseInt(regionid)):null;
    }
}
