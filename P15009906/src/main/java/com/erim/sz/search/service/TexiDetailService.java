package com.erim.sz.search.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.common.bean.VTexiCarBean;
import com.erim.sz.common.bean.VTexiPriceBean;
import com.erim.sz.search.dao.TexiDetailDao;
import com.erim.sz.search.dao.VTexiCarDao;
import com.erim.sz.search.dao.VTexiPriceDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

    /***
    * 
    * @ClassName: TexiDetailService
    * @Description: 租车接口
    * @author 龙龙
    * @date 2015年7月29日 下午6:06:16
    *
     */
    @Service("texiService")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public class TexiDetailService {
	
	
	@Autowired
	private TexiDetailDao         texiDao;
	@Autowired
	private CodeService           codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	@Autowired
	private VTexiCarDao           vTexiCarDao;
	@Autowired
	private VTexiPriceDao		  vTexiPriceDao;


	/**
	 * @Title: showTexi 
	 * @Description: 分页查询租车 
	 * @param @param model
	 * @param @param bean    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void showTexi(ModelMap model, TexiDetailBean bean) {
        /////////////////////////////////// 字典设置start ///////////////////////////////
		//档次
		model.addAttribute("texitype",     this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXITYPE));
        //车型
        model.addAttribute("models",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
        //省
        model.addAttribute("provinces",    this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
        /////////////////////////////////// 字典设置end  ///////////////////////////////
        //获取国内国际港澳台的值
  		String tdlInland = bean.getTdlInland();
  		if(null != tdlInland && !"".equals(tdlInland)){
  		//如果为国内时清空国际的值
  	  		if("02".equals(tdlInland)){
  	  			bean.setTdlExternal(null);
  	  			bean.setTdlForeign(null);
  	  			bean.setTdlForeignCity(null);
  	  		}
  	  		//如果为国际清空国内的值
  	  		if("01".equals(tdlInland)){
  	  			bean.setTdlProvince(null);
  	  			bean.setTdlCity(null);
  	  			bean.setTdlCounty(null);
  	  		}
  		}
        // 分页查询
		List<TexiDetailBean> texiList = texiDao.selectPageTexi(bean, model);
		for (TexiDetailBean texi : texiList) {
			List<VTexiCarBean> resultList = this.vTexiCarDao.selectVTexiCar(texi.getId());
			//车辆信息
			texi.setListVTexiCarBean(resultList);
			
			//遍历房型 返回房间号
			StringBuffer cid = new StringBuffer();
			if(null != resultList && resultList.size()>0){
				for(VTexiCarBean hdb : resultList){
					//cid += hdb.getId()+",";
					cid.append(hdb.getId()).append("_").append(hdb.getNtype()).append(",");
				}
			}
			if(null != cid && cid.length()>0 && (cid.lastIndexOf(",") == cid.length()-1)){
				cid.deleteCharAt(cid.length()-1);
			}
			//b.setAllRoomId(cid.toString());
			texi.setAllTexiIdType(cid.toString());
		}
		// 回传信息
		model.put("texiList", texiList);
	}

	
	
	
	public void setCode(ModelMap model){
		//车型
    	model.addAttribute("models",          this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
    	//车型标准
    	model.addAttribute("vehiclestandard", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.VEHICLESTANDARD));
    	// 档次
    	model.addAttribute("texitype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXITYPE));
    	//汽车可乘坐人数
       model.addAttribute("textzuo",         this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTZUO));
    	// 省市
    	model.addAttribute("provinces",       this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
	}

	
	/**
	 * @Title: selectTexiPrice 
	 * @Description: 根据bean 查询量价
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<VTexiPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月20日 下午7:52:01 
	 * @throws
	 */
	public List<VTexiPriceBean> selectTexiPrice(VTexiPriceBean bean) {
		// id 和 类型
		String idType  = bean.getIdType();
		if(StringUtils.isNotBlank(idType)){
			String[] aidType = idType.split("_");
			VTexiPriceBean param = new VTexiPriceBean();
			param.setTcpId(Integer.parseInt(aidType[0]));
			param.setTcpNtype(aidType[1]);
			return this.vTexiPriceDao.selectTexiPrice(param);
		}
		return null;
	}
	
}