package com.erim.sz.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.CafeteriaDetailBean;
import com.erim.sz.common.bean.CafeteriaPackageBean;
import com.erim.sz.common.bean.CafeteriaPackageDishesBean;
import com.erim.sz.common.bean.CafeteriaPriceBean;
import com.erim.sz.common.bean.CafeteriaVoucherBean;
import com.erim.sz.search.dao.CafeteriaDetailDao;
import com.erim.sz.search.dao.CafeteriaPackageDao;
import com.erim.sz.search.dao.CafeteriaPriceDao;
import com.erim.sz.search.dao.CafeteriaVoucherDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/***
 * 
 * @ClassName: CafeteriaDetailService 
 * @Description: 特色餐接口 
 * @author bo
 * @date 2015年8月23日 下午5:57:52 
 *
 */
@Service("cafeteriaService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CafeteriaDetailService {

	@Autowired
	private CafeteriaDetailDao    cafeteriaDao;
	@Autowired
	private CodeService           codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	@Autowired
	private CafeteriaPackageDao   cafeteriaPackageDao;
	@Autowired
	private CafeteriaPriceDao	  cafeteriaPriceDao;
	@Autowired
	private CafeteriaVoucherDao	  cafeteriaVoucherDao;
	/**
	 * 
	 * @Title: showHotel
	 * @Description: 查询特色餐信息
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public void showCafeteria(ModelMap model, CafeteriaDetailBean bean) {
     /////////////////////////////////// 字典设置start ///////////////////////////////
     // 星级
     model.addAttribute("cdlstartlevel",     this.codeService.getSystemCodeByCodeNo(DictionaryUtil.CDLSTARTLEVEL));
     // 省
     model.addAttribute("provinces",         this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
     //餐厅业务
   	 model.addAttribute("business",			 this.codeService.getSystemCodeByCodeNo(DictionaryUtil.BUSINESS));
     /////////////////////////////////// 字典设置end  ///////////////////////////////

     bean.getPageLinkBean().setLimit(10);

      //获取国内国际值
     String cdlInland = bean.getCdlInland();
     if(null != cdlInland && !"".equals(cdlInland)){
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
     }
       // 分页查询
       List<CafeteriaDetailBean> cafeteriaList = cafeteriaDao.selectPageCafeteria(bean, model);
       for (CafeteriaDetailBean detail : cafeteriaList) {
    	 //根据餐厅id返回代金券列表<....    	   
    	 List<CafeteriaVoucherBean> listVoucher = this.cafeteriaVoucherDao.selectVoucherByCpeId(detail.getId());
    	 detail.setListCafeteriaVoucher(listVoucher);   	 
    	//...>   
    	   
    	 List<CafeteriaPackageBean> listPackage = this.cafeteriaPackageDao.selectPackageByCdlId(detail.getId());
    	 //遍历餐厅 返回套餐
		  StringBuffer cid = new StringBuffer();
		  
    	  //遍历套餐 查询菜品信息
    	  
    	  for(CafeteriaPackageBean cpb : listPackage){
    		  List<CafeteriaPackageDishesBean> listDishes = this.cafeteriaPackageDao.selectDishesByCpeId(cpb.getId());
    		  //遍历菜品 查询菜信息
    		  for(CafeteriaPackageDishesBean dishes : listDishes){
    			  dishes.setFoodList(this.cafeteriaPackageDao.selectFoodByCpdId(dishes.getId()));
    		  }
			  cpb.setDishesList(listDishes);
			  
			  cid.append(cpb.getId()).append(",");
    	  }
    	  detail.setListCafeteriaPackage(listPackage);
    	  
    	  if(null != cid && cid.length()>0 && (cid.lastIndexOf(",") == cid.length()-1)){
			cid.deleteCharAt(cid.length()-1);
		  }
    	  detail.setAllPackageId(cid.toString());
		}
		// 回传信息
		model.put("cafeteriaList", cafeteriaList);
	}

	/**+
	 * @Title: selectCafeteriaDetialById 
	 * @Description: 根据ID查询实体 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return TexiDetailBean    返回类型 
	 * @throws
	 */
	public void selectCafeteriaDetialById(ModelMap model,Integer id){
		
		model.addAttribute("CafeteriaDetail", this.cafeteriaDao.selectCafeteria(id));
	}


	/**
	 * @Title: listHotelPrice 
	 * @Description: 量价查询
	 * @param @param priceBean
	 * @param @return    设定文件 
	 * @return List<CafeteriaPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 下午3:40:51 
	 * @throws
	 */
	public List<CafeteriaPriceBean> listCafeteriaPrice(CafeteriaPriceBean priceBean){
		return this.cafeteriaPriceDao.listCafeteriaPrice(priceBean);
	}
	
	
	/**
	 * @Title: setCode 
	 * @Description: 放置字典 
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setCode(ModelMap model){
		// 餐厅档次
		model.addAttribute("cdlstartlevel", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.CDLSTARTLEVEL));
		//餐厅业务
		model.addAttribute("business",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.BUSINESS));
		// 省市县
		model.addAttribute("provinces", this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
	}
}