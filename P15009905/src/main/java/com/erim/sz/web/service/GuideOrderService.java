package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuideOrderBean;
import com.erim.sz.web.dao.GuideOrderDao;

/**
 * 
 * @ClassName: GuideOrderService 
 * @Description: 接口
 * @author maoxian
 * @date 2015年9月10日 下午6:29:14 
 *
 */
@Service("guideOrderService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuideOrderService {

	@Autowired
	private GuideOrderDao guideOrderDao;

	public void showGuide(ModelMap model, GuideOrderBean bean) {

		// 分页查询
		List<GuideOrderBean> guideList = guideOrderDao.selectGuide(bean, model);

		// 回传信息
		model.put("guideList", guideList);
	}

}