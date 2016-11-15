package com.erim.sz.sametown.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.sametown.dao.TicketDetailDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: TicketDetailService
 * @描述: 门票接口
 * @作者: 李庆
 * @创建时间: 2015年10月25日 下午5:08:46
 *
 */
@Service("ticketService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TicketDetailService {

	@Autowired
	private TicketDetailDao ticketDao;
	@Autowired
	private CodeService codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;

	public void showTicket(ModelMap model, TicketDetailBean bean) {
		
		
		// 省
		model.addAttribute("provinces", this.tmSystemRegionService.getSystemCodeByCodeNo(0));
		// ///////////////////////////////// 字典设置end

		// 分页查询
		List<TicketDetailBean> ticketList = ticketDao.selectPageTicket(bean, model);
		
		//转码
		for (int i = 0; i < ticketList.size(); i++) {
			TicketDetailBean ticketBean = ticketList.get(i);
			
			
			// 所在城市
			String tdlCity = ticketBean.getTdlCity();
			if (tdlCity != null && !"".equals(tdlCity)) {
				String str = tmSystemRegionService.getSystemRegionById(Integer.valueOf(tdlCity));
				ticketBean.setTdlCity(str);
			}
			//景点级别
			String tdlScenicLevel = ticketBean.getTdlScenicLevel();
			if (!"".equals(tdlScenicLevel) && tdlScenicLevel != null) {
				String tdlScenicLevelStr = codeService.getValueByCodeKeys("C098", tdlScenicLevel);
				ticketBean.setTdlScenicLevel(tdlScenicLevelStr);
			}
			String TdlNation=ticketBean.getTdlNation();
			if(TdlNation !=null && !"".equals(TdlNation)){
				if ("01".equals(TdlNation)) {
					ticketBean.setTdlNation("香港");
				}
				if ("02".equals(TdlNation)) {
					ticketBean.setTdlNation("澳门");
				}
				if ("03".equals(TdlNation)) {
					ticketBean.setTdlNation("台湾");
				}
			}
		}
		// 回传信息
		model.put("ticketList", ticketList);
		//同城类型
    	model.addAttribute("sametownntype", ErimConstants.TOWN_TICKET);
	}
	/**
	 * @Title: 		  setCode
	 * @Description:  放置字典
	 * @param @param  model 设定文件
	 * @return 		  void 返回类型
	 * @throws
	 */
	public void setCode(ModelMap model) {
		
		
		// 景点级别
		model.addAttribute("level", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.LEVEL));
		
		// 国家  香港 澳门 台湾 国家
		model.addAttribute("state", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STATE));
	}

}
