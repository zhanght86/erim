package com.erim.sz.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelMeetingBean;
import com.erim.sz.web.dao.HotelMeetingDao;
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
@Service("hotelmeetService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelMeetingService {

	@Autowired
	private HotelMeetingDao        hotelmeetDao;
	@Autowired
	private CodeService codeService;
	/**
	 * 
	 * @方法名: selectList
	 * @描述: 酒店会议室查询
	 * @作者: 王赛
	 * @创建时间: 2015年11月23日 下午4:42:59 
	 * @param hdlid
	 * @param model
	 *
	 */
	public void selectList(Integer hdlid,ModelMap model){
		
		HotelMeetingBean bean = new HotelMeetingBean();
		bean.setHdlId(hdlid);
		List<HotelMeetingBean> HotelMeetlist = hotelmeetDao.selectList(bean);
		//转码
		for(int i = 0; i < HotelMeetlist.size(); i++){
			HotelMeetingBean detail = HotelMeetlist.get(i);
			//会议室设施
			String type = detail.getHmgIsTea();
			if (type != null && !"".equals(type)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.MEET, type);
				detail.setHmgIsTea(str);
			}
			// 摆放形式
			String hmgShape = detail.getHmgShape();
			if (hmgShape != null && !"".equals(hmgShape)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.SHAPE, hmgShape);
				detail.setHmgShape(str);
			}
		}
		model.addAttribute("listMeet", HotelMeetlist);
	}
}