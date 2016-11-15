package com.erim.sz.cafeteria.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.cafeteria.service.CafeteriaVoucherPriceService;
import com.erim.sz.cafeteria.service.CafeteriaVoucherService;
import com.erim.sz.common.bean.CafeteriaVoucherBean;

/**
 * @ClassName:   CafeteriaVoucherController 
 * @Description: 代金券控制层 
 * @author       贺渊博 
 * @date         2015年10月2日 下午6:53:36 
 */
@Controller
public class CafeteriaVoucherController {

	@Autowired
	public CafeteriaVoucherService      cafeteriaVoucherService;
	@Autowired
	public CafeteriaVoucherPriceService cafeteriaVoucherPriceService;
	
	/**
	 * @Title:       showCafeteriaVoucher
	 * @Description: 代金券查看
	 * @param        model
	 * @return       String 返回类型
	 */
	@RequestMapping(value="/cafeteria/voucher/showvoucher")
	public String showVoucher(ModelMap model,CafeteriaVoucherBean bean){
		cafeteriaVoucherService.selectCafeteriaVoucherById(bean, model);
		cafeteriaVoucherService.setCode(model);
		return "/cafeteria/voucher/update";
	}
	
	/**
	 * @描述: 保存代金券信息
	 * @作者: 贺渊博
	 * @创建时间: 2015年12月10日 上午10:43:47
	 * @param model
	 * @param cafeteriaVoucherBean
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/cafeteria/voucher/update")
	public Integer update(ModelMap model, CafeteriaVoucherBean cafeteriaVoucherBean, HttpServletRequest request) {
		
		return cafeteriaVoucherService.update(cafeteriaVoucherBean,request);
	}
	
	/**
	 * @Title: deltetPrice 
	 * @Description: 根据id删除
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value = "/cafeteria/voucher/deltetPrice")
	public Integer deltetPrice(Integer id){
		return this.cafeteriaVoucherPriceService.delete(id);
	}
}
