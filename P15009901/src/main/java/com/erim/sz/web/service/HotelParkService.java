package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelParkBean;
import com.erim.sz.web.dao.HotelParkDao;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: HotelMeetingService
 * @描述: 酒店会议室
 * @作者: 王赛
 * @创建时间: 2015年11月23日 下午4:42:29
 *
 */
@Service("hotelparkService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelParkService {

	@Autowired
	private HotelParkDao        hotelparkDao;
	@Autowired
	private CodeService codeService;
	/**
	 * 
	 * @方法名: selectList
	 * @描述: 酒店停车场查询
	 * @作者: 王赛
	 * @创建时间: 2015年11月23日 下午4:58:56 
	 * @param hdlid
	 * @param model
	 *
	 */
	public void selectList(Integer hdlid,ModelMap model){
		
		HotelParkBean bean = new HotelParkBean();
		bean.setHdlId(hdlid);
		List<HotelParkBean> HotelParklist = hotelparkDao.selectList(bean);
		//转码
		for(int i = 0; i < HotelParklist.size(); i++){
			HotelParkBean detail = HotelParklist.get(i);
			//停车场类型
			String hpbType = detail.getHpbType();
			if (hpbType != null && !"".equals(hpbType)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTPTYPE, hpbType);
				detail.setHpbType(str);
			}
			//停车场费用
			String hpbCost = detail.getHpbCost();
			if (hpbCost != null && !"".equals(hpbCost)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTPMONEY, hpbCost);
				detail.setHpbCost(str);
			}
		}
		model.addAttribute("listPark", HotelParklist);
	}
}