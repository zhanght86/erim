package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.CafeteriaDetailBean;
import com.erim.sz.web.dao.CafeteriaDetailDao;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: CafeteriaDetailService 
 * @Description: 特色餐接口
 * @author maoxian
 * @date 2015年9月14日 下午7:45:08 
 *
 */
@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CafeteriaDetailService {

	@Autowired
	private CafeteriaDetailDao cafeteriaDao;
	@Autowired
	private CodeService codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	/**
	 * 
	 * @Title: showHotel
	 * @Description: 查询特色餐信息
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public void showCafeteria(ModelMap model, CafeteriaDetailBean bean,Integer limit) {
		//转码
		//餐厅菜系
//		String sort = bean.getCdlSort();
//		if (sort != null && !"".equals(sort)) {
//			String str = codeService.getValueByCodeKeys(DictionaryUtil.SORT, sort);
//			bean.setCdlSort(str);
//		}
//		if("香港".equals(bean.getCdlForeignCityVo())){
//			bean.setCdlExternal("01");
//			bean.setCdlForeignCity("");
//		}else if("澳门".equals(bean.getCdlForeignCityVo())){
//			bean.setCdlExternal("02");
//			bean.setCdlForeignCity("");
//		}else if("台湾".equals(bean.getCdlForeignCityVo())){
//			bean.setCdlExternal("03");
//			bean.setCdlForeignCity("");
//		}else{
//			bean.setCdlExternal("");
//			bean.setCdlForeignCity(bean.getCdlForeignCityVo());
//		}
		bean.getPageLinkBean().setLimit(limit);
		// 分页查询
		List<CafeteriaDetailBean> cafeteriaList = cafeteriaDao.selectPageCafeteria(bean, model,limit);
		
		// 回传信息
		model.put("cafeteriaList", cafeteriaList);
	}
	/**
	 * 
	 * @Title: selectCafeteriaById 
	 * @Description: 根据ID查询对象
	 * @param @param id    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void selectCafeteriaById(Integer id,ModelMap model){
		CafeteriaDetailBean detail = cafeteriaDao.selectCafeteria(id);
		/*字典转码*/
		//主打菜系
		String cdlSort = detail.getCdlSort();
		if(cdlSort != null && !"".equals(cdlSort)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.SORT, cdlSort);
			detail.setCdlSort(str);
		}
		//餐厅停车场
		String cdlStopCar = detail.getCdlStopCar();
		if(cdlStopCar != null && !"".equals(cdlStopCar)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.YOUORWU, cdlStopCar);
			detail.setCdlStopCar(str);
		}
		//餐厅网络设施
		String cdlInternet = detail.getCdlInternet();
		if(cdlInternet != null && !"".equals(cdlInternet)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.CDLINTERNET, cdlInternet);
			detail.setCdlInternet(str);
		}
		//餐厅业务
		String cdlBusiness = detail.getCdlBusiness();
		if(cdlBusiness != null && !"".equals(cdlBusiness)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.BUSINESS, cdlBusiness);
			detail.setCdlBusiness(str);
		}
		//市
		String cdlCity = detail.getCdlCity();
        if (cdlCity != null && !"".equals(cdlCity)) {
        	String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(cdlCity));
        	detail.setCdlCity(str);
        }
        //区县
//		String cdlCounty = detail.getCdlCounty();
//	     if (cdlCity != null && !"".equals(cdlCity)) {
//	     	String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(cdlCounty));
//	     	detail.setCdlCounty(str);
//	     }
		model.addAttribute("cafeteria", detail);
	}

}