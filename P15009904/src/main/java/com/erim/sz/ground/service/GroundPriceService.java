package com.erim.sz.ground.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.bean.GroundPriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.ground.dao.GroundDetailDao;
import com.erim.sz.ground.dao.GroundPriceDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.PriceUtil;

/**
 * @类名: GroundPriceService
 * @描述: 当地游量价管理信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年10月25日 上午10:07:11
 */
@Service("groundPriceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class GroundPriceService {

	@Autowired
	private GroundPriceDao groundPriceDao;
	@Autowired
	private GroundDetailDao groundDetailDao;
	
	/**
	 * @描述: 当地游管理-量价页面初始化
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月25日 下午4:04:19
	 * @param map
	 * @param bean
	 */
	public void showGroundPricePortal(ModelMap map, GroundPriceBean bean) {
		
		// 产品ID
		Integer gdlId = bean.getGdlId();
		GroundDetailBean detailBean = groundDetailDao.selectById(gdlId);
		// 产品名称
		SecurityUtils.getSubject().getSession().setAttribute("gdlName", detailBean.getGddName());
		
		// 产品ID
		SecurityUtils.getSubject().getSession().setAttribute("oneId", gdlId);
		
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		
		// 返回页面的参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
		
	}
	
	/**
	 * 
	 * @方法名: showListForward
	 * @描述: 时间向前选择按钮
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午1:39:07 
	 * @param map
	 * @param bean
	 *
	 */
	public void showListForward(ModelMap map, GroundPriceBean bean) {
		
		//Session
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		int yearInt = Integer.valueOf(year);
		int monthInt = Integer.valueOf(month);
		if (monthInt == 12) {
			yearInt++;
			monthInt = 1;
		} else {
			monthInt++;
		}
		year = Integer.toString(yearInt);
		month = Integer.toString(monthInt);
		// 存入Session,以便接下来操作使用
		if (year != null && !"".equals(year) && month != null && !"".equals(month)) {
			SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
			SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		}
		
		// 返回页面的参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
		
	}
	
	/**
	 * 
	 * @方法名: showListBackwards
	 * @描述: 时间向后选择按钮
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午1:38:52 
	 * @param map
	 * @param bean
	 *
	 */
	public void showListBackwards(ModelMap map, GroundPriceBean bean) {
		
		//Session
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		int yearInt = Integer.valueOf(year);
		int monthInt = Integer.valueOf(month);
		if (monthInt == 1) {
			yearInt--;
			monthInt = 12;
		} else {
			monthInt--;
		}
		year = Integer.toString(yearInt);
		month = Integer.toString(monthInt);
		// 存入Session,以便接下来操作使用
		if (year != null && !"".equals(year) && month != null && !"".equals(month)) {
			SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
			SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		}
		
		// 返回页面的参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
		
	}
	
	/**
	 * 
	 * @方法名: insertPrice
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午5:37:29 
	 * @param map
	 * @param bean
	 * @return
	 *
	 */
	public Integer insertPrice(ModelMap map, GroundPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		
		// 产品ID
		Integer gdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		// 产品名称
		String gdlName = (String) SecurityUtils.getSubject().getSession().getAttribute("gdlName");
		
		// 开始时间和结束时间
		String start = bean.getStart();
		String end = bean.getEnd();
		
		// 获取之间所有日期
		String[] day = DateUtil.getCountByStartEnd(start, end);
		
		Integer state = 0;
		for (int i = 0; i < day.length; i++) {
			// 当前日期
			String date = day[i];
			// 获取当前日期为周几
			String week = DateUtil.getWeekByDate(date);
			// 判断是否符合按周选择
			boolean bl = PriceUtil.isAllowAdd(bean.getWeek(), week);
			
			if (bl) {
				// 第一条可录入日期
				if (state == 0) {
					// 获取初次录入日期的年月信息
					PriceUtil.getFirstDate(date, map);
				}
				// 是否有可录入日期
				state = 1;
				bean.setGdlId(gdlId); // 产品ID
				bean.setGdlName(gdlName); // 产品名称
				bean.setGpeDate(date); // 日期
				bean.setGpeWeek(week); // 星期
				bean.setCpyId(CommonUtil.getCpyId()); // 公司ID
				bean.setGpeIsOpen(ErimConstants.YESORNO_YES); // 默认出售
				bean.setGpeCreateTime(new Date()); // 创建时间
				bean.setGpeCreateUser(CommonUtil.getLoginName()); // 创建用户
				// 执行新增
				result = groundPriceDao.insertPrice(bean);
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
	 * 
	 * @方法名: refresh
	 * @描述: 刷新参数
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午4:27:11 
	 * @param map
	 * @param bean
	 *
	 */
	public void refresh(ModelMap map, GroundPriceBean bean) {
		
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * 
	 * @方法名: selectGroundPriceList
	 * @描述: 
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午4:27:51 
	 * @param map
	 * @param bean
	 *
	 */
	public void selectGroundPriceList(ModelMap map, GroundPriceBean bean) {
		
		List<GroundPriceBean> list = new ArrayList<GroundPriceBean>(42);
		List<GroundPriceBean> modelList = new ArrayList<GroundPriceBean>();
		
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
		Integer gdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		bean.setGdlId(gdlId);
		// 量价信息
		modelList = groundPriceDao.selectGroundPriceList(bean, monthCount);
		
		// 日历号
		int j = 0;
		/*
		 * 根据年月，判断该月日历数据前，共有多少空格
		 */
		int weekCount = DateUtil.getWeekByDate(year, month);
		for (int i = 0; i < weekCount; i++) {
			// 填入空格
			list.add(i, new GroundPriceBean());
		}
		
		/*
		 * 处理查询的量价信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询到的量价信息
			GroundPriceBean model = new GroundPriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 量价信息日期
				String gpeDate = model.getGpeDate();
				//　下标
				int index = j + weekCount;
				// 当前信息日期是否符合日期
				if (monthCount[j].equals(gpeDate)) {
					// 当前日期是否允许修改
					boolean bl = DateUtil.getCheckDateUpdate(gpeDate);
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
					model = new GroundPriceBean();
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
			GroundPriceBean model = new GroundPriceBean();
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
	 * 
	 * @方法名: updateIsOpen
	 * @描述: 更改出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午4:53:02 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateIsOpen(GroundPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = groundPriceDao.updateIsOpen(bean);
		return result;
	}
	
	/**
	 * 
	 * @方法名: updatePrice
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午4:54:00 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updatePrice(GroundPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = groundPriceDao.updatePrice(bean);
		return result;
	}
	
	/**
	 * 
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月25日 下午4:57:47 
	 * @param bean
	 * @return
	 *
	 */
	public Integer updateBatchIsOpen(GroundPriceBean bean, ModelMap map) {
		Integer result = CommonUtil.ERROR;
		// 开始日期和结束日期
		String start = bean.getStart();
		String end = bean.getEnd();
		// 获取初次录入日期的年月信息
		PriceUtil.getFirstDate(start, map);
		// 获取之间所有日期
		String[] strList = DateUtil.getCountByStartEnd(start, end);
		// 产品ID
		Integer gdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		bean.setGdlId(gdlId);
		bean.setGpeIsOpen(ErimConstants.YESORNO_NO); // 停止出售
		// 执行修改
		result = groundPriceDao.updateBatchOpen(bean, strList);
		
		return result;
	}
}
