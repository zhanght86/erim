package com.erim.sz.sameTown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.CompanyDetailBean;
import com.erim.sz.company.service.CompanyDetailService;
import com.erim.sz.sameTown.service.PubSametownService;

/**
 * @ClassName: PubSametownController 
 * @Description: 同城同业共享设置
 * @author maoxian
 * @date 2015年9月18日 下午2:12:22 
 */
@Controller
public class PubSametownController {

	@Autowired
	private CompanyDetailService companyDetailService;
	@Autowired
	private PubSametownService   pubSametownService;
	
	/**
	 * @Title: setsametown 
	 * @Description: 同城同业设置
	 * @param @param ntype
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/town/detail/setsametown")
	public String setsametown(@ModelAttribute("ntype") String ntype,@ModelAttribute("cid")Integer cid,@ModelAttribute("companyDetail") CompanyDetailBean bean, ModelMap model) {
		
		companyDetailService.selectPageCafeteria(bean, model, ntype, cid);
		
		//查询多少此条纪录 选择同业个数
		pubSametownService.selectList(cid, ntype, model);
		
		return "/town/detail/setsametown";
	}
	
	/**
	 * @Title: deleteAll 
	 * @Description: 删除属性为ntype的所有数据
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/town/detail/deleteAll")
	public @ResponseBody Integer deleteAll(String ntype,Integer cid){
		return this.pubSametownService.deleteAll(ntype,cid);
	}
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入同城同业
	 * @param @param ids
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/town/detail/insert")
	public @ResponseBody Integer insert(String ntype, Integer cid){
		this.pubSametownService.deleteAll(ntype,cid);
		return 0==this.companyDetailService.insertAll(ntype, cid)?0:1;
	}
	
	/**
	 * @Title: delete 
	 * @Description: 删除同城同业
	 * @param @param ids
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @throws
	 */
	@RequestMapping(value = "/town/detail/update")
	public @ResponseBody Integer update(String type,String cpyid,String ntype,Integer cid){
		return this.pubSametownService.update(type,cpyid,ntype,cid);
	}
}
