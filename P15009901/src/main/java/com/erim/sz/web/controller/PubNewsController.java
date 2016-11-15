package com.erim.sz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.common.bean.PubNewsBean;
import com.erim.sz.web.service.PubNewsService;

/**
 * @类名: PubNewsController
 * @描述: 新闻资讯信息实体操作控制层
 * @作者: 宁晓强
 * @创建时间: 2015年10月22日 下午3:13:35
 */
@Controller
public class PubNewsController {

	@Autowired
	private PubNewsService pubNewsService;
	
	/**
	 * @方法名: showPubNewsPageList
	 * @描述: 查询数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午4:16:19 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/pub/news/list")
	public String showPubNewsPageList(ModelMap map, @ModelAttribute("pubNews")PubNewsBean bean) {
		
		pubNewsService.selectPubNewsPageList(bean, map);
		
		pubNewsService.setCode(map);
		
		return "/pub/news/list";
	}
	
	
	
	
}
