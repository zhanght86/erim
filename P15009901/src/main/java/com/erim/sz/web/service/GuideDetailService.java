package com.erim.sz.web.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.web.bean.TmSystemRegionBean;
import com.erim.sz.web.dao.GuideDetailDao;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: GuideDetailService 
 * @Description: 导游
 * @author maoxian
 * @date 2015年11月3日 下午1:13:29
 */
@Service("guidedetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuideDetailService {

	@Autowired
	private GuideDetailDao        guideDao;
	@Autowired
	private CodeService           codeService;
	@Autowired
	private LineDetailService   lineDetailService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	@Autowired
	private TicketDetailService   ticketService;
	/**
	 * @Title: showGuide
	 * @Description: 查询酒店信息
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void showGuide(ModelMap model, GuideDetailBean bean, Integer limit) {
		//页面查询：目的城市
		//城市搜索 国内地陪 出发地为国内
		if(StringUtils.isNotEmpty(bean.getGdlLocalCityVo())){
			
			TmSystemRegionBean tmBean = new TmSystemRegionBean();
			tmBean.setRegionName(bean.getGdlLocalCityVo());
			TmSystemRegionBean TmSystemRegionBean = tmSystemRegionService.getSystemRegionByRegionName(tmBean);
			if("01".equals(bean.getGdlServer())){//国内地陪
				if(TmSystemRegionBean != null){
					bean.setGdlLocalCity(TmSystemRegionBean.getRegionNo());
					bean.setGdlLocalProvince(TmSystemRegionBean.getRegionPid()+"");;
				}else{
					bean.setGdlLocalCity(bean.getGdlLocalCityVo());
				}
			}else if("02".equals(bean.getGdlServer())){//国内全陪
				if(TmSystemRegionBean != null){
					bean.setGdlNationalCity(TmSystemRegionBean.getRegionNo());
					bean.setGdlNationalProvince(TmSystemRegionBean.getRegionPid()+"");;
				}else{
					bean.setGdlNationalCity(bean.getGdlLocalCityVo());
				}
			}
		}
		//城市搜索 国内全陪 出发地为国内
		if(StringUtils.isNotEmpty(bean.getGdlForienCityVo())){
			
			TmSystemRegionBean tmBean = new TmSystemRegionBean();
			tmBean.setRegionName(bean.getGdlForienCityVo());
			TmSystemRegionBean TmSystemRegionBean = tmSystemRegionService.getSystemRegionByRegionName(tmBean);
			if("03".equals(bean.getGdlServer())){//国际港澳台领队 出发地
				if(TmSystemRegionBean != null){
					bean.setGdlLeaderCity(TmSystemRegionBean.getRegionNo());
					bean.setGdlLeaderProvince(TmSystemRegionBean.getRegionPid()+"");;
				}else{
					bean.setGdlLeaderCity(bean.getGdlLocalCityVo());
				}
			}else if("04".equals(bean.getGdlServer())){//国际港澳台地陪 目的地
				if("香港".equals(bean.getGdlForienCityVo())){
					bean.setGdlGaidLokal("01");
					bean.setGdlGaidCountry(null);
				}else if("澳门".equals(bean.getGdlForienCityVo())){
					bean.setGdlGaidLokal("02");
					bean.setGdlGaidCountry(null);
				}else if("台湾".equals(bean.getGdlForienCityVo())){
					bean.setGdlGaidLokal("03");
					bean.setGdlGaidCountry(null);
				}else{
					bean.setGdlGaidLokal("04");
					bean.setGdlGaidCountry(bean.getGdlForienCityVo());
				}
			}
		}
		
		
		if(StringUtils.isEmpty(bean.getGdlServer())){
			bean.setGdlServer("01");
		}
		// 量价日期
//		if (StringUtils.isEmpty(bean.getGpeDate())) {
//			bean.setGpeDate(DateUtil.getCuurentDate());
//		}
		// 分页查询
		List<GuideDetailBean> guideList = guideDao.selectPageGuide(bean, model,limit);
		//转码
		//服务类型
//		for(int i = 0;i < guideList.size();i++){
//			GuideDetailBean detail = guideList.get(i);
//			String gdlServerTemp = "";
//			String gdlServer = detail.getGdlServer();
//			if(null != gdlServer && !"".equals(gdlServer)){
//				if(gdlServer.indexOf("01")>=0){
//					gdlServerTemp += "国内地陪,";
//				}
//				if(gdlServer.indexOf("02")>=0){
//					gdlServerTemp += "国内全陪,";
//				}
//				if(gdlServer.indexOf("03")>=0){
//					gdlServerTemp += "国际港澳台/领队,";
//				}
//				if(gdlServer.indexOf("04")>=0){
//					gdlServerTemp += "国家港澳台/地陪,";
//				}
//				
//				if(gdlServerTemp.length()>0){
//					detail.setGdlServer(gdlServerTemp.substring(0, gdlServerTemp.length()-1));
//				}else{
//					detail.setGdlServer("");
//				}
//			}
//		}
		//回传信息
		model.put("guideList", guideList);
		//热门专线
		this.lineDetailService.selectHotLine(model);
		//热门门票 
		this.ticketService.selectHoteTicket(model);
	}
	
	/**
	 * @描述: 字典
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月30日 上午10:32:05
	 * @param map
	 */
	public void setCode(ModelMap map) {
		/*导游列表页搜索项*/
		//性别
		map.addAttribute("sex",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SEX));
		//导游级别
		map.addAttribute("rating",    this.codeService.getSystemCodeByCodeNo(DictionaryUtil.RATING));
		//导游语种
		map.addAttribute("language",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.LANGUAGE));
		//港澳台
        map.addAttribute("state",     this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STATE));
	}
	
	/**
	 * @Title: selectGuide
	 * @Description: 根据主键查询指定的实体
	 * @param @param id
	 * @param @return    设定文件
	 * @return GuideDetailBean    返回签证实体对象
	 * @throws
	 */
	public void selectGuide(int id,String gdlServer,ModelMap model){
		GuideDetailBean GuideBean = guideDao.selectGuide(id);
		//外语语种
		String gdlLanguage = GuideBean.getGdlLanguage();
		if (gdlLanguage != null && !"".equals(gdlLanguage)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.LANGUAGE, gdlLanguage);
			GuideBean.setGdlLanguage(str);
		}
		//导游等级
		String gdlGrade = GuideBean.getGdlGrade();
		if (gdlGrade != null && !"".equals(gdlGrade)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.GRADE, gdlGrade);
			GuideBean.setGdlGrade(str);
		}
		//导游公司评级
		String CompanyRating = GuideBean.getGdlCompanyRating();
		if (CompanyRating != null && !"".equals(CompanyRating)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.RATING, CompanyRating);
			GuideBean.setGdlCompanyRating(str);
		}
		//服务类型
		/*String gdlServer = GuideBean.getGdlServer();
		if (gdlGrade != null && !"".equals(gdlGrade)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.SERVICE, gdlServer);
			GuideBean.setGdlServer(str);
		}*/
		
		//服务城市(国内地陪)
		if("01".equals(gdlServer)){
			String LocalCity = GuideBean.getGdlLocalCity();
			if(null != LocalCity && !"".equals(LocalCity)){
				String[] arr = LocalCity.split(",");
				String str = "";
				if(arr.length >1){
					for(int i = 0;i<arr.length-1;i++){
						str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[i]))+",";
					}
					str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[arr.length-1]));
				}else if(arr.length ==1){
					str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[0]));
				}
				GuideBean.setGdlLocalCity(str);
			}
		}else if("02".equals(gdlServer)){
			//服务城市(国内全陪)
			String NationalCity = GuideBean.getGdlNationalCity();
			if(null != NationalCity && !"".equals(NationalCity)){
				String[] arr = NationalCity.split(",");
				String str = "";
				if(arr.length > 1){
					for(int i = 0;i < arr.length - 1;i++){
						str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[i]))+",";
					}
					str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[arr.length-1]));
				}else if(arr.length ==1){
					str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[0]));
				}
				GuideBean.setGdlNationalCity(str);
			}
		}else if("03".equals(gdlServer)){
			//服务城市(国际领队)
			String LeaderCity = GuideBean.getGdlLeaderCity();
			if(null != LeaderCity && !"".equals(LeaderCity)){
				String[] arr = LeaderCity.split(",");
				String str = "";
				if(arr.length > 1){
					for(int i = 0;i < arr.length - 1;i++){
						str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[i]))+",";
					}
					str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[arr.length-1]));
				}else if(arr.length ==1){
					str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[0]));
				}
				GuideBean.setGdlLeaderCity(str);
			}
			//国际领队(港澳台)
			String Destination = GuideBean.getGdlDestination();
			if(null != Destination && !"".equals(Destination)){
//				if("01".equals(Destination)){
//					GuideBean.setGdlDestination("香港");
//				}
//				if("02".equals(Destination)){
//					GuideBean.setGdlDestination("澳门");
//				}
//				if("03".equals(Destination)){
//					GuideBean.setGdlDestination("台湾");
//				}
//				if("04".equals(Destination)){
//					GuideBean.setGdlDestination("国际");
//				}
				if(Destination.contains("04")){
					//国际港澳台领队(国家)
					String DestinationCountry = GuideBean.getGdlDestinationCountry();
					if (null != DestinationCountry && !"".equals(DestinationCountry)) {
						model.addAttribute("guojild", DestinationCountry.split(","));
					} else {
						model.addAttribute("guojild", new String[]{""});
					}
				}
			}
			
			
		}else if("04".equals(gdlServer)){
			//国际地陪(港澳台)
			String GaidLokal = GuideBean.getGdlGaidLokal();
			if(GaidLokal.contains("04")){
				//国际地陪(国家)
				String GaidCountry = GuideBean.getGdlGaidCountry();
				if (null != GaidCountry && !"".equals(GaidCountry)) {
					model.addAttribute("guojidp", GaidCountry.split(","));
				} else {
					model.addAttribute("guojidp", new String[]{""});
				}
			}
			
		}
		
		model.addAttribute("guide", GuideBean);
	}
	
	
	
	
	
	
	
	
	
	
	
	public void showGuidedj(ModelMap model, GuideDetailBean bean, Integer limit) {
		//页面查询：目的城市
		if(StringUtils.isNotEmpty(bean.getGdlLocalCityVo())){
			TmSystemRegionBean tmBean = new TmSystemRegionBean();
			tmBean.setRegionName(bean.getGdlLocalCityVo());
			TmSystemRegionBean TmSystemRegionBean = tmSystemRegionService.getSystemRegionByRegionName(tmBean);
			if(TmSystemRegionBean != null){
				bean.setGdlLocalCity(TmSystemRegionBean.getRegionNo());
			}
			
		}
		// 量价日期
		if (StringUtils.isEmpty(bean.getGpeDate())) {
			bean.setGpeDate(DateUtil.getCuurentDate());
		}
		// 分页查询
		List<GuideDetailBean> guideList = guideDao.selectPageGuide(bean, model,limit);
		//转码
		//服务类型
		for(int i = 0;i < guideList.size();i++){
			GuideDetailBean detail = guideList.get(i);
			String gdlServerTemp = "";
			String gdlServer = detail.getGdlServer();
			if(null != gdlServer && !"".equals(gdlServer)){
				if(gdlServer.indexOf("01")>=0){
					gdlServerTemp += "国内地陪,";
				}
				if(gdlServer.indexOf("02")>=0){
					gdlServerTemp += "国内全陪,";
				}
				if(gdlServer.indexOf("03")>=0){
					gdlServerTemp += "国际港澳台/领队,";
				}
				if(gdlServer.indexOf("04")>=0){
					gdlServerTemp += "国家港澳台/地陪,";
				}
				
				if(gdlServerTemp.length()>0){
					detail.setGdlServer(gdlServerTemp.substring(0, gdlServerTemp.length()-1));
				}else{
					detail.setGdlServer("");
				}
			}
		}
		//回传信息
		model.put("guideList", guideList);
		//热门专线
		this.lineDetailService.selectHotLine(model);
		//热门门票 
		this.ticketService.selectHoteTicket(model);
	}
	
	public void selectGuidedj(int id,ModelMap model){
		GuideDetailBean GuideBean = guideDao.selectGuide(id);
		//外语语种
		String gdlLanguage = GuideBean.getGdlLanguage();
		if (gdlLanguage != null && !"".equals(gdlLanguage)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.LANGUAGE, gdlLanguage);
			GuideBean.setGdlLanguage(str);
		}
		//导游等级
		String gdlGrade = GuideBean.getGdlGrade();
		if (gdlGrade != null && !"".equals(gdlGrade)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.GRADE, gdlGrade);
			GuideBean.setGdlGrade(str);
		}
		//导游公司评级
		String CompanyRating = GuideBean.getGdlCompanyRating();
		if (CompanyRating != null && !"".equals(CompanyRating)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.RATING, CompanyRating);
			GuideBean.setGdlCompanyRating(str);
		}
		//服务类型
//		String gdlServer = GuideBean.getGdlServer();
//		if (gdlGrade != null && !"".equals(gdlGrade)) {
//			String str = codeService.getValueByCodeKeys(DictionaryUtil.SERVICE, gdlServer);
//			GuideBean.setGdlServer(str);
//		}
		//服务城市(国内地陪)
		String LocalCity = GuideBean.getGdlLocalCity();
		if(null != LocalCity && !"".equals(LocalCity)){
			String[] arr = LocalCity.split(",");
			String str = "";
			if(arr.length >0){
				for(int i = 0;i<arr.length;i++){
					str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[i]))+",";
				}
				str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[arr.length-1]));
			}else if(arr.length ==1){
				str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[0]));
			}
			GuideBean.setGdlLocalCity(str);
		}
		//服务城市(国内全陪)
		String NationalCity = GuideBean.getGdlNationalCity();
		if(null != NationalCity && !"".equals(NationalCity)){
			String[] arr = NationalCity.split(",");
			String str = "";
			if(arr.length > 0){
				for(int i = 0;i < arr.length;i++){
					str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[i]))+",";
				}
				str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[arr.length-1]));
			}else if(arr.length ==1){
				str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[0]));
			}
			GuideBean.setGdlNationalCity(str);
		}
		//服务城市(国际领队)
		String LeaderCity = GuideBean.getGdlLeaderCity();
		if(null != LeaderCity && !"".equals(LeaderCity)){
			String[] arr = LeaderCity.split(",");
			String str = "";
			if(arr.length > 0){
				for(int i = 0;i < arr.length;i++){
					str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[i]))+",";
				}
				str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[arr.length-1]));
			}else if(arr.length ==1){
				str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[0]));
			}
			GuideBean.setGdlLeaderCity(str);
		}
		//国际领队(港澳台)
		String Destination = GuideBean.getGdlDestination();
		if(null != Destination && !"".equals(Destination)){
			if("01".equals(Destination)){
				GuideBean.setGdlDestination("香港");
			}
			if("02".equals(Destination)){
				GuideBean.setGdlDestination("澳门");
			}
			if("03".equals(Destination)){
				GuideBean.setGdlDestination("台湾");
			}
			if("04".equals(Destination)){
				GuideBean.setGdlDestination("国际");
			}
		}
		//国际地陪(港澳台)
		String GaidLokal = GuideBean.getGdlGaidLokal();
		if(null != GaidLokal && !"".equals(GaidLokal)){
			if("01".equals(GaidLokal)){
				GuideBean.setGdlGaidLokal("香港");
			}
			if("02".equals(GaidLokal)){
				GuideBean.setGdlGaidLokal("澳门");
			}
			if("03".equals(GaidLokal)){
				GuideBean.setGdlGaidLokal("台湾");
			}
			if("04".equals(GaidLokal)){
				GuideBean.setGdlGaidLokal("国际");
			}
		}
		//国际港澳台领队(国家)
		String DestinationCountry = GuideBean.getGdlDestinationCountry();
		if (null != DestinationCountry && !"".equals(DestinationCountry)) {
			model.addAttribute("guojild", DestinationCountry.split(","));
		} else {
			model.addAttribute("guojild", new String[]{""});
		}
		//国际地陪(国家)
		String GaidCountry = GuideBean.getGdlGaidCountry();
		if (null != GaidCountry && !"".equals(GaidCountry)) {
			model.addAttribute("guojidp", GaidCountry.split(","));
		} else {
			model.addAttribute("guojidp", new String[]{""});
		}
		model.addAttribute("guide", GuideBean);
	}
	
	
	
	
	
}