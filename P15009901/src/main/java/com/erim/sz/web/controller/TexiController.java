/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserController.java : 2013-06-30
 */
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

import com.erim.sz.common.bean.TexiCarBean;
import com.erim.sz.common.bean.TexiCarPriceBean;
import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.common.bean.TexiDriveBean;
import com.erim.sz.common.bean.TexiDrivePriceBean;
import com.erim.sz.web.bean.TmSystemRegionBean;
import com.erim.sz.web.service.TexiCarService;
import com.erim.sz.web.service.TexiDetailService;
import com.erim.sz.web.service.TexiDriveService;
import com.erim.sz.web.service.TexiSendPriceService;
import com.erim.sz.web.service.TexiSendService;
import com.erim.sz.web.service.TmSystemRegionService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: TexiDetailController 
 * @Description: 车辆信息
 * @author maoxian
 * @date 2015年9月12日 下午5:35:03 
 *
 */
@Controller
public class TexiController {
	@Autowired
	private TexiDetailService texiService;
	@Autowired
	private CodeService		   codeService;
	@Autowired
	private TexiDriveService   texiDriveService;
	@Autowired
	private TexiCarService   texiCarService;
	@Autowired
	private TexiSendService   texiSendService;
	@Autowired
	private TexiSendPriceService   texiSendPriceService;
	@Autowired 
	private TmSystemRegionService tmSystemRegionService;
	/**
	 * @Title: view 
	 * @Description: 租车
	 * @param @param model
	 * @param @param id
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/texi/car")
	public String car(ModelMap model,@ModelAttribute("text") TexiDetailBean bean,@ModelAttribute("searchType")String searchType) {
//		//自驾游搜索条件 用车方式
//		if(StringUtils.isNotEmpty(bean.getZjlType())){
//			//01：全天 02：半天
//			if("01".equals(bean.getZjlType())){
//				//取车地址
//				String city = bean.getZjlCity();
//				if(StringUtils.isNotEmpty(city)){
//					bean.setZjlTakeAddress(city);
//					bean.setZjlHfTakeAddress("");
//				}
//				//取车地点
//				if(StringUtils.isNotEmpty(bean.getZjlHfTakePlace())){
//					bean.setZjlTakePlaceVo(bean.getZjlHfTakePlace());
//					bean.setZjlTakePlace(bean.getZjlHfTakePlace());
//					bean.setZjlHfTakePlace("");
//					
//				}
//				//还车地点
//				if(StringUtils.isNotEmpty(bean.getZjlHfBackPlace())){
//					bean.setZjlBackPlaceVo(bean.getZjlHfBackPlace());
//					bean.setZjlBackPlace(bean.getZjlHfBackPlace());
//					bean.setZjlHfBackPlace("");
//					
//				}
//			}else{
//				//取车地址
//				String city = bean.getZjlCity();
//				if(StringUtils.isNotEmpty(city)){
//					bean.setZjlTakeAddress("");
//					bean.setZjlHfTakeAddress(city);
//				}
//				//取车地点
//				if(StringUtils.isNotEmpty(bean.getZjlHfTakePlace())){
//					bean.setZjlTakePlaceVo(bean.getZjlHfTakePlace());
//					bean.setZjlTakePlace("");
//				}
//				//还车地点
//				if(StringUtils.isNotEmpty(bean.getZjlHfBackPlace())){
//					bean.setZjlBackPlaceVo(bean.getZjlHfBackPlace());
//					bean.setZjlBackPlace("");
//				}
//				
//			}
//		}else{
//			//取车地址 包括全天和半天
//			if(StringUtils.isNotEmpty(bean.getZjlCity())){
//				bean.setZjlTakeAddress(bean.getZjlCity());
//				bean.setZjlHfTakeAddress(bean.getZjlCity());
//			}
//			//取车地点 02：固定地点:01：送车上门 （包括全天和半天的）
//			if(StringUtils.isNotEmpty(bean.getZjlHfTakePlace())){
//				bean.setZjlTakePlace(bean.getZjlHfTakePlace());
//				bean.setZjlTakePlaceVo(bean.getZjlHfTakePlace());
//			}
//			//还车地点 02：固定地点 01：上门取车（包括全天和半天的）
//			if(StringUtils.isNotEmpty(bean.getZjlHfBackPlace())){
//				bean.setZjlBackPlace(bean.getZjlHfBackPlace());
//				bean.setZjlBackPlaceVo(bean.getZjlHfBackPlace());
//			}
//		}
//
//		if(StringUtils.isEmpty(searchType) || searchType.equals("1")){
//			if(StringUtils.isEmpty(bean.getTspDate())){
//				Date date = new Date();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				String dateStr = sdf.format(date);
//				bean.setTspDate(dateStr);
//			}
//			bean.setSendType("01");
//			this.texiService.showTexiSend(model, bean, 10);
//			
//		}else if(searchType.equals("2")){
//			if(StringUtils.isEmpty(bean.getTspDate())){
//				Date date = new Date();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				String dateStr = sdf.format(date);
//				bean.setTspDate(dateStr);
//			}
//			bean.setSendType("02");
//			this.texiService.showTexiSend(model, bean, 10);
//			
//		}else if(searchType.equals("3")){
//			if(StringUtils.isEmpty(bean.getTspDate())){
//				Date date = new Date();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				String dateStr = sdf.format(date);
//				bean.setTspDate(dateStr);
//			}
//			bean.setSendType("03");
//			this.texiService.showTexiSend(model, bean, 10);
//			
//		}else if(searchType.equals("4")){
//			if(StringUtils.isEmpty(bean.getTspDate())){
//				Date date = new Date();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				String dateStr = sdf.format(date);
//				bean.setTspDate(dateStr);
//			}
//			bean.setSendType("04");
//			this.texiService.showTexiSend(model, bean, 10);
//			
//		}else if(searchType.equals("7")){
//			if(StringUtils.isEmpty(bean.getTspDate())){
//				Date date = new Date();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				String dateStr = sdf.format(date);
//				bean.setTspDate(dateStr);
//			}
//			bean.setSendType("05");
//			this.texiService.showTexiSend(model, bean, 10);
//			
//		}else if(searchType.equals("5")){
//			if(StringUtils.isEmpty(bean.getTcpDate1())){
//				Date date = new Date();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				String dateStr = sdf.format(date);
//				bean.setTcpDate1(dateStr);
//			}
//			this.texiService.showTexiCar(model, bean, 10);
//		}else if(searchType.equals("6")){
//			if(StringUtils.isEmpty(bean.getTdpDate1())){
//				Date date = new Date();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				String dateStr = sdf.format(date);
//				bean.setTdpDate1(dateStr);
//			}
//			this.texiService.showTexiDrive(model, bean, 10);
//		}
//		/*租车列表页搜索项*/
//		//车型
//		model.addAttribute("tdltype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
//		//乘坐人数
//		model.addAttribute("tdlnum",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTZUO));
//		//车辆档次
//		model.addAttribute("texitype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXITYPE));
//		return "/texi/car1";
		if(StringUtils.isEmpty(bean.getTspDate())){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			bean.setTspDate(dateStr);
		}
		//send1
		bean.setSendType("01");
		//国际国内tdlInland 默认国内
		if(StringUtils.isEmpty(bean.getTdlInland())){
			bean.setTdlInland("02");
		}
		this.texiService.showTexiSend(model, bean, 10);
		/*租车列表页搜索项*/
		//车型
		model.addAttribute("tdltype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
		//乘坐人数
		model.addAttribute("tdlnum",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTZUO));
		//车辆档次
		model.addAttribute("texitype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXITYPE));
		return "/texi/car1";
	}
	@RequestMapping(value = "/{cpyno}/texi/car1")
	public String car1(ModelMap model,@ModelAttribute("text") TexiDetailBean bean,@ModelAttribute("searchType")String searchType) {
		if(StringUtils.isEmpty(bean.getTspDate())){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			bean.setTspDate(dateStr);
		}
		//send1
		bean.setSendType("01");
		//国际国内tdlInland 默认国内
		if(StringUtils.isEmpty(bean.getTdlInland())){
			bean.setTdlInland("02");
		}
		this.texiService.showTexiSend(model, bean, 10);
		/*租车列表页搜索项*/
		//车型
		model.addAttribute("tdltype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
		//乘坐人数
		model.addAttribute("tdlnum",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTZUO));
		//车辆档次
		model.addAttribute("texitype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXITYPE));
		return "/texi/car1";
	}
	@RequestMapping(value = "/{cpyno}/texi/car2")
	public String car2(ModelMap model,@ModelAttribute("text") TexiDetailBean bean,@ModelAttribute("searchType")String searchType) {
		if(StringUtils.isEmpty(bean.getTspDate())){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			bean.setTspDate(dateStr);
		}
		//send2
		bean.setSendType("02");
		//国际国内tdlInland 默认国内
		if(StringUtils.isEmpty(bean.getTdlInland())){
			bean.setTdlInland("02");
		}
		this.texiService.showTexiSend(model, bean, 10);
		/*租车列表页搜索项*/
		//车型
		model.addAttribute("tdltype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
		//乘坐人数
		model.addAttribute("tdlnum",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTZUO));
		//车辆档次
		model.addAttribute("texitype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXITYPE));
		return "/texi/car2";
	}
	@RequestMapping(value = "/{cpyno}/texi/car3")
	public String car3(ModelMap model,@ModelAttribute("text") TexiDetailBean bean,@ModelAttribute("searchType")String searchType) {
		if(StringUtils.isEmpty(bean.getTspDate())){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			bean.setTspDate(dateStr);
		}
		//send3
		bean.setSendType("03");
		//国际国内tdlInland 默认国内
		if(StringUtils.isEmpty(bean.getTdlInland())){
			bean.setTdlInland("02");
		}
		this.texiService.showTexiSend(model, bean, 10);
		/*租车列表页搜索项*/
		//车型
		model.addAttribute("tdltype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
		//乘坐人数
		model.addAttribute("tdlnum",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTZUO));
		//车辆档次
		model.addAttribute("texitype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXITYPE));
		return "/texi/car3";
	}
	@RequestMapping(value = "/{cpyno}/texi/car4")
	public String car4(ModelMap model,@ModelAttribute("text") TexiDetailBean bean,@ModelAttribute("searchType")String searchType) {
		if(StringUtils.isEmpty(bean.getTspDate())){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			bean.setTspDate(dateStr);
		}
		//send4
		bean.setSendType("04");
		//国际国内tdlInland 默认国内
		if(StringUtils.isEmpty(bean.getTdlInland())){
			bean.setTdlInland("02");
		}
		this.texiService.showTexiSend(model, bean, 10);
		/*租车列表页搜索项*/
		//车型
		model.addAttribute("tdltype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
		//乘坐人数
		model.addAttribute("tdlnum",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTZUO));
		//车辆档次
		model.addAttribute("texitype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXITYPE));
		return "/texi/car4";
	}
	@RequestMapping(value = "/{cpyno}/texi/car7")
	public String car7(ModelMap model,@ModelAttribute("text") TexiDetailBean bean,@ModelAttribute("searchType")String searchType) {
		if(StringUtils.isEmpty(bean.getTspDate())){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			bean.setTspDate(dateStr);
		}
		//send5
		bean.setSendType("05");
		//国际国内tdlInland 默认国内
		if(StringUtils.isEmpty(bean.getTdlInland())){
			bean.setTdlInland("02");
		}
		this.texiService.showTexiSend(model, bean, 10);
		/*租车列表页搜索项*/
		//车型
		model.addAttribute("tdltype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
		//乘坐人数
		model.addAttribute("tdlnum",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTZUO));
		//车辆档次
		model.addAttribute("texitype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXITYPE));
		return "/texi/car7";
	}
	@RequestMapping(value = "/{cpyno}/texi/car5")
	public String car5(ModelMap model,@ModelAttribute("text") TexiDetailBean bean,@ModelAttribute("searchType")String searchType) {
		if(StringUtils.isEmpty(bean.getTcpDate1())){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			bean.setTcpDate1(dateStr);
		}
		//包车类型
		if(StringUtils.isEmpty(bean.getBclType())){
			bean.setBclType("01");
		}
		//国际国内tdlInland 默认国内
		if(StringUtils.isEmpty(bean.getTdlInland())){
			bean.setTdlInland("02");
		}
		//选择国内 将国际城市字段清除
		if(StringUtils.isEmpty(bean.getTdlInland()) || bean.getTdlInland().equals("02")){
			//城市转码
			if(StringUtils.isNotEmpty(bean.getTdlCityVo())){
				TmSystemRegionBean tmBean = new TmSystemRegionBean();
				tmBean.setRegionName(bean.getTdlCityVo());
				TmSystemRegionBean TmSystemRegionBean = tmSystemRegionService.getSystemRegionByRegionName(tmBean);
				if(TmSystemRegionBean != null){
					bean.setTdlCity(TmSystemRegionBean.getRegionNo());
				}else{
					bean.setTdlCity(bean.getTdlCityVo());
				}
			}
			//将国际字段清除
			bean.setTdlExternal("");
			bean.setTdlForeignCity("");
		}
		//选择国际时 出发城市设置 页面传参为tdlForeignCity
		if(StringUtils.isNotEmpty(bean.getTdlInland()) && bean.getTdlInland().equals("01")){
			// 将国内城市字段清除
			bean.setTdlCity("");
			if(StringUtils.isNotEmpty(bean.getTdlForeignCityVo())){
				if("香港".equals(bean.getTdlForeignCityVo())){
					bean.setTdlExternal("01");
					bean.setTdlForeignCity("");
				}else if("澳门".equals(bean.getTdlForeignCityVo())){
					bean.setTdlExternal("02");
					bean.setTdlForeignCity("");
				}else if("台湾".equals(bean.getTdlForeignCityVo())){
					bean.setTdlExternal("03");
					bean.setTdlForeignCity("");
				}else{
					bean.setTdlForeignCity(bean.getTdlForeignCityVo());
				}
			}
		}
		this.texiService.showTexiCar(model, bean, 10);
		/*租车列表页搜索项*/
		//车型
		model.addAttribute("tdltype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
		//乘坐人数
		model.addAttribute("tdlnum",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTZUO));
		//车辆档次
		model.addAttribute("texitype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXITYPE));
		return "/texi/car5";
	}
	@RequestMapping(value = "/{cpyno}/texi/car6")
	public String car6(ModelMap model,@ModelAttribute("text") TexiDetailBean bean,@ModelAttribute("searchType")String searchType) {
		if(StringUtils.isEmpty(bean.getTdpDate1())){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			bean.setTdpDate1(dateStr);
		}
		//自驾
		if(StringUtils.isEmpty(bean.getZjlType())){
			bean.setZjlType("01");
		}
		//国际国内tdlInland 默认国内
		if(StringUtils.isEmpty(bean.getTdlInland())){
			bean.setTdlInland("02");
		}
		//选择国内 将国际城市字段清除
		if(StringUtils.isEmpty(bean.getTdlInland()) || bean.getTdlInland().equals("02")){
			//城市转码
			if(StringUtils.isNotEmpty(bean.getTdlCityVo())){
				TmSystemRegionBean tmBean = new TmSystemRegionBean();
				tmBean.setRegionName(bean.getTdlCityVo());
				TmSystemRegionBean TmSystemRegionBean = tmSystemRegionService.getSystemRegionByRegionName(tmBean);
				if(TmSystemRegionBean != null){
					bean.setTdlCity(TmSystemRegionBean.getRegionNo());
				}else{
					bean.setTdlCity(bean.getTdlCityVo());
				}
			}
			//将国际字段清除
			bean.setTdlExternal("");
			bean.setTdlForeignCity("");
		}
		//选择国际时 出发城市设置 页面传参为tdlForeignCity
		if(StringUtils.isNotEmpty(bean.getTdlInland()) && bean.getTdlInland().equals("01")){
			// 将国内城市字段清除
			bean.setTdlCity("");
			if(StringUtils.isNotEmpty(bean.getTdlForeignCityVo())){
				if("香港".equals(bean.getTdlForeignCityVo())){
					bean.setTdlExternal("01");
					bean.setTdlForeignCity("");
				}else if("澳门".equals(bean.getTdlForeignCityVo())){
					bean.setTdlExternal("02");
					bean.setTdlForeignCity("");
				}else if("台湾".equals(bean.getTdlForeignCityVo())){
					bean.setTdlExternal("03");
					bean.setTdlForeignCity("");
				}else{
					bean.setTdlForeignCity(bean.getTdlForeignCityVo());
				}
			}
		}
		
		this.texiService.showTexiDrive(model, bean, 10);
		/*租车列表页搜索项*/
		//车型
		model.addAttribute("tdltype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
		//乘坐人数
		model.addAttribute("tdlnum",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTZUO));
		//车辆档次
		model.addAttribute("texitype",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXITYPE));
		return "/texi/car6";
	}
	
	/**
	 * @Title: view 
	 * @Description: 租车
	 * @param @param model
	 * @param @param id
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/texi/carxiang/{id}/{tdpDate}")
	public String carxiang(ModelMap model,@PathVariable("id") Integer id,@PathVariable("tdpDate") String tdpDate) {
		//根据id查询车辆信息
		this.texiService.selectTexiDetialById(model, id);
		//自驾查看
		TexiDriveBean texiDriveBean = this.texiDriveService.selectTexiDrive(model, id);
		model.addAttribute("texiDrive",texiDriveBean);
		if(texiDriveBean != null){
			TexiDrivePriceBean bean = new TexiDrivePriceBean();
			bean.setZjlId(texiDriveBean.getId());
			bean.setTdpDate(tdpDate);
			//自驾价格查看 全天
			bean.setZjlType("01");
			TexiDrivePriceBean texiDrivePrice1 = this.texiDriveService.selectTexiDrivePriceBean(model,bean);
			//自驾价格查看 半天
			bean.setZjlType("02");
			TexiDrivePriceBean texiDrivePrice2 = this.texiDriveService.selectTexiDrivePriceBean(model,bean);
			model.addAttribute("texiDrivePrice1",texiDrivePrice1);
			model.addAttribute("texiDrivePrice2",texiDrivePrice2);
		}
		//固定接送
		this.texiSendService.selectSendById(model, id);
		return "/texi/carxiang";
	}

	/**
	 * @Title: carview 
	 * @Description: 查看车辆信息
	 * @param @param model
	 * @param @param id
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月12日 下午11:08:27 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/texi/carxiang/{id}")
	public String carview(ModelMap model,@PathVariable("id") Integer id){
		return this.carxiang(model, id, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	}
	
	/**
	 * 
	 * @方法名: texicar
	 * @描述: 包车查看
	 * @作者: 王赛
	 * @创建时间: 2015年11月27日 下午1:39:38 
	 * @param model
	 * @param id
	 * @return
	 *
	 */
	@RequestMapping(value = "/{cpyno}/texi/texicar/{id}/{tcpDate}")
	public String texicar(ModelMap model,@PathVariable("id") Integer id,@PathVariable("tcpDate") String tcpDate) {
		this.texiService.selectTexiDetialById(model, id);
		TexiCarBean texiCarBean = texiCarService.selectTexiCar(model, id);
		model.addAttribute("texicar",texiCarBean);
		
		TexiCarPriceBean bean = new TexiCarPriceBean();
		if(texiCarBean != null){
			bean.setBclId(texiCarBean.getId());
			bean.setTcpDate(tcpDate);
			//包车价格查看 全天
			bean.setBclType("01");
			TexiCarPriceBean texiCarPrice1 = this.texiCarService.selectTexiCarPriceBean(model,bean);
			//包车价格查看 半天
			bean.setBclType("02");
			TexiCarPriceBean texiCarPrice2 = this.texiCarService.selectTexiCarPriceBean(model,bean);
			model.addAttribute("texiCarPrice1",texiCarPrice1);
			model.addAttribute("texiCarPrice2",texiCarPrice2);
		}
		return "/texi/texicar";
	}
	
	/**
	 * @Title: carorder 
	 * @Description: 订单详情 
	 * @param @param model
	 * @param @param id
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/texi/carorder/{id}")
	public String carorder(ModelMap model,@PathVariable("id") Integer id){
		return "/texi/carorder";
	}
	@RequestMapping(value = "/{cpyno}/texi/sendprice")
	public String sendprice(ModelMap model,Integer id){
		texiSendPriceService.selectSendById(model, id);
		return "/texi/sendprice";
	}
	@RequestMapping(value = "/{cpyno}/texi/sendprice2")
	public String sendprice2(ModelMap model,Integer id){
		texiSendPriceService.selectSendById(model, id);
		return "/texi/sendprice2";
	}
	@RequestMapping(value = "/{cpyno}/texi/sendprice3")
	public String sendprice3(ModelMap model,Integer id){
		texiSendPriceService.selectSendById(model, id);
		return "/texi/sendprice3";
	}
	@RequestMapping(value = "/{cpyno}/texi/sendprice4")
	public String sendprice4(ModelMap model,Integer id){
		texiSendPriceService.selectSendById(model, id);
		return "/texi/sendprice4";
	}
	@RequestMapping(value = "/{cpyno}/texi/sendprice7")
	public String sendprice7(ModelMap model,Integer id){
		texiSendPriceService.selectSendById(model, id);
		return "/texi/sendprice7";
	}
}