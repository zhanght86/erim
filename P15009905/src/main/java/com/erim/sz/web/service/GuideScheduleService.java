package com.erim.sz.web.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuideScheduleBean;
import com.erim.sz.common.util.FindDatesUtil;
import com.erim.sz.web.dao.GuideScheduleDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: GuideScheduleService 
 * @Description: 导游档期、金额控制
 * @author maoxian
 * @date 2015年9月11日 下午3:45:02 
 *
 */
@Service("guideScheduleService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GuideScheduleService {
	
	@Autowired
	private GuideScheduleDao guideScheduleDao;
	
	/**
	 * @Title: insert 
	 * @Description: 插入方法
	 * @param @param guideScheduleBean
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public Integer insert(GuideScheduleBean guideScheduleBean,ModelMap model){
		try{
			//获取导游id
			guideScheduleBean.setGdlId(Integer.parseInt(SecurityUtils.getSubject().getSession().getAttribute("id").toString()));
			
			//获取截至时间
			String gseDateEnd = guideScheduleBean.getGseDateEnd();
			//如果时间不为空则为批量设置 否则为日期设置
			if(StringUtils.isNotBlank(gseDateEnd)){
				String startDate = guideScheduleBean.getGseDateStart();
				//时间都不能为空
				if(StringUtils.isNotBlank(startDate) && StringUtils.isNotBlank(gseDateEnd)){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
					Date dBegin = sdf.parse(startDate);
					Date dEnd = sdf.parse(gseDateEnd);
					List<Date> lDate = FindDatesUtil.findDates(dBegin, dEnd);
					//遍历日期 有 修改 没有则插入
					for (Date date : lDate) {
						guideScheduleBean.setGseDateStart(sdf.format(date));
						List<GuideScheduleBean> listGuideBean = this.guideScheduleDao.selectAll(guideScheduleBean);
						if(null != listGuideBean && listGuideBean.size()>0){
							GuideScheduleBean bean = listGuideBean.get(0);
							guideScheduleBean.setId(bean.getId());
							this.guideScheduleDao.update(guideScheduleBean);
						}else{
							this.guideScheduleDao.insert(guideScheduleBean);
						}
					}
				}
				
			}else{
				List<GuideScheduleBean> listGuideBean = this.guideScheduleDao.selectAll(guideScheduleBean);
				if(null != listGuideBean && listGuideBean.size()>0){
					GuideScheduleBean bean = listGuideBean.get(0);
					guideScheduleBean.setId(bean.getId());
					this.guideScheduleDao.update(guideScheduleBean);
				}else{
					this.guideScheduleDao.insert(guideScheduleBean);
				}
			}
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @Title: selectAll 
	 * @Description: 根据日历查询价格 满档空档
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void selectAll(ModelMap model){
		//获取档期管理
		Integer gdlid = Integer.parseInt(SecurityUtils.getSubject().getSession().getAttribute("id").toString());
		
		GuideScheduleBean bean = new GuideScheduleBean();
		bean.setGdlId(gdlid);
		List<GuideScheduleBean> listGuideScheduleBean = this.guideScheduleDao.selectAll(bean);
		model.addAttribute("listGuideSchedule", listGuideScheduleBean);
	}
	
}
