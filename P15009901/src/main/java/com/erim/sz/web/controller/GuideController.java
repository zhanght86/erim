package com.erim.sz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.GuideDetailBean;
import com.erim.sz.common.bean.GuidePriceBean;
import com.erim.sz.web.service.GuideDetailService;
import com.erim.sz.web.service.GuidePhotoService;
import com.erim.sz.web.service.GuidePriceServcie;
import com.erim.sz.web.service.GuideRecordService;
import com.erim.sz.web.service.TmSystemRegionService;
import com.erim.web.service.CodeService;

/**
 * @ClassName: GuideController 
 * @Description: 导游管理
 * @author maoxian
 * @date 2015年9月13日 下午2:34:00 
 */
@Controller
public class GuideController {

	@Autowired
	private GuideDetailService 	guideDetailService;
	@Autowired
	private GuideRecordService 	guideRecordService;
	@Autowired
	private GuidePhotoService 	guidePhotoService;
	@Autowired
	private CodeService		   	codeService;
	@Autowired
	private GuidePriceServcie 	guidePriceServcie;
	@Autowired 
	private TmSystemRegionService tmSystemRegionService;

	/**
	 * @描述: 导游列表页
	 * @作者: 
	 * @创建时间: 2015年11月30日 上午10:35:28
	 * @param model
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/{cpyno}/guide/daoyou")
	public String daoyou(ModelMap model,@ModelAttribute("guide")GuideDetailBean bean) {
		
		// 执行查询
		guideDetailService.showGuide(model, bean, 10);
		// 字典
		guideDetailService.setCode(model);
		// 省份
	    model.addAttribute("provinces",        this.tmSystemRegionService.getSystemCodeListForProvince());
		return "/guide/daoyou";
	}
	
	/**
	 * @Title: daoyouxiang 
	 * @Description: 导游详细页
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/guide/daoyouxiang/{id}")
	public String daoyouxiang(ModelMap model,@PathVariable("id")Integer id,String gdlServer) {
		// 执行根据主键查询一条信息
		guideDetailService.selectGuide(id,gdlServer, model);
		// 查询导游动态
		guideRecordService.setRecordByRecordBean(id, model);
		// 查询导游相册
		guidePhotoService.selectPhotoList(model, id);
		model.addAttribute("gdlServer", gdlServer);
		return "/guide/daoyouxiang";
	}
	
	/**
	 * @Title: order 
	 * @Description: 导游预订
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/guide/daoyouxiang/order/{id}")
	public String order(ModelMap model){
		return "/guide/daoyouorder";
	}
	
	/**
	 * @描述: 导游日历
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午8:59:52
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/{cpyno}/guide/daoyouxiang/price")
	public String priceList(ModelMap map, GuidePriceBean bean) {
		
		guidePriceServcie.getGuidePriceList(map, bean);
		
		return "/guide/price";
	}
	
	/**
	 * @描述: 更改当前选择时间
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午9:02:45
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/{cpyno}/guide/daoyouxiang/skipDate")
	public String skipDate(ModelMap map, GuidePriceBean bean) {
		
		String portal = bean.getPortal();
		
		// 时间向前选择
		if ("02".equals(portal)) {
			guidePriceServcie.forward(map, bean);
		} else if ("01".equals(portal)) {
			// 时间向后选择
			guidePriceServcie.backwards(map, bean);
		} else if ("03".equals(portal)) {
			// 选择服务类型
			guidePriceServcie.skipService(map, bean);
		}
		return "/guide/price";
	}
	
	/**
	 * @描述: 地接外网查询 需要查询该导游所有服务类型 
	 * @作者: 吴哲元
	 * @创建时间: 2015年12月30日 下午8:08:19
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{cpyno}/guide/daoyouxiangdj/{id}")
	public String daoyouxiangdj(ModelMap model,@PathVariable("id")Integer id) {
		// 执行根据主键查询一条信息
		this.guideDetailService.selectGuidedj(id, model);
		// 查询导游动态
		guideRecordService.setRecordByRecordBean(id, model);
		// 查询导游相册
		guidePhotoService.selectPhotoList(model, id);
		return "/guide/daoyouxiangdj";
	}
	
	@RequestMapping("/{cpyno}/guide/daoyouxiang/pricedj")
	public String priceListdj(ModelMap map, GuidePriceBean bean) {
		
		guidePriceServcie.getGuidePriceListDJ(map, bean);
		
		return "/guide/pricedj";
	}
	
	@RequestMapping("/{cpyno}/guide/daoyouxiang/skipDatedj")
	public String skipDatedj(ModelMap map, GuidePriceBean bean) {
		
		String portal = bean.getPortal();
		
		// 时间向前选择
		if ("02".equals(portal)) {
			guidePriceServcie.forwardDJ(map, bean);
		} else if ("01".equals(portal)) {
			// 时间向后选择
			guidePriceServcie.backwardsDJ(map, bean);
		} else if ("03".equals(portal)) {
			// 选择服务类型
			guidePriceServcie.skipServiceDJ(map, bean);
		}
		return "/guide/pricedj";
	}
	
}