package com.erim.sz.guide.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.GuidePriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.guide.service.GuidePriceService;

/**
 * @类名: GuidePriceController
 * @描述: 导游管理信息实体操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年10月20日 下午3:05:36
 */
@Controller
public class GuidePriceController {

	@Autowired
	private GuidePriceService guidePriceService;
	
	/**
	 * @描述: 根据服务类型来判断跳转页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月20日 下午3:59:11
	 * @return
	 */
	public String skipService() {
		String servicePage = "";
		String serviceType = (String) SecurityUtils.getSubject().getSession().getAttribute("currIsInternal");
		if (ErimConstants.GUIDE_SERVICE_LOCAL.equals(serviceType)) {
			// 国内地陪- 三种价格
			servicePage =  "/guide/price/list";
		} else if (ErimConstants.GUIDE_SERVICE_NATIONAL.equals(serviceType)) {
			// 国内全陪- 二种价格
			servicePage =  "/guide/price/listTwo";
		} else if (ErimConstants.GUIDE_SERVICE_LEADER.equals(serviceType)) {
			// 国际领队- 二种价格
			servicePage =  "/guide/price/listTwo";
		} else if (ErimConstants.GUIDE_SERVICE_GAID.equals(serviceType)) {
			// 国际地陪- 三种价格
			servicePage =  "/guide/price/list";
		}
		return servicePage;
	}
	
	/**
	 * @描述: 获取页面数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月20日 下午2:55:10
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/guide/price/list")
	public String showGuidePricePage(ModelMap map, GuidePriceBean bean) {
		
		// 入口号
		String portal = bean.getPortal();
		
		// 同业资源入口
		if ("06".equals(portal)) {
			guidePriceService.showSametownPortal(map, bean);
			
			// 获取数据
			bean = new GuidePriceBean();
			guidePriceService.selectGuidePriceList(map, bean);
			return "/guide/sametown/price";
		}
		// 同业资源时间向前选择按钮
		if ("07".equals(portal)) {
			guidePriceService.showListForward(map, bean);
			
			// 获取数据
			bean = new GuidePriceBean();
			guidePriceService.selectGuidePriceList(map, bean);
			return "/guide/sametown/price";
		}
		// 同业资源时间向后选择按钮
		if ("08".equals(portal)) {
			guidePriceService.showListBackwards(map, bean);
			
			// 获取数据
			bean = new GuidePriceBean();
			guidePriceService.selectGuidePriceList(map, bean);
			return "/guide/sametown/price";
		}
		// 第一入口
		if ("01".equals(portal)) {
			guidePriceService.showGuidePricePortal(map, bean);
		}
		// 时间向前选择
		if ("02".equals(portal)) {
			guidePriceService.showListForward(map, bean);
		}
		// 时间向后
		if ("03".equals(portal)) {
			guidePriceService.showListBackwards(map, bean);
		}
		// 刷新
		if ("04".equals(portal)) {
			guidePriceService.refresh(map, bean);
		}
		// 更改服务类型
		if ("05".equals(portal)) {
			guidePriceService.skipService(map, bean);
		}
		// 获取数据
		bean = new GuidePriceBean();
		guidePriceService.selectGuidePriceList(map, bean);
		
		// 根据服务类型，判断跳转哪个页面
		return skipService();
	}
	
	/**
	 * @描述: 获取该导游是否有量价信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月8日 上午10:23:13
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/guide/price/getInternal")
	public Integer getGuideIsInternal(ModelMap map, GuidePriceBean bean) {
		return guidePriceService.getGuideIsInternal(map, bean);
	}
	
	/**
	 * @方法名: insertPrice
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午4:40:17 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/guide/price/insert")
	public Integer insertPrice(ModelMap map, GuidePriceBean bean) {
		return guidePriceService.insertPrice(map, bean);
	}
	
	/**
	 * 
	 * @方法名: updateIsOpen
	 * @描述: 更改是否带团状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午4:42:47 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@RequestMapping("/guide/price/updateIsOpen")
	public String updateIsOpen(ModelMap map, GuidePriceBean bean) {
		
		// 是否带团
		guidePriceService.updateIsOpen(bean);
		// 参数
		guidePriceService.refresh(map, bean);
		// 数据
		bean = new GuidePriceBean();
		guidePriceService.selectGuidePriceList(map, bean);
		
		// 根据服务类型，判断跳转哪个页面
		return skipService();
	}
	
	/**
	 * 
	 * @方法名: updatePrice
	 * @描述: 修改量价信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午4:44:01 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/guide/price/updatePrice")
	public Integer updatePrice(ModelMap map, GuidePriceBean bean) {
		return guidePriceService.updatePrice(bean);
	}
	
	/**
	 * 
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量更改是否带团状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月20日 下午4:54:50 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	@RequestMapping("/guide/price/updateBatchIsOpen")
	public String updateBatchIsOpen(ModelMap map, GuidePriceBean bean) {
		
		// 更改
		guidePriceService.updateBatchIsOpen(bean, map);
		// 参数
		guidePriceService.refresh(map, bean);
		// 数据
		bean = new GuidePriceBean();
		guidePriceService.selectGuidePriceList(map, bean);
		
		// 根据服务类型，判断跳转哪个页面
		return skipService();
	}
}
