package com.erim.sz.texi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TexiDriveBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.texi.dao.TexiDriveDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: TexiDriveService
 * @Description: 自驾接口
 * @author 王赛
 * @date 2015年10月1日 上午4:02:24
 */
@Service("texiDriveService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TexiDriveService {
	
	@Autowired
	private TexiDriveDao texiDriveDao;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;

	/**
	 * @方法名: selectTextDriveByTxiId
	 * @描述: 根据车辆id查询自驾信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月12日 下午4:49:24 
	 * @param texiDriveBean
	 * @param model
	 */
	public void getTextDriveById(TexiDriveBean bean, ModelMap model) {
		
		// 租车ID
		Integer tdlId = bean.getTdlId();
		// 根据ID获取一条数据
		TexiDriveBean detail = texiDriveDao.getTextDriveById(tdlId);
		/*
		 * 当没有获取到数据时，则手动赋值租车ID
		 * 因为：接下来返回的页面是修改新增共用页面，所以无论新增or修改，租车ID都是必须得。
		 */
		if (detail == null) {
			detail = new TexiDriveBean();
			// 车辆ID
			detail.setTdlId(tdlId);
			// 是否自驾
			detail.setZjlType(ErimConstants.YESORNO_YES);
			// 是否异地换车
			detail.setZjlPlaceCar(ErimConstants.YESORNO_YES);
			// 半天取车地点
			detail.setZjlHfTakePlace(ErimConstants.YESORNO_YES);
			// 半天还车地点
			detail.setZjlHfBackPlace(ErimConstants.YESORNO_YES);
			// 全天取车地点
			detail.setZjlTakePlace(ErimConstants.YESORNO_YES);
			// 全天还车地点
			detail.setZjlBackPlace(ErimConstants.YESORNO_YES);
			// 省
			detail.setZjlProvince("1");
			// 市
			detail.setZjlCity("0");
		}
		model.addAttribute("texiDrive", detail);
		//省市
		model.addAttribute("provinces", tmSystemRegionService.getSystemCodeListByCodeNo(100000));
	}

	/**
	 * @Title: update 
	 * @Description: 更新
	 * @param bean
	 * @param 设定文件 
	 * @return Integer 返回类型 
	 */
	public Integer update(TexiDriveBean bean) {
		Integer result = CommonUtil.ERROR;
		// 租车自驾ID
		Integer driveID = bean.getId();
		if (driveID == null) {
			result = texiDriveDao.insert(bean);
		} else {
			result = texiDriveDao.update(bean);
		}
		return result;
	}
}
