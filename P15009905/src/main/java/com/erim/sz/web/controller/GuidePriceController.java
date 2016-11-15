package com.erim.sz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.GuidePriceBean;
import com.erim.sz.web.service.GuidePriceService;

/**
 * @类名: GuidePriceController
 * @描述: 量价信息实体操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年12月22日 下午4:34:13
 */
@Controller
public class GuidePriceController {

	@Autowired
	private GuidePriceService guidePriceService;
	
	/**
	 * @描述: 修改档期后，刷新页面，没有初始化页面参数
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 上午11:26:26
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/guide/price/list")
	public String selectPriceList(ModelMap map, GuidePriceBean bean) {
		
		// 执行查询档期管理信息
		guidePriceService.selectPriceList(map);
		
		return "index";
	}
	
	/**
	 * @描述: 切换日期
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 上午11:48:57
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/guide/price/updateDate")
	public String updateDate(ModelMap map, GuidePriceBean bean) {
		
		String portal = bean.getPortal();
		
		if ("01".equals(portal)) {
			// 时间向前选择
			guidePriceService.forwardDate(map, bean);
		} 
		if ("02".equals(portal)) {
			// 时间向后选择
			guidePriceService.backwardsDate(map, bean);
		}
		return "index";
	}
	
	/**
	 * @描述: 切换导游当前服务类型
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 下午1:52:33
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/guide/price/updateService")
	public String updateService(ModelMap map, GuidePriceBean bean) {
		
		// 执行更改导游当前选择服务类型，并获取数据
		guidePriceService.updateServiceType(map, bean);
		return "index";
	}
	
	/**
	 * @描述: 更改导游档期信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月23日 上午10:29:59
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/guide/price/updateIsOpen")
	public Integer updateIsOpen(ModelMap map, GuidePriceBean bean) {
		
		return guidePriceService.updateIsOpen(map, bean);
	}
	
}
