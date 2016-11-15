package com.erim.sz.line.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.erim.sz.common.bean.LinePriceBean;
import com.erim.sz.line.service.LineDetailService;
import com.erim.sz.line.service.LinePriceService;
import com.erim.web.service.CodeService;

/**
 * @描述: 专线量价管理信息实体操作控制层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月5日 下午8:44:53
 */
@Controller
public class LinePriceController {

	@Autowired
	private LinePriceService linePriceService;
	@Autowired
	private CodeService codeService;
	@Autowired
	private LineDetailService lineDetailService;
	
	/**
	 * @描述: 查询
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:49:22
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/line/price/list")
	public String showLinePricePage(ModelMap map, LinePriceBean bean) {
		String portal = bean.getPortal();
		
		// 第一入口
		if ("01".equals(portal)) {
			linePriceService.showLinePricePortal(map, bean);
		}
		// 时间向后选择
		if ("02".equals(portal)) {
			linePriceService.showListForward(map, bean);
		}
		// 时间向前选择
		if ("03".equals(portal)) {
			linePriceService.showListBackwards(map, bean);
		}
		if ("04".equals(portal)) {
			linePriceService.refresh(map, bean);
		}
		// 获取数据
		bean = new LinePriceBean();
		linePriceService.selectLinePriceList(map, bean);
		
		return "/line/price/list";
	}
	
	/**
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:50:04
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/line/price/insert")
	public Integer insertPrice(ModelMap map, LinePriceBean bean) {
		return linePriceService.insertPrice(map, bean);
	}
	
	/**
	 * @描述: 更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:51:03
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/line/price/updateIsOpen")
	public String updateIsOpen(ModelMap map, LinePriceBean bean) {
		
		// 执行更改
		linePriceService.updateIsOpen(bean);
		// 参数
		linePriceService.refresh(map, bean);
		// 数据
		bean = new LinePriceBean();
		linePriceService.selectLinePriceList(map, bean);
		return "/line/price/list";
	}
	
	/**
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:51:33
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/line/price/updatePrice")
	public Integer updatePrice(ModelMap map, LinePriceBean bean) {
		return linePriceService.updatePrice(bean);
	}
	
	/**
	 * @描述: 批量更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:52:00
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/line/price/updateBatchIsOpen")
	public String updateBatchIsOpen(ModelMap map, LinePriceBean bean) {
		// 更改
		linePriceService.updateBatchIsOpen(bean);
		// 参数
		linePriceService.refresh(map, bean);
		// 数据
		bean = new LinePriceBean();
		linePriceService.selectLinePriceList(map, bean);
		
		return "/line/price/list";
	}
}