package com.erim.sz.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuidePhotoBean;
import com.erim.sz.web.dao.GuidePhotoDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: GuidePhotoService 
 * @Description: 相册
 * @author maoxian
 * @date 2015年9月10日 下午7:28:09 
 */
@Service("guidePhotoService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuidePhotoService {
	
	@Autowired
	private GuidePhotoDao guidePhotoDao;
	
	/**
	 * @描述: 图片展示
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月24日 下午6:32:14
	 * @param bean
	 * @param map
	 */
	public void selectGuidePhotoByGuide(GuidePhotoBean bean, ModelMap map) {
		
		List<GuidePhotoBean> list = new ArrayList<GuidePhotoBean>();
		
		bean.setGdlId((Integer)SecurityUtils.getSubject().getSession().getAttribute("id"));
		list = guidePhotoDao.selectGuidePhotoByGuide(bean);
		
		if (list != null && list.size() > 0) {
			String str = list.get(0).getGptImgUrl();
			map.addAttribute("firstImg", str);
		}
		
		map.addAttribute("guidePhoto", list);
	}
	
	/**
	 * @描述: 新增导游上传照片
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月24日 下午6:22:09
	 * @param bean
	 * @return
	 */
	public Integer insertPhoto(GuidePhotoBean bean) {
		
		Integer result = CommonUtil.ERROR;
		
		bean.setGdlId((Integer)SecurityUtils.getSubject().getSession().getAttribute("id"));
		bean.setGptCreatetime(new Date());
		bean.setGptCreateuser((String)SecurityUtils.getSubject().getSession().getAttribute("userName"));
		
		result = guidePhotoDao.insertPhoto(bean);
		return result;
	}
	
	/**
	 * @描述: 删除相册
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月27日 上午10:39:17
	 * @param bean
	 * @return
	 */
	public Integer deletePhoto(GuidePhotoBean bean) {
		Integer result = CommonUtil.ERROR;
		
		// 执行删除
		result = guidePhotoDao.deletePhoto(bean);
		
		return result;
	}
	
}
