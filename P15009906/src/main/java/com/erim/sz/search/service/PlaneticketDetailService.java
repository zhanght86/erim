package com.erim.sz.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.PlaneticketDetailBean;
import com.erim.sz.search.dao.PlaneticketDetailDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/***
 * 
 * @ClassName: PlaneticketDetailService
 * @Description: 飞机票接口
 * @author 龙龙
 * @date 2015年7月29日 下午5:40:35
 *
 */
@Service("planeticketService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class PlaneticketDetailService {

	@Autowired
	private PlaneticketDetailDao planeticketDao;
	@Autowired
	private CodeService           codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;


	public void showPlaneticket(ModelMap model, PlaneticketDetailBean bean) {

		// 分页查询
		List<PlaneticketDetailBean> planeticketList = planeticketDao
				.selectPagePlaneticket(bean, model);
		//转码
		for (int i = 0; i < planeticketList.size(); i++) {
			
			PlaneticketDetailBean detail = planeticketList.get(i);
			//舱位
			String ptdClassEconomy = detail.getPtdClassEconomy();
			if (ptdClassEconomy != null && !"".equals(ptdClassEconomy)) {
				String str = codeService.getValueByCodeKeys(DictionaryUtil.PTDSPACE, ptdClassEconomy);
				detail.setPtdClassEconomy(str);
			}
			// 城市
			String ptdStartCity = detail.getPtdStartCity();
	        if (ptdStartCity != null && !"".equals(ptdStartCity)) {
	        	String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ptdStartCity));
	        	detail.setPtdStartCity(str);
	        }
	     // 城市
 			String ptdEndCity = detail.getPtdEndCity();
 	        if (ptdEndCity != null && !"".equals(ptdEndCity)) {
 	        	String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(ptdEndCity));
 	        	detail.setPtdEndCity(str);
 	        }
		}
		

		// 回传信息
		model.put("planeticketList", planeticketList);
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
	public int insert(ModelMap model,PlaneticketDetailBean bean) {
		// 插入数据
		try{
			planeticketDao.insertPlaneticket(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	/**
	 * @Title: selectPlaneticketDetialById 
	 * @Description: 根据ID查询实体 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return TexiDetailBean    返回类型 
	 * @throws
	 */
	public void selectPlaneticketDetialById(ModelMap model,Integer id){
		
		model.addAttribute("planeticketDetail", this.planeticketDao.selectPlaneticket(id));
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
	public Integer update(ModelMap model, PlaneticketDetailBean bean) {
		try{
			planeticketDao.updatePlaneticket(bean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	/**
	 * 
	 * @Title: delete
	 * @Description: 删除
	 * @param @param id 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	public int delete(Integer id) {
		try{
		planeticketDao.deletePlaneticket(id);
		return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
	/**
	 * @Title: setCode 
	 * @Description: 放置字典 
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setCode(ModelMap model){
		//机型
    	model.addAttribute("models", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.MODELS));
    	//型标准
    	model.addAttribute("vehiclestandard", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.VEHICLESTANDARD));
    	//舱位
    	model.addAttribute("ptdspace", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.PTDSPACE));
    	//省市县
    	model.addAttribute("provinces", this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
	}

	/**
	 * 
	 * @Title: selectPlaneticket
	 * @Description: 根据主键查询指定的实体
	 * @param @param id
	 * @param @return    设定文件
	 * @returnPlaneticketDetailBean    返回签证实体对象
	 * @throws
	 */
	public PlaneticketDetailBean selectPlaneticket(int id){
		return	planeticketDao.selectPlaneticket(id);
	}
	


}
