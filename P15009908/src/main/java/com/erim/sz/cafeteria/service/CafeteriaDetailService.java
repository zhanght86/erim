package com.erim.sz.cafeteria.service;

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
import com.erim.sz.cafeteria.dao.CafeteriaDetailDao;
import com.erim.sz.common.bean.CafeteriaDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.common.util.CodeUtil;
import com.erim.sz.cus.service.CusSystemCooperationService;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName:       CafeteriaDetailService 
 * @Description:    (特色餐接口) 
 * @author           贺渊博 
 * @date            2015年10月2日 上午8:53:15 
 */
@Service("cafeteriaService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CafeteriaDetailService {
	
    @Autowired
    private CafeteriaDetailDao cafeteriaDao;
    @Autowired
    private CodeService codeService;
    @Autowired
    private TmSystemRegionService tmSystemRegionService;
    @Autowired
	private CusSystemCooperationService  cusSystemCooperationService;
    
    /**
     * @方法名：showCafeteriaTown 
     * @描述:  同城同业	
     * @作者：     贺渊博
     * @创建时间：2015年11月11日 下午3:37:51
     * @param model
     * @param bean
     */
    public void  showCafeteriaTown(ModelMap model,CafeteriaDetailBean bean) {
    	
    	if (StringUtils.isEmpty(bean.getCpcDate())) {
    		bean.setCpcDate(DateUtil.getCuurentDate());
    	}
		//当前公司
		bean.setCpyId(CommonUtil.getCpyId());
		//获取国内或国际港澳台的值
		String cdlInland = bean.getCdlInland();
		//为国内时清空国际港澳台的值
		if("02".equals(cdlInland)) {
			bean.setCdlExternal(null);
			bean.setCdlForeign(null);
			bean.setCdlForeignCity(null);
		}
		//如果为国际港澳台时清空国际的值
		if("01".equals(cdlInland)){
			bean.setCdlProvince(null);
			bean.setCdlCity(null);
			bean.setCdlCounty(null);
		}
		//分页查询
		List<CafeteriaDetailBean> cafeteriaList = cafeteriaDao.selectPageTown(bean, model);
		for (int i = 0; i < cafeteriaList.size(); i++) {
			CafeteriaDetailBean detail = cafeteriaList.get(i);
			// 城市
			String cdlCity = detail.getCdlCity();
	        if (cdlCity != null && !"".equals(cdlCity)) {
	        	String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(cdlCity));
	        	detail.setCdlCity(str);
	        }
			// 代金券面额
			String cvpPriceTotal = detail.getCvpPriceTotal();
			if (cvpPriceTotal != null && !"".equals(cvpPriceTotal)) {
				cvpPriceTotal = cvpPriceTotal.replace(",", "/");
				detail.setCvpPriceTotal(cvpPriceTotal);
			}
			// 代金券同业价
			String cvpPriceTown = detail.getCvpPriceTown();
			if (cvpPriceTown != null && !"".equals(cvpPriceTown)) {
				cvpPriceTown = cvpPriceTown.replace(",", "/");
				detail.setCvpPriceTown(cvpPriceTown);
			}
        }
		//回传信息
	   model.put("cafeteriaList", cafeteriaList);
	}
    
    /**
     * @Title:showCafeteria
     * @Description:查询特色餐信息
     */
    public void showCafeteria(ModelMap model, CafeteriaDetailBean bean){
        /////////////////////////////////// 字典设置start ///////////////////////////////
    	bean.setCpyId(CommonUtil.getCpyId());
    	// 星级
		model.addAttribute("cdlstartlevel",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.CDLSTARTLEVEL));
		// 省
		model.addAttribute("provinces",        this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		/////////////////////////////////// 字典设置end  ///////////////////////////////
		//同城类型
    	model.addAttribute("sametownntype", ErimConstants.TOWN_CAFETERIA);
    	
		bean.getPageLinkBean().setLimit(10);
		
		//获取国内国际值
		String cdlInland = bean.getCdlInland();
		//选择国内时，清空国际数据
		if("02".equals(cdlInland)){
			bean.setCdlForeign(null);
			bean.setCdlForeignCity(null);
			bean.setCdlExternal(null);
		}
		//选择国际时，清空国内省市县数据
		else if("01".equals(cdlInland)){
			bean.setCdlProvince(null);
			bean.setCdlCity(null);
			bean.setCdlCounty(null);
		}
		//如果是合作用户 查询合作用户的操作权限 写入查询条件
		if("1".equals(CommonUtil.getCooperation())){
			Integer cid = cusSystemCooperationService.getCpyIdByNtype(ErimConstants.TOWN_CAFETERIA);
			//产品id
			if(0 != cid)  bean.setId(cid);
		}
		// 分页查询
		List<CafeteriaDetailBean> cafeteriaList = cafeteriaDao.selectPageCafeteria(bean, model);
		
		for (int i = 0; i < cafeteriaList.size(); i++) {
			CafeteriaDetailBean detail = cafeteriaList.get(i);
			// 城市
			String cdlCity = detail.getCdlCity();
	        if (cdlCity != null && !"".equals(cdlCity)) {
	        	String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(cdlCity));
	        	detail.setCdlCity(str);
	        }
	        //餐厅业务
	        String cdlBusiness = detail.getCdlBusiness();
			if (cdlBusiness != null && !"".equals(cdlBusiness)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.BUSINESS, cdlBusiness);
				detail.setCdlBusiness(str);
			}
			String External=detail.getCdlExternal();
			if(External !=null && !"".equals(External)){
				if("01".equals(External)){
					detail.setCdlExternal("香港");
				}
				if("02".equals(External)){
					detail.setCdlExternal("澳门");
				}
				if("03".equals(External)){
					detail.setCdlExternal("台湾");
				}
			}
		}
		// 回传信息
		model.put("cafeteriaList", cafeteriaList);
		 //国家字符串类型 自动检索时用
        model.addAttribute("guojiaforquery",this.getGuojiaForQuery(this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY)));
	}

    /**
     * @描述: 特色餐新增方法
     * @作者: 宁晓强
     * @创建时间: 2015年12月1日 下午3:39:41
     * @param model
     * @param bean
     * @return
     */
    public Integer insert(ModelMap model, CafeteriaDetailBean bean) {
    	
		try {
			bean.setCdlCreatetime(new Date());
			bean.setCdlCreateuse(CommonUtil.getLoginName());
			bean.setCpyId(CommonUtil.getCpyId());
			bean.setCdlIsDelStatus("0");
			//获取国内国际时
			String cdlInland = bean.getCdlInland();
			if("02".equals(cdlInland)){
				bean.setCdlExternal(null);
				bean.setCdlForeign(null);
				bean.setCdlForeignCity(null);
			}
			if("01".equals(cdlInland)){
				bean.setCdlProvince(null);
				bean.setCdlCity(null);
				bean.setCdlCounty(null);
			}
			Integer result = cafeteriaDao.insertCafeteria(bean);
			// 当新增成功，返回ID，更新编码
			if (result == CommonUtil.SUCCESS) {
				Integer ID = bean.getId(); // 该条数据ID
				Integer cpyID = bean.getCpyId(); // 公司ID
				// 获取产品编号
				String code = CodeUtil.getShopCode(CodeUtil.NTYPE_CAFETERIA, cpyID, ID);
				bean.setCdlCode(code);
				// 更新编号
				result = cafeteriaDao.updateCafeteriacode(bean);
			}
			return result;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
    
    /**
	 * @Title: selectCafeteriaDetialById 
	 * @Description: 根据ID查询实体 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return TexiDetailBean    返回类型 
	 * @throws
	 */
	public void selectCafeteriaDetialById(ModelMap model,Integer id){
		
		CafeteriaDetailBean bean = cafeteriaDao.selectCafeteria(id);
		
		model.addAttribute("CafeteriaDetail", bean);
	}
	
	/**
	 * @描述: 同业资源展示餐厅业务信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月20日 下午6:52:39
	 * @param map
	 * @param id
	 */
	public void showBusinessPage(ModelMap map, Integer id) {
		CafeteriaDetailBean bean = cafeteriaDao.selectCafeteria(id);
		map.addAttribute("businessDetail", bean);
	}
	
    /**
     * @Title:       update
     * @Description:修改特色餐
     * @param    model
     * @return   void 返回类型
     */
    public Integer update(ModelMap model, CafeteriaDetailBean bean) {
    	Integer result = CommonUtil.ERROR;
		try{
			bean.setCdlCreatetime(new Date());
			//获取国内国际时
			String cdlInland = bean.getCdlInland();
			if("02".equals(cdlInland)){
				bean.setCdlExternal(null);
				bean.setCdlForeign(null);
				bean.setCdlForeignCity(null);
			}
			if("01".equals(cdlInland)){
				bean.setCdlProvince(null);
				bean.setCdlCity(null);
				bean.setCdlCounty(null);
			}
			result = cafeteriaDao.updateCafeteria(bean);
			return result;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
    }
	/**
     *@Title:       update
     * @Description:特色餐上线状态
     * @param    model
     * @return   void 返回类型
     */
	public int delete(CafeteriaDetailBean bean) {
		try{
			cafeteriaDao.deleteCafeteria(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
    
	}
	/**
	 * @Title: setCode 
	 * @Description: 放置字典 
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setCode(ModelMap model){
		//网络设施
		model.addAttribute("cdlinternet",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.CDLINTERNET));
		//停车场
		model.addAttribute("stopcar",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.YOUORWU));
		//餐厅业务
		model.addAttribute("business",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.BUSINESS));
		// 餐厅档次
		model.addAttribute("cdlstartlevel", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.CDLSTARTLEVEL));
		// 菜系类别
		model.addAttribute("sort", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SORT));
		// 预定方式
		model.addAttribute("scheduled", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SCHEDULED));
		// 省市县
		model.addAttribute("provinces", this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));

		//国家字符串类型 自动检索时用
        model.addAttribute("guojiaforquery",this.getGuojiaForQuery(this.codeService.getSystemCodeByCodeNo(DictionaryUtil.COUNTRY)));

	}  
	 /**
	  * 
	  * @描述: 修改预定方式
	  * @作者: （李庆）
	  * @创建时间: 2015年11月28日 下午4:38:33
	  * @param model
	  * @param bean
	  * @return
	  */
    public Integer update1(ModelMap model, CafeteriaDetailBean bean) {
    	Integer result = CommonUtil.ERROR;
		try{
			result = cafeteriaDao.updateScheduled(bean);
			return result;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	} 
    
    /**
     * @描述: 连个注释都不写
     * @作者: 
     * @创建时间: 2015年12月18日 上午10:41:54
     * @param map
     * @return
     */
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

}    