package com.erim.sz.cafeteria.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.cafeteria.service.CafeteriaPackageDishesFoodService;
import com.erim.sz.cafeteria.service.CafeteriaPackageDishesService;
import com.erim.sz.cafeteria.service.CafeteriaPackageService;
import com.erim.sz.common.bean.CafeteriaPackageBean;
	
/**
 * @ClassName:   CafeteriaPackageController 
 * @Description: 套餐详情控制 
 * @author       贺渊博 
 * @date         2015年10月2日 下午2:21:15 
 */
@Controller
public class CafeteriaPackageController {
	
	@Autowired
	private CafeteriaPackageService           cafeteriaPackageService;
	@Autowired
	private CafeteriaPackageDishesService     cafeteriaPackageDishesService;
	@Autowired
	private CafeteriaPackageDishesFoodService cafeteriaPackageDishesFoodService;

	/**
	 * @描述: 特色餐套餐列表页
	 * @作者: 贺渊博
	 * @创建时间: 2016年1月5日 下午5:57:43
	 * @param model
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/cafeteria/package/list")
	public String showList(ModelMap model, @ModelAttribute("cafeteriaPackage")CafeteriaPackageBean bean) {
		
		cafeteriaPackageService.showCafeteriaPackage(model, bean);
		
		return "/cafeteria/package/list";
	}
	
	/**
     * @Title:        CafeteriaPackage 
     * @Description:  新增页面
     * @param @throws ErimException    设定文件 
     * @return        String    返回类型 
     */
    @RequestMapping(value = "/cafeteria/package/insertPage")
    public String insertPage(ModelMap model) {
    	return "/cafeteria/package/insert";
    }
    
    /**
     * @描述: 新增方法
     * @作者: 
     * @创建时间: 2015年12月3日 下午3:00:56
     * @param model
     * @param cafeteriaPackageBean
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cafeteria/package/insert")
	public Integer insert(ModelMap model, CafeteriaPackageBean cafeteriaPackageBean, HttpServletRequest request) {
		return cafeteriaPackageService.insert(model, cafeteriaPackageBean, request);
	}
    
    /**
     * @Title:        updatePage 
     * @Description:   跳转修改页面
     * @param          model
     * @return         String    返回类型 
     */
    @RequestMapping(value="/cafeteria/package/updatePage")
    public String updatePage(ModelMap model,Integer id) throws ErimException{
    	//根据ID查询实体
    	this.cafeteriaPackageService.selectCafeteriaPackageById(model, id);
    	return "/cafeteria/package/update";
    }
    
    /**
     * @描述: 修改套餐
     * @作者: 
     * @创建时间: 2015年12月3日 下午2:52:09
     * @param model
     * @param cafeteriaPackageBean
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/cafeteria/package/update")
    public Integer update(ModelMap model, CafeteriaPackageBean cafeteriaPackageBean, HttpServletRequest request) {
    	
    	return cafeteriaPackageService.update(model, cafeteriaPackageBean, request);
    }
    
    /**
     * @描述: 上下架
     * @作者: 
     * @创建时间: 2015年12月3日 下午3:15:39
     * @param bean
     * @param model
     * @return
     * @throws ErimException
     */
    @RequestMapping(value = "/cafeteria/package/delete")
	public String delete(CafeteriaPackageBean bean,ModelMap model) throws ErimException{
    	cafeteriaPackageService.delete(bean);
    	return showList(model, bean);

    }
    
    /**
     * @描述: view 查看餐厅信息
     * @作者: 
     * @创建时间: 2015年12月3日 下午3:15:50
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/cafeteria/package/view")
    public String view(ModelMap model,@RequestParam(value = "id") Integer id){
    	cafeteriaPackageService.selectCafeteriaPackageById(model, id);
    	return "/cafeteria/package/view";
    }
    
    /**
     * @Title: deleteDishes 
     * @Description: 删除菜品
     * @param @param id
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @author maoxian
     * @date 2015年11月22日 下午5:42:12 
     * @throws
     */
    @RequestMapping(value = "/cafeteria/package/deleteDishes")
    public @ResponseBody Integer deleteDishes(Integer id){
    	return this.cafeteriaPackageDishesService.delete(id);
    }
    
    /**
     * @Title: deleteDishesFood 
     * @Description: 删除菜
     * @param @param id
     * @param @return    设定文件 
     * @return Integer    返回类型 
     * @author maoxian
     * @date 2015年11月22日 下午5:52:31 
     * @throws
     */
    @RequestMapping(value = "/cafeteria/package/deleteDishesFood")
    public @ResponseBody Integer deleteDishesFood(Integer id){
    	return this.cafeteriaPackageDishesFoodService.delete(id);
    }
}
