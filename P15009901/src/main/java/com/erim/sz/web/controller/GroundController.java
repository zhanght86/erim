/**
 * Copyright (c) e-rimming.com
 * 
 * Licensed under the Apache License, Version v1.0 (the "License");
 * 
 * UserController.java : 2013-06-30
 */
package com.erim.sz.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erim.sz.common.bean.GroundDetailBean;
import com.erim.sz.common.bean.GroundPriceBean;
import com.erim.sz.common.bean.GroundTriplBean;
import com.erim.sz.common.bean.VCompanyDetailBean;
import com.erim.sz.common.util.ImageUtil;
import com.erim.sz.web.handler.WordGenerator;
import com.erim.sz.web.service.GroundDetailService;
import com.erim.sz.web.service.GroundPriceService;
import com.erim.sz.web.service.GroundTripService;
import com.erim.sz.web.service.TmSystemRegionService;
import com.erim.sz.web.service.VCompanyDetailService;
import com.erim.sz.web.util.DateUtil;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.utils.properties.PropertiesUtils;
import com.erim.web.service.CodeService;
/**
 * 
 * @类名: GroundController
 * @描述: 当地游
 * @作者: 王赛
 * @创建时间: 2015年11月24日 下午9:05:05
 *
 */
@Controller
public class GroundController {
	
	@Autowired
	private GroundDetailService   groundDetailService;
	@Autowired
	private GroundPriceService    groundPriceService;
	@Autowired
	private GroundTripService     groundTripService;
	@Autowired
	private CodeService		      codeService;
	@Autowired 
	private TmSystemRegionService tmSystemRegionService;
	@Autowired
	private VCompanyDetailService vCompanyDetailService;
	
	/**
	 * @方法名: lvyou
	 * @描述: 当地游列表
	 * @作者: 王赛
	 * @创建时间: 2015年11月24日 下午9:05:30 
	 * @param model
	 * @return
	 *
	 */
	@RequestMapping(value = "/{cpyno}/ground/lvyou")
	public String lvyou(ModelMap model,@ModelAttribute("ground")GroundDetailBean bean,String searchModel) {
		
		if (StringUtils.isEmpty(bean.getGpeDate())) {
			bean.setGpeDate(DateUtil.getCuurentDate());
		}
		groundDetailService.selectGround(model, bean,10);
		/*当地游搜索项*/
		// 产品形态
		model.addAttribute("product",    this.codeService.getSystemCodeByCodeNo(DictionaryUtil.PRODUCT));
		//产品标准
		model.addAttribute("themeone",   this.codeService.getSystemCodeByCodeNo(DictionaryUtil.STANDARDS));
		//产品主题
		model.addAttribute("zhuti",      this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ZHUTI));
		//学生活动
		model.addAttribute("game",       this.codeService.getSystemCodeByCodeNo(DictionaryUtil.GAME));
		// 省份
	    model.addAttribute("provinces",  this.tmSystemRegionService.getSystemCodeListForProvince());
	    
	    model.addAttribute("searchModel", 2);
	    model.put("bean", bean);
		return "/ground/lvyou";
	}
	/**
	 * 
	 * @方法名: lvyouxiang
	 * @描述: 当地游详情
	 * @作者: 王赛
	 * @创建时间: 2015年11月24日 下午10:31:08 
	 * @param model
	 * @param id
	 * @return
	 *
	 */
	@RequestMapping(value = "/{cpyno}/ground/lvyouxiang/{id}")
	public String lvyouxiang(ModelMap model,@PathVariable("id") Integer id,String searchModel) {
		groundDetailService.selectGroundById(id, model);
		this.groundDetailService.selectPriceByGroundId(id,model);
		//行程管理
		List<GroundTriplBean> list = groundTripService.getTripUpdatePage(id, model);
		List<String> imgList = new ArrayList<String>();
		for(GroundTriplBean bean : list){
			imgList.add(bean.getGddImg1());
			imgList.add(bean.getGddImg2());
		}
		model.addAttribute("imgList", imgList);
		model.addAttribute("searchModel",2);
		return "/ground/lvyouxiang";
	}
	
	/**
	 * @描述: 当地游量价项
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月28日 下午1:56:55
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/{cpyno}/ground/price")
	public String priceList(ModelMap map, GroundPriceBean bean) {
		groundPriceService.getGroundPriceList(map, bean);
		return "/ground/price";
	}
	
	/**
	 * @描述: 量价项时间选择
	 * @作者: 宁晓强
	 * @创建时间: 2015年11月28日 下午1:58:16
	 * @param map
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/{cpyno}/ground/price/date")
	public String priceDate(ModelMap map, GroundPriceBean bean) {
		String portal = bean.getPortal();
		
		if ("01".equals(portal)) {
			// 量价项时间向前选择
			groundPriceService.forward(map, bean);
		} else if ("02".equals(portal)) {
			// 时间向后选择
			groundPriceService.backwards(map, bean);
		}
		
		return "/ground/price";
	}

	/**
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 * @Title: exportWord 
	 * @Description: 当地游导出行程
	 * @param @param map
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @author maoxian
	 * @date 2015年12月25日 下午3:07:06 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/ground/detail/exportWord")
	public String exportWord(ModelMap map, GroundDetailBean bean,HttpServletResponse resp,@PathVariable("cpyno") String cpyno) throws Exception{
		
		if(StringUtils.isNotBlank(cpyno)){

			GroundDetailBean gdb  = this.groundDetailService.selectById(bean.getId(), map);
			VCompanyDetailBean vc = this.vCompanyDetailService.selectCompanyByCode(cpyno);
			if(StringUtils.isNotBlank(vc.getCpyImg())){
				//图片转义 转为可用于word存储的结构
				String cpyImg = PropertiesUtils.getPropertyByKey("app.staticFileRes") + vc.getCpyImg();
				String savePath = ImageUtil.download(cpyImg, UUID.randomUUID().toString().replace("-", "") + ".jpg",
						getClass().getResource("/").getFile().toString());
				if (StringUtils.isNotBlank(savePath)) {
					vc.setCpyImg(ImageUtil.getImgStr(savePath));
					ImageUtil.deleteFile(savePath);
				}
			}

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("gdb", gdb);
			//放置企业信息
			paramMap.put("vc", vc);

			// 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整
			// 否则Freemarker的模板殷勤在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了
			File file = null;
			InputStream fin = null;
			ServletOutputStream out = null;
			try {
				// 调用工具类WordGenerator的createDoc方法生成Word文档
				file = WordGenerator.createDoc(paramMap, "resume");
				fin = new FileInputStream(file);

				resp.setCharacterEncoding("utf-8");
				resp.setContentType("application/msword");
				// 设置浏览器以下载的方式处理该文件默认名为resume.doc
				resp.addHeader("Content-Disposition", "attachment;filename=resume.doc");

				out = resp.getOutputStream();
				byte[] buffer = new byte[512]; // 缓冲区
				int bytesToRead = -1;
				// 通过循环将读入的Word文件的内容输出到浏览器中
				while ((bytesToRead = fin.read(buffer)) != -1) {
					out.write(buffer, 0, bytesToRead);
				}
			} finally {
				if (fin != null)
					fin.close();
				if (out != null)
					out.close();
				if (file != null)
					file.delete(); // 删除临时文件
			}
		}
		return null;
	}
	
	 
}