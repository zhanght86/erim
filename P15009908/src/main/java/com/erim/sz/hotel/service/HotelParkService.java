package com.erim.sz.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.common.bean.HotelParkBean;
import com.erim.sz.hotel.dao.HotelDetailDao;
import com.erim.sz.hotel.dao.HotelParkDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * @ClassName: HotelParkService 
 * @Description: TODO(酒店停车场实体操作业务层) 
 * @author  贺渊博 
 * @date 2015年11月3日 下午10:15:31 
 */
@Service("hotelParkService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelParkService {
	
	@Autowired
	private HotelParkDao hotelParkDao;
	@Autowired
	private HotelDetailDao hotelDetailDao;
	@Autowired
	private CodeService codeService;
	
	/**
	 * @描述: 根据酒店ID获取停车场数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月9日 下午9:21:36
	 * @param map
	 * @param bean
	 */
	public void selectParkByHotelId(ModelMap map, HotelParkBean bean){
		
		HotelDetailBean hotelBean = new HotelDetailBean();
		// 酒店id
		Integer hdlId = bean.getHdlId();
		// 返回页面参数
		hotelBean = hotelDetailDao.getHotelDetailById(hdlId);
		map.addAttribute("hotelBean", hotelBean);
		// 执行查询
		bean.getPageLinkBean().setLimit(10);
		List<HotelParkBean> parkList = hotelParkDao.selectPageparkList(bean, map);
		for (int i = 0; i < parkList.size(); i++){
			HotelParkBean model = parkList.get(i);
			//停车场类型
			String hpbType = model.getHpbType();
			if (hpbType != null && !"".equals(hpbType)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTPTYPE, hpbType);
				model.setHpbType(str);
			}
			// 停车场费用
			String hpbCost = model.getHpbCost();
			if (hpbCost != null && !"".equals(hpbCost)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.TEXTPMONEY, hpbCost);
				model.setHpbCost(str);
			}
		}
		map.put("ParkList", parkList);
	}
	
    /**
     * @方法名：insertPark 
     * @描述: 保存停车场信息
     * @作者：  贺渊博
     * @创建时间：2015年11月3日 下午10:48:55
     * @param bean
     * @return
     */
	public Integer savePark(HotelParkBean bean) {
		
		Integer result = CommonUtil.ERROR;
		// 停车场ID
		Integer ID = bean.getId();
		// 当ID为空时，为新增
		if(ID == null || "".equals(ID)){
			// 执行新增
			result = hotelParkDao.insertPark(bean);
		} else {
			// 执行修改
			result = hotelParkDao.updatePark(bean);
		}
		return result;
	}
	/**
	 * 
	 * @方法名：deletePark 
	 * @描述:  删除一条停车场信息
	 * @作者：  贺渊博
	 * @创建时间：2015年11月3日 下午10:50:58
	 * @param id
	 * @return
	 *
	 */
	public Integer deletePark(Integer id){
		   
	   Integer result = hotelParkDao.deletePark(id);
	   return result;
	   
   }
	
	/**
	 * 
	 * @方法名: selectCefeteriaById
	 * @描述: 根据id查询一条数据
	 * @作者: 王赛
	 * @创建时间: 2015年11月4日 下午4:47:10 
	 * @param model
	 * @param bean
	 *
	 */
	public void selectparkById(ModelMap model,HotelParkBean bean){
		
		HotelParkBean detail = hotelParkDao.getparkById(bean);
		
		model.addAttribute("hotelpark", detail);
	}
	
	/**
	 * 
	 * @描述: 放置字典
	 * @作者: 
	 * @创建时间: 2015年11月5日 上午11:46:26
	 * @param model
	 */
	public void setCode(ModelMap model){
		//停车场类型
		model.addAttribute("texttype",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTPTYPE));
		//停车费用
		model.addAttribute("zyxm",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.TEXTPMONEY));
	}   
}

   
