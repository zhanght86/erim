package com.erim.sz.sametown.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.ComBusRegionBean;
import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.company.dao.ComBusRegionDao;
import com.erim.sz.company.service.CompanyBusinessService;
import com.erim.sz.sametown.dao.GroundDetailDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/***
 * 
 * @类名: GroundDetailService
 * @描述: 当地游接口
 * @作者: 李庆
 * @创建时间: 2015年10月25日 下午5:07:55
 *
 */
@Service("groundService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GroundDetailService {

	@Autowired
	private GroundDetailDao 	   groundDao;
	@Autowired
	private CodeService			   codeService;
	@Autowired
	private TmSystemRegionService  tmSystemRegionService;
	@Autowired
	private ComBusRegionDao        comBusRegionDao;
	@Autowired
	private CompanyBusinessService companyBusinessService;

	/**
	 * @描述: 列表展示
	 * @创建时间: 2015年11月15日 下午5:07:43
	 * @param model
	 * @param bean
	 */
	public void showGroundTown(ModelMap model,GroundDetailBean bean) {
		
		String date = bean.getGpeDate();
		if (StringUtils.isEmpty(date)) {
			bean.setGpeDate(DateUtil.getCuurentDate());
		}
		
		//bean.setCpyId(CommonUtil.getCpyId());
		
		//获取当前公司id
		//bean.setNowCpyId(CommonUtil.getCpyId());
		
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
		
		//根据公司id 查询地接涉及范围
		List<ComBusRegionBean> listcusRegion = this.comBusRegionDao.listRegionBean("01");
		//获取所有省
		String bus = "";
		if(null != listcusRegion && listcusRegion.size()>0){
			//企业范围
			for(ComBusRegionBean region : listcusRegion){
				if(StringUtils.isNotBlank(region.getCbrProvince())){
					bus += region.getCbrProvince() + ",";
				}
			}
		}
		
		//获取国家的可服务区域 根据国家查询服务区域内地接  由于需求不明确 暂不处理
//		CompanyBusinessBean cbs = this.companyBusinessService.selectBuinessByCpyId(CommonUtil.getCpyId());
//		if(null != cbs){
//			//获取国际地接国家 内容
//			String cbsServiceOuter = cbs.getCbsServiceOuter();
//			//获取国际其它
//			String cbsNurRest	   = cbs.getCbsNurRest();
//		}

		//声明数组
		//List<GroundDetailBean> groundList = new ArrayList<GroundDetailBean>();
		if(!"".equals(bus)) {
			bus = bus.substring(0,bus.length()-1);
			bean.setAstrprovince(bus.split(","));
		}else{
			String[] strisnull = { "-1" };
			bean.setAstrprovince(strisnull);
		}
		// 分页查询
		List<GroundDetailBean> groundList = groundDao.selectPageTown(bean,model);
		
		//转码
		for (int i = 0; i < groundList.size(); i++) {
			
			GroundDetailBean detail = groundList.get(i);
			GroundDetailBean map = groundList.get(i);
			
			//列表也显示国际港澳台、国家城市
			String gddCountylocation=detail.getGddCountylocation();
			if(gddCountylocation !=null && !"".equals(gddCountylocation)){
				if ("01".equals(gddCountylocation)) {
					detail.setGddCountylocation("香港");
				}
				if ("02".equals(gddCountylocation)) {
					detail.setGddCountylocation("澳门");
				}
				if ("03".equals(gddCountylocation)) {
					detail.setGddCountylocation("台湾");
				}
			}
			//产品主题
			String GddStandards = detail.getGddStandards();
			if (GddStandards != null && !"".equals(GddStandards)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.THEME, GddStandards);
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
			String gddCity = map.getGddCity();
			if (gddCity != null && !"".equals(gddCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(gddCity));
				map.setGddCity(str);
			}
		}
		
		// 回传信息
		model.put("groundList", groundList);
		//省市县
		model.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		
//		if(StringUtils.isNotBlank(business.getCbsRanProvince1())) bus += business.getCbsRanProvince1() + ",";
//		if(StringUtils.isNotBlank(business.getCbsRanProvince2())) bus += business.getCbsRanProvince2() + ",";
//		if(StringUtils.isNotBlank(business.getCbsRanProvince3())) bus += business.getCbsRanProvince3() + ",";
//		if(StringUtils.isNotBlank(business.getCbsRanProvince4())) bus += business.getCbsRanProvince4() + ",";
//		if(StringUtils.isNotBlank(business.getCbsRanProvince5())) bus += business.getCbsRanProvince5() + ",";
	}
	
	/**
	 * @Title: 			setCode
	 * @Description: 	放置字典
	 * @param @param 	model 设定文件
	 * @return 			void 返回类型
	 * @throws
	 */
	public void setCode(ModelMap model) {

		//产品形态
		model.addAttribute("product", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.PRODUCT));
		//产品主题
		model.addAttribute("theme", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.THEME));
		//产品标准
		model.addAttribute("standards", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STANDARDS));
		//省市县
		model.addAttribute("provinces",this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
	}


}