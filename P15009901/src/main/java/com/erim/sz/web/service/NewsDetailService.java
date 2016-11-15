package com.erim.sz.web.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.PubNewsBean;
import com.erim.sz.web.dao.NewsDetailDao;

/**
 * 
 * @ClassName: NewsDetailService
 * @Description: 新闻资讯实体操作业务类
 * @Author 宁晓强
 * @Date 2015年9月21日 下午1:52:49
 *
 */
@Repository("newsDetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class NewsDetailService {

	@Autowired
	private NewsDetailDao newsDetailDao;
	
	/**
	 * 
	 * @Title: selectPageNews
	 * @Description: 
	 * @param model
	 * @param bean
	 * @param limit
	 *
	 */
	public List<PubNewsBean> selectPageNews(ModelMap model, PubNewsBean bean, Integer limit) {
		
		bean.getPageLinkBean().setLimit(10);
		
		List<PubNewsBean> list = newsDetailDao.selectPageNews(bean, model, limit);
		for (int i = 0; i < list.size(); i++) {
			// 时间格式转换
			PubNewsBean bean2 = list.get(i);
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(bean2.getNewCreateTime());
//			bean2.setCreateTime(date);
		}
		return list;
	}
	
	/**
	 * 
	 * @Title: selectNewsContext
	 * @Description: 门户网站新闻资讯查看内容专用 - 根据ID查询一条信息
	 * @param map
	 * @param id
	 *
	 */
	public PubNewsBean selectNewsBean(ModelMap map, Integer id) {
		// 给该条数据点击数+1
		newsDetailDao.updateClickById(id);
		
		// 查询一条数据
		PubNewsBean bean = newsDetailDao.selectNewsBean(map, id);
		String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(bean.getNewCreateTime());
//		bean.setCreateTime(data);
		return bean;
	}
}
