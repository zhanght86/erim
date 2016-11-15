package com.erim.sz.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TransticketDetailBean;
import com.erim.sz.search.dao.TransticketDetailDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: TransticketDetailService
 * @描述: 火车票
 * @作者: 李庆
 * @创建时间: 2015年10月25日 下午5:13:52
 *
 */
@Service("transticketService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TransticketDetailService {

	@Autowired
	private TransticketDetailDao  transticketDao;
	@Autowired
	private CodeService			  codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;

	public void showTransticket(ModelMap model, TransticketDetailBean bean) {
		// 分页查询
		List<TransticketDetailBean> transticketList = transticketDao.selectPageTransticket(bean, model);
		
		model.put("transticketList", transticketList);
	}

	

}