package com.erim.sz.texi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TexiSendPriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.texi.dao.TexiSendPriceDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.PriceUtil;
import com.erim.web.service.CodeService;

/**
 * @类名: TexiSendPriceService
 * @描述: 租车管理包车量价管理信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年10月13日 下午4:51:43
 */
@Service("texiSendPriceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TexiSendPriceService {

	@Autowired
	private TexiSendPriceDao texiSendPriceDao;
	@Autowired
	private CodeService codeService;
	
	/**
	 * @方法名: showSendPricePortal
	 * @描述: 固定线路量价管理列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午5:17:35 
	 * @param map
	 * @param bean
	 */
	public void showSendPricePortal(ModelMap map, TexiSendPriceBean bean) {
		
		Integer sendId = bean.getSendId();
		if (sendId != null && !"".equals(sendId)) {
			SecurityUtils.getSubject().getSession().setAttribute("sendID", sendId);
		}
		// 当前年月
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
		// 接送类型转码
		setCode(map, bean);
	}
	
	/**
	 * @方法名: showListForward
	 * @描述: 时间向前选择刷新列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午6:44:07 
	 * @param map
	 * @param bean
	 */
	public void showListForward(ModelMap map, TexiSendPriceBean bean) {
		
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 转换到下个月
		int yearInt = Integer.valueOf(priceYear);
		int monthInt = Integer.valueOf(priceMonth);
		if (monthInt == 12) {
			yearInt++;
			monthInt = 1;
		} else {
			monthInt++;
		}
		priceYear = Integer.toString(yearInt);
		priceMonth = Integer.toString(monthInt);
		// 存入Session
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", priceYear);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", priceMonth);
		
		// 当前年月，放进map
		map.addAttribute("priceYeMon", priceYear + " 年 " + priceMonth + " 月");
		// 接送类型转码
		setCode(map, bean);
	}
	
	/**
	 * @方法名: showListBackwards
	 * @描述: 时间向后选择刷新页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午6:48:18 
	 * @param map
	 * @param bean
	 */
	public void showListBackwards(ModelMap map, TexiSendPriceBean bean) {
		// 当前年
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		// 当前月
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 转换到上个月
		//DateUtil.monthBackwards(priceYear, priceMonth);
		int yearInt = Integer.valueOf(priceYear);
		int monthInt = Integer.valueOf(priceMonth);
		
		if (monthInt == 1) {
			yearInt--;
			monthInt = 12;
		} else {
			monthInt--;
		}
		
		priceYear = Integer.toString(yearInt);
		priceMonth = Integer.toString(monthInt);
		// 存入Session
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", priceYear);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", priceMonth);
		
		// 当前年月，放进map
		map.addAttribute("priceYeMon", priceYear + " 年 " + priceMonth + " 月");
		// 接送类型转码
		setCode(map, bean);
	}
	
	/**
	 * @方法名: setCode
	 * @描述: 接送类型转码
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午7:08:08 
	 * @param map
	 * @param bean
	 */
	public void setCode(ModelMap map, TexiSendPriceBean bean) {
		// 接送类型转码
		String sendType = bean.getSendType();
		if (sendType != null && !"".equals(sendType)) {
			SecurityUtils.getSubject().getSession().setAttribute("sendType", sendType);
		} else {
			sendType = (String) SecurityUtils.getSubject().getSession().getAttribute("sendType");
		}
		String strType = codeService.getValueByCodeNoAndKey("C075", sendType);
		map.addAttribute("sendType", strType);
		
		// 租车ID
		Integer texiID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("texiID");
		map.addAttribute("texiID", texiID);
	}
	
	/**
	 * @方法名: insertPrice
	 * @描述: 新增量价管理
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午7:33:06 
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer insertPrice(ModelMap map, TexiSendPriceBean bean) {
		
		Integer result = CommonUtil.ERROR;
		// 线路ID
		Integer sendId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("sendID");
		// 线路类型
		String sendType = (String) SecurityUtils.getSubject().getSession().getAttribute("sendType");
		String start = bean.getStart(); // 开始时间
		String end = bean.getEnd(); // 结束时间
		// 获取之间所有日期
		String[] day = DateUtil.getCountByStartEnd(start, end);
		Integer state = 0;
		for (int i = 0; i < day.length; i++) {
			// 当前日期
			String tspDate = day[i];
			// 获取星期
			String week = DateUtil.getWeekByDate(tspDate);
			// 当前日期是否符合按周选择
			boolean bl = isAllowAdd(bean.getWeek(), week);
			if (bl) {
				// 第一条可录入日期
				if (state == 0) {
					// 获取初次录入日期的年月信息
					PriceUtil.getFirstDate(tspDate, map);
				}
				state = 1;
				bean.setSendId(sendId); // 线路ID
				bean.setSendType(sendType); // 线路类型
				bean.setTspDate(tspDate); // 日期
				bean.setTspWeek(week); // 星期
				bean.setCpyId(CommonUtil.getCpyId()); // 公司ID
				bean.setTspIsOpen(ErimConstants.YESORNO_YES); // 是否出售
				bean.setTspCreateUser(CommonUtil.getLoginName()); // 创建用户
				bean.setTspCreateTime(new Date()); // 创建时间
				// 执行新增
				result = texiSendPriceDao.insertSendPrice(bean);
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
	 * @方法名: isAllowAdd
	 * @描述: 判断是否符合日期选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午7:43:34 
	 * @param hnpWeek
	 * @param week
	 * @return
	 */
	public boolean isAllowAdd(String hnpWeek, String week) {
		
		// 星期等于null，直接返回允许
		if (hnpWeek == null || hnpWeek == "" ) {
			return true;
		}
		// 分解允许录入的星期
		String[] weekLi = hnpWeek.split(",");
		for (int i = 0; i < weekLi.length; i++) {
			// 允许录入的星期
			String weekStr = weekLi[i];
			// 当选择0, 每个星期都可以录入
			if ("0".equals(weekStr)) {
				return true;
			}
			// 当前日期符合当前选择的星期
			if (week.equals(weekStr)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @方法名: refresh
	 * @描述: 刷新页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月13日 下午8:10:05 
	 * @param map
	 * @param bean
	 */
	public void refresh(ModelMap map, TexiSendPriceBean bean) {
		// 接送类型
		setCode(map, bean);
		// 年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 当前年月，放进map
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @方法名: selectSendPriceList
	 * @描述: 租车固定路线量价管理数据查询
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月14日 上午10:10:20 
	 * @param map
	 * @param bean
	 */
	public void selectSendPriceList(ModelMap map, TexiSendPriceBean bean) {
		List<TexiSendPriceBean> list = new ArrayList<TexiSendPriceBean>(42);
		List<TexiSendPriceBean> modelList = new ArrayList<TexiSendPriceBean>();
		
		// 获取日期
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		// 该月所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 该月天数总计
		int monthNum = DateUtil.getMonthCount(year, month);
		
		/*
		 * 根据路线ID、该月所有日期 获取该月所有量价信息
		 */
		Integer sendId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("sendID");
		bean.setSendId(sendId);// 路线ID
		// 该月房量信息
		modelList = texiSendPriceDao.selectSendPriceList(bean, monthCount);
		
		// 日历-日号
		int j = 0;
		/*
		 * 根据年月，判断该月日历前，共有多少空格
		 */
		int weekCount = DateUtil.getWeekByDate(year, month);
		for (int i = 0; i < weekCount; i++) {
			// 填入空值
			list.add(i, new TexiSendPriceBean());
		}
		/*
		 * 处理查询的房量信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询的量价信息
			TexiSendPriceBean model = new TexiSendPriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 量价信息日期
				String tspDate = model.getTspDate();
				// 下标
				int index = j + weekCount;
				// 当前信息日期是否符合日历日期
				if (monthCount[j].equals(tspDate)) {
					// 当前日期是否允许修改
					boolean bl = DateUtil.getCheckDateUpdate(tspDate);
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
					model = new TexiSendPriceBean();
					model.setDay(j + 1 + "");
					list.add(index, model);
				}
				j++;
			}
		}
		/*
		 * 填充日历中剩余的空格
		 */
		// 日历中已有的格数
		int priceSize = list.size();
		// 剩余格数
		int blankCount = 42 - priceSize;
		// 填入空值
		for (int i = 0; i < blankCount; i++) {
			// 下标
			int index = priceSize + i;
			TexiSendPriceBean model = new TexiSendPriceBean();
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
	 * @描述: 开关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月14日 上午11:19:58 
	 * @param bean
	 * @return
	 */
	public Integer updateIsOpen(TexiSendPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = texiSendPriceDao.updateIsOpen(bean);
		return result;
	}

	/**
	 * @方法名: updatePrice
	 * @描述: 修改量价信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月14日 上午11:21:00 
	 * @param bean
	 * @return
	 */
	public Integer updatePrice(TexiSendPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = texiSendPriceDao.updateSendPrice(bean);
		return result;
	}
	
	/**
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月14日 上午11:26:47 
	 * @param bean
	 * @return
	 */
	public Integer updateBatchIsOpen(TexiSendPriceBean bean, ModelMap map) {
		Integer result = CommonUtil.ERROR;
		String start = bean.getStart();
		String end = bean.getEnd();
		// 获取初次录入日期的年月信息
		PriceUtil.getFirstDate(start, map);
		// 获取之间所有日期
		String[] strList = DateUtil.getCountByStartEnd(start, end);
		// 线路ID
		Integer sendID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("sendID");
		bean.setSendId(sendID);
		bean.setTspIsOpen(ErimConstants.YESORNO_NO);
		for (int i = 0; i < strList.length; i++) {
			bean.setTspDate(strList[i]);
			result = texiSendPriceDao.updateBatchIsOpen(bean);
		}
		return result;
	}
}
