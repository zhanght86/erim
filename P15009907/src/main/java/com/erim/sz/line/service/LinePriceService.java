package com.erim.sz.line.service;

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

import com.erim.sz.common.bean.LineDetailBean;
import com.erim.sz.common.bean.LinePriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.line.dao.LineDetailDao;
import com.erim.sz.line.dao.LinePriceDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.PriceUtil;
import com.erim.sz.web.util.Util;
import com.erim.web.service.CodeService;

/**
 * @描述: 专线量价信息实体操作业务层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月5日 下午8:27:54
 */
@Service("linePriceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class LinePriceService {
	
	@Autowired
	private LinePriceDao linePriceDao;
	@Autowired
	private LineDetailDao lineDao;
	@Autowired
	private CodeService codeService;
	
	/**
	 * @描述: 第一次进入量价日历页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:29:15
	 * @param map
	 * @param bean
	 */
	public void showLinePricePortal(ModelMap map, LinePriceBean bean) {
		
		// 专线ID
		Integer tdlId = bean.getTdlId();
		LineDetailBean detailBean = new LineDetailBean();
		detailBean.setId(tdlId);
		// 根据专线ID获取一条信息
		detailBean = lineDao.selectLine(detailBean);
		
		// 专线名称
		String tdlName = detailBean.getLdlName();
		// 存储在Session
		SecurityUtils.getSubject().getSession().setAttribute("oneId", tdlId);
		SecurityUtils.getSubject().getSession().setAttribute("tdlName", tdlName);
		
		// 年
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		
		// 返回页面需要的参数
		map.addAttribute("priceYeMon", year + " 年" + month + " 月");
	}
	
	/**
	 * @描述: 时间向前选择按钮
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:34:02
	 * @param map
	 * @param bean
	 */
	public void showListForward(ModelMap map, LinePriceBean bean) {
		
		//Session
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
		
		// 返回页面的参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
		
	}
	
	/**
	 * @描述: 时间向后选择按钮
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:34:27
	 * @param map
	 * @param bean
	 */
	public void showListBackwards(ModelMap map, LinePriceBean bean) {
		
		//Session
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
		
		// 返回页面的参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:35:25
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer insertPrice(ModelMap map, LinePriceBean bean) {
		Integer result = CommonUtil.ERROR;
		
		// 产品ID
		Integer tdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		// 产品名称
		String tdlName = (String) SecurityUtils.getSubject().getSession().getAttribute("tdlName");
		
		// 开始时间和结束时间
		String start = bean.getStart();
		String end = bean.getEnd();
		
		// 获取之间所有日期
		String[] day = DateUtil.getCountByStartEnd(start, end);
		for (int i = 0; i < day.length; i++) {
			// 当前日期
			String date = day[i];
			// 获取当前日期为周几
			String week = DateUtil.getWeekByDate(date);
			// 判断是否符合按周选择
			boolean bl = Util.isAllowAdd(bean.getWeek(), week);
			
			if (bl) {
				bean.setTdlId(tdlId); // 产品ID
				bean.setTdlName(tdlName); // 产品名称
				bean.setLpeDate(date); // 日期
				bean.setLpeWeek(week); // 星期
				bean.setCpyId(CommonUtil.getCpyId()); // 公司ID
				bean.setLpeIsOpen(ErimConstants.YESORNO_YES); // 默认出售
				bean.setLpeCreateDate(new Date()); // 创建时间
				bean.setLpeCreateUser(CommonUtil.getLoginName()); // 创建用户
				// 执行新增
				result = linePriceDao.insertPrice(bean);
			}
		}
		return result;
	}
	
	/**
	 * @方法名: refresh
	 * @描述: 刷新参数
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午4:27:11 
	 * @param map
	 * @param bean
	 */
	public void refresh(ModelMap map, LinePriceBean bean) {
		
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 查询数据列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:39:26
	 * @param map
	 * @param bean
	 */
	public void selectLinePriceList(ModelMap map, LinePriceBean bean) {
		
		List<LinePriceBean> list = new ArrayList<LinePriceBean>(42);
		List<LinePriceBean> modelList = new ArrayList<LinePriceBean>();
		
		// 获取日期
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		// 该有所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 该有天数总计
		int monthNum = DateUtil.getMonthCount(year, month);
		
		/*
		 * 根据产品ID、当前所选日期获取该日期内所有量价信息
		 */
		// 产品ID
		Integer tdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		bean.setTdlId(tdlId);
		// 量价信息
		modelList = linePriceDao.selectLinePriceList(bean, monthCount);
		
		// 日历号
		int j = 0;
		/*
		 * 根据年月，判断该月日历数据前，共有多少空格
		 */
		int weekCount = DateUtil.getWeekByDate(year, month);
		for (int i = 0; i < weekCount; i++) {
			// 填入空格
			list.add(i, new LinePriceBean());
		}
		
		/*
		 * 处理查询的量价信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询到的量价信息
			LinePriceBean model = new LinePriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 量价信息日期
				String lpeDate = model.getLpeDate();
				//　下标
				int index = j + weekCount;
				// 当前信息日期是否符合日期
				if (monthCount[j].equals(lpeDate)) {
					// 当前日期是否允许修改
					boolean bl = DateUtil.getCheckDateUpdate(lpeDate);
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
					model = new LinePriceBean();
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
			LinePriceBean model = new LinePriceBean();
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
	 * @描述: 更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:42:42
	 * @param bean
	 * @return
	 */
	public Integer updateIsOpen(LinePriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = linePriceDao.updateIsOpen(bean);
		return result;
	}
	
	/**
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:43:04
	 * @param bean
	 * @return
	 */
	public Integer updatePrice(LinePriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = linePriceDao.updatePrice(bean);
		return result;
	}
	
	/**
	 * @描述: 批量更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月5日 下午8:44:02
	 * @param bean
	 * @return
	 */
	public Integer updateBatchIsOpen(LinePriceBean bean) {
		Integer result = CommonUtil.ERROR;
		// 开始日期和结束日期
		String start = bean.getStart();
		String end = bean.getEnd();
		// 获取之间所有日期
		String[] strList = DateUtil.getCountByStartEnd(start, end);
		// 产品ID
		Integer tdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		bean.setTdlId(tdlId);
		bean.setLpeIsOpen(ErimConstants.YESORNO_NO); // 停止出售
		// 执行修改
		result = linePriceDao.updateBatchIsOpen(bean, strList);
		
		return result;
	}
}