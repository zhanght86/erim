package com.erim.sz.texi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.TexiSendPriceBean;
import com.erim.sz.texi.service.TexiSendPriceService;

/**
 * @类名: SendPriceController
 * @描述: 固定接送线路信息实体操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年10月13日 下午2:38:42
 */
@Controller
public class TexiSendPriceController {

	@Autowired
	private TexiSendPriceService texiSendPriceService;
	
	/**
	 * @方法名: showSendPricePage
	 * @描述: 打开固定接送线路信息量价管理页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午2:40:39 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/texi/send/sendPricePage")
	public String showSendPricePage(ModelMap map, TexiSendPriceBean bean) {
		
		String portal = bean.getDicPortal();
		// 第一入口
		if ("01".equals(portal)) {
			// 获取页面参数
			texiSendPriceService.showSendPricePortal(map, bean);
			
			// 获取数据
			bean = new TexiSendPriceBean();
			texiSendPriceService.selectSendPriceList(map, bean);
		}
		// 时间向前选择
		if ("02".equals(portal)) {
			texiSendPriceService.showListForward(map, bean);
			
			// 获取数据
			bean = new TexiSendPriceBean();
			texiSendPriceService.selectSendPriceList(map, bean);
		}
		// 时间向后选择
		if ("03".equals(portal)) {
			texiSendPriceService.showListBackwards(map, bean);
			
			// 获取数据
			bean = new TexiSendPriceBean();
			texiSendPriceService.selectSendPriceList(map, bean);
		}
		// 刷新
		if ("04".equals(portal)) {
			texiSendPriceService.refresh(map, bean);
			
			// 获取数据
			bean = new TexiSendPriceBean();
			texiSendPriceService.selectSendPriceList(map, bean);
		}
		
		return "/texi/send/price";
	}
	
	/**
	 * @方法名: insertSendPrice
	 * @描述: 新增量价管理
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午7:55:41 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/texi/send/insertPrice")
	public Integer insertSendPrice(ModelMap map, TexiSendPriceBean bean) {
		return texiSendPriceService.insertPrice(map, bean);
	}
	
	/**
	 * @方法名: updateIsOpen
	 * @描述: 开关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月14日 上午11:31:28 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/texi/send/updateIsOpen")
	public String updateIsOpen(ModelMap map, TexiSendPriceBean bean) {
		
		// 开关房
		texiSendPriceService.updateIsOpen(bean);
		// 页面参数
		texiSendPriceService.refresh(map, bean);
		// 获取数据
		bean = new TexiSendPriceBean();
		texiSendPriceService.selectSendPriceList(map, bean);
		
		return "/texi/send/price";
	}
	
	/**
	 * @方法名: updatePrice
	 * @描述: 修改房量
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月14日 上午11:32:38 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/texi/send/updatePrice")
	public Integer updatePrice(ModelMap map, TexiSendPriceBean bean) {
		
		return texiSendPriceService.updatePrice(bean);
	}
	
	/**
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月14日 上午11:41:24 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/texi/send/updateBatchIsOpen")
	public String updateBatchIsOpen(ModelMap map, TexiSendPriceBean bean) {
		// 批量关房
		texiSendPriceService.updateBatchIsOpen(bean, map);
		// 页面参数
		texiSendPriceService.refresh(map, bean);
		// 获取数据
		bean = new TexiSendPriceBean();
		texiSendPriceService.selectSendPriceList(map, bean);

		return "/texi/send/price";
	}
}
