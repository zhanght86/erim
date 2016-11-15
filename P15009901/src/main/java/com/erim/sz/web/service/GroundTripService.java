package com.erim.sz.web.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.bean.GroundTriplBean;
import com.erim.sz.web.dao.GroundDetailDao;
import com.erim.sz.web.dao.GroundTripDao;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: GroundTripService
 * @描述: 当地游行程管理
 * @作者: 王赛
 * @创建时间: 2015年11月25日 下午1:53:47
 *
 */
@Service("groundTripService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GroundTripService {
	
	@Autowired
	private GroundTripDao groundTripDao;
	@Autowired
	private GroundDetailDao groundDetailDao;
	@Autowired
	private CodeService codeService;
	
	
	/**
	 * @描述: 当地游修改界面进入行程管理页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月16日 下午2:23:45
	 * @param tdlId
	 * @param model
	 */
	public List<GroundTriplBean> getTripUpdatePage(Integer tdlId,ModelMap model) {
		// 产品ID
		model.addAttribute("tdlId", tdlId);
		// 根据产品ID获取行程管理信息
		List<GroundTriplBean> list = groundTripDao.getTripByTdlId(tdlId);
		for(GroundTriplBean trip : list){
			//路线
			String lineup = trip.getGddLineup();
			if(StringUtils.isNotBlank(lineup)){
				String[] alineup = lineup.split(",");
				trip.setAgddLineup(alineup);
			}
			//工具
			String tool = trip.getGddTool();
			if(StringUtils.isNotBlank(tool)){
				String[] atool = tool.split(",");
				trip.setAgddTool(atool);
			}
		}
		// 行程管理列表
		model.addAttribute("groundtrip", list);
		return list;
		
	}
}