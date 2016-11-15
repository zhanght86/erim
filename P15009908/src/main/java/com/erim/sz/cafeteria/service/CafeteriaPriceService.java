package com.erim.sz.cafeteria.service;

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

import com.erim.sz.cafeteria.dao.CafeteriaDetailDao;
import com.erim.sz.cafeteria.dao.CafeteriaPackageDao;
import com.erim.sz.cafeteria.dao.CafeteriaPriceDao;
import com.erim.sz.common.bean.CafeteriaDetailBean;
import com.erim.sz.common.bean.CafeteriaPackageBean;
import com.erim.sz.common.bean.CafeteriaPriceBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.PriceUtil;

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
	private CafeteriaPackageDao cafeteriaPackageDao;
	@Autowired
	private CafeteriaDetailDao cafeteriadao;
	
	/**
	 * @描述: 查询特色餐是否有套餐信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月22日 上午11:42:02
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer getCafeteriaPackageNum(ModelMap map, CafeteriaPackageBean bean) {
		
		// 根据产品ID查询所有套餐信息
		List<CafeteriaPackageBean> list = cafeteriaPackageDao.selectPageCafeteria(bean, map);
		// 套餐数量
		int packageNum = list.size();
		if (packageNum != 0) {
			return CommonUtil.SUCCESS;
		} else {
			return CommonUtil.CAFETERIANOTPACKAGE;
		}
	}
	
	/**
	 * @描述: 选择套餐ID
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月22日 下午3:44:03
	 * @param map
	 * @param bean
	 */
	public void skipCafeteriaPackage(ModelMap map, CafeteriaPriceBean bean) {
		// 套餐ID
		Integer cpeId = bean.getCpeId();
		SecurityUtils.getSubject().getSession().setAttribute("twoId", cpeId);
		map.addAttribute("cpeId", cpeId);
		
		// Session中（也就是页面中）的年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 同业资源查看量价列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月22日 下午2:04:28
	 * @param map
	 * @param bean
	 */
	public void showPackagePricePortal(ModelMap map, CafeteriaPriceBean bean) {
		//　产品ID
		Integer cdlId = bean.getCdlId();
		CafeteriaPackageBean packageBean = new CafeteriaPackageBean();
		packageBean.setCdlID(cdlId);
		
		// 产品名称
		CafeteriaDetailBean detailBean = cafeteriadao.selectCafeteria(cdlId);
		SecurityUtils.getSubject().getSession().setAttribute("cdlName", detailBean.getCdlName());
		
		// 根据产品ID查询所有套餐信息
		List<CafeteriaPackageBean> list = cafeteriaPackageDao.selectPageCafeteria(packageBean, map);
		
		// 套餐信息字典
		SecurityUtils.getSubject().getSession().setAttribute("packageList", list);
		
		// 套餐ID
		Integer cpeId = null;
		if (bean.getCpeId() != null) {
			cpeId = bean.getCpeId();
		} else {
			cpeId = list.get(0).getId();
		}
		SecurityUtils.getSubject().getSession().setAttribute("twoId", cpeId);
		map.addAttribute("cpeId", cpeId);
		
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
	 * @方法名: showCafeteriaPricePortal
	 * @描述: 特色餐套餐量价管理信息列表页
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 上午11:26:49 
	 * @param map
	 * @param bean
	 */
	public void showCafeteriaPricePortal(ModelMap map, CafeteriaPriceBean bean) {
		
		// 获取套餐ID
		Integer cpeId = bean.getCpeId();
		SecurityUtils.getSubject().getSession().setAttribute("twoId", cpeId);
		
		// 根据套餐ID查询一条套餐信息
		CafeteriaPackageBean detailBean = cafeteriaPackageDao.selectCafeteriaPackage(cpeId);
		
		// 获取套餐名称
		String cpeName = detailBean.getCpeName();
		SecurityUtils.getSubject().getSession().setAttribute("twoName", cpeName);
		map.addAttribute("cpeName", cpeName);
		
		// 产品ID
		Integer cdlId = bean.getCdlId();
		SecurityUtils.getSubject().getSession().setAttribute("cdlId", cdlId);
		
		// 产品名称
		CafeteriaDetailBean detail = cafeteriadao.selectCafeteria(cdlId);
		SecurityUtils.getSubject().getSession().setAttribute("cdlName", detail.getCdlName());
		
		// 当前年月
		String year = DateUtil.getCuurentYear();
		String month = DateUtil.getCuurentMonth();
		
		// 存入Session,以便其他操作使用
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		
		// 返回页面需要的参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @方法名: showListForward
	 * @描述: 时间向前选择按钮
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 上午11:33:09 
	 * @param map
	 * @param bean
	 */
	public void showListForward(ModelMap map, CafeteriaPriceBean bean) {
		
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
		
		// 特色餐ID
		Integer cdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("twoId");
		// 套餐名称
		String cpeName = (String) SecurityUtils.getSubject().getSession().getAttribute("twoName");
		
		// 页面需要的参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
		map.addAttribute("cpeName", cpeName);
		map.addAttribute("cpeId", cdlId);
	}
	
	/**
	 * @方法名: showListBackwards
	 * @描述: 时间向后选择按钮
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 上午11:43:27 
	 * @param map
	 * @param bean
	 */
	public void showListBackwards(ModelMap map, CafeteriaPriceBean bean) {
		
		// Session(也就是页面)中的年月
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
		
		// 特色餐ID
		Integer cdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("twoId");
		// 套餐名称
		String cpeName = (String) SecurityUtils.getSubject().getSession().getAttribute("twoName");
		
		// 页面需要的参数
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
		map.addAttribute("cpeName", cpeName);
		map.addAttribute("cpeId", cdlId);
	}
	
	/**
	 * @方法名: insertPrice
	 * @描述: 新增量价
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 上午11:44:11 
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer insertPrice(ModelMap map, CafeteriaPriceBean bean) {
		
		Integer result = CommonUtil.ERROR;
		
		// 套餐ID
		Integer cpeId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("twoId");
		// 套餐名称
		String cpeName = (String) SecurityUtils.getSubject().getSession().getAttribute("twoName");
		// 产品ID
		Integer cdlId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("cdlId");
		
		// 开始时间和结束时间
		String start = bean.getStart();
		String end = bean.getEnd();
		
		// 获取之间所有日期
		String[] day = DateUtil.getCountByStartEnd(start, end);
		
		// 有无可添加信息
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
				//　有一条可添加的数据则改为1
				state = 1;
				bean.setCdlId(cdlId); // 产品ID
				bean.setCpeId(cpeId); // 套餐ID
				bean.setCpeName(cpeName); // 套餐名称
				bean.setCpcDate(date); // 日期
				bean.setCpcWeek(week); // 星期
				bean.setCpyId(CommonUtil.getCpyId()); // 公司ID
				bean.setCpcIsOpen(ErimConstants.YESORNO_YES); // 是否出售
				bean.setCpcCreateUser(CommonUtil.getLoginName()); // 创建用户
				bean.setCpcCreateTime(new Date()); // 创建时间
				// 执行新增
				result = cafeteriaPriceDao.insertPrice(bean);
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
	 * @方法名: refresh
	 * @描述: 纯刷新
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 上午11:55:22 
	 * @param map
	 * @param bean
	 */
	public void refresh(ModelMap map, CafeteriaPriceBean bean) {
		// 套餐名称
		String cpeName = (String) SecurityUtils.getSubject().getSession().getAttribute("twoName");
		map.addAttribute("cpeName", cpeName);
		
		// 的年月
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 套餐ID
		Integer cpeId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("twoId");
		
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
		map.addAttribute("cpeId", cpeId);
	}
	
	/**
	 * @方法名: selectCafeteriaPriceList
	 * @描述: 数据展示
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 上午11:57:44 
	 * @param map
	 * @param bean
	 */
	public void selectCafeteriaPriceList(ModelMap map, CafeteriaPriceBean bean) {
		List<CafeteriaPriceBean> list = new ArrayList<CafeteriaPriceBean>(42);
		List<CafeteriaPriceBean> modelList = new ArrayList<CafeteriaPriceBean>();
		
		// 获取日期
		String year = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String month = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		// 该有所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(year, month);
		// 该有所有天数总计
		int monthNum = DateUtil.getMonthCount(year, month);
		
		/*
		 * 根据套餐ID、当前所选日期获取该日期内所有量价信息
		 */
		// 套餐ID
		Integer cpeId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("twoId");
		bean.setCpeId(cpeId);
		// 量价信息
		modelList = cafeteriaPriceDao.selectCafeteriaPriceList(bean, monthCount);
		
		// 日历号
		int j = 0;
		/*
		 * 根据年月，判断该月日历数据前，共有多少空格
		 */
		int weekCount = DateUtil.getWeekByDate(year, month);
		for (int i = 0; i < weekCount; i++) {
			// 填入空格
			list.add(i, new CafeteriaPriceBean());
		}
		
		/*
		 * 处理查询的量价信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询到的量价信息
			CafeteriaPriceBean model = new CafeteriaPriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 量价信息日期
				String tplDate = model.getCpcDate();
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
					model = new CafeteriaPriceBean();
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
			CafeteriaPriceBean model = new CafeteriaPriceBean();
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
	 * @描述: 更改出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 下午1:23:07 
	 * @param bean
	 * @return
	 */
	public Integer updateIsOpen(CafeteriaPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = cafeteriaPriceDao.updateIsOpen(bean);
		return result;
	}
	
	/**
	 * @方法名: updatePrice
	 * @描述: 修改量价信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 下午1:24:10 
	 * @param bean
	 * @return
	 */
	public Integer updatePrice(CafeteriaPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = cafeteriaPriceDao.updatePrice(bean);
		return result;
	}
	
	/**
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量更改是否出售状态
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月18日 下午1:24:33 
	 * @param bean
	 * @return
	 */
	public Integer updateBatchIsOpen(CafeteriaPriceBean bean, ModelMap map) {
		Integer result = CommonUtil.ERROR;
		// 开始日期和结束日期
		String start = bean.getStart();
		String end = bean.getEnd();
		// 获取初次录入日期的年月信息
		PriceUtil.getFirstDate(start, map);
		// 获取之间所有日期
		String[] strList = DateUtil.getCountByStartEnd(start, end);
		// 套餐ID
		Integer cpeId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("twoId");
		bean.setCpeId(cpeId);
		bean.setCpcIsOpen(ErimConstants.YESORNO_NO); // 停止出售
		// 执行修改
		result = cafeteriaPriceDao.updateBatchIsOpen(bean, strList);
		return result;
	}
}
