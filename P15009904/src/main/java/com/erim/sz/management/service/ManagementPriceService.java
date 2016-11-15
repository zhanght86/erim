package com.erim.sz.management.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.ManagementDetailBean;
import com.erim.sz.common.bean.ManagementPriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.management.dao.ManagementDetailDao;
import com.erim.sz.management.dao.ManagementPriceDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.PriceUtil;

/**
 * @描述: 签证量价管理信息实体操作业务层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月7日 下午2:38:28
 */
@Service("managementPriceService")
public class ManagementPriceService {

	@Autowired
	private ManagementPriceDao managementPriceDao;
	@Autowired
	private ManagementDetailDao managementDao;
	
	/**
	 * @描述: 初始化量价
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午2:38:23
	 * @param map
	 * @param bean
	 */
	public void managementPricePortal(ModelMap map, ManagementPriceBean bean) {
		// 产品ID
		Integer mdlId = bean.getMdlId();
		// 根据签证ID查询一条签证信息
		ManagementDetailBean detailBean = managementDao.selectManagement(mdlId);
		
		// 产品名称
		String mdlName = detailBean.getMdlName();
		
		// 存储在Session
		SecurityUtils.getSubject().getSession().setAttribute("oneId", mdlId);
		SecurityUtils.getSubject().getSession().setAttribute("oneName", mdlName);
		
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		
		// 返回页面的参数
		map.addAttribute("mdlName", mdlName);
		map.addAttribute("priceYeMon", year + " 年" + month + " 月");
	}
	
	/**
	 * @描述: 时间向前选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午2:43:21
	 * @param map
	 * @param bean
	 */
	public void showListForward(ModelMap map, ManagementPriceBean bean) {
		
		// Session
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
		
		// 产品名称
		String mdlName = (String) SecurityUtils.getSubject().getSession().getAttribute("oneName");
		// 返回页面的参数
		map.addAttribute("mdlName", mdlName);
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 时间向后选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午2:43:07
	 * @param map
	 * @param bean
	 */
	public void showListBackwards(ModelMap map, ManagementPriceBean bean) {
		
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
		
		// 产品名称
		String mdlName = (String) SecurityUtils.getSubject().getSession().getAttribute("oneName");
		// 返回页面的参数
		map.addAttribute("mdlName", mdlName);
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 新增
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午4:00:09
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer insertPrice(ModelMap map, ManagementPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		// 产品ID
		Integer mdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		// 产品名称
		String mdlName = (String) SecurityUtils.getSubject().getSession().getAttribute("oneName");
		
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
				state = 1;
				bean.setMdlId(mdlId);
				bean.setMdlName(mdlName);
				bean.setMdlDate(date);
				bean.setMdlWeek(week);
				bean.setMdlIsOpen(ErimConstants.YESORNO_YES);
				bean.setMdlCreateTime(new Date());
				bean.setMdlCreateUser(CommonUtil.getLoginName());
				
				// 新增
				result = managementPriceDao.insertPrice(bean);
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
	 * @描述: 刷新参数
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午2:52:26
	 * @param map
	 * @param bean
	 */
	public void refresh(ModelMap map, ManagementPriceBean bean) {
		// 产品名称
		String mdlName = (String) SecurityUtils.getSubject().getSession().getAttribute("oneName");
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		map.addAttribute("mdlName", mdlName);
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 查询
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午2:53:08
	 * @param map
	 * @param bean
	 */
	public void selectManagementPriceList(ModelMap map, ManagementPriceBean bean) {
		List<ManagementPriceBean> list = new ArrayList<ManagementPriceBean>(42);
		List<ManagementPriceBean> modelList = new ArrayList<ManagementPriceBean>();
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
		Integer mdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
		bean.setMdlId(mdlId);
		// 量价信息
		modelList = managementPriceDao.selectManagementPriceList(bean, monthCount);
		// 日历号
		int j = 0;
		/*
		 * 根据年月，判断该月日历数据前，共有多少空格
		 */
		int weekCount = DateUtil.getWeekByDate(year, month);
		for (int i = 0; i < weekCount; i++) {
			// 填入空格
			list.add(i, new ManagementPriceBean());
		}
		/*
		 * 处理查询的价格信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理信息
			ManagementPriceBean model = new ManagementPriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 量价信息日期
				String gpeDate = model.getMdlDate();
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
					model = new ManagementPriceBean();
					model.setDay(j + 1 + "");
					list.add(index, model);
				}
				j++;
			}
		}
		/*
		 * 填充日历中剩余的空格，凑满42个
		 */
		// 日历中已有的个数
		int priceSize = list.size();
		// 剩余格数
		int blankCount = 42 - priceSize;
		// 填入空值
		for (int i = 0; i < blankCount; i++) {
			// 下标
			int index = priceSize + i;
			ManagementPriceBean model = new ManagementPriceBean();
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
	 * @描述: 修改
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月7日 下午3:01:19
	 * @param bean
	 * @return
	 */
	public Integer updatePrice(ManagementPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = managementPriceDao.updatePrice(bean);
		return result;
	}
}
