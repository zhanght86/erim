package com.erim.sz.sametown.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.CafeteriaDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.sametown.dao.CafeteriaDetailDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;
/**
 * 
 * @类名: CafeteriaDetailService
 * @描述: 特色餐接口
 * @作者: 李庆
 * @创建时间: 2015年10月26日 下午2:14:21
 *
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
		model.addAttribute("provinces",        this.tmSystemRegionService.getSystemCodeByCodeNo(0));
		/////////////////////////////////// 字典设置end  ///////////////////////////////
		//同城类型
    	model.addAttribute("sametownntype", ErimConstants.TOWN_CAFETERIA);
    	
		bean.getPageLinkBean().setLimit(10);
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
	}

    
}    