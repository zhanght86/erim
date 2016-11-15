package com.erim.sz.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelPriceBean;
import com.erim.sz.web.dao.HotelRoomDao;

/**
 * @ClassName: HotelRoomService 
 * @Description:房型管理
 * @author maoxian
 * @date 2015年11月3日 下午11:32:38
 */
@Service("hotelroomService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelRoomService {

	@Autowired
	private HotelRoomDao        hotelDao;

	/**
	 * @Title: selectList 
	 * @Description: 查询房型
	 * @param @param roomBean
	 * @param @return    设定文件 
	 * @return List<HotelRoomBean>    返回类型 
	 * @throws
	 */
	public void selectList(HotelPriceBean bean,ModelMap model){
		model.addAttribute("listRoom", this.hotelDao.selectList(bean));
	}
	
	
}