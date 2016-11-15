package com.erim.sz.texi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.TexiDrivePriceBean;
import com.erim.sz.texi.service.TexiDrivePriceService;

/**
 * 
 * @类名: TexiDrivePriceController
 * @描述: 租车管理包车量价管理信息实体操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年10月15日 上午10:14:37
 *
 */
@Controller
public class TexiDrivePriceController {

	@Autowired
	private TexiDrivePriceService texiDrivePriceService;
	
	/**
	 * 
	 * @方法名: showDrivePricePage
	 * @描述: 包车量价管理信息列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 上午10:16:27 
	 * @param map
	 * @return
	 *
	 */
	@RequestMapping("/texi/drive/drivePricePage")
	public String showDrivePricePage(ModelMap map, TexiDrivePriceBean bean) {
		
		String portal = bean.getDicPortal();
		// 第一入口
		if ("01".equals(portal)) {
			// 获取页面参数
			texiDrivePriceService.showDrivePricePortal(map, bean);
			
			// 获取数据
			bean = new TexiDrivePriceBean();
			texiDrivePriceService.selectDrivePirceList(map, bean);
		}
		// 时间向前选择
		if ("02".equals(portal)) {
			texiDrivePriceService.showListForward(map, bean);
			
			// 获取数据
			bean = new TexiDrivePriceBean();
			texiDrivePriceService.selectDrivePirceList(map, bean);
		}
		// 时间向后选择
		if ("03".equals(portal)) {
			texiDrivePriceService.showListBackwards(map, bean);
			
			// 获取数据
			bean = new TexiDrivePriceBean();
			texiDrivePriceService.selectDrivePirceList(map, bean);
		}
		// 选择包车类型
		if ("04".equals(portal)) {
			texiDrivePriceService.showListDriveType(map, bean);
			
			// 数据
			bean = new TexiDrivePriceBean();
			texiDrivePriceService.selectDrivePirceList(map, bean);
		}
		// 刷新
		if ("05".equals(portal)) {
			texiDrivePriceService.refresh(map, bean);
			
			// 获取数据
			bean = new TexiDrivePriceBean();
			texiDrivePriceService.selectDrivePirceList(map, bean);
		}
		
		// 获取车辆名称
		texiDrivePriceService.getTdlName(map);
		
		return "/texi/drive/drivePrice";
	}
	
	/**
	 * @方法名: insertDrivePrice
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午5:45:24 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/texi/drive/insertPrice")
	public Integer insertDrivePrice(ModelMap map, TexiDrivePriceBean bean) {
		return texiDrivePriceService.insertPrice(map, bean);
	}
	
	/**
	 * 
	 * @方法名: updateIsOpen
	 * @描述: 修改上架状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午5:47:28 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@RequestMapping("/texi/drive/updateIsOpen")
	public String updateIsOpen(ModelMap map, TexiDrivePriceBean bean) {
		
		// 开关房
		texiDrivePriceService.updateIsOpen(bean);
		// 参数
		texiDrivePriceService.refresh(map, bean);
		// 数据
		bean = new TexiDrivePriceBean();
		texiDrivePriceService.selectDrivePirceList(map, bean);
		
		return "/texi/drive/drivePrice";
	}
	
	/**
	 * 
	 * @方法名: updatePrice
	 * @描述: 修改房量
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午5:48:50 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/texi/drive/updatePrice")
	public Integer updatePrice(ModelMap map, TexiDrivePriceBean bean) {
		
		return texiDrivePriceService.updatePrice(bean);
	}
	
	/**
	 * 
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午5:50:22 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@RequestMapping("/texi/drive/updateBatchIsOpen")
	public String updateBatchIsOpen(ModelMap map, TexiDrivePriceBean bean) {
		// 批量关房
		texiDrivePriceService.updateBatchIsOpen(bean, map);
		// 参数
		texiDrivePriceService.refresh(map, bean);
		// 数据
		bean = new TexiDrivePriceBean();
		texiDrivePriceService.selectDrivePirceList(map, bean);
		
		return "/texi/drive/drivePrice";
	}
	
}
