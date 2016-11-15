package com.erim.sz.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.erim.sz.common.bean.GuidePriceBean;
import com.erim.sz.common.bean.ManagementDetailBean;
import com.erim.sz.common.bean.ManagementPriceBean;
import com.erim.sz.search.dao.ManagementDetailDao;
import com.erim.sz.search.dao.ManagementPriceDao;
import com.erim.sz.web.util.DictionaryUtil;
import com.erim.web.service.CodeService;

/***
 * 
 * @ClassName: ManagementDetailService
 * @Description: 签证接口
 * @author 龙龙
 * @date 2015年7月29日 下午4:58:49
 *
 */
@Service("managementService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ManagementDetailService {

	@Autowired
	private ManagementDetailDao managementDao;
	@Autowired
	private CodeService 		codeService;
	@Autowired
	private ManagementPriceDao  managementPriceDao;

	public void showManagement(ModelMap model,ManagementDetailBean bean) {

		// 分页查询
		List<ManagementDetailBean> managementList = managementDao.selectPageManagement(bean, model);
		// 回传信息
		model.put("managementList", managementList);
	}
	/**
	 * @Title: setCode 
	 * @Description: 放置字典 
	 * @param @param model    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void setCode(ModelMap model){
		//面签需要
		model.addAttribute("face",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.INTERVIEW));
		//签证类型
		model.addAttribute("models",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.NTYPE)); 
		//入境次数
		model.addAttribute("entry",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.ENTRYNUM));
		//送签地
		model.addAttribute("send",this.codeService.getSystemCodeByCodeNo(DictionaryUtil.SEND));
	}
	
	
	/**
	 * @Title: selectPriceList 
	 * @Description: 签证查询
	 * @param @param bean
	 * @param @return    设定文件 
	 * @return List<ManagementPriceBean>    返回类型 
	 * @author maoxian
	 * @date 2015年12月24日 下午9:49:36 
	 * @throws
	 */
	public List<ManagementPriceBean> selectPriceList(ManagementPriceBean bean){
		return this.managementPriceDao.selectPriceList(bean);
	}
}