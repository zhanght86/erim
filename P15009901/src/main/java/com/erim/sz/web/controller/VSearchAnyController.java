package com.erim.sz.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.web.bean.VSearchAnyBean;
import com.erim.sz.web.service.VSearchAnyService;

/**
 * @ClassName: VSearchAnyController 
 * @Description: 视图检索
 * @author maoxian
 * @date 2016年1月3日 下午3:03:34
 */
@Controller
public class VSearchAnyController {
	
	@Autowired
	private VSearchAnyService vSearchAnyService;
	
	/**
	 * @Title: selectListByName 
	 * @Description: 根据名称检索 
	 * @param @param name
	 * @param @return    设定文件 
	 * @return List<VSearchAnyBean>    返回类型 
	 * @author maoxian
	 * @date 2016年1月3日 下午3:04:47 
	 * @throws
	 */
	@RequestMapping(value = "/{cpyno}/vSearchAny/search/selectListByName")
	public @ResponseBody List<VSearchAnyBean> selectListByName(VSearchAnyBean bean){
		return StringUtils.isNotBlank(bean.getvName())?this.vSearchAnyService.selectSearchResult(bean):new ArrayList<VSearchAnyBean>();
	}
}