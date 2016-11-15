package com.erim.sz.cafeteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.core.exception.ErimException;
import com.erim.sz.cafeteria.service.CafeteriaCuisineService;
import com.erim.sz.common.bean.CafeteriaCuisineBean;

/**
 * @ClassName: CafeteriaCuisineController
 * @Description: 特色菜控制层
 * @author 贺渊博
 * @date 2015年10月2日 下午3:42:23
 */
@Controller
public class CafeteriaCuisineController {
	
	@Autowired
	private CafeteriaCuisineService cafeteriaCuisineService;

	/**
	 * @Title: showList 
	 * @Description: 特色菜列表页 
	 * @param @param model 
	 * @return String 返回类型 
	 */
	@RequestMapping(value = "/cafeteria/cuisine/list")
	public String cuisinList(ModelMap model, CafeteriaCuisineBean Bean) {
		this.cafeteriaCuisineService.showCuisine(model, Bean);
		return "/cafeteria/cuisine/insert";

	}

	/**
	 * @throws ErimException 
	 * @Title: insert和update
	 * @Description: 特色菜添加和修改 
	 * @param TexiSendBean 
	 */
	@ResponseBody
	@RequestMapping("/cafeteria/cuisine/insert")
	public Integer update(ModelMap model, CafeteriaCuisineBean Bean) {

		return	cafeteriaCuisineService.update(Bean);

	}

	/**
	 * @throws             ErimException 
	 * @Title:             delete 
	 * @Description:       特色菜上下架 
	 * @param @param       1代表上架，0代表下架
	 * @param @return      设定文件 
	 * @return             int 返回类型 
	 */
	@RequestMapping(value = "/cafeteria/cuisine/delcuisine")
	public String delcuisine(CafeteriaCuisineBean bean, ModelMap model) throws ErimException {
		this.cafeteriaCuisineService.deCuisine(bean);
		return this.cuisinList(model, bean);
	}
	
	/**
	 * @方法名：        delete 
	 * @描述:      删除方法
	 * @作者：           贺渊博
	 * @创建时间：    2015年10月18日 上午11:19:55
	 * @param     bean
	 * @param     model
	 */
    @ResponseBody
	@RequestMapping(value = "/cafeteria/cuisine/delete")
	public Integer delete(CafeteriaCuisineBean bean){
		
    	return	cafeteriaCuisineService.delete(bean.getId());
	}

	/**
	 * @Title:         view CafeteriaCuisine
	 * @Description:   特色菜查看
	 * @param @return  设定文件
	 * @return         String 返回类型
	 */
	@RequestMapping(value = "/cafeteria/cuisine/showcuisine")
	public String view(ModelMap model, CafeteriaCuisineBean bean) {
		
		cafeteriaCuisineService.selectCafeteriaCuisineById(model, bean);
		
		cafeteriaCuisineService.showCuisine(model, bean);
		
		return "/cafeteria/cuisine/update";
	}

}
