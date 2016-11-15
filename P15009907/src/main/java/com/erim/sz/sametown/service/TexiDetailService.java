package com.erim.sz.sametown.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.sametown.dao.TexiDetailDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: TexiDetailService
 * @描述: 租车
 * @作者: 李庆
 * @创建时间: 2015年10月26日 下午1:24:02
 *
 */
@Service("texiService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TexiDetailService {
	
	@Autowired
	private TexiDetailDao         texiDao;
	@Autowired
	private CodeService           codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;

	/**
	 * @Title: 		 showTexiTown 
	 * @Description: 同城同业
	 * @param @param model
	 * @param @param bean  设定文件 
	 * @return 		 void  返回类型 
	 * @throws
	 */
	public void showTexiTown(ModelMap model, TexiDetailBean bean) {
		// 分页查询
		List<TexiDetailBean> texiList = texiDao.selectPageTown(bean, model);
		for (int i = 0; i < texiList.size(); i++) {
			TexiDetailBean detail = texiList.get(i);
			// 车辆档次
			String tdlTexttype = detail.getTdlTexttype();
			if (tdlTexttype != null && !"".equals(tdlTexttype)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXITYPE, tdlTexttype);
				detail.setTdlTexttype(str);
			}
			
			// 车型
			String tdlType = detail.getTdlType();
			if (tdlType != null && !"".equals(tdlType)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.MODELS, tdlType);
				detail.setTdlType(str);
			}
			//可乘人数
			String tdlNum = detail.getTdlNum();
			if(tdlNum != null && !"".equals(tdlNum)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTZUO, tdlNum);
				detail.setTdlNum(str);
			}
			//汽车品牌
			String tdlBrand = detail.getTdlBrand();
			if(tdlBrand !=null && !"".equals(tdlBrand)){
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTBRAND, tdlBrand);
				detail.setTdlBrand(str);
			}
			
			// 所在城市
			String hdlCity = detail.getTdlCity();
			if (hdlCity != null && !"".equals(hdlCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(hdlCity));
				detail.setTdlCity(str);
			}
		}
		// 回传信息
		model.put("texiList", texiList);
		
	}
	
	
}