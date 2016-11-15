package com.erim.sz.web.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.common.bean.MallDestinationBean;
import com.erim.sz.common.bean.MallHotBean;
import com.erim.sz.common.bean.MallShopBean;
import com.erim.sz.common.bean.MallThemeBean;
import com.erim.sz.common.bean.MallThemeTypeBean;
import com.erim.sz.common.bean.MallWebBean;
import com.erim.sz.web.dao.GroundDetailDao;
import com.erim.sz.web.dao.MallDestinationDao;
import com.erim.sz.web.dao.MallHotDao;
import com.erim.sz.web.dao.MallThemeDao;
import com.erim.sz.web.dao.MallWebDao;
import com.mysql.jdbc.Util;

/**
 * 
 * @ClassName: CompanyDetailService 
 * @Description: 所有企业
 * @author maoxian
 * @date 2015年11月15日 上午11:25:13 
 *
 */
@Service("mallWebService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class MallWebService {

	@Autowired
	private MallWebDao 			 mallWebDao;
	@Autowired
	private MallDestinationDao   mallDestinationDao;
	@Autowired
	private MallHotDao			 mallHotDao;
	@Autowired
	private MallThemeDao         mallThemeDao;
	@Autowired
	private MallShopService      mallShopService;
	@Autowired
	private LineDetailService 	 lineDetailService;
	@Autowired
	private CompanyDetailService companyDetailService;
	@Autowired
	private GroundDetailDao      groundDetailDao;
	
	
	/**
	 * 
	 * @Title: selectMallWebByCode 
	 * @Description: 企业编码
	 * @param @param cpyCode
	 * @param @return    设定文件 
	 * @return MallWebBean    返回类型 
	 * @throws
	 */
	public MallWebBean selectMallWebByCode(String cpyCode){
		//设置企业no到session中
		return this.mallWebDao.selectMallWebByCid(this.companyDetailService.getCpyId(cpyCode));
	}
	
	/**
	 * @Title: setMallWeb 
	 * @Description:  不同企业设置
	 * @param @param cpyno
	 * @param @param model
	 * @param @param request    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setMallWeb(String cpyno,ModelMap model,HttpServletRequest request){
		if(StringUtils.isNotBlank(cpyno)){
			//设置企业no到session中
    		request.getSession().setAttribute("cpyno", cpyno);
    		
    		MallWebBean web = this.selectMallWebByCode(cpyno);
    		//设置门户标题
    		request.getSession().setAttribute("mallWeb", web);
    		//设置客服qq
    		if(web != null){
    			String qq = web.getWebQq();
        		if(StringUtils.isNotBlank(qq)){
        			request.getSession().setAttribute("astrqq", qq.split(","));
        		}
    		}
    		
    		
    		Integer cpyId = this.companyDetailService.getCpyId(cpyno);
    		//当地游
    		this.setDd(model, cpyId);
    		//热门精选
    		this.setTj(model, cpyId);
    		//主题
    		this.setZt(model, cpyId);
    		//往model中赋值
        	//this.lineDetailService.setProperty(model);
        	//商城
        	this.mallShopService.initShopCity(cpyno, model);
    	}
	}
	/**
     * @Title: setTj 
     * @Description: 主题推荐
     * @param @param model    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void setZt(ModelMap model,Integer cpyId){
    	
    	Map<String,List<LineDetailBean>> tj = new HashMap<String,List<LineDetailBean>>();
    	//热门类型
    	MallThemeBean hotbean = new MallThemeBean();
		hotbean.setCpyId(cpyId);
    	
    	List<MallThemeTypeBean> listType = this.mallThemeDao.selectListMallThemeType(hotbean);
    	for(MallThemeTypeBean ty:listType){
    		//查询所有 符合条件的 theme 
    		hotbean.setMteNtype(ty.getTheme_type_id());
    		List<MallThemeBean> listHot = this.mallThemeDao.selectListMallTheme(hotbean);
    		String cid = "";
    		for(MallThemeBean bean : listHot){
    			cid += bean.getLineId()+",";
    		}
    		if(!"".equals(cid))  {
    			cid = cid.substring(0, cid.length()-1);
    			tj.put(ty.getTheme_type_id(), this.lineDetailService.selectListById(cid.split(",")));
    		}else{
    			tj.put(ty.getTheme_type_id(), null);
    		}
    	}
    	model.addAttribute("zt", tj);
    	model.addAttribute("ThemeTypeList", listType);
    	
    }
	
	
	/**
     * @Title: setTj 
     * @Description: 热门精选 
     * @param @param model    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void setTj(ModelMap model,Integer cpyId){
    	
    	Map<String,List<LineDetailBean>> tj = new HashMap<String,List<LineDetailBean>>();
    	//热门类型
    	String[][] ntype = {{"1","周边旅游"},{"2","国内旅游"},{"3","港澳台/日韩/东南亚"},{"4","朝鲜/俄罗斯/欧洲/美洲"},{"5","澳洲/中东/非洲"}};
    	for(String[] type : ntype){
    		//查询所有 符合条件的 hot 
    		MallHotBean hotbean = new MallHotBean();
    		hotbean.setCpyId(cpyId);
    		hotbean.setMhtNtype(type[0]);
    		List<MallHotBean> listHot = this.mallHotDao.selectListMallHot(hotbean);
    		String cid = "";
    		for(MallHotBean bean : listHot){
    			cid += bean.getLineId()+",";
    		}
    		if(!"".equals(cid))  {
    			cid = cid.substring(0, cid.length()-1);
    			tj.put(type[0], this.lineDetailService.selectListById(cid.split(",")));
    		}else{
    			tj.put(type[0], null);
    		}
    	}
    	model.addAttribute("tj", tj);
    	
    }
	
	 /**
     * @Title: setDd 
     * @Description: 当地旅游
     * @param @param model    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void setDd(ModelMap model,Integer cpyId){
    	
    	//声明存放数组
    	Map<String,List<GroundDetailBean>> dd = new LinkedHashMap<String,List<GroundDetailBean>>();
    	
    	//根据企业id 查询要展示的当地游
		List<MallDestinationBean> listMallDestination = this.mallDestinationDao.listMallDestination(cpyId);
		for(MallDestinationBean mall : listMallDestination){
			//设置查询参数
			GroundDetailBean bean = new GroundDetailBean();
			String level=mall.getMdnRegionLevel();
			String regioncode=mall.getMdnRegionCode();
			if (level!=null && level.length()>0)
			{   
				//国内
				if(level.equals("00"))
				{
					if (regioncode.contains("0000"))
					{
					  bean.setGddProvice(regioncode);	
					}
					else if(regioncode.contains("00"))
					{
					  bean.setGddCity(regioncode);					  
					}
					else
					{
					  bean.setGddCounty(regioncode);					  
					}				
				}
				//国际
				else if (level.equals("04"))
				{
				   bean.setGddCountylocation(level);
				   bean.setGddMajorcountries(mall.getMdnName());
				}
				else //港澳台
				{
					bean.setGddCountylocation(level);					
				}
				
			}
			
			dd.put(mall.getMdnName(), this.groundDetailDao.selectPageGround(bean, model, 9));
		}
    	//放置model
    	model.put("dd", dd);
    }
}