package com.erim.sz.web.service;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuideRecordBean;
import com.erim.sz.web.dao.GuideRecordDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: GuideRecordService 
 * @Description: 导游动态管理
 * @author maoxian
 * @date 2015年9月10日 下午7:54:13 
 */
@Service("guideRecordService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuideRecordService {
	
	@Autowired
	private GuideRecordDao guideRecordDao;
	
	/**
	 * @描述: 导游管理
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月27日 下午4:48:52
	 * @param bean
	 * @param model
	 */
	public void selectGuideRecordByRecord(GuideRecordBean bean,ModelMap model) {
		
		Integer gdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("id");
		bean.setGdlId(gdlId);
		model.addAttribute("guideRecord", guideRecordDao.selectGuideRecordByRecord(bean));
	}
	
	/**
	 * @描述: 插入方法
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月25日 下午5:35:46
	 * @param bean
	 * @return
	 */
	public Integer insert(GuideRecordBean bean) {
		try {
			bean.setGdlId(Integer.parseInt(SecurityUtils.getSubject().getSession().getAttribute("id").toString()));
			bean.setGrdCreatetime(new Date());
			guideRecordDao.insert(bean);
			return CommonUtil.SUCCESS;
		} catch(Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @描述: 根据id删除一条我的动态
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月25日 下午4:12:33
	 * @param id
	 */
	public void del(Integer id) {
		GuideRecordBean guideRecordBean = new GuideRecordBean();
		guideRecordBean.setId(id);
		guideRecordDao.del(guideRecordBean);
	}
}
