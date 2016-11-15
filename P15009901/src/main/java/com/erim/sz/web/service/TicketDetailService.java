package com.erim.sz.web.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.web.bean.TmSystemRegionBean;
import com.erim.sz.web.dao.TicketDetailDao;
import com.erim.sz.web.util.DateUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @ClassName: TicketDetailService
 * @Description: 门票接口
 * @author 陈鹏
 * @date 2015年7月29日 下午8:02:48
 *
 */
@Service("ticketService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TicketDetailService {

	@Autowired
	private TicketDetailDao     ticketDao;
	@Autowired
	private LineDetailService   lineDetailService;
	@Autowired
	private CodeService codeService;
	@Autowired 
	private TmSystemRegionService tmSystemRegionService;
	
	public void showTicket(ModelMap model, TicketDetailBean bean, Integer limit) {
		//首页搜索传的值tdlCityVo 国内城市
		if(StringUtils.isNotEmpty(bean.getTdlCityVo())){
			if("香港".equals(bean.getTdlCityVo())){
				bean.setTdlNation("01");
			}else if("澳门".equals(bean.getTdlCityVo())){
				bean.setTdlNation("02");
			}else if("台湾".equals(bean.getTdlCityVo())){
				bean.setTdlNation("03");
			}else{
				TmSystemRegionBean tmBean = new TmSystemRegionBean();
				tmBean.setRegionName(bean.getTdlCityVo());
				TmSystemRegionBean TmSystemRegionBean = tmSystemRegionService.getSystemRegionByRegionName(tmBean);
				bean.setTdlCity(TmSystemRegionBean.getRegionNo());
				bean.setTdlProvince(TmSystemRegionBean.getRegionPid()+"");
			}
		}
		//首页搜索项传的值tdlCityone 国际城市
		if(StringUtils.isNotEmpty(bean.getTdlCityone())){
			if("香港".equals(bean.getTdlCityone())){
				bean.setTdlNation("01");
				bean.setTdlCityone(null);
			}else if("澳门".equals(bean.getTdlCityone())){
				bean.setTdlNation("02");
				bean.setTdlCityone(null);
			}else if("台湾".equals(bean.getTdlCityone())){
				bean.setTdlNation("03");
				bean.setTdlCityone(null);
			}else{
				bean.setTdlNation("04");
			}
			
		}
		
		if(StringUtils.isEmpty(bean.getTplDate())){
			bean.setTplDate(DateUtil.getCuurentDate());
    	}
		// 分页查询
		List<TicketDetailBean> ticketList = ticketDao.selectPageTicket(bean, model, limit);
		/*字典转码*/
		for(int i = 0;i < ticketList.size();i++){
			//门票景区级别
			TicketDetailBean ticketBean = ticketList.get(i);
			String tdlScenicLevel = ticketBean.getTdlScenicLevel();
			if (!"".equals(tdlScenicLevel) && tdlScenicLevel != null) {
				String tdlScenicLevelStr = codeService.getValueByCodeKeys("C098", tdlScenicLevel);
				if(tdlScenicLevelStr != null && tdlScenicLevelStr.contains("不分级")){
					tdlScenicLevelStr = "";
				}
				ticketBean.setTdlScenicLevel(tdlScenicLevelStr);
			}
		} 
		// 回传信息
		model.put("ticketList", ticketList);
		model.put("tdlNation", bean.getTdlNation());
		this.lineDetailService.selectHotLine(model);
		this.selectHoteTicket(model);
	}

	/**
	 * 
	 * @Title: selectBeanByPriId @Description: 通过酒店ID查询酒店基础信息 @param @param
	 * id @param @return 设定文件 @return TicketDetailBean 返回类型 @throws
	 */
	public void selectBeanByPriId(ModelMap model, Integer id) {
		TicketDetailBean  datail = ticketDao.selectTicket(id);
		
		/*字典转码*/
		//景点主题
		String tdlAttractions = datail.getTdlAttractions();
		if (!"".equals(tdlAttractions) && tdlAttractions != null) {
			String Str = codeService.getValueByCodeKeys("C099", tdlAttractions);
			datail.setTdlAttractions(Str);
		}
		//景点级别
		String ScenicLevel = datail.getTdlScenicLevel();
		if (!"".equals(ScenicLevel) && ScenicLevel != null) {
			String Str = codeService.getValueByCodeKeys("C098", ScenicLevel);
			datail.setTdlScenicLevel(Str);
		}
		model.addAttribute("ticketDetail", datail);
	}
	
	
	/**
	 * @Title: selectHoteTicket 
	 * @Description: 查询热门门票
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void selectHoteTicket(ModelMap model){
		model.addAttribute("hotticket", this.ticketDao.selectHoteTicket());
	}
}