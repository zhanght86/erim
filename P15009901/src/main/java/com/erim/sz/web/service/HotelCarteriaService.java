package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelCefeteriaBean;
import com.erim.sz.web.dao.HotelCarteriaDao;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: HotelCarteriaService
 * @描述: 酒店餐厅信息
 * @作者: 王赛
 * @创建时间: 2015年11月23日 下午5:09:11
 *
 */
@Service("hotelcarteriaService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelCarteriaService {

	@Autowired
	private HotelCarteriaDao        hotelcarteriadao;
	@Autowired
	private CodeService codeService;
	/**
	 * 
	 * @方法名: selectList
	 * @描述: 酒店餐厅
	 * @作者: 王赛
	 * @创建时间: 2015年11月23日 下午5:10:28 
	 * @param tdlId
	 * @param model
	 *
	 */
	public void selectList(Integer tdlId,ModelMap model){
		
		HotelCefeteriaBean bean = new HotelCefeteriaBean();
		bean.setTdlId(tdlId);
		List<HotelCefeteriaBean> CefeteriaList = hotelcarteriadao.selectList(bean);
		//转码
		//餐厅类型
		for(int i = 0; i < CefeteriaList.size(); i++){
 			HotelCefeteriaBean detail = CefeteriaList.get(i);
			//餐厅类型
			String type = detail.getHmgCafeteriatype();
			if (type != null && !"".equals(type)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.CTTYPE, type);
				detail.setHmgCafeteriatype(str);
			}
		}
		
		model.addAttribute("listcarteria", CefeteriaList);
	}
}