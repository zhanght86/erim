package com.erim.sz.cafeteria.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.cafeteria.dao.CafeteriaPackageDao;
import com.erim.sz.cafeteria.dao.CafeteriaPackageDishesDao;
import com.erim.sz.cafeteria.dao.CafeteriaPackageDishesFoodDao;
import com.erim.sz.common.bean.CafeteriaPackageBean;
import com.erim.sz.common.bean.CafeteriaPackageDishesBean;
import com.erim.sz.common.bean.CafeteriaPackageDishesFoodBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: CafeteriaPackageService
 * @Description: 套餐接口
 * @author 贺渊博
 * @date 2015年10月2日 下午2:04:19
 */
@Service("cafeteriaPackageService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CafeteriaPackageService {

	@Autowired
	private CafeteriaPackageDao 			  cafeteriaPackageDao;
	@Autowired
	private CafeteriaPackageDishesService     cafeteriaPackageDishesService;
	@Autowired
	private CafeteriaPackageDishesFoodService cafeteriaPackageDishesFoodService;
	@Autowired
	private CafeteriaPackageDishesDao         cafeteriaPackageDishesDao;
	@Autowired
	private CafeteriaPackageDishesFoodDao     cafeteriaPackageDishesFoodDao;

	/**
	 * @方法名: showCafeteriaPackage
	 * @描述: 套餐分页查询
	 * @创建时间: 2015年10月20日 上午10:29:37
	 * @param model
	 * @param bean
	 */
	public void showCafeteriaPackage(ModelMap model, CafeteriaPackageBean bean) {

		// 特色餐ID
		Integer cdlID = bean.getCdlID();
		if (cdlID != null) {
			// 存入Session,key 为系统中一级页面数据ID 通用名称 oneId
			SecurityUtils.getSubject().getSession().setAttribute("oneId", cdlID);
		} else {
			cdlID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
			bean.setCdlID(cdlID);
		}

		bean.getPageLinkBean().setLimit(10);
		// 分页查询
		List<CafeteriaPackageBean> cafeteriaList = cafeteriaPackageDao.selectPageCafeteria(bean, model);
		// 回传信息
		model.put("cafeteriaList", cafeteriaList);
	}

	/**
	 * @Title: selectCafeteriaPackage
	 * @Description: 根据主键查询指定的实体
	 * @param @param
	 *            id
	 * @param @return
	 *            设定文件
	 * @return CafeteriaPackageBean 返回实体对象
	 */
	public CafeteriaPackageBean selectCafeteriaPackage(int id) {
		return cafeteriaPackageDao.selectCafeteriaPackage(id);
	}

	/**
	 * @描述: 新增套餐
	 * @作者: 宁晓强
	 * @创建时间: 2015年12月13日 下午5:08:25
	 * @param model
	 * @param bean
	 * @param request
	 * @return
	 */
	public Integer insert(ModelMap model, CafeteriaPackageBean bean, HttpServletRequest request) {

		try {
			// 获取餐厅ID
			Integer cdlID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
			// 添加餐厅id
			bean.setCdlID(cdlID);
			// 上线状态
			bean.setCpeIsDelStatus("1");
			// 添加时自动添加创建时间
			bean.setCpeCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

			// 插入数据
			Integer result = cafeteriaPackageDao.insertCafeteria(bean);

			// 菜品
			String[] acpdAvenue = request.getParameterValues("cpdAvenue"); // 可选几道
			String[] acpdPrice = request.getParameterValues("cpdPrice"); // 单价
			String[] anumber = request.getParameterValues("number"); // 几道菜

			// 菜
			String[] acpfName = request.getParameterValues("cpfName");
			String[] acpfNumber = request.getParameterValues("cpfNumber");
			String[] acpfNtype = request.getParameterValues("cpfNtype");
			// 其他菜的价格
			String[] acpfPrice = request.getParameterValues("cpfPrice");
			String[] acpfImg1 = request.getParameterValues("cpfImg1");

			if (null != acpdAvenue && acpdAvenue.length > 0) {
				int k = 0;
				for (int i = 0; i < acpdAvenue.length; i++) {
					/*
					 * 菜品
					 */
					CafeteriaPackageDishesBean dischesBean = new CafeteriaPackageDishesBean();
					// 套餐ID
					dischesBean.setCpeId(bean.getId());
					// 可选道数
					dischesBean
							.setCpdAvenue(StringUtils.isNotBlank(acpdAvenue[i]) ? Integer.parseInt(acpdAvenue[i]) : 0);
					// 单价
					dischesBean.setCpdPrice(StringUtils.isNotBlank(acpdPrice[i]) ? Integer.parseInt(acpdPrice[i]) : 0);
					// 创建时间
					dischesBean.setCpdCreatetime(new Date());
					// 执行插入菜品
					this.cafeteriaPackageDishesService.insert(dischesBean);

					/*
					 * 添加菜品中菜
					 */
					List<CafeteriaPackageDishesFoodBean> listDisFood = new ArrayList<CafeteriaPackageDishesFoodBean>();
					// 菜品ID
					Integer cpdId = dischesBean.getId();
					// 菜品中菜的数量
					int int_number = Integer.parseInt(anumber[i]);
					// 声明菜的数量
					int intlengt = k + int_number;
					// 循环菜品
					for (int j = k; j < intlengt; j++) {
						/*
						 * 菜品中的菜
						 */
						CafeteriaPackageDishesFoodBean foodBean = new CafeteriaPackageDishesFoodBean();
						// 套餐ID
						foodBean.setCpeId(bean.getId());
						// 菜品ID
						foodBean.setCpdId(cpdId);
						// 菜品类型
						foodBean.setCpfNtype(acpfNtype[j]);
						// 菜名
						foodBean.setCpfName(acpfName[j]);
						//插入图片
						foodBean.setCpfImg1(acpfImg1[j]);
						// 数量规格
						// String numberStr = acpfNumber[j];
						// if (numberStr != null && !"".equals(numberStr)) {
						foodBean.setCpfNumber(acpfNumber[j]);
						// }
						// 单价
						String priceStr = acpdPrice[i];
						if (priceStr != null && !"".equals(priceStr)) {
							foodBean.setCpfPrice(Integer.parseInt(priceStr));
						}
						// 创建时间
						foodBean.setCpfCreatetime(new Date());
						listDisFood.add(foodBean);
					}
					k = intlengt;
					// 执行插入菜品中的菜
					this.cafeteriaPackageDishesFoodService.insert(listDisFood);
				}
				/*
				 * 菜品中的其他菜
				 */
				List<CafeteriaPackageDishesFoodBean> listDisFood = new ArrayList<CafeteriaPackageDishesFoodBean>();
				// 填入其它菜
				int inx_price = 0;
				for (int l = k; l < acpfName.length; l++) {
					/*
					 * 菜品中的一条其他菜
					 */
					CafeteriaPackageDishesFoodBean foodBean = new CafeteriaPackageDishesFoodBean();
					// 创建时间
					foodBean.setCpfCreatetime(new Date());
					// 菜品名称
					foodBean.setCpfName(acpfName[l]);
					// 数量规格
					// String numberStr = acpfNumber[l];
					// if (numberStr != null && !"".equals(numberStr)) {
					// foodBean.setCpfNumber(Integer.parseInt(numberStr));
					// }
					foodBean.setCpfNumber(acpfNumber[l]);
					// 单价
					String priceStr = acpfPrice[inx_price];
					if (priceStr != null && !"".equals(priceStr)) {
						foodBean.setCpfPrice(Integer.parseInt(priceStr));
					}
					// 套餐ID
					foodBean.setCpeId(bean.getId());
					// 菜品ID为0，因为没有菜品
					foodBean.setCpdId(0);
					// 菜品类型
					foodBean.setCpfNtype(acpfNtype[l]);
					// 图片
					foodBean.setCpfImg1("");
					listDisFood.add(foodBean);
					inx_price++;
				}
				// 执行插入其他菜
				this.cafeteriaPackageDishesFoodService.insert(listDisFood);
			}
			return result;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}

	/**
	 * @描述: 修改套餐方法
	 * @作者: 
	 * @创建时间: 2015年12月3日 下午2:52:43
	 * @param model
	 * @param bean
	 * @param request
	 * @return
	 */
	public Integer update(ModelMap model, CafeteriaPackageBean bean, HttpServletRequest request) {
		
		try {
			//修改套餐基本信息
			cafeteriaPackageDao.updateCafeteriaPackage(bean);
			
			//修改菜品基本信息
			// 菜品
			String[] acpdId		= request.getParameterValues("cpdId");     // 菜品id
			String[] acpdAvenue = request.getParameterValues("cpdAvenue"); // 可选几道
			String[] acpdPrice  = request.getParameterValues("cpdPrice");  // 单价
			String[] anumber    = request.getParameterValues("number");    // 几道菜

			// 菜
			String[] acpfId     = request.getParameterValues("cpfId");     // 菜id
			String[] acpfName   = request.getParameterValues("cpfName");   
			String[] acpfNumber = request.getParameterValues("cpfNumber");
			String[] acpfNtype  = request.getParameterValues("cpfNtype");
			// 其他菜的价格
			String[] acpfPrice  = request.getParameterValues("cpfPrice");
			String[] acpfImg1   = request.getParameterValues("cpfImg1");

			// 可选几道不为null
			if (null != acpdAvenue && acpdAvenue.length > 0) {
				int k = 0;
				for (int i = 0; i < acpdAvenue.length; i++) {
					/*
					 * 菜品
					 */
					CafeteriaPackageDishesBean dischesBean = new CafeteriaPackageDishesBean();
					// 套餐ID
					dischesBean.setCpeId(bean.getId());
					// 可选道数
					dischesBean.setCpdAvenue(StringUtils.isNotBlank(acpdAvenue[i]) ? Integer.parseInt(acpdAvenue[i]) : 0);
					// 单价
					dischesBean.setCpdPrice(StringUtils.isNotBlank(acpdPrice[i]) ? Integer.parseInt(acpdPrice[i]) : 0);
					// 创建时间
					dischesBean.setCpdCreatetime(new Date());
					
					// 当菜品ID不为null
					if(StringUtils.isNotBlank(acpdId[i])){
						dischesBean.setId(Integer.parseInt(acpdId[i]));
						this.cafeteriaPackageDishesService.update(dischesBean);
					} else {
						// 执行插入菜品
						this.cafeteriaPackageDishesService.insert(dischesBean);
					}

					/*
					 * 添加菜品中菜
					 */
					List<CafeteriaPackageDishesFoodBean> listDisFood = new ArrayList<CafeteriaPackageDishesFoodBean>();
					// 菜品ID
					Integer cpdId = dischesBean.getId();
					// 菜品中菜的数量
					int int_number = Integer.parseInt(anumber[i]);
					// 声明菜的数量
					int intlengt = k + int_number;
					// 循环菜品
					for (int j = k; j < intlengt; j++) {
						/*
						 * 菜品中的菜
						 */
						CafeteriaPackageDishesFoodBean foodBean = new CafeteriaPackageDishesFoodBean();
						// 套餐ID
						foodBean.setCpeId(bean.getId());
						// 菜品ID
						foodBean.setCpdId(cpdId);
						// 菜品类型
						foodBean.setCpfNtype(acpfNtype[j]);
						// 菜名
						foodBean.setCpfName(acpfName[j]);
						//插入图片
						foodBean.setCpfImg1(acpfImg1[j]);
						// 数量规格
						// String numberStr = acpfNumber[j];
						// if (numberStr != null && !"".equals(numberStr)) {
						foodBean.setCpfNumber(acpfNumber[j]);
						// }
						// 单价
						String priceStr = acpdPrice[i];
						if (priceStr != null && !"".equals(priceStr)) {
							foodBean.setCpfPrice(Integer.parseInt(priceStr));
						}
						if(StringUtils.isNotBlank(acpfId[j])){
							foodBean.setId(Integer.parseInt(acpfId[j]));
							cafeteriaPackageDishesFoodDao.update(foodBean);
						}else{
							// 创建时间
							foodBean.setCpfCreatetime(new Date());
							listDisFood.add(foodBean);
						}
					}
					k = intlengt;
					// 执行插入菜品中的菜
					if(null != listDisFood && listDisFood.size()>0){
						this.cafeteriaPackageDishesFoodService.insert(listDisFood);
					}
				}
				/*
				 * 菜品中的其他菜
				 */
				List<CafeteriaPackageDishesFoodBean> listDisFood = new ArrayList<CafeteriaPackageDishesFoodBean>();
				// 填入其它菜
				int inx_price = 0;
				for (int l = k; l < acpfName.length; l++) {
					/*
					 * 菜品中的一条其他菜
					 */
					CafeteriaPackageDishesFoodBean foodBean = new CafeteriaPackageDishesFoodBean();
					// 创建时间
					foodBean.setCpfCreatetime(new Date());
					// 菜品名称
					foodBean.setCpfName(acpfName[l]);
					// 数量规格
					// String numberStr = acpfNumber[l];
					// if (numberStr != null && !"".equals(numberStr)) {
					// foodBean.setCpfNumber(Integer.parseInt(numberStr));
					// }
					foodBean.setCpfNumber(acpfNumber[l]);
					// 单价
					String priceStr = acpfPrice[inx_price];
					if (priceStr != null && !"".equals(priceStr)) {
						foodBean.setCpfPrice(Integer.parseInt(priceStr));
					}
					// 套餐ID
					foodBean.setCpeId(bean.getId());
					// 菜品ID为0，因为没有菜品
					foodBean.setCpdId(0);
					// 菜品类型
					foodBean.setCpfNtype(acpfNtype[l]);
					// 图片
					foodBean.setCpfImg1("");
					if(StringUtils.isNotBlank(acpfId[l])) {
						foodBean.setId(Integer.parseInt(acpfId[l]));
						this.cafeteriaPackageDishesFoodDao.update(foodBean);
					} else {
						listDisFood.add(foodBean);
					}
					inx_price++;
				}
				// 执行插入其他菜
				if(null != listDisFood && listDisFood.size() > 0) {
					this.cafeteriaPackageDishesFoodService.insert(listDisFood);
				}
			}
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}

	/**
	 * @Title: 根据套餐ID查询一条套餐信息，返回修改页面
	 * @param model
	 * @param id
	 * @return void 返回类型
	 */
	public void selectCafeteriaPackageById(ModelMap map, Integer id) {

		// 根据套餐ID查询一条套餐信息
		CafeteriaPackageBean packageBean = cafeteriaPackageDao.selectCafeteriaPackage(id);
		// 根据套餐ID查询菜品列表
		List<CafeteriaPackageDishesBean> dishesList = cafeteriaPackageDishesDao.selectListByCpeId(id);
		// 遍历列表获取菜
		for (int i = 0; i < dishesList.size(); i++) {
			CafeteriaPackageDishesBean model = dishesList.get(i);
			// 菜品ID
			Integer dishesId = model.getId();
			// 根据菜品ID查询菜列表
			List<CafeteriaPackageDishesFoodBean> foodList = cafeteriaPackageDishesFoodDao.selectFoodByCpdId(dishesId);
			// 菜列表 添加到菜品
			model.setFoodList(foodList);
		}
		// 根据套餐ID,菜品类型="其它",菜品ID=0,获取其它菜品列表
		CafeteriaPackageDishesFoodBean foodBean = new CafeteriaPackageDishesFoodBean();
		foodBean.setCpfNtype("其它");// 菜品类型
		foodBean.setCpdId(0);// 菜品ID
		foodBean.setCpeId(id); // 套餐ID
		List<CafeteriaPackageDishesFoodBean> qitaList = cafeteriaPackageDishesFoodDao.selectFoodByFood(foodBean);

		// 其它菜品、
		map.addAttribute("qitaList", qitaList);
		// 菜品信息
		map.addAttribute("dishesList", dishesList);
		// 套餐信息
		map.addAttribute("cafeteriaPackage", packageBean);
	}

	/**
	 * @Title: CafeteriaPackage
	 * @Description: 套餐上线状态
	 * @param id
	 *            设定文件
	 * @return void 返回类型
	 */
	public int delete(CafeteriaPackageBean bean) {
		try {
			cafeteriaPackageDao.deleteCafeteria(bean);
			return CommonUtil.SUCCESS;
		} catch (Exception e) {
			return CommonUtil.error(getClass(), e);
		}
	}
}
