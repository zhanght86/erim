package com.erim.sz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TexiSendBean;
import com.erim.sz.web.dao.TexiSendDao;

/**
 * @描述: 固定接送接口
 * @作者: （heyuanbo）
 * @创建时间: 2015年11月24日 下午6:34:00
 */
@Service("texiSendService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TexiSendService {
	@Autowired
	private  TexiSendDao texiSendDao;
	
	public void selectSendById(ModelMap model,Integer id){
		TexiSendBean bean = texiSendDao.selectSendById(id);
		
		model.addAttribute("texisend",bean);
	} 

}
