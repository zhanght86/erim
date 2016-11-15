package com.erim.sz.texi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.TexiCarBean;
import com.erim.sz.texi.service.TexiCarService;

/***
 * @ClassName: TexiCarController
 * @Description: 包车
 * @author 贺渊博
 * @date 2015年10月1日 下午7:05:14
 */
@Controller
public class TexiCarController {
	
	@Autowired
	private TexiCarService texiCarService;

	/**
	 * @Title: showCar
	 * @Description: 包车信息
	 * @param model
	 * @param tdlId
	 * @return String 返回类型
	 */
	@RequestMapping(value = "/texi/car/showcar")
	public String showCar(ModelMap model, TexiCarBean texiDrive) {
		texiCarService.getTexiCarById(texiDrive, model);
		return "/texi/car/update";
	}

	/**
	 * @方法名: update
	 * @描述: 修改或者新增包车信息
	 * @作者: 宁晓强
	 * @创建时间: 2015年10月12日 下午2:20:51 
	 * @param model
	 * @param texiCarBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/texi/car/update")
	public Integer update(ModelMap map, TexiCarBean texiCarBean) {
		
		return texiCarService.update(texiCarBean);
	}
}
