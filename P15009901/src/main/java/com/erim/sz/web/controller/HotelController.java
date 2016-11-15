package com.erim.sz.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.common.bean.HotelPriceBean;
import com.erim.sz.web.service.HotelCarteriaService;
import com.erim.sz.web.service.HotelDetailService;
import com.erim.sz.web.service.HotelMeetingService;
import com.erim.sz.web.service.HotelParkService;
import com.erim.sz.web.service.HotelPriceService;
import com.erim.sz.web.service.HotelRoomService;
import com.erim.sz.web.service.TmSystemRegionService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: HotelController 
 * @Description: 酒店管理
 * @author maoxian
 * @date 2015年9月15日 下午1:39:23 
 *
 */
@Controller
public class HotelController {
	
	@Autowired
	private HotelDetailService    hotelDetailService;
	@Autowired
	private HotelRoomService  	  hotelRoomService;
	@Autowired
	private HotelPriceService	  hotelPriceService;
	@Autowired
	private HotelMeetingService   hotelmeetService;
	@Autowired
	private HotelParkService      hotelparkService;
	@Autowired
	private HotelCarteriaService  hotelcarteriaService;
	@Autowired
	private CodeService		   	  codeService;
	@Autowired 
	private TmSystemRegionService tmSystemRegionService;
	/**
	 * 
	 * @Title: jiudian 
	 * @Description: 酒店详情
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/hotel/jiudian")
	public String jiudian(ModelMap model,@ModelAttribute("hotel") HotelDetailBean bean) {
		
		model.addAttribute("hdlExternal", bean.getHdlExternal());
		this.hotelDetailService.showHotel(model, bean, 10);
		/*酒店列表页搜索项*/
		// 星级
		model.addAttribute("startlevel",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STARTLEVEL));
		// 酒店特色
		model.addAttribute("hotelfeatures",    this.codeService.getSystemCodeByCodeNo(DictionaryUtil.HOTELFEATURES));
		// 酒店设施
	    model.addAttribute("hotelfacilities",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.HOTELFACILITIES));
	    // 酒店服务
	    model.addAttribute("serviceitems",     this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SERVICEITEMS));
	    // 省份
	    model.addAttribute("provinces",        this.tmSystemRegionService.getSystemCodeListForProvince());
		return "/hotel/jiudian";
	}
	
	
	/**
	 * @Title: jiudianxiang 
	 * @Description: 酒店详情
	 * @param @param model
	 * @param @param id
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
//	@RequestMapping(value = "/{cpyno}/hotel/jiudianxiang/{id}/{price}")
//	public String jiudianxiang(ModelMap model,@PathVariable("id") Integer id,@PathVariable("price") String price) {
//		//根据id查询酒店信息
//		this.hotelDetailService.selectHotel(id,model);
//		//根据酒店id差查询房型信息
//		this.hotelRoomService.selectList(id, model);
//		//根据酒店id查询会议室信息
//		this.hotelmeetService.selectList(id, model);
//		//根据酒店id查询停车场信息
//		this.hotelparkService.selectList(id, model);
//		//根据酒店id查询餐厅信息
//		this.hotelcarteriaService.selectList(id, model);
//		return "/hotel/jiudianxiang";
//	}
	
	/**
	 * @Title: jiudianxiang 
	 * @Description: 酒店详情
	 * @param @param model
	 * @param @param id
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/hotel/jiudianxiang/{id}")
	public String jiudianxiangview(ModelMap model,@PathVariable("id") Integer id,HotelDetailBean bean){
		if(StringUtils.isEmpty(bean.getHnpDate())){
			bean.setHnpDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		}
		//08已调用此链接地址 重新赋值id
		bean.setId(id);
		//根据id查询酒店信息
		this.hotelDetailService.selectHotel(bean,model);
		//根据酒店id差查询房型信息
		HotelPriceBean priceBean = new HotelPriceBean();
		priceBean.setHdlId(id);
		priceBean.setHnpDate(bean.getHnpDate());
		this.hotelRoomService.selectList(priceBean, model);
		//根据酒店id查询会议室信息
		this.hotelmeetService.selectList(id, model);
		//根据酒店id查询停车场信息
		this.hotelparkService.selectList(id, model);
		//根据酒店id查询餐厅信息
		this.hotelcarteriaService.selectList(id, model);
		return "/hotel/jiudianxiang";
	}
	
	/**
	 * @描述: 酒店量价项
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月26日 下午4:34:44
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping("/{cpyno}/hotel/jiudianxiang/liangjiaxiang")
	public String liangjiaxiang(ModelMap map, HotelPriceBean bean) {
		hotelPriceService.getHotelPriceList(map, bean);
		return "/hotel/price";
	}
	
	/**
	 * @描述: 酒店量价项时间选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月26日 下午10:55:18
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/{cpyno}/hotel/jiudianxiang/liangjiaxiangdate")
	public String liangjiaxiangriqi(ModelMap map, HotelPriceBean bean) {
		
		String portal = bean.getPortal();
		
		if ("01".equals(portal)) {
			// 时间向前选择
			hotelPriceService.forward(map, bean);
		} else if ("02".equals(portal)) {
			// 时间向后选择
			hotelPriceService.backwards(map, bean);
		}
		return "/hotel/price";
	}
}