package com.erim.sz.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.PubNewsBean;
import com.erim.sz.news.service.PubNewsService;

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
	
	/**
	 * @方法名: insertPage
	 * @描述: 新增页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午4:18:03 
	 * @param map
	 * @return
	 */
	@RequestMapping("/pub/news/insertPage")
	public String insertPage(ModelMap map) {
		pubNewsService.setCode(map);
		return "/pub/news/insert";
	}
	
	/**
	 * @方法名: insert
	 * @描述: 新增保存功能
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午4:19:28 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/pub/news/insert")
	public Integer insert(ModelMap map, PubNewsBean bean) {
		return pubNewsService.insert(map, bean);
	}
	
	/**
	 * @方法名: delete
	 * @描述: 删除
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午4:20:50 
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/pub/news/delete")
	public Integer delete(PubNewsBean bean) {
		return pubNewsService.delete(bean);
	}
	
	/**
	 * @方法名: updatePage
	 * @描述: 修改页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午4:22:47 
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping("/pub/news/updatePage")
	public String updatePage(ModelMap map, PubNewsBean bean) {
		// 根据ID查询一条数据
		pubNewsService.getPubNewsById(map, bean);
		// 查询字典
		pubNewsService.setCode(map);
		return "/pub/news/update";
	}
	
	/**
	 * @方法名: update
	 * @描述: 修改保存
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月22日 下午4:23:52 
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/pub/news/update")
	public Integer update(ModelMap map, PubNewsBean bean) {
		return pubNewsService.update(map, bean);
	}
	
	/**
	 * @方法名: updateIsShow
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月23日 上午10:42:59 
	 * @param bean
	 * @return
	 */
	@RequestMapping("/pub/news/updateIsShow")
	public String updateIsShow(ModelMap map, PubNewsBean bean) {
		// 执行更改是否门户显示
		pubNewsService.updateIsShow(bean);
		// 数据列表
		pubNewsService.selectPubNewsPageList(bean, map);
		// 字典
		pubNewsService.setCode(map);
		return "/pub/news/list";
	}
}
