package com.erim.sz.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuidePhotoBean;
import com.erim.sz.web.dao.GuidePhotoDao;

/**
 * @类名: GuidePhotoService
 * @描述: 导游相册信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年12月28日 上午11:32:38
 */
@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuidePhotoService {

	@Autowired
	private GuidePhotoDao guidePhotoDao;
	
	/**
	 * @描述: 查询导游相册
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月28日 上午11:34:47
	 * @param map
	 * @param bean
	 * @return
	 */
	public void selectPhotoList(ModelMap map, Integer id) {
		List<GuidePhotoBean> list = new ArrayList<GuidePhotoBean>();
		GuidePhotoBean bean = new GuidePhotoBean();
		bean.setGdlId(id);
		// 执行查询
		list = guidePhotoDao.selectGuidePhotoList(bean);
		
		map.addAttribute("guidePhoto", list);
	}
}
