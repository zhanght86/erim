package com.erim.sz.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.CafeteriaDetailBean;
import com.erim.sz.common.bean.CafeteriaPriceBean;
import com.erim.sz.common.bean.HotelPriceBean;
import com.erim.sz.web.bean.TmSystemRegionBean;
import com.erim.sz.web.service.CafeteriaDetailService;
import com.erim.sz.web.service.CafeteriaPriceService;
import com.erim.sz.web.service.CarteriaCuisineService;
import com.erim.sz.web.service.CarteriaPackageService;
import com.erim.sz.web.service.CarteriaVoucherService;
import com.erim.sz.web.service.TmSystemRegionService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: CafeteriaController 
 * @Description: 特色餐
 * @author maoxian
 * @date 2015年9月14日 下午7:40:31 
 *
 */
@Controller
public class CafeteriaController {

	@Autowired
	private CafeteriaDetailService cafeteriaDetailService;
	@Autowired
	private CarteriaCuisineService carteriacuisineService;
	@Autowired
	private CarteriaPackageService carteriapackageService;
	@Autowired
	private CarteriaVoucherService carteriavoucherservice;
	@Autowired
	private CafeteriaPriceService cafeteriaPriceService;
	@Autowired
	private CodeService codeService;
	@Autowired 
	private TmSystemRegionService tmSystemRegionService;
	/**
	 * @Title: tesecan 
	 * @Description: 特色餐列表
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/cafeteria/tesecan")
	public String tesecan(ModelMap model,@ModelAttribute("tesecan")CafeteriaDetailBean bean) {
		//首页搜索传的值CdlCityVo 国内城市
		if(StringUtils.isNotEmpty(bean.getCdlCityVo())){
			if("香港".equals(bean.getCdlCityVo())){
				bean.setCdlExternal("01");
			}else if("澳门".equals(bean.getCdlCityVo())){
				bean.setCdlExternal("02");
			}else if("台湾".equals(bean.getCdlCityVo())){
				bean.setCdlExternal("03");
			}else{
				TmSystemRegionBean tmBean = new TmSystemRegionBean();
				tmBean.setRegionName(bean.getCdlCityVo());
				TmSystemRegionBean TmSystemRegionBean = tmSystemRegionService.getSystemRegionByRegionName(tmBean);
				bean.setCdlCity(TmSystemRegionBean.getRegionNo());
				bean.setCdlProvince(TmSystemRegionBean.getRegionPid()+"");
			}
		}
		//首页搜索项传的值CdlForeignCity 国际城市
		if(StringUtils.isNotEmpty(bean.getCdlForeignCity())){
			if("香港".equals(bean.getCdlForeignCity())){
				bean.setCdlExternal("01");
				bean.setCdlForeignCity(null);
			}else if("澳门".equals(bean.getCdlForeignCity())){
				bean.setCdlExternal("02");
				bean.setCdlForeignCity(null);
			}else if("台湾".equals(bean.getCdlForeignCity())){
				bean.setCdlExternal("03");
				bean.setCdlForeignCity(null);
			}else{
				bean.setCdlExternal("04");
			}
		}
		this.cafeteriaDetailService.showCafeteria(model, bean,12);
		/*列表页搜索项*/
		//主打菜系
		model.addAttribute("sort",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SORT));
		// 省份
	    model.addAttribute("provinces",        this.tmSystemRegionService.getSystemCodeListForProvince());
		return "/cafeteria/tesecan";
	}
	
	/**
	 * @Title: tesecanxiang 
	 * @Description: 特色餐详情页 
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/cafeteria/tesecanxiang/{id}")
	public String tesecanxiang(ModelMap model,@PathVariable("id") Integer id) {
		this.cafeteriaDetailService.selectCafeteriaById(id, model);
		//餐厅特色菜
		carteriacuisineService.selectList(id, model);
		//餐厅套餐
		carteriapackageService.selectList(id, model);
		//餐厅代金券
		carteriavoucherservice.selectvoucherById(model, id);
		return "/cafeteria/tesecanxiang";
	}
	/**
	 * @Title: orderpage 
	 * @Description: 特色餐预订页面
	 * @param @param model
	 * @param @param id
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/cafeteria/orderpage/{id}")
	public String orderpage(ModelMap model,@PathVariable("id") Integer id){
		return "/cafeteria/tescecanorder";
	}
	
	@RequestMapping("/{cpyno}/cafeteria/tesecanxiang/price")
	public String priceList(ModelMap map, CafeteriaPriceBean bean) {
		cafeteriaPriceService.getCafeteriaPriceList(map, bean);
		return "cafeteria/price";
	}
	/**
	 * 
	 * @描述: 时间向前或向后选择
	 * @作者: 吴哲元
	 * @创建时间: 2015年12月25日 上午11:27:03
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/{cpyno}/cafeteria/tesecanxiang/skipDate")
	public String skipDate(ModelMap map, CafeteriaPriceBean bean) {
		
		String portal = bean.getPortal();
		
		if ("01".equals(portal)) {
			// 时间向前选择
			cafeteriaPriceService.forward(map, bean);
		} else if ("02".equals(portal)) {
			// 时间向后选择
			cafeteriaPriceService.backwards(map, bean);
		}
		return "cafeteria/price";
	}
	
}