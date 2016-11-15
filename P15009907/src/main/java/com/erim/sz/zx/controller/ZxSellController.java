package com.erim.sz.zx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erim.sz.common.bean.ZxSellCooperationBean;
import com.erim.sz.zx.service.ZxSellCooperationService;

/**
 * @ClassName: ZxSellController 
 * @Description: 专线组团合作
 * @author maoxian
 * @date 2015年12月8日 下午4:40:09
 */
@Controller
public class ZxSellController {

	@Autowired
	private ZxSellCooperationService zxSellCooperationService;
	
	/**
	 * @Title: insert 
	 * @Description: 合作管理插入
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月8日 下午4:42:55 
	 * @throws
	 */
	@RequestMapping(value = "/zxsell/detail/insert")
	public @ResponseBody Integer insert(ZxSellCooperationBean zxSellCooperationBean){
		return this.zxSellCooperationService.insert(zxSellCooperationBean);
	}
	
	/**
	 * @Title: delete 
	 * @Description: 合作管理删除
	 * @param @param zxSellCooperationBean
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月8日 下午4:52:04 
	 * @throws
	 */
	@RequestMapping(value = "/zxsell/detail/delete")
	public @ResponseBody Integer delete(ZxSellCooperationBean zxSellCooperationBean){
		return this.zxSellCooperationService.delete(zxSellCooperationBean);
	}
	
	/**
	 * @Title: insertList 
	 * @Description: 插入合作管理
	 * @param @param list
	 * @param @return    设定文件 
	 * @return Integer    返回类型 
	 * @author maoxian
	 * @date 2015年12月8日 下午4:53:13 
	 * @throws
	 */
	@RequestMapping(value = "/zxsell/detail/insertList")
	public @ResponseBody Integer insertList(ZxSellCooperationBean zxSellCooperationBean){
		return this.zxSellCooperationService.insertList(zxSellCooperationBean);
	}
}