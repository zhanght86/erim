package com.erim.sz.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.TicketClassBean;
import com.erim.sz.common.bean.TicketPriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.web.dao.TicketPriceDao;
import com.erim.sz.web.dao.TicketclasskDao;
import com.erim.sz.web.util.DateUtil;
/**
 * @描述: 门票量价信息实体操作业务层
 * 
 * @作者: 宁晓强
 * @创建时间: 2015年11月27日 下午3:46:15
 */
@Service("ticketPriceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TicketPriceService {

	@Autowired
	private TicketPriceDao ticketPriceDao;
	@Autowired 
	private TicketclasskDao  ticketclassDao;
	/**
	 * @描述: 票类量价列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午4:01:39
	 * @param map
	 * @param bean
	 */
	public void getTicketPriceList(ModelMap map, TicketPriceBean bean) {
		
		// 当前年月
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		
		// 获取当前月份之前的所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<TicketPriceBean> list = ticketPriceDao.selectProceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(list, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("tclId", bean.getTclId());
		
		// 获取票类相关信息
		getTicketClass(map, bean);
	}
	
	/**
	 * @描述: 获取票类相关信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月28日 上午11:18:15
	 * @param map
	 * @param bean
	 */
	public void getTicketClass(ModelMap map, TicketPriceBean bean) {
		// 票类ID
		Integer tclId = bean.getTclId();
		TicketClassBean classBean = new TicketClassBean();
		classBean.setId(tclId);
		// 执行查询
		classBean = ticketclassDao.selectOne(classBean);
		map.addAttribute("ticketClass", classBean);
	}
	
	/**
	 * @描述: 时间向前选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月26日 下午10:32:46
	 * @param map
	 * @param bean
	 */
	public void forward(ModelMap map, TicketPriceBean bean) {
		
		String year = bean.getStart();
		String month = bean.getEnd();
		
		int yearInt = Integer.valueOf(year);
		int monthInt = Integer.valueOf(month);
		if (monthInt == 12) {
			yearInt++;
			monthInt = 1;
		} else {
			monthInt++;
		}
		year = Integer.toString(yearInt);
		if (monthInt < 10) {
			month = "0" + Integer.toString(monthInt);
		} else {
			month = Integer.toString(monthInt);
		}
				
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<TicketPriceBean> list = ticketPriceDao.selectProceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(list, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("tclId", bean.getTclId());
		
		// 获取票类相关信息
		getTicketClass(map, bean);
	}
	
	/**
	 * @描述: 时间向后选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月26日 下午10:50:03
	 * @param map
	 * @param bean
	 */
	public void backwards(ModelMap map, TicketPriceBean bean) {
		
		String year = bean.getStart();
		String month = bean.getEnd();
		
		// 转换到上个月
		int yearInt = Integer.valueOf(year);
		int monthInt = Integer.valueOf(month);
		
		if (monthInt == 1) {
			yearInt--;
			monthInt = 12;
		} else {
			monthInt--;
		}
		
		year = Integer.toString(yearInt);
		if (monthInt < 10) {
			month = "0" + Integer.toString(monthInt);
		} else {
			month = Integer.toString(monthInt);
		}
		
		// 获取当前月份所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<TicketPriceBean> list = ticketPriceDao.selectProceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(list, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("tclId", bean.getTclId());
		
		// 获取票类相关信息
		getTicketClass(map, bean);
	}
	
	/**
	 * @描述: 生成日历
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月27日 下午4:07:47
	 * @param modelList
	 * @param monthCount
	 * @param year
	 * @param month
	 * @return
	 */
	public List<TicketPriceBean> createCalendar(List<TicketPriceBean> modelList, String[] monthCount, String year, String month) {
		
		List<TicketPriceBean> list = new ArrayList<TicketPriceBean>(42);
		
		// 该月天数总计
		int monthNum = DateUtil.getMonthCount(year, month);
		
		// 日历-日号
		int j = 0;
		
		/*
		 * 根据年月，判断该月日历前，共有多少空格
		 */
		int weekCount = DateUtil.getWeekByDate(year, month);
		for (int i = 0; i < weekCount; i++) {
			// 填入空值
			list.add(i, new TicketPriceBean());
		}
		
		/*
		 * 处理查询的房量信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询的房量信息
			TicketPriceBean model = new TicketPriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 房量信息日期
				String hnpDate = model.getTplDate();
				// 下标
				int index = j+weekCount;
				// 当前信息日期符合日历日期
				if (monthCount[j].equals(hnpDate)) {
					// 日历号
					String day = j + 1 + "";
					String dayStr = "";
					if((j + 1) < 10){
						dayStr = "0" + (j + 1);
					}else{
						dayStr = (j + 1)+"";
					}
					model.setDay(day);
					// 是否为今天
					if (DateUtil.getCuurentMonth().equals(month) && DateUtil.getCurrentDay().equals(dayStr)) {
						model.setIsUpdate(ErimConstants.YESORNO_YES);
					} else {
						model.setIsUpdate(ErimConstants.YESORNO_NO);
					}
					//判断当日 预定时间是否超出
					if("02".equals(model.getTplDateType()) && StringUtils.isNotEmpty(model.getTplSameH())){
						Date thisDate = DateUtil.parseDate( year + "-" + month + "-" + dayStr + " " + model.getTplSameH() , "yyyy-MM-dd HH:mm");
						if(thisDate.getTime() - new Date().getTime() >= 0){
							//可以预定
							model.setIsPredetermine("1");
						}else{
							model.setIsPredetermine("0");
						}
					}else if("01".equals(model.getTplDateType()) && StringUtils.isNotEmpty(model.getTplForwardH())){//判断提前几天
						Date thisDate = DateUtil.parseDate( year + "-" + month + "-" + dayStr, "yyyy-MM-dd");
						Double differenceDay = Math.ceil((double)(thisDate.getTime() - new Date().getTime())/(24*60*60*1000));
						if(differenceDay - Integer.parseInt(model.getTplForwardH()) >= 0){
							//可以预定
							model.setIsPredetermine("1");
						}else{
							model.setIsPredetermine("0");
						}
					}else{
						model.setIsPredetermine("1");
					}
					list.add(index, model);
				} else {
					// 不符合
					i--;
					model = new TicketPriceBean();
					// 日历号
					String day = j + 1 + "";
					model.setDay(day);
					// 是否为今天
					if (DateUtil.getCuurentMonth().equals(month) && DateUtil.getCurrentDay().equals(day)) {
						model.setIsUpdate(ErimConstants.YESORNO_YES);
					} else {
						model.setIsUpdate(ErimConstants.YESORNO_NO);
					}
					list.add(index, model);
				}
				j++;
			}
		}
		
		/*
		 * 填充日历中剩余的格子
		 */
		// 日历中已有的格数
		int priceSize = list.size();
		// 剩余格数
		int blankCount = 42-priceSize;
		// 填入空值
		for (int i = 0; i < blankCount; i++) {
			// 下标
			int index = priceSize+i;
			TicketPriceBean model = new TicketPriceBean();
			// 日历
			if (j < monthNum) {
				String day = j + 1 + "";
				model.setDay(day);
				// 是否为今天
				if (DateUtil.getCuurentMonth().equals(month) && DateUtil.getCurrentDay().equals(day)) {
					model.setIsUpdate(ErimConstants.YESORNO_YES);
				} else {
					model.setIsUpdate(ErimConstants.YESORNO_NO);
				}
				list.add(index, model);
				j++;
			} else {
				list.add(index, model);
			}
		}
		return list;
	}
	
	public TicketPriceBean getPriceBeanById(Integer id) {
		return  ticketPriceDao.getPriceBeanById(id);
	}
}
