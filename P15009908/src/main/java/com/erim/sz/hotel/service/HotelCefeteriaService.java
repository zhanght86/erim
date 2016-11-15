package com.erim.sz.hotel.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelCefeteriaBean;
import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.hotel.dao.HotelCafeteriaDao;
import com.erim.sz.hotel.dao.HotelDetailDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: HotelMeetingService
 * @描述: 酒店餐厅信息实体操作业务层
 * @作者: 王赛
 * @创建时间: 2015年11月3日 下午10:03:18
 *
 */
@Service("hotelCefeteriaService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelCefeteriaService {

	@Autowired
	private HotelCafeteriaDao hotelCafdeteriaDao;
	@Autowired
	private HotelDetailDao hotelDetailDao;
	@Autowired
	private CodeService codeService;
	
	/**
	 * @描述: 根据酒店id查询酒店餐厅信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月9日 下午8:57:36
	 * @param map
	 * @param bean
	 */
	public void selectCafeteriaByHotelId(ModelMap map, HotelCefeteriaBean bean) {
		
		//获取酒店id
		Integer tdlId = bean.getTdlId();
		// 执行查询
		HotelDetailBean hotelBean = hotelDetailDao.getHotelDetailById(tdlId);
		map.addAttribute("hotelBean", hotelBean);
		//如果酒店的id不为空
		if (tdlId != null && !"".equals(tdlId)) {
			SecurityUtils.getSubject().getSession().setAttribute("tdlId", tdlId);
		}
		// 执行查询
		bean.getPageLinkBean().setLimit(10);
		List<HotelCefeteriaBean> CefeteriaList = hotelCafdeteriaDao.selectPageCefeteriaList(bean,map);
		for(int i = 0; i < CefeteriaList.size(); i++){
 			HotelCefeteriaBean detail = CefeteriaList.get(i);
			//餐厅类型
			String type = detail.getHmgCafeteriatype();
			if (type != null && !"".equals(type)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.CTTYPE, type);
				detail.setHmgCafeteriatype(str);
			}
		}
		// 回传信息
		map.put("cefeteriaList", CefeteriaList);
	}
	
	/**
	 * 
	 * @方法名: HotelCefeteriaBean
	 * @描述: 保存餐厅信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月3日 下午10:01:56 
	 * @param bean
	 *
	 */
	public Integer insertCefeteriaBean(HotelCefeteriaBean bean) {
		Integer result = CommonUtil.ERROR;
		// 餐厅ID
		Integer ID = bean.getId();
		// 当ID为空时，为新增
		if(ID == null || "".equals(ID)){
			//获取酒店id
			Integer tdlID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("tdlId");
			bean.setTdlId(tdlID);
			// 执行新增
			result = hotelCafdeteriaDao.insertCefeteriaBean(bean);
		} else {
			// 执行修改
			result = hotelCafdeteriaDao.updateCefeteria(bean);
		}
		return result;
	}
	
	/**
	 * 
	 * @方法名: deleteCafeter
	 * @描述: 删除一条餐厅信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月3日 下午10:01:26 
	 * @param id
	 * @return
	 *
	 */
	public Integer deleteCafeter(Integer id) {
		
		Integer result = hotelCafdeteriaDao.deleteCefeteria(id);
		return result;
	}
	
	/**
	 * @方法名: selectCefeteriaById
	 * @描述: 根据id查询信息
	 * @作者: 王赛
	 * @创建时间: 2015年11月4日 上午9:29:22 
	 * @param model
	 * @param bean
	 */
	public void selectCefeteriaById(ModelMap model,HotelCefeteriaBean bean){
		
		HotelCefeteriaBean detail = hotelCafdeteriaDao.getCefeteriaById(bean);
		
		model.addAttribute("hotelCafeteria", detail);
	}
}
