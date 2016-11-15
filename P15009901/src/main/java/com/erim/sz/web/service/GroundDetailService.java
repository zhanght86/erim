package com.erim.sz.web.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.bean.GroundPriceBean;
import com.erim.sz.common.bean.GroundTriplBean;
import com.erim.sz.web.dao.GroundDetailDao;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: GroundDetailService 
 * @Description: 当地游
 * @author maoxian
 * @date 2015年11月15日 下午4:03:50 
 *
 */
@Service("groundDetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GroundDetailService {

	@Autowired
	private GroundDetailDao       groundDetailDao;
	@Autowired
	private CodeService           codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	@Autowired
	private LineDetailService     lineDetailService;
	@Autowired
	private TicketDetailService   ticketDetailService;
	@Autowired
	private GroundTripService	  groundTripService;
	/**
	 * 
	 * @方法名: selectGround
	 * @描述: 当地游列表页
	 * @作者: 王赛
	 * @创建时间: 2015年11月24日 下午8:46:52 
	 * @param model
	 * @param bean
	 * @param limit
	 *
	 */
	public void selectGround(ModelMap model, GroundDetailBean bean,Integer limit) {
//		if("香港".equals(bean.getGddDeparturecityVo())){
//			bean.setGddCountylocation("01");
//			bean.setGddDeparturecity("");
//		}else if("澳门".equals(bean.getGddDeparturecityVo())){
//			bean.setGddCountylocation("02");
//			bean.setGddDeparturecity("");
//		}else if("台湾".equals(bean.getGddDeparturecityVo())){
//			bean.setGddCountylocation("03");
//			bean.setGddDeparturecity("");
//		}else{
//			bean.setGddCountylocation("");
//			bean.setGddDeparturecity(bean.getGddDeparturecityVo());
//		}
		bean.getPageLinkBean().setLimit(10);
		//分页查询
		List<GroundDetailBean> groundList = groundDetailDao.selectPageGround(bean, model,limit);
		/*字典转码*/
		for(int i = 0;i < groundList.size();i++){
			GroundDetailBean detail = groundList.get(i);
			//产品主题
			String Standards = detail.getGddStandards();
			if (!"".equals(Standards) && Standards != null) {
				String Str = codeService.getValueByCodeKeys("C086", Standards);
				detail.setGddStandards(Str);
			}
			//产品形态
			String gddProduct = detail.getGddProduct();
			if (gddProduct != null && !"".equals(gddProduct)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.PRODUCT, gddProduct);
				detail.setGddProduct(str);
			}
			//产品标准
			String gddThemeone = detail.getGddThemeone();
			if (gddThemeone != null && !"".equals(gddThemeone)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.STANDARDS, gddThemeone);
				detail.setGddThemeone(str);
			}
			//学生活动
			String game = detail.getGddGame();
			if(game != null && !"".equals(game)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.GAME, game);
				detail.setGddGame(str);
			}
			// 所在城市
			String gddCity = detail.getGddCity();
			if (gddCity != null && !"".equals(gddCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(gddCity));
				detail.setGddCity(str);
			}
		} 
		// 回传信息
		model.put("groundList", groundList);
		//热门专线
		this.lineDetailService.selectHotLine(model);
		//热门门票
		this.ticketDetailService.selectHoteTicket(model);
	}
	
	/**
	 * @Title: selectById 
	 * @Description: 根据当地游id 获取当地游信息
	 * @param @param id
	 * @param @return    设定文件 
	 * @return GroundDetailBean    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 下午3:44:36 
	 * @throws
	 */
	public GroundDetailBean selectById(Integer id,ModelMap model){

		//return this.groundDetailDao.selectGroundExport(id);

		GroundDetailBean detail = groundDetailDao.selectGroundExport(id);
		//产品主题
		String gddStandards = detail.getGddStandards();
		if (!"".equals(gddStandards) && gddStandards != null) {
			String str = codeService.getValueByCodeKeys("C086", gddStandards);
			detail.setGddStandards(str);
		}
		//产品形态
		String gddProduct = detail.getGddProduct();
		if (gddProduct != null && !"".equals(gddProduct)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.PRODUCT, gddProduct);
			detail.setGddProduct(str);
		}
		//产品标准
		String gddThemeone = detail.getGddThemeone();
		if (gddThemeone != null && !"".equals(gddThemeone)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.STANDARDS, gddThemeone);
			detail.setGddThemeone(str);
		}
		//学生活动
		String game = detail.getGddGame();
		if(game != null && !"".equals(game)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.GAME, game);
			detail.setGddGame(str);
		}
		// 所在城市
		String gddCity = detail.getGddCity();
		if (gddCity != null && !"".equals(gddCity)) {
			String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(gddCity));
			detail.setGddCity(str);
		}
		
		List<GroundTriplBean> listTrip = this.groundTripService.getTripUpdatePage(id,model);
		for(GroundTriplBean trip : listTrip){
			String gddTool   = trip.getGddTool();
			String gddLineup = trip.getGddLineup();
			
			if(StringUtils.isNotBlank(gddTool) && StringUtils.isNotBlank(gddLineup)){
				String[] agddTool    = gddTool.split(",");
				String[] aggddLineup = gddLineup.split(",");
				
				String backLine = "";
				for(int i = 0;i<agddTool.length ; i++){
					String t = codeService.getValueByCodeKeys("C076", agddTool[i]);
					String l = aggddLineup[i];
				
					backLine += "→"+t+"→"+l;
				}
				trip.setGddLineup(backLine);
			}
		}
		detail.setListGroundTripBean(listTrip);
		return detail;
	}
	/**
	 * 
	 * @方法名: selectGroundById
	 * @描述: 根据id查询一条信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月24日 下午10:43:33 
	 * @param id
	 * @param model
	 *
	 */
	public void selectGroundById(Integer id,ModelMap model){
		
		GroundDetailBean detail = groundDetailDao.selectGround(id);
		//产品主题
		String gddStandards = detail.getGddStandards();
		if (!"".equals(gddStandards) && gddStandards != null) {
			String Str = codeService.getValueByCodeKeys("C086", gddStandards);
			model.addAttribute("gddStandards", Str.split(","));
		}
		String gddAddstandards = detail.getGddAddstandards();
		if(gddAddstandards != null && !"".equals(gddAddstandards)){
			model.addAttribute("gddAddstandards", gddAddstandards.split(","));
		}
		//产品形态
		String gddProduct = detail.getGddProduct();
		if (gddProduct != null && !"".equals(gddProduct)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.PRODUCT, gddProduct);
			detail.setGddProduct(str);
		}
		//产品标准
		String gddThemeone = detail.getGddThemeone();
		if (gddThemeone != null && !"".equals(gddThemeone)) {
			String str = codeService.getValueByCodeKeys(DictionaryUtil.STANDARDS, gddThemeone);
			detail.setGddThemeone(str);
		}
		//学生活动
		String game = detail.getGddGame();
		if(game != null && !"".equals(game)){
			String str = codeService.getValueByCodeKeys(DictionaryUtil.GAME, game);
			detail.setGddGame(str);
		}
		// 所在城市
		String gddCity = detail.getGddCity();
		if (gddCity != null && !"".equals(gddCity)) {
			String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(gddCity));
			detail.setGddCity(str);
		}
		// 主要景点
		String gddCharacteristic = detail.getGddCharacteristic();
		if (gddCharacteristic != null && !"".equals(gddCharacteristic)) {
			model.addAttribute("atdlCharacteristic", gddCharacteristic.split(","));
		} else {
			model.addAttribute("atdlCharacteristic", new String[]{""});
		}
		// 产品特色
		String gddFeature = detail.getGddFeature();
		if (gddFeature != null && !"".equals(gddFeature)) {
			model.addAttribute("gddFeature", gddFeature.split(","));
		} else {
			model.addAttribute("gddFeature", new String[]{""});
		}
		model.addAttribute("Ground", detail);
	}
	
	public void selectPriceByGroundId(Integer id,ModelMap model){
		GroundPriceBean bean = new GroundPriceBean();
		bean.setGdlId(id);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String datestr = sdf.format(date);
		bean.setGpeDate(datestr);
		List<GroundPriceBean> groundPriceBeanList =  this.groundDetailDao.selectPriceByGroundId(bean);
		if(groundPriceBeanList != null && groundPriceBeanList.size() > 0){
			model.addAttribute("groundprice", groundPriceBeanList.get(0));
		}else{
			model.addAttribute("groundprice", null);
		}
	}
}