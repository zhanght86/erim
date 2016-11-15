package com.erim.sz.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.bean.GroundPriceBean;
import com.erim.sz.search.dao.GroundDetailDao;
import com.erim.sz.search.dao.GroundPriceDao;
import com.erim.sz.search.dao.GroundTripDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/***
 * 
 * @ClassName: GroundDetailService
 * @Description: 地接社接口
 * @author 龙龙
 * @date 2015年7月29日 下午4:19:14
 *
 */
@Service("groundService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GroundDetailService {

	@Autowired
	private GroundDetailDao 	  groundDao;
	@Autowired
	private GroundPriceDao 		  groundPriceDao;		 
	@Autowired
	private GroundTripDao		  groundTripDao;
	@Autowired
	private CodeService 		  codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;

	public void showGround(ModelMap model, GroundDetailBean bean) {
		//获取国内国外值
		String gddInternation = bean.getGddInternation();
		//如果选择国内，清空国际的值
		if("1".equals(gddInternation)){
			bean.setGddCountylocation(null);
			bean.setGddMajorcountries(null);
			bean.setGddDeparturecity(null);
		}
		//如果选择国际，清空国内的值
		else if("2".equals(gddInternation)){
			bean.setGddProvice(null);
			bean.setGddCity(null);
		}
		//遍历当地游  获取当地游行程
		List<GroundDetailBean> listGround = groundDao.selectPageGround(bean,model);
		for(GroundDetailBean detail : listGround){
			detail.setListGroundTripBean(this.groundTripDao.getTripByTdlId(detail.getId()));
		}
		// 分页查询
		model.put("groundList", listGround);
	}

	
	/**
	 * @Title: selectPriceList 
	 * @Description: 查询当地游量价
	 * @param @param priceBean
	 * @param @return    设定文件 
	 * @return List<GroundPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 上午12:24:04 
	 * @throws
	 */
	public List<GroundPriceBean> selectPriceList(GroundPriceBean price){
		return this.groundPriceDao.selectPriceList(price);
	}
	
	/**
	 * @Title: setCode
	 * @Description: 放置字典
	 * @param @param model 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void setCode(ModelMap model) {

		// 是否属于同城或周边旅游
		model.addAttribute("models",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.YESORNO));
		// 产品属性
		model.addAttribute("vehiclestandard", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.VEHICLESTANDARD));
		// 省市县
		model.addAttribute("provinces",this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		//产品形态
		model.addAttribute("product", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.PRODUCT));
		//产品主题
		model.addAttribute("theme", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.THEME));
		//产品标准
		model.addAttribute("standards", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STANDARDS));
		//学生活动
		model.addAttribute("game", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.GAME));
		//省市县
		model.addAttribute("provinces",this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
	}
	
}