package com.erim.sz.zx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.zx.service.ZxSellCooperationService;

/**
 * @ClassName: ZxSellCooperationController 
 * @Description: 合作管理
 * @author maoxian
 * @date 2015年12月9日 下午2:33:22
 */
@Controller
public class ZxSellCooperationController {

	@Autowired
	private ZxSellCooperationService zxSellCooperationService;

	/**
	 * @Title: insertAll 
	 * @Description: 选择全部
	 * @param @param ntype 1更新  2删除
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月9日 下午3:27:40 
	 * @throws
	 */
	@RequestMapping(value = "/zxsell/detail/insertAll")
	public @ResponseBody Integer insertAll(HttpServletRequest request){
		return this.zxSellCooperationService.updateAll(request);
//		return "1".equals(ntype)?this.zxSellCooperationService.insertAll():this.zxSellCooperationService.deleteAll();
	}
}
