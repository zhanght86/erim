package com.erim.sz.sametown.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.sametown.dao.HotelDetailDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: HotelDetailService
 * @描述: 酒店接口
 * @作者: 李庆
 * @创建时间: 2015年10月25日 下午5:08:24
 *
 */
@Service("hotelDetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelDetailService {

	@Autowired
	private HotelDetailDao 		  hotelDetailDao;
	@Autowired
	private CodeService 		  codeService;
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
	public void showHotel(ModelMap model, HotelDetailBean bean) {
		
		/////////////////////////////////// 字典设置start ///////////////////////////////
		// 星级
		model.addAttribute("startlevel",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STARTLEVEL));
		// 省
		model.addAttribute("provinces",        this.tmSystemRegionService.getSystemCodeByCodeNo(0));
		/////////////////////////////////// 字典设置end  ///////////////////////////////
		
		bean.getPageLinkBean().setLimit(10);

		// 分页查询
		List<HotelDetailBean> hotelList = hotelDetailDao.selectPageHotelList(bean, model);
		
		for (int i = 0; i < hotelList.size(); i++) {
			HotelDetailBean model1 = hotelList.get(i);
			// 所在城市
			String hdlCity = model1.getHdlCity();
			if (hdlCity != null && !"".equals(hdlCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(hdlCity));
				model1.setHdlCity(str);
			}
			// 酒店档次
			String hdlLevel = model1.getHdlLevel();
			if (hdlLevel != null && !"".equals(hdlLevel)) {
				String str = codeService.getValueByCodeNoAndKey(DictionaryUtil.STARTLEVEL, hdlLevel);
				model1.setHdlLevel(str);
			}
			
		}
		// 回传信息
		model.put("hotelList", hotelList);
	}
	/**
	 * 
	 * @方法名: setCode
	 * @描述: 放置字典
	 * @作者: 李庆
	 * @创建时间: 2015年10月27日 下午2:21:15 
	 * @param model
	 *
	 */
	public void setCode(ModelMap model) {
		// 星级/酒店档次
		model.addAttribute("startlevel",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STARTLEVEL));
		// 特色
		model.addAttribute("hotelfeatures",    this.codeService.getSystemCodeByCodeNo(DictionaryUtil.HOTELFEATURES));
		// 设施
		model.addAttribute("hotelfacilities",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.HOTELFACILITIES));
		// 休闲娱乐
		model.addAttribute("recreation",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.RECREATION));
		// 餐饮设施
		model.addAttribute("diningfacilities", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.DININGFACILITIES));
		// 信用卡
		model.addAttribute("credit",           this.codeService.getSystemCodeByCodeNo(DictionaryUtil.CREDIT));
		// 服务项目
		model.addAttribute("serviceitems",     this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SERVICEITEMS));
		
		// 省
		model.addAttribute("provinces",        this.tmSystemRegionService.getSystemCodeByCodeNo(0));
	}
}
