package com.erim.sz.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.CafeteriaPackageBean;
import com.erim.sz.common.bean.CafeteriaPriceBean;
import com.erim.sz.common.bean.HotelPriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.web.dao.CafeteriaDetailDao;
import com.erim.sz.web.dao.CafeteriaPackageDao;
import com.erim.sz.web.dao.CafeteriaPriceDao;
import com.erim.sz.web.util.DateUtil;

/**
 * @类名: CafeteriaPriceService
 * @描述: 特色餐套餐量价信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年10月18日 上午11:12:31
 */
@Service("cafeteriaPriceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CafeteriaPriceService {

	@Autowired
	private CafeteriaPriceDao cafeteriaPriceDao;
	@Autowired
	private CafeteriaDetailDao cafeteriadao;
	@Autowired
	private CafeteriaPackageDao cafeteriaPackageDao;
	
//	public Integer getCafeteriaPackageNum(ModelMap map, CafeteriaPackageBean bean) {
//		
//		// 根据产品ID查询所有套餐信息
//		List<CafeteriaPackageBean> list = cafeteriaPackageDao.selectPageCafeteria(bean, map);
//		// 套餐数量
//		int packageNum = list.size();
//		if (packageNum != 0) {
//			return CommonUtil.SUCCESS;
//		} else {
//			return CommonUtil.CAFETERIANOTPACKAGE;
//		}
//	}
	
	public void getCafeteriaPriceList(ModelMap map, CafeteriaPriceBean bean) {
		
		// 当前年月
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		
		// 获取当前月份之前的所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 执行查询
		List<CafeteriaPriceBean> list = cafeteriaPriceDao.selectCafeteriaPriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(list, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("cpeId", bean.getCpeId());
		
		// 获取票类相关信息
		//getCafeteriaPakageById(Integer id);
		CafeteriaPackageBean cafeteriaPackageBean = cafeteriaPackageDao.selectCafeteriaPackage(bean.getCpeId());
		map.addAttribute("cafeteriaPackageBean", cafeteriaPackageBean);
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
	public List<CafeteriaPriceBean> createCalendar(List<CafeteriaPriceBean> modelList, String[] monthCount, String year, String month) {
		
		List<CafeteriaPriceBean> list = new ArrayList<CafeteriaPriceBean>(42);
		
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
			list.add(i, new CafeteriaPriceBean());
		}
		
		/*
		 * 处理查询的房量信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询的房量信息
			CafeteriaPriceBean model = new CafeteriaPriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 房量信息日期
				String hnpDate = model.getCpcDate();
				// 下标
				int index = j+weekCount;
				// 当前信息日期符合日历日期
				if (monthCount[j].equals(hnpDate)) {
					// 日历号
					String day = j + 1 + "";
					String dayStr = "";
					if((j + 1) < 10){
						dayStr = "0" + (j + 1);
					}
					model.setDay(day);
					// 是否为今天
					if (DateUtil.getCuurentMonth().equals(month) && DateUtil.getCurrentDay().equals(dayStr)) {
						model.setIsUpdate(ErimConstants.YESORNO_YES);
					} else {
						model.setIsUpdate(ErimConstants.YESORNO_NO);
					}
					list.add(index, model);
				} else {
					// 不符合
					i--;
					model = new CafeteriaPriceBean();
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
			CafeteriaPriceBean model = new CafeteriaPriceBean();
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
	/**
	 * @描述: 
	 * @作者: 吴哲元
	 * @创建时间: 2015年12月25日 上午11:59:23
	 * @param map
	 * @param bean
	 */
	public void forward(ModelMap map, CafeteriaPriceBean bean) {
		
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
		List<CafeteriaPriceBean> modelList = cafeteriaPriceDao.selectCafeteriaPriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("cpeId", bean.getCpeId());
		// 获取票类相关信息
		CafeteriaPackageBean cafeteriaPackageBean = cafeteriaPackageDao.selectCafeteriaPackage(bean.getCpeId());
		map.addAttribute("cafeteriaPackageBean", cafeteriaPackageBean);
	}
	
	/**
	 * @描述: 
	 * @作者: 吴哲元
	 * @创建时间: 2015年12月25日 上午11:59:38
	 * @param map
	 * @param bean
	 */
	public void backwards(ModelMap map, CafeteriaPriceBean bean) {
		
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
		List<CafeteriaPriceBean> modelList = cafeteriaPriceDao.selectCafeteriaPriceList(bean, monthCount);
		// 生成日历
		map.addAttribute("priceList", createCalendar(modelList, monthCount, year, month));
		map.addAttribute("year", year);
		map.addAttribute("month", month);
		map.addAttribute("cpeId", bean.getCpeId());
		// 获取票类相关信息
		CafeteriaPackageBean cafeteriaPackageBean = cafeteriaPackageDao.selectCafeteriaPackage(bean.getCpeId());
		map.addAttribute("cafeteriaPackageBean", cafeteriaPackageBean);
	}
	public CafeteriaPriceBean getPriceBeanById(Integer id) {
		return  cafeteriaPriceDao.getPriceBeanById(id);
	}
}
