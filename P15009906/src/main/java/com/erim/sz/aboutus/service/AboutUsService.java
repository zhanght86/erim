package com.erim.sz.aboutus.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.aboutus.dao.AboutUsDao;
import com.erim.sz.common.bean.AboutUsBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @类名: AboutUsService
 * @描述: 关于我们信息实体操作业务层
 * @作者: 贺渊博
 * @创建时间: 2015年11月29日 下午5:41:57
 */
@Service("aboutUsService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class AboutUsService {
	
	@Autowired
	private AboutUsDao aboutUsDao;
	
	/**
	 * @描述: 通过id查询
	 * @作者: （heyuanbo）
	 * @创建时间: 2015年12月6日 下午1:16:45
	 * @param id
	 * @return 返回类型 AboutUsBean
	 */
	public void selectAboutUs(ModelMap map, AboutUsBean bean) {
		
		// 公司ID
		bean.setCpyId(CommonUtil.getCpyId());
		// 执行查询
		bean = aboutUsDao.selectAboutUs(bean);
		
		map.addAttribute("aboutUs", bean);
	}
	
	/**
	 * @描述:  更新关于我们
	 * @作者: （heyuanbo）
	 * @创建时间: 2015年11月29日 下午5:59:35
	 * @param model
	 * @param id
	 */
	public Integer update(ModelMap model,AboutUsBean bean) {
		
		Integer result = CommonUtil.ERROR;
		
		Integer id = bean.getId();
		if (id == null && !"".equals(id)) {
			// 公司ID
			bean.setCpyId(CommonUtil.getCpyId());
			// 创建用户
			bean.setSauCreateuser(CommonUtil.getLoginName());
			// 创建时间
			bean.setSauCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			
			result = aboutUsDao.insert(bean);
		} else {
			result = aboutUsDao.update(bean);
		}
		return result;
	}
}
