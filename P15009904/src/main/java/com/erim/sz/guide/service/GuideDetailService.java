package com.erim.sz.guide.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.core.lang.ExtHashMap;
import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.common.util.CodeUtil;
import com.erim.sz.guide.dao.GuideDetailDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.sz.web.util.RandomUtil;
import com.erim.sz.zy.service.ZySystemCooperationService;
import com.erim.web.service.CodeService;

/**
 * @ClassName: GuideDetailService
 * @Description: 导游接口
 * @author 陈鹏
 * @date 2015年7月29日 下午8:03:43
 */
@Service("guideService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuideDetailService {

	@Autowired
	private GuideDetailDao guideDao;
	@Autowired
	private CodeService codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	@Autowired
	private ZySystemCooperationService zySystemCooperationService;
    
	/**
	 * @描述: 同业管理列表页
	 * @创建时间: 2015年11月22日 下午5:14:43
	 * @param model
	 * @param bean
	 */
	public void showGuideTown(ModelMap model, GuideDetailBean bean){
		
		String date = bean.getGpeDate();
    	if (StringUtils.isEmpty(date)) {
    		bean.setGpeDate(DateUtil.getCuurentDate());
    	}
    	
		// 公司ID
		bean.setCpyId(CommonUtil.getCpyId());
		//获取区域值
		String gdlServer = bean.getGdlServer();
		//当选择国内地陪时，清空国内全陪,国际/港澳台领队,国际/港澳台地陪等字段
		if("01".equals(gdlServer)){
		    bean.setGdlNationalProvince(null);
		    bean.setGdlNationalCity(null);
		    bean.setGdlNationalCounty(null);
			bean.setGdlDestination(null);
			bean.setGdlDestinationCountry(null);
			bean.setGdlGaidLokal(null);
			bean.setGdlGaidCountry(null);
			bean.setGdlLeaderProvince(null);
			bean.setGdlLeaderCity(null);
			bean.setGdlLeaderCounty(null);
			
		}
		//当选择国内全陪时，清空国内地陪时,国际/港澳台领队,国际/港澳台地陪字段
		else if("02".equals(gdlServer)){
			bean.setGdlLocalProvince(null);
			bean.setGdlLocalCity(null);
			bean.setGdlLocalCounty(null);
			bean.setGdlDestination(null);
			bean.setGdlDestinationCountry(null);
			bean.setGdlGaidLokal(null);
			bean.setGdlGaidCountry(null);
			bean.setGdlLeaderProvince(null);
			bean.setGdlLeaderCity(null);
			bean.setGdlLeaderCounty(null);
		}
		//当选择国际/港澳台领队,清空国内全陪时，国内地陪,国际/港澳台地陪时字段
		else if("03".equals(gdlServer)){
			
			bean.setGdlNationalProvince(null);
			bean.setGdlNationalCity(null);
			bean.setGdlNationalCounty(null);
			bean.setGdlGaidLokal(null);
			bean.setGdlGaidCountry(null);
			bean.setGdlLocalProvince(null);
			bean.setGdlLocalCity(null);
			bean.setGdlLocalCounty(null);
			
		}
		//当选择国际/港澳台地陪,清空国内全陪时，国内地陪,国际/港澳台领队 时字段
		else if("04".equals(gdlServer)){
			bean.setGdlNationalProvince(null);
			bean.setGdlNationalCity(null);
			bean.setGdlNationalCounty(null);
			bean.setGdlDestination(null);
			bean.setGdlDestinationCountry(null);
			bean.setGdlLocalProvince(null);
			bean.setGdlLocalCity(null);
			bean.setGdlLocalCounty(null);
			bean.setGdlLeaderProvince(null);
			bean.setGdlLeaderCity(null);
			bean.setGdlLeaderCounty(null);
		}
		
		//如果是合作用户 查询合作用户的操作权限 写入查询条件
		if("1".equals(CommonUtil.getCooperation())){
			Integer cid = zySystemCooperationService.getCpyIdByNtype(ErimConstants.TOWN_GUIDE);
			//产品id
			if(0 != cid)  bean.setId(cid);
		}
				
		// 分页查询
		List<GuideDetailBean> guideList = guideDao.selectPageTown(bean, model);
		
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
			String gdlGaidLokal = detail.getGdlGaidLokal();
			if (gdlGaidLokal != null && !"".equals(gdlGaidLokal)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.STATE, gdlGaidLokal);
				detail.setGdlGaidLokal(str);
			}
	        //国际目的地
			String gdlDestination = detail.getGdlDestination();
			if (gdlDestination != null && !"".equals(gdlDestination)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.STATE, gdlDestination);
				detail.setGdlDestination(str);
			}
		}
		// 回传信息
		model.put("guideList", guideList);
	}
	/**
	 * @方法名: showGuide
	 * @描述: 查询数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月24日 下午4:56:57 
	 * @param model
	 * @param bean
	 */
	public void showGuide(ModelMap model, GuideDetailBean bean) {
		// 公司ID
		bean.setCpyId(CommonUtil.getCpyId());
		//获取区域值
		String gdlServer = bean.getGdlServer();
		//当选择国内地陪时，清空国内全陪,国际/港澳台领队,国际/港澳台地陪等字段
		if("01".equals(gdlServer)){
		    bean.setGdlNationalProvince(null);
		    bean.setGdlNationalCity(null);
		    bean.setGdlNationalCounty(null);
			bean.setGdlDestination(null);
			bean.setGdlDestinationCountry(null);
			bean.setGdlGaidLokal(null);
			bean.setGdlGaidCountry(null);
			bean.setGdlLeaderProvince(null);
			bean.setGdlLeaderCity(null);
			bean.setGdlLeaderCounty(null);
		}
		//当选择国内全陪时，清空国内地陪时,国际/港澳台领队,国际/港澳台地陪字段
		else if("02".equals(gdlServer)){
			bean.setGdlLocalProvince(null);
			bean.setGdlLocalCity(null);
			bean.setGdlLocalCounty(null);
			bean.setGdlDestination(null);
			bean.setGdlDestinationCountry(null);
			bean.setGdlGaidLokal(null);
			bean.setGdlGaidCountry(null);
			bean.setGdlLeaderProvince(null);
			bean.setGdlLeaderCity(null);
			bean.setGdlLeaderCounty(null);
		}
		//当选择国际/港澳台领队,清空国内全陪时，国内地陪,国际/港澳台地陪时字段
		else if("03".equals(gdlServer)){
			
			bean.setGdlNationalProvince(null);
			bean.setGdlNationalCity(null);
			bean.setGdlNationalCounty(null);
			bean.setGdlGaidLokal(null);
			bean.setGdlGaidCountry(null);
			bean.setGdlLocalProvince(null);
			bean.setGdlLocalCity(null);
			bean.setGdlLocalCounty(null);
			
		}
		//当选择国际/港澳台地陪,清空国内全陪时，国内地陪,国际/港澳台领队 时字段
		else if("04".equals(gdlServer)){
			bean.setGdlNationalProvince(null);
			bean.setGdlNationalCity(null);
			bean.setGdlNationalCounty(null);
			bean.setGdlDestination(null);
			bean.setGdlDestinationCountry(null);
			bean.setGdlLocalProvince(null);
			bean.setGdlLocalCity(null);
			bean.setGdlLocalCounty(null);
			bean.setGdlLeaderProvince(null);
			bean.setGdlLeaderCity(null);
			bean.setGdlLeaderCounty(null);
		}
		
		//如果是合作用户 查询合作用户的操作权限 写入查询条件
		if("1".equals(CommonUtil.getCooperation())){
			Integer cid = zySystemCooperationService.getCpyIdByNtype(ErimConstants.TOWN_GUIDE);
			//产品id
			if(0 != cid)  bean.setId(cid);
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
				gdlLanguage = gdlLanguage.replace(",21", "");
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
			//国内地陪
			String gdlLocalCity = detail.getGdlLocalCity();
			if (gdlLocalCity != null && !"".equals(gdlLocalCity)) {
				String[] arr = gdlLocalCity.split(",");
				String str = "";
				if(arr.length >1){
					for(int j = 0;j<arr.length-1;j++){
						if(StringUtils.isEmpty(arr[j])) continue;
						str +=tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[j]))+",";
					}
					str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[arr.length-1]));
				}else if(arr.length == 1){
					str =tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[0]));
				}
				detail.setGdlLocalCity(str);
			}
			//国内全陪
			String gdlNationalCity = detail.getGdlNationalCity();
			if (gdlNationalCity != null && !"".equals(gdlNationalCity)) {
				String[] arr = gdlNationalCity.split(",");
				String str = "";
				if(arr.length >1){
					for(int j = 0;j<arr.length;j++){
						if(StringUtils.isEmpty(arr[j])) continue;
						str +=tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[j]))+",";
					}
					str +=tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[arr.length-1]));
				}else if(arr.length == 1){
					str =tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[0]));
				}
				detail.setGdlNationalCity(str);
			}
			//国际出发地 城市
			String gdlLeaderCity = detail.getGdlLeaderCity();
			if(null != gdlLeaderCity && !"".equals(gdlLeaderCity)){
				String[] arr = gdlLeaderCity.split(",");
				String str = "";
				if(arr.length >1 ){
					for(int j = 0;j<arr.length-1;j++){
						if(StringUtils.isEmpty(arr[j])) continue;
						str +=tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[j]))+",";
					}
					str += tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[arr.length-1]));
				}else if(arr.length ==1){
					str +=tmSystemRegionService.getSystemRegionById(Integer.valueOf(arr[0]));
				}
				detail.setGdlLeaderCity(str);
			}
			//国际目的地
			String gdlDestination = detail.getGdlDestination();
			if (gdlDestination != null && !"".equals(gdlDestination)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.STATE, gdlDestination);
				detail.setGdlDestination(str);
			}
			//国际目的国家
//			String gdlDestinationCountry = detail.getGdlDestinationCountry();
//			if (gdlDestinationCountry != null && !"".equals(gdlDestinationCountry)) {
//				String str = codeService.getValueByCodeKeys(DictionaryUtil.COUNTRY, gdlDestinationCountry);
//				detail.setGdlDestinationCountry(str);
//			}
			//国际地陪
			String gdlGaidLokal = detail.getGdlGaidLokal();
			if (gdlGaidLokal != null && !"".equals(gdlGaidLokal)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.STATE, gdlGaidLokal);
				detail.setGdlGaidLokal(str);
			}
			//国际地陪
//			String gdlGaidCountry = detail.getGdlGaidCountry();
//			if (gdlGaidCountry != null && !"".equals(gdlGaidCountry)) {
//				String str = codeService.getValueByCodeKeys(DictionaryUtil.COUNTRY, gdlGaidCountry);
//				detail.setGdlGaidCountry(str);
//			}
		}
		// 回传信息
		model.put("guideList", guideList);
	}
	
	/**
	 * @描述: 导游信息新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月9日 下午3:56:55
	 * @param model
	 * @param bean
	 * @return
	 */
	public Integer insert(ModelMap model, GuideDetailBean bean) {
		
		/*String service = bean.getGdlServer();
		// 服务范围不包含国内地陪
		if (!service.contains("01")) {
			bean.setGdlLocalProvince(null);
			bean.setGdlLocalCity(null);
			bean.setGdlLocalCounty(null);
		}
		// 不包含国内全陪
		if (!service.contains("02")) {
			bean.setGdlNationalProvince(null);
			bean.setGdlNationalCity(null);
			bean.setGdlNationalCounty(null);
		}
		// 不包含国际港澳台领队
		if (!service.contains("03")) {
			bean.setGdlLeaderProvince(null);
			bean.setGdlLeaderCity(null);
			bean.setGdlLeaderCounty(null);
			bean.setGdlDestination(null);
			bean.setGdlDestinationCountry(null);
		}
		// 不包含国际港澳台地陪
		if (!service.contains("04")) {
			bean.setGdlGaidLokal(null);
			bean.setGdlGaidCountry(null);
		}*/
		
		try{
			// 插入数据
			bean.setGdlCreatetime(new Date());
			// 创建用户
			bean.setGdlCreateuser(CommonUtil.getLoginName());
			// 公司id
			bean.setCpyId(CommonUtil.getCpyId());
			// 随机密码
			bean.setGdlPwd(RandomUtil.genRandomNum(5));
			//是否上下架
			bean.setGdlIsDelStatus("0");
			//插入数据
			Integer result =guideDao.insertGuide(bean);
			//当新增成功，返回ID,更新编码
			if(result == CommonUtil.SUCCESS){
				Integer ID=bean.getId();
				Integer cpyID=bean.getCpyId();
				//获取产品编码
				String code=CodeUtil.getShopCode(CodeUtil.NTYPE_GUIDE, cpyID, ID);
				bean.setGdlCode(code);
				//更新编码
				result = guideDao.Guideupdatecode(bean);
			}
			return result;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @描述: 根据ID查询导游信息
	 * @作者: 
	 * @创建时间: 2015年12月9日 下午3:50:07
	 * @param model
	 * @param bean
	 */
	public void selectGuideDetialById(ModelMap model,GuideDetailBean bean){
		// 执行根据ID查询一条导游信息
		GuideDetailBean detail = guideDao.selectGuide(bean);
		model.addAttribute("guideDetail", detail);
		
		//主要景点逗号分隔成数组
		model.addAttribute("gdlrest", this.getNull(detail.getGdlRest()));
		
		//国内地陪逗号分隔成数组
		model.addAttribute("local", this.getNull(detail.getGdlLocalProvince()));
		//国内地陪逗号分隔成数组
		model.addAttribute("local1", this.getNull(detail.getGdlLocalCity()));
		//国内地陪逗号分隔成数组
		model.addAttribute("local2", this.getNull(detail.getGdlLocalCounty()));
		
		//国内全陪逗号分隔成数组
		model.addAttribute("national", this.getNull(detail.getGdlNationalProvince()));
		//国内全陪逗号分隔成数组
		model.addAttribute("national1", this.getNull(detail.getGdlNationalCity()));
		//国内全陪逗号分隔成数组
		model.addAttribute("national2", this.getNull(detail.getGdlNationalCounty()));
		
		//国际港澳台领队逗号分隔成数组
		model.addAttribute("Leader", this.getNull(detail.getGdlLeaderProvince()));
		//国际港澳台领队逗号分隔成数组
		model.addAttribute("Leader1", this.getNull(detail.getGdlLeaderCity()));
		//国际港澳台领队逗号分隔成数组
		model.addAttribute("Leader2", this.getNull(detail.getGdlLeaderCounty()));
		//国际港澳台领队国家逗号分隔成数组
		model.addAttribute("guojiaa", this.getNull(detail.getGdlDestinationCountry()));
		
		//国际地陪国家逗号分隔成数组
		model.addAttribute("gaidcountry", this.getNull(detail.getGdlGaidCountry()));
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
        //国家字符串类型 自动检索时用
        model.addAttribute("guojiaforquery",this.getGuojiaForQuery(this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY)));
        //港澳台
        model.addAttribute("state",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STATE));
        //公司评级
        model.addAttribute("rating",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.RATING));
        //从业时间
        model.addAttribute("age",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.AGE));
        //预定方式
        model.addAttribute("scheduled",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SCHEDULED));
    	//省
    	model.addAttribute("provinces", this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
    	//同城类型
    	model.addAttribute("sametownntype", ErimConstants.TOWN_GUIDE);
	}
	
	/**
	 * @描述: 分隔省
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月9日 下午3:17:54
	 * @param s
	 * @return
	 */
	public String[] getNull(String s){
		if(s != null ){
			return s.split(",");
		}else{
			return null;
		}
	}
	
	/**
	 * @Title: update
	 * @Description: 修改
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public Integer update(ModelMap model, GuideDetailBean bean) {
		try{
		bean.setGdlCreatetime(new Date());
		guideDao.updateGuide(bean);
		return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}

	/**
	 * @return 
	 * 
	 * @Title: delete
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public int delete(Integer id) {
		try{
			guideDao.deleteGuide(id);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @Title: selectGuide
	 * @Description: 根据主键查询指定的实体
	 * @param @param id
	 * @param @return    设定文件
	 * @return GuideDetailBean    返回签证实体对象
	 * @throws
	 */
	public GuideDetailBean selectGuide(GuideDetailBean bean){
		return guideDao.selectGuide(bean);
	}
	/**
	 * 
	 * @param bean
	 */
	public void updateStatus(ModelMap model, GuideDetailBean bean) {
		try{
			guideDao.deleteguide(bean);
			// 置空，遍历列表
			bean.setId(null);
			bean.setGdlIsDelStatus(null);
			List<GuideDetailBean> guideList = guideDao.selectPageGuide(bean, model);
			model.put("guideList", guideList);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public String getGuojiaForQuery(ExtHashMap map){
	    Iterator iter = map.entrySet().iterator();
	    String s = "";
	    while(iter.hasNext()){
	       Entry entry = (Entry) iter.next();
	       Object a = entry.getValue();
	       s += a.toString()+",";
	    }
	    return s;
	}
	/**
	 * 
	 * @Title: update
	 * @Description: 修改
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public Integer update1(ModelMap model, GuideDetailBean bean) {
		try{
			//bean.setGdlCreatetime(new Date());
			guideDao.updateScheduled(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	/**
	 * @Title: checkLoginName 
	 * @Description: TODO(查看用户是否已经被注册) 
	 * @param @param loginname
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public Integer checkLoginName(String loginname){
		GuideDetailBean userBean = this.guideDao.selectUserByLoginname(loginname);
		return null != userBean?1:0;
	}
}