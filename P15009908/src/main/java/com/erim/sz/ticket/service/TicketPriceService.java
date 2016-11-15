package com.erim.sz.ticket.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TicketClassBean;
import com.erim.sz.common.bean.TicketDetailBean;
import com.erim.sz.common.bean.TicketPriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.ticket.dao.TicketClassDao;
import com.erim.sz.ticket.dao.TicketDetailDao;
import com.erim.sz.ticket.dao.TicketPriceDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.PriceUtil;

/**
 * @类名: TicketPriceService
 * @描述: 门票量价管理信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年10月17日 上午10:48:03
 */
@Service("ticketPriceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TicketPriceService {

	@Autowired
	private TicketPriceDao ticketPriceDao;
	@Autowired
	private TicketDetailDao ticketDao;
	@Autowired
	private TicketClassDao ticketClassDao;
	
	/**
	 * @描述: 根据条件查询票类信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月21日 上午11:34:18
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer getTicketClassNum(ModelMap map, TicketClassBean bean) {
		
		// 根据产品ID查询所有票类信息
		List<TicketClassBean> classList = ticketClassDao.selectTicketClass(bean);
		// 票类数量
		int classNum = classList.size();
		if (classNum != 0) {
			return CommonUtil.SUCCESS;
		} else {
			return CommonUtil.TICKETNOTCLASS;
		}
	}
	
	/**
	 * @描述: 选择票类ID
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月22日 上午11:12:06
	 * @param map
	 * @param bean
	 */
	public void skipTicketClass(ModelMap map, TicketPriceBean bean) {
		// 票类ID - 当前选中的
		Integer id = bean.getTclId();
		SecurityUtils.getSubject().getSession().setAttribute("tclId", id);
		
		// Session中（也就是页面中）的年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 同业资源查看量价列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月21日 下午2:18:19
	 * @param map
	 * @param bean
	 */
	public void showClassPricePortal(ModelMap map, TicketPriceBean bean) {
		// 产品ID
		Integer tdlId = bean.getTdlId();
		SecurityUtils.getSubject().getSession().setAttribute("tdlId", tdlId);
		
		// 产品名称
		TicketDetailBean detailBean = ticketDao.getTicketById(tdlId);
		SecurityUtils.getSubject().getSession().setAttribute("tdlName", detailBean.getTdlName());
		
		// 根据产品ID查询所有票类信息
		TicketClassBean classBean = new TicketClassBean();
		classBean.setTdlId(tdlId);
		List<TicketClassBean> classList = ticketClassDao.selectTicketClass(classBean);
		// 票类信息字典
		SecurityUtils.getSubject().getSession().setAttribute("classList", classList);
		
		// 票类ID
		Integer tclId = null;
		if (bean.getTclId() != null) {
			tclId = bean.getTclId();
		} else {
			tclId = classList.get(0).getId();
		}
		SecurityUtils.getSubject().getSession().setAttribute("tclId", tclId);
		
		// 当前年月
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		// 存入Session,以便接下来使用
		if (year != null && month != null && !"".equals(year) && !"".equals(month)) {
			SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
			SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		}
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @方法名: showTicketPricePortal
	 * @描述: 门票量价管理列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午1:17:07 
	 * @param map
	 * @param bean
	 */
	public void showTicketPricePortal(ModelMap map, TicketPriceBean bean) {
		
		// 获取票类ID
		Integer tclId = bean.getTclId();
		SecurityUtils.getSubject().getSession().setAttribute("tclId", tclId);
		TicketClassBean classBean = new TicketClassBean();
		classBean.setId(tclId);
		
		// 根据票类ID查询一条票类信息
		classBean = ticketClassDao.selectClassend(classBean);
		
		// 获取票类名称
		String tclName = classBean.getTdlTicket();
		SecurityUtils.getSubject().getSession().setAttribute("tclName", tclName);
		
		// 获取门票ID
		Integer tdlId = bean.getTdlId();
		SecurityUtils.getSubject().getSession().setAttribute("tdlId", tdlId);
		
		// 产品名称
		TicketDetailBean detailBean = ticketDao.getTicketById(tdlId);
		SecurityUtils.getSubject().getSession().setAttribute("tdlName", detailBean.getTdlName());
		
		// 当前年月
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		
		// 存入Session,以便接下来使用
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		
		// 返回页面需要的参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @方法名: showListForward
	 * @描述: 时间向前选择按钮
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午1:27:45 
	 * @param map
	 * @param bean
	 */
	public void showListForward(ModelMap map, TicketPriceBean bean) {
		
		// Session（也就是页面）中的年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 执行时间向前选择
		Map<String, Object> dateMap = PriceUtil.dateForward(year, month);
		year = (String) dateMap.get("year");
		month = (String) dateMap.get("month");
		
		// 存入Session,以便接下来操作使用
		if (year != null && !"".equals(year) && month != null && !"".equals(month)) {
			SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
			SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		}
		// 页面需要的参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @方法名: showListBackwards
	 * @描述: 时间向后选择按钮
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午1:29:19 
	 * @param map
	 * @param bean
	 */
	public void showListBackwards(ModelMap map, TicketPriceBean bean) {
		
		// Session（也就是页面）中的年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 执行时间向后选择
		Map<String, Object> dateMap = PriceUtil.dateBackwards(year, month);
		year = (String) dateMap.get("year");
		month = (String) dateMap.get("month");
		
		// 存入Session,以便接下来操作使用
		if (year != null && !"".equals(year) && month != null && !"".equals(month)) {
			SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
			SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		}
		// 页面需要的参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @方法名: insertPrice
	 * @描述: 新增量价
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午1:31:33 
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer insertPrice(ModelMap map, TicketPriceBean bean) {
		
		// 操作结果定义
		Integer result = CommonUtil.ERROR;
		// 票类ID
		Integer tclId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("tclId");
		// 票类名称
		String tclName = (String) SecurityUtils.getSubject().getSession().getAttribute("tclName");
		// 产品ID
		Integer tdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("tdlId");
		// 开始时间和结束时间
		String start = bean.getStart();
		String end = bean.getEnd();
		// 获取之间所有日期
		String[] day = DateUtil.getCountByStartEnd(start, end);
		Integer state = 0;
		for (int i = 0; i < day.length; i++) {
			// 当前日期
			String tplDate = day[i];
			// 获取当前日期为周几
			String week = DateUtil.getWeekByDate(tplDate);
			// 判断是否符合按周选择条件
			boolean bl = PriceUtil.isAllowAdd(bean.getWeek(), week);
			if (bl) {
				// 第一条可录入日期
				if (state == 0) {
					// 获取初次录入日期的年月信息
					PriceUtil.getFirstDate(tplDate, map);
				}
				state = 1;
				bean.setTdlId(tdlId); // 门票ID
				bean.setTclId(tclId); // 票类ID
				bean.setTclType(tclName); // 票类名称
				bean.setTplDate(tplDate); // 日期
				bean.setTplWeek(week); // 星期
				bean.setCpyId(CommonUtil.getCpyId()); // 公司ID
				bean.setTplIsOpen(ErimConstants.YESORNO_YES); // 是否出售
				bean.setTplCreateUser(CommonUtil.getLoginName()); // 创建用户
				bean.setTplCreateTime(new Date()); // 创建时间
				// 执行新增
				result = savePrice(bean);
			}
		}
		// 没有任何可添加的日期
		if (state == 0) {
			//　如果只是无可新增日期，返回没有可添加的日期
			result = CommonUtil.NOTHAVE;
		}
		return result;
	}
	
	/**
	 * @描述: 保存量价信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月19日 下午4:35:33
	 * @param bean
	 * @return
	 */
	public Integer savePrice(TicketPriceBean bean) {
		// 操作状态
		Integer result = CommonUtil.ERROR;
		// 根据票类ID，录入日期判断是否存在该条信息
		TicketPriceBean priceBean = ticketPriceDao.getPriceByClassDate(bean);
		if (priceBean != null) {
			// 能搜到量价信息，即为修改
			bean.setId(priceBean.getId());
			result = ticketPriceDao.update(bean);
		} else {
			// 无量价信息，新增
			result = ticketPriceDao.insertTicketPrice(bean);
		}
		return result;
	}
	
	/**
	 * @方法名: refresh
	 * @描述: 不修改任何页面参数，纯刷新
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午1:58:56 
	 * @param map
	 * @param bean
	 */
	public void refresh(ModelMap map, TicketPriceBean bean) {
		
		// Session中（也就是页面中）的年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @方法名: selectTicketPriceList
	 * @描述: 查询数据
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午4:03:54 
	 * @param map
	 * @param bean
	 */
	public void selectTicketPriceList(ModelMap map, TicketPriceBean bean) {
		List<TicketPriceBean> list = new ArrayList<TicketPriceBean>(42);
		List<TicketPriceBean> modelList = new ArrayList<TicketPriceBean>();
		
		// 获取日期
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		// 该有所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 该有所有天数总计
		int monthNum = DateUtil.getMonthCount(year, month);
		
		/*
		 * 根据票类ID、当前所选日期获取该日期内所有量价信息
		 */
		//票类ID
		Integer tclId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("tclId");
		bean.setTclId(tclId);
		// 该月量价信息
		modelList = ticketPriceDao.selectTicketPriceList(bean, monthCount);
		
		// 日历号
		int j = 0;
		/*
		 * 根据年月，判断该月日历数据前，共有多少空格
		 */
		int weekCount = DateUtil.getWeekByDate(year, month);
		for (int i = 0; i < weekCount; i++) {
			// 填入空格
			list.add(i, new TicketPriceBean());
		}
		
		/*
		 * 处理查询的量价信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询到的量价信息
			TicketPriceBean model = new TicketPriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 量价信息日期
				String tplDate = model.getTplDate();
				// 下标
				int index = j + weekCount;
				// 当前信息日期是否符合日期
				if (monthCount[j].equals(tplDate)) {
					// 当前日期是否允许修改
					boolean bl = DateUtil.getCheckDateUpdate(tplDate);
					// 允许修改
					if (bl) {
						model.setIsUpdate(ErimConstants.YESORNO_YES);
					} else {
						model.setIsUpdate(ErimConstants.YESORNO_NO);
					}
					// 塞进List
					model.setDay(j + 1 + "");
					list.add(index, model);
				} else {
					// 不符合
					i--;
					model = new TicketPriceBean();
					model.setDay(j + 1 + "");
					list.add(index, model);
				}
				j++;
			}
		}
		
		/*
		 * 填充日历中剩余的空格，凑满42个
		 */
		// 日历中已有的格数
		int priceSize = list.size();
		// 剩余格数
		int blankCount = 42 - priceSize;
		// 填入空值
		for (int i = 0; i < blankCount; i++) {
			// 下标
			int index = priceSize + i;
			TicketPriceBean model = new TicketPriceBean();
			// 日历
			if (j < monthNum) {
				model.setDay(j + 1 + "");
				list.add(index, model);
				j++;
			} else {
				list.add(index, model);
			}
		}
		map.addAttribute("priceList", list);
	}
	
	/**
	 * @方法名: updateIsOpen
	 * @描述: 更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午2:28:59 
	 * @param bean
	 * @return
	 */
	public Integer updateIsOpen(TicketPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = ticketPriceDao.updateIsOpen(bean);
		return result;
	}
	
	/**
	 * @方法名: updatePrice
	 * @描述: 更改量价信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午2:30:17 
	 * @param bean
	 * @return
	 */
	public Integer updatePrice(TicketPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		String isSign = bean.getTplIsSign();
		// 当不限量时
		if (ErimConstants.YESORNO_NO.equals(isSign)) {
			bean.setTplSign(null);
		}
		result = ticketPriceDao.updateTicketPrice(bean);
		return result;
	}
	
	/**
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月17日 下午2:32:02 
	 * @param bean
	 * @return
	 */
	public Integer updateBatchIsOpen(TicketPriceBean bean, ModelMap map) {
		Integer result = CommonUtil.ERROR;
		// 开始日期和结束日期
		String start = bean.getStart();
		String end = bean.getEnd();
		// 获取初次录入日期的年月信息
		PriceUtil.getFirstDate(start, map);
		// 获取之间所有日期
		String[] strList = DateUtil.getCountByStartEnd(start, end);
		// 票类ID
		Integer tclId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("tclId");
		bean.setTclId(tclId);
		bean.setTplIsOpen(ErimConstants.YESORNO_NO); // 停止出售
		// 执行修改
		result = ticketPriceDao.updateBatchIsOpen(bean, strList);
		return result;
	}
}