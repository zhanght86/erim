package com.erim.sz.web.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.erim.sz.common.bean.PubNewsBean;
import com.erim.sz.web.service.NewsDetailService;
import com.erim.sz.web.service.PubNewsService;

/**
 * 
 * @ClassName: NewsController
 * @Description: 新闻资讯实体操作控制层
 * @Author ningxiaoqiang
 * @Date 2015年9月22日 上午8:49:32
 *
 */
@Controller
public class NewsController {

	@Autowired
	private NewsDetailService newsDetailService;
	@Autowired
	private PubNewsService pubNewsService;
	
	/**
	 * 
	 * @Title: news
	 * @Description: 获取新闻资讯数据列表
	 * @param model
	 * @param bean
	 * @return
	 *
	 */
	@RequestMapping(value = "/{cpyno}/news/news")
	public String news(ModelMap model, PubNewsBean bean,String searchModel,String newType) {
		if(StringUtils.isNotEmpty(newType)){
			bean.setNewType(newType);
		}else{
			bean.setNewType("00");
		}
		List<PubNewsBean> list = pubNewsService.selectPubNewsPageList(bean, model);
		model.put("NewsList", list);
		model.put("newType", bean.getNewType());
		model.put("searchModel", 4);
		return "/news/news";
	}
	
	/**
	 * 
	 * @Title: news
	 * @Description: 获取新闻资讯数据列表
	 * @param model
	 * @param bean
	 * @return
	 *
	 */
//	@RequestMapping(value = "/{cpyno}/news/newsCX")
//	public String news1(ModelMap model, PubNewsBean bean) {
//		List<PubNewsBean> list = newsDetailService.selectPageNews(model, bean, 10);
//		model.put("NewsList", list);
//		return "/news/newsCX";
//	}
	
	/**
	 * 
	 * @Title: news
	 * @Description: 获取新闻资讯数据列表
	 * @param model
	 * @param bean
	 * @return
	 *
	 */
//	@RequestMapping(value = "/{cpyno}/news/newsHW")
//	public String news2(ModelMap model, PubNewsBean bean) {
//		List<PubNewsBean> list = newsDetailService.selectPageNews(model, bean, 10);
//		model.put("NewsList", list);
//		return "/news/newsHW";
//	}
	
	/**
	 * 
	 * @Title: selectNewsBean
	 * @Description: 门户网站新闻资讯查看内容专用 - 根据ID查询一条信息
	 * @param model
	 * @param id
	 * @return
	 *
	 */
	@RequestMapping(value = "/{cpyno}/news/newsBean")
	public String selectNewsBean(ModelMap map, @RequestParam(value="id") Integer id,String newType) {
		pubNewsService.getPubNewsById(map, id);
		map.put("newType", newType);
		return "/news/newsContext";
	}
	
	/**
	 * 
	 * @Title: selectNewsBean1
	 * @Description: 门户网站新闻资讯查看内容专用 - 根据ID查询一条信息
	 * @param model
	 * @param id
	 * @return
	 *
	 */
//	@RequestMapping(value = "/{cpyno}/news/newsBeanCX")
//	public String selectNewsBean1(ModelMap map, @RequestParam(value="id") Integer id) {
//		map.addAttribute("newsBean", newsDetailService.selectNewsBean(map, id));
//		return "/news/newsCXContext";
//	}
	
	/**
	 * 
	 * @Title: selectNewsBean2
	 * @Description: 门户网站新闻资讯查看内容专用 - 根据ID查询一条信息
	 * @param model
	 * @param id
	 * @return
	 *
	 */
//	@RequestMapping(value = "/{cpyno}/news/newsBeanHW")
//	public String selectNewsBean2(ModelMap map, @RequestParam(value="id") Integer id) {
//		map.addAttribute("newsBean", newsDetailService.selectNewsBean(map, id));
//		return "/news/newsHWContext";
//	}
	
	@RequestMapping(value = "/{cpyno}/news/newsFooter")
	public String newsFooter(ModelMap map,String helpcenter) {
		if(StringUtils.isEmpty(helpcenter)){
			helpcenter = "1";
		}
		map.put("helpcenter", helpcenter);
		return "/news/newsfooter";
	}
	
}