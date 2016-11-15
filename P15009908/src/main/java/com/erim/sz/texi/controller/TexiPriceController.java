package com.erim.sz.texi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.texi.service.TexiPriceService;

/**
 * @描述: 同业资源租车量价信息实体操作控制层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月24日 上午11:10:03
 */
@Controller
public class TexiPriceController {

	@Autowired
	private TexiPriceService texiPriceService;
	
	/**
	 * @描述: 同业资源租车量价列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月24日 上午11:40:46
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/texi/price/showPage")
	public String showSametownPricePage(ModelMap map, TexiDetailBean bean) {
		
		String portal = bean.getPortal();
		// 初始化
		if ("01".equals(portal)) {
			texiPriceService.showSametownPricePage(map, bean);
		}
		// 时间向前选择
		if ("02".equals(portal)) {
			texiPriceService.showListForward(map, bean);
		}
		// 时间向后选择
		if ("03".equals(portal)) {
			texiPriceService.showListBackwards(map, bean);
		}
		// 更改租车使用类型
		if ("04".equals(portal)) {
			texiPriceService.texiApplyType(map, bean);
		}
		// 更改固定接送ID
		if ("05".equals(portal)) {
			texiPriceService.texiSend(map, bean);
		}
		// 更改包车类型
		if ("06".equals(portal)) {
			texiPriceService.texiCar(map, bean);
		}
		// 更改自驾类型
		if ("07".equals(portal)) {
			texiPriceService.texiDrive(map, bean);
		}
		bean = new TexiDetailBean();
		// 执行查询
		texiPriceService.selectPriceList(map, bean);
		return "/texi/sametown/price";
	}
	
	/**
	 * @描述: 查询该租车是否有使用信息 
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月24日 上午11:42:29
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/texi/price/getIsApply")
	public Integer getTexiIsApply(ModelMap map, TexiDetailBean bean) {
		
		return texiPriceService.getTexiTypeNum(map, bean);
	}
}
