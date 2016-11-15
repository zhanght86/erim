package com.erim.sz.cafeteria.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.cafeteria.dao.CafeteriaCuisineDao;
import com.erim.sz.common.bean.CafeteriaCuisineBean;
import com.erim.sz.web.util.CommonUtil;

/**
 * @ClassName: CafeteriaCuisineService 
 * @Description: 特色菜接口
 * @author 贺渊博 
 * @date 2015年10月2日 下午3:31:09 
 */
@Service("cafeteriaCuisineService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CafeteriaCuisineService {
	
	@Autowired
	private CafeteriaCuisineDao  cafeteriaCuisineDao;
	
	/**
	 * @Title: 		 showCuisine 
	 * @Description: 特色菜列表
	 * @param @param model
	 * @param @param bean 设定文件 
	 * @return 		 void 返回类型 
	 * @throws
	 */
	public void showCuisine(ModelMap model,CafeteriaCuisineBean bean){
		
		Integer cdlID = bean.getCdlID();
		if (cdlID != null) {
			SecurityUtils.getSubject().getSession().setAttribute("oneId", cdlID);
		}else {
			cdlID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
			bean.setCdlID(cdlID);
		}
		
//		bean.getPageLinkBean().setLimit(10);
		//分页查询
		List<CafeteriaCuisineBean> cuisineList = cafeteriaCuisineDao.selectCuisine(bean, model);
		// 回传信息
		model.put("cuisineList", cuisineList);
	}
	
	/**
	 * @Title: 		 insert
	 * @Description: 添加特色菜
	 * @param @param id 设定文件
	 * @return 		 void 返回类型
	 * @throws
	 */
	public Integer update(CafeteriaCuisineBean bean){
		
		Integer result = CommonUtil.ERROR;
		
		Integer CuisineId = bean.getId();
		
		if(CuisineId == null || "".equals(CuisineId)){
			
			// 获取餐厅ID
			Integer cdlID = (Integer) SecurityUtils.getSubject().getSession().getAttribute("oneId");
			//添加餐厅id
			bean.setCdlID(cdlID);
			bean.setCslIsDelStatus("1");
			bean.setCslCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			result = cafeteriaCuisineDao.insert(bean);
			 
		}else{
			result = cafeteriaCuisineDao.update(bean);
		}
		return result;
	}
	
	/**
	 * @Title:          selectCafeteriaCuisineById 
	 * @Description:    根据套餐信息查询特色菜
	 * @param           id
	 * @return         CafeteriaCuisineBean    返回类型 
	 */
	public void selectCafeteriaCuisineById(ModelMap model,CafeteriaCuisineBean bean ){
		 
		 CafeteriaCuisineBean detail = cafeteriaCuisineDao.selectCafeteriaCuisineById(bean);
		 
		 model.addAttribute("cafeteriaCuisine",detail);
		 
	}
	
	/**
	 * @Title: 		 delete
	 * @Description: 特色餐上下架
	 * @param @param id 设定文件
	 * @return 		 int 返回类型
	 * @throws
	 */
	public int deCuisine(CafeteriaCuisineBean cafeteriaCuisineBean){
		try{
			cafeteriaCuisineDao.delCuisine(cafeteriaCuisineBean);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(),e);
		}
	}
	
	/**
	 * @方法名：      delete 
	 * @描述:     特色菜删除
	 * @作者：         贺渊博
	 * @创建时间：  2015年10月18日 上午11:16:10
	 * @param    id
	 * @return   int返回类型
	 *
	 */
	public int delete(Integer id){
		try{
			cafeteriaCuisineDao.delete(id);
			return CommonUtil.SUCCESS;
		}catch(Exception e){
			return CommonUtil.error(getClass(), e);
		}
	}
}
