package com.erim.sz.texi.service;

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

import com.erim.sz.common.bean.TexiCarPriceBean;
import com.erim.sz.common.bean.TexiDetailBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.texi.dao.TexiCarPriceDao;
import com.erim.sz.texi.dao.TexiDetailDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.PriceUtil;

/**
 * @类名: TexiCarPriceService
 * @描述: 租车管理包车量价管理信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年10月15日 下午4:17:13
 */
@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TexiCarPriceService {

	@Autowired
	private TexiCarPriceDao texiCarPriceDao;
	@Autowired
	private TexiDetailDao texiDetailDao;
	
	/**
	 * @方法名: showCarPricePortal
	 * @描述: 
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月16日 上午10:45:16 
	 * @param map
	 * @param bean
	 */
	public void showCarPricePortal(ModelMap map, TexiCarPriceBean bean) {
		// 包车ID
		Integer carID = bean.getBclId();
		SecurityUtils.getSubject().getSession().setAttribute("carID", carID);
		// 租车ID
		Integer texiID = bean.getTdlId();
		SecurityUtils.getSubject().getSession().setAttribute("texiID", texiID);
		// 包车类型，第一次进入默认类型为半天/02
		SecurityUtils.getSubject().getSession().setAttribute("carType", "02");
		// 当前年月
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 获取车辆名称
	 * @作者: 宁晓强
	 * @创建时间: 2016年1月4日 下午5:52:28
	 * @param map
	 * @param bean
	 */
	public void getTdlName(ModelMap map, TexiCarPriceBean bean) {
		// 租车ID
		Integer texiID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("texiID");
		// 根据租车ID获取一条租车信息
		TexiDetailBean detailBean = texiDetailDao.getTexiDetialById(texiID);
		map.addAttribute("tdlName", detailBean.getTdlName());
	}
	
	/**
	 * @方法名: showListForward
	 * @描述: 时间向前选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午4:25:12 
	 * @param map
	 * @param bean
	 */
	public void showListForward(ModelMap map, TexiCarPriceBean bean) {
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 执行时间向前选择
		Map<String, Object> dateMap = PriceUtil.dateForward(priceYear, priceMonth);
		priceYear = (String) dateMap.get("year");
		priceMonth = (String) dateMap.get("month");
				
		// 存入Session
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", priceYear);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", priceMonth);
		
		// 当前年月，放进map
		map.addAttribute("priceYeMon", priceYear + " 年 " + priceMonth + " 月");
		
	}
	
	/**
	 * @方法名: showListBackwards
	 * @描述: 时间向后选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午5:52:10 
	 * @param map
	 * @param bean
	 */
	public void showListBackwards(ModelMap map, TexiCarPriceBean bean) {
		// 当前年月
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 执行时间向后选择
		Map<String, Object> dateMap = PriceUtil.dateBackwards(priceYear, priceMonth);
		priceYear = (String) dateMap.get("year");
		priceMonth = (String) dateMap.get("month");
				
		// 存入Session
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", priceYear);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", priceMonth);
		
		// 当前年月，放进map
		map.addAttribute("priceYeMon", priceYear + " 年 " + priceMonth + " 月");
		
	}
	
	/**
	 * @方法名: insertPrice
	 * @描述: 新增量价管理
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午4:38:48 
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer insertPrice(ModelMap map, TexiCarPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		// 包车ID
		Integer carID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("carID");
		// 包车类型
		String carType = (String) SecurityUtils.getSubject().getSession().getAttribute("carType");
		String start = bean.getStart();
		String end = bean.getEnd();
		
		// 获取之间所有日期
		String[] day = DateUtil.getCountByStartEnd(start, end);
		Integer state = 0;
		for (int i = 0; i < day.length; i++) {
			// 当前日期
			String tcpDate = day[i];
			// 获取星期
			String week = DateUtil.getWeekByDate(tcpDate);
			boolean bl = isAllowAdd(bean.getWeek(), week);
			if (bl) {
				// 第一条可录入日期
				if (state == 0) {
					// 获取初次录入日期的年月信息
					PriceUtil.getFirstDate(tcpDate, map);
				}
				state = 1;
				bean.setBclId(carID); // 包车ID
				bean.setBclType(carType); // 包车类型
				bean.setTcpDate(tcpDate); // 日期
				bean.setTcpWeek(week); // 星期
				bean.setCpyId(CommonUtil.getCpyId()); // 公司ID
				bean.setTcpIsOpen(ErimConstants.YESORNO_YES); // 是否出售
				bean.setTcpCreateTime(new Date()); // 创建时间
				bean.setTcpCreateUser(CommonUtil.getLoginName()); // 创建用户
				// 执行新增
				result = texiCarPriceDao.insertCarPrice(bean);
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
	 * @创建时间: 2015年10月15日 下午4:34:14 
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
	 * @方法名: showListCarType
	 * @描述: 选择包车类型
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午5:52:55 
	 * @param map
	 * @param bean
	 */
	public void showListCarType(ModelMap map, TexiCarPriceBean bean) {
		// 包车类型
		String carType = bean.getBclType();
		if (carType != null && !"".equals(carType)) {
			SecurityUtils.getSubject().getSession().setAttribute("carType", carType);
			map.addAttribute("carType", carType);
		}
		// 年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
		
	}
	
	/**
	 * @方法名: refresh
	 * @描述: 刷新页面
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午4:42:47 
	 * @param map
	 * @param bean
	 */
	public void refresh(ModelMap map, TexiCarPriceBean bean) {
		// 年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
		
	}
	
	/**
	 * @方法名: selectCarPirceList
	 * @描述: 查询
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午5:17:06 
	 * @param map
	 * @param bean
	 */
	public void selectCarPirceList(ModelMap map, TexiCarPriceBean bean) {
		List<TexiCarPriceBean> list = new ArrayList<TexiCarPriceBean>(42);
		List<TexiCarPriceBean> modelList = new ArrayList<TexiCarPriceBean>();
		
		// 获取日期
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		// 该月所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 该月天数总计
		int monthNum = DateUtil.getMonthCount(year, month);
		
		/*
		 * 根据包车ID、包车类型、该月所有日期 获取该月所有量价信息
		 */
		// 包车ID
		Integer carID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("carID");
		bean.setBclId(carID);
		// 包车类型
		String carType = (String) SecurityUtils.getSubject().getSession().getAttribute("carType");
		bean.setBclType(carType);
		// 该月所有房量信息
		modelList = texiCarPriceDao.selectCarPriceList(bean, monthCount);
		
		// 日历-日号
		int j = 0;
		/*
		 * 根据年月，判断该月日历前，共有多少空格
		 */
		int weekCount = DateUtil.getWeekByDate(year, month);
		for (int i = 0; i < weekCount; i++)  {
			// 填入空值
			list.add(i, new TexiCarPriceBean());
		}
		/*
		 * 处理查询的量价信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询的量价信息
			TexiCarPriceBean model = new TexiCarPriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 量价日期
				String tcpDate = model.getTcpDate();
				// 下标
				int index = j + weekCount;
				// 当前信息日期是否符合日历日期
				if (monthCount[j].equals(tcpDate)) {
					// 当前日期是否允许修改
					boolean bl = DateUtil.getCheckDateUpdate(tcpDate);
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
					model = new TexiCarPriceBean();
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
		// 填入空格
		for (int i = 0; i < blankCount; i++) {
			// 下标
			int index = priceSize + i;
			TexiCarPriceBean model = new TexiCarPriceBean();
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
	 * @创建时间: 2015年10月15日 下午5:20:09 
	 * @param bean
	 * @return
	 */
	public Integer updateIsOpen(TexiCarPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = texiCarPriceDao.updateIsOpen(bean);
		return result;
	}
	
	/**
	 * @方法名: updatePrice
	 * @描述: 修改量价
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午5:21:46 
	 * @param bean
	 * @return
	 */
	public Integer updatePrice(TexiCarPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = texiCarPriceDao.updateCarPrice(bean);
		return result;
	}
	
	/**
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月15日 下午5:28:39 
	 * @param bean
	 * @return
	 */
	public Integer updateBatchIsOpen(TexiCarPriceBean bean, ModelMap map) {
		Integer result = CommonUtil.ERROR;
		String start = bean.getStart();
		String end = bean.getEnd();
		// 获取初次录入日期的年月信息
		PriceUtil.getFirstDate(start, map);
		// 获取之间所有日期
		String[] strList = DateUtil.getCountByStartEnd(start, end);
		// 包车ID
		Integer carID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("carID");
		bean.setBclId(carID);
		// 包车类型
		String carType = (String) SecurityUtils.getSubject().getSession().getAttribute("carType");
		bean.setBclType(carType);
		bean.setTcpIsOpen(ErimConstants.YESORNO_NO);
		for (int i = 0; i < strList.length; i++) {
			bean.setTcpDate(strList[i]);
			result = texiCarPriceDao.updateBatchIsOpen(bean);
		}
		return result;
	}
}
