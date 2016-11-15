package com.erim.sz.hotel.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.HotelDetailBean;
import com.erim.sz.common.bean.HotelPriceBean;
import com.erim.sz.common.bean.HotelRoomBean;
import com.erim.sz.common.constant.ErimConstants;
import com.erim.sz.hotel.dao.HotelDetailDao;
import com.erim.sz.hotel.dao.HotelPriceDao;
import com.erim.sz.hotel.dao.HotelRoomDao;
import com.erim.sz.web.util.CommonUtil;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.PriceUtil;

/**
 * @类名: HotelPriceService
 * @描述: 酒店量价管理信息实体操作业务层
 * @作者: 宁晓强
 * @创建时间: 2015年10月5日 下午3:08:35
 */
@Service("hotelPriceService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class HotelPriceService {

	@Autowired
	private HotelPriceDao hotelPriceDao;
	@Autowired
	private HotelDetailDao hotelDetailDao;
	@Autowired
	private HotelRoomDao hotelRoomDao;
	
	/**
	 * @方法名: showListPortal
	 * @描述: 酒店量价管理列表页 - 初始化页面参数
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月5日 下午3:08:24 
	 * @param map
	 * @param bean
	 */
	public void showListPortal(ModelMap map, HotelPriceBean bean) {
		
		// 酒店基础ID
		Integer hdlId = bean.getHdlId();
		// 存入Session
		SecurityUtils.getSubject().getSession().setAttribute("hotelID", hdlId);
		// 根据酒店基础ID查询酒店名称
		HotelDetailBean detailBean = hotelDetailDao.getHotelDetailById(hdlId);
		SecurityUtils.getSubject().getSession().setAttribute("hotelName", detailBean.getHdlName());
		
		// 根据酒店基础信息ID查询房型列表
		HotelRoomBean roomBean = new HotelRoomBean();
		roomBean.setHdlId(hdlId);
		List<HotelRoomBean> roomList = hotelRoomDao.selectHotelRoomList(roomBean, map);
		
		if (roomList.size() != 0) {
			// 房型ID
			Integer roomID = roomList.get(0).getId();
			// 房型名称
			String roomName = roomList.get(0).getHheName();
			// 房型信息
			map.addAttribute("roomList", roomList);
			// 房型ID
			SecurityUtils.getSubject().getSession().setAttribute("roomID", roomID);
			// 房型名称
			SecurityUtils.getSubject().getSession().setAttribute("roomName", roomName);
			// 房间总数量
			SecurityUtils.getSubject().getSession().setAttribute("homenum", roomList.get(0).getHheHomenum());
		}
		
		// 当前年
		String year = DateUtil.getCuurentYear();
		// 当前月
		String month = DateUtil.getCuurentMonth();
		// 存入Session
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		// 当前年月，放进map
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}
	
	/**
	 * @描述: 同业资源酒店量价列表
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月12日 下午5:37:25
	 * @param map
	 * @param bean
	 */
	public void showTownListPortal(ModelMap map, HotelPriceBean bean) {
		
		// 酒店基础ID
		Integer hdlId = bean.getHdlId();
		SecurityUtils.getSubject().getSession().setAttribute("hotelID", hdlId);
		// 根据酒店基础ID查询酒店名称
		HotelDetailBean detailBean = hotelDetailDao.getHotelDetailById(hdlId);
		SecurityUtils.getSubject().getSession().setAttribute("hotelName", detailBean.getHdlName());
		
		// 根据酒店基础信息ID查询房型列表
		HotelRoomBean roomBean = new HotelRoomBean();
		roomBean.setHdlId(hdlId);
		List<HotelRoomBean> roomList = hotelRoomDao.selectHotelRoomList(roomBean, map);
		
		// 房型信息
		map.addAttribute("roomList", roomList);
		
		// 房型ID
		Integer roomID = 0;
		// 最低价房型
		if (bean.getHheId() != null) {
			roomID = bean.getHheId();
		} else if (roomList.size() != 0) {
			// 房型ID
			roomID = roomList.get(0).getId();
		}
		// 当前选择房型ID
		SecurityUtils.getSubject().getSession().setAttribute("roomID", roomID);
		
		// 当前年
		String year = DateUtil.getCuurentYear();
		// 当前月
		String month = DateUtil.getCuurentMonth();
		// 存入Session
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", year);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", month);
		// 当前年月，放进map
		map.addAttribute("priceYeMon", year + " 年 " + month + " 月");
	}

	/**
	 * @方法名: getRoomNum
	 * @描述: 判断是否有房型信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月30日 下午8:28:27 
	 * @param map
	 * @param bean
	 * @return
	 */
	public Integer getRoomNum(ModelMap map, HotelPriceBean bean) {
		// 酒店基础ID
		Integer hdlId = bean.getHdlId();
		HotelRoomBean roomBean = new HotelRoomBean();
		roomBean.setHdlId(hdlId);
		// 根据酒店基础信息ID查询该酒店房型信息	
		List<HotelRoomBean> roomList = hotelRoomDao.selectPageHotelRoomList(roomBean, map);
		if (roomList.size() != 0) {
			return CommonUtil.SUCCESS;
		} else {
			// 没有房型信息
			return CommonUtil.NOTROOM;
		}
	}
	
	/**
	 * @方法名: showListForward
	 * @描述: 时间向前选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月5日 下午4:53:22 
	 * @param map
	 * @param bean
	 */
	public void showListForward(ModelMap map, HotelPriceBean bean) {
		
		// 当前年月
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
		
		// 刷新页面参数
		refresh(map, bean, priceYear, priceMonth);
	}
	
	/**
	 * @方法名: showListBackwards
	 * @描述: 酒店量价管理列表页 - 时间向后选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月5日 下午5:32:55 
	 * @param map
	 * @param bean
	 */
	public void showListBackwards(ModelMap map, HotelPriceBean bean) {
		
		// 当前年月
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 转换到上个月
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
		
		// 刷新页面参数
		refresh(map, bean, priceYear, priceMonth);
	}
	
	/**
	 * @方法名: refresh
	 * @描述: 量价管理内部，月份切换专用 -页面刷新，修改Session中的priceYear、priceMonth
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月5日 下午5:36:01 
	 * @param map
	 * @param bean
	 */
	public void refresh(ModelMap map, HotelPriceBean bean, String priceYear, String priceMonth) {
		// 房型信息
		HotelRoomBean roomBean = new HotelRoomBean();
		// 酒店基础ID
		Integer hotelID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("hotelID");
		roomBean.setHdlId(hotelID);
		// 房型信息
		List<HotelRoomBean> roomList = hotelRoomDao.selectPageHotelRoomList(roomBean, map);
		map.addAttribute("roomList", roomList);
		
		// 存入Session
		SecurityUtils.getSubject().getSession().setAttribute("priceYear", priceYear);
		SecurityUtils.getSubject().getSession().setAttribute("priceMonth", priceMonth);
		
		// 当前年月，放进map
		map.addAttribute("priceYeMon", priceYear + " 年 " + priceMonth + " 月");
	}
	
	/**
	 * @方法名: showListRoom
	 * @描述: 房型选择，修改Session中的房型roomID
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月5日 下午6:58:40 
	 * @param map
	 * @param bean
	 */
	public void showListRoom(ModelMap map, HotelPriceBean bean) {
		
		// 房型信息
		HotelRoomBean roomBean = new HotelRoomBean();
		// 酒店基础ID
		Integer hotelID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("hotelID");
		roomBean.setHdlId(hotelID);
		// 房型信息
		List<HotelRoomBean> roomList = hotelRoomDao.selectPageHotelRoomList(roomBean, map);
		map.addAttribute("roomList", roomList);
		// 房型ID
		Integer roomID = bean.getHheId();
		// 根据房型ID获取一条房型信息
		roomBean.setId(roomID);
		roomBean = hotelRoomDao.getRoombyId(roomBean);
		
		// 房型名称
		String roomName = roomBean.getHheName();
		// 房间总数量
		Integer homenum = roomBean.getHheHomenum();
		
		// 从房型列表中取出房型名称
		/*for (int i = 0; i < roomList.size(); i++) {
			HotelRoomBean roomModel = roomList.get(i);
			if (roomModel.getId() == roomID) {
				roomName = roomModel.getHheName();
				homenum = roomModel.getHheHomenum();
			}
		}*/
		// 房间总数量
		SecurityUtils.getSubject().getSession().setAttribute("homenum", homenum);
		// 存入Session
		SecurityUtils.getSubject().getSession().setAttribute("roomID", roomID);
		SecurityUtils.getSubject().getSession().setAttribute("roomName", roomName);
		
		// 当前年月
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 当前年月，放进map
		map.addAttribute("priceYeMon", priceYear + " 年 " + priceMonth + " 月");
	}
	
	/**
	 * @方法名: insertPrice
	 * @描述: 新增量价管理信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月6日 上午11:03:25 
	 * @param map
	 * @param bean
	 */
	public Integer insertPrice(ModelMap map, HotelPriceBean bean) {
		
		Integer result = 0;
		Integer hotelID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("hotelID"); // 酒店ID
		Integer roomID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("roomID"); // 房型ID
		Integer cpyId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userCpyId"); // 公司ID
		// 处理数据
		String enteringStart = bean.getEnteringStart();
		String enteringEnd = bean.getEnteringEnd();
		// 24小时售卖
		// 获取之间所有日期
		String[] day = DateUtil.getCountByStartEnd(enteringStart, enteringEnd);
		Integer state = 0;
		for (int i = 0; i < day.length; i++) {
			// 当前日期
			String hnpDate = day[i];
			// 获取当前日期为周几
			String week = DateUtil.getWeekByDate(hnpDate);
			// 判断当前日期是否符合按周选择
			boolean bl = isAllowAdd(hnpDate, bean.getWeek(), week);
			// 当前日期为可新增日期
			if (bl) {
				// 第一条可录入日期
				if (state == 0) {
					// 获取初次录入日期的年月信息
					PriceUtil.getFirstDate(hnpDate, map);
				}
				// 有可录入日期
				state = 1;
				bean.setHnpDate(hnpDate); // 日期
				bean.setHdlId(hotelID); // 酒店ID
				bean.setHheId(roomID); // 房型ID
				bean.setHnpWeek(week); // 星期
				bean.setCpyId(cpyId); // 公司ID
				bean.setHnpIsOpen(ErimConstants.YESORNO_YES); // 是否开房
				bean.setHnpCreateUser(CommonUtil.getLoginName()); // 创建用户
				bean.setHnpCreatetime(new Date()); // 创建时间
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
	 * @创建时间: 2015年12月19日 下午2:44:15
	 * @param bean
	 * @return 是否成功
	 */
	public Integer savePrice(HotelPriceBean bean) {
		// 操作状态
		Integer result = CommonUtil.ERROR;
		// 根据房型ID，录入日期判断是否存在该条信息
		HotelPriceBean priceBean = hotelPriceDao.getPriceByRoomDate(bean);
		if (priceBean != null) {
			// 能搜到量价信息，即为修改
			bean.setId(priceBean.getId());
			result = hotelPriceDao.update(bean);
		} else {
			// 无量价信息，新增
			result = hotelPriceDao.insertPrice(bean);
		}
		return result;
	}
	
	/**
	 * @方法名: isAllowAdd
	 * @描述: 判断当前日期是否可以增加，过滤按周选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月6日 下午2:17:52 
	 * @param hnpDate 当前日期
	 * @param hnpWeek 按周选择
	 * @param week 当前日期为周几
	 * @return 当前日期是否符合按周选择
	 */
	public boolean isAllowAdd(String hnpDate, String hnpWeek, String week) {
		
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
	 * @方法名: insertRefresh
	 * @描述: 新增成功后刷新页面 - 对Session无任何改动
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月6日 下午8:53:09 
	 * @param map
	 * @param bean
	 */
	public void insertRefresh(ModelMap map, HotelPriceBean bean) {
		// 房型信息
		HotelRoomBean roomBean = new HotelRoomBean();
		// 酒店基础ID
		Integer hotelID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("hotelID");
		roomBean.setHdlId(hotelID);
		// 房型信息
		List<HotelRoomBean> roomList = hotelRoomDao.selectPageHotelRoomList(roomBean, map);
		map.addAttribute("roomList", roomList);
		
		// 年月
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		
		// 当前年月，放进map
		map.addAttribute("priceYeMon", priceYear + " 年 " + priceMonth + " 月");
	}
	
	/**
	 * @方法名: selectPriceList
	 * @描述: 量价管理数据查询
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月9日 上午9:20:06 
	 * @param map
	 * @param bean
	 */
	public void selectPriceList(ModelMap map, HotelPriceBean bean) {
		
		List<HotelPriceBean> list = new ArrayList<HotelPriceBean>(42);
		List<HotelPriceBean> modelList = new ArrayList<HotelPriceBean>();
		
		/*
		 * 获取当前月份的所有日期
		 */
		String priceYear = (String) SecurityUtils.getSubject().getSession().getAttribute("priceYear");
		String priceMonth = (String) SecurityUtils.getSubject().getSession().getAttribute("priceMonth");
		// 该月所有日期
		String[] monthCount = DateUtil.getMonthCountByYearMonth(priceYear, priceMonth);
		// 该月天数总计
		int monthNum = DateUtil.getMonthCount(priceYear, priceMonth);
		
		/*
		 * 根据酒店基础ID、房型ID、该月所有日期 获取该月所有房量信息
		 */
		Integer hotelID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("hotelID");
		Integer roomID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("roomID");
		bean.setHdlId(hotelID);// 酒店基础ID
		bean.setHheId(roomID);// 房型ID
		// 该月房量信息
		modelList = hotelPriceDao.selectPriceList(bean, monthCount);
		
		// 日历-日号
		int j = 0;
		
		/*
		 * 根据年月，判断该月日历前，共有多少空格
		 */
		int weekCount = DateUtil.getWeekByDate(priceYear, priceMonth);
		for (int i = 0; i < weekCount; i++) {
			// 填入空值
			list.add(i, new HotelPriceBean());
		}
		
		/*
		 * 处理查询的房量信息，填入日历
		 */
		if (modelList.size() != 0) {
			// 处理查询的房量信息
			HotelPriceBean model = new HotelPriceBean();
			for (int i = 0; i < modelList.size(); i++) {
				model = modelList.get(i);
				// 房量信息日期
				String hnpDate = model.getHnpDate();
				// 下标
				int index = j+weekCount;
				// 当前信息日期符合日历日期
				if (monthCount[j].equals(hnpDate)) {
					// 当前日期是否允许修改
					boolean bl = DateUtil.getCheckDateUpdate(hnpDate);
					// 允许修改
					if (bl) {
						model.setIsUpdate(ErimConstants.YESORNO_YES);
					} else {
						model.setIsUpdate(ErimConstants.YESORNO_NO);
					}
					// 日历号
					model.setDay(j+1+"");
					list.add(index, model);
				} else {
					// 不符合
					i--;
					model = new HotelPriceBean();
					// 日历号
					model.setDay(j+1+"");
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
			HotelPriceBean model = new HotelPriceBean();
			// 日历
			if (j < monthNum) {
				model.setDay(j+1+"");
				list.add(index, model);
				j++;
			} else {
				list.add(index, model);
			}
		}
		map.addAttribute("priceList", list);
	}

	/**
	 * @方法名: updateOpen
	 * @描述: 开关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月8日 下午5:47:45 
	 * @param bean
	 * @return
	 */
	public Integer updateOpen(HotelPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		result = hotelPriceDao.updateOpen(bean);
		return result;
	}
	
	/**
	 * @方法名: updatePrice
	 * @描述: 修改房量
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月8日 下午6:38:42 
	 * @param bean
	 * @return
	 */
	public Integer updatePrice(HotelPriceBean bean) {
		Integer result = CommonUtil.ERROR;
		// 出售
		bean.setHnpIsOpen(ErimConstants.YESORNO_YES);
		result = hotelPriceDao.updatePrice(bean);
		return result;
	}
	
	/**
	 * @方法名: updateBatchIsOpen
	 * @描述: 批量关房
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月31日 上午11:21:50 
	 * @param bean
	 * @return
	 */
	public Integer updateBatchIsOpen(HotelPriceBean bean, ModelMap map) {
		Integer result = CommonUtil.ERROR;
		// 开始日期和结束日期
		String start = bean.getEnteringStart();
		String end = bean.getEnteringEnd();
		// 获取初次录入日期的年月信息
		PriceUtil.getFirstDate(start, map);
		// 获取之间所有日期
		String[] strList = DateUtil.getCountByStartEnd(start, end);
		// 房型ID
		Integer roomID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("roomID");
		// 酒店ID
		Integer hotelID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("hotelID");
		bean.setHdlId(hotelID);
		bean.setHheId(roomID);
		bean.setHnpIsOpen(ErimConstants.YESORNO_NO);
		// 执行修改
		result = hotelPriceDao.updateBatchIsOpen(bean, strList);
		return result;
	}
}
