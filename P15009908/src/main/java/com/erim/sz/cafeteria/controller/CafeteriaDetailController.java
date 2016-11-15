package com.erim.sz.cafeteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.cafeteria.service.CafeteriaDetailService;
import com.erim.sz.common.bean.CafeteriaDetailBean;

/**
 * @ClassName: CafeteriaDetailController
 * @Description: TODO(特色餐详细控制)
 * @author 贺渊博
 * @date 2015年10月2日 上午9:56:29
 */
@Controller
public class CafeteriaDetailController {
	
	@Autowired
	private CafeteriaDetailService cafeteriaService;

	/**
	 * @描述: 同城同业特色餐
	 * @作者: 王健
	 * @创建时间: 2015年12月10日 上午10:57:15
	 * @param model
	 * @param cafeteriaDetailBean
	 * @return
	 * @throws ErimException
	 */
	@RequestMapping(value = "/cafeteria/detail/sametown")
	public String sametown(ModelMap model, @ModelAttribute("cafeteriaDetail") CafeteriaDetailBean cafeteriaDetailBean) throws ErimException {
		
		cafeteriaService.showCafeteriaTown(model, cafeteriaDetailBean);
	    cafeteriaService.setCode(model);
		return "/cafeteria/sametown/list";
	}
	
	/**
	 * @描述: 同业资源展示餐厅业务信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月20日 下午6:51:00
	 * @param model
	 * @param id
	 * @return
	 * @throws ErimException
	 */
	@RequestMapping(value = "/cafeteria/sametown/business")
	public String showBusinesPage(ModelMap model, Integer id) {
		
		// 获取同业资源餐厅业务信息
		cafeteriaService.showBusinessPage(model, id);
		
		return "/cafeteria/sametown/business";
	}

	/**
	 * @描述: 特色餐列表页
	 * @作者: 
	 * @创建时间: 2015年12月8日 上午11:25:27
	 * @param model
	 * @param cafeteriaDetailBean
	 * @return
	 */
	@RequestMapping(value = "/cafeteria/detail/list")
	public String showList(ModelMap model, @ModelAttribute("cafeteriaDetail") CafeteriaDetailBean cafeteriaDetailBean) {

		cafeteriaService.showCafeteria(model, cafeteriaDetailBean);

		return "/cafeteria/detail/list";
	}

	/**
	 * @描述: 特色餐新增方法
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月1日 下午3:39:10
	 * @param model
	 * @param cafeteriaDetailBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/cafeteria/detail/insert")
	public Integer insert(ModelMap model, CafeteriaDetailBean bean) {
		return cafeteriaService.insert(model, bean);
	}

	/**
	 * 
	 * @Title: insertPage
	 * @Description: 新增页面
	 * @param model
	 *            设定文件
	 * @return
	 * 
	 */
	@RequestMapping(value = "/cafeteria/detail/insertPage")
	public String insertPage(ModelMap model) {
		// 查询字典
		cafeteriaService.setCode(model);

		return "/cafeteria/detail/insert";
	}

	/**
	 * @Title: update
	 * @Description: 修改方法
	 * @param @param
	 *            model
	 * @param @param
	 *            cafeteriaDetailBean
	 * @param @return
	 *            设定文件
	 * @return Integer 返回类型
	 */
	@ResponseBody
	@RequestMapping(value = "/cafeteria/detail/update")
	public Integer update(ModelMap model, CafeteriaDetailBean cafeteriaDetailBean) {
		return cafeteriaService.update(model, cafeteriaDetailBean);
	}

	/**
	 * @Title: updatePage
	 * @Description: 跳转修改页面
	 * @param @param  model
	 * @param @throws  ErimException 设定文件
	 * @return String 返回类型
	 */
	@RequestMapping(value = "/cafeteria/detail/updatePage")
	public String updatePage(ModelMap model, Integer id) throws ErimException {
		// 根据ID查询实体
		this.cafeteriaService.selectCafeteriaDetialById(model, id);
		// 查询字典
		this.cafeteriaService.setCode(model);
		return "/cafeteria/detail/update";
	}

	/**
	 * @Title: delete
	 * @Description: 上下架
	 * @param @param  CafeteriaDetailBean
	 * @param @return  设定文件
	 * @return int 返回类型 1删除成功，0删除失败
	 */
	@RequestMapping(value = "/cafeteria/detail/delete")
	public String delete(CafeteriaDetailBean bean, ModelMap model) throws ErimException {
		this.cafeteriaService.delete(bean);
		bean = new CafeteriaDetailBean();
		return this.showList(model, bean);
	}

	/**
	 * @描述: 跳转预定方式页面
	 * @作者: （李庆）
	 * @创建时间: 2015年11月28日 下午4:37:54
	 * @param model
	 * @param id
	 * @return
	 * @throws ErimException
	 */
	@RequestMapping(value = "/cafeteria/detail/scheduledPage")
	public String updateScheduled(ModelMap model, Integer id) throws ErimException {
		// 根据ID查询实体
		cafeteriaService.selectCafeteriaDetialById(model, id);
		// 查询字典
		cafeteriaService.setCode(model);
		return "/cafeteria/detail/scheduled";
	}
	
	/**
	 * @描述: 修改预定方式
	 * @作者: （李庆）
	 * @创建时间: 2015年11月28日 下午4:38:19
	 * @param model
	 * @param cafeteriaDetailBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/cafeteria/detail/scheduled")
	public Integer scheduled(ModelMap model, CafeteriaDetailBean cafeteriaDetailBean) {
		return cafeteriaService.update1(model, cafeteriaDetailBean);
	}

}
