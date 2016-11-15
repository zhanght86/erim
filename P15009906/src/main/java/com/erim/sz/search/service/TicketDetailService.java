package com.erim.sz.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TicketClassBean;
import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.common.bean.TicketPriceBean;
import com.erim.sz.search.dao.TicketClassDao;
import com.erim.sz.search.dao.TicketDetailDao;
import com.erim.sz.search.dao.TicketPriceDao;
import com.erim.sz.tm.service.TmSystemRegionService;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/**
 * 
 * @类名: TicketDetailService
 * @描述: 门票接口
 * @作者: 李庆
 * @创建时间: 2015年10月29日 下午12:13:29
 *
 */
@Service("ticketService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TicketDetailService {

	@Autowired
	private TicketDetailDao       ticketDao;
	@Autowired
	private TicketPriceDao		  ticketPriceDao;
	@Autowired
	private CodeService           codeService;
	@Autowired
	private TmSystemRegionService tmSystemRegionService;
	@Autowired
	private TicketClassDao		  ticketClassDao;

	public void showTicket(ModelMap model, TicketDetailBean bean) {
		//----------------字典设置-------------------//
		//省
		model.addAttribute("provinces",this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		
		//后去国内国际的值
    	String tdlWithinOrOuter = bean.getTdlWithinOrOuter();
    	if(null != tdlWithinOrOuter && !"".equals(tdlWithinOrOuter)){
    		// 国内
        	if ("01".equals(tdlWithinOrOuter)) {
        		// 清空港澳台，国家，国外城市
        		bean.setTdlNation(null);
        		bean.setTdlCountyone(null);
        		bean.setTdlCityone(null);
        	} else if ("02".equals(tdlWithinOrOuter)) {
        		// 清空省市县
        		bean.setTdlProvince(null);
        		bean.setTdlCity(null);
        		bean.setTdlCounty(null);
        	}
    	}
		// 分页查询
		List<TicketDetailBean> ticketList = ticketDao.selectPageTicket(bean,model);
		for (TicketDetailBean t : ticketList) {
			List<TicketClassBean> resultList = this.ticketClassDao.selectTicketClass(t.getId());
			t.setListTicketClass(resultList);
			
			
			//遍历房型 返回房间号
			StringBuffer cid = new StringBuffer();
			if(null != resultList && resultList.size()>0){
				for(TicketClassBean hdb : resultList){
					//cid += hdb.getId()+",";
					cid.append(hdb.getId()).append(",");
				}
			}
			if(null != cid && cid.length()>0 && (cid.lastIndexOf(",") == cid.length()-1)){
				cid.deleteCharAt(cid.length()-1);
			}
			t.setAllClassId(cid.toString());
		}
		

		// 回传信息
		model.put("ticketList", ticketList);
	}
	/**
	 * @Title: setCode
	 * @Description: 放置字典
	 * @param @param model 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void setCode(ModelMap model) {
		// 省市县
		model.addAttribute("provinces", this.tmSystemRegionService.getSystemCodeListByCodeNo(100000));
		// 信用卡
		model.addAttribute("credit",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.CREDIT));
		// 景点级别
		model.addAttribute("level", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.LEVEL));
		//主题
		model.addAttribute("attractions", this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ATTRACTIONS));

	}

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
	public List<TicketPriceBean> listTicketPrice(TicketPriceBean priceBean){
		return this.ticketPriceDao.selectTicketPrice(priceBean);
	}
}
