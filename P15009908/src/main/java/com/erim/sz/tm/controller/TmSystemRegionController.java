package com.erim.sz.tm.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.lang.ExtHashMap;
import com.erim.sz.common.bean.CompanyBusinessBean;
import com.erim.sz.tm.bean.TmSystemRegionBean;
import com.erim.sz.tm.service.TmSystemRegionService;

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
    
    /**
     * @Title: ajaxGetRegion 
     * @Description: 获取子集省市县返回json
     * @param @param regionid
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/ajaxLockGetRegion")
    public List<TmSystemRegionBean> ajaxLockGetRegion(String regionid){
    	List<TmSystemRegionBean> list = this.tmSystemRegionService.getSystemCodeListByCodeNo(Integer.parseInt(regionid));

    	//获取公司企业信息
		CompanyBusinessBean buinessBean = (CompanyBusinessBean)SecurityUtils.getSubject().getSession().getAttribute("userBussiness");
		String cbsRanCity1 = buinessBean.getCbsRanCity1();
		String cbsRanCity2 = buinessBean.getCbsRanCity2();
		String cbsRanCity3 = buinessBean.getCbsRanCity3();
		String cbsRanCity4 = buinessBean.getCbsRanCity4();
		String cbsRanCity5 = buinessBean.getCbsRanCity5();
		
		//返回backList
		List<TmSystemRegionBean> backList = new ArrayList<TmSystemRegionBean>();
		for(TmSystemRegionBean region : list){
			String regionNo = region.getRegionNo();
			if(regionNo.equals(cbsRanCity1) || regionNo.equals(cbsRanCity2) || regionNo.equals(cbsRanCity3) || regionNo.equals(cbsRanCity4) || regionNo.equals(cbsRanCity5)){
				backList.add(region);
			}
		}
    	
    	return StringUtils.isNotBlank(regionid)?null!=backList&&backList.size()>0?backList:list:null;
    }
    
    @ResponseBody
    @RequestMapping(value = "/ajaxLockGetTown")
    public List<TmSystemRegionBean> ajaxLockGetTown(String regionid){
    	List<TmSystemRegionBean> list = this.tmSystemRegionService.getSystemCodeListByCodeNo(Integer.parseInt(regionid));

    	//获取公司企业信息
		CompanyBusinessBean buinessBean = (CompanyBusinessBean)SecurityUtils.getSubject().getSession().getAttribute("userBussiness");
		String cbsRanCounty1 = buinessBean.getCbsRanCounty1();
		String cbsRanCounty2 = buinessBean.getCbsRanCounty2();
		String cbsRanCounty3 = buinessBean.getCbsRanCounty3();
		String cbsRanCounty4 = buinessBean.getCbsRanCounty4();
		String cbsRanCounty5 = buinessBean.getCbsRanCounty5();
		
		//返回backList
		List<TmSystemRegionBean> backList = new ArrayList<TmSystemRegionBean>();
		for(TmSystemRegionBean region : list){
			String regionNo = region.getRegionNo();
			if(regionNo.equals(cbsRanCounty1) || regionNo.equals(cbsRanCounty2) || regionNo.equals(cbsRanCounty3) || regionNo.equals(cbsRanCounty4) || regionNo.equals(cbsRanCounty5)){
				backList.add(region);
			}
		}
    	
    	return StringUtils.isNotBlank(regionid)?null!=backList&&backList.size()>0?backList:list:null;
    }
}
