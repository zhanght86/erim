package com.erim.sz.web.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.common.bean.LinePriceBean;
import com.erim.sz.common.bean.LineTripBean;
import com.erim.sz.web.dao.LineDetailDao;
import com.erim.sz.web.dao.MallLinecompanyDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: LineDetailService 
 * @Description: 专线旅游
 * @author maoxian
 * @date 2015年10月3日 下午1:38:27
 */
@Service("lineService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class LineDetailService {

	@Autowired
	private LineDetailDao         lineDetailDao;
	@Autowired
	private TicketDetailService   ticketDetailService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	@Autowired
	private CodeService           codeService;
	@Autowired
	private MallLinecompanyDao    mallLinecompanyDao;
	
	/**
	 * @Title: selectAllListBean 
	 * @Description: 根据选择的供应商展示专线
	 * @param @return    设定文件 
	 * @return List<LineDetailBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月4日 上午2:44:30 
	 * @throws
	 */
	public List<LineDetailBean> selectAllListBean(ModelMap model,Integer cpyId){
		String[] atrCpyid = this.mallLinecompanyDao.getArrayCpyId();
		//this.zxSellCooperationService.se
		if(null != atrCpyid && atrCpyid.length>0){
			return this.lineDetailDao.selectLineByaCpyid(atrCpyid,new LineDetailBean(),cpyId);
		}
		return null;
	}
	
	
	
	public void selectLine(ModelMap model, LineDetailBean bean,Integer limit){
		bean.getPageLinkBean().setLimit(10);
		//分页查询
		List<LineDetailBean> lineList = lineDetailDao.selectPageLine(bean, model,limit);
		
		// 回传信息
		model.put("lineList", lineList);
		//热门专线
		this.selectHotLine(model);
		//热门门票
		this.ticketDetailService.selectHoteTicket(model);
	}
	
	/**
	 * @Title: selectBeanByLineId 
	 * @Description: 专线id
	 * @param @param lineid
	 * @param @return    设定文件 
	 * @return LineDetailBean    返回类型 
	 * @author maoxian
	 * @date 2015年12月27日 下午7:22:11 
	 * @throws
	 */
	public LineDetailBean selectBeanByLineId(Integer lineid,ModelMap model){
		LineDetailBean line = this.lineDetailDao.selectBeanByLineId(lineid);
		if(null != line){
			
			//列表也显示国际港澳台、国家城市
			String ldlCountylocation=line.getLdlCountylocation();
			if(ldlCountylocation !=null && !"".equals(ldlCountylocation)){
				if ("01".equals(ldlCountylocation)) {
					line.setLdlCountylocation("香港");
				}
				if ("02".equals(ldlCountylocation)) {
					line.setLdlCountylocation("澳门");
				}
				if ("03".equals(ldlCountylocation)) {
					line.setLdlCountylocation("台湾");
				}
			}
			// 大交通
			String ldlBigTraffic = line.getLdlBigTraffic();
			if (ldlBigTraffic != null && !"".equals(ldlBigTraffic)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.VEHICLE, ldlBigTraffic);
				line.setLdlBigTraffic(str);
			}
			// 大交通
			String ldlBigTraffic1 = line.getLdlBigTraffic1();
			if (ldlBigTraffic1 != null && !"".equals(ldlBigTraffic1)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.VEHICLE, ldlBigTraffic1);
				line.setLdlBigTraffic1(str);
			}
			//产品形态
			String ldlProductForm = line.getLdlProductForm();
			if (ldlProductForm != null && !"".equals(ldlProductForm)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.PRODUCT, ldlProductForm);
				line.setLdlProductForm(str);
			}
			//产品标准
			String ldlProductStandard = line.getLdlProductStandard();
			if (ldlProductStandard != null && !"".equals(ldlProductStandard)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.STANDARD, ldlProductStandard);
				line.setLdlProductStandard(str);
			}
			//产品主题
			String ldlProType1 = line.getLdlProType1();
			if (ldlProType1 != null && !"".equals(ldlProType1)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.THEME, ldlProType1);
				line.setLdlProType1(str);
			}
			//学生活动
			String ldlGame = line.getLdlGame();
			if (ldlGame != null && !"".equals(ldlGame)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.GAME, ldlGame);
				line.setLdlGame(str);
			}
			// 所在省
			String ldlProvince = line.getLdlProvince();
			if(StringUtils.isNotBlank(ldlProvince)){
				line.setLdlProvince(tmSystemRegionService.getSystemRegionById(Integer.valueOf(ldlProvince)));
			}
			
			// 所在城市
			String ldlCity = line.getLdlCity();
			if (ldlCity != null && !"".equals(ldlCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ldlCity));
				line.setLdlCity(str);
			}
			//查询专线所有行程
			LinePriceBean bean = new LinePriceBean();
			bean.setTdlId(line.getId());
			List<LineTripBean> lineTrip = this.lineDetailDao.selectLineTripByLineId(bean);
			line.setListTripBean(lineTrip);
			
			for(LineTripBean trip : lineTrip){
				String gddTool  = trip.getLdlTripTraffic();
				String gddLineup = trip.getLtpEndplace();
				
				if(StringUtils.isNotBlank(gddTool) && StringUtils.isNotBlank(gddLineup)){
					String[] agddTool    = gddTool.split(",");
					String[] aggddLineup = gddLineup.split(",");
					
					String backLine = "";
					for(int i = 0;i<agddTool.length ; i++){
						String t = codeService.getValueByCodeKeys("C076", agddTool[i]);
						String l = aggddLineup[i];
					
						backLine += "→"+t+"→"+l;
					}
					trip.setLdlTripTraffic(backLine);
				}
			}
		}
		return line;
	}

	
	
	/**
	 * @Title: selectListById 
	 * @Description: in  id
	 * @param @param id
	 * @param @return    设定文件 
	 * @return List<LineDetailBean>    返回类型 
	 * @throws
	 */
	public List<LineDetailBean> selectListById(String[] str1){
		Integer[] intTemp = new Integer[str1.length];
		for (int i = 0; i <str1.length; i++)
		{
		  intTemp[i] = Integer.parseInt(str1[i]);
		}
		return this.lineDetailDao.selectListById(intTemp);
	}
	
	/**
	 * @Title: showLine 
	 * @Description: 分页查询
	 * @param @param model
	 * @param @param bean
	 * @param @param limit
	 * @param @return    设定文件 
	 * @return List<LineDetailBean>    返回类型 
	 * @throws
	 */
	public List<LineDetailBean> showLine(ModelMap model, LineDetailBean bean,Integer limit) {

		return lineDetailDao.selectPageLine(bean, model,limit);
	}
	/**
	 * 
	 * @Title: selectLineById 
	 * @Description: 根据ID查询对象
	 * @param @param id    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void selectLineById(Integer id,ModelMap model){
		LineDetailBean lineDetailBean =  this.lineDetailDao.selectLine(id);
		String ldlCity = lineDetailBean.getLdlCity();
		if(StringUtils.isNotEmpty(ldlCity)){
			ldlCity = tmSystemRegionService.getSystemRegionById(Integer.parseInt(ldlCity));
			lineDetailBean.setLdlCity(ldlCity);
		}
		// 产品形态PRODUCT
		String ldlProductForm = codeService.getValueByCodeKeys(DictionaryUtil.PRODUCT, lineDetailBean.getLdlProductForm());
		lineDetailBean.setLdlProductForm(ldlProductForm);
		//产品标准
		String ldlProductStandard = codeService.getValueByCodeKeys(DictionaryUtil.STANDARD, lineDetailBean.getLdlProductStandard());
		lineDetailBean.setLdlProductStandard(ldlProductStandard);
		//产品主题ZHUTI
		if(StringUtils.isNotEmpty(lineDetailBean.getLdlProType1())){
			String ldlProType1 = codeService.getValueByCodeKeys(DictionaryUtil.ZHUTI, lineDetailBean.getLdlProType1());
			model.addAttribute("ldlProType1", ldlProType1.split(","));
		}
		if(StringUtils.isNotEmpty(lineDetailBean.getLdlProType2())){
			//String ldlProType2 = codeService.getValueByCodeKeys(DictionaryUtil.ZHUTI, lineDetailBean.getLdlProType2());
			model.addAttribute("ldlProType2",lineDetailBean.getLdlProType2().split(","));
		}
		//是否属于学生活动GAME 01：否 02：是
//		String ldlYesno = codeService.getValueByCodeKeys(DictionaryUtil.GAME, lineDetailBean.getLdlYesno());
//		lineDetailBean.setLdlYesno(ldlYesno);
		if(StringUtils.isNotEmpty(lineDetailBean.getLdlGame())){
			String ldlGame = codeService.getValueByCodeKeys(DictionaryUtil.GAME,lineDetailBean.getLdlGame());
			model.addAttribute("ldlGame", ldlGame.split(","));
		}
		if(StringUtils.isNotEmpty(lineDetailBean.getLdlAddgame())){
			//String ldlAddGame = codeService.getValueByCodeKeys(DictionaryUtil.ZHUTI, lineDetailBean.getLdlAddgame());
			model.addAttribute("ldlAddGame",  lineDetailBean.getLdlAddgame().split(","));
		}
		// 主要景点
		String ldlAttraction = lineDetailBean.getLdlAttraction();
		if (ldlAttraction != null && !"".equals(ldlAttraction)) {
			model.addAttribute("ldlAttraction", ldlAttraction.split(","));
		} else {
			model.addAttribute("ldlAttraction", new String[]{""});
		}
		// 产品特色
		String ldlFeature = lineDetailBean.getLdlFeature();
		if (ldlFeature != null && !"".equals(ldlFeature)) {
			model.addAttribute("ldlFeature", ldlFeature.split(","));
		} else {
			model.addAttribute("ldlFeature", new String[]{""});
		}
		
		
		model.addAttribute("line", lineDetailBean);
	}
	public void selectPriceByLineId(Integer id,ModelMap model){
		LinePriceBean bean = new LinePriceBean();
		bean.setTdlId(id);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String datestr = sdf.format(date);
		bean.setLpeDate(datestr);
		List<LinePriceBean> linePriceBeanList =  this.lineDetailDao.selectPriceByLineId(bean);
		if(linePriceBeanList != null && linePriceBeanList.size() > 0){
			model.addAttribute("lineprice", linePriceBeanList.get(0));
		}else{
			model.addAttribute("lineprice", null);
		}
	}
	public List<LineTripBean> selectLineTripByLineId(Integer id,ModelMap model){
		LinePriceBean bean = new LinePriceBean();
		bean.setTdlId(id);
		return this.lineDetailDao.selectLineTripByLineId(bean);
		
	}
	/**
	 * @Title: setProperty 
	 * @Description: set值
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setProperty(ModelMap model){
		//this.setTj(model);
    	this.setZt(model);
    	//this.setDd(model);
	}
	/**
     * @Title: setTj 
     * @Description: 热门精选 
     * @param @param model    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void setTj(ModelMap model){
    	//声明查询对象
    	LineDetailBean  lineBean = new LineDetailBean();
    	
    	Map<String,List<LineDetailBean>> tj = new HashMap<String,List<LineDetailBean>>();
    	//周边旅游
    	tj.put("tjZb", this.showLine(model, lineBean, 7));
    	//国内旅游
    	tj.put("tjGn", this.showLine(model, lineBean, 7));
    	//港澳台/日韩/东南亚	
    	tj.put("tjGat", this.showLine(model, lineBean, 7));
    	//朝鲜/俄罗斯/欧洲/美洲
    	tj.put("tjOz", this.showLine(model, lineBean, 7));
    	//澳洲/中东/非洲
    	tj.put("tjFz", this.showLine(model, lineBean, 7));
    	//放置model
    	model.put("tj", tj);
    }
	
    /**
     * @Title: setZt 
     * @Description: 主题推荐
     * @param @param model    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void setZt(ModelMap model){
    	//声明查询对象
    	LineDetailBean  lineBean = new LineDetailBean();
    	
    	Map<String,List<LineDetailBean>> zt = new HashMap<String,List<LineDetailBean>>();
    	//周边旅游
    	zt.put("ztZb", this.showLine(model, lineBean, 7));
    	//国内旅游
    	zt.put("ztGn", this.showLine(model, lineBean, 7));
    	//港澳台/日韩/东南亚	
    	zt.put("ztGat", this.showLine(model, lineBean, 7));
    	//朝鲜/俄罗斯/欧洲/美洲
    	zt.put("ztOz", this.showLine(model, lineBean, 7));
    	//澳洲/中东/非洲
    	zt.put("ztFz", this.showLine(model, lineBean, 7));
    	//放置model
    	model.put("zt", zt);
    }
    
    /**
     * @Title: selectHotLine 
     * @Description: 热门专线 
     * @param @param model    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void selectHotLine(ModelMap model){
    	model.addAttribute("hotLine", this.lineDetailDao.selectHotLine());
    }
    
    
    /**
     * @Title: selectHotLines 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @param model    设定文件 
     * @return void    返回类型 
     * @date 2016年1月3日 下午7:16:21 
     * @throws
     */
    public void selectHotLines(ModelMap model){
    	model.addAttribute("hotLinezb", this.lineDetailDao.selectZb());
    	model.addAttribute("hotLineGn", this.lineDetailDao.selectGn());
    	model.addAttribute("hotLineGw1", this.lineDetailDao.selectGw1());
    	model.addAttribute("hotLineGw2", this.lineDetailDao.selectGw2());
    	model.addAttribute("hotLineGw3", this.lineDetailDao.selectGw3());
    	
    }
    
    
    /**
     * @Title: showLine 
     * @Description: 分页查询
     * @param @param model
     * @param @param bean    设定文件 
     * @return void    返回类型 
     * @author maoxian
     * @date 2016年1月3日 下午7:20:45 
     * @throws
     */
	public void showLine(ModelMap model, LineDetailBean bean) {
		// 产品形态
		model.addAttribute("product",    this.codeService.getSystemCodeByCodeNo(DictionaryUtil.PRODUCT));
		//产品标准
		model.addAttribute("themeone",   this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STANDARDS));
		//产品主题
		model.addAttribute("zhuti",      this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ZHUTI));
		//学生活动
		model.addAttribute("game",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.GAME));
		// 省份
	    model.addAttribute("provinces",  this.tmSystemRegionService.getSystemCodeListForProvince());
			    
			    
	   bean.setCpyId(CommonUtil.getCpyId());
	    //获取国内国外值
		String ldlInternation = bean.getLdlInternation();
		//如果选择国内，清空国际的值
		if("1".equals(ldlInternation)){
			bean.setLdlCountylocation(null);
			bean.setLdlMajorcountries(null);
			bean.setLdlDeparturecity(null);
		}
		//如果选择国际，清空国内的值
		else if("2".equals(ldlInternation)){
			bean.setLdlProvince(null);
			bean.setLdlCity(null);
			bean.setLdlCounty(null);
		}

        // 分页查询
		List<LineDetailBean> lineList = lineDetailDao.selectPageLine(bean, model);
		// 回传信息
		model.put("lineList", lineList);
		
		//热门专线
		this.selectHotLine(model);
		//热门门票
		this.ticketDetailService.selectHoteTicket(model);
	}
    
}