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

import com.erim.sz.common.bean.MallShopLineBean;
import com.erim.sz.mall.dao.MallShopLineDao;
import com.erim.sz.web.util.CommonUtil;


/**
 * @ClassName: MallShopLineService 
 * @Description: 商城管理
 * @author maoxian
 * @date 2015年12月4日 上午4:17:42
 */
@Service("mallShopLineService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MallShopLineService {
	
	
	@Autowired
	private MallShopLineDao mallShopLineDao;
	
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
	    String mspId1   = request.getParameter("mspId1");
	    String mspId2   = request.getParameter("mspId2");
	    String cpyId    = request.getParameter("cpyId");
	    
	    if(StringUtils.isNotBlank(lineId)){
	    	String[] aline  = lineId.split(",");
	    	String[] acpyId = cpyId.split(","); 
	    	
	    	//设置删除
	    	MallShopLineBean delparm = new MallShopLineBean();
	    	delparm.setCpyId(CommonUtil.getCpyId());
	    	delparm.setMspId1(Integer.parseInt(mspId1));
	    	delparm.setMspId2(Integer.parseInt(mspId2));
	    	this.mallShopLineDao.deleteAll(delparm);
	    	
	    	//声明数组
	    	List<MallShopLineBean> list = new ArrayList<MallShopLineBean>();
	    	for(int i =0;i<aline.length; i ++){
	    		MallShopLineBean theme = new MallShopLineBean();
	    		theme.setMslLineid(Integer.parseInt(aline[i]));
	    		theme.setMslCpyid(Integer.parseInt(acpyId[i]));
	    		theme.setMslCreatetime(new Date());
	    		theme.setMslCreateuser(CommonUtil.getLoginName());
	    		theme.setMspId1(Integer.parseInt(mspId1));
	    		theme.setMspId2(Integer.parseInt(mspId2));
	    		theme.setCpyId(CommonUtil.getCpyId());
	    		list.add(theme);
	    	}
	    	this.mallShopLineDao.insertAll(list);
	    }
	    
		return 0;
	}
	
	/**
	 * @Title: listShopLine 
	 * @Description: 放置model
	 * @param @param bean
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public List<MallShopLineBean> listShopLine(MallShopLineBean bean,ModelMap model){
		bean.setCpyId(CommonUtil.getCpyId());
		return this.mallShopLineDao.selectListByBean(bean);
	}	
}