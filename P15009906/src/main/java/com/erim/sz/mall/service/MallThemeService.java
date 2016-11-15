package com.erim.sz.mall.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.MallThemeBean;
import com.erim.sz.common.bean.MallThemeTypeBean;
import com.erim.sz.mall.dao.MallThemeDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @类名: MallThemeService
 * @描述: 主题推荐，主题名称选项做活
 * @作者: 国亚文
 * @创建时间: 2015年12月25日 下午5:15:21
 */ 
@Service("mallThemeService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MallThemeService {
	
	
	@Autowired
	private MallThemeDao mallThemeDao;
	/**
	 * 
	 * @方法名: insertThemeType
	 * @描述:   插入所选的主题类型
	 * @作者: 国亚文
	 * @创建时间: 2015年12月25日 下午7:26:05 
	 * @param bean
	 * @return
	 */
	public void insertThemeType(MallThemeTypeBean bean){
		bean.setCpyId(CommonUtil.getCpyId());
		bean.setMteCreatetime(new Date());
		mallThemeDao.insertTheme(bean);
	}
	
	/**
	 * 
	 * @方法名: deleteThemeType
	 * @描述:   删除所选的主题类型
	 * @作者: 国亚文
	 * @创建时间: 2015年12月25日 下午7:26:05 
	 * @param bean
	 * @return
	 */
	public void deleteThemeType(MallThemeTypeBean bean){
		bean.setCpyId(CommonUtil.getCpyId());
		bean.setMteCreatetime(new Date());
		mallThemeDao.deleteTheme(bean);
		
		//同时删除子表
    	MallThemeBean delparm = new MallThemeBean();
    	delparm.setCpyId(CommonUtil.getCpyId());
    	delparm.setMteNtype(bean.getTheme_type_id());
    	this.mallThemeDao.deletecpy(delparm);		
	}
	
	/**
	 * @Title: insert 
	 * @Description: 插入 
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	public Integer insert(HttpServletRequest request){
		String lineId   = request.getParameter("lineId");
	    String mteNtype = request.getParameter("mteNtype");
	    
	    if(StringUtils.isNotBlank(lineId)){
	    	String[] aline = lineId.split(",");
	    	
	    	//设置删除
	    	MallThemeBean delparm = new MallThemeBean();
	    	delparm.setCpyId(CommonUtil.getCpyId());
	    	delparm.setMteNtype(mteNtype);
	    	this.mallThemeDao.deletecpy(delparm);
	    	
	    	//声明数组
	    	List<MallThemeBean> list = new ArrayList<MallThemeBean>();
	    	for(String line : aline){
	    		MallThemeBean theme = new MallThemeBean();
	    		theme.setLineId(Integer.parseInt(line));
	    		theme.setMteCreatetime(new Date());
	    		theme.setMteCreateuser(CommonUtil.getLoginName());
	    		theme.setMteNtype(mteNtype);
	    		theme.setCpyId(CommonUtil.getCpyId());
	    		list.add(theme);
	    	}
	    	this.mallThemeDao.insertList(list);
	    }
	    
		return 0;
	}
	
	/**
	 * @Title: listTheme 
	 * @Description: 放置model
	 * @param @param bean
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void listTheme(MallThemeBean bean,ModelMap model){
		List<MallThemeBean> list = new ArrayList<MallThemeBean>();
		if(!StringUtils.isBlank(bean.getMteNtype()))
		{
		  bean.setCpyId(CommonUtil.getCpyId());
		  list=this.mallThemeDao.selectList(bean);
		}		
		model.addAttribute("listTheme", list);
	}	
	
	public List<MallThemeTypeBean> listThemeType(MallThemeTypeBean bean,ModelMap model){
		bean.setCpyId(CommonUtil.getCpyId());
		List<MallThemeTypeBean> list=this.mallThemeDao.selectThemeList(bean);
		return list;
	}
}