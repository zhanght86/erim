package com.erim.sz.search.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.common.bean.HotelPriceBean;
import com.erim.sz.common.bean.HotelRoomBean;
import com.erim.sz.search.dao.HotelDetailDao;
import com.erim.sz.search.dao.HotelPriceDao;
import com.erim.sz.search.dao.HotelRoomDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/***
 * 
 * @ClassName: HotelDetailService
 * @Description: 酒店接口
 * @author 龙龙
 * @date 2015年7月29日 上午11:19:37
 *
 */
@Service("hoteldetailService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelDetailService {

	@Autowired
	private HotelDetailDao        hotelDao;
	@Autowired
	private HotelRoomDao		  hotelRoomDao;
	@Autowired
	private HotelPriceDao		  HotelPriceDao;
	@Autowired
	private CodeService 	      codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;

	
	/**
	 * @Title: listHotelPrice 
	 * @Description: 查询酒店价格
	 * @param @param priceBean
	 * @param @return    设定文件 
	 * @return List<HotelPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月17日 下午7:52:45 
	 * @throws
	 */
	public List<HotelPriceBean> listHotelPrice(HotelPriceBean priceBean){
		return this.HotelPriceDao.listHotelPrice(priceBean);
	}
	
	/**
	 * 
	 * @Title: showHotel
	 * @Description: 查询酒店信息
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void showHotel(ModelMap model, HotelDetailBean bean) {
		
		bean.getPageLinkBean().setLimit(10);

		List<HotelDetailBean> listHotelRoom = hotelDao.selectPageHotel(bean, model);
		for(HotelDetailBean b : listHotelRoom){
			List<HotelRoomBean> resultList = this.hotelRoomDao.selectHotelRoomList(b.getId());
			b.setListHotelRoom(resultList);
			
			//遍历房型 返回房间号
			StringBuffer cid = new StringBuffer();
			if(null != resultList && resultList.size()>0){
				for(HotelRoomBean hdb : resultList){
					//cid += hdb.getId()+",";
					cid.append(hdb.getId()).append(",");
				}
			}
			if(null != cid && cid.length()>0 && (cid.lastIndexOf(",") == cid.length()-1)){
				cid.deleteCharAt(cid.length()-1);
			}
			b.setAllRoomId(cid.toString());
		}
		
		// 回传信息
		model.put("hotelList", listHotelRoom);
	}

	/**
	 * 
	 * @Title: insert
	 * @Description: 插入
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public Integer insert(ModelMap model, HotelDetailBean bean) {
		try {
			bean.setHdlCreatetime(new Date());
			bean.setHdlCreateuser((String)SecurityUtils.getSubject().getSession().getAttribute("userName"));
			bean.setCpyId((Integer)SecurityUtils.getSubject().getSession().getAttribute("userCpyId"));
			bean.setHdlIsDelStatus("0");
			// 插入数据
			hotelDao.insertHotel(bean);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}

	}

	/**
	 * @Title: selectHotelDetialById
	 * @Description: 根据ID查询实体
	 * @param @param id
	 * @param @return 设定文件
	 * @return HotelDetailBean 返回类型
	 * @throws
	 */
	public void selectHotelDetialById(ModelMap model, Integer id) {

		model.addAttribute("hotelDetail", this.hotelDao.selectHotel(id));
	}

	/**
	 * 
	 * @Title: update
	 * @Description: 修改
	 * @param @param model
	 * @param @param bean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public Integer update(ModelMap model,HotelDetailBean bean) {
		try {
			hotelDao.updateHotel(bean);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return void 返回类型
	 * @throws
	 */

	
	
	public int delete(HotelDetailBean bean) {
		try{
			hotelDao.deleteHotel(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}

	/**
	 * 
	 * @Title: selectBeanByPriId
	 * @Description: 通过酒店ID查询酒店基础信息
	 * @param @param id
	 * @param @return 设定文件
	 * @return HotelDetailBean 返回类型
	 * @throws
	 */
	public void selectBeanByPriId(ModelMap model, String id) {
		if (StringUtils.isNotBlank(id)) {
			model.addAttribute("hotelDetail",this.hotelDao.selectBeanByPriId(Integer.parseInt(id)));
		}
	}

	/**
	 * @Title: setCode
	 * @Description: 放置字典
	 * @param @param model 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void setCode(ModelMap model) {
		// 星级
		model.addAttribute("startlevel",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STARTLEVEL));
		// 特色
		model.addAttribute("hotelfeatures",    this.codeService.getSystemCodeByCodeNo(DictionaryUtil.HOTELFEATURES));
		// 设施
		model.addAttribute("hotelfacilities",  this.codeService.getSystemCodeByCodeNo(DictionaryUtil.HOTELFACILITIES));
		// 休闲娱乐
		model.addAttribute("recreation",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.RECREATION));
		// 餐饮设施
		model.addAttribute("diningfacilities", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.DININGFACILITIES));
		// 信用卡
		model.addAttribute("credit",           this.codeService.getSystemCodeByCodeNo(DictionaryUtil.CREDIT));
		// 服务项目
		model.addAttribute("serviceitems",     this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SERVICEITEMS));
		// 省
		model.addAttribute("provinces",        this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
	}
	/**
	 * 
	 * @Title: selectHotel
	 * @Description: 根据主键查询指定的实体
	 * @param @param id
	 * @param @return    设定文件
	 * @return GuideDetailBean    返回签证实体对象
	 * @throws
	 */
	public HotelDetailBean selectHotel(int id){
		return hotelDao.selectHotel(id);
	}
}