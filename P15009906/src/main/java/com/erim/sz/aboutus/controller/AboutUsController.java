package com.erim.sz.aboutus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.aboutus.service.AboutUsService;
import com.erim.sz.common.bean.AboutUsBean;

/**
 * @类名: AboutUsController
 * @描述: 关于我们信息实体操作控制层
 * @作者: 贺渊博
 * @创建时间: 2015年11月29日 下午5:42:08
 */
@Controller
public class AboutUsController {
	
	@Autowired
	private AboutUsService aboutUsService;
	
	/**
	 * @描述: 打开页面方法
	 * @作者: （heyuanbo）
	 * @创建时间: 2015年12月5日 下午4:39:54
	 * @return
	 */
	@RequestMapping(value = "/sell/aboutus/updatePage")
	public String updatePage(ModelMap map, AboutUsBean bean) throws ErimException {
		
		// 执行查询
		aboutUsService.selectAboutUs(map, bean);
		
		return "/aboutus/update";
	}
	
	/**
	 * @描述:  修改方法
	 * @作者: （heyuanbo）
	 * @创建时间: 2015年12月5日 下午5:32:33
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sell/aboutus/update")
	public Integer update(ModelMap model,AboutUsBean bean){
		return aboutUsService.update(model,bean);
	}
}
