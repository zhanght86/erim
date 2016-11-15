package com.erim.sz.web.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.web.bean.TmSystemRegionBean;
import com.erim.sz.web.dao.HotelDetailDao;
import com.erim.sz.web.dao.HotelRoomDao;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: HotelDetailService 
 * @Description: 酒店
 * @author maoxian
 * @param <TmSystemRegionService>
 * @param <TmSystemRegionService>
 * @date 2015年9月15日 下午12:48:57 
 *
 */
@Service("hoteldetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelDetailService {

	@Autowired
	private HotelDetailDao        hotelDao;
	@Autowired
	private CodeService codeService;
	@Autowired
	HotelRoomDao  hotelroomDao;
	@Autowired 
	private TmSystemRegionService tmSystemRegionService;
	/**
	 * 
	 * @Title: showHotel
	 * @Description: 查询酒店信息
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void showHotel(ModelMap model, HotelDetailBean bean,Integer limit) {
		if(StringUtils.isEmpty(bean.getHnpDate())){
			bean.setHnpDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    	}
		bean.getPageLinkBean().setLimit(10);
		//首页搜索传的值HdlCityVo 国内城市
		if(StringUtils.isNotEmpty(bean.getHdlCityVo())){
			if("香港".equals(bean.getHdlCityVo())){
				bean.setHdlExternal("01");
			}else if("澳门".equals(bean.getHdlCityVo())){
				bean.setHdlExternal("02");
			}else if("台湾".equals(bean.getHdlCityVo())){
				bean.setHdlExternal("03");
			}else{
				TmSystemRegionBean tmBean = new TmSystemRegionBean();
				tmBean.setRegionName(bean.getHdlCityVo());
				TmSystemRegionBean TmSystemRegionBean = tmSystemRegionService.getSystemRegionByRegionName(tmBean);
				bean.setHdlCity(TmSystemRegionBean.getRegionNo());
				bean.setHdlProvince(TmSystemRegionBean.getRegionPid()+"");
			}
		}
		//首页搜索项传的值HdlForeignCity 国际城市
		if(StringUtils.isNotEmpty(bean.getHdlForeignCity())){
			if("香港".equals(bean.getHdlForeignCity())){
				bean.setHdlExternal("01");
				bean.setHdlForeignCity(null);
			}else if("澳门".equals(bean.getHdlForeignCity())){
				bean.setHdlExternal("02");
				bean.setHdlForeignCity(null);
			}else if("台湾".equals(bean.getHdlForeignCity())){
				bean.setHdlExternal("03");
				bean.setHdlForeignCity(null);
			}else{
				bean.setHdlExternal("04");
			}
		}
		// 分页查询
		List<HotelDetailBean> hotelList = hotelDao.selectPageHotel(bean, model,limit);
		
		// 回传信息
		model.put("hotel", bean);
		model.put("hotelList", hotelList);
		model.put("hdlExternal", bean.getHdlExternal());
	}
	/**
	 * 
	 * @Title: selectHotel
	 * @Description: 根据主键查询指定的实体
	 * @param @param id
	 * @param @return    设定文件
	 * @return GuideDetailBean    返回签证实体对象
	 * @throws
	 */
	public void selectHotel(HotelDetailBean bean,ModelMap model){
		if(StringUtils.isEmpty(bean.getHnpDate())){
			bean.setHnpDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		}
		HotelDetailBean detail = hotelDao.selectHotel(bean);
		/*字典转码*/
		//酒店设施
		String hdlFacilities = detail.getHdlFacilities();
		if(hdlFacilities !=null && !"".equals(hdlFacilities)){
			String Str = codeService.getValueByCodeKeys(DictionaryUtil.HOTELFACILITIES, hdlFacilities);
			detail.setHdlFacilities(Str);
		}
		//服务项目
		String hdlService = detail.getHdlService();
		if(hdlService != null && !"".equals(hdlService)){
			String Str = codeService.getValueByCodeKeys(DictionaryUtil.SERVICEITEMS, hdlService);
			detail.setHdlService(Str);
		}
		//酒店特色
		String Characteristic = detail.getHdlCharacteristic();
		if(Characteristic != null && !"".equals(Characteristic)){
			String Str = codeService.getValueByCodeKeys(DictionaryUtil.HOTELFEATURES, Characteristic);
			detail.setHdlCharacteristic(Str);
		}
		//酒店档次
		String hdlLevel = detail.getHdlLevel();
		if(hdlLevel != null && !"".equals(hdlLevel)){
			String Str = codeService.getValueByCodeKeys(DictionaryUtil.STARTLEVEL, hdlLevel);
			detail.setHdlLevel(Str);
		}
		//网络设施
		String hdlNetWork = detail.getHdlNetWork();
		if(hdlNetWork != null && !"".equals(hdlNetWork)){
			String Str = codeService.getValueByCodeKeys(DictionaryUtil.INTERNET, hdlNetWork);
			detail.setHdlNetWork(Str);
		}
		//可接受信用卡
		if(detail.getHdlCreditcard() != null && !"".equals(detail.getHdlCreditcard())){
			String[] hdlCreditcard = detail.getHdlCreditcard().split(",");
			model.addAttribute("hdlCreditcard", hdlCreditcard);
		}
		model.addAttribute("hotel", detail);
	}
	
}