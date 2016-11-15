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

import com.erim.sz.common.bean.MallHotBean;
import com.erim.sz.mall.dao.MallHotDao;
import com.erim.sz.web.util.CommonUtil;

/**
 * 
 * @ClassName: MallHotService 
 * @Description: 热门精选 
 * @author maoxian
 * @date 2015年11月12日 上午2:18:34 
 *
 */
@Service("mallHotService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MallHotService {
	
	
	@Autowired
	private MallHotDao mallHotDao;
	
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
	    String mhtNtype = request.getParameter("mhtNtype");
	  //设置删除
    	MallHotBean delparm = new MallHotBean();
    	delparm.setCpyId(CommonUtil.getCpyId());
    	delparm.setMhtNtype(mhtNtype);
    	this.mallHotDao.deletecpy(delparm);
	    
	    if(StringUtils.isNotBlank(lineId)){
	    	String[] aline = lineId.split(",");
	    	
	    	
	    	
	    	//声明数组
	    	List<MallHotBean> list = new ArrayList<MallHotBean>();
	    	for(String line : aline){
	    		MallHotBean hot = new MallHotBean();
	    		hot.setLineId(Integer.parseInt(line));
	    		hot.setMhtCreatetime(new Date());
	    		hot.setMhtCreateuser(CommonUtil.getLoginName());
	    		hot.setMhtNtype(mhtNtype);
	    		hot.setCpyId(CommonUtil.getCpyId());
	    		list.add(hot);
	    	}
	    	this.mallHotDao.insertList(list);
	    }
	    
		return 0;
	}
	
	/**
	 * @Title: listHot 
	 * @Description: 放置model
	 * @param @param bean
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void listHot(MallHotBean bean,ModelMap model){
		model.addAttribute("listHot", this.mallHotDao.selectList(bean));
	}	
}