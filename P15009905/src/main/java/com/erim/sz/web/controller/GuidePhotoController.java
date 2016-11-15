package com.erim.sz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.GuidePhotoBean;
import com.erim.sz.web.service.GuidePhotoService;

/**
 * @ClassName: GuidePhotoController 
 * @Description: 导游相册查看
 * @author maoxian
 * @date 2015年9月10日 下午7:30:23 
 */
@Controller
public class GuidePhotoController {

	@Autowired
	private GuidePhotoService guidePhotoService;

	/**
	 * @描述: 查询相册
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月24日 上午11:50:44
	 * @param model
	 * @param guidePhotoBean
	 * @return
	 */
	@RequestMapping("/photo")
	public String photo(ModelMap model,GuidePhotoBean guidePhotoBean){
		guidePhotoService.selectGuidePhotoByGuide(guidePhotoBean, model);
		return "photo";
	}
	
	/**
	 * @描述: 上传相册
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月24日 下午6:15:27
	 * @param map
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/photo/insert")
	public Integer insert(GuidePhotoBean bean) {
		
		return guidePhotoService.insertPhoto(bean);
	}
	
	/**
	 * @描述: 删除相册
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月27日 上午10:34:53
	 * @param bean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/photo/delete")
	public Integer deletePhoto(GuidePhotoBean bean) {
		
		return guidePhotoService.deletePhoto(bean);
	}
}