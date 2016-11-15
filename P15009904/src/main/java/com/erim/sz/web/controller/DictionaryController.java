/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * IndexController.java : 2013-06-30
 */
package com.erim.sz.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.bean.CodeBean;
import com.erim.web.service.CodeService;

/**
 * @ClassName: DictionaryController 
 * @Description: 自动补全字典
 * @author maoxian
 * @date 2015年11月8日 下午6:04:53
 */
@Controller
public class DictionaryController {

	@Autowired
	private CodeService codeService;
	
	
	/**
	 * @throws UnsupportedEncodingException 
	 * @Title: getDictionaryByCountry 
	 * @Description: 查询所有国家 自动补全
	 * @param @return    设定文件 
	 * @return List<CodeBean>    返回类型 
	 * @throws
	 */
	@RequestMapping("/dictionary/list/contry")
	public @ResponseBody List<CodeBean> getDictionaryByCountry(HttpServletRequest requset) throws UnsupportedEncodingException{
		
		String countryName = requset.getParameter("q");
//		if(StringUtils.isNotBlank(countryName)){
//			countryName= new String(countryName.getBytes("ISO-8859-1"), "UTF-8"); 
//		}
		//返回
		List<CodeBean> returnCode = new ArrayList<CodeBean>();
		List<CodeBean> resulut    = codeService.getSystemCodeListByCodeNo(DictionaryUtil.COUNTRY);
		if(StringUtils.isNotBlank(countryName)){
			for(CodeBean code : resulut){
				if(code.getCodeValue().contains(countryName)){
					returnCode.add(code);
				}
			}
		}else{
			returnCode = resulut;
		}
		return returnCode;
	}
	
	/**
	 * @描述: 根据value获取一条国家数据
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月14日 下午11:19:14
	 * @param codeValue
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dictionary/one/value")
	public String getDictionaryByValue(String codeValue) {
		
		String state = "";
		List<CodeBean> resulut = codeService.getSystemCodeListByCodeNo(DictionaryUtil.COUNTRY);
		if (StringUtils.isNotBlank(codeValue)) {
			for(CodeBean model : resulut){
				if(model.getCodeValue().contains(codeValue)){
					state = model.getCodeMark();
				}
			}
		}
		return state;
	}
}