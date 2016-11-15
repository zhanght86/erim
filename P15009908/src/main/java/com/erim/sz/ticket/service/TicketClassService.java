package com.erim.sz.ticket.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TicketClassBean;
import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.ticket.dao.TicketClassDao;
import com.erim.sz.ticket.dao.TicketDetailDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.web.service.CodeService;


/**
 * @ClassName:   ticketclassService 
 * @Description: 票类管理
 * @author		  王赛
 * @date 		 2015年10月10日 下午2:02:24 
 */
@Service("ticketclassService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TicketClassService {
	
	@Autowired
	private TicketClassDao ticketClassDao;
	@Autowired
	private TicketDetailDao ticketDao;
	@Autowired
	private CodeService codeService;
	
	/**
	 * @方法名: showTicket
	 * @描述: 票类信息列表
	 * @作者: 王赛
	 * @创建时间: 2015年11月3日 下午2:32:54 
	 * @param model
	 * @param bean
	 */
	public void showTicket(ModelMap model, TicketClassBean bean) {
		
		// 景点ID
		Integer tdlID = bean.getTdlId();
		// 根据ID查询景点信息
		TicketDetailBean detailBean = ticketDao.getTicketById(tdlID);
		model.addAttribute("detailBean", detailBean);
		if (tdlID != null) {
			SecurityUtils.getSubject().getSession().setAttribute("ticketID", tdlID);
		}else {
			tdlID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("ticketID");
			bean.setTdlId(tdlID);
		}
		// 查询票类信息列表
		List<TicketClassBean> classList = ticketClassDao.selectTicketClass(bean);	
		// 回传信息
		model.put("classList", classList);
	}

	/**
	 * 
	 * @方法名: delete
	 * @描述: 票类上下架
	 * @作者: 王赛
	 * @创建时间: 2015年11月2日 下午12:28:37 
	 * @param bean
	 * @return
	 *
	 */
	public int delete(TicketClassBean bean) {
		try {
			ticketClassDao.delete(bean);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
	
	/**
	 * @方法名: update
	 * @描述: 票类新增和修改的保存功能
	 * @作者: 王赛
	 * @创建时间: 2015年11月3日 下午2:33:37 
	 * @param bean
	 * @return
	 */
	public Integer update(TicketClassBean bean){
		
		Integer result = CommonUtil.ERROR;
		// 景点ID
		Integer tdlId = bean.getTdlId();
		// 票类ID
		Integer classID = bean.getId();
		// 票类名称
		String ticketName = bean.getTdlTicket();
		// 分割票类名称
		String name[] = ticketName.split(",");
		// 判断是否有票类ID
		if(classID == null || "".equals(classID)) {
			// 执行多条添加
			for(int i = 0; i < name.length; i++) {
				// 景点ID
				bean.setTdlId(tdlId);
				// 添加时默认添加下架，下架数据为0
				bean.setTdlDelStatus("1");
				// 添加时添加默认时间
				bean.setTdlCreattime(DateUtil.getCuurentTime());
				// 添加票类名称
				bean.setTdlTicket(name[i]);
				// 执行添加方法
				result = ticketClassDao.insertclass(bean);
			}
		} else {
			
			// 景点ID
			bean.setTdlId(tdlId);
			// 添加时默认添加下架，下架数据为0
			bean.setTdlDelStatus("1");
			// 添加时添加默认时间
			bean.setTdlCreattime(DateUtil.getCuurentTime());
			// 如果名称没有添加 则执行修改方法  否则执行添加方法
			result = ticketClassDao.update(bean);
			
			/**
			 * 注释原因:修改没有多条票类功能
			 * 修改人:宁晓强
			 * 修改时间:2015.12.01
			 */
			/** if(name.length == 1 && name[0] == ticketName) {
			} else {
				if(ticketName != null) {
					for(int i=0;i<name.length;i++) {
						bean.setTdlTicket(name[i]);
						result=ticketClassDao.insertclass(bean);
					}
				}
			} */
		}
		return result;
	}
	
	/**
	 * @描述: 票类修改、列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月1日 下午2:47:11
	 * @param model
	 * @param bean
	 */
	public void selectclassById(ModelMap model, TicketClassBean bean) {
		
		// 根据ID查询一条票类信息
		TicketClassBean classBean = ticketClassDao.selectClassend(bean);
		
		model.addAttribute("ticketclass", classBean);
	}
}
