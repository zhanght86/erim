package com.erim.sz.ground.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.company.service.CompanyBusinessService;
import com.erim.sz.ground.service.GroundDetailService;
import com.erim.sz.ground.service.GroundTripService;

/**
 * @ClassName: GroundDetailController
 * @Description: 当地游showGroundTown
 * @author maoxian
 * @date 2015年10月5日 下午6:49:13
 */
@Controller
public class GroundDetailController {

	@Autowired
	private GroundDetailService    groundService;
	@Autowired
	private GroundTripService      groundTripService;
	@Autowired
	private CompanyBusinessService companyBusinessService;

	/**
	 * @描述: 同业资源列表页
	 * @创建时间: 2015年11月22日 下午4:37:37
	 * @param model
	 * @param groundDetailBean
	 * @return
	 * @throws ErimException
	 */
	@RequestMapping(value = "/ground/detail/sametown")
	public String sametown(ModelMap model,@ModelAttribute("groundDetail") GroundDetailBean groundDetailBean) throws ErimException {
		
		// 执行查询
		groundService.showGroundTown(model, groundDetailBean);
		// 字典
		groundService.setCode(model);
		
		return "/ground/sametown/list";
	}

	/**
	 * @描述: 当地旅游管理数据列表
	 * @作者: 
	 * @创建时间: 2015年12月7日 下午4:59:20
	 * @param model
	 * @param groundDetailBean
	 * @return
	 * @throws ErimException
	 */
	@RequestMapping(value = "/ground/detail/list")
	public String showList(ModelMap model, @ModelAttribute("GroundDetail") GroundDetailBean groundDetailBean)
			throws ErimException {
		
		// 新增页面查询字典
		groundService.setCode(model);

		groundService.showGround(model, groundDetailBean);
		// 同城类型
		model.addAttribute("sametownntype", ErimConstants.TOWN_GROUND);

		return "/ground/detail/list";
	}

	/**
	 * @描述: 修改页面
	 * @作者: 
	 * @创建时间: 2015年12月8日 下午4:07:08
	 * @param model
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/ground/detail/updatePage")
	public String updatePage(ModelMap model, GroundDetailBean bean) {
		// 修改页面查询字典
		groundService.setCode(model);
		// 修改页面查询一条
		groundService.selectGroundDetialById(model, bean);
		return "/ground/detail/update";
	}

	/**
	 * @描述: 修改方法
	 * @作者: 应该是贺渊博写的
	 * @创建时间: 2015年12月8日 下午4:07:27
	 * @param model
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ground/detail/update")
	public Integer update(ModelMap model, GroundDetailBean bean) {

		return groundService.update(model, bean);
	}

	/**
	 * @描述: 行程管理中补充当地游信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月16日 下午3:25:07
	 * @param model
	 * @param bean
	 * @param tdlId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ground/detail/updatetrip")
	public Integer updatetrip(ModelMap model, GroundDetailBean bean, Integer tdlId, HttpServletRequest request) {
		// 执行保存行程
		groundTripService.insertList(request, tdlId);
		
		// 补充当地游基础信息
		return groundService.updatetrip(model, bean, tdlId);
	}

	/**
	 * @描述: 新增页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月8日 下午4:07:43
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ground/detail/insertPage")
	public String insertPage(ModelMap model) {
		
		//this.companyBusinessService.getProcitytown(model);
		// 新增页面查询字典
		groundService.setCode(model);
		return "/ground/detail/insert";
	}

	/**
	 * @描述: 新增当地游基础信息
	 * @作者: 
	 * @创建时间: 2015年12月8日 下午3:40:48
	 * @param model
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ground/detail/insert")
	public Integer insert(ModelMap model, GroundDetailBean bean) {
		return groundService.insert(model, bean);
	}

	/**
	 * @描述: 新增当地游基础信息-跳转行程管理页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月17日 下午2:57:14
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/ground/detail/skipTrip")
	public String insertGround(ModelMap map, GroundDetailBean bean) {

		// 保存当地游基础信息
		groundService.insertGround(map, bean);
		// 产品ID
		Integer tdlId = bean.getId();
		// 根据产品ID获取行程管理信息
		groundTripService.getTripUpdatePage(tdlId, map);

		return "/ground/trip/update";
	}

	/**
	 * @描述: 上架下架
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月8日 下午4:07:53
	 * @param bean
	 * @param model
	 * @return
	 * @throws ErimException
	 */
	@RequestMapping(value = "/ground/detail/delete")
	public String delete(GroundDetailBean bean, ModelMap model) throws ErimException {
		groundService.updateStatus(bean);
		bean = new GroundDetailBean();
		return this.showList(model, bean);
	}

	/**
	 * @描述: 复制一条当地游信息 - 包含行程管理，同业管理。不包含量价
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月15日 下午7:46:10
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/ground/detail/copy")
	public Integer copyGrounDetail(GroundDetailBean bean) {
		// 执行复制
		return groundService.copyGroundDetail(bean);
	}

	/**
	 * @描述: 跳转预定方式页面
	 * @作者: （李庆）
	 * @创建时间: 2015年11月28日 下午4:39:41
	 * @param model
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/ground/detail/scheduledPage")
	public String scheduledPage(ModelMap model, GroundDetailBean bean) {
		// 修改页面查询字典
		groundService.setCode(model);
		// 修改页面查询一条
		this.groundService.selectGroundDetialById(model, bean);
		return "/ground/detail/scheduled";
	}

	/**
	 * 修改预定方式
	 * @描述: 
	 * @作者: （李庆）
	 * @创建时间: 2015年11月28日 下午4:40:07
	 * @param model
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ground/detail/scheduled")
	public Integer update1(ModelMap model, GroundDetailBean bean) {

		return groundService.update1(model, bean);
	}

}