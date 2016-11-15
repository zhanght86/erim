package com.erim.sz.web.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuideRecordBean;
import com.erim.sz.web.dao.GuideRecordDao;

/**
 * @ClassName: GuideRecordService 
 * @Description: 导游动态
 * @author maoxian
 * @date 2015年11月4日 上午12:12:40
 */
@Service("guiderecordService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuideRecordService {

	@Autowired
	private GuideRecordDao        guideDao;

	/**
	 * @Title: setRecordByRecordBean 
	 * @Description: 查询导游动态
	 * @param @param recore
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setRecordByRecordBean(Integer id,ModelMap model){
		GuideRecordBean recore = new GuideRecordBean();
		recore.setGdlId(id);
		List<GuideRecordBean> list = new ArrayList<GuideRecordBean>();
		list = guideDao.getListRcordByBean(recore);
		// 时间转码
		for (int i = 0; i < list.size(); i++) {
			// 创建时间
			Date createDate = list.get(i).getGrdCreatetime();
			String month = new SimpleDateFormat("MM").format(createDate);
			String day = new SimpleDateFormat("dd").format(createDate);
			String dateStr = month + "." + day;
			list.get(i).setDateStr(dateStr);
		}
		model.addAttribute("guideRecord", list);
	}
	
}