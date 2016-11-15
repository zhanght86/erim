package com.erim.sz.sametown.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.sametown.dao.GuideDetailDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: GuideDetailService
 * @描述: 导游接口 
 * @作者: 李庆
 * @创建时间: 2015年10月25日 下午5:08:10
 *
 */
@Service("guideService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuideDetailService {

	@Autowired
	private GuideDetailDao 		  guideDao;
	@Autowired
	private CodeService           codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;

	/**
	 * 
	 * @方法名: showGuide
	 * @描述: 查询数据列表
	 * @作者: 李庆
	 * @创建时间: 2015年10月24日 下午4:56:57 
	 * @param model
	 * @param bean
	 *
	 */
	public void showGuide(ModelMap model, GuideDetailBean bean) {
		// 公司ID
		bean.setCpyId(CommonUtil.getCpyId());
		//获取区域值
		String gdlServer = bean.getGdlServer();
		// 当省为0时置为空
		if ("0".equals(bean.getGdlLocalProvince())) {
			bean.setGdlLocalProvince(null);
		}
		if ("0".equals(bean.getGdlNationalProvince())) {
			bean.setGdlNationalProvince(null);
		}
		if ("0".equals(bean.getGdlLeaderProvince())) {
			bean.setGdlLeaderProvince(null);
		}
		//当选择国内地陪时，清空国内全陪,国际/港澳台领队,国际/港澳台地陪等字段
		if("01".equals(gdlServer)){
		    bean.setGdlNationalProvince(null);
		    bean.setGdlNationalCity(null);
			bean.setGdlDestination(null);
			bean.setGdlDestinationCountry(null);
			bean.setGdlGaidLokal(null);
			bean.setGdlGaidCountry(null);
		}
		//当选择国内全陪时，清空国内地陪时,国际/港澳台领队,国际/港澳台地陪字段
		else if("02".equals(gdlServer)){
			bean.setGdlLocalProvince(null);
			bean.setGdlLocalCity(null);
			bean.setGdlDestination(null);
			bean.setGdlDestinationCountry(null);
			bean.setGdlGaidLokal(null);
			bean.setGdlGaidCountry(null);
		}
		//当选择国际/港澳台领队,清空国内全陪时，国内地陪,国际/港澳台地陪时字段
		else if("03".equals(gdlServer)){
			
			bean.setGdlNationalProvince(null);
			bean.setGdlNationalCity(null);
			bean.setGdlDestination(null);
			bean.setGdlDestinationCountry(null);
			bean.setGdlGaidLokal(null);
			bean.setGdlGaidCountry(null);
		}
		//当选择国际/港澳台地陪,清空国内全陪时，国内地陪,国际/港澳台领队 时字段
		else if("04".equals(gdlServer)){
			bean.setGdlNationalProvince(null);
			bean.setGdlNationalCity(null);
			bean.setGdlDestination(null);
			bean.setGdlDestinationCountry(null);
			bean.setGdlLocalProvince(null);
			bean.setGdlLocalCity(null);
		}
		
		// 分页查询
		List<GuideDetailBean> guideList = guideDao.selectPageGuide(bean, model);
		
		for (int i = 0; i < guideList.size(); i++) {
			
			GuideDetailBean detail = guideList.get(i);
			// 性别
			String gdlSex = detail.getGdlSex();
			if (gdlSex != null && !"".equals(gdlSex)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.SEX, gdlSex);
				detail.setGdlSex(str);
			}
			//语种
			String gdlLanguage = detail.getGdlLanguage();
			if (gdlLanguage != null && !"".equals(gdlLanguage)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.LANGUAGE, gdlLanguage);
				detail.setGdlLanguage(str);
			}
			//公司评级
			String gdlCompanyRating = detail.getGdlCompanyRating();
			if (gdlCompanyRating != null && !"".equals(gdlCompanyRating)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.RATING, gdlCompanyRating);
				detail.setGdlCompanyRating(str);
			}
			//导游等级
			String gdlGrade = detail.getGdlGrade();
			if (gdlGrade != null && !"".equals(gdlGrade)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.GRADE, gdlGrade);
				detail.setGdlGrade(str);
			}
			//国际地陪
			String gdlGaidCountry = detail.getGdlGaidCountry();
			if (gdlGaidCountry != null && !"".equals(gdlGaidCountry)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.COUNTRY, gdlGaidCountry);
				detail.setGdlGaidCountry(str);
			}
			//国际地陪
			String gdlGaidLokal = detail.getGdlGaidLokal();
			if (gdlGaidLokal != null && !"".equals(gdlGaidLokal)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.STATE, gdlGaidLokal);
				detail.setGdlGaidLokal(str);
			}
		    //////////////////////////////////国内地陪/////////////////////////////////////////
			// 省
			String gdlLocalProvince = detail.getGdlLocalProvince();
			if (gdlLocalProvince != null && !"".equals(gdlLocalProvince)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(gdlLocalProvince));
			    detail.setGdlLocalProvince(str);
			}
			// 市
			String gdlLocalCity = detail.getGdlLocalCity();
			if (gdlLocalCity != null && !"".equals(gdlLocalCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(gdlLocalCity));
			    detail.setGdlLocalCity(str);
			}
			/////////////////////////////////国内全陪///////////////////////////////////////////
			// 省
			String gdlNationalProvince = detail.getGdlNationalProvince();
			if (gdlNationalProvince != null && !"".equals(gdlNationalProvince)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(gdlNationalProvince));
			    detail.setGdlNationalProvince(str);
			}
			// 市
			String gdlNationalCity = detail.getGdlNationalCity();
			if (gdlNationalCity != null && !"".equals(gdlNationalCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(gdlNationalCity));
			    detail.setGdlNationalCity(str);
			}
			///////////////////////////国际领队////////////////////////////////////////////////////
	        // 省
			String gdlLeaderProvince = detail.getGdlLeaderProvince();
			if (gdlLeaderProvince != null && !"".equals(gdlLeaderProvince)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(gdlLeaderProvince));
			    detail.setGdlLeaderProvince(str);
			}
			// 市
			String gdlLeaderCity = detail.getGdlLeaderCity();
			if (gdlLeaderCity != null && !"".equals(gdlLeaderCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(gdlLeaderCity));
			    detail.setGdlLeaderCity(str);
			}
	        //国际目的地
			String gdlDestination = detail.getGdlDestination();
			if (gdlDestination != null && !"".equals(gdlDestination)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.STATE, gdlDestination);
				detail.setGdlDestination(str);
			}
			//国际目的国家
			String gdlDestinationCountry = detail.getGdlDestinationCountry();
			if (gdlDestinationCountry != null && !"".equals(gdlDestinationCountry)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.COUNTRY, gdlDestinationCountry);
				detail.setGdlDestinationCountry(str);
			}
		}
		// 回传信息
		model.put("guideList", guideList);
	}
	/**
	 * @Title: setCode 
	 * @Description: 放置字典 
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setCode(ModelMap model){
    	//性别
    	model.addAttribute("sex", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SEX));
    	//服务类型
    	model.addAttribute("service", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SERVICE));
    	//语种
    	model.addAttribute("language", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.LANGUAGE));
    	//等级
    	model.addAttribute("grade", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.GRADE));
    	//国家
        model.addAttribute("guojia",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY));
        //港澳台
        model.addAttribute("state",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STATE));
        //公司评级
        model.addAttribute("rating",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.RATING));
    	//省
    	model.addAttribute("provinces", this.tmSystemRegionService.getSystemCodeByCodeNo(0));
    	//同城类型
    	model.addAttribute("sametownntype", ErimConstants.TOWN_GUIDE);
	}

}