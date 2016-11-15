package com.erim.sz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.common.bean.TexiSendBean;
import com.erim.sz.common.bean.TexiSendPriceBean;
import com.erim.sz.web.dao.TexiDetailDao;
import com.erim.sz.web.dao.TexiSendDao;
import com.erim.sz.web.dao.TexiSendPriceDao;

/**
 * @描述: 固定接送接口
 * @作者: （heyuanbo）
 * @创建时间: 2015年11月24日 下午6:34:00
 */
@Service("texiSendPriceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TexiSendPriceService {
	@Autowired
	private  TexiSendPriceDao texiSendPriceDao;
	@Autowired
	private  TexiSendDao texiSendDao;
	@Autowired
	private TexiDetailDao texiDao;
	
	public void selectSendById(ModelMap model,Integer id){
		TexiSendPriceBean bean = texiSendPriceDao.selectById(id);
		Integer sendId = bean.getSendId();
		TexiSendBean sendBean = texiSendDao.selectSendById2(sendId);
		Integer texiId = sendBean.getTdlId();
		TexiDetailBean texiDetailBean = texiDao.selectTexi(texiId);
		model.addAttribute("texisendprice",bean);
		model.addAttribute("texisend",sendBean);
		model.addAttribute("texiDetailBean",texiDetailBean);
	} 

}
